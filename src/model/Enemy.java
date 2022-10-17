package model;

public class Enemy {
	public static final String OGROS= "OGROS";
	public static final String ABSTRACTOS= "ABSTRACTO";
	public static final String JEFES ="JEFE";
	public static final String MAGICOS ="MAGICO";
	private String name;
	private int typeEnemy;
	private String enemyConstantType;
	private int restPoint;
	private int sumPoint;
	private int positionX;
	private int positionY;


	/*RELATIONS */

	/*METHODS */
	public Enemy(String name, int typeEnemy) {
		this.name = name;
		this.typeEnemy= typeEnemy;
		this.enemyConstantType = registerTypeEnemy(typeEnemy);
		this.positionX = Level.randomX();
		this.positionY = Level.randomY();
		this.sumPoint = setPointEnemies(typeEnemy);
		this.restPoint = -setPointEnemies(typeEnemy);
	}

	/**
	 * Description: this method records the points for the enemies 
	 * @return sumPointEnemies (int) 
	 */
	public int setPointEnemies(int type) {
		int sumPointEnemies = 0;
		if (enemyConstantType == OGROS) {    
			sumPointEnemies = 5;
		}
		else if(enemyConstantType == ABSTRACTOS) {
			sumPointEnemies = 10;
		}
		else if(enemyConstantType == JEFES) {
			sumPointEnemies= 30;
		}
		else if(enemyConstantType == MAGICOS) {
			sumPointEnemies = 15;
		}
		return sumPointEnemies;
	}


   /**
	* Description this method records the type of enemy
	* @param typeEnemy
	* @return constantEnemy (String) 
	*/

	public String registerTypeEnemy(int typeEnemy){

		String constantEnemy="";
		switch(typeEnemy){
			case 1:
			constantEnemy = Enemy.OGROS;
			break; 

			case 2:
			constantEnemy = Enemy.ABSTRACTOS;
			break;

			case 3:
			constantEnemy = Enemy.JEFES;
			
			break;

			case 4:
			constantEnemy = Enemy.MAGICOS;
			break;
		}
		return constantEnemy;
	}


	/*SETTERS AND GETTERS */
	public String getName() {
		return name;
	}

  
	public void setName(String name) {
		this.name = name;
	}

	
	public int getTypeEnemy() {
		return typeEnemy;
	}

   
	public void setTypeEnemy(int typeEnemy) {
		this.typeEnemy = typeEnemy;
	}

	
	public int getRestPoint() {
		return restPoint;
	}

	
	public void setRestPoint(int restPoint) {
		this.restPoint = restPoint;
	}

	
	public int getSumPoint() {
		return sumPoint;
	}

	
	public void setSumPoint(int sumPoint) {
		this.sumPoint = sumPoint;
	}


	/**
	 * @return String return the enemyConstantType
	 */
	public String getEnemyConstantType() {
		return enemyConstantType;
	}

	/**
	 * @param enemyConstantType the enemyConstantType to set
	 */
	public void setEnemyConstantType(String enemyConstantType) {
		this.enemyConstantType = enemyConstantType;
	}

	/**
	 * @return int return the positionX
	 */
	public int getPositionX() {
		return positionX;
	}

	/**
	 * @param positionX the positionX to set
	 */
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	/**
	 * @return int return the positionY
	 */
	public int getPositionY() {
		return positionY;
	}

	/**
	 * @param positionY the positionY to set
	 */
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

}
