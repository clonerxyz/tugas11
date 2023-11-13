/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.test11;

import static com.mycompany.test11.MergeSort.printArray;

/**
 *
 * @author Clonerxyz
 */
class MergeSort
{
    void merge(int arri[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int [n1];
        int R[] = new int [n2];
        for (int i=0; i<n1; ++i)
            L[i] = arri[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arri[m + 1+ j];
            int i = 0, j = 0;
            int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arri[k] = L[i];
                i++;
            }
            else
            {
                arri[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1)
        {
            arri[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) 
        {
            arri[k] = R[j];
            j++;
            k++;
        }
    }//end void merge

    void sort(int arri[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            sort(arri, l, m);
            sort(arri , m+1, r);
            merge(arri, l, m, r);
        }
    }//end void sort

    static void printArray(int arri[])
    {
        int n = arri.length;
        for (int i=0; i<n; ++i)
        System.out.print(arri[i] + " ");
        System.out.println();
    }//end static void printArray 
}
class CountingSort
{
    void sort(char arr[])
    {
        int n = arr.length;
        char output[] = new char[n];
        int count[] = new int[256];
        for (int i = 0; i < 256; ++i)
            count[i] = 0;
        for (int i = 0; i < n; ++i)
            ++count[arr[i]];
        for (int i = 1; i <= 255; ++i)
            count[i] += count[i - 1];
        for (int i = 0; i < n; ++i)
            {
                output[count[arr[i]] - 1] = arr[i];
                --count[arr[i]];
            }
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
     }//end void sort 
}

public class Test11 {
   public static void main(String[] args) {
        System.out.print("TUGAS 1 MergeSort \n");
        
        int arri[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Given Array");
        printArray(arri);
        MergeSort obi = new MergeSort();
        obi.sort(arri, 0, arri.length-1);
        System.out.println("\nSorted array");
        printArray(arri);
        
        System.out.print("\n\nTUGAS 2 CountingSort \n");
        CountingSort ob = new CountingSort();
        char arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o',
        'r', 'g', 'e', 'e', 'k', 's' };
        ob.sort(arr);
        System.out.print("Sorted character array is ");
        for (int i = 0; i < arr.length; ++i)
        System.out.print(arr[i]); 
        
    } 
}