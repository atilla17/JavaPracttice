import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Account {

    private  int id;
    private  double balance;
    private  double annualIntrestRate;
    private Date dateCreated;

    public Account()
    {
        id = 0;
        balance = 0;
        annualIntrestRate = 0;
        dateCreated = new Date();
    }
    public Account(int id_, double initBal)
    {
        this();
        id = id_;
        balance = initBal;
        annualIntrestRate = 0;
        //dateCreated = new Date();
    }

    public int GetId()
    {
        return id;
    }
    public void SetId(int id_)
    {
        id = id_;
    }
    public double GetBalance()
    {
        return balance;
    }
    public void SetBalance(double balance_)
    {
        balance = balance_;
    }

    public double GetAnualIntrestRate()
    {
        return annualIntrestRate;
    }

    public  void SetAnualIntrestRate(double AIR)
    {
        annualIntrestRate = AIR;
    }
    public  Date GetDateCreated()
    {
        return dateCreated;
    }

    public void Withdraw(double amount)
    {
        balance -= amount;
    }
    public void Desposite(double amount)
    {
        balance += amount;
    }
    public  double GetMonthlyIntrest()
    {
        return  balance * (annualIntrestRate / 12) ;
    }
    public  double GetMonthlyIntrestRate()
    {
        return  balance * ((annualIntrestRate / 12) * 0.1) ;
    }

    public String ToString()
    {
        String newStr  = "Basic account, Balance : " + GetBalance() + " \n Monthly intrest rate : " + GetMonthlyIntrestRate()
                +"\n Account was created on " + GetDateCreated();
        return  newStr;
    }

}
