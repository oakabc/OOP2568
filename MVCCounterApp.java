// ไฟล์: MVCCounterApp.java
// นี่คือคลาสหลักที่ประกอบและรันแอปพลิเคชัน
// โค้ดทั้งหมดของแอปพลิเคชันถูกรวมไว้ในไฟล์นี้เพื่อให้รันได้ง่ายขึ้น
public class MVCCounterApp {

    public static void main(String[] args) {
        // 1. สร้าง Model
        // Model ห่อหุ้มข้อมูล (จำนวนนับ) และตรรกะในการเปลี่ยนแปลงข้อมูลนั้น
        // มันเป็นอิสระจาก GUI อย่างสมบูรณ์
        CounterModel model = new CounterModel();

        // 2. สร้าง View
        // View คือการแสดงผลทางภาพ มันสืบทอดจาก JFrame (การสืบทอด)
        // และมีส่วนประกอบ UI อยู่ภายใน มันไม่ทราบวิธีจัดการตรรกะ
        CounterView view = new CounterView();

        // 3. สร้าง Controller
        // Controller คือ "ตัวเชื่อม" มันเชื่อมต่อ View และ Model เข้าด้วยกัน
        // มันใช้ interface ActionListener (Polymorphism) เพื่อตอบสนองการคลิกปุ่ม
        CounterController controller = new CounterController(model, view);

        // 4. เชื่อมต่อ View และ Controller
        // View จำเป็นต้องรู้ว่าจะแจ้งเตือนใครเมื่อปุ่มถูกคลิก
        // เราตั้งค่า Controller เป็น ActionListener สำหรับปุ่มของ View
        view.getIncrementButton().addActionListener(controller);

        // 5. เชื่อมต่อ View และ Model
        // View จำเป็นต้องรู้เมื่อข้อมูลของ Model เปลี่ยนแปลง
        // View ลงทะเบียนตัวเองเป็น listener ให้กับ Model
        // View ต้องใช้ interface CountListener (Polymorphism)
        model.addListener(view);

        // 6. ทำให้ GUI มองเห็นได้
        view.setVisible(true);
    }
}

// นี่คือ custom interface สำหรับ listeners ซึ่งเป็นตัวอย่างที่ดีของ Polymorphism
// คลาสใดๆ ที่ต้องการฟังการเปลี่ยนแปลงของ Model จะต้องใช้ interface นี้
interface CountListener {
    void countChanged(int newCount);
}

// Model: ห่อหุ้มข้อมูลและตรรกะของแอปพลิเคชัน
// มันใช้ custom interface เพื่อแจ้งเตือน listeners ที่สนใจการเปลี่ยนแปลง
import java.util.ArrayList;
import java.util.List;

class CounterModel {
    // Encapsulation (การห่อหุ้ม): 'count' เป็น private และสามารถแก้ไขได้ผ่าน method public เท่านั้น
    private int count;
    private final List<CountListener> listeners;

    public CounterModel() {
        this.count = 0;
        this.listeners = new ArrayList<>();
    }

    public int getCount() {
        return this.count;
    }

    // method นี้เปลี่ยนสถานะภายในและแจ้งเตือน listeners ทั้งหมด
    public void increment() {
        this.count++;
        notifyListeners();
    }

    // เพิ่ม listener เพื่อรับการแจ้งเตือนเมื่อจำนวนนับเปลี่ยน
    public void addListener(CountListener listener) {
        this.listeners.add(listener);
    }

    // แจ้งเตือน listeners ที่ลงทะเบียนไว้ทั้งหมดถึงการเปลี่ยนแปลง
    private void notifyListeners() {
        for (CountListener listener : listeners) {
            // Polymorphism (ภาวะพหุสัณฐาน): อ็อบเจกต์ `listener` โดยไม่คำนึงถึงชนิดเฉพาะของมัน
            // รับประกันว่าจะต้องมี method `countChanged` ที่เราสามารถเรียกใช้ได้
            listener.countChanged(this.count);
        }
    }
}

// View: ส่วนติดต่อผู้ใช้แบบกราฟิก
// มันสืบทอดจาก JFrame และใช้ custom interface CountListener ของเรา
import javax.swing.*;
import java.awt.*;

// Inheritance (การสืบทอด): CounterView เป็น JFrame และสืบทอดคุณสมบัติทั้งหมดของมัน
// Polymorphism: CounterView ยังเป็น CountListener ตามที่กำหนดใน interface
class CounterView extends JFrame implements CountListener {
    private final JLabel countLabel;
    private final JButton incrementButton;

    public CounterView() {
        super("MVC Counter");

        // Encapsulation: ส่วนประกอบ UI ทั้งหมดถูกจัดการภายในคลาสนี้
        this.countLabel = new JLabel("Count: 0", SwingConstants.CENTER);
        this.incrementButton = new JButton("Increment");

        // ตั้งค่าเค้าโครงและเพิ่มส่วนประกอบ
        this.setLayout(new BorderLayout(10, 10)); // ใช้ BorderLayout สำหรับเค้าโครงที่สะอาดตา
        this.add(countLabel, BorderLayout.CENTER);
        this.add(incrementButton, BorderLayout.SOUTH);

        // กำหนดค่า frame
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // จัดกึ่งกลางหน้าต่าง
    }

    // method นี้ถูกเรียกโดย Controller เพื่ออัปเดตการแสดงผล
    public JButton getIncrementButton() {
        return this.incrementButton;
    }

    // นี่คือการใช้งาน method `countChanged` จาก interface CountListener
    // Polymorphism ในการปฏิบัติ: Model เรียก method นี้บนอ็อบเจกต์ View
    @Override
    public void countChanged(int newCount) {
        this.countLabel.setText("Count: " + newCount);
    }
}

// Controller: จัดการการโต้ตอบของผู้ใช้และอัปเดต Model
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Polymorphism: Controller ใช้ interface ActionListener มาตรฐาน
// JButton คาดหวังอ็อบเจกต์ที่ "เป็น" ActionListener
class CounterController implements ActionListener {

    private final CounterModel model;
    private final CounterView view;

    public CounterController(CounterModel model, CounterView view) {
        // Encapsulation: Controller เก็บข้อมูลอ้างอิงไปยัง Model และ View ที่มันจัดการ
        this.model = model;
        this.view = view;
    }

    // นี่คือการใช้งาน method `actionPerformed` จาก interface ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        // เมื่อปุ่มถูกคลิก method นี้จะถูกเรียก
        // หน้าที่ของ Controller คือการอัปเดต Model
        // มันไม่ทำการอัปเดต View โดยตรง
        if (e.getSource() == view.getIncrementButton()) {
            model.increment();
        }
    }
}
