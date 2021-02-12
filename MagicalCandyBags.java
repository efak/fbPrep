public class MagicalCandyBags {
    /**
     * Magical Candy Bags 
     * You have N bags of candy. The ith bag contains arr[i]
     * pieces of candy, and each of the bags is magical! It takes you 1 minute to
     * eat all of the pieces of candy in a bag (irrespective of how many pieces of
     * candy are inside), and as soon as you finish, the bag mysteriously refills.
     * If there were x pieces of candy in the bag at the beginning of the minute,
     * then after you've finished you'll find that floor(x/2) pieces are now inside.
     * You have k minutes to eat as much candy as possible. How many pieces of candy
     * can you eat?
     */

    int maxCandies(int[] arr, int k) {
        // Write your code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            int polled, counter = 0;
            double tmp;
    
            for(int e: arr){
                maxHeap.add(e);
            }
    
            for( int i = 1; i <= k; i++){
                polled = maxHeap.poll();
                counter += polled;
                //recalculate
                tmp = Math.floor(polled/2);
                maxHeap.add((int)tmp);
            }
    
            return counter;
        
      }
    
}
