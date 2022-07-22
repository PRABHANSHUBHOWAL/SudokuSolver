import java.util.*;
class sudoku
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter your Sudoku numbers row-wise \n\nEnter 0 in case of blanks ");
        int a[][]=new int[9][9];
        int i=0,j=0;
        // Input by user
        for(i=0;i<9;i++)
        {
            System.out.println("\nEnter digits of row no. "+(i+1)+"\n");
            for(j=0;j<9;j++)
            {
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println("Entered Sudoku Puzzle\n");
        show(a);
        solve(a);
        System.out.println("\nSolution of the Sudoku Puzzle\n");
        show(a);
    }
    // SOLVING
    public static boolean solve(int a[][])
    {
        int row = -1;
		int col = -1;
		boolean isEmpty =true;
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (a[i][j] == 0)
				{
					row = i;
					col = j;
					isEmpty =false;
					break;
				}
			}
			if (!isEmpty) 
            {
				break;
			}
		}

		// No empty space left
		if (isEmpty)
		{
			return true;
		}

		// Else backtrack for each-row 
		for (int dig=1;dig<=9;dig++)
		{
			if (check(a,row,col,dig))
			{
				a[row][col]=dig;
				if (solve(a))
				{
				   // Show puzzle
					return true;
				}
				else
				{
					// replace it
					a[row][col]=0;
				}
			}
		}
		return false;
	}
    
    public static boolean check(int a[][],int row,int col,int dig)
    {
        int i=0,j=0;
        // Unique Row
        for(i=0;i<9;i++)
        {
            if(a[row][i]==dig)
            return false;
        }
        // Unique Column
        for(i=0;i<9;i++)
        {
            if(a[i][col]==dig)
            return false;
        }
        // Corresponding square has unique number
		int sqRow=row-row%3;
		int sqCol=col-col%3;
		for (i=sqRow;i<sqRow+3;i++)
		{
			for (j=sqCol;j<sqCol+3;j++)
			{
				if (a[i][j]==dig)
				{
					return false;
				}
			}
		}
		// If its the only possibility
		return true;
    }
    // SHOWING SUDOKU GRID
    public static void show(int a[][])
    {
        int i=0,j=0;
        System.out.println("-------------------------------------------------------");
        for(i=0;i<9;i++)
        {
            System.out.print("|  ");
            for(j=0;j<9;j++)
            {
                if(a[i][j]==0)
                {
                    System.out.print("   |  ");
                    continue;
                }
                
                System.out.print(a[i][j]+"  |  ");
            }
            System.out.println();
            System.out.println("-------------------------------------------------------");
        }
    }
}