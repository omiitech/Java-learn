import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of the circle: ");
        double r = sc.nextDouble();
        
        double area = Math.PI * r * r;
        double circumference = 2 * Math.PI * r;
        
        System.out.println("Area of Circle: " + area);
        System.out.println("Circumference of Circle: " + circumference);
        sc.close();
    }
}