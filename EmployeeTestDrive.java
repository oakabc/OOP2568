
class Employee {

    // access modifier
    public int id;
    public String name;
    private double salary;
    
    // instance method
    public void setSalary(double salary) {
    
        // Condition เงื่อนไข เช่น เงินเดือนต้องมากกว่า 15_000 แต่ไม่เกิน 1_000_000
        if (salary >= 15_000 && salary <= 1_000_000)
            this.salary = salary; // ทำการกำหนดค่า
    }
    
    public double getSalary(){
    
        
        return salary;
    }
    

}

public class EmployeeTestDrive {

    public static void main(String[] args) {

        Employee ck = new Employee();
        ck.id = 12123;
        ck.name = "Chanakarn Kingkaew";
        //ck.salary = 100_000_000;
        ck.setSalary(20_000);
        System.out.println(ck.getSalary());
    }
}
