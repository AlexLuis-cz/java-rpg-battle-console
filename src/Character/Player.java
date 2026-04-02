package Character;

public class Player {
    private String name;
    private int life;
    private int damage;

    public Player(String name, int life, int damage) {
        this.name = name;
        this.life = life;
        this.damage = damage;
    }
    public Player(){

    }

    public void showStatus() {
        System.out.println("Name:" + this.name);
        System.out.println("Life:" + this.life);
        System.out.println("Damage:" + this.damage);
    }

    //name
    public void setName(String name) {
        this.name = name;
    }

    //damage
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }

    //life
    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return this.life;
    }
}
