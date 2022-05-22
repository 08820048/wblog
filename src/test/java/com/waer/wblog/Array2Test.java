package com.waer.wblog;

/**
 * @author: Tisox
 * @date: 2021/12/3 10:14
 * @description:
 * @blog:tisox.waer.ltd
 */
public class Array2Test {
    public static void main(String[] args) {
        int [][] a = new int[4][4];
        a[0][0] = 1;
        a[0][1] = 2;
        a[0][2] = 8;
        a[0][3] = 9;

        a[1][0] = 2;
        a[1][1] = 4;
        a[1][2] = 9;
        a[1][3] = 12;

        a[2][0] = 4;
        a[2][1] = 7;
        a[2][2] = 10;
        a[2][3] = 13;

        a[3][0] = 6;
        a[3][1] = 8;
        a[3][2] = 11;
        a[3][3] = 15;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+" |");
            }
            System.out.println();
        }
        for (int k=0;k<a.length;k++)
        {
           // System.out.println("********"+a[0][3]);
            //System.out.println("********"+a[0][2]);
            System.out.println("********"+a[2][1]);
            //System.out.println("********"+a[0][1]);
        }
    }
}
