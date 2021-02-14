import java.util.Scanner;
class bankManagement{
    public static void main(String[] args) {
        int ch,amt;
        Scanner k = new Scanner(System.in);
        bankAccount bk = new bankAccount("Chirag","chi2020");
        do{
        System.out.println("'1' to deposit\n'2' to withdraw\n'3' to check previous Transaction\n'4' to check balance\n'5' to exit");
        ch = k.nextInt();
        switch(ch)
        {
            case 1:
                System.out.println("\nEnter the amount");
                amt = k.nextInt();
                bk.deposit(amt);
                break;
            case 2:
                System.out.println("\nEnter the amount");
                amt = k.nextInt();  
                bk.withdraw(amt);
                break;
            case 3:
                bk.previousTransaction();
                break;
            case 4:
                bk.checkBalance();
                break;
            case 5:
                System.out.println("\nThank You!!! Visit Again");
                break;
        }
    }while(ch!=5);
	
        
    }
}

class bankAccount extends bankManagement{
    int balance=0;
    int previousTransaction;
    String customerName,custmerId;
    bankAccount(String cname,String cid)
    {
        customerName = cname;
        custmerId = cid;
    }
    void deposit(int amount)
    { 
        if (amount != 0)
        {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }
    void withdraw(int amount)
    {
        if (amount != 0)
        {
            balance = balance - amount;
            previousTransaction = -amount;
        }
        
    }
    void previousTransaction()
    {
        if(previousTransaction < 0)
        {
            System.out.println("Cash Withdrawn = "+ (previousTransaction * -1));
        }
        else if(previousTransaction > 0)
        {
            System.out.println("Cash Deposited = " + previousTransaction );
        }
        else{
            System.out.println("No Transaction");
        }
    }
    void checkBalance()
    {
        System.out.println("You have " +"\u20B9"+balance+" in your bank Account" );
    }
}