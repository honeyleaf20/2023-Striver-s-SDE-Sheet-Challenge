 static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        ArrayList<Integer> ns = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr.get(i))
                stack.pop();

            if (stack.isEmpty())
                ns.add(-1);
            else
                ns.add(stack.peek());
            int ele = arr.get(i);
            stack.push(ele);
        }
        Collections.reverse(ns);
        return ns;
    }
