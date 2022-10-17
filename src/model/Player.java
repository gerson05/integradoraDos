package model;


public class Player {

    private String nickname;
    private String name;
    private int points;
    private int lives;
    private int level;
    


    /*relations  */
    private Level myLevel;
    /*methods*/
    public Player(String nickname, String name ){
        this.nickname= nickname;
        this.name=name;
        lives= 5;
        points=10;
        level=1;
        this.myLevel= new Level(level, points);

    } 

    

    /*setters y getters */
    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public String getNickname(){
        return nickname;
    }

    public void setName(String name ){
     this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setPoints(int points){
        this.points= points;
    }

    public int getPoints(){
        return points;
    }

    public void setLives(int lives ){
        this.lives = lives;
    }

    public int getLives(){
        return lives;
    }

    public void setLevel(int level){
        this.level= level;
    }

    public int getLevel(){
        return level;
    }
    
    public Level getMyLevel(){
        return myLevel;
    }
    
    public void setMylevel(Level myLevel){
        this.myLevel= myLevel;
    }
}