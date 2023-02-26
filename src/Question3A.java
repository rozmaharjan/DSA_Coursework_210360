import java.util.Arrays;

//import java.util.Arrays;
//
//public class Question3A {
//    // function to find the minimum product difference of an even-length array
//    public static int minProductDifference(int[] arr) {
//        int n = arr.length;
//        // loop to sort the array in non-ascending order using bubble sort
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - i - 1; j++) {
//                // swap arr[j] and arr[j + 1] if arr[j] is smaller than arr[j + 1]
//                if (arr[j] < arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//        int half = n / 2;
//        // product of first half of the array
//        int product1 = 1;
//        int product2 = 1;
//        int first_half[]=new int[half];
//        int second_half[]=new int[half];
//        for(int i=0;i< half;i++){
//            first_half[i]=arr[i];
//            second_half[i]=arr[i+half];
//        }
//        System.out.println(Arrays.toString(first_half));
//        System.out.println(Arrays.toString(second_half));
//
//        int first_product=first_half[0]*second_half[second_half.length-1];
//        int second_product=first_half[first_half.length-1]*second_half[0];
//
//        System.out.println(first_product);
//        System.out.println(second_product);
//
//        int min_diff=Math.abs(second_product-first_product);
//        return min_diff;
//    }
//
//    public static void main(String[] args) {
//        int a[]= {5,2,4,11};
//        System.out.println("The minimum product difference is "+  minProductDifference(a));
//
//    }
//}
public class Question3A {
    public static int minProductDifference(int[] arr) {
        Arrays.sort(arr); // sort the input array
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        // calculate the difference between two subarrays with the minimum product difference
        for (int i = 0; i < n / 2; i++) {
            int product1 = arr[i] * arr[n - i - 1];
            int product2 = arr[n / 2 + i] * arr[n - n / 2 - i - 1];
            int diff = Math.abs(product1 - product2);
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 11};
        System.out.println(minProductDifference(arr)); // outputs 2
    }
}
