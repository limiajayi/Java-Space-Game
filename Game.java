package org.uob.a1;

import java.util.Scanner; 

public class Game {
    //gets a description when 'look' is called
    public static String provideDescription(Room place) {
        return place.getDescription();
    }

    //called before the user starts the game
    public static void gameCommands() {
        System.out.println("Here are some basic commands:");
        System.out.println("'map' views the map.");
        System.out.println("'inventory' views the items you have.");
        System.out.println("'look items' to see description of items in your inventory.");
        System.out.println("'score' views your current score.");
        System.out.println("<symbol> helps you move to new rooms your character is in the correct position.");
        System.out.println("'help' guides you if you get lost.");
        System.out.println("'quit' exits the game.");
        System.out.println("'move <direction>' moves your character on the map.");
        System.out.println("The directions are: 'north', 'south', 'east', and 'west'.");
        System.out.println("Enter 'start' to start the game.");
    }

    //prompt that's called when the user enters 'start'
    public static void initPrompt(Inventory newStuff) {
            System.out.println("Commander: You are an astronaut, collecting materials to bring back to earth!");
            System.out.println("Commander: Here are some items you'll need: a map to see where you are and a telescope to look at the stars. \n");
            newStuff.addItem("map");
            newStuff.addItem("telescope");

            System.out.println("--You look into your inventory and see: ");
            System.out.println(newStuff.displayInventory());

            System.out.println("Commander: You can only land on Mercury, Venus, Mars and Pluto.");
            System.out.println("Commander: I hope you understand why the other planets are slightly dangerous.");
            System.out.println("--Move your player over the correct symbol for the planet you want to go to.");
            System.out.println("--Then enter the symbol for the planet!!");
            System.out.println("Commander: Return back to earth when you're done.");
            System.out.println("Commander: Goodluck\n");
    }

    //prompt that's called when the user enters earth '&'
    public static void earthPrompt() {
        System.out.println("--Home sweet home.\n");
    }

    //states how many planets the player visited when they return back to earth '&'
    public static void checkRoomsVisited(Player newUser) {
        int num = newUser.getRoomsVisited();
        System.out.println("You visited " + num + " planets!");
    }

    //checks if the user visited a planet AND the rock they picked up from that planet
    public static void checkPlanetsVisited(Player newUser) {
        Inventory newInventory = newUser.getInventory();
        Inventory planetsSeen = newUser.getNameOfRooms();
        int mars = newInventory.hasItem("Massive Iron Oxide Rock");
        int mercury = newInventory.hasItem("Silica Slab");
        int venus = newInventory.hasItem("Sulfur Oxide Rock");

        //if the player visited mars
        if (mars != -1 && planetsSeen.hasItem("Mars") != -1) {
            System.out.println("Commander: You went to Mars!!");
            System.out.println("Commander: Did you see any aliens?");
            System.out.println("Commander: Let me help you with that...");
            System.out.println("--Your Commander helps you with the Massive Oxide Rock. \n");
            newUser.getInventory().removeItem("Massive Iron Oxide Rock");
            newUser.getInventory().displayInventory();
        } else if (planetsSeen.hasItem("Mars") != -1) {
            System.out.println("Commander: Went to Mars and brought nothing back..");
        }

        //if the player visited mercury
        if (mercury != -1 && planetsSeen.hasItem("Mercury") != -1) {
            System.out.println("Commander: You went to Mercury!!");
            System.out.println("Commander: Hope it wasn't too cold..");
            System.out.println("Commander: Let me help you with that...");
            System.out.println("--Your Commander helps you with the Silica Slab. \n");
            System.out.println();
            newUser.getInventory().removeItem("Silica Slab");
            newUser.getInventory().displayInventory();
        } else if (planetsSeen.hasItem("Mercury") != -1) {
            System.out.println("Commander: Went to Mercury and brought nothing back..");
        }

        //if the player visited venus
        if (venus != -1 && planetsSeen.hasItem("Venus") != -1) {
            System.out.println("Commander: You went to Venus!!");
            System.out.println("Commander: You've seen volcanoes on venus before seeing volcanoes on earth!");
            System.out.println("Commander: Let me help you with that...");
            System.out.println("--Your Commander helps you with the Sulfur Oxide Rock. \n");
            System.out.println();
            newUser.getInventory().removeItem("Sulfur Oxide Rock");
            newUser.getInventory().displayInventory();
        } else if (planetsSeen.hasItem("Venus") != -1) {
            System.out.println("Commander: Went to Venus and brought nothing back..");
        }

        //if the player visited pluto
        if (planetsSeen.hasItem("Pluto") != -1) {
            System.out.println("Commander: You went to Pluto!!");
            System.out.println("Commander: How was the ultraviolet snow?\n");
        }
    }

