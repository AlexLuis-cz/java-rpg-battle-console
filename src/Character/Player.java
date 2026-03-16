package Character;

public class Player {
    public int life;
    public String name;
    public int damage;

    public void ShowStatus(){
        System.out.println("Name:"+this.name);
        System.out.println("Life:"+this.life);
        System.out.println("Damage:"+this.damage);
    }
}
