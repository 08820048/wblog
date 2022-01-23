package com.waer.wblog;

import java.util.Arrays;

/**
 * @author: Tisox
 * @date: 2021/12/10 20:59
 * @description:
 * @blog:tisox.waer.ltd
 */
public class kmp  {
    public static void main(String[] args) {
        String str = "ababa";
        String subString = "aba";
        char [] arr = new char[] {'a', 'b','a','a','b','e'};
//        char [] arr1 = new char[] {'a', 'b','c'};
        String subString1 = "abc";
        kmp k = new kmp();
//        int res = hasSubstring(str.toCharArray(), subString.toCharArray());
//        System.out.println("BF:"+res);
        int[] next1 = next1(arr);
        for (int i : next1) {
            System.out.println("next:"+ Arrays.toString(next1));
        }
//        int result = k.match(str.toCharArray(), subString.toCharArray());
//        System.out.print("KMP:"+result);
    }
    private static  int[] next(char pattern[]){
        int[] next_value = new int[pattern.length];
        int j=0;
        for(int i=1;i<pattern.length;){
            if(pattern[i] == pattern[j]){
                next_value[i] = j+1;
                j++;
                i++;
            }else{
                if(j!=0){
                    j = next_value[j-1];
                }else{
                    next_value[i] =0;
                    i++;
                }
            }
        }
        return next_value;
    }

    public int match(char[] text,char[]pattern){
        int next[] = next(pattern);
        int i=0;
        int j=0;
        while(i<text.length && j<pattern.length){
            if(text[i]==pattern[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = next[j-1];
                }else{
                    i++;
                }
            }
        }
        if(j==pattern.length){
            return i-j+1;
        }else{
            return -1;
        }
    }
    public static int hasSubstring(char[] text, char[] pattern){
        int i=0;
        int j=0;
        int k = 0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                j=0;
                k++;
                i = k;
            }
        }
        if(j == pattern.length){
            return i-j+1;
            //return true;
        }
        return -1;
    }
    public static int[]next1(char p[]){
        int j=1,k=0;
        int[] next_value = new int[p.length];
        next_value[1] =0;
        while(j<p.length-1)
        {
            if(k==0 || p[j]==p[k]){
                next_value[++j] = ++k;
            }else{
                k = next_value[k];
            }
        }
        return next_value;
    }
}
