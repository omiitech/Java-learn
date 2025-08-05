import java.util.Scanner;

public class OtcBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to OTC-Bank$!");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial balance: ");
        int initial = sc.nextInt();

        Bank b = new Bank(name, initial);

        boolean run = true;

        while (run) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Amount to deposit: ");
                    int dep = sc.nextInt();
                    b.deposit(dep);
                    break;

                case 2:
                    System.out.print("Amount to withdraw: ");
                    int wit = sc.nextInt();
                    b.withdraw(wit);
                    break;

                case 3:
                    b.showBalance();
                    break;

                case 4:
                    System.out.println("Thanks for using  OTC-Bank$!");
                    run = false;
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }

        sc.close();
    }
}
