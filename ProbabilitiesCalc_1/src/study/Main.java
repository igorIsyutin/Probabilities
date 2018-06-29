package study;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) {
        calculate(1000);
    }

    private static float getPercentage(int n, int total){
        float res = (float)n/total;
        return res*100;
    }

    private static void calculate(int trials){
        //massive of amount of fallout
        int[] res = new int[]{0,0,0,0,0,0};
        //make trials and save result
        for (int i=0; i<trials; i++){
            res[ThreadLocalRandom.current().nextInt(6)]++;
        }
        //calculations for each face
        for (int i=0; i<res.length; i++){
            System.out.println(i+1 + " : " + res[i] + " times;");
            //Actual = amount of fallout/number of attempts
            float actual = getPercentage(res[i], trials);
            //Expected = always 1/6 for six-sided die
            float expected = getPercentage(1,6);
            System.out.println("Actual percentage: " + df.format(actual) + "%");
            System.out.println("Expected percentage: " + df.format(expected) + "%");
            //Margin = difference module of the expected and actual value
            System.out.println("Margin: " + df.format(Math.abs(actual-expected)) + "%");
        }
    }
}
