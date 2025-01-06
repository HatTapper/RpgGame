public class KnightGroup extends Enemy {
    public KnightGroup()
    {
        super("Group of Knights", 800, 20, 15, 0.35, 1500);
    }

    @Override
    public void printStandardAttack()
    {
        System.out.println("One of the knights slams down their great sword.");
    }
    @Override
    public void printCriticalAttack()
    {
        System.out.println("CRITICAL HIT!\nA knight closes the distance and punches you in the gut!");
    }
    @Override
    public void printParry()
    {
        System.out.printf("One of the knights quickly recovers from the parry and disengages, only taking %d damage.\n", damage / 2);
    }

    @Override
    public void printTakeDamage(int damage)
    {
        System.out.println("One of the knights takes the blow.\n");
        if(health <= 0)
        {
            System.out.println("All of them gravely injured, they surrender to you.");
        }
    }

    @Override
    public void inspect()
    {
        System.out.printf("""
                A group of walking tanks. It seems like you angered quite a lot of them.
                
                Name: %s
                Health: %d / %d
                Damage: %d
                Defense: %d
                Critical Hit Chance: %.2f%%
                """, name, health, maxHealth, damage, defense, criticalChance * 100);
    }
}