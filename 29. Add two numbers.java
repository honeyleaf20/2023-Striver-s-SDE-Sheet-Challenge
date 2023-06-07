29. Add two numbers

 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       if (l1 == null && l2 == null) return null;
        int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
        ListNode head = new ListNode(val % 10);
        head.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next);
        if (val >= 10) head.next = addTwoNumbers(head.next, new ListNode(1));
        return head;
    }  