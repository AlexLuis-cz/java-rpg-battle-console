package Character;

public class Player {
    public int life;
    public String name;
    public int damage;

    public void ShowStatus(){
        System.out.println("Name:"+name+"\nLife:"+life+"\nDamage:"+damage);
    }
}
