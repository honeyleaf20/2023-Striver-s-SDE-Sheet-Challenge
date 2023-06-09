31. Intersection of 2 linkedlists

 public static int findIntersection(Node headA, Node headB) {
        //Write your code here
        if(headA == null || headB == null) return -1;
    
    Node a = headA;
    Node b = headB;
    
    while( a != b){
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a.data;
    }