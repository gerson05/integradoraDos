
package model;

public class Game {

    public static final int MAXPLAYER = 20;
    public static final int CANTLEVELS = 10;

    
    /*RELATIONS */
    private Player[] players;
    private Level levels[];
    /*METHODS */ 
    public Game() {
        players = new Player[MAXPLAYER];
        levels = new Level[CANTLEVELS];
        for (int i = 0; i < levels.length; i++) {
            levels[i] = new Level(i+1, 500);
        }
    }

    /**
    * Description: this method create the player for the game 
    * @param nickname
    * @param name
    * @return message (String) 
    */
    public String createPlayer(String nickname, String name ){
        
        // int identify =levels[0].getIdentify();
        // int pointNext = levels[0].getPointNext();
        String message = "The player was successfully registered";

        Player objPlayer = searchPlayer(nickname);
        boolean stop = false;

        if (objPlayer == null) {
            objPlayer = new Player(nickname, name);
            for (int i = 0; i < MAXPLAYER && !stop; i++) {
                if (players[i] == null) {
                    players[i] = objPlayer;
                    stop = true;
                } 
            }
        } else {
            message = "Nickname already in use";
        }
        return message;
    }

    /**
     * Description this method search if there is exist a player with a nickname already take 
     * @param nickname
     * @return objPlayer (Player)
     */

    public Player searchPlayer(String nickname){
        
        Player objPlayer= null ;
        boolean confirm= false ;
        for(int i= 0; i<players.length && !confirm; i++){
            if(players[i]!=null){
                if(players[i].getNickname().equalsIgnoreCase(nickname)){
                    objPlayer=players[i];
                    confirm= true;
                }
            }
        }
        return objPlayer;
    }

    /**
     * Description: This method creates the different levels for the game with no enemies
     * @return message (String)
     */

    public String createLevels() {
        int pointNext = 50;
        for (int i = 1; i <= CANTLEVELS; i++) {
            // Creation of a new level with identify value equals to index and the minimum points with pointNext variable
            levels[i]= new Level(i, pointNext);
            pointNext +=100;
        }
        return "The levels were successfully created";
    }

    /**
     * Description:this method return the position of the level
     * @param identify
     * @return levelposition (int)
     */

    public int searchLevel(int identify) {
        int levelposition =-1;
        boolean condition= false;
        for (int i =0; i<levels.length && !condition; i++) {
            if (levels[i] !=null && levels[i].getIdentify() ==(identify)) {
                levelposition=i;
                condition= true;
            }
        }
        return levelposition;
    }
    
    /**
     * Description this method search a player for his nickname in the array
     * @param nicknameOfPlayer
     * @return userPlayer (Player)
     */

    public Player searchUser(String nicknameOfPlayer) {
        Player userPlayer = null;
        boolean condition = false;
        for (int i=0; i < players.length && !condition; i++) {
            if (players[i].getNickname().equals(nicknameOfPlayer)) {
                userPlayer = players[i];
                condition = true;
            }
           
        }
        return userPlayer;
    }

    /**
     * Description this method increase the level of one player
     * @param name
     * @return message (String)
     */

    public String increasePlayerLevel(String name) {
        String message = "";
        Player player = searchUser(name);
        if (player != null) {
            if (player.getPoints() >= player.getMyLevel().getPointNext()) {
                player.setMylevel(levels[player.getMyLevel().getIdentify() + 1]);
                message ="The player "+ player.getName() + " has a level up";

            } else {
                message ="The player "+ player.getName() +" cannot level up";
            }
        } else {
            message = "Player with nickname " + name + "not found";
        }
        return message;
    }

    /**
     * Description: this method return the amount of enemies and treasures
     * @param level
     * @return message (String)
     */
    public String listEnemiesAndTreasures(int level) {
        Level myLevel = levels[level];
        return "The level " + level +  "has " + myLevel.getNumEnemies() +
            ", " + myLevel.getNumTreasures() + "enemies and treasures respectively";
    }

