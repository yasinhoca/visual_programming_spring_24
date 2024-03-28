package odev8;

import java.util.Random;

public class Matris {

    static int[][] uret(int r,int c){
        int[][] m = new int[r][c];
        Random rast = new Random();

        int i,j;
        for(i=0;i<r;i++){
            for(j=0;j<c;j++){
                m[i][j] = rast.nextInt(40)+10;
            }
        }

        return m;

    }


}
