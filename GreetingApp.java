import javax.swing.*; // Import ไลบรารี Swing ทั้งหมด
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GreetingApp {

    public static void main(String[] args) {
        // Swing ควรทำงานบน Event Dispatch Thread (EDT) เพื่อความปลอดภัย
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // 1. สร้างหน้าต่างหลัก (JFrame)
        // JFrame คือ Object ของหน้าต่างโปรแกรม
        JFrame frame = new JFrame("Greeting App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ตั้งค่าให้โปรแกรมปิดเมื่อกดปุ่ม X
        frame.setSize(350, 150); // กำหนดขนาดหน้าต่าง

        // 2. สร้าง Panel เพื่อจัดกลุ่ม Components
        // JPanel คือ Object ที่ใช้เป็นภาชนะสำหรับวางส่วนประกอบอื่นๆ
        JPanel panel = new JPanel();
        frame.add(panel); // เพิ่ม Panel เข้าไปใน Frame

        // 3. สร้าง Components ต่างๆ
        // JLabel คือ Object ป้ายข้อความ
        JLabel nameLabel = new JLabel("กรอกชื่อของคุณ:");
        panel.add(nameLabel); // เพิ่มป้ายข้อความลงใน Panel

        // JTextField คือ Object ช่องกรอกข้อความ
        JTextField nameTextField = new JTextField(15); // กำหนดขนาดช่องข้อความประมาณ 15 ตัวอักษร
        panel.add(nameTextField); // เพิ่มช่องกรอกข้อความลงใน Panel

        // JButton คือ Object ปุ่ม
        JButton greetButton = new JButton("ทักทาย");
        panel.add(greetButton); // เพิ่มปุ่มลงใน Panel

        // 4. เพิ่มการตอบสนองเมื่อปุ่มถูกคลิก (Event Handling)
        // เราสร้าง Object ActionListener เพื่อ "ฟัง" ว่าปุ่มถูกกดหรือไม่
        greetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ดึงข้อความจาก JTextField
                String name = nameTextField.getText();

                // ตรวจสอบว่าผู้ใช้กรอกชื่อหรือไม่
                if (name != null && !name.trim().isEmpty()) {
                    // พิมพ์คำทักทายออกทาง Console
                    System.out.println("สวัสดี, " + name + "! ยินดีต้อนรับครับ");
                    // หรือจะแสดงเป็น Dialog Box ก็ได้
                    JOptionPane.showMessageDialog(frame, "สวัสดี, " + name + "!");
                } else {
                    JOptionPane.showMessageDialog(frame, "กรุณากรอกชื่อก่อนนะครับ");
                }
            }
        });

        // 5. แสดงหน้าต่าง
        frame.setLocationRelativeTo(null); // ตั้งค่าให้หน้าต่างอยู่กลางจอ
        frame.setVisible(true); // ทำให้หน้าต่างแสดงผลขึ้นมา
    }
}
