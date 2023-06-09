38. Copy list with random pointer

public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		// Write your code here.
		HashMap<LinkedListNode,LinkedListNode> map = new HashMap<>();

        LinkedListNode tem = head;

        while(tem!=null){

            LinkedListNode node = new LinkedListNode(tem.data);

            map.put(tem,node);

            tem= tem.next;

        }

        tem = head;

        while(tem!=null){

            LinkedListNode p = map.get(tem);

            p.next = map.get(tem.next)!=null?map.get(tem.next):null;

            p.random = map.get(tem.random)!=null?map.get(tem.random):null;

            tem=tem.next;

        }

        return map.get(head);
	}