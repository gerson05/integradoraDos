package model;



public class Level {
    public static final int MAXNUMBERNEMY = 25;
    public static final int MAXNUMBERTREASURE= 50; 
    
    // Attribute to identify the level
    private int identify;
    // Minimum points required by the level to level up
    private int pointNext;

    
    /*RELATIONS */
    private Enemy enemies[];
    private Traisure treasure[];

    /*METHODS */

    public Level(int identify, int pointNext){
        this.identify= identify;
        this.pointNext= pointNext;
        enemies = new  Enemy[MAXNUMBERNEMY];
        treasure = new Traisure[MAXNUMBERTREASURE];
    }


    public static int randomY() {
        return (int)( Math.random()*720) + 1;
    }

    public static int randomX() {
        return (int) (Math.random()*1280) + 1;
    }
    
    /**
     * 
     * @param name
     * @param typeEnemy
     * @return message (String) 
     * 
     * Description: this method records the diferent enemies in the array of enemies
     */
    public String registerEnemy(String name, int typeEnemy) {
        int positionX = randomX();
        int positionY = randomY();
        boolean stop = false;
        String message = "The enemy was registered successfully, the position in X is : " + positionX + " and the position en Y is: "+ positionY;

        if (searchEnemy(name) == null) {
            Enemy newEnemy = new Enemy(name, typeEnemy);
            for (int i = 0; i < MAXNUMBERNEMY && !stop; i++) {
                if (enemies[i] == null) {
                    enemies[i] = newEnemy;
                    stop = true;
                }
            }
        } else {
            message = "Enemy name not valid";
        }
        return message;
    }
    

    /**
     * 
     * @param name
     * @param url
     * @param totalPoint
     * @param cant
     * @return message (String) 
     * 
     *Description: this method records the diferents treasures for the array of treasure 
     */
    public String registerTreasure(String name, String url, int totalPoint, int cant) {
        Traisure objTreasure = searchTreasure(); 
        boolean condition = false;
        String message = "The treasure was successfully registered";
        for (int i = 0; i < MAXNUMBERTREASURE && !condition; i++) {
           if (objTreasure == null) {
                for (int j = 0; j < cant; j++) {
                    objTreasure = new Traisure(name, url, totalPoint, cant);
                    condition = true;
                }
           } else {
            message ="cannot register the treasure";
           }
        }
        return message;
    }

    /**
     * Description: this method record the dificulty of the diferents levels 
     * @return message (String)
     */

    public String dificultyLevel(){
        int sumPointsEnemies = 0;
        int sumPointsTresure = 0;
        String message = "";
        for(int i =0;i < enemies.length;i++){
            sumPointsEnemies += enemies[i].getRestPoint();
        }
        for(int j=0; j< treasure.length; j++){
            sumPointsTresure = treasure[j].getTotalPoint();
        }
        if(sumPointsTresure > sumPointsEnemies){
            message = "the dificulty level is easy";
        }
        if(sumPointsTresure == sumPointsEnemies){
            message = "the level dificulty is normal";
        }
        if(sumPointsTresure< sumPointsEnemies){
            message= "the dificulty level is hard";
        }
        return message;
    }

    /**
     * Description: this method search if the enemy name already exist in the array of enemies
     * @param Name
     * @return objEnemies (Enemy)
     */

        public Enemy searchEnemy(String Name){
            Enemy objEnemies= null ;
            boolean confirm= false ;
            for(int i= 0; i<enemies.length && !confirm; i++){
                if(enemies[i]!=null){
                    if(enemies[i].getName().equalsIgnoreCase(Name)){
                        objEnemies=enemies[i];
                        confirm= true;
                    }
                }
            }
        return objEnemies;
        }


        /**
         * Description: this method check if there are space in the array of enemies 
         * @return boolean
         */

