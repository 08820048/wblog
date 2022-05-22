package com.waer.wblog;

import java.util.Arrays;


/**
 * @author: Tisox
 * @date: 2021/12/11 20:02
 * @description:
 * @blog:tisox.waer.ltd
 */
public class kmptest {
    public static void main(String[] args) {
        String text = "ababa";
        String pattern = "aba";
        int[] next = next(pattern);
        System.out.println("ne:"+ Arrays.toString(next));
        int kmp = kmp(text, pattern, next);
        System.out.println("ans:"+kmp);
    }
    //next数组
    public static int[] next(String pattern){
        int[] ne = new int[pattern.length()];
        int j=0;
        //int i = 1;
        for(int i=1;i<ne.length;){
            if(pattern.charAt(i)==pattern.charAt(j)){
                ne[i] = j+1;
                j++;
                i++;
            }else{
                if(j!=0){
                    j = ne[j-1];
                }else{
                    ne[i] = 0;
                    i++;
                }
            }
        }
        return ne;
    }

    //KMP算法
    static int kmp(String text,String pattern,int[] next){
        int j=0;
        int i=0;
        while(i<text.length() && j<pattern.length()){
            if(text.charAt(i)==pattern.charAt(j)){
                j++;
                i++;
            }else{
                if(j!=0){
                    j = next[j-1];
                }else{
                    i++;
                }
            }
        }
        if(j==pattern.length()){
            return i-j+1;
        }else{
            return -1;
        }
    }
}
