/*
 * Created by JFormDesigner on Wed Dec 21 19:43:29 ICT 2022
 */

package View;

import Controller.DatabaseConnector;
import Model.Bill;
import Model.Book;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class Order extends JFrame {

    private Home home;

    public Order(Home home) {
        this.home = home;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        this.setVisible(true);
        displayTable();
    }

    public void displayTable() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "BookID", "Name", "Author", "UnitPrice", "Quantity"
                }
        ) {
            boolean[] columnEditable = new boolean[] {
                    true, true, true, false, false
            };
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnEditable[columnIndex];
            }
        };
        {
            TableColumnModel cm = table_item.getColumnModel();
            cm.getColumn(0).setMinWidth(5);
            cm.getColumn(0).setMaxWidth(70);
            cm.getColumn(0).setPreferredWidth(60);
            cm.getColumn(1).setMinWidth(100);
            cm.getColumn(1).setMaxWidth(250);
            cm.getColumn(1).setPreferredWidth(210);
            cm.getColumn(2).setMinWidth(80);
            cm.getColumn(2).setMaxWidth(120);
            cm.getColumn(2).setPreferredWidth(100);
        }
        table_item.setFont(new Font("Calibri", Font.PLAIN, 13));
        table_item.setForeground(new Color(0x006666));
        table_item.setFillsViewportHeight(true);
        table_item.setBackground(Color.white);
        scrollPane1.setViewportView(table_item);
        double totalPrice = 0;
        for (Book book : home.getOrder().keySet()) {
            model.addRow(new Object[]{book.getBookID(), book.getName(), book.getAuthor(), book.getPrice(), home.getOrder().get(book).toString()});
            totalPrice += book.getPrice() * home.getOrder().get(book);
        }
        this.table_item.setModel(model);
        this.label_totalPrice.setText(totalPrice + "");
    }

    private void clickButton(ActionEvent e) {
        // TODO add your code here
        if (e.getActionCommand().equals("remove item")) {
            System.out.println("Remove item");
            for (int i : table_item.getSelectedRows()) {
                String BID = (String) this.table_item.getValueAt(i, 0);
                home.getOrder().remove(home.getMappingOrder().get(BID));
                home.getMappingOrder().remove(BID);
                this.displayTable();
            }
        } else if (e.getActionCommand().equals("show item info")) {
            System.out.println("Show item info");
            String BID = (String) this.table_item.getValueAt(table_item.getSelectedRow(), 0);
            BookInfo bookInfo = new BookInfo(BID, this.home);
            bookInfo.setVisible(false);
            bookInfo.undisplayAddToOrder();
            bookInfo.setVisible(true);
        } else if (e.getActionCommand().equals("delivery")) {
            System.out.println("Delivery");
            Bill bill = new Bill(DatabaseConnector.getBiID(), home.getAccount(), "SID0001", home.getOrder(), "2022-12-22", "DID0001");
            String query1 = Bill.generateInsertBillQuery(bill);
            String query2 = Bill.generateInsertBillDetailQuery(bill);
            try {
                System.out.println(query1);
                System.out.println(query2);
                home.getDb().getConnection().createStatement().execute(query1);
                home.getDb().getConnection().createStatement().execute(query2);
            } catch (SQLException sqlException) {
                System.out.println("Fail to update bill.");
                sqlException.printStackTrace();
            }
            this.dispose();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table_item = new JTable();
        button_remove = new JButton();
        button_view = new JButton();
        button_delivery = new JButton();
        label_totalPrice = new JLabel();
        label1 = new JLabel();
        hSpacer1 = new JPanel(null);

        //======== this ========
        setBackground(Color.darkGray);
        setForeground(new Color(0xcc0000));
        setTitle("Order");
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setBackground(Color.darkGray);
            scrollPane1.setOpaque(true);

            //---- table_item ----
            table_item.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "BookID", "Name", "Author", "UnitPrice", "Quantity"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    true, true, true, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = table_item.getColumnModel();
                cm.getColumn(0).setMinWidth(5);
                cm.getColumn(0).setMaxWidth(70);
                cm.getColumn(0).setPreferredWidth(60);
                cm.getColumn(1).setMinWidth(100);
                cm.getColumn(1).setMaxWidth(250);
                cm.getColumn(1).setPreferredWidth(210);
                cm.getColumn(2).setMinWidth(80);
                cm.getColumn(2).setMaxWidth(120);
                cm.getColumn(2).setPreferredWidth(100);
            }
            table_item.setFont(new Font("Calibri", Font.PLAIN, 16));
            table_item.setForeground(new Color(0x006666));
            table_item.setFillsViewportHeight(true);
            table_item.setBackground(Color.darkGray);
            scrollPane1.setViewportView(table_item);
        }

        //---- button_remove ----
        button_remove.setIcon(new ImageIcon(getClass().getResource("/View/Icon/Shopping-cart-remove-icon.png")));
        button_remove.setBackground(Color.darkGray);
        button_remove.setOpaque(true);
        button_remove.setForeground(Color.darkGray);
        button_remove.setToolTipText("remove item");
        button_remove.setActionCommand("remove item");
        button_remove.addActionListener(e -> clickButton(e));

        //---- button_view ----
        button_view.setIcon(new ImageIcon(getClass().getResource("/View/Icon/Shopping-cart-info-icon.png")));
        button_view.setBackground(Color.darkGray);
        button_view.setForeground(Color.darkGray);
        button_view.setOpaque(true);
        button_view.setToolTipText("show item info");
        button_view.setActionCommand("show item info");
        button_view.addActionListener(e -> clickButton(e));

        //---- button_delivery ----
        button_delivery.setText("delivery");
        button_delivery.setForeground(new Color(0x006666));
        button_delivery.setBackground(Color.white);
        button_delivery.setOpaque(true);
        button_delivery.setFont(new Font("Calibri", Font.BOLD, 14));
        button_delivery.setIcon(new ImageIcon(getClass().getResource("/View/Icon/Shopping-cart-accept-icon.png")));
        button_delivery.setHorizontalAlignment(SwingConstants.TRAILING);
        button_delivery.addActionListener(e -> clickButton(e));

        //---- label_totalPrice ----
        label_totalPrice.setForeground(new Color(0xff3333));
        label_totalPrice.setBackground(Color.white);
        label_totalPrice.setFont(new Font("Calibri", Font.BOLD, 20));
        label_totalPrice.setHorizontalAlignment(SwingConstants.CENTER);
        label_totalPrice.setVerticalAlignment(SwingConstants.BOTTOM);
        label_totalPrice.setText("000 VND");

        //---- label1 ----
        label1.setText("BOOK ORDER:");
        label1.setForeground(new Color(0x006666));
        label1.setFont(new Font("Calibri", Font.PLAIN, 24));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                            .addComponent(button_remove, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button_view, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addGap(170, 170, 170))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(hSpacer1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label_totalPrice, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(button_delivery, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 502, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(27, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button_remove, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_view, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                        .addComponent(label1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label_totalPrice, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_delivery, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(30, 30, 30))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(hSpacer1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table_item;
    private JButton button_remove;
    private JButton button_view;
    private JButton button_delivery;
    private JLabel label_totalPrice;
    private JLabel label1;
    private JPanel hSpacer1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
