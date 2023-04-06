import java.util.*;
class Atm
{
    public static HashMap<Integer,ArrayList<String>>cd = new HashMap<Integer,ArrayList<String>>();
    public static ArrayList<ArrayList<String>>transaction = new ArrayList<ArrayList<String>>();
    public static void main(String[] args)
    {
        Scanner obj = new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter Your Choice: /n1. Customer Login/n2. Exit");
            int choice = obj.nextInt();
            switch(choice)
            {
                case 1:
                    CustomerLogin();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                System.out.println("Invalid Choice!");        
            }
        }
    }
    public static void CustomerLogin()
    {
        ArrayList<String> details = new ArrayList<>();
        details.add("0909");
        details.add("surabhi");
        details.add("20000");
        cd.put(789654,details);
        Scanner obj = new Scanner(System.in);
        System.out.println("Please Enter Credit Card Details :");
        int cnumber = obj.nextInt();
        System.out.println("Please Enter Your PIN");
        int pin  = obj.nextInt();
        String pin1 = String.valueOf(pin);
        if(cd.containsKey(cnumber))
        {
            if(pin1.equals((cd.get(cnumber).get(0))))
            {
                System.out.println("WELCOME"+(cd.get(cnumber).get(1)));
                Transaction(cnumber);
            }
            else
            {
                System.out.println("Enter Correct Pin!");
            }
        }
        else
        {
            System.out.println("Enter Valid Card Details!!");
        }

    }
    public static void Transaction(int cnumber)
    {
        Scanner obj = new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter Your Choice: \n1. Check Balance\n2. Withdraw Money\n3. Deposit Money\n4. Transfer Money\n5. Statement");
            int choice = obj.nextInt();
            switch(choice)
            {
                case 1:
                    enquiry(cnumber);
                    break;
                case 2:
                    CashWithDraw(cnumber);
                    break;
                case 3:
                    Deposit(cnumber);
                    break;
                case 4:
                    Transfer(cnumber);
                    break;
                case 5:
                    Statement(cnumber);
                    break;
                case 6:
                    System.out.println("Thank You for banking with us!!");
                    System.exit(0);
                    break;
                default:
                System.out.println("Invalid Choice!!");
            }
        }
    }
    public static void enquiry(int cnumber)
    {
        System.out.println("Your Current Balance is:"+cd.get(cnumber).get(2));
    }

    public static void CashWithDraw(int cnumber)
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Please Enter Amount");
        int cash = obj.nextInt();
        if(cash <= Integer.parseInt(cd.get(cnumber).get(2)))
        {
            System.out.println("Please wait while we process.");
            String amount = cd.get(cnumber).get(2);
            int amount1 = Integer.parseInt(amount);
            amount1 -= cash;
            amount = String.valueOf(amount1);
            ArrayList<String> details = cd.get(cnumber);
            details.set(2, amount);
            cd.put(cnumber, details);
            ArrayList<String> transactionDetails = new ArrayList<>();
            transactionDetails.add(String.valueOf(cnumber));
            transactionDetails.add("Withdraw");
            transactionDetails.add(String.valueOf(cash));
            transaction.add(transactionDetails);
            System.out.println("Your current Balance is:"+cd.get(cnumber).get(2));
        }
        else
        {
            System.out.println("Insufficient Funds!!");
        }
    }

    public static void Deposit(int cnumber)
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Amount");
        int cash = obj.nextInt();
        System.out.println("Amount Successfully Deposited and Balance Revised!");
            String amount = cd.get(cnumber).get(2);
            int amount1 = Integer.parseInt(amount);
            amount1 += cash;
            ArrayList<String> details = cd.get(cnumber);
            details.set(2, amount);
            cd.put(cnumber, details);
            ArrayList<String> transactionDetails = new ArrayList<>();
            transactionDetails.add(String.valueOf(cnumber));
            transactionDetails.add("Deposit");
            transactionDetails.add(String.valueOf(cash));
            transaction.add(transactionDetails);
            System.out.println("Your Current Balance is:"+cd.get(cnumber).get(2));
    }
    public static void Statement(int cnumber)
    {
        for(ArrayList<String> i:transaction)
        {
            if(Integer.parseInt(i.get(0)) == cnumber)
            {
                for(String j:i)
                {
                    System.out.println(j+" ");
                }
                System.out.println();
            }
        }
    }

    public static void Transfer(int cnumber)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account Number of ");
        int acc1 = sc.nextInt();
        System.out.println("Enter Transfer Amount");
        int cash = sc.nextInt();
        if(cash <= Integer.parseInt(cd.get(cnumber).get(2)))
        {
            System.out.println("A sum of Rs. " +cash+" has been transfered to " +acc1+ " successfully!");
            String amount = cd.get(cnumber).get(2);
            int amount1 = Integer.parseInt(amount);
            amount1 -= cash;
            amount = String.valueOf(amount1);
            ArrayList<String> details = cd.get(cnumber);
            details.set(2, amount);
            cd.put(cnumber, details);
            ArrayList<String> transactionDetails = new ArrayList<>();
            transactionDetails.add(String.valueOf(cnumber));
            transactionDetails.add("Transfer");
            transactionDetails.add(String.valueOf(cash));
            transaction.add(transactionDetails);
            System.out.println("Current Balance Amount = " +cd.get(cnumber).get(2));
        }
        else
        {
            System.out.println("Insufficient Balance!");
        }
    }

}