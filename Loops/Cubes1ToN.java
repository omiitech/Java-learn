import java.util.Scanner;

public class Cubes1ToN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {
            System.out.println("Cube of " + i + " is " + (i * i * i));
        }
        sc.close();
    }
}
