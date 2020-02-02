package data;

public class Bank {

   public int bankId;
   public double balance;
   public BankLoan[] loans;
   public  double assets;
   public  double loanedValue;

    public Bank(double b, int id, int numLons)
    {
        balance = b;
        bankId = id;
        if(numLons > 0)
        {
            loans = new BankLoan[numLons];
        }
        assets = balance;
        loanedValue = 0;
    }

    public double rawloanValue()
    {
        double sum = 0;
        if(loans != null)
        {
            for(int i = 0 ; i< loans.length; i++)
            {
                sum += loans[i].ammmount;
            }
        }
        return sum;
    }


}
