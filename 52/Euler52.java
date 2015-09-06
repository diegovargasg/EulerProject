/***************************************************************************************
@author: Diego Vargas
@Desc: https://projecteuler.net/problem=52

It can be seen that the number, 125874, and it's double, 251748, 
contain exactly the same digits, but in a different order.
Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.

****************************************************************************************/
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.lang.*;

public class Euler52{

    public static void main( String[] args ) {

        Calendar init = Calendar.getInstance();
        System.out.println("\n-- Euler12 --\n\nExecuting... \n\n");

        Integer i = 1;
        boolean run = true;

        while( run ){

            int minL = String.valueOf( i*2 ).length();
            int maxL = String.valueOf( i*6 ).length();
            ArrayList mainArray[] = new ArrayList[7];

            // We only proceed when the numbers have the same lenght
            if( minL == maxL ){

                ArrayList<Integer> prevArray = new ArrayList<Integer>();

                for( int j = 2; j <= 6; j++ ){

                    boolean flagContinue = true;
                    String intString = Integer.toString(i*j);
                    ArrayList<Integer> cArray = new ArrayList<Integer>();

                    // Verify whether each number contains the same digits
                    for( int z = 0; z < intString.length(); z++ ){
                        char b =  intString.charAt(z);
                        int t = b - '0';
                        cArray.add(t);

                        if( prevArray.size() != 0 && flagContinue == true ){
                            flagContinue = prevArray.contains( t );
                        }
                    }

                    // Discard counting duplicates
                    if( prevArray.size() != 0 ){
                        for( int k = 0; k < cArray.size(); k++ ){
                            int cOcurrences = Collections.frequency( cArray, ( cArray.get(k) ) );
                            int pOcurrences = Collections.frequency( prevArray, ( cArray.get(k) ) );

                            if( cOcurrences != pOcurrences ){
                                flagContinue = false;
                                break;
                            }
                        }    
                    }

                    // We break the loop if the validation fails
                    if( !flagContinue ){
                        prevArray.clear();
                        break;
                    }

                    prevArray = cArray;

                    // Verifies we've reached the expected number of iterations.
                    if( j > 5 ){
                        System.out.println( "Result: "+i+" \n");
                        System.out.println( "******\n");
                        run = false;
                    }
                }
            }
            i++;
        }

        Calendar end = Calendar.getInstance();
        long diff = (end.getTimeInMillis() - init.getTimeInMillis())/(1000);
        System.out.println("\n\n Time Execution: "+diff+"Sec.");
    }
}