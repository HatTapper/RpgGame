
public class Rat extends Enemy {
    public Rat() {
        super("Rat", 100, 5, 0, 0.1, 125);
    }

    @Override
    public void printStandardAttack()
    {
        System.out.println("The rat charges forward and bites!");
    }
    @Override
    public void printCriticalAttack()
    {
        System.out.println("CRITICAL HIT!\nThe rat clawed at your ankle, leaving deep cuts!");
    }
    @Override
    public void printParry()
    {
        System.out.printf("The rat is stunned by your parry, taking %d damage!", damage);
    }

    @Override
    public void printTakeDamage(int damage)
    {
        System.out.println("The rat squeaks in pain!\n");
        if(health <= 0)
        {
            System.out.println("The rat collapses to the ground.");
        }
    }

    @Override
    public void inspect()
    {
        System.out.printf("""
                You've intruded on this rodent's domain, and it won't let it up so easy.
                
                Name: %s
                Health: %d / %d
                Damage: %d
                Defense: %d
                Critical Hit Chance: %.2f%%
                """, name, health, maxHealth, damage, defense, criticalChance * 100);
    }
}
