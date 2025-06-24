package a;

import javax.swing.*;



class Account {

    /// Instance variables
private double balance;
//private String accountName, accountNumber, branch;

    public Account(double initialBalance) {
        if (initialBalance > 0.0) {
            balance = initialBalance;
        }
    }

    public void deposit(double amount) {
        /// การฝากเงินเข้าบัญชี
        if (amount > 0)
         balance = balance + amount;
    }

    public void withdraw(double amount) {
        /// การถอนเงินออกบัญชี // Control Logic 
        if (balance >= amount)
         balance = balance - amount;
        else JOptionPane.showMessageDialog(null, "วงเงินของท่านไม่เพียงพอ", "แจ้งเตือน!", JOptionPane.ERROR_MESSAGE);
    }

    public double getBalance() {
        /// ดูยอดเงินในบัญชี
         return balance;
    }
    
@Override
    public String toString() {
    
        return "บัญชีนี้มีเงิน = " + balance;
    }
}

public class AccountTest {

    public static void main(String[] args) {
        Account me = new Account(100); //เงิน 100
        me.deposit(300); // ฝากเงิน 100+300 = 400
        System.out.println(me.getBalance()); // 400
        me.withdraw(500); // เกินวงเงิน
        System.out.println(me.getBalance());
        System.out.println(me);
    }
}
