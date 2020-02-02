import data.Bank;
import data.BankLoan;

import java.util.Scanner;

public class BankChecker {

    int numBanks;
    double assetMin;
    Bank[] myBanks;


    public void ReadBankInfo()
    {
        ReadBankNum();
        ReadMinAssets();
        myBanks = new Bank[numBanks];

        for(int i = 0; i < numBanks; i++)
        {
            double bal;
            int numLoan;
            Scanner in = new Scanner(System.in);
            try {
                System.out.println("Bank " + i + "------------------");
                System.out.print("      Bank#" + i + " Balance:->");
                bal = in.nextDouble();
                System.out.print("     Number of loanes:->");
                numLoan = in.nextInt();
                myBanks[i] = new Bank(bal, i, numLoan);
            }
            catch (Exception e)
            {
                System.out.println("Error in bank info please re enter");
                i--;
                continue;
            }
            for(int x = 0; x < numLoan; x++ )
            {
                Boolean err =false;
                try {
                    System.out.println("  Loan " + x + "----------");
                    System.out.print("     Loan to<id>:->");
                    int borowerId = in.nextInt();
                    System.out.print("     Loan Ammount:->");
                    double loanAmt = in.nextDouble();

                    //check for errors
                    if (borowerId == i) {
                        System.out.println("Bank cannot loan to itself please re enter loan info");
                        x--;
                        continue;
                    }
                    if (borowerId >= numBanks || borowerId < 0) {
                        System.out.println("Bank ID invalid please re enter loan info");
                        x--;
                        continue;
                    }
                   // if (loanAmt > bal) {
                     //   System.out.println("Bank cannot loan more then it owns please re enter loan info");
                       // x--;
                        //continue;
                    //}
                    myBanks[i].loans[x] = new BankLoan(i, borowerId, loanAmt);

                }
                catch (Exception e)
                {
                    System.out.println("Error in loan info please re enter loan info");
                    err = true;

                }
                if(err == true) {
                    x--;
                    continue;
                }
            }

        }
        FindUnsafeBanks();
    }

    private void ReadBank()
    {
        System.out.print("Number of banks: ->");
        Scanner in = new Scanner(System.in);
        numBanks = in.nextInt();
    }

    private  void  ReadBankNum()
    {
        try {
            System.out.print("Number of banks: ->");
            Scanner in = new Scanner(System.in);
            numBanks = in.nextInt();
        }
        catch (Exception e)
        {
            System.out.println("Not a number");
            ReadBankNum();
        }

        if(numBanks < 2)
        {
            System.out.println("Enter a number greater then one");
            ReadBankNum();
            return;
        }

    }
    private void ReadMinAssets ()
    {
        try {
            System.out.print("MinimumAssets: ->");

            Scanner in = new Scanner(System.in);

            assetMin = in.nextDouble();
        }
        catch (Exception e)
        {
            System.out.println("Not a number");
            ReadMinAssets();
        }
    }

    private  void declareUnsafeBank(int id)
    {
        for(int i = 0 ; i < myBanks.length; i++)
        {
            if(myBanks[i].loans != null)
            {
                for(int l = 0; l < myBanks[i].loans.length; l++)
                {
                    if(myBanks[i].loans[l].borowoerId == id)
                    {
                        myBanks[i].loanedValue -= myBanks[i].loans[l].ammmount;
                        System.out.println("*** Bank " + i + " dropped a loan worth " + myBanks[i].loans[l].ammmount);
                    }
                }
            }
        }
    }
    private void FindUnsafeBanks()
    {
        //Set asset values
        for(int i = 0; i < myBanks.length; i++)
        {
            if(myBanks[i].loans.length >= 1 && myBanks[i].loans != null)
            {
                //add loans to my assets
                for(int x = 0; x < myBanks[i].loans.length; x++)
                {
                    myBanks[i].loanedValue = myBanks[i].loanedValue + myBanks[i].loans[x].ammmount;
                }

                //if I am unsafe then remove my debt from other banks assets
                if(myBanks[i].balance + myBanks[i].rawloanValue() < assetMin)
                {
                    System.out.println("Bank " + i + "'s loans cannot be re paid");
                    declareUnsafeBank(i);
                }
            }
        }

        //final check for unsafe banks
        for(int f = 0; f < myBanks.length; f++)
        {
            if(myBanks[f].balance + myBanks[f].loanedValue < assetMin)
            {
                System.out.println("Bank " + f + " is unsafe\nAssets: " + myBanks[f].balance +"\nLoan value: " + myBanks[f].loanedValue + "\nTotal amount loaned + " + myBanks[f].rawloanValue());
            }
            else
            {
                System.out.println("Bank " + f + " is safe\nAssets: " + myBanks[f].balance +"\nLoan value: " + myBanks[f].loanedValue + "\nTotal amount loaned + " + myBanks[f].rawloanValue());
            }
        }
    }





}
