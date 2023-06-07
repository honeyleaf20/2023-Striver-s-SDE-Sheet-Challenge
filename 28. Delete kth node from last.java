28. Delete kth node from last

public static Node removeKthNode(Node head, int K)
    {
        // Write your code here.
        if(head==null || K==0)return head;
         Node slow = head, fast=head;
          for(int i=0;i<K;i++){
            fast = fast.next;
        }
          if(fast==null)return head.next;
          while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next =slow.next.next;
        return head;
        

    }