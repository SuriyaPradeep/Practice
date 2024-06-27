package SUMS;

public class K_thelementoftwoArrays {
    /*
Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. The task is to find the element that would be at the kth position of the final sorted array.

Example 1:
Input:
arr1[] = {2, 3, 6, 7, 9}
arr2[] = {1, 4, 8, 10}
k = 5
Output:
6
Explanation:
The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.
     */
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        int K=0,i=0,j=0;
        while(i<n && j<m){
            if(arr1[i]<=arr2[j]){
                K++;
                if(K==k){
                    return arr1[i];
                }
                i++;
            } else{
                K++;
                if(K==k){
                    return arr2[j];
                }
                j++;
            }
        }
        while(i<n){
            K++;
            if(K==k){
                return arr1[i];
            }
            i++;
        }
        while(j<m){
            K++;
            if(K==k){
                return arr2[j];
            }
            j++;
        }
        return -1;
    }
}
