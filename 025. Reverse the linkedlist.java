25. Reverse the linkedlist

public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        // Write your code here!
		if(head==null || head.next==null)return head;
		LinkedListNode<Integer> newHead = null;
    while (head != null) {
        LinkedListNode<Integer> next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;
    }
    return newHead;
    }
