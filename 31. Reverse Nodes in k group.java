31. Reverse Nodes in k group

public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
		// Write your code here.
		 if (n < 1 || head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node curr = head;
        Node future = curr.next;
        int length = findLength(head);
        for (int i = 0; i < n; i++) {
            Node last = prev;
            Node newEnd = curr;
            int k = 0;
            if (b[i] == 0)
                continue;
            if (b[i] < length) {
                k = b[i];
                length -= b[i];
            } else {
                k = length;
                length -= k;
            }
            int count = 0;
            while (curr != null && count < k) {
                future = curr.next;
                curr.next = prev;
                prev = curr;
                curr = future;
                count += 1;
            }
            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }
            newEnd.next = curr;
            prev = newEnd;
            if (length == 0) {
                break;
            }
        }
        return head;
	}
	public static int findLength(Node head) {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }