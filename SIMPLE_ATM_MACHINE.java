import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM_INTERFACE {
		    private BankAccount account;
		    private Scanner doc;

		    public ATM_INTERFACE(BankAccount account) {
		        this.account = account;
		        this.doc = new Scanner(System.in);
		    }
		    public void deposit() {
		        System.out.print("Enter amount to deposit: $");
		        try {
		            double amount = doc.nextDouble();
		            account.deposit(amount);
		        } catch (InputMismatchException e) {
		            System.out.println("Invalid input. Please enter a valid number.");
		            doc.nextLine();
		        }
		    }

		    public void withdraw() {
		        System.out.print("Enter amount to withdraw: $");
		        try {
		            double amount = doc.nextDouble();
		            account.withdraw(amount);
		        } catch (InputMismatchException e) {
		            System.out.println("Invalid input. Please enter a valid number.");
		            doc.nextLine();
		        }
		    }

		    public void checkBalance() {
		        System.out.printf("Your current balance is: $%.2f", account.getBalance());
		    }

		    public void run() {
		        int choice;
		        do {
		            System.out.println("\n1. Deposit");
		            System.out.println("2. Withdraw");
		            System.out.println("3. Check Balance");
		            System.out.println("4. Exit");
		            System.out.print("Enter your choice: ");

		            try {
		                choice = doc.nextInt();
		                doc.nextLine();
		                switch (choice) {
		                    case 1:
		                        deposit();
		                        break;
		                    case 2:
		                        withdraw();
		                        break;
		                    case 3:
		                        checkBalance();
		                        break;
		                    case 4:
		                        System.out.println("Thank you!");
		                        break;
		                    default:
		                        System.out.println("Invalid choice.");
		                }
		            } catch (InputMismatchException e) {
		                System.out.println("Invalid input. Please enter a number from 1 to 4.");
		                doc.nextLine();
		                choice = 0;  
		            }
		            
		        } while (choice != 4);
		        doc.close();
		    }
		    public static void main(String[] args) {
		    	BankAccount userAccount = new BankAccount(1000.00); 
		    	ATM_INTERFACE atm = new ATM_INTERFACE(userAccount);
		        atm.run();
		    }

	}
		class BankAccount {
		    private double balance;
		    public BankAccount(double openingbalance) {
		        if (openingbalance < 0) {
		            System.out.println("Warning: Initial balance cannot be negative. Setting to 0.");
		            this.balance = 0;
		        } else {
		            this.balance = openingbalance;
		        }
		    }
		    public double getBalance() {
		        return balance;
		    }

		    public void deposit(double amount) {
		        if (amount > 0) {
		            balance += amount;
		            System.out.printf("Deposit successful. New balance: $%.2f", balance);
		        } else {
		            System.out.println("Deposit failed. Amount must be positive.");
		        }
		    }
		    public boolean withdraw(double amount) {
		        if (amount <= 0) {
		            System.out.println("Amount must be a positive number.");
		            return false;
		        }
		        else if (amount > balance) {
		            System.out.printf("Your current balance is $ %.2f, Withdrawal fail!", balance);
		            return false;
		        }
		        else {
		        balance =balance-amount;
		        System.out.printf("New balance: $%.2f, Withdrawal successful!", balance);
		        return true;
		    }
		        }
		}

