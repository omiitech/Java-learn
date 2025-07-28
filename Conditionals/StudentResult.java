import java.util.Scanner;

public class StudentResult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] marks = new int[5];
        boolean invalid = false;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();

            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("❌ Invalid marks entered! Marks should be between 0 and 100.");
                invalid = true;
                break;
            }
        }

        if (!invalid) {
            boolean pass = true;
            for (int mark : marks) {
                if (mark < 35) {
                    pass = false;
                    break;
                }
            }

            if (pass) {
                System.out.println("🎉 Student has PASSED!");
            } else {
                System.out.println("😢 Student has FAILED!");
            }
        }
        sc.close();
    }
}