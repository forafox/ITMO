package lab1;

import java.util.Random;

public class Launcher {
    public static double rnd( double min, double max){
        double x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }
    public static void main(String[] args){
        double min=-5.0,max=9.0;
        int flag=0;
        int [] Supply= new int[] {1,4,6,7,9,10,11,12};// Для сверки потом
        long [] n = new long[17]; //Объявляем массив

        for (int j=16;j>=1;j--){
            n[j]=j;
        }

        double [] x = new double[21];

        for(int j=1;j<=20;j++){
            x[j]=rnd(min,max);
        }

        double [][] c =new double[16][20];

        for(int i=0;i<16;i++){
            for(int j=0;j<20;j++) {
                flag=0;
                double mark = x[j];
                if (n[i] == 16) {
                    c[i][j] = Math.tan((Math.cos(mark) + Math.PI) / (Math.pow(Math.E, mark)));
                    flag+=1;
                }
                for (int k = 0; k < 8; k++)
                    if (n[i] == Supply[k]) {
                        c[i][j] = Math.asin(1 / (Math.pow(Math.E, (Math.pow((2 * (Math.pow(Math.sin(mark), 2))), 2)))));
                        flag+=1;
                    }
                if(flag==0)
                    c[i][j]=Math.log10(Math.pow(Math.sin(Math.pow(Math.pow(Math.E,Math.pow((mark*(mark+1)),3)),((Math.log10(Math.pow(Math.sin(mark),2)))/(Math.cbrt(Math.pow((mark*(Math.PI+mark)),mark))-0.5)))),2));
            }
        }
        for(int i=0;i<16;i++) {
            for (int j = 0; j < 20; j++)
                System.out.printf(" %9.3f ",c[i][j]);
        System.out.println(" ");
        }
    }
}
