import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * แอปพลิเคชันนี้สาธิตการสลับ JPanel ภายใน JFrame โดยใช้ JMenuBar และ CardLayout
 * ซึ่งเป็นแนวทางปฏิบัติทั่วไปในการสร้างแอปพลิเคชันที่มีหลายมุมมอง (Multi-view application)
 */
public class PanelSwitcherApp {

    // ประกาศตัวแปรสำหรับ Components หลักๆ เพื่อให้สามารถเข้าถึงได้จากหลายเมธอด
    private JFrame frame;
    private JPanel cardPanel; // Panel ที่จะใช้ CardLayout ในการสลับ "การ์ด" (Panel อื่นๆ)
    private CardLayout cardLayout; // Layout Manager ที่ใช้ในการสลับ Component

    public static void main(String[] args) {
        // สร้างและแสดง GUI บน Event Dispatch Thread (EDT) เพื่อความปลอดภัย
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PanelSwitcherApp().createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        // 1. --- ตั้งค่า JFrame (บ้าน) ---
        frame = new JFrame("Panel Switcher Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // 2. --- สร้าง JMenuBar (เมนูบาร์ด้านบน) ---
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu viewMenu = new JMenu("View"); // เมนูสำหรับสลับ Panel

        // เพิ่มเมนูย่อยใน File
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0)); // ใช้ Lambda expression ให้โค้ดสั้นลง
        fileMenu.add(exitMenuItem);

        // เพิ่มเมนูย่อยใน View
        JMenuItem showPanel1Item = new JMenuItem("Show Panel 1");
        JMenuItem showPanel2Item = new JMenuItem("Show Panel 2");
        viewMenu.add(showPanel1Item);
        viewMenu.add(showPanel2Item);

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        frame.setJMenuBar(menuBar); // นำเมนูบาร์ไปติดตั้งที่ Frame

        // 3. --- ตั้งค่า Panel หลักที่จะใช้สลับการ์ด ---
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout); // กำหนดให้ Panel นี้ใช้ CardLayout

        // 4. --- สร้าง Panel ที่จะใช้เป็น "การ์ด" (ห้องต่างๆ) ---

        // Panel 1
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(173, 216, 230)); // สีฟ้าอ่อน
        panel1.add(new JLabel("This is Panel 1"));
        panel1.add(new JButton("Button on Panel 1"));

        // Panel 2
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(255, 228, 181)); // สีส้มอ่อน
        panel2.add(new JLabel("Welcome to Panel 2"));
        panel2.add(new JCheckBox("A checkbox"));

        // 5. --- เพิ่มการ์ด (Panel) เข้าไปใน cardPanel ---
        // เราตั้งชื่อให้แต่ละการ์ดเพื่อใช้ในการอ้างอิงตอนสลับ
        cardPanel.add(panel1, "Panel1");
        cardPanel.add(panel2, "Panel2");

        // 6. --- เพิ่ม ActionListeners ให้กับเมนูเพื่อทำการสลับ Panel ---
        showPanel1Item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // สั่งให้ cardLayout แสดงการ์ดที่ชื่อว่า "Panel1"
                cardLayout.show(cardPanel, "Panel1");
            }
        });

        showPanel2Item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // สั่งให้ cardLayout แสดงการ์ดที่ชื่อว่า "Panel2"
                cardLayout.show(cardPanel, "Panel2");
            }
        });


        // 7. --- นำ cardPanel ไปวางใน JFrame และแสดงผล ---
        frame.add(cardPanel, BorderLayout.CENTER); // วาง Panel หลักไว้ตรงกลาง
        frame.setLocationRelativeTo(null); // แสดงหน้าต่างกลางจอ
        frame.setVisible(true);
    }
}
