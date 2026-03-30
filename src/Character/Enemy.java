package Character;

public class Enemy {
    private String name;
    private int life;
    private int damage;

    public void ShowStatusEnemy() {
        System.out.println("Name:" + this.name);
        System.out.println("Name:" + this.life);
        System.out.println("Name:" + this.damage);
    }

    public void init(String name, int life, int damage) {
        this.name = name;
        this.life = life;
        this.damage = damage;
    }

    //name
    public void setName(String name) {
        this.name = name;
    }

    //life
    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return this.life;
    }

    //damage
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }
}
