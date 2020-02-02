
import java.util.Scanner;

public class ATM {

    Account[] accounts;

    Account currentlySelected;


    public void Init()
    {
        accounts = new Account[10];
        for(int i = 0; i < accounts.length; i++)
        {
            accounts[i] = new Account(i, 100);
        }

        MainMenu();
    }

    private void MainMenu()
    {
        try {
        System.out.println("EnterID your account id: ");
        Scanner in = new Scanner(System.in);
        int selection = in.nextInt();

            currentlySelected = accounts[selection];
        }
        catch (Exception e)
        {
            System.out.println("Invalid Account id");
            MainMenu();
        }

        Options();

    }


    private void Options()
    {
        try {

            System.out.println("Main menu");
            System.out.println("1.Check balance");
            System.out.println("2.withdraw");
            System.out.println("3.deposit");
            System.out.println("4.exit");

            Scanner in = new Scanner(System.in);
            int selection = in.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("The current balance is " + currentlySelected.GetBalance());
                    Options();
                    break;
                case 2:
                    Withdraw();
                    break;
                case 3:
                    Deposite();
                    break;
                case 4:
                    MainMenu();
                    break;
                default:
                    System.out.println("Invalid selection");
                    Options();
            }
        }
        catch (Exception e)
        {
            System.out.println("Invalid selection");
            Options();
        }
    }
    void Withdraw()
    {
        try {

        System.out.println("enter an amount to withdraw: ");
        Scanner in = new Scanner(System.in);
        double ammount = in.nextDouble();


            currentlySelected.Withdraw(ammount);
        }
        catch (Exception e){
            System.out.println("Invalid amount entered");
            Options();
        }

        System.out.println("The current balance is " + currentlySelected.GetBalance());
        Options();

    }
    void Deposite()
    {
        System.out.println("enter an amount to deposite: ");
        Scanner in = new Scanner(System.in);
        double ammount = in.nextDouble();

        try {
            currentlySelected.Desposite(ammount);
        }
        catch (Exception e){
            System.out.println("Invalid amount entered");
            Options();
        }

        System.out.println("The current balance is " + currentlySelected.GetBalance());

        Options();
    }

}
