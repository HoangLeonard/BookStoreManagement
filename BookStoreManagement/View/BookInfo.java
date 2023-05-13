/*
 * Created by JFormDesigner on Wed Dec 21 11:00:48 ICT 2022
 */

package View;

import Controller.DatabaseConnector;
import Model.Book;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class BookInfo extends JDialog {
    Home home;
    String BookID;
    String bookName;
    String author;
    String publisher;
    String categories;
    int quantity;
    double price;

    public BookInfo(String BID, Home view) {
        initComponents();
        home = view;
        try {
            ResultSet result = view.getDb().getConnection().createStatement().executeQuery
                    ("SELECT BookID, BookName, a.Name as AuthorName, PublisherName, Categories, book.AuthorID, book.PublisherID, book.Quantity, book.UnitPrice\n" +
                    "FROM book JOIN author a on a.AuthorID = book.AuthorID\n" +
                    "JOIN publisher p on p.PublisherID = book.PublisherID\n" +
                    "WHERE BookID = '" + BID + "'");
            if (result.next()) {
                URL url = this.getClass().getResource("/View/Books/" + BID + ".jpg");
                Image img = Toolkit.getDefaultToolkit().createImage(url).getScaledInstance(160,190,0);
                label_img.setIcon(new ImageIcon(img));
                textField_BookID.setText(BID);
                textArea_Categories.setText(result.getString("Categories"));
                textField_Author.setText(result.getString("AuthorName"));
                textField_BookName.setText(result.getString("BookName"));
                textField_Publisher.setText(result.getString("PublisherName"));
                BookID = result.getString("BookID");
                bookName = result.getString("BookName");
                author = result.getString("AuthorName");
                publisher = result.getString("PublisherName");
                categories = result.getString("Categories");
                quantity = result.getInt("Quantity");
                price = result.getDouble("UnitPrice");
            }
        } catch (SQLException sqlException) {
            System.out.println("can not connect db.");
        }
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void undisplayAddToOrder() {
        this.button1.setVisible(false);
        this.spinner_Quantity.setVisible(false);
        this.label_Price.setVisible(false);
    }

    private void addToOrder(ActionEvent e) {
        // TODO add your code here
        if (e.getActionCommand().equals("add to order")) {
            int value = (int) this.spinner_Quantity.getValue();
            if (value > 0) {
                Book book = new Book(BookID, bookName, author, publisher, categories, quantity, price);
                home.getOrder().put(book, value);
                home.getMappingOrder().put(BookID, book);
                this.dispose();
                System.out.println("add " + book + " to order");
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label_img = new JLabel();
        label5 = new JPanel();
        label_BookID = new JLabel();
        textField_BookID = new JTextField();
        label_BookName = new JLabel();
        textField_BookName = new JTextField();
        label_Author = new JLabel();
        textField_Author = new JTextField();
        label_Publisher = new JLabel();
        textField_Publisher = new JTextField();
        label_Categories = new JLabel();
        label_Price = new JLabel();
        spinner_Quantity = new JSpinner();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea_Categories = new JTextArea();

        //======== this ========
        setBackground(Color.white);
        setForeground(new Color(0x006666));
        var contentPane = getContentPane();

        //---- label_img ----
        label_img.setBackground(Color.darkGray);
        label_img.setOpaque(true);
        label_img.setHorizontalAlignment(SwingConstants.CENTER);

        //======== label5 ========
        {
            label5.setLayout(new GridBagLayout());
            ((GridBagLayout)label5.getLayout()).columnWidths = new int[] {101, 201, 0};
            ((GridBagLayout)label5.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
            ((GridBagLayout)label5.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)label5.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

            //---- label_BookID ----
            label_BookID.setText("BookID");
            label_BookID.setForeground(new Color(0x006666));
            label_BookID.setFont(new Font("Calibri", Font.BOLD, 16));
            label_BookID.setBackground(Color.white);
            label_BookID.setVerticalAlignment(SwingConstants.BOTTOM);
            label5.add(label_BookID, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 19, 10), 0, 0));

            //---- textField_BookID ----
            textField_BookID.setCaretColor(Color.darkGray);
            textField_BookID.setForeground(Color.darkGray);
            textField_BookID.setFont(new Font("Calibri", Font.PLAIN, 14));
            label5.add(textField_BookID, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 19, 0), 0, 0));

            //---- label_BookName ----
            label_BookName.setText("Book Name");
            label_BookName.setForeground(new Color(0x006666));
            label_BookName.setFont(new Font("Calibri", Font.BOLD, 16));
            label_BookName.setBackground(Color.white);
            label_BookName.setVerticalAlignment(SwingConstants.BOTTOM);
            label5.add(label_BookName, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 19, 10), 0, 0));

            //---- textField_BookName ----
            textField_BookName.setCaretColor(Color.darkGray);
            textField_BookName.setForeground(Color.darkGray);
            textField_BookName.setFont(new Font("Calibri", Font.PLAIN, 14));
            label5.add(textField_BookName, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 19, 0), 0, 0));

            //---- label_Author ----
            label_Author.setText("Author");
            label_Author.setForeground(new Color(0x006666));
            label_Author.setFont(new Font("Calibri", Font.BOLD, 16));
            label_Author.setBackground(Color.white);
            label_Author.setVerticalAlignment(SwingConstants.BOTTOM);
            label5.add(label_Author, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 19, 10), 0, 0));

            //---- textField_Author ----
            textField_Author.setCaretColor(Color.darkGray);
            textField_Author.setForeground(Color.darkGray);
            textField_Author.setFont(new Font("Calibri", Font.PLAIN, 14));
            label5.add(textField_Author, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 19, 0), 0, 0));

            //---- label_Publisher ----
            label_Publisher.setText("Publisher");
            label_Publisher.setForeground(new Color(0x006666));
            label_Publisher.setFont(new Font("Calibri", Font.BOLD, 16));
            label_Publisher.setBackground(Color.white);
            label_Publisher.setVerticalAlignment(SwingConstants.BOTTOM);
            label5.add(label_Publisher, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 19, 10), 0, 0));

            //---- textField_Publisher ----
            textField_Publisher.setCaretColor(Color.darkGray);
            textField_Publisher.setForeground(Color.darkGray);
            textField_Publisher.setFont(new Font("Calibri", Font.PLAIN, 14));
            label5.add(textField_Publisher, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 19, 0), 0, 0));

            //---- label_Categories ----
            label_Categories.setText("Categories:");
            label_Categories.setForeground(new Color(0x006666));
            label_Categories.setFont(new Font("Calibri", Font.BOLD, 16));
            label_Categories.setBackground(Color.white);
            label5.add(label_Categories, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 10), 0, 0));
        }

        //---- label_Price ----
        label_Price.setText("Price: ");
        label_Price.setForeground(new Color(0x006666));
        label_Price.setFont(new Font("Calibri", Font.BOLD, 16));
        label_Price.setBackground(Color.white);
        label_Price.setVerticalAlignment(SwingConstants.BOTTOM);

        //---- spinner_Quantity ----
        spinner_Quantity.setFont(new Font("Calibri", Font.PLAIN, 11));
        spinner_Quantity.setBackground(Color.darkGray);
        spinner_Quantity.setModel(new SpinnerNumberModel(0, 0, null, 1));
        spinner_Quantity.setForeground(new Color(0x006666));

        //---- button1 ----
        button1.setIcon(new ImageIcon(getClass().getResource("/View/Icon/Shopping-cart-add-icon.png")));
        button1.setToolTipText("add to order");
        button1.setBackground(Color.darkGray);
        button1.setActionCommand("add to order");
        button1.addActionListener(e -> addToOrder(e));

        //======== scrollPane1 ========
        {

            //---- textArea_Categories ----
            textArea_Categories.setCaretColor(Color.darkGray);
            textArea_Categories.setForeground(Color.darkGray);
            textArea_Categories.setFont(new Font("Calibri", Font.ITALIC, 14));
            scrollPane1.setViewportView(textArea_Categories);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(button1)
                            .addGap(64, 64, 64))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label_img, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label_Price, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spinner_Quantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(14, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1)
                            .addGap(12, 12, 12))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(label_img, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(spinner_Quantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label_Price, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(button1)))
                    .addGap(18, 18, 18))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label_img;
    private JPanel label5;
    private JLabel label_BookID;
    private JTextField textField_BookID;
    private JLabel label_BookName;
    private JTextField textField_BookName;
    private JLabel label_Author;
    private JTextField textField_Author;
    private JLabel label_Publisher;
    private JTextField textField_Publisher;
    private JLabel label_Categories;
    private JLabel label_Price;
    private JSpinner spinner_Quantity;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTextArea textArea_Categories;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
