package maze_runner;
import java.util.*;
public class ShortestPath {
  public static void main(String[] args) {
    Scanner s1 = new Scanner(System.in);

    System.out.println("Enter matrix dimension (n x n) : ");

    int n = s1.nextInt();

    char [][] arr = new char[n][n];

    for(int i = 0 ;i < n; i++){
      for(int j = 0 ;j < n ; j++){
        arr[i][j] = '0'; 
      }
    }
    System.out.println("Enter the Adventurer Position row and col : ");

    int aRow = s1.nextInt();
    int aCol = s1.nextInt();

    arr[aRow][aCol] = 'A';

    System.out.println("Enter the Destination Position row and col : ");

    int rRow = s1.nextInt();

    int rCol = s1.nextInt();
    System.out.println();

    arr[rRow][rCol] = 'D';

    for(int i = 0  ; i < n ;i++){
      for(int j =0 ; j < n ;j++){
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

    int res = shortestPath(aRow , aCol, rRow, rCol);
    System.out.println();

      System.out.println("The shortest path is "+res);

  }

  private static int shortestPath(int x , int y , int dx , int dy){
    

    return Math.max(Math.abs(dx -x) , Math.abs(dy -y));
  }



}
