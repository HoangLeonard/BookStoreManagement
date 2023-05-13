/*
 * Created by JFormDesigner on Wed Dec 21 07:33:12 ICT 2022
 */

package View;

import java.awt.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author unknown
 */
public class Flowlayout extends JFrame {

    public Flowlayout() throws HeadlessException {

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        frame1 = new JFrame();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== frame1 ========
        {
            frame1.setBackground(new Color(0x009999));
            var frame1ContentPane = frame1.getContentPane();

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setFont(table1.getFont().deriveFont(table1.getFont().getSize() + 13f));
                table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                scrollPane1.setViewportView(table1);
            }

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, frame1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(40, Short.MAX_VALUE)
                        .addComponent(scrollPane1)
                        .addContainerGap(26, Short.MAX_VALUE))
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame frame1;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {
        new Flowlayout();
    }
}