        public boolean spaceEnemy() {
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i] == null) {
                    return true;
                }
            }
            return false;
        }

        /**
         * Description: this method chekc if there are space in the array of treasures
         * @return boolean
         */

        public boolean spaceTreasure(){
            for(int i=0;i< treasure.length;i++){
                if(treasure[i]==null)
                return true;
            }
            return false;
        }
    
    
        /**
         * Description:this method check if there are space in the array
         * @param Name
         * @return objTreasure (Traisure) 
         */
        public Traisure searchTreasure() {
            Traisure objTreasure = null ;
            boolean confirm = false ;
            for(int i= 0; i < treasure.length && !confirm; i++) {
                if (treasure[i] != null) {
                    objTreasure = treasure[i];
                    confirm = true;
                }
            }
            return objTreasure;
        }

        /**
         * Description: this method return the num of enemies for the array
         * @return numEnemies (int)
         */
        public int getNumEnemies() {
            int numEnemies = 0;
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i] != null) {
                    numEnemies++;
                }
            }
            return numEnemies;        
        }
    
        /**
         * Description: this method return the num of treasure for the array
         * @return numTreasures (int)
         */
        public int getNumTreasures() {
            int numTreasures = 0;
            for (int i = 0; i < treasure.length; i++) {
                if (treasure[i] != null) {
                    numTreasures++;
                }
            }
            return numTreasures;        
        }
    
        /**
         * Description: this method return the num of treasure for the array with the name enter by a user 
         * @param name
         * @return cont (int)
         */
        public int countTreasure(String name) {
            int cont = 0;

            for(int i=0; i<treasure.length;i++){
                if(treasure[i]!=null){
                    if(name== treasure[i].getName()){
                        cont++;
                    }
                }
                
            }
            return cont;
        }

        /**
         * Description: this method return de num enemies of one type enter by the user in the array
         * @param TypeEnemy
         * @return count (int)
         */
        public int totalEnemyType(String typeEnemy) {
            int count = 0;
            for(int i = 0; i < enemies.length; i++) {
                if (enemies[i] != null && typeEnemy.equals(enemies[i].getEnemyConstantType())) {
                    count++;
                } else {
                    System.out.println("invalid type of enemy");
                } 
            }
            return count; 
        }

        /**
         * Description:this method return the num of consonant of enemies 
         * @return count (int)
         */
        public int totalConstantEnemy() {
            int count = 0;
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i] != null) {
                    String enemyName = enemies[i].getName().trim().toLowerCase();
                    for (int j = 0; j < enemyName.length(); j++) {
                        char consonant = enemyName.charAt(j);
                        if (consonant != 'a' && consonant != 'e' && consonant != 'i' &&
                                consonant != 'o' && consonant != 'u') {
                            count++;
                        }
                    }
                } 

            }
            return count;
        }

        /**
         * Description: this method return the enemy with highest points
         * @return enemigopah (Enemy)
         */
        public Enemy highestPointEnemy() {
            int temporal = 0 ;
            Enemy enemigopah = null;
            for (int i = 0; i < enemies.length; i++) {
                Enemy currentEnemy = enemies[i];
                if (currentEnemy != null && currentEnemy.getSumPoint() > temporal) {
                    temporal = currentEnemy.getSumPoint();
                    enemigopah = enemies[i];
                }
            }
            return enemigopah;
        }

        /**
         * Description: this method return the most repeat treasure
         * @return temp (Traisure)
         */
        public Traisure repeatTreasure(){
            Traisure temp = null;
            int higher=0;
            for(int i=0; i< treasure.length;i++){
                if(treasure[i].getCant() > higher){
                    higher =treasure[i].getCant();
                    temp = treasure[i];
                    }
            }
            return temp;
        }

    

    /*SETTERS AND GETTERS */
    public int getIdentify() {
        return identify;
    }

   
    public void setIdentify(int identify) {
        this.identify = identify;
    }

    
    public int getPointNext() {
        return pointNext;
    }

   
    public void setPointNext(int pointNext) {
        this.pointNext = pointNext;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public Traisure[] getTreasure() {
        return treasure;
    }

    

    


}
