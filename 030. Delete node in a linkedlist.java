30. Delete node in a linkedlist

public static void deleteNode(LinkedListNode<Integer> node) {
		// Write your code here.
        node.data = node.next.data;
        node.next = node.next.next;
	}
