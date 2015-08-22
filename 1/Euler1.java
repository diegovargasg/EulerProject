/***************************************************************************************
@author: Diego Vargas
@Desc: https://projecteuler.net/problem=1

If we list all the natural number below 10 that are multiples of 3 or 5, 
we get 3, 5, 6 and 9; The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.

****************************************************************************************/
import java.util.Calendar;
import java.lang.*;

public class Euler1{

    public static void main(String[] args) {

        Calendar init = Calendar.getInstance();
        System.out.println("\n-- Euler1 --\n\nExecuting... \n\n");

        int sum = 0;

        for (int i = 3; i < 1000; i++) {
            if( i%3 == 0 || i%5 == 0 ){
                sum += i;
            }
        }

        System.out.println(sum+" is the sum of all the multiples of 3 or 5 below 1000");
        Calendar end = Calendar.getInstance();
        long diff = (end.getTimeInMillis() - init.getTimeInMillis())/(1000);
        System.out.println("\n\n Time Execution: "+diff+"Sec.");
    }
}