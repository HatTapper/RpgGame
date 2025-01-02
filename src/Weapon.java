import java.util.Random;

public abstract class Weapon {
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

    public abstract void printAttack(Player player, Enemy enemy);
    public int getDamage(Player player)
    {
        return damage + player.getLevel() * 2;
    }
}
