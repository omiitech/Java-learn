import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalTime;
import java.io.FileWriter;
import java.io.IOException;

class Bank {
    String name;
    int accountNumber;
    int balance;
    int pin;
    int depositCount = 0;
    int withdrawCount = 0;
    ArrayList<String> history = new ArrayList<>();

    public Bank(String name, int balance, int accountNumber, int pin) {
        this.name = name;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.pin = pin;
    }

    public void deposit(int amount) {
        balance += amount;
        depositCount++;
        history.add("📥 Deposited $" + amount);
        System.out.println("📥 Deposited: $" + amount);
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
            return;
        }
        balance -= amount;
        withdrawCount++;
        history.add("📤 Withdrew $" + amount);
        System.out.println("📤 Withdrawn: $" + amount);
    }

    public void showBalance() {
        System.out.println("🏦 Account Holder: " + name);
        System.out.println("🧾 Account Number: " + accountNumber);
        System.out.println("💰 Current Balance: $" + balance);
        System.out.println("📈 Deposits Made: " + depositCount);
        System.out.println("📉 Withdrawals Made: " + withdrawCount);
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("🕑 No transactions yet.");
        } else {
            System.out.println("📜 Transaction History:");
            for (String entry : history) {
                System.out.println("• " + entry);
            }
        }
    }

    @Override
    public String toString() {
        return "👤 " + name + " | 🧾 Acc#: " + accountNumber + " | 💰 $" + balance;
    }
}

public class SecureBankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Bank> users = new ArrayList<>();
        LocalTime time = LocalTime.now();

        System.out.println("⏰ Login Time: " + time.getHour() + ":" + time.getMinute());
        System.out.println("🙌 Welcome to OTC-Bank$!");

        boolean running = true;

        while (running) {
            System.out.println("\n===== 🏦 OTC-BANK HOME MENU =====");
            System.out.println("1. 🆕 Create New Account");
            System.out.println("2. 🔐 Login to Existing Account");
            System.out.println("3. 💾 Exit and Save");

            System.out.print("👉 Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("👤 Enter your name: ");
                    String name = sc.nextLine();

                    System.out.print("💸 Enter initial balance: ");
                    int initial = sc.nextInt();

                    System.out.print("🔢 Set account number: ");
                    int accNo = sc.nextInt();

                    System.out.print("🔐 Set 4-digit PIN: ");
                    int pin = sc.nextInt();
                    sc.nextLine();

                    Bank newUser = new Bank(name, initial, accNo, pin);
                    users.add(newUser);

                    System.out.println("✅ Account created successfully for " + name);
                    break;

                case 2:
                    System.out.print("🔎 Enter account number: ");
                    int loginAcc = sc.nextInt();
                    System.out.print("🔑 Enter PIN: ");
                    int loginPin = sc.nextInt();
                    sc.nextLine();

                    Bank foundUser = null;
                    for (Bank user : users) {
                        if (user.accountNumber == loginAcc && user.pin == loginPin) {
                            foundUser = user;
                            break;
                        }
                    }

                    if (foundUser != null) {
                        System.out.println("👋 Welcome back, " + foundUser.name + "!");
                        userMenu(sc, foundUser);
                    } else {
                        System.out.println("❌ Invalid account number or PIN.");
                    }
                    break;

                case 3:
                    System.out.println("💾 Saving data to file...");
                    saveToFile(users);
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
            System.out.println("4. 📜 Show History");
            System.out.println("5. 🔙 Logout");

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
                    user.showHistory();
                    break;

                case 5:
                    System.out.println("👋 Logged out of account.");
                    session = false;
                    break;

                default:
                    System.out.println("❌ Invalid option.");
            }
        }
    }

   public static void saveToFile(ArrayList<Bank> users) {
    try {
        FileWriter writer = new FileWriter("bank_data.txt", true); 
        for (Bank user : users) {
            writer.write(user.toString() + "\n");
        }
        writer.write("🔚 === End of Session ===\n\n");
        writer.close();
    } catch (IOException e) {
        System.out.println("❌ Error saving file: " + e.getMessage());
    }
}

}
