package model;

public class Traisure {
    private String name;
    private String url;
    private int totalPoint;
    private int cant; 
    private int positionX;
    private int positionY;



    /*METHODS */
    public Traisure(String name, String url, int totalPoint, int cant){
        this.name=name;
        this.url=url;
        this.totalPoint=totalPoint;
        this.cant=cant;
        this.positionX = Level.randomX();
        this.positionY = Level.randomY();
    }
    
    /*SETTER Y GETTERS */
    public String getName() {
        return name;
    }

   
    public void setName(String name) {
        this.name = name;
    }

   
    public String getUrl() {
        return url;
    }

  
    public void setUrl(String url) {
        this.url = url;
    }

   
    public int getTotalPoint() {
        return totalPoint;
    }

    
    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }


    public int getCant() {
        return cant;
    }

    
    public void setCant(int cant) {
        this.cant = cant;
    }

}