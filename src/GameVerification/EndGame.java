package GameVerification;

import Character.Enemy;
import Character.Player;

public class EndGame {
    public void endGame(Player playerSelect, Enemy enemySelect) {
        if (playerSelect.getLife() == 0 && enemySelect.getLife() == 0) {
            System.out.println("Draw!");
        } else if (playerSelect.getLife() <= 0) {
            System.out.println("You Lose!");
        } else if (enemySelect.getLife() <= 0) {
            System.out.println("You win!");
        }
    }
}
