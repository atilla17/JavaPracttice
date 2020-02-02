public class CheckingAcount extends Account {
    public  CheckingAcount(int id, double ammount){
        super(id, ammount);
    }

    public String TotString()
    {
        String newStr  = "Basic account, Balance : " + GetBalance() + " \n Monthly intrest rate : " + GetMonthlyIntrestRate()
                +"\n Account was created on " + GetDateCreated();
        return  newStr;
    }

}
