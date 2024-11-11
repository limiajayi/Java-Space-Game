package org.uob.a1;

public class Score {
    private int startingScore;
    private double currentScore;
    private int numRoomsVisited;
    private int numOfSolvedPuzzles;
    private final int PUZZLE_VALUE = 10;

    public Score(int startingScore) {
        this.startingScore = startingScore;
        this.currentScore = 0;
        this.numRoomsVisited = 0;
        this.numOfSolvedPuzzles = 0;
    }

    public void visitRoom() {
        this.numRoomsVisited += 1;
    }
        
    public void solvePuzzle() {
        this.numOfSolvedPuzzles += 1;
    }

    public double getScore() {
        double newScore =  (this.startingScore - this.numRoomsVisited + (this.numOfSolvedPuzzles * this.PUZZLE_VALUE));
        this.currentScore = newScore;
        return this.currentScore;
    }
}