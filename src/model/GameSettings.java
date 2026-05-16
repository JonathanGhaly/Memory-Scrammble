package model;

public class GameSettings {
    private int rows;
    private int columns;
    private int timeLimit;

    public GameSettings(int rows,int columns,int timeLimit){
        this.rows=rows;
        this.columns=columns;
        this.timeLimit=timeLimit;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getTimeLimit() {
        return timeLimit;
    }
}