    //called at the end of the game when the player returns to earth, displays the player's score
    public static void checkScore(Score newScore) {
        double num = newScore.getScore();
        System.out.println("You got a score of " + num);
        System.out.println("Well done!!");
        System.out.println("Enter 'quit' to finish the game! \n");
    }

    //called when the player goes to the sun '*'
    public static void sunPrompt() {
        System.out.println("The suns' storms have crushed your spaceship upon approach");
        System.out.println("--You fell into the sun and died.");
        System.out.println("Enter 'quit' to quit. \n");
    }

    //called when the player enters mercury '`'
    public static void mercuryPrompt() {
        System.out.println("--You have successfully landed on the COOL side of mercury.");
        System.out.println("Mercury is tidally locked with the sun, so one side permanently faces the sun while the other side faces away from the sun.");
        System.out.println("--You would rather not be on the side facing the sun.");
        System.out.println("--You might want to pick up night vision goggles because it's dark out.");
        System.out.println("--You are in Borealis Planitia. \n Enter 'look' for a description of the planet. \n Enter 'search' to search the area. \n Enter 'look at sky' for more info! \n Enter 'pick up' to collect rocks. \n Enter 'pick up night vision goggles' to see more things. \n Enter 'leave' to leave the planet. \n");
    }

    //called when the player enters mars '#'
    public static void marsPrompt() {
        System.out.println("--You have successfully landed on mars with no issues!");
        System.out.println("--It has gotten colder in your spacesuit.");
        System.out.println("--You wonder if there rumors of aliens are true ...");
        System.out.println("--You are on Mount Olympus. \n Enter 'look' for a description of the planet. \n Enter 'search' to search the area. \n Enter 'look at sky' for more info! \n Enter 'pick up' to collect rocks. \n Enter 'leave' to leave the planet. \n");
    }

    //venus prompt that comes up when entering venus '~'
    public static void venusPrompt() {
        System.out.println("--You roughly land on Venus. It was a bumpy ride.");
        System.out.println("Venus is a dense, hot planet, covered in volcanoes.");
        System.out.println(" It's atmosphere is full of greenhouse gases, which traps heat and has winds with speeds up to 360 km per hour.");
        System.out.println("--You thought that since Venus was the same size as the earth, walking on the planet would be easy.");
        System.out.println("--The current carbon dioxide storm happening outside your space ship says otherwise.");
        System.out.println("--You might want to pick up some studded boots.");
        System.out.println("--You are on Maat Mons.\n Enter 'look' for a description of the planet. \n Enter 'search' to search the area. \n Enter 'look at sky' for more info!\n Enter 'pick up' to collect rocks \n Enter 'pick up studded boots' so you can walk. \n Enter 'leave' to leave the planet. \n");

    }

    //called when the player enters jupiter 'O'
    public static void jupiterPrompt() {
        System.out.println("--You have decided to disobey your commanders orders and approach the gas giant!!");
        System.out.println("While the patterns on Jupiter are pretty, it's gravity crushes your spaceship with you inside it.");
        System.out.println("Enter 'quit' to quit. \n");
    }

    //called when the player enters saturn '@'
    public static void saturnPrompt() {
        System.out.println("--You have decided to disobey your commanders orders and approach arguable the prettiest planet");
        System.out.println("--You are sat admiring the rings.");
        System.out.println("A rock larger than your spaceship hit it.");
        System.out.println("You die of oxygen deprivation. At least you had a nice view before your death.");
        System.out.println("Enter 'quit' to quit. \n");
    }

