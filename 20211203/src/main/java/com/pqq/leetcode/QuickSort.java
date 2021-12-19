package com.pqq.leetcode;

/**
 * @author pqq
 * @create ${year}-12-10 18:18
 */

public class QuickSort{
    public static void main(String[] args) {
        int[] ints = {5, 7, -1, 3, 2, 7, 10};
        QuickSort sort1 = new QuickSort();
        sort1.quickSort(ints,0,ints.length-1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    public void quickSort(int arr[], int start, int end)
    {

        int i = start, j = end, temp ,t;
        if(i >= j || arr.length == 0){
            return;
        }
        temp = arr[start];
        while(i < j)
        {
            while(i < j && arr[start] <= arr[j]){
                j--;
            }

            while (i < j && arr[start] >= arr[i]){
                i++;
            }

            if(i < j){
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        arr[start] = arr[i];
        arr[i] = temp;
        quickSort(arr,start,i-1);
        quickSort(arr,i+1,end);


    }
}