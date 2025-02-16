import java.util.ArrayList;
import java.util.Scanner;



class Expense {
    String category;
    double amount;
    String description;

    public Expense(String category, double amount, String description) {
        this.category = category;
        this.amount = amount;
        this.description = description;
    }
}

public class ExpenseTracker {
    private ArrayList<Expense> expenses;
    private double totalExpense;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
        totalExpense = 0.0;
    }

    public void addExpense() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter category (e.g., Food, Transportation, etc.): ");
        String category = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        Expense expense = new Expense(category, amount, description);
        expenses.add(expense);
        totalExpense += amount;

        System.out.println("Expense added successfully!");
        scanner.close();
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses added yet!");
        } else {
            System.out.println("Expenses:");
            for (int i = 0; i < expenses.size(); i++) {
                Expense expense = expenses.get(i);
                System.out.println((i + 1) + ". Category: " + expense.category + ", Amount: " + expense.amount + ", Description: " + expense.description);
            }
        }
    }

    public void viewTotalExpense() {
        System.out.println("Total Expense: " + totalExpense);
    }

    public void deleteExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses added yet!");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the expense number to delete: ");
            int expenseNumber = scanner.nextInt() - 1;

            if (expenseNumber >= 0 && expenseNumber < expenses.size()) {
                Expense expense = expenses.get(expenseNumber);
                expenses.remove(expenseNumber);
                totalExpense -= expense.amount;

                System.out.println("Expense deleted successfully!");
            } else {
                System.out.println("Invalid expense number!");
            }
            scanner.close();
        }
    }



    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker();
         Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Expense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    expenseTracker.addExpense();
                    break;
                case 2:
                    expenseTracker.viewExpenses();
                    break;
                case 3:
                    expenseTracker.viewTotalExpense();
                    break;
                case 4:
                    expenseTracker.deleteExpense();
                    break;
                case 5:
                
                    System.out.println("Exiting...");
                    return;
                    
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
                    
            }
          scanner.close();  
        }
        
    }
}



