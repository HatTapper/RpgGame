import java.io.Serial;
import java.io.Serializable;
import java.util.Random;

public abstract class Weapon implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public String name;
    public int damage;
    public double criticalChance;

    public Weapon(String name, int damage, double criticalChance)
    {
        this.name = name;
        this.damage = damage;
        this.criticalChance = criticalChance;
    }

    public void inspect()
    {
        System.out.println("Name: " + name);
        System.out.println("Damage: " + damage);
        System.out.println("Critical Chance: " + criticalChance);
    }

    public void attack(Player player, Enemy enemy)
    {
        printAttack(player, enemy);
        int finalDamage = damage + player.getLevel() * 2;
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        if(rand.nextDouble(0.00, 1.00) < criticalChance)
        {
            finalDamage *= 2;
            if(finalDamage <= 0) finalDamage = 0;
            System.out.printf("CRITICAL HIT!\nYou dealt %d damage!\n", finalDamage - enemy.defense);
            enemy.takeDamage(finalDamage);
        }
        else
        {
            if(finalDamage <= 0) finalDamage = 0;
            System.out.printf("You dealt %d damage!\n", finalDamage - enemy.defense);
            enemy.takeDamage(finalDamage);
        }
    }

    public void attack(Player player, EnemyBoss enemy)
    {
        printAttack(player, enemy);
        int finalDamage = damage + player.getLevel() * 2;
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        if(rand.nextDouble(0.00, 1.00) < criticalChance)
        {
            finalDamage *= 2;
            if(finalDamage <= 0) finalDamage = 0;
            System.out.printf("CRITICAL HIT!\nYou dealt %d damage!\n", finalDamage - enemy.defense);
            enemy.takeDamage(finalDamage);
        }
        else
        {
            if(finalDamage <= 0) finalDamage = 0;
            System.out.printf("You dealt %d damage!\n", finalDamage - enemy.defense);
            enemy.takeDamage(finalDamage);
        }
    }

    public abstract void printAttack(Player player, Enemy enemy);
    public abstract void printAttack(Player player, EnemyBoss enemy);
    public int getDamage(Player player)
    {
        return damage + player.getLevel() * 2;
    }
}
