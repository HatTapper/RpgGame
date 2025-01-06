import java.util.Random;

public class Soldier extends Enemy {
    public Soldier()
    {
        super("Soldier", 100, 10, 5, 0.25, 200);
    }

    @Override
    public void printStandardAttack()
    {
        System.out.println("The soldier slashes with his blade.");
    }
    @Override
    public void printCriticalAttack()
    {
        System.out.println("CRITICAL HIT!\nThe soldier lands a devastating thrust!");
    }
    @Override
    public void printParry()
    {
        System.out.printf("The soldier is launched back, taking %d damage! He grunts in anger, raising his damage by 2!\n", damage);
        damage += 2;
    }

    @Override
    public void printTakeDamage(int damage)
    {
        System.out.println("The soldier takes the blow.\n");
        if(health <= 0)
        {
            System.out.println("The soldier falls to the ground.");
        }
    }

    @Override
    public void inspect()
    {
        System.out.printf("""
                An armored opponent carrying themselves with pride and grace.
                
                Name: %s
                Health: %d / %d
                Damage: %d
                Defense: %d
                Critical Hit Chance: %.2f%%
                """, name, health, maxHealth, damage, defense, criticalChance * 100);
    }
}
