package ui;
import model.Game;
import java.util.Scanner;
  
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Game game = new Game();

    public static void createVideoGame() { 
        game.createLevels();
    }
    
    public static void addPlayer() {
        System.out.println("Enter the name of the player");
        String namePlayer = sc.nextLine();
        System.out.println("Enter the nickname of the player");
        String nicknamePlayer = sc.nextLine();
        System.out.println(game.createPlayer(namePlayer, nicknamePlayer));
    }

    public static void addEnemy() {
        System.out.println("Enter the level to regiter the enemy in the range of 1 to 10");
        int leveloption = sc.nextInt();
        while (leveloption < 1 || leveloption > 10) {
            System.out.println("Error: enter the level in the expected range");
            leveloption = sc.nextInt();
        }
        sc.nextLine();
        if (game.getLevels()[leveloption-1].spaceEnemy()) {
            System.out.println("Enter the name of the enemy");
            String nameEnemy = sc.nextLine();
            System.out.println("Enter the type of the enemy:\n1. Ogros\n2 Abstracto\n3 Jefe\n4 Magico");
            int typeOfEnemy = sc.nextInt();

            String message = game.registerEnemy2(leveloption, nameEnemy,typeOfEnemy);
            System.out.println(message);
        }
    }

    public static void addtreasure() {
        System.out.println("Enter the level to regiter the treasure in the range of 1 to 10");
        int leveloption = sc.nextInt();
        while (leveloption < 1 || leveloption > 10) {
            System.out.println("Enter the level in the expected range");
            leveloption = sc.nextInt();
        }
        sc.nextLine();
        if (game.getLevels()[leveloption-1].spaceTreasure()) {
            System.out.println("Enter the name of the treasure");
            String nameTreasure = sc.nextLine();
            System.out.println("Enter the url for the treasure");
            String urlTreasure = sc.nextLine();
            System.out.println("Enter the total poinst of rewards for the treasure");
            int rewardTreasure = sc.nextInt();
            System.out.println("Enter the cant particular for the treasure");
            int cantTreasure = sc.nextInt();

            while (cantTreasure < 1 || cantTreasure > 50) {
                System.out.println("Error: enter the amount of treasures in the expected range");
                cantTreasure = sc.nextInt();
            }

            String message = game.registerTreasure2(leveloption, nameTreasure, urlTreasure,rewardTreasure,cantTreasure);
            System.out.println(message);
        } 
    }

    public static String modifyPointsPlayer() {
        String message = "the points was modify successful";
        System.out.println("Enter the total points for register in player");
        int points = sc.nextInt();
        System.out.println("Enter the nickname of the player");
        String nicknamePlayer = sc.nextLine();
        game.searchUser(nicknamePlayer).setPoints(points);
        return message;
    }

    public static void increaseLevel() {
        System.out.println("ingrese el nickname del jugador");
        String nickname = sc.nextLine();

        System.out.println(game.increasePlayerLevel(nickname));
    }

    public static void numEnemiesAndTreasures() {
        System.out.println("Enter the level to know the number of enemies and treasures");
        int level = sc.nextInt();

        if (level >=1 || level<=10) {
           System.out.println(game.listEnemiesAndTreasures(level));
        }
    }

    public static void cantFoundOfTreasure() {
        System.out.println("enter the name of the treasure that you want search in levels");
        String name = sc.nextLine();

        System.out.println(game.totalNumTreasureLevel(name));
    }

    public static void cantFoundOfEnemy() {
        System.out.println("Enter the type of enemy for serach in levels");
        String typeEnemey = sc.nextLine().toUpperCase();
        System.out.println(game.typeEnemyToShow(typeEnemey));
    }

    public static void enemyConsonant() {
        System.out.println(game.consonantseEnemy());
    }

    public static void pointHighEnemy() {
        System.out.println(game.showHighestPointEnemy());
    }

    public static void treasureRepeat() {
        System.out.println(game.repeatTreasureLevel());
    }

    public static void top() {
        for(int i = 0; i < 5; i++) {
            System.out.println(game.ranking()[i].getNickname()+""+game.ranking()[i].getPoints());
        }
        System.out.println(game.ranking());
    }
    
    public static void menu() {
        int opt = 0;
        String message = "bievenido a el juego escoge la opcion que desees realizar: "+"\n\n"+
            "1. Register  player\n"+
            "2. Register  enemy\n"+
            "3. Register treasure\n"+
            "4. Modify points player\n"+
            "5. Increase points of player\n"+
            "6. list enemies and treasures\n"+
            "7. cant found of tresures \n"+
            "8. Type enemy for all levels\n"+
            "9. Constant enemies\n"+
            "10. Highest points of enemy\n"+
            "11. Repeat Treasure levels\n"+
            "12. Top player\n"+
            "13. out";
        do {
            System.out.println(message);
            opt = sc.nextInt();
            switch(opt) {
                case 1:
                    sc.nextLine();
                    addPlayer();
                    System.out.println(message);
                    break;

                case 2:
                    sc.nextLine();
                    addEnemy();
                    System.out.println(message);
                    break;

                case 3:
                    sc.nextLine();
                    addtreasure();
                    System.out.println(message);
                    break;

                case 4:
                    sc.nextLine();
                    modifyPointsPlayer();
                    System.out.println(message);
                    break;

                case 5:
                    sc.nextLine();
                    increaseLevel();
                    System.out.println(message);
                    break;

                case 6:
                    sc.nextLine();
                    numEnemiesAndTreasures();
                    System.out.println(message);
                    break;
                
                case 7:
                    sc.nextLine();
                    cantFoundOfTreasure();
                    System.out.println(message);
                    break;

                case 8:
                    sc.nextLine();
                    cantFoundOfEnemy();
                    System.out.println(message);
                    break;
                
                case 9:
                    sc.nextLine();
                    enemyConsonant();
                    System.out.println(message);
                    break;

                case 10:
                    sc.nextLine();
                    pointHighEnemy();
                    System.out.println(message);
                    break;

                case 11:
                    sc.nextLine();
                    treasureRepeat();
                    System.out.println(message);
                    break;

                case 12:
                    sc.nextLine();
                    top();
                    System.out.println(message);
                    break;

                case 13:
                    System.out.println("bye bye");
                    break;  
            }
            opt = sc.nextInt();
        } while (opt != 13);
    }








    public static void main(String[] args) {
            menu();
    }


    
}