    /**
     * Description: this method register an enemy in a level gave for user
     * @param leveloption
     * @param name
     * @param typeOfEnemy
     * @return register enemy in level 
     */
    public String registerEnemy2(int leveloption, String name, int typeOfEnemy) {
        return levels[leveloption].registerEnemy(name, typeOfEnemy);
    }

    /**
     * Descrption: this method register an treasure in a level
     * @param leveloption
     * @param name
     * @param url
     * @param point
     * @param cant
     * @return register treasure in a level
     */
    public String registerTreasure2(int leveloption, String name, String url,int point, int cant) {
        return levels[leveloption].registerTreasure(name, url, point, cant);
    }

    /**
     * Description: this method return the total num of treasure for all levels with a name 
     * @param name
     * @return message (String)
     */
   public String totalNumTreasureLevel( String name) {
        int count = 0;

        for(int i =0; i < levels.length; i++){
        count += levels[i].countTreasure(name);
        }
        return "the treasure total num with name: " +name+ "is: "+ count;
    }

    /**
     * Descrption: this method return the total number enemy of one type
     * @param type
     * @return message (String)
     */
    public String typeEnemyToShow(String type) {
        int count = 0;
        for(int i = 0; i < levels.length; i++) {
            count += levels[i].totalEnemyType(type);
        }
        return "The total num of enemis with the type: " +type+ " is: "+ count;
    }
   
    /**
     * Description: this method return the total number of consonants for enemies 
     * @return message (String)
     */
   public String consonantseEnemy() {
    int count = 0;
    for (int i =0; i < levels.length;i++) {
        count += levels[i].totalConstantEnemy();
    }
    System.out.println(count);
    return "the num of consonants in enemis is: " + count;
   }

   /**
    * Description:this method retunr the enemy with the the best points 
    * @return message (String)
    */
   public String showHighestPointEnemy() {
    int points = 0;
    String name = "";
    int level = 0;
    for (int i = 0; i < levels.length; i++) {
        Enemy currentEnemy = levels[i].highestPointEnemy();
        if (currentEnemy != null && currentEnemy.getSumPoint() > points) {
            points = levels[i].highestPointEnemy().getSumPoint();
            name = currentEnemy.getName();
            level = levels[i].getIdentify();
        }
    }
    return "the enemy with de hightest points is: " + points + " his name is: " + name + " in the level "+ level;
   }

   /**
    * Description: this method return the most repeat treasure 
    * @return message (String)
    */
   public String repeatTreasureLevel(){
    String message ="";
    Traisure obj=null;
    for(int i=0; i<levels.length;i++){
        if(obj == null){
            obj= levels[i].repeatTreasure();
            }else if(levels[i].repeatTreasure().getCant()> obj.getCant()){
                obj= levels[i].repeatTreasure();
        }
    }
    message= "the traisure most repeat in all levels is: "+ obj.getName();
    return message;
   }

   /**
    * Description: this method return the top of best players in points 
    * @return ranking
    */
    public Player[] ranking() {
        sortPlayersByScore();
        Player[] ranking = new Player[5];
        for (int i = 0; i < ranking.length; i++) {
            Player currentPlayer = players[i];
            if (currentPlayer != null) {
                ranking[i] = currentPlayer;
            }
        }
        return ranking;
    }
    /**
     * Description: this method sorts the list of players by its scores
     */
    private void sortPlayersByScore() {
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < players.length - 1; j++) {
                Player currentPlayer = players[j];
                Player nextPlayer = players[j+1];
                if (currentPlayer != null && nextPlayer != null 
                    && currentPlayer.getPoints() < nextPlayer.getPoints()) {
                    players[j] = nextPlayer;
                    players[j+1] = currentPlayer;
                }
            }
        }
    }

    public Level[] getLevels() {
        return levels;
    }

    public Player[] getPlayers() {
        return players;
    }

   
}

