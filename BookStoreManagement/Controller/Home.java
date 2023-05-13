package Controller;

import View.AccountInfo;
import View.CreateAccount;
import View.Order;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

public class Home implements ActionListener, MouseListener {

    private View.Home view;
    private DatabaseConnector db;

    public Home(View.Home view) {
        this.view = view;
        db = this.view.getDb();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("info")) {
            System.out.println("cick on info");
            new AccountInfo(this.db, view);
        } else if (e.getActionCommand().equals("order")) {
            System.out.println("click on order");
            new Order(view);
        } else if (e.getActionCommand().equals("search")) {
            System.out.println("click on search");

            String textSearch = this.view.getTextField_Search().getText();
            if (textSearch.equals(""))
                this.view.initBooks();
            else {
                String query = "SELECT * FROM tmp_Book\n" +
                        "WHERE 1 ";
                String ftsNaturalLanguage = "";
                String ftsBoolean = "";
                Hashtable<String, String> exact = new Hashtable<>();
                String[] token = textSearch.trim().split("\\s+");
                for (String i : token) {
                    if (i.matches("^(-|\\+){1}[^+ -]{1,}$")) {
                        ftsBoolean += i + " ";
                    } else if (i.matches("[a-zA-Z_0-9^s]+:[a-zA-Z_0-9^s]+")) {
                        String[] tmp = i.split(":");
                        exact.put(tmp[0], tmp[1]);
                    } else {
                        ftsNaturalLanguage += i + " ";
                    }
                }
                if (!ftsNaturalLanguage.equals("")) {
                    query = query + "\nAND MATCH (BookName, Categories, AuthorName, PublisherName)\n" +
                            "AGAINST ('__ftsNaturalLanguage' IN NATURAL LANGUAGE MODE )";
                    query = query.replace("__ftsNaturalLanguage", ftsNaturalLanguage.trim());
                }
                if (!ftsBoolean.equals("")) {
                    query = query + "\nAND MATCH (BookName, Categories, AuthorName, PublisherName)\n" +
                            "AGAINST ('__ftsBoolean' IN BOOLEAN MODE ) ";
                    query = query.replace("__ftsBoolean", ftsBoolean.trim());
                }
                for (String i : exact.keySet()) {
                    query = query + "\nAND key LIKE '%__val%'\n";
                    query = query.replace("key", i).replace("__val", exact.get(i));
                }
                try {
                    ResultSet resultSet = db.getConnection().createStatement().executeQuery(query);
                    view.getPanel_books().removeAll();
                    while (resultSet.next()) {
                        String bookID = resultSet.getString("BookID");
                        String bookName = resultSet.getString("BookName");
                        double price = resultSet.getDouble("UnitPrice");
                        JPanel book = view.createBookView(bookID, bookName, String.valueOf(price));
                        view.display(book);
                    }
                    view.reloadView(view.getPanel_books());
                } catch (SQLException sqlException) {
                    JOptionPane.showMessageDialog(view, "Check your query! \nExact search is available in" +
                            " BookID, AuthorID, PublisherID, BookName, AuthorName, PublisherName", "error", JOptionPane.INFORMATION_MESSAGE);
                    sqlException.printStackTrace();
                }
            }
        } else if (e.getActionCommand().equals("Create new account")) {
            CreateAccount createAccount = new CreateAccount();
            createAccount.setVisible(false);
            createAccount.getComboBox_Type().enable(true);
            createAccount.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
