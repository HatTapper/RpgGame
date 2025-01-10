
public class Fists extends Weapon {
    public Fists() {
        super("Fists", 15, 0.1);
    }

    @Override
    public void printAttack(Player player, Enemy enemy)
    {
        System.out.println("Raising your arm, you throw a left hook!");
    }

    @Override
    public void printAttack(Player player, EnemyBoss enemy)
    {
        System.out.println("Raising your arm, you throw a left hook!");
    }
}
