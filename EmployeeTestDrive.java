
import java.util.Scanner;


class Employee {

    // access modifier
    public int id;
    public String name;
    private double salary;
    
    // Constructor = วิธีการสร้าง Object
    
    // 0. default constructor
    public Employee() {
      
    }
    
    // 1. สร้างโดยใส่ id ทันที
    public Employee(int id) { // สร้าง object ต้องใส่ id
    
        this.id = id;
    }
    
    // 2. สร้างโดยใส่ name + id 
    public Employee(int id, String name) {
    
        this.id = id;
        this.name = name;
    }
    
    
    // instance method
    public void setSalary(double salary) {
    
        // Condition เงื่อนไข เช่น เงินเดือนต้องมากกว่า 15_000 แต่ไม่เกิน 1_000_000
        if (salary >= 15_000 && salary <= 1_000_000)
            this.salary = salary; // ทำการกำหนดค่าที่ส่งมาให้กับ salary ใน object
    }
    
    
      public double getSalary(String password){
        
        if (password.equals("1212312121"))
            return salary;
        else return -1;
    }

    

}

public class EmployeeTestDrive {

    public static void main(String[] args) {
        /// สร้าง object โดยใช้ id
        Employee ck = new Employee(12123);
        //ck.id = 12123;
        ck.name = "Chanakarn Kingkaew";
        //ck.salary = 100_000_000;
        ck.setSalary(20_000); // ck.salary = 20_000;
        System.out.println(ck.getSalary("1212312121"));
    
        
        Employee st = new Employee();
        
        Scanner input = new Scanner (System.in);
        
        System.out.print("please input id: ");
        int emid = input.nextInt();
        System.out.print("please input name: ");
        input.nextLine(); // nextInt เวลาอ่านเสร็จจะคืนบรรทัดใหม่ ('\n')
        // จะทำให้ nextLine() อ่าน '\n' เป็น String 
        String name = input.nextLine();
        
        Employee xy = new Employee(emid,name);
        
        System.out.println("name = " + xy.name);
        System.out.println("id = " + xy.id);
    }
}
