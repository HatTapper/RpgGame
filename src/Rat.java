import java.util.Random;

public class Rat extends Enemy {
    public Rat() {
        super("Rat", 100, 5, 0, 0.1);
    }

    @Override
    public void attack(Player player)
    {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        if(rand.nextDouble(0, 1) < criticalChance)
        {
            System.out.printf("CRITICAL HIT!\nThe rat clawed at your ankle, leaving deep cuts!\n It deals %d damage!\n", damage * 2);
            player.takeDamage(damage * 2);
        }
        else {
            System.out.printf("The rat charges forward and bites!\nIt deals %d damage!\n", damage);
            player.takeDamage(damage);
        }
    }

    @Override
    public void takeDamage(int damage)
    {
        System.out.println("The rat squeaks in pain!\n");
        health -= damage;
        if(health <= 0)
        {
            System.out.println("The rat collapses to the ground.");
        }
    }
}