    //called when the player enters uranus '¬'
    public static void uranusPrompt() {
        System.out.println("--You have decided to disobey your commanders orders and approach the light blue planet");
        System.out.println("--You try to land on the surface and then realise it's raining diamonds");
        System.out.println("Your spaceship isn't built to handle rocks falling from the sky.");
        System.out.println("You're not sure what will get you first; oxygen deprivation or starvation.");
        System.out.println("Enter 'quit' to quit. \n");
    }

    //called when the player enters neptune '='
    public static void neptunePrompt() {
        System.out.println("--You have decided to disobey your commanders orders and approach the dark blue planet");
        System.out.println("--You try to land on the surface and suddenly realise the pressure is too high.");
        System.out.println("Your spaceship begins to melt.");
        System.out.println("Enter 'quit' to quit \n");
    }

    //called when the player enters pluto 
    public static void plutoPrompt() {
        System.out.println("--You don't so much as land on pluto but you glide onto the planet.");
        System.out.println("Gravity is weak on Pluto.");
        System.out.println("--You are in The Heart. \n Enter 'look' for a description of the planet.  \n Enter 'look at sky' for more info! \n Enter 'search' to search the area. \n Enter 'pick up night vision goggles' to see more things. \n Enter 'leave' to leave the planet. \n");
    }

    //what the player sees after entering 'look at the sky'
    public static String planetFeature(Room newRoom, Inventory newStuff) {

        //checks if the player has the required item to look at the sky. if not then the player either dies or is sent back to their spaceship

        String result = "";
        if (newRoom.getName().equals("Mercury")) {
            if (newStuff.hasItem("night vision goggles") != -1) {
                result = result + "Mercury has no atmosphere, so the night sky is MUCH brighter! \n";
            } else {
                result = result + "--You can't see anything because you have no night vision goggles.\n--You go back to your spaceship. \n";
            }
        } else if (newRoom.getName().equals("Mars")) {
            result = result + "--You can faintly see Phobos and Deimos, Mars' moons!!";
        } else if (newRoom.getName().equals("Venus")) {
            if (newStuff.hasItem("studded boots") != -1) {
                result = result + "There's a storm and it's raining acid. \n--You hope the volcano behind you doesn't decide to become active. \n--You can feel the vague beginnings of a migraine. \n";
            } else {
                result = result + "--You decided to be smart and take no studded boots with you. \n--You are left at the mercy of the winds.\n --Enter 'quit' to leave. \n";
            }
        } else if (newRoom.getName().equals("Pluto")) {
            if (newStuff.hasItem("night vision goggles") != -1) {
                result = result + "--The sun looks like a dot in the sky.";
            } else {
                result = result + "--You can't see anything because you have no night vision goggles.\n--You go back to your spaceship. \n";
            }
        }
        return result;
    }

    //called when the player enters 'search'
    public static String search(Room newRoom, Inventory newStuff) {
        String result = "";
        switch (newRoom.getName()) {
            case "Mars":
                result = result + "The red surface is mesmerising and there's.. something? In the distance. \n--You assume it's rovers and move on. \n";
                break;
            case "Mercury":
                if (newStuff.hasItem("night vision goggles") != -1) {
                    result = result + "Surprisingly, mercury is mostly made up of iron and silicate rocks.";
                } else {
                    result = result + "--You can't see anything because you have no night vision goggles.\n--You go back to your spaceship. \n";
                }
                break;
            case "Venus":
                if (newStuff.hasItem("studded boots") != -1) {
                    result = result + "There are lava tracks on the floor and the ground is rumbling. A volcano must be near by. \n --You can't wait to get back home. \n";
                } else {
                    result = result + "--You decided to be smart and take no studded boots with you. \n--You are left at the mercy of the winds.\n --Enter 'quit' to leave. \n";
                }
                break;
            case "Pluto":
                if (newStuff.hasItem("night vision goggles") != -1) {
                    result = result + "Pluto is very rocky, very dark and very cold. At least it's a beautiful planet!";
                } else {
                    result = result + "--You can't see anything because you have no night vision goggles.\n--You go back to your spaceship.\n";
                }
                break;
            default:
                break;
        }
        return result;
    }

