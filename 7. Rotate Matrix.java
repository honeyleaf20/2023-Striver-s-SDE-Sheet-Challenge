7. Rotate Matrix

public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        // Write your code here.
        int row=0, col=0, maxRow=n, maxCol=m,prev,curr;

         while(row<maxRow-1&&col<maxCol-1){
            prev=mat.get(row+1).get(col);
            for(int i=col;i<maxCol;i++){

              curr=mat.get(row).get(i);
              mat.get(row).set(i,prev);
              prev=curr;   

           }

           row++;

           for(int i=row;i<maxRow;i++)

           {

               curr=mat.get(i).get(maxCol-1);

               mat.get(i).set(maxCol-1,prev);

               prev=curr;

           }

           maxCol--;

           if(row<maxRow)

           {

               for(int i=maxCol-1;i>=col;i--)

               {

               curr=mat.get(maxRow-1).get(i);

               mat.get(maxRow-1).set(i,prev);

               prev=curr;

               }

           }

           maxRow--;

           if(col<maxCol)

           {

             for(int i=maxRow-1;i>=row;i--)

             {

                curr=mat.get(i).get(col);

                 mat.get(i).set(col,prev);

                 prev=curr;

             }

            

           }

           col++;

        }       

    }
