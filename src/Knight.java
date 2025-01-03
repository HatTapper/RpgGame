public class Knight extends Enemy {
    public Knight()
    {
        super("Knight", 250, 12, 10, 0.35, 750);
    }

    @Override
    public void printStandardAttack()
    {
        System.out.println("The knight slams down his great sword.");
    }
    @Override
    public void printCriticalAttack()
    {
        System.out.println("CRITICAL HIT!\nThe knight closes the distance and punches you in the gut!");
    }
    @Override
    public void printParry()
    {
        System.out.printf("The knight quickly recovers from the parry, focusing on guarding himself and only taking %d damage.\nHis defense goes up by 2!\n", damage / 2);
        defense += 2;
    }

    @Override
    public void takeDamage(int damage)
    {
        System.out.println("The knight takes the blow.\n");
        health -= damage;
        if(health <= 0)
        {
            System.out.println("Struggling to stand, the knight falls to the ground.");
        }
    }

    @Override
    public void inspect()
    {
        System.out.printf("""
                A walking tank. Let's hope you can take him down.
                
                Name: %s
                Health: %d / %d
                Damage: %d
                Defense: %d
                Critical Hit Chance: %.2f%%
                """, name, health, maxHealth, damage, defense, criticalChance * 100);
    }
}
