import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalTime;  // ⏰ For time

class Bank {
    String name;
    int accountNumber;
    int balance;
    int depositCount = 0;
    int withdrawCount = 0;

    public Bank(String name, int balance, int accountNumber) {
        this.name = name;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void deposit(int amount) {
        balance += amount;
        depositCount++;
        System.out.println("📥 Deposited: $" + amount);
    }

    public void withdraw(int amount) {
        balance -= amount;
        withdrawCount++;
        System.out.println("📤 Withdrawn: $" + amount);
    }

    public void showBalance() {
        System.out.println("🏦 Account Holder: " + name);
        System.out.println("🧾 Account Number: " + accountNumber);
        System.out.println("💰 Current Balance: $" + balance);
        System.out.println("📈 Deposits Made: " + depositCount);
        System.out.println("📉 Withdrawals Made: " + withdrawCount);
    }

    @Override
    public String toString() {
        return "👤 " + name + " | 🧾 Acc#: " + accountNumber + " | 💰 $" + balance;
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Bank> users = new ArrayList<>();

        LocalTime time = LocalTime.now();  // ⏰ get current time
        System.out.println("⏰ System Time: " + time.getHour() + ":" + time.getMinute());
        System.out.println("🙌 Welcome to OTC-Bank$!");

        boolean running = true;

        while (running) {
            System.out.println("\n===== 🏦 OTC-BANK HOME MENU =====");
            System.out.println("1. 🆕 Create New Account");
            System.out.println("2. 🔐 Login to Existing Account");
            System.out.println("3. 🚪 Exit");

            System.out.print("👉 Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    System.out.print("👤 Enter your name: ");
                    String name = sc.nextLine();

                    System.out.print("💸 Enter initial balance: ");
                    int initial = sc.nextInt();

                    System.out.print("🔢 Set account number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    Bank newUser = new Bank(name, initial, accNo);
                    users.add(newUser);

                    System.out.println("✅ Account created successfully for " + name);
                    break;

                case 2:
                    System.out.print("🔎 Enter account number to login: ");
                    int loginAcc = sc.nextInt();
                    sc.nextLine();

                    Bank foundUser = null;

                    for (Bank user : users) {
                        if (user.accountNumber == loginAcc) {
                            foundUser = user;
                            break;
                        }
                    }

                    if (foundUser != null) {
                        System.out.println("👋 Welcome back, " + foundUser.name + "!");
                        userMenu(sc, foundUser);
                    } else {
                        System.out.println("❌ Account not found.");
                    }
                    break;

                case 3:
                    System.out.println("🙏 Thank you for using OTC-Bank$! Goodbye.");
                    running = false;
                    break;

                default:
                    System.out.println("❌ Invalid choice.");
            }
        }

        sc.close();
    }

    public static void userMenu(Scanner sc, Bank user) {
        boolean session = true;

        while (session) {
            System.out.println("\n===== 🧾 " + user.name + "'s ACCOUNT MENU =====");
            System.out.println("1. 📥 Deposit");
            System.out.println("2. 📤 Withdraw");
            System.out.println("3. 💰 Show Balance");
            System.out.println("4. 🔙 Logout");

            System.out.print("👉 Choose: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("💵 Enter deposit amount: ");
                    int dep = sc.nextInt();
                    sc.nextLine();
                    user.deposit(dep);
                    break;

                case 2:
                    System.out.print("💳 Enter withdraw amount: ");
                    int wit = sc.nextInt();
                    sc.nextLine();
                    user.withdraw(wit);
                    break;

                case 3:
                    user.showBalance();
                    break;

                case 4:
                    System.out.println("👋 Logged out of account.");
                    session = false;
                    break;

                default:
                    System.out.println("❌ Invalid option.");
            }
        }
    }
}
