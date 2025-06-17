import java.util.Scanner;

public class StringFormat {
    
    public static void main (String [] args){
        
        // Input 
        Scanner input = new Scanner(System.in);
        System.out.print("Input your name: ");
        String text = input.nextLine(); //" chanakarn oak Kingkaew "
        
        // Process 
        
        // trim toLowercase 0 - toUppercase
        text = text.trim().toLowerCase();
        System.out.println(text);
        
        // split String -> String [] 
        String [] ta = text.split(" ");
        // { "chanakarn", "oak", "kingkaew"}
        
        for (int i = 0; i < ta.length; i++) {
           System.out.print(Character.toUpperCase(ta[i].charAt(0)) + ta[i].substring(1) + " ");
            /// "chanakarn" -charAt-> 'c' -toUpper -> 'C' + "hanakarn"
            
        }
        
    }
}