/***************************************************************************************
@author: Diego Vargas
@Desc: https://projecteuler.net/problem=206

Find the unique positive integer whose square has the form 1_2_3_4_5_6_7_8_9_0,
where each “_” is a single digit.

****************************************************************************************/

public class Euler206{

    //Min and Max number whose square has the form 1_2_3_4_5_6_7_8_9_0
    static long min = 1010101030L;
    static long max = 1389026623L;


    // Only the numbers ended with 30 and 70 will match the latest 3 digits of the form
    public static void main(String[] args) {

        for(long i = min; i < max; i = i+100 ){

            // calculates the square for the number ended in 30
            long result = i * i;

            // Transforms the square to a array of strings
            String[] txtResult = Long.toString(result).split("");
            String finalResult = "";

            // Extracts the odd digits from the string
            for (int j = 0; j < txtResult.length; j++){
                if( j%2 != 0 ){
                    finalResult += txtResult[j];
                }
            }

            // Compares the obtained string with the form and breaks the loop
            if( finalResult.equals("1234567890") ){
                System.out.println("Result: "+i);
                break;
            }

            // calculates the square for the number ended in 70
            i += 40;
            result = i * i;
            // Resets finalResult variable
            finalResult = "";

            // Transforms the square to a array of strings
            txtResult = Long.toString(result).split("");

            // Extracts the odd digits from the string
            for (int j = 0; j<txtResult.length; j++){
                if( j%2 != 0 ){
                    finalResult += txtResult[j];
                }
            }

            // Compares the obtained string with the form and breaks the loop
            if( finalResult.equals("1234567890") ){
                System.out.println("Result: "+i);
                break;
            }

            // resets the counter if neither of them match the form
            i-=40;
        }
    }
}