26. Middle of LinkedList

 public static Node findMiddle(Node head)
    {
        // Write your code here.
        Node slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
