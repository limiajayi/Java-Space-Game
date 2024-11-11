package org.uob.a1;

public class Inventory {
    final int MAX_ITEMS = 10;
    private String[] items;
    private int counter; //the number of items added to the items array
    
    // constructor for inventory
    public Inventory() {
        this.items = new String[MAX_ITEMS];
        this.counter = 0;
    }

    //has item method 
    public int hasItem(String item) {
        int num = -1;
        for (int i = 0; i < this.items.length; i++) {
            
            //if the item in the array is not null check if it equals the item we're looking for

            if (this.items[i] != null) {
                if (item.equals(this.items[i])) {
                    num = i;
                }
            }
        }
        // if not return -1
        return num;
    }

    public int getLength() {
        return this.counter;
    }

    public void addItem(String item) {
        int i = 0;

        //while i is less than the length of the array and the array doesn't have the item
        while (i < MAX_ITEMS && hasItem(item) == -1) {
            
            //if a space in the array is equal to null, let the added item replace the null item

            if (this.items[i] == null) {
                items[i] = item;
            }

            i++;
        }
        this.counter += 1; // updates the number of items in the items array
    }

    public String displayInventory() {
        String result = "";
        for (int i = 0; i < this.items.length; i++) {

            //only the items that are NOT null are allowed to be displayed
            if (this.items[i] != null) {
                result = result + items[i] + " ";
            }
        }
        return result;
    }

    public void removeItem(String item) {
        String[] newList = new String[MAX_ITEMS];
        newList = this.items;
        int j = hasItem(item); //returns the index of the item

        // if the items in inventory is greater than 0
        if (this.counter > 0) {

            //if the inventory has the item
            if (j != -1) {

                //looping through the array, if i is equal to the index of the item, that position should be equal to null
                for (int i = 0; i < this.items.length; i++) {
                    if (i == j) {
                        newList[i] = null;
                        }
                    }

                // updates the counter if the item is found in items array
                this.counter -= 1; 
                }
        }

        this.items = newList;
    }

}