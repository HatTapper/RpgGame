import java.util.Random;

public class Hyena extends Enemy {
    public Hyena() {
        super("Hyena", 75, 10, 5, 0.3, 200);
    }

    @Override
    public void inspect() {
        System.out.printf("""
                Just be glad it wasn't a pack of wolves.
                
                Name: %s
                Health: %d / %d
                Damage: %d
                Defense: %d
                Critical Hit Chance: %.2f%%
                """, name, health, maxHealth, damage, defense, criticalChance * 100);
    }

    @Override
    public void printStandardAttack()
    {
        System.out.println("The hyena lands a blow with its claws.");
    }
    @Override
    public void printCriticalAttack()
    {
        System.out.println("CRITICAL HIT!\nThe hyena zips past your defenses, biting you hard!");
    }
    @Override
    public void printParry()
    {
        System.out.printf("The hyena is stunned by your parry, taking %d damage!", damage);
    }

    public void printTakeDamage(int damage) {
        System.out.println("The hyena whines!\n");
        if(health <= 0)
        {
            System.out.println("With a defeated yelp, the hyena collapses.");
        }
    }
}