    //items you pick up to take back home
    public static void pickUp(Room newRoom, Inventory newStuff, Score newScore) {
        String result = "";
        switch (newRoom.getName()) {
            case "Mars":
                result = result + "--You've just picked up Iron Oxide. Don't inhale it.";
                System.out.println(result);
                newStuff.addItem("Massive Iron Oxide Rock");
                break;
            case "Mercury":
                if (newStuff.hasItem("night vision goggles") != -1) {
                    result = result + "--You've picked up a silica slab. It would be super sharp if you didn't have your spacesuit on.";
                    System.out.println(result);
                    newStuff.addItem("Silica Slab");
                    newScore.solvePuzzle();
                } else {
                    result = result + "--You can't see anything because you have no night vision goggles.\n --You go back to your spaceship.";
                    System.out.println(result);
                }
                break;
            case "Venus":
                if (newStuff.hasItem("studded boots") != -1) {
                    result = result + "--You've picked up a sulfur rock. It appears to be glowing yellow...";
                    System.out.println(result);
                    newStuff.addItem("Sulfur Oxide Rock");
                    newScore.solvePuzzle();
                } else {
                    result = result + "--You decided to be smart and take no studded boots with you. \n --You are left at the mercy of the winds.\n --Enter 'quit' to leave. ";
                    System.out.println(result);
                }
                break;
        
            default:
                break;
        }
    }

    //called when 'look items' is entered by the player, gives a description for each item if the player has it
    public static void lookAtItems(String input, Inventory newStuff) {
        Scanner inputDevice = new Scanner(System.in);
        input = inputDevice.nextLine();
        while (!(input.equals("exit"))) {
            switch (input) {
                case "inventory":
                    System.out.println(newStuff.displayInventory());
                    break;
                case "look map":
                    System.out.println("Shows where you are on the map.");
                    break;
                case "look telescope":
                    System.out.println("Lets you view the sky.");
                    break;
                case "look Massive Iron Oxide Rock":
                    if (newStuff.hasItem("Massive Iron Oxide Rock") != -1) {
                        System.out.println("It's rust from another planet!");
                    } else {
                        System.out.println("I'm afraid you do not have that in your inventory.");
                    }
                    break;
                case "look Silica Slab":
                    if (newStuff.hasItem("Silica Slab") != -1) {
                        System.out.println("This is a very pretty shade of blue.");
                    } else {
                        System.out.println("I'm afraid you do not have that in your inventory.");
                    }
                    break;
                case "look Sulfur Oxide Rock":
                    if (newStuff.hasItem("Sulfur Oxide Rock") != -1) {
                        System.out.println("It looks like something that a monster threw up. Ugly and Yellow.");
                    } else {
                        System.out.println("I'm afraid you do not have that in your inventory.");
                    }
                    break;
                case "look studded boots":
                    if (newStuff.hasItem("studded boots") != -1) {
                        System.out.println("Used for increased grip when walking the surface of Venus");
                    } else {
                        System.out.println("I'm afraid you do not have that in your inventory.");
                    }
                    break;
                case "look night vision goggles":
                    if (newStuff.hasItem("night vision goggles") != -1) {
                        System.out.println("Used to view the dark side of mercury clearly.");
                    } else {
                        System.out.println("I'm afraid you do not have that in your inventory.");
                    }
                    break;
            
                default:
                    System.out.println("I think you have entered the wrong command.");
                    break;
            }
            input = inputDevice.nextLine();
        }
        if (input.equals("exit")) {
            System.out.println("--You are no more viewing items in your inventory.");
        }
    }


