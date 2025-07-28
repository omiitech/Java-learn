import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of the rectangle: ");
        double length = sc.nextDouble();
        System.out.print("Enter breadth of the rectangle: ");
        double breadth = sc.nextDouble();
        
        double area = length * breadth;
        double perimeter = 2 * (length + breadth);
        
        System.out.println("Area of Rectangle: " + area);
        System.out.println("Perimeter of Rectangle: " + perimeter);
        sc.close();
    }
}