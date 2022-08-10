import java.util.Scanner;

public class MineSweeper {
    int row;
    int col;
    int numberOfElements;
    int numberOfMine;
    String[][] gameMap;
    String[][] mineMap;
    int rowS, colS;
    int move;

    MineSweeper(int row, int col) {
        this.row = row;
        this.col = col;
        this.numberOfElements = this.col * this.row;
        this.numberOfMine = this.numberOfElements / 4;
        this.gameMap = new String[this.row][this.col];
        this.mineMap = new String[this.row][this.col];
        this.move = this.numberOfElements - this.numberOfMine;

    }

    void gameMap() {
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                this.gameMap[i][j] = "-";

            }

        }
    }
    void showGameMap(){
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                System.out.print(this.gameMap[i][j] + " ");


            }
            System.out.println();
        }

    }

    void mineMap() {
        int start = 0;

        while (start < numberOfMine) {
            int r = (int) (Math.random() * this.row);
            int c = (int) (Math.random() * this.row);
            this.mineMap[r][c] = "*";
            start++;

        }
        for (int i = 0; i < mineMap.length; i++) {
            for (int j = 0; j < mineMap[i].length; j++) {
                if (this.mineMap[i][j] != "*") {
                    this.mineMap[i][j] = "-";
                }
            }
        }

    }

    void showMineMap() {
        for (int i = 0; i < mineMap.length; i++) {
            for (int j = 0; j < mineMap[i].length; j++) {
                System.out.print(mineMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    int placement() {
        int counter = 0;
        if (this.rowS - 1 == 0) {
            if (this.colS - 1 == 0) {
                if (mineMap[this.rowS - 1][this.colS].equals("*")) {        //sağ
                    counter += 1;
                }
                if (mineMap[this.rowS][this.colS - 1].equals("*")) {    //aşağı
                    counter += 1;
                }
                if (mineMap[this.rowS][this.colS].equals("*")) {        //sağ + aşağı
                    counter += 1;
                }
            } else if (this.colS == this.col) {
                if (mineMap[this.rowS - 1][this.colS - 2].equals("*")) {    //sol
                    counter += 1;
                }
                if (mineMap[this.rowS][this.colS - 1].equals("*")) {    //aşağı
                    counter += 1;
                }
                if (mineMap[this.rowS][this.colS - 2].equals("*")) {    // sol + aşağı
                    counter += 1;
                }

            } else {
                if (mineMap[this.rowS - 1][this.colS].equals("*")) {
                    counter += 1;
                }
                if (mineMap[this.rowS - 1][this.colS - 2].equals("*")) {
                    counter += 1;
                }
                if (mineMap[this.rowS][this.colS - 1].equals("*")) {
                    counter += 1;
                }
                if (mineMap[this.rowS][this.colS - 2].equals("*")) {    // sol + aşağı
                    counter += 1;
                }
                if (mineMap[this.rowS][this.colS].equals("*")) {        //sağ + aşağı
                    counter += 1;
                }
            }

        } else if (this.rowS == this.row) {
            if (this.colS - 1 == 0) {
                if (mineMap[this.rowS - 1][this.colS].equals("*")) {        //sağ
                    counter += 1;
                }
                if (mineMap[this.rowS - 2][this.colS - 1].equals("*")) {    //yukarı
                    counter += 1;
                }
                if (mineMap[this.rowS - 2][this.colS].equals("*")) {        //sağ + yukarı
                    counter += 1;
                }
            } else if (this.colS == this.col) {
                if (mineMap[this.rowS - 1][this.colS - 2].equals("*")) {    //sol
                    counter += 1;
                }
                if (mineMap[this.rowS - 2][this.colS - 1].equals("*")) {    //yukarı
                    counter += 1;
                }
                if (mineMap[this.rowS - 2][this.colS - 2].equals("*")) {    //sol + yukarı
                    counter += 1;
                }
            } else {
                if (mineMap[this.rowS - 2][this.colS - 1].equals("*")) {    //yukarı
                    counter += 1;
                }
                if (mineMap[this.rowS - 1][this.colS - 2].equals("*")) {    //sol
                    counter += 1;
                }
                if (mineMap[this.rowS - 1][this.colS].equals("*")) {        //sağ
                    counter += 1;
                }
                if (mineMap[this.rowS - 2][this.colS - 2].equals("*")) {    //sol + yukarı
                    counter += 1;
                }
                if (mineMap[this.rowS - 2][this.colS].equals("*")) {        //sağ + yukarı
                    counter += 1;
                }
            }
        } else if (this.colS == this.col) {
            if (mineMap[this.rowS - 2][this.colS - 1].equals("*")) {    //yukarı
                counter += 1;
            }
            if (mineMap[this.rowS - 1][this.colS - 2].equals("*")) {    //sol
                counter += 1;
            }
            if (mineMap[this.rowS][this.colS - 1].equals("*")) {    //aşağı
                counter += 1;
            }
            if (mineMap[this.rowS - 2][this.colS - 2].equals("*")) {    //sol + yukarı
                counter += 1;
            }
            if (mineMap[this.rowS][this.colS - 2].equals("*")) {    // sol + aşağı
                counter += 1;
            }

        } else if (this.colS - 1 == 0) {
            if (mineMap[this.rowS - 2][this.colS - 1].equals("*")) {    //yukarı
                counter += 1;
            }
            if (mineMap[this.rowS][this.colS - 1].equals("*")) {    //aşağı
                counter += 1;
            }
            if (mineMap[this.rowS - 1][this.colS].equals("*")) {        //sağ
                counter += 1;
            }
            if (mineMap[this.rowS - 2][this.colS].equals("*")) {        //sağ + yukarı
                counter += 1;
            }
            if (mineMap[this.rowS][this.colS].equals("*")) {        //sağ + aşağı
                counter += 1;
            }

        } else {
            if (mineMap[this.rowS - 1][this.colS].equals("*")) {        //sağ
                counter += 1;
            }
            if (mineMap[this.rowS - 1][this.colS - 2].equals("*")) {    //sol
                counter += 1;
            }
            if (mineMap[this.rowS - 2][this.colS - 1].equals("*")) {    //yukarı
                counter += 1;
            }
            if (mineMap[this.rowS][this.colS - 1].equals("*")) {    //aşağı
                counter += 1;
            }
            if (mineMap[this.rowS][this.colS].equals("*")) {        //sağ + aşağı
                counter += 1;
            }
            if (mineMap[this.rowS - 2][this.colS].equals("*")) {        //sağ + yukarı
                counter += 1;
            }
            if (mineMap[this.rowS - 2][this.colS - 2].equals("*")) {    //sol + yukarı
                counter += 1;
            }
            if (mineMap[this.rowS][this.colS - 2].equals("*")) {    // sol + aşağı
                counter += 1;
            }
        }

        return counter;


    }


    void run() {
        Scanner inp = new Scanner(System.in);
        gameMap();
        mineMap();
        //showMineMap();
        System.out.println("==== Welcome to Minesweeper Game ====");

        while (true) {
            System.out.println("================");
            showGameMap();
            System.out.print("Row Number: ");
            this.rowS = inp.nextInt();
            System.out.print("Col Number: ");
            this.colS = inp.nextInt();

            if (rowS > this.row || rowS <= 0 || colS > this.col || colS <= 0) {
                System.out.println("Enter valid numbers!");
            } else {
                if (mineMap[this.rowS - 1][this.colS - 1].equals("*")) {
                    System.out.println("Game Over!");
                    showMineMap();
                    break;
                } else if (!gameMap[this.rowS - 1][this.colS - 1].equals("-")){
                    this.gameMap[this.rowS - 1][this.colS- 1] = String.valueOf(placement());
                } else {
                    this.gameMap[this.rowS - 1][this.colS- 1] = String.valueOf(placement());
                    this.move--;

                }
            }
            if (this.move == 0){
                System.out.println("Congrast, You won the game!");
                showMineMap();
                break;
            }


        }
    }
}