    // called when the player enters a room
    public static void roomActions(String input, Room newRoom, Inventory newStuff, Score newScore) {
        Scanner inputDevice = new Scanner(System.in);
        input = inputDevice.nextLine();
            while (!(input.equals("leave")) && !(input.equals("quit"))) {
                switch (input) {
                    case "search":
                        System.out.println(search(newRoom, newStuff));
                        break;
                    case "help":
                        System.out.println("You are on the planet " + newRoom.getName() + " searching for rocks to take back to earth!");
                        System.out.println("Enter 'leave' if you're done searching this planet.");
                        break;
                    case "pick up":
                        pickUp(newRoom, newStuff, newScore);
                        break;
                    case "pick up night vision goggles":
                        newStuff.addItem("night vision goggles");
                        System.out.println("--You just picked up night vision goggles to explore mercury.");
                        break;
                    case "pick up studded boots":
                        newStuff.addItem("studded boots");
                        System.out.println("--You just picked up studded boots to explore venus.");
                        break;
                    case "look":
                        System.out.println(provideDescription(newRoom));
                        break;
                    case "look at sky":
                        System.out.println(planetFeature(newRoom, newStuff));
                        break;
                    case "inventory":
                        System.out.println(newStuff.displayInventory());
                        break;
                    case "crater":
                        System.out.println("You died.");
                        break;
                    default:
                        System.out.println("I think you've entered the wrong prompt.");
                        break;
                            }
                input = inputDevice.nextLine();
        }
        if (input.equals("quit")) {
            System.out.println("Enter 'quit' again.");
        }
    }

