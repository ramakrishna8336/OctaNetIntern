package MiniProject;
import java.util.*;
public class Task1 {
	private static final String USER_ID = "15112023"; // predefined user id
    private static final String USER_PIN = "2000"; // predefined user pin
    private double balance; // current balance

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task1 atm = new Task1();
        Scanner scanner = new Scanner(System.in);

        System.out.println("****Welcome to the SBI ATM****");

     
        System.out.print("Enter user id: ");
        String userId = scanner.nextLine();

        System.out.print("Enter user pin: ");	
        String userPin = scanner.nextLine();
        

        if (!userId.equals(USER_ID) || !userPin.equals(USER_PIN)) {
            System.out.println("Invalid user id or pin. Exiting...");
            return;
        }

        // user, show menu
        while (true) {
            System.out.println("PLease Select from ATM Menu:");
            System.out.println("1. View Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    atm.TransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter Amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter Amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter Amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    System.out.print("Enter recipient's account number: ");
                    String recipient = scanner.next();
                    atm.transfer(transferAmount, recipient);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
	
	private List<String>transactionHistory = new ArrayList<>();
	public void TransactionHistory() {
		if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transactionHistory);
            }
        }
    }
	
	private void recordTransaction(String transaction) {
    	transactionHistory.add(transaction);
    }

    public void withdraw(double Amount) {
        if (balance >= Amount) {
            balance -= Amount;
            recordTransaction("Withdrawal: -₹" + Amount);
            System.out.println("₹" + Amount + " withdrawn successfully.");
            System.out.println("New balance: ₹" + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void deposit(double Amount) {
        balance += Amount;
        recordTransaction("Deposit: +₹" + Amount);
        System.out.println("₹" + Amount + " deposited successfully.");
        System.out.println("New balance: ₹" + balance);
    }

    public void transfer(double Amount, String recipient) {
        if (balance >= Amount) {
            balance -= Amount;
            recordTransaction("Transfer to " + recipient + ": -₹" + Amount);
            System.out.println("₹" + Amount + " transferred to account " + recipient + " successfully.");
            System.out.println("New balance: ₹" + balance);
        } else {
            System.out.println("Insufficient funds.");
        }

	}
    


	}


