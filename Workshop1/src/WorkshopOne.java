import java.util.Scanner;

public class WorkshopOne {

    public static void main(String[] args)
    {
        //Location myLocation = myLocation = Location.locateLargest(Until.ReadDataFromUser());

        //Task2Test();
        //Task3Test();
        //Task4Test();

        SelectTask();
    }


    private static  void SelectTask()
    {
        System.out.println("Task selection");
        System.out.println("1.task 1");
        System.out.println("2.task 2");
        System.out.println("3.task 3");
        System.out.println("4.task 4");
        Scanner in = new Scanner(System.in);
        int selection = in.nextInt();

        switch (selection)
        {
            case 1:
                Task1Test();
                break;
            case 2:
                Task2Test();
                break;
            case 3:
                Task3Test();
                break;
            case 4:
                Task4Test();
                break;
            default:
                System.out.println("Invalid selection");
                SelectTask();
        }
    }

    private  static  void Task1Test()
    {
        Location myLocation = myLocation = Location.locateLargest(Until.ReadDataFromUser());
    }

    private static void Task2Test()
    {
        Account myAccount = new Account(1122, 20000.00);
        myAccount.SetAnualIntrestRate(4.5);
        myAccount.Withdraw(2500);
        myAccount.Desposite(3000);
        System.out.println("Balance : " + myAccount.GetBalance() + " \n Monthly intrest rate : " + myAccount.GetMonthlyIntrestRate());
        System.out.println("Account was created on " + myAccount.GetDateCreated());
    }

    private static void Task3Test()
    {
        ATM atm = new  ATM();
        atm.Init();
    }

    private  static void Task4Test()
    {
        Account normal = new Account(1,8);
        SavingsAccount sav = new SavingsAccount(2, 100);
        CheckingAcount chk = new CheckingAcount(11, 300);

       //4
        System.out.println(normal.ToString());
        System.out.println(sav.ToString());
        System.out.println(chk.ToString());

    }
}
