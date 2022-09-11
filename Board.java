public class Board {
    private Cell c[][] = new Cell[4][4];

    public Board() {
        for (int i = 1; i <= 3; i++)
            for (int j = 1; j <= 3; j++) {
                c[i][j] = new Cell();
            }
    }

    public Cell getC(int x, int y) {
        return c[x][y];
    }

    public void DrawBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + c[1][1].Draw() + " | " + c[1][2].Draw() +
                " | " + c[1][3].Draw() + " |");
        System.out.println("|-----------|");
        System.out.println("| " + c[2][1].Draw() + " | " + c[2][2].Draw() +
                " | " + c[2][3].Draw() + " |");
        System.out.println("|-----------|");
        System.out.println("| " + c[3][1].Draw() + " | " + c[3][2].Draw() +
                " | " + c[3][3].Draw() + " |");
        System.out.println("|---|---|---|");
    }
}