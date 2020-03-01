import java.io.*;
import java.util.*;

/*
Given a list of sorted integers and a target value, calculate the smallest absolute difference between the sums of any pairs of integers and the target. 
    Example: [-1, 4, 5, 6] with target 9. Smallest difference would be 0 given by the pair (4, 5): 4 + 5 = 9 and 9 - 9 = 0
*/

class Solution {
    static int smallDiff(int[] arr, int n) {
        if (arr.length == 0) return n;
        if (arr.length == 1) return Math.abs(arr[0] - n);

        Arrays.sort(arr);
        int i = 0, j = arr.length - 1, smallAbsDiff = Integer.MAX_VALUE, currDiff = 0, sum = 0;
        while (i < j) {
            sum = arr[j] + arr[i];
            currDiff = Math.abs(sum - n);
            if (currDiff == 0) return currDiff;
            else if (currDiff < smallAbsDiff) {
                smallAbsDiff = currDiff;
                j--;
            }
            else {
                i++;
            }
        }
        return smallAbsDiff;
    }
    
    public static void main(String[] args) {
        int[] arr = {-1, 5, 100, 6, 19, 7};
        System.out.println(smallDiff(arr, 9));
    }
}
