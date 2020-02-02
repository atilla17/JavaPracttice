import com.sun.deploy.util.StringUtils;
import javafx.application.Application;

import java.util.Scanner;

public class Location {

    double[][] grid_;
    static int row_;
    static int col_;
    static Double max_;

    int myRow;
    int myCol;
    Double myMax;

    public Location(int r, int c, Double m, double[][] d)
    {
        myRow = r;
        myCol = c;
        myMax = m;
        grid_ = d;
    }

    public static Location locateLargest(double[][] data)
    {
        for(int x = 0; x < data.length; x++){
            if(max_ == null)
            {
              max_ = data[0][0];
            }
            System.out.println("row " + x);
            for(int y = 0; y < data[x].length; y++)
            {
                System.out.println("    col " + y + ' ' + data[x][y]);
                if(data[x][y] > max_) {
                    max_ = data[x][y];
                    row_ = x;
                    col_ = y;
                }
            }

        }
        System.out.println("MAX VALUE: " + max_ +" Location: " + row_ + " : " + col_);
        return new Location(row_, col_, max_, data);
    }

    //Unused code
    String[] SSplit(String target, char del)
    {
        int size = 0;
        for(int i = 0; i< target.length(); i++)
        {
            if(target.charAt(i) == del)
            {
                size++;

            }
        }
        String[] newStr = new String[size];
        int[] s = new int[size];
        int[] e = new int[size];
        int sIndex = 0;

        int sPoint = 0;
        int ePoint = 0;

        boolean cycle = false;
        for(int x = 0; x < target.length(); x++)
        {
            if(!cycle)
            {
                sPoint = x;
                cycle = true;
            }
            if(target.charAt(x) == del)
            {
                cycle = false;
                ePoint = x;
                s[sIndex] = sPoint;
                e[sIndex] = ePoint;
                sIndex++;
            }
        }
        for(int y = 0; y < size;y++)
        {
            newStr[y] = target.substring(s[y], e[y]);
            System.out.println(target.substring(s[y], e[y]));

        }
        return newStr;

    }
}
