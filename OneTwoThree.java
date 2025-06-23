/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chanakarnkin
 */
public class OneTwoThree {
    
    static int sum = 777; // global variable
    
    public static void oneTwoThree() {
    
        System.out.println("1");
        System.out.println("2");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("1");
        System.out.println("2");
        System.out.println("1");
        System.out.println("2");
        System.out.println("1");
    }
    
    // Method Overloading
    
    public static void printN(){
    
        System.out.println("Print: n");
         System.out.println("Sum global = " + sum);
    }
    
    public static void printN(int n) {
    
        System.out.println("Print: " + n);
    }
    
     public static void printN(int n, int m) {
    
        System.out.println("Print: " + (n + m));
       
    }
     
     public static void printN(String n, String m){
     
         if (n.equals("Hi") && m.equals("Hello"))
         
             System.out.println(n+m);
     }
     
    public static int sum(int x, int y) {

        int sum = 0; // local variable
        for (int i = x; i <= y; i++) {
            sum += i;
        }
        System.out.println("Sum from " + x + " to " + y + " is " + sum);
        return sum;
    }
    
    public static int max(int num1, int num2) {
    
       int result;
       if (num1 > num2) result = num1;
       else result = num2;
        
        return result; 
    }
    public static int min(int num1, int num2) {
    
       int result;
       if (num1 < num2) result = num1;
       else result = num2;
        
        return result; 
    }
    
    // Non-static (instance method)
    
    /**
     * 
     * @param num1 เป็นค่าที่ใส่มาเป็นเลขฐาน
     * @param num2 เป็นเลขที่เอามาลบ
     * @return คำตอบของ num1-num2
     */
    
    public int minus (int num1, int num2){ 
    
        return num1-num2;
    }
    
    public static void main(String[] args) {
        
     //oneTwoThree();
     OneTwoThree.printN();
     printN(555);
     printN(555, 666);
     printN("Hi","Hello");
     
        System.out.println("Sum = " + sum(1,10));
        System.out.println("Sum = " + sum(20,30));
        System.out.println("max = " + max(555,666));
        System.out.println("min = " + min(555,666));
        
        OneTwoThree ott = new OneTwoThree();
        System.out.println("minus = " + ott.minus(555,666));
        
    }
    
}
