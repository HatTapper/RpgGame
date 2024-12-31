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
    public void attack(Player player) {
        Random rand = new Random();
        rand.setSeed(678953245);
        if(rand.nextDouble(0, 1) < criticalChance)
        {
            System.out.println("CRITICAL HIT!\nThe hyena zips past your defenses, biting you hard!");
            player.takeDamage(damage * 2);

            if(player.getActiveSkill() == SkillEnums.PARRY)
            {
                System.out.printf("The hyena is stunned by your parry, taking %d damage!", damage);
                takeDamage(damage);
            }
        }
        else {
            System.out.println("The hyena lands a blow with its claws.");
            player.takeDamage(damage);
        }
    }

    public void takeDamage(int damage) {
        System.out.println("The hyena whines!\n");
        health -= damage;
        if(health <= 0)
        {
            System.out.println("With a defeated yelp, the hyena collapses.");
        }
    }
}
