package org.uob.a1;

public class Player {
    private Position pos; //position of player
    private Inventory stuff; //items the player has
    private Inventory nameOfRooms; //rooms the player has visted which is relevant to ending the game
    private int roomsVisited; //increments each time a player visits a rooom.


    //initializes the player object
    public Player(Position initPos, Inventory initStuff, Inventory initNameOfRooms) {
        this.pos = initPos;
        this.stuff = initStuff;
        this.nameOfRooms = initNameOfRooms;
        this.roomsVisited = 0;
    }

    //displays the players inventory
    public void displayStuff() {
        System.out.println(this.stuff.displayInventory());
    }

    //returns the players inventory
    public Inventory getInventory() {
        return this.stuff;
    }

    //returns the array with the name of the rooms they got
    public Inventory getNameOfRooms() {
        return this.nameOfRooms;
    }

    //returns the players position
    public Position getPosition() {
        return this.pos;
    }

    //returns the number of rooms visited
    public int getRoomsVisited() {
        return this.roomsVisited;
    }

    //updates the number of rooms visited
    public void updateRoomsVisited() {
        this.roomsVisited += 1;
    }

    //moves the player around the map object
    public void movePlayer(Map area, char symbol, Position newPos) {

        //this sets the previous position of the player to EMPTY = '.'
        for (int i = 0; i < area.getWidth(); i++) {
            for (int j = 0; j < area.getHeight(); j++) {
                if (area.getMap()[i][j] == symbol) {
                    area.getMap()[i][j] = '.';
                }
            }
        }

        //this sets the current symbol on the map to the Player's symbol ONLY IF the previous symbol is equal to '.'
        //ive done this so the previously declared symbols for the rooms won't get replaced when the player moves over them.
        
        if (area.getMap()[newPos.x][newPos.y] == '.') {

            //this makes sure the player doesn't go out of bounds
            if (newPos.x < area.getWidth() && newPos.y < area.getHeight()) {
                area.getMap()[newPos.x][newPos.y] = symbol;
            }
        }
    }
}
