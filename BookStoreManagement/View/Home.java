package View;

import java.awt.event.*;
import Controller.DatabaseConnector;
import Model.Account;
import Model.Book;

import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import javax.swing.*;


public class Home extends JFrame{

    public Home() {
        System.out.println("View: Creating Home GUI.");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.initComponents();
        ActionListener listener = new Controller.Home(this);
        this.setActionListener(listener);
//        this.bookView = new JViewport();
//        this.bookView.add(panel_books);
//        Point p = this.bookView.getViewPosition();
//        this.bookView.setViewPosition(new Point(p.x, p.y+4));
        this.setVisible(true);
        System.out.println("View: Created Home GUI.");
    }

    public Home(Account account, DatabaseConnector db) {
        System.out.println("View: Creating Home GUI.");
        this.account = account;
        this.db = db;
        this.order = new Hashtable<>();
        this.mappingOrder = new Hashtable<>();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.initComponents();
        ActionListener listener = new Controller.Home(this);
        this.setActionListener(listener);
        this.initBooks();
        if (account.getType().equals("client")) {
            System.out.println(account.getType());
            this.menuBar1.setVisible(false);
        }
        this.setVisible(true);

        System.out.println("View: Created Home GUI.");
    }

    private void setActionListener(ActionListener l){
        this.button_Info.addActionListener(l);
        this.button_Order.addActionListener(l);
        this.button_Search.addActionListener(l);
        this.menuItem_CreateNewAccount.addActionListener(l);
    }

    public void initBooks() {
        panel_books.removeAll();
        try {
            System.out.println("Getting book");
            ResultSet result = db.getConnection().createStatement().executeQuery("SELECT * FROM book LIMIT 30");
            while (result.next()) {
                String bookID = result.getString("BookID");
                String name = result.getString("BookName");
                String price = result.getString("UnitPrice");
                display(createBookView(bookID, name, price));
            }
            reloadView(panel_books);
        } catch (SQLException sqlException) {
            System.out.println("Fail to init book");
        }
    }

    public void reloadView(Component c) {
        c.setVisible(false);
        c.setVisible(true);
    }

    private void bookMouseClick(MouseEvent e) {
        // TODO add your code here
        Component jPanel = (JPanel) e.getComponent();
        String BID = jPanel.getName();
        new BookInfo(BID, this);
    }

    public JPanel createBookView (String BID, String name, String price) {
        JPanel book = new JPanel();
        JLabel label_img = new JLabel();
        JLabel label_name = new JLabel();
        JLabel label_price = new JLabel();
        //======== book ========
        {
            book.setName(BID);
            book.setPreferredSize(new Dimension(120, 200));
            book.setBackground(Color.white);
            book.setForeground(Color.gray);
            book.setOpaque(true);
            book.setMinimumSize(new Dimension(120, 200));
            book.setMaximumSize(new Dimension(120, 200));
            book.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    bookMouseClick(e);
                }
            });
            book.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 2));
            ((FlowLayout)book.getLayout()).setAlignOnBaseline(true);

            //---- label_img ----
            label_img.setPreferredSize(new Dimension(120, 140));
            label_img.setOpaque(true);
            label_img.setBackground(Color.darkGray);
            book.add(label_img);

            //---- textArea_name ----
            label_name.setFont(new Font("Calibri", Font.PLAIN, 14));
            label_name.setBackground(Color.white);
            label_name.setForeground(new Color(0x0C4F4F));
            label_name.setMinimumSize(new Dimension(10, 10));
            label_name.setPreferredSize(new Dimension(120, 20));
            label_name.setVerticalAlignment(JLabel.CENTER);
            label_name.setText("");
            book.add(label_name);

            //---- label_price ----
            label_price.setText("text");
            label_price.setPreferredSize(new Dimension(120, 20));
            label_price.setHorizontalTextPosition(SwingConstants.RIGHT);
            label_price.setHorizontalAlignment(SwingConstants.RIGHT);
            label_price.setVerticalAlignment(JLabel.CENTER);
            label_price.setFont(new Font("Calibri", Font.BOLD, 16));
            label_price.setForeground(new Color(0xff3333));
            label_price.setBackground(Color.white);
            book.add(label_price);
        }
        String link = "/View/Books/" + BID + ".jpg";
        URL url = this.getClass().getResource(link);
        Image img = Toolkit.getDefaultToolkit().createImage(url).getScaledInstance(120,140,0);
        label_img.setIcon(new ImageIcon(img));
        name = (name.length() > 16)? name.substring(0,15) +"...": name;
        label_name.setText(name);
        label_price.setText(price);
        return book;
    }

    public void display(JPanel book) {
        this.panel_books.add(book);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu_Account = new JMenu();
        menuItem_CreateNewAccount = new JMenuItem();
        menuItem_RevokeAccount = new JMenuItem();
        menuItem_ShowAccountInfo = new JMenuItem();
        menu_Book = new JMenu();
        menuItem_Addnewbook = new JMenuItem();
        menuItem_UpdateBook = new JMenuItem();
        menuItem_DeleteBook = new JMenuItem();
        menu3 = new JMenu();
        menuItem9 = new JMenuItem();
        menuItem10 = new JMenuItem();
        menuItem11 = new JMenuItem();
        menuItem12 = new JMenuItem();
        menu_Publisher = new JMenu();
        menuItem_AddPublisher = new JMenuItem();
        menuItem_ModifyPublisher = new JMenuItem();
        menuItem_DeletePublisher = new JMenuItem();
        menuItem_ShowPublisher = new JMenuItem();
        panel_Header = new JPanel();
        label_Logo = new JLabel();
        textField_Search = new JTextField();
        button_Search = new JButton();
        hSpacer1 = new JPanel(null);
        button_Order = new JButton();
        button_Info = new JButton();
        panel_books = new JPanel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));
        setBackground(Color.white);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {
            menuBar1.setBackground(Color.white);
            menuBar1.setForeground(Color.darkGray);

            //======== menu_Account ========
            {
                menu_Account.setText("Account");
                menu_Account.setForeground(Color.darkGray);
                menu_Account.setOpaque(true);
                menu_Account.setBackground(Color.white);
                menu_Account.setIcon(new ImageIcon(getClass().getResource("/View/Icon/account.png")));

                //---- menuItem_CreateNewAccount ----
                menuItem_CreateNewAccount.setText("Create new account");
                menu_Account.add(menuItem_CreateNewAccount);

                //---- menuItem_RevokeAccount ----
                menuItem_RevokeAccount.setText("Revoke account");
                menu_Account.add(menuItem_RevokeAccount);

                //---- menuItem_ShowAccountInfo ----
                menuItem_ShowAccountInfo.setText("Show account info");
                menu_Account.add(menuItem_ShowAccountInfo);
            }
            menuBar1.add(menu_Account);

            //======== menu_Book ========
            {
                menu_Book.setText("Book");
                menu_Book.setForeground(Color.darkGray);
                menu_Book.setOpaque(true);
                menu_Book.setBackground(Color.white);
                menu_Book.setIcon(new ImageIcon(getClass().getResource("/View/Icon/book-icon.png")));

                //---- menuItem_Addnewbook ----
                menuItem_Addnewbook.setText("Add new book");
                menu_Book.add(menuItem_Addnewbook);

                //---- menuItem_UpdateBook ----
                menuItem_UpdateBook.setText("Update book");
                menu_Book.add(menuItem_UpdateBook);

                //---- menuItem_DeleteBook ----
                menuItem_DeleteBook.setText("Delete book");
                menu_Book.add(menuItem_DeleteBook);
            }
            menuBar1.add(menu_Book);

            //======== menu3 ========
            {
                menu3.setText("Author");
                menu3.setForeground(Color.darkGray);
                menu3.setOpaque(true);
                menu3.setBackground(Color.white);
                menu3.setIcon(new ImageIcon(getClass().getResource("/View/Icon/text-x-authors-icon.png")));

                //---- menuItem9 ----
                menuItem9.setText("Add new author");
                menu3.add(menuItem9);

                //---- menuItem10 ----
                menuItem10.setText("Update new author");
                menu3.add(menuItem10);

                //---- menuItem11 ----
                menuItem11.setText("Delete author");
                menu3.add(menuItem11);

                //---- menuItem12 ----
                menuItem12.setText("Show author info");
                menu3.add(menuItem12);
            }
            menuBar1.add(menu3);

            //======== menu_Publisher ========
            {
                menu_Publisher.setText("Publisher");
                menu_Publisher.setForeground(Color.darkGray);
                menu_Publisher.setOpaque(true);
                menu_Publisher.setBackground(Color.white);
                menu_Publisher.setIcon(new ImageIcon(getClass().getResource("/View/Icon/Publisher-icon.png")));

                //---- menuItem_AddPublisher ----
                menuItem_AddPublisher.setText("Add publisher");
                menu_Publisher.add(menuItem_AddPublisher);

                //---- menuItem_ModifyPublisher ----
                menuItem_ModifyPublisher.setText("Modify publisher");
                menu_Publisher.add(menuItem_ModifyPublisher);

                //---- menuItem_DeletePublisher ----
                menuItem_DeletePublisher.setText("Delete publisher");
                menu_Publisher.add(menuItem_DeletePublisher);

                //---- menuItem_ShowPublisher ----
                menuItem_ShowPublisher.setText("Show publisher info");
                menu_Publisher.add(menuItem_ShowPublisher);
            }
            menuBar1.add(menu_Publisher);
        }
        setJMenuBar(menuBar1);

        //======== panel_Header ========
        {
            panel_Header.setPreferredSize(new Dimension(658, 50));
            panel_Header.setBackground(new Color(0x006666));
            panel_Header.setLayout(new FlowLayout());

            //---- label_Logo ----
            label_Logo.setIcon(new ImageIcon(getClass().getResource("/View/Icon/book.png")));
            label_Logo.setText("BOKKOB");
            label_Logo.setFont(new Font("Segoe UI", Font.BOLD, 18));
            label_Logo.setPreferredSize(new Dimension(112, 40));
            panel_Header.add(label_Logo);

            //---- textField_Search ----
            textField_Search.setFont(new Font("Calibri", Font.PLAIN, 16));
            textField_Search.setDisabledTextColor(new Color(0xcccccc));
            textField_Search.setPreferredSize(new Dimension(320, 40));
            textField_Search.setToolTipText("put your search query");
            textField_Search.setHorizontalAlignment(SwingConstants.LEFT);
            textField_Search.setBackground(Color.darkGray);
            textField_Search.setScrollOffset(9);
            panel_Header.add(textField_Search);

            //---- button_Search ----
            button_Search.setIcon(new ImageIcon(getClass().getResource("/View/Icon/search.png")));
            button_Search.setHorizontalTextPosition(SwingConstants.RIGHT);
            button_Search.setToolTipText("search");
            button_Search.setForeground(new Color(0x006666));
            button_Search.setBackground(new Color(0x006666));
            button_Search.setMinimumSize(new Dimension(10, 10));
            button_Search.setPreferredSize(new Dimension(40, 40));
            button_Search.setIconTextGap(0);
            button_Search.setAlignmentY(0.0F);
            button_Search.setBorderPainted(false);
            button_Search.setOpaque(false);
            button_Search.setActionCommand("search");
            panel_Header.add(button_Search);

            //---- hSpacer1 ----
            hSpacer1.setPreferredSize(new Dimension(60, 10));
            hSpacer1.setAutoscrolls(true);
            hSpacer1.setForeground(new Color(0x006666));
            hSpacer1.setBackground(new Color(0x006666));
            panel_Header.add(hSpacer1);

            //---- button_Order ----
            button_Order.setIcon(new ImageIcon(getClass().getResource("/View/Icon/Online-Shopping-icon.png")));
            button_Order.setHorizontalTextPosition(SwingConstants.RIGHT);
            button_Order.setToolTipText("search");
            button_Order.setForeground(new Color(0x006666));
            button_Order.setBackground(new Color(0x006666));
            button_Order.setMinimumSize(new Dimension(10, 10));
            button_Order.setPreferredSize(new Dimension(40, 40));
            button_Order.setIconTextGap(0);
            button_Order.setAlignmentY(0.0F);
            button_Order.setBorderPainted(false);
            button_Order.setOpaque(false);
            button_Order.setActionCommand("order");
            panel_Header.add(button_Order);

            //---- button_Info ----
            button_Info.setIcon(new ImageIcon(getClass().getResource("/View/Icon/Male-user-info-icon.png")));
            button_Info.setHorizontalTextPosition(SwingConstants.RIGHT);
            button_Info.setToolTipText("search");
            button_Info.setForeground(new Color(0x006666));
            button_Info.setBackground(new Color(0x006666));
            button_Info.setMinimumSize(new Dimension(10, 10));
            button_Info.setPreferredSize(new Dimension(40, 40));
            button_Info.setIconTextGap(0);
            button_Info.setAlignmentY(0.0F);
            button_Info.setBorderPainted(false);
            button_Info.setOpaque(false);
            button_Info.setActionCommand("info");
            panel_Header.add(button_Info);
        }
        contentPane.add(panel_Header, BorderLayout.NORTH);

        //======== panel_books ========
        {
            panel_books.setBackground(Color.darkGray);
            panel_books.setAutoscrolls(true);
            panel_books.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            panel_books.setNextFocusableComponent(null);
            panel_books.setFocusTraversalPolicyProvider(true);
            panel_books.setFocusCycleRoot(true);
            panel_books.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        }
        contentPane.add(panel_books, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu_Account;
    private JMenuItem menuItem_CreateNewAccount;
    private JMenuItem menuItem_RevokeAccount;
    private JMenuItem menuItem_ShowAccountInfo;
    private JMenu menu_Book;
    private JMenuItem menuItem_Addnewbook;
    private JMenuItem menuItem_UpdateBook;
    private JMenuItem menuItem_DeleteBook;
    private JMenu menu3;
    private JMenuItem menuItem9;
    private JMenuItem menuItem10;
    private JMenuItem menuItem11;
    private JMenuItem menuItem12;
    private JMenu menu_Publisher;
    private JMenuItem menuItem_AddPublisher;
    private JMenuItem menuItem_ModifyPublisher;
    private JMenuItem menuItem_DeletePublisher;
    private JMenuItem menuItem_ShowPublisher;
    private JPanel panel_Header;
    private JLabel label_Logo;
    private JTextField textField_Search;
    private JButton button_Search;
    private JPanel hSpacer1;
    private JButton button_Order;
    private JButton button_Info;
    private JPanel panel_books;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private Account account;
    private Hashtable<Book, Integer> order;
    private Hashtable<String, Book> mappingOrder;
    private DatabaseConnector db;

    public JPanel getPanel_books() {
        return panel_books;
    }

    public void setPanel_books(JPanel panel_books) {
        this.panel_books = panel_books;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Hashtable<Book, Integer> getOrder() {
        return order;
    }

    public void setOrder(Hashtable<Book, Integer> books) {
        this.order = books;
    }

    public Hashtable<String, Book> getMappingOrder() {
        return mappingOrder;
    }

    public void setMappingOrder(Hashtable<String, Book> mappingOrder) {
        this.mappingOrder = mappingOrder;
    }

    public DatabaseConnector getDb() {
        return db;
    }

    public JTextField getTextField_Search() {
        return textField_Search;
    }

    public void setTextField_Search(JTextField textField_Search) {
        this.textField_Search = textField_Search;
    }
}
