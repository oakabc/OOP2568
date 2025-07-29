abstract class Shape {
    
    protected String color;
    protected boolean filled;
    
    public Shape() {
        color = null;
        filled = false;
    }
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() { // == getFilled()
        return filled;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    
   abstract double getArea();
   abstract double getPerimeter();
   public String toString() {
       
       if (filled) // %b = boolean
       return String.format("A Shape with color of %s and filled.", color);
       else 
       return String.format("A Shape with color of %s and not filled.", color);
   }
    
}
    
class Circle extends Shape {
    
    protected double radius;
    
    /// Constructor Overloading 
    public Circle(){
        super();  
    }
    public Circle(double radius){
        super();
        this.radius = radius;
    }
    public Circle(String color, boolean filled, double radius){
        super(color,filled);
        this.radius = radius;
    }
    
    public double getArea(){
        return Math.PI*Math.pow(radius,2);
    }
    public double getPerimeter(){
        return 2*Math.PI*radius;
    }

    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius){
        this.radius = radius;
    }
    
    public String toString(){
        return String.format("A Circle with radius = %.2f, which is a subclass of %s", radius, super.toString());
    }
    
}


public class Main { 
    // Test Class, Main Class, Driver Class
    
    public static void main (String[] args) {
        
        Shape c = new Circle("Blue", true, 5);
        System.out.println(c);
        
        Shape ba = new Circle("Red", false, 5);
        System.out.println(ba);
        
        System.out.println(c==ba); // reference ไปที่เดียวกันหรือไม่
    }
}
