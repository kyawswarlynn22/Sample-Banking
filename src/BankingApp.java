import java.util.Scanner;


class BankDetails {
    private String account_no;
    private String name;
    private String account_type;
    private long balance;
    private String password;

    Scanner sc = new Scanner(System.in);

    public void OpenAccount() {
        System.out.println("Enter Account No: ");
        account_no = sc.next();
        System.out.println("Enter Account Type: ");
        account_type = sc.next();
        System.out.println("Enter Name: ");
        name = sc.next();
        System.out.println("Enter Balance: ");
        balance = sc.nextLong();
        System.out.println("Enter account password: ");
        password = sc.next();
    }

    public void ShowAccount() {
        System.out.println("Name of account holder: " + name);
        System.out.println("Account No.: " + account_no);
        System.out.println("Account Type: " + account_type);
        System.out.println("Balance: " + balance);
    }

    public void deposit() {
        long amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextLong();
        balance += amt;
    }

    public void Withdrawal() {
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextLong();
        if (balance >= amt) {
            balance -= amt;
            System.out.println("Balance after withdrawal: " + balance);
        }else {
            System.out.println("Your balance is less than " + amt + "\tTransaction Failed...!!");
        }
    }

    public boolean AccountSearch(String acc_no) {
        if (account_no.equals(acc_no)) {
            return (true);
        }
        return (false);
    }

    public boolean CheckPassword() {
        String pw;
        System.out.println("Enter your account password: ");
        pw = sc.next();
        if (password.equals(pw)){
            return (true);
        }else {
            return (false);
        }
    }
}


public class BankingApp {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("How Many number of customers do you want to create?");
        int n = sc.nextInt();

        BankDetails C[] = new BankDetails[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new BankDetails();
            C[i].OpenAccount();
        }

        int choice;

        do {
            System.out.println("\n  *** Banking System Application ***");
            System.out.println("1. Display all account details \n 2. Search by Account number \n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Exit ");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    for (int i = 0; i < C.length; i++) {
                        C[i].ShowAccount();
                    }
                    break;

                case 2:
                    System.out.println("Enter account no. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].AccountSearch(ac_no);
                        if (found){
                            if (C[i].CheckPassword()){
                                C[i].ShowAccount();
                                break;
                            }else {
                                System.out.println("Password incorrect...!!");
                                break;
                            }
                        }
                    }
                    if (!found){
                        System.out.println("Search failed! Account doesn't exist...!!");
                    }
                    break;

                case 3:
                    System.out.println("Enter Account No. :");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].AccountSearch(ac_no);
                        if (found) {
                            if (C[i].CheckPassword()) {
                                C[i].deposit();
                                break;
                            } else {
                                System.out.println("Password incorrect...!!");
                                break;
                            }
                        }
                    }
                    if (!found){
                        System.out.println("Search failed! Account doesn't exist...!!");
                    }
                    break;

                case 4:
                    System.out.println("Enter Account No. :");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].AccountSearch(ac_no);
                        if (found) {
                            if (C[i].CheckPassword()) {
                                C[i].Withdrawal();
                                break;
                            } else {
                                System.out.println("Password incorrect...!!");
                                break;
                            }
                        }
                    }
                    if (!found){
                        System.out.println("Search failed! Account doesn't exist...!!");
                    }
                    break;
            }
        }
        while (choice != 5);

    }
}

