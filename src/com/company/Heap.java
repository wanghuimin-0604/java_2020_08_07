package com.company;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-08-07
 * Time:15:21
 * 一万年太久，只争朝夕，加油
 */
//建大堆
public class Heap {
    public static void createHeap(int[] arr,int size){
        //从后向前遍历
        //向下调整
        for(int i=(size-1-1)/2;i>=0;i--){
            shiftDown(arr,size,i);
        }
    }

    private static void shiftDown(int[] arr, int size, int index) {
        int parent=index;
        int child=parent*2+1;
        while(child<size){
            if(child+1<size&&arr[child+1]>arr[child]){
                child=child+1;
            }
            if(arr[parent]<arr[child]){
                int tmp=arr[parent];
                arr[parent]=arr[child];
                arr[child]=tmp;
            }else{
                break;
            }
            parent=child;
            child=child*2+1;
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,5,3,8,7,6};
        createHeap(arr,arr.length);
        System.out.println(Arrays.toString(arr));

    }
}
