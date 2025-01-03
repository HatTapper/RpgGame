import java.util.Random;

public class SewageBeast extends Enemy {
    public SewageBeast()
    {
        super("Sewage Beast", 50, 10, 30, 0.0, 500);
    }

    @Override
    public void printStandardAttack()
    {
        System.out.println("The beast throws itself at you! Part of it falls off in the process.\nThe beast loses 3 defense!");
        defense -= 3;
        if(defense <= 0) {defense = 0;}
    }

    @Override
    public void printCriticalAttack() {
        // this will never be run as critical chance is 0%
    }

    @Override
    public void printParry()
    {
        // this will never be run as critical chance is 0%
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;

        System.out.println("The creature flinches.\n");

        if(health <= 0)
        {
            System.out.println("Its structure deteriorating, it collapses back into the sewage, becoming one with the current.");
        }
    }

    @Override
    public void inspect() {
        System.out.printf("""
                It doesn't look very stable. As time passes, parts of its body keep falling off.
                
                Name: %s
                Health: %d / %d
                Damage: %d
                Defense: %d
                Critical Hit Chance: %.2f%%
                """, name, health, maxHealth, damage, defense, criticalChance * 100);
    }
}
