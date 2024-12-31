import java.util.Random;

public class Fists extends Weapon {
    public Fists() {
        super("Fists", 15, 0.1);
    }

    @Override
    public void attack(Player player, Enemy enemy)
    {
        System.out.println("Raising your arm, you throw a left hook!");
        int finalDamage = damage + player.getLevel() * 2;
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        if(rand.nextDouble(0, 1) < criticalChance)
        {
            finalDamage *= 2;
            finalDamage -= enemy.defense;
            if(finalDamage <= 0) finalDamage = 0;
            System.out.printf("CRITICAL HIT!\nYou dealt %d damage!\n", finalDamage);
            enemy.takeDamage(finalDamage);
        }
        else
        {
            finalDamage -= enemy.defense;
            if(finalDamage <= 0) finalDamage = 0;
            System.out.printf("You dealt %d damage!\n", finalDamage);
            enemy.takeDamage(finalDamage);
        }
    }
}
