public class LargestTripleProduct {
    /**
     * Largest Triple Products You're given a list of n integers arr[0..(n-1)]. You
     * must compute a list output[0..(n-1)] such that, for each index i (between 0
     * and n-1, inclusive), output[i] is equal to the product of the three largest
     * elements out of arr[0..i] (or equal to -1 if i < 2, as arr[0..i] then
     * includes fewer than three elements). Note that the three largest elements
     * used to form any product may have the same values as one another, but they
     * must be at different indices in arr.
     * 
     * @param arr
     * @return
     */

    int[] findMaxProduct(int[] arr) {
        // Write your code here
        int n = arr.length;
        int product = 1;
        int[] output = new int[n];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        // populate heap with first 3 integers
        // and calculate product
        if (n >= 3) {
            for (int i = 0; i < 3; i++) {
                maxHeap.add(arr[i]);
                product *= arr[i];
            }
        }
        output[0] = -1;
        output[1] = -1;
        output[2] = product;

        for (int i = 3; i < n; i++) {
            int peeked = maxHeap.peek();
            if (arr[i] > peeked) {
                maxHeap.poll();
                maxHeap.add(arr[i]);

                product = product / peeked;
                product = product * arr[i];
            }
            output[i] = product;

        }

        return output;
    }
    
}
