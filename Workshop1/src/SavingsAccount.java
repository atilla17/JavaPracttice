public class SavingsAccount extends Account {

    public  SavingsAccount(int id, double ammount){
        super(id, ammount);
    }

    public String ToString()
    {
        String newStr  = "Savings account, Balance : " + GetBalance() + " \n Monthly intrest rate : " + GetMonthlyIntrestRate()
                +"\n Account was created on " + GetDateCreated();
        return  newStr;
    }
}
