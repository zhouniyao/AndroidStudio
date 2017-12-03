package com.example;

/**
 * Created by Administrator on 2017/11/13.
 */
//递归回溯打印k进制所有可能
public class recursionDemo {
    static int count = 0;
    //k进制所有可能打印
    static void printA(int[] A){
        //for-each
       // for(int i : A){
       //     System.out.print(i);
       // }
        count++;
        for(int i = A.length-1; i>=0; i--){
            System.out.print(A[i]);
        }
    }
    static void k_jinzhi_print(int[] A,int n, int k){
        if(n < 1)//基本情形
        {

            printA(A);//打印数组所有元素
            System.out.println();
            return;
        }
        else{

            for(int i=0; i < k; i++){
                A[n-1]=i;
               // System.out.print(A[n-1]);//error!
                k_jinzhi_print(A, n-1, k);
                //printA(A);//error!
            }
        }
    }

    //回溯打印k进制所有可能
    public static void main(String[] args){
        int[] A = new int[4];//设置数组大小，即k进制长度
        k_jinzhi_print(A, A.length, 5);

        System.out.println(count);
    }
}
