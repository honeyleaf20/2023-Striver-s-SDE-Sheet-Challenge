27. Merge two sorted linkedlist

public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		// Write your code here.
         if(first==null) return second;        
         if(second == null) return first;        
         if(first.data<second.data){            
             first.next = sortTwoLists(first.next,second);            
             return first;        
             }        
             else{           
                  second.next = sortTwoLists(first,second.next);          
                    return second;        
                    }
             
        }
