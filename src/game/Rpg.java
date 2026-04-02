package game;

import Character.Enemy;
import Character.Player;

import java.util.*;

public class Rpg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------");
        System.out.println("(1: Creat Player) (2: Gerwald) (3: Atlantes)");
        System.out.print("Choose a player:");
        byte chosenPlayer = sc.nextByte();
        //player 1
        String creatName = "";
        if (chosenPlayer == 1) {
            System.out.print("Write the player's name:");
            creatName = sc.next();
        }
        Player player = new Player(creatName, 1000, 200);
        Player player2 = new Player("Gerwald", 1000, 200);
        Player player3 = new Player("Atlantes", 1000, 200);
        //playerSelect
        Player playerSelect = null;
        //Enemies
        Enemy enemy = new Enemy("Armstrong", 1000, 100);
        Enemy enemy2 = new Enemy("Gertrudes", 1000, 100);
        Enemy enemy3 = new Enemy("Ártemis", 1000, 100);
        Enemy enemySelect = null;
        //select
        switch (chosenPlayer) {
            case 1:
                playerSelect = player;
                playerSelect.ShowStatus();
                break;
            case 2:
                playerSelect = player2;
                playerSelect.ShowStatus();
                break;
            case 3:
                playerSelect = player3;
                playerSelect.ShowStatus();
                break;
            default:
                System.out.println("Invalidated character, please try again");
                return;
        }
        System.out.println("-------------------");
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0:
                enemySelect = enemy;
                enemySelect.ShowStatusEnemy();
                break;
            case 1:
                enemySelect = enemy2;
                enemySelect.ShowStatusEnemy();
                break;
            case 2:
                enemySelect = enemy3;
                enemySelect.ShowStatusEnemy();
                break;
        }
        //Fight
        byte actionOption;
        while (playerSelect.getLife() > 0 && enemySelect.getLife() > 0) {

            boolean playerDefended = false;
            boolean enemyDefended = false;

            System.out.println("---------------");
            System.out.println("Fight:");
            System.out.println("1: Attack 2: Defender");
            actionOption = sc.nextByte();
            int actionEnemy = random.nextInt(2);
            if (actionEnemy == 0) {
                enemyDefended = true;
            }
            //action Player
            switch (actionOption) {
                case 1:
                    if (enemyDefended) {
                        System.out.println("enemy defended");
                        System.out.println("enemy's current life:" + enemySelect.getLife());
                    } else {
                        enemySelect.setLife(enemySelect.getLife() - playerSelect.getDamage());
                        System.out.println("damage caused:" + playerSelect.getDamage());
                        System.out.println("enemy's current life:" + enemySelect.getLife());
                    }
                    break;
                case 2:
                    playerDefended = true;
                    System.out.println("You defended");
                    System.out.println("current life:" + playerSelect.getLife());
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            //action Enemy
            if (actionEnemy == 1) {
                if (playerDefended) {
                    System.out.println("enemy tried to cause:" + enemySelect.getDamage() + " damage");
                } else {
                    playerSelect.setLife(playerSelect.getLife() - enemySelect.getDamage());
                    System.out.println("damage caused:" + enemySelect.getDamage());
                    System.out.println("player's current life:" + playerSelect.getLife());
                }
            }
            //end-of-game verification
            if (playerSelect.getLife() <= 0 && enemySelect.getLife() <= 0) {
                playerSelect.setLife(0);
                enemySelect.setLife(0);
                System.out.println("Draw!");
            }else if (enemySelect.getLife() <= 0) {
                enemySelect.setLife(0);
                System.out.println("You Won!");
            } else if (playerSelect.getLife() <= 0) {
                playerSelect.setLife(0);
                System.out.println("Enemy Won");
            }
            //new game
            if (playerSelect.getLife() <= 0 || enemySelect.getLife() <= 0) {
                System.out.println("Play again: Y/N");
                sc.nextLine();
                String newgame = sc.nextLine().toUpperCase();

                switch (newgame) {
                    case "Y":
                        playerSelect.setLife(1000);
                        enemySelect.setLife(1000);
                        break;
                    case "N":
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            }
        }
    }
}