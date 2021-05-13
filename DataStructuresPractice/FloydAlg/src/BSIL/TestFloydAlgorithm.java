package BSIL;

public class TestFloydAlgorithm
{
    public static void main(String[] args)
    {
        int[][] A = { {0 , 5, 99, 1 }, //adjacency matrix
                {3 , 0, 99, 99}, //99 is infinity value
                {9 , 4, 0 , 1 },
                {99, 2, 99, 0 },
        };

        System.out.println();

        for (int k = 0; k<= 3; k++)
        {
            System.out.println();
            System.out.println("Matrix A" + k + ":");
            for (int i = 0; i <= 3; i++)
            {
                for (int j = 0; j <= 3; j++)
                {
                    A[i][j] = Math.min(A[i][j], (A[i][k] + A[k][j]));
                    System.out.print (A[i][j] + "\t");
                }
                System.out.println();
            }

        }


        System.out.println();
        System.out.println("Final Shortest paths matrix:");
        for (int i = 0; i<= 3; i++) //print array
        {
            for (int j = 0; j<= 3; j++)
                System.out.print (A[i][j] + "\t");
            System.out.println();
        }
    }
}
