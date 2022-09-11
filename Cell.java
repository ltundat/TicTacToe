public class Cell {

    private CellStatus status;
    private boolean played;

    public Cell() {
        this.status = CellStatus.EMPTY;
        played = false;
    }

    public boolean isPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public CellStatus getStatus() {
        return status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }

    public String Draw() {
        if (status == CellStatus.EMPTY) return " ";
        return status.toString();
    }

}