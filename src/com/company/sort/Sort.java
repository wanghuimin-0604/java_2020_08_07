package com.company.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:排序算法
 * User:wanghuimin
 * Date:2020-08-07
 * Time:16:05
 * 一万年太久，只争朝夕，加油
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 2, 6, 8, 11, 23, 19};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    //直接插入排序
    public static void insert(int[] arr) {
        for (int bound = 1; bound < arr.length; bound++) {
            //把bound位置的元素保存下来，插到前面已经排好序的区间
            int tmp = arr[bound];
            int j = bound - 1;
            for (; j >= 0; j--) {
                if (tmp < arr[j]) {
                    //小于的话，就把bound-1位置的元素后移
                    arr[j + 1] = arr[j];
                } else {
                    //说明这个元素大于已排好区间的最大元素，不用动了
                    break;
                }
            }
            //这里说明j为-1了,说明这个tmp中保存的数字小于已排好区间的所有元素，因此插到0位置下标
            arr[j + 1] = tmp;
        }
    }

    //希尔排序（分组插入排序）
    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 1) {
            insertGap(arr, gap);
            gap = gap / 2;

        }
        insertGap(arr, 1);
    }

    private static void insertGap(int[] arr, int gap) {
        for (int bound = gap; bound < arr.length; bound++) {
            int tmp = arr[bound];
            //找出bound位置的相邻元素
            int j = bound - gap;
            for (; j >= 0; j -= gap) {
                if (tmp < arr[j]) {
                    arr[j + gap] = arr[j];
                } else {
                    break;
                }

            }
            arr[j + gap] = tmp;
        }
    }

    /**
     * 堆排序思想：
     * 先建立一个大堆，此时去堆顶元素，堆顶元素就是最大的元素，将堆顶元素和最后一个元素交换，
     * 下次从0号位置开始向下调整直到倒数第二个元素
     * 以此类推
     * 当堆中剩下一个元素，此时这个元素就是最小的，这个堆按照从下到大排序完成了
     */
    public static void heapSort(int[] arr) {
        creatrHeap(arr);
        //将元素换位置
        int heapSize = arr.length;
        for (int i = 0; i < arr.length; i++) {
            swap(arr, 0, heapSize - 1);
            heapSize--;
            shiftDown(arr, heapSize, 0);

        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static void creatrHeap(int[] arr) {
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr, arr.length, i);
        }
    }

    private static void shiftDown(int[] arr, int size, int index) {
        int parent = index;
        int child = parent * 2 + 1;
        while (child < size) {
            if (child + 1 < size && arr[child + 1] > arr[child]) {
                child = child + 1;
            }
            if (arr[child] > arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
            }

            parent = child;
            child = child * 2 + 1;

        }
    }

    //选择排序
    //bound将数组分成两个区间
    //在待排序区间找到最小的放到bound位置
    public static void selectSort(int[] arr) {
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = bound + 1; cur < arr.length; cur++) {
                if (arr[bound] > arr[cur]) {
                    int tmp = arr[bound];
                    arr[bound] = arr[cur];
                    arr[cur] = tmp;
                } else {
                    continue;
                }
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        //从后向前遍历，找最小的，放在最前面
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = arr.length - 1; cur > bound; cur--) {
                if (arr[cur] < arr[cur -1]) {
                    int tmp = arr[cur];
                    arr[cur] = arr[cur -1];
                    arr[cur - 1] = tmp;
                } else {
                    continue;
                }
            }
        }
    }
}