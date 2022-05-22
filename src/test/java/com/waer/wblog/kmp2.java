package com.waer.wblog;

import java.util.Arrays;

/**
 * @author: Tisox
 * @date: 2021/12/11 11:19
 * @description:
 * @blog:tisox.waer.ltd
 */
public class kmp2 {
    public static void main(String[] args) {
        /*模板串*/
        //String str2 = "jNNNNjNNNN";
        String str = "ababa";
        String subString = "abaabe";
       // String str = "ababa";
        /*模式串*/
     //   String str1 = "jNNPw9NNNNnNMANTNHGNjNNNNjNNNN";

        int[] nextValue = nextValue1(subString);
        System.out.println("next:"+ Arrays.toString(nextValue));

        int index = Match(str,subString,nextValue);
        System.out.println("index=="+index);
    }

    /**
     * 计算数组的next值
     * @param tags
     * @return next值
     */
    private static  int [] nextValue(String tags){
        int[] next = new int[tags.length()];
        //特判
        next[0] = 0;
        for(int i=1,j=0;i<tags.length(); i++){
            while(j>0 && tags.charAt(i)!=tags.charAt(j)){
                j = next[j-1];
            }
            if(tags.charAt(i)==tags.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    private static int Match(String str1,String str2,int [] nextValue){
        for(int i=0,j=0;i<str1.length();i++){
            while(j>0 && str1.charAt(i)!=str2.charAt(j)){
                j = nextValue[j-1];
            }
            if(str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if(j==str2.length()){
                j = nextValue[j-1];
                return  i-j+1;
            }
        }
        return -1;
    }

    private static  int [] nextValue1(String tags){
        int[] next = new int[tags.length()+1];
        //特判
        //next[1] = 0;
        next[0]=-1;
        int j=0,k=-1;
        while(j <= tags.length()-1){
            if(k==-1 || tags.charAt(j) ==tags.charAt(k)){
                next[++j] = ++k;
            }else{
                k  = next[k];
            }
        }
//        for(int i=1,j=0;i<tags.length(); i++){
//            while(j>0 && tags.charAt(i)!=tags.charAt(j)){
//                j = next[j-1];
//            }
//            if(tags.charAt(i)==tags.charAt(j)){
//                j++;
//            }
//            next[i] = j;
//        }
        return next;
    }
}
