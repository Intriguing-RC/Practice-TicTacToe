package me.intriguing;

public class Board {

    private char[][] items = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};

    public void printBoard() {
        System.out.printf(" %s | %s | %s %n---+---+---%n %s | %s | %s %n---+---+---%n %s | %s | %s %n", items[0][0], items[0][1], items[0][2], items[1][0], items[1][1], items[1][2], items[2][0], items[2][1], items[2][2]);
    }

    public boolean checkWin(Player player) {
        char letter = player.getLetter();

        int count;
        for (int i = 0; i <= 2; i++) {

            count = 0;
            // Check for each row
            for (int j = 0; j <= 2; j++) {
                if (items[i][j] == letter) count++;
            } if (count == 3) return true;

            count = 0;
            // Check for each column
            for (int j = 0; j <= 2; j++) {
                if (items[j][i] == letter) count++;
            } if (count == 3) return true;

        }

        count = 0;
        for (int i = 0; i <= 2; i++) {
            if (items[i][i] == letter) count++;
        } if (count == 3) return true;

        // Check for diagonal other way
        count = 0;
        for (int i = 2, j = 0; i >= 0 && j <= 2; i--, j++) {
            if (items[i][j] == letter) count++;
        }  return count == 3;

    }

    public String getIndex(int number) {
        switch(number) {
            case 1:
                return "i=0;j=0";
            case 2:
                return "i=0;j=1";
            case 3:
                return "i=0;j=2";
            case 4:
                return "i=1;j=0";
            case 5:
                return "i=1;j=1";
            case 6:
                return "i=1;j=2";
            case 7:
                return "i=2;j=0";
            case 8:
                return "i=2;j=1";
            case 9:
                return "i=2;j=2";
            default:
                return null;
        }

    }

    public boolean checkExists(int i, int j) {
        char item = items[i][j];
        return item == 'X' || item == 'O';
    }

    public boolean checkTie() {
        int count = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (items[i][j] == 'X' || items[i][j] == 'O') {
                    count++;
                }
            }
        } return count == 9;
    }

    public void setIndex(int i, int j, char value) {
        items[i][j] = value;
    }


}
