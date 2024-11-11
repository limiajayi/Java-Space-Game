package org.uob.a1;

public class Map {
    private int width;
    private int height;
    final private char EMPTY = '.';
    private char[][] map;

    //Initializes the map class
    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        map = new char[this.width][this.height];
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {

                //if a space in the map is null, set it to the empty variable
                if (map[i][j] == '\0') {
                    map[i][j] = this.EMPTY;
                }
            }
        }
    }

    //gets width
    public int getWidth() {
        return this.width;
    }

    //gets height
    public int getHeight() {
        return this.height;
    }

    //gets the map
    public char[][] getMap() {
        return this.map;
    }

    //places a room using the x and y coordinates of a room and the symbol
    public void placeRoom(Position pos, char symbol) {
        if (pos.x < this.width && pos.y < this.height) {
            map[pos.x][pos.y] = symbol;
        }
    }

    //displays a room by adding each x coordinate, creates a new line at the end of a row
    public String display() {
        String result = "";
        for (int k = 0; k < this.height; k++) {
            for (int l = 0; l < this.width; l++) {
                result = result + map[l][k];
                
            }
            result = result + "\n";
        }

        return result;
    }

}