import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int row=0, col = 0;
        Scanner dif = new Scanner(System.in);
        System.out.print("1-Beginner\n2-Intermediate\n3-Expert\n4-Custom Size\nYou need to select the difficulty of Mine Sweeper to determine the size of the map:");
        int difficulty = dif.nextInt();
        switch (difficulty){
            case 1:
                row = 3;
                col = 3;
                break;
            case 2:
                row = 5;
                col = 5;
                break;
            case 3:
                row = 7;
                col = 7;
                break;
            case 4:
                System.out.print("Number of row:");
                row = dif.nextInt();
                System.out.print("Number of column:");
                col = dif.nextInt();
        }
        MineSweeper m1 = new MineSweeper(row,col);
        m1.run();

    }


}
