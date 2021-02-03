import java.io.*; 
import java.util.*;



class QueueRemoval {

  // Add any helper functions you may need here
  class QNode{
        int val;
        int index;

        public QNode(int v, int i){
            val = v;
            index = i;
        }
    }
  

  int[] findPositions(int[] arr, int x) {
        // Write your code here
				LinkedList<QNode> arrayQueue = new LinkedList<>();
        LinkedList<QNode> popQueue = new LinkedList<>();

        int[] answer = new int[x];

        // fill queue with array values. Index is 1-based
        int c = 1;
        for (int e : arr) {
            arrayQueue.add(new QNode(e, c));
            c++;
        }

				//do x iterations
        for (int i = 1; i <= x; i++) {
            
            int j = 1, max = Integer.MIN_VALUE;
            QNode tmpNode;
            
            // 1. pop x elements
            while (j <= x && !arrayQueue.isEmpty()) {
                tmpNode = arrayQueue.pop();
                max = (tmpNode.val > max) ? tmpNode.val : max;
                popQueue.add(tmpNode);
                j++;
            }
            
            // step 2 and 3 combined
            int len = popQueue.size();
            boolean maxDeleted = false;
            for (int m = 0; m < len; m++) {
                tmpNode = popQueue.pop();

								//drop only one value that i equal to the max
                if (tmpNode.val == max) {
                    if (!maxDeleted) {
                        maxDeleted = true;
                        answer[i - 1] = tmpNode.index; //grab answer
                        continue;
                    }
                }
                
                //decrement if positive
                tmpNode.val = (tmpNode.val > 0) ? tmpNode.val - 1 : tmpNode.val;
								
								//add to original que
                arrayQueue.add(tmpNode);
            }

        }

        return answer;    
  }
	
	}
