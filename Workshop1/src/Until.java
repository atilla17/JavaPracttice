import java.util.Scanner;

public class Until {

    private static int[] ReadArraySize()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter rows and columbs <row><,><col>:  ");
        String input = System.in.toString();
        String[] inputs;
        try {
            do {
                input = in.next();
                inputs = input.split(",");
                if (inputs.length != 2) {
                    System.out.println("Error - length : " + inputs.length + " : enter Exactly two values");
                }
            } while (inputs.length != 2);
            int[] dims = new int[2];
            dims[0] = Integer.parseInt(inputs[0]);
            dims[1] = Integer.parseInt(inputs[1]);
            System.out.println("Accepted.");
            //in.close();
            return dims;
        }
        catch(Exception e)
        {
            System.out.println("Invalid characters were added please try again");
            return ReadArraySize();
        }

    }


    private static String[] GetRow(int cols )
    {
        try {
            Scanner in = new Scanner(System.in);
            String input = System.in.toString();
            String[] inputs;

            input = in.next();
            inputs = input.split(",");
            if (inputs.length != cols) {
                System.out.println("Error - length : " + inputs.length + " : enter exactly " + cols + " values");
            }
            for (int i = 0; i < inputs.length; i++) {
                Double a = Double.parseDouble(inputs[i]);
                if(a.isNaN())
                {
                    System.out.println("Invalid character entered");
                    return  GetRow(cols);
                }
            }
            return inputs;
        }
        catch (Exception e)
        {
            System.out.println("Invalid character entered");
            return  GetRow(cols);
        }
    }
    public static double[][] ReadDataFromUser()
    {
        //get the rows and cols from the user
        Scanner in = new Scanner(System.in);
        System.out.print("Enter rows and columbs <row><,><col>:  ");
        String input = System.in.toString();
        String[] inputs;

        int[] dims = ReadArraySize();
        int rows = dims[0];
        int cols = dims[1];

        double[][] grid_ = new double[rows][cols];

        System.out.println("Grid is r: " + grid_.length + " c: " + grid_[0].length);
        for(int i = 0; i < rows; i++)
        {
            System.out.println("Enter " + cols + " number(s) for row " + i);
            do{
                inputs = GetRow(cols);
            }while (inputs.length != cols);
            for(int j = 0; j< inputs.length;j++)
            {
                double num = Double.parseDouble(inputs[j]);
                grid_[i][j] = num;
                //System.out.println("grid_[" + i +"][" + j +"]" +" = " + num);
            }
            System.out.println("Accepted.." + (i+1) +"/"+rows);
        }
        return grid_;
    }
}
