public class MediaStream {
    /**
     * Median Stream :
     * You're given a list of n integers arr[0..(n-1)]. You must
     * compute a list output[0..(n-1)] such that, for each index i (between 0 and
     * n-1, inclusive), output[i] is equal to the median of the elements arr[0..i]
     * (rounded down to the nearest integer). The median of a list of integers is
     * defined as follows. If the integers were to be sorted, then: If there are an
     * odd number of integers, then the median is equal to the middle integer in the
     * sorted order. Otherwise, if there are an even number of integers, then the
     * median is equal to the average of the two middle-most integers in the sorted
     * order.
     * 
     * @param arr
     * @return
     */

    int[] findMedian(int[] arr) {
        // Write your code here
        int n = arr.length;
        int[] output = new int[n];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            if (maxHeap.size() == minHeap.size()) {
                if (minHeap.peek() != null && arr[i] > minHeap.peek()) {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(arr[i]);
                } else {
                    maxHeap.offer(arr[i]);
                }
            } else {
                if (arr[i] < maxHeap.peek()) {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(arr[i]);
                } else {
                    minHeap.offer(arr[i]);
                }
            }

            if (maxHeap.isEmpty()) {
                output[i] = 0;
            }
            if (maxHeap.size() == minHeap.size()) {
                Integer topMin = minHeap.peek();
                Integer topMax = maxHeap.peek();
                output[i] = (int) Math.floor((topMax + topMin) / 2);
            } else {
                output[i] = maxHeap.peek();
            }

            System.out.println(i + " - maxHeap: " + maxHeap.toString());
            System.out.println(i + " - minHeap: " + minHeap.toString());
        }

        return output;
    }
}

    
}
