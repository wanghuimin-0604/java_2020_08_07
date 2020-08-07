package com.company;

import java.util.Arrays;

/**
 * 优先队列
 * 基本操作：入队列、出队列、取队首元素
 */
class MyPriorityQueue {
    public int[] arr;
    public int size;

    public MyPriorityQueue() {
        this.arr = new int[100];
        this.size=0;
    }


    //基本操作
    //入队列
    public void offer(int x) {
        //先把要添加的元素放到最后一个位置
        //然后向上调整，使之满足大堆的特性
        arr[size] = x;
        size++;
        shiftUp(arr, size, size - 1);

    }
    //出队列
    public Integer poll(){
        //出的是堆中的首元素
        //先把最后一个元素赋值给0
        //然后从该位置向下调整
        //先把删除位置的元素保存下来
        int ret=arr[0];
        //再把最后一个元素赋值到0位置
        arr[0]=arr[size-1];
        size--;
        //从0号位置进行向下调整
        shiftDown(arr,size,0);
        return ret;
    }

    //取队首元素
    public int peek(){
        return arr[0];
    }
    private void shiftDown(int[] arr, int size, int index) {
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

    private void shiftUp(int[] arr, int size, int index) {
        int child = index;
        int parent = (child - 1) / 2;
        while (parent>=0) {
            if (arr[child] > arr[parent]) {
                //交换
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
            } else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }
    public void print(){
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        //System.out.println(Arrays.toString(arr));
    }
    //判断队列是否为空
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
}


public class Main {
    public static void main(String[] args) {
	    MyPriorityQueue m=new MyPriorityQueue();
        m.offer(9);
        m.offer(7);
        m.offer(8);
        m.offer(5);
        m.offer(3);
        m.offer(6);
        m.offer(2);
        m.offer(20);
        m.poll();
        m.print();
        System.out.println();
        System.out.println(m.peek());

    }
}