    public static void main(String[] args) {

        Scanner inputDevice = new Scanner(System.in);

        Map space = new Map(21, 10);

        //the players stats
        Inventory usersPockets = new Inventory();

        usersPockets.addItem("beamer");
        System.out.println(usersPockets.displayInventory());

        Inventory roomsUserVisited = new Inventory();
        int xCoord = 10;
        int yCoord = 2;
        Position userPosition = new Position(xCoord, yCoord);
        Score userScore = new Score(0);
        Player user = new Player(userPosition, usersPockets, roomsUserVisited);

        //The 'planets/rooms' in space
        Position center = new Position(10, 4);
        Room sun = new Room("Sun", "The sun takes up most of the mass in the solar system", '*', center);
        space.placeRoom(center, sun.getSymbol());

        Position closeToSun = new Position(14, 4);
        Room mercury = new Room("Mercury", "Mercury, closest planet to the sun.", '`', closeToSun);
        space.placeRoom(mercury.getPosition(), mercury.getSymbol());

        Position secondFromSun = new Position(16, 2);
        Room venus = new Room("Venus", "Venus, Hottest planet in the solar system!", '~', secondFromSun);
        space.placeRoom(venus.getPosition(), venus.getSymbol());

        Position thirdFromSun = new Position(10, 1);
        Room earth = new Room("Earth", "Earth, The only habitable planet", '&', thirdFromSun);
        space.placeRoom(earth.getPosition(), earth.getSymbol());

        Position fourthFromSun = new Position(4, 2);
        Room mars = new Room("Mars", "Mars, the red planet.", '#', fourthFromSun);
        space.placeRoom(fourthFromSun, mars.getSymbol());

        Position fifthFromSun = new Position(2, 4);
        Room jupiter = new Room("Jupiter", "Jupiter, largest planet in the solar system!!", 'O', fifthFromSun);
        space.placeRoom(fifthFromSun, jupiter.getSymbol());

        Position sixthFromSun = new Position(4, 6);
        Room saturn = new Room("Saturn", "Saturn has the most beautiful rings!", '@', sixthFromSun);
        space.placeRoom(sixthFromSun, saturn.getSymbol());

        Position seventhFromSun = new Position(10, 7);
        Room uranus = new Room("Uranus", "Uranus is a pale blue planet, the first to be discovered by telescope.", '¬', seventhFromSun);
        space.placeRoom(seventhFromSun, uranus.getSymbol());
        
        Position eighthFromSun = new Position(14, 8);
        Room neptune = new Room("Neptune", "Neptune, the first planet to be discovered by mathematical calculations.", '=', eighthFromSun);
        space.placeRoom(eighthFromSun, neptune.getSymbol());

        Position ninthFromSun = new Position(18, 9);
        Room pluto = new Room("Pluto", "Pluto, the planet with a heart shaped plain on it.", '+', ninthFromSun);
        space.placeRoom(pluto.getPosition(), pluto.getSymbol());

        //position for planets that the user has been to before, which appears on top of the planet
        Position beenThere = new Position(0, 0);

        gameCommands();
        System.out.println("");
        String userInput = inputDevice.nextLine();


        if (userInput.equals("start")) {
            //initial prompt
            initPrompt(usersPockets);

            //asks the player where they would like to go then displays the player on the map
            System.out.println("What planet would you like to go to?\n '%' - You\n '*' - The sun\n '`' - Mercury\n '~' - Venus\n '&' - Earth\n '#' - Mars\n 'O' - Jupiter\n '@' - Saturn\n '¬' - Uranus \n '£' - Neptune \n '+' - Pluto \n 'v' - for planets you've visited!!");
            userPosition = new Position(xCoord, yCoord);
            user.movePlayer(space, '%', userPosition);
            System.out.println(space.display());;
            
            while (!(userInput.equals("quit"))) {
                switch (userInput) {
                    // starts the game
                    case "start":
                        break;

                    //shows the player the map
                    case "map":
                        userPosition = new Position(xCoord, yCoord);
                        user.movePlayer(space, '%', userPosition);
                        System.out.println(space.display());
                        break;

                    //shows the player the inventory
                    case "inventory":
                        System.out.println(usersPockets.displayInventory());
                        break;

                    //shows description of items
                    case "look items":
                        System.out.println("Enter 'look <item>' where <item> stands for an item in your inventory.");
                        System.out.println("Enter 'exit' to leave your inventory.");
                        lookAtItems(userInput, usersPockets);
                        break;
                    
                    //shows the player their score
                    case "score":
                        System.out.println("SCORE: " + userScore.getScore());
                        break;

                    //gives the player context on where they are and reminds them of the controls
                    case "help":
                        userPosition = new Position(xCoord, yCoord); 
                        user.movePlayer(space, '%', userPosition);
                        System.out.println("You are the '%' character on the map.");
                        System.out.println(space.display());
                        System.out.println("What planet would you like to go to?\n '%' - You\n '*' - The sun\n '`' - Mercury\n '~' - Venus\n '&' - Earth\n '#' - Mars\n 'O' - Jupiter\n '@' - Saturn\n '¬' - Uranus \n '£' - Neptune \n '+' - Pluto \n 'v' - for planets you've visited!!");
                        System.out.println("Don't forget to move your player over the correct symbol for the planet you want to go to.");
                        System.out.println("Then enter the symbol for the planet! \n");
                        break;

                    //moves up
                    case "move north":
                        yCoord -= 1;
                        userPosition = new Position(xCoord, yCoord);
                        user.movePlayer(space, '%', userPosition);
                        System.out.println(space.display());
                        break;

                    //moves down
                    case "move south":
                        yCoord += 1;
                        userPosition = new Position(xCoord, yCoord);
                        user.movePlayer(space, '%', userPosition);
                        System.out.println(space.display());
                        break;

                    //moves left
                    case "move west":
                        xCoord -= 1;
                        userPosition = new Position(xCoord, yCoord);
                        user.movePlayer(space, '%', userPosition);
                        System.out.println(space.display());
                        break;
                    
                    //moves right
                    case "move east":
                        xCoord += 1;
                        userPosition = new Position(xCoord, yCoord); 
                        user.movePlayer(space, '%', userPosition);
                        System.out.println(space.display());
                        break;

                    //the sun
                    case "*":
                        if (userPosition.x == center.x && userPosition.y == center.y) {
                            sunPrompt();
                        }
                        break;
                    
                    // mercury
                    case "`":
                        if (userPosition.x == closeToSun.x && userPosition.y == closeToSun.y) {
                            //stats
                            userScore.visitRoom();
                            user.getNameOfRooms().addItem(mercury.getName());
                            user.updateRoomsVisited();

                            //in mercury
                            mercuryPrompt();
                            roomActions(userInput, mercury, usersPockets, userScore);
                        
                            //leaving mercury
                            xCoord = 14;
                            yCoord = 5;
                            System.out.println("--You have just left Mercury.");
                            userPosition = new Position(xCoord, yCoord);
                            user.movePlayer(space, '%', userPosition);

                            //places a 'v' above the room if the player has been there
                            beenThere = new Position(14, 3);
                            space.placeRoom(beenThere, 'v');
                            System.out.println(space.display());
                            }
                        break;

                    // mars      
                    case "#":
                        if (userPosition.x == fourthFromSun.x && userPosition.y == fourthFromSun.y) {
                            //stats
                            userScore.visitRoom();
                            user.getNameOfRooms().addItem(mars.getName());
                            user.updateRoomsVisited();

                            //in mars
                            marsPrompt();
                            roomActions(userInput, mars, usersPockets, userScore);
                        
                            //leaving mars
                            xCoord = 4;
                            yCoord = 3;
                            System.out.println("--You have just left Mars.");
                            userPosition = new Position(xCoord, yCoord);
                            user.movePlayer(space, '%', userPosition);

                            //places a 'v' above the room if the player has been there
                            beenThere = new Position(4, 1);
                            space.placeRoom(beenThere, 'v');
                            System.out.println(space.display());
                        }
                        break;

                    // venus
                    case "~":
                        if (userPosition.x == secondFromSun.x && userPosition.y == secondFromSun.y) {
                            //stats
                            userScore.visitRoom();
                            user.getNameOfRooms().addItem(venus.getName());
                            user.updateRoomsVisited();

                            //in venus
                            venusPrompt();
                            roomActions(userInput, venus, usersPockets, userScore);

                            //leaving venus
                            xCoord = 16;
                            yCoord = 3;
                            System.out.println("--You have just left Venus.");
                            userPosition = new Position(xCoord, yCoord);
                            user.movePlayer(space, '%', userPosition);

                            //places a 'v' above the room if the player has been there
                            beenThere = new Position(16, 1);
                            space.placeRoom(beenThere, 'v');
                            System.out.println(space.display());;
                        }
                        break;

                    //jupiter
                    case "O":
                        if (userPosition.x == fifthFromSun.y && userPosition.y == fifthFromSun.y) {
                            jupiterPrompt();
                        }
                        break;

                    //saturn
                    case "@":
                        if (userPosition.x == sixthFromSun.x && userPosition.y == sixthFromSun.y) {
                            saturnPrompt();
                        }
                        break;

                    //uranus
                    case "¬":
                        if (userPosition.x == seventhFromSun.x && userPosition.y == seventhFromSun.y) {
                            uranusPrompt();
                        }
                        break;

                    //neptune
                    case "=":
                        if (userPosition.x == eighthFromSun.x && userPosition.y == eighthFromSun.y) {
                            neptunePrompt();
                        }
                        break;
                    
                    //pluto
                    case "+": 
                        if (userPosition.x == ninthFromSun.x && userPosition.y == ninthFromSun.y) {
                            //stats
                            userScore.visitRoom();
                            user.updateRoomsVisited();
                            user.getNameOfRooms().addItem(pluto.getName());

                            //in venus
                            plutoPrompt();
                            roomActions(userInput, pluto, usersPockets, userScore);

                            //leaving pluto
                            xCoord = 17;
                            yCoord = 9;
                            System.out.println("--You have just left Pluto.");
                            userPosition = new Position(xCoord, yCoord);
                            user.movePlayer(space, '%', userPosition);

                            //places a 'v' above the room if the player has been there
                            beenThere = new Position(18, 8);
                            space.placeRoom(beenThere, 'v');
                            System.out.println(space.display());
                        }
                        break;
                    
                    //earth
                    case "&":
                        if (userPosition.x == thirdFromSun.x && userPosition.y == thirdFromSun.y) {
                            earthPrompt();
                            checkRoomsVisited(user);
                            checkPlanetsVisited(user);
                            checkScore(userScore);
                        }
                        break;    
                    default:
                        System.out.println("I think you've entered the wrong prompt.");
                        break;
                }
                userInput = inputDevice.nextLine();
            }

        }

        System.out.println("Game Over.");
    
    }
    
}