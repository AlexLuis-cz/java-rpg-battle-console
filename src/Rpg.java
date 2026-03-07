import Character.Enemy;
import Character.Player;
import java.util.*;
public class Rpg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Players
        Player player = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player playerSelect = null;

        player.name = "Athena"; //Player
        player.life = 1000; //Player
        player.damage = 200; //Player

        player2.name = "Gerwald"; //Player
        player2.life = 1000; //Player
        player2.damage = 200; //Player

        player3.name = "Atlantes"; //Player
        player3.life = 1000; //Player
        player3.damage = 200; //Player
        //Enemies
        Enemy enemy = new Enemy();
        Enemy enemy2 = new Enemy();
        Enemy enemy3 = new Enemy();
        Enemy enemySelect = null;

        enemy.name = "Armstrong";
        enemy.life = 1000;
        enemy.damage = 100;

        enemy2.name = "Gertrudes";
        enemy2.life = 1000;
        enemy2.damage = 100;

        enemy3.name = "Ártemis";
        enemy3.life = 1000;
        enemy3.damage = 100;
        //select
        System.out.println("-----------------");
        System.out.println("(1: Athena) (2: Gerwald) (3: Atlantes)");
        System.out.print("Choose a player:");

        byte chosenPlayer = sc.nextByte();
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
        while (playerSelect.life > 0 && enemySelect.life > 0) {
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
                        System.out.println("enemy defended" + "\nenemy's current life:" + enemySelect.life);
                    } else {
                        enemySelect.life -= playerSelect.damage;
                        System.out.println("damage caused:" + playerSelect.damage + "\nenemy's current life:" + enemySelect.life);
                    }
                    break;
                case 2:
                    playerDefended = true;
                    System.out.println("You defended" + "\ncurrent life:" + playerSelect.life);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            //action Enemy
            if (actionEnemy == 1) {
                if (playerDefended) {
                    System.out.println("enemy tried to cause:" + enemySelect.damage + " damage");
                } else {
                    playerSelect.life -= enemySelect.damage;
                    System.out.println("damage caused:" + enemySelect.damage + "\nplayer's current life:" + playerSelect.life);
                }
            }
            //end-of-game verification
            if (playerSelect.life <= 0 && enemySelect.life <= 0) {
                playerSelect.life = 0;
                enemySelect.life = 0;
                System.out.println("Draw!");
                break;
            }
            if (enemySelect.life <= 0) {
                enemySelect.life = 0;
                System.out.println("You Won!");
                break;
            } else if (playerSelect.life <= 0) {
                playerSelect.life = 0;
                System.out.println("Enemy Won");
                break;
            }
        }
    }
}