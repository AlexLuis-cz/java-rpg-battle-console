package game;
import Character.Enemy;
import Character.Player;
import java.util.*;
public class Rpg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String creatName = "";
        System.out.println("-----------------");
        System.out.println("(1: Creat Player) (2: Gerwald) (3: Atlantes)");
        System.out.print("Choose a player:");
        byte chosenPlayer = sc.nextByte();
        Player player = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        //player 1
        if (chosenPlayer == 1) {
            System.out.print("Write the player's name:");
            creatName = sc.next();
        }
        player.setName(creatName);
        player.setLife(1000); //Player
        player.setDamage(200);

        //player 2
        player2.setName("Gerwald"); //Player
        player2.setLife(1000); //Player
        player2.setDamage(200); //Player

        //player 3
        player3.setName("Atlantes"); //Player
        player3.setLife(1000); //Player
        player3.setDamage(200); //Player

        //playerSelect
        Player playerSelect = null;
        //Enemies
        Enemy enemy = new Enemy();
        Enemy enemy2 = new Enemy();
        Enemy enemy3 = new Enemy();
        Enemy enemySelect = null;

        enemy.setName("Armstrong");
        enemy.setLife(1000);
        enemy.setDamage(100);

        enemy2.setName("Gertrudes");
        enemy2.setLife(1000);
        enemy2.setDamage(100);

        enemy3.setName("Ártemis");
        enemy3.setLife(1000);
        enemy3.setDamage(100);
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
                        System.out.println("enemy defended" + "\nenemy's current life:" + enemySelect.getLife());
                    } else {
                        enemySelect.setLife(enemySelect.getLife() - playerSelect.getDamage());
                        System.out.println("damage caused:" + playerSelect.getDamage() + "\nenemy's current life:" + enemySelect.getLife());
                    }
                    break;
                case 2:
                    playerDefended = true;
                    System.out.println("You defended" + "\ncurrent life:" + playerSelect.getLife());
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
                    System.out.println("damage caused:" + enemySelect.getDamage() + "\nplayer's current life:" + playerSelect.getLife());
                }
            }
            //end-of-game verification
            if (playerSelect.getLife() <= 0 && enemySelect.getLife() <= 0) {
                playerSelect.setLife(0);
                enemySelect.setLife(0);
                System.out.println("Draw!");
                break;
            }
            if (enemySelect.getLife() <= 0) {
                enemySelect.setLife(0);
                System.out.println("You Won!");
                break;
            } else if (playerSelect.getLife() <= 0) {
                playerSelect.setLife(0);
                System.out.println("Enemy Won");
                break;
            }
        }
    }
}