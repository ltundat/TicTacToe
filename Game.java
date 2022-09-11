import java.util.Scanner;

public class Game {

    public static boolean Check(Board b) {
        if (b.getC(1, 1).getStatus() == b.getC(1, 2).getStatus() &&
                b.getC(1, 2).getStatus() == b.getC(1, 3).getStatus() &&
                b.getC(1, 1).isPlayed()) {
            return true;
        }
        if (b.getC(2, 1).getStatus() == b.getC(2, 2).getStatus() &&
                b.getC(2, 2).getStatus() == b.getC(2, 3).getStatus() &&
                b.getC(2, 3).isPlayed()) {
            return true;
        }
        if (b.getC(3, 1).getStatus() == b.getC(3, 2).getStatus() &&
                b.getC(3, 2).getStatus() == b.getC(3, 3).getStatus() &&
                b.getC(3, 3).isPlayed()) {
            return true;
        }
        if (b.getC(1, 1).getStatus() == b.getC(2, 1).getStatus() &&
                b.getC(2, 1).getStatus() == b.getC(3, 1).getStatus() &&
                b.getC(3, 1).isPlayed()) {
            return true;
        }
        if (b.getC(1, 2).getStatus() == b.getC(2, 2).getStatus() &&
                b.getC(2, 2).getStatus() == b.getC(3, 2).getStatus() &&
                b.getC(3, 2).isPlayed()) {
            return true;
        }
        if (b.getC(1, 3).getStatus() == b.getC(2, 3).getStatus() &&
                b.getC(2, 3).getStatus() == b.getC(3, 3).getStatus() &&
                b.getC(3, 3).isPlayed()) {
            return true;
        }
        if (b.getC(1, 1).getStatus() == b.getC(2, 2).getStatus() &&
                b.getC(2, 2).getStatus() == b.getC(3, 3).getStatus() &&
                b.getC(3, 3).isPlayed()) {
            return true;
        }
        return b.getC(1, 3).getStatus() == b.getC(2, 2).getStatus() &&
                b.getC(2, 2).getStatus() == b.getC(3, 1).getStatus() &&
                b.getC(3, 1).isPlayed();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Board b = new Board();
        System.out.println("Welcome to TicTacToe Game!");
        System.out.println("1.X go first  2.O go first");

        boolean start = false;
        int choose = 0;
        while (!start) {
            choose = input.nextInt();
            if (choose != 1 && choose != 2) System.out.println("Invalid choose!");
            else {
                start = true;
            }
        }

        boolean end = false;
        int count = 0;
        CellStatus now;
        now = (choose == 1) ? CellStatus.X : CellStatus.O;
        System.out.println(now + "'s turn");
        b.DrawBoard();
        while (!end) {
            boolean stop = false;
            while (!stop) {
                int x = input.nextInt();
                int y = input.nextInt();
                if (x > 0 && x < 4 && y > 0 && y < 4 && !b.getC(x, y).isPlayed()) {
                    b.getC(x, y).setPlayed(true);
                    b.getC(x, y).setStatus(now);
                    count++;
                    if (Check(b)) {
                        end = true;
                        b.DrawBoard();
                        System.out.println(now + " win!");
                        break;
                    }
                    if (count == 9) {
                        b.DrawBoard();
                        System.out.println("Draw!");
                        end = true;
                        break;
                    }
                    if (now == CellStatus.X) now = CellStatus.O;
                    else now = CellStatus.X;
                    System.out.println(now + "'s turn");
                    stop = true;
                    b.DrawBoard();

                } else {
                    System.out.println("Invalid move!");
                }
            }
        }
    }
}