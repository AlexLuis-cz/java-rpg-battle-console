package Character;

public class Enemy {
    private String name;
    private int life;
    private int damage;

    public Enemy(String name, int life, int damage) {
        this.name = name;
        this.life = life;
        this.damage = damage;
    }

    public Enemy() {

    }

    public void showStatusEnemy() {
        System.out.println("Name:" + this.name);
        System.out.println("life:" + this.life);
        System.out.println("damage:" + this.damage);
    }

    //life
    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return this.life;
    }
    public int getDamage() {
        return this.damage;
    }
}
