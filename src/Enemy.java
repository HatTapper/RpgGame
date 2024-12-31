// abstract class for enemies in the game

public abstract class Enemy {
    public String name;          // enemy's name
    public int health;           // enemy's health
    public int maxHealth;        // enemy's max health
    public int damage;           // the damage it deals
    public int defense;          // the defense used in negating damage taken
    public double criticalChance;// the chance of it landing a critical hit (2x damage)
    public int experienceGiven;  // the experience given to the player upon defeating it

    // constructor
    public Enemy(String name, int health, int damage, int defense, double criticalChance, int experienceGiven) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
        this.defense = defense;
        this.criticalChance = criticalChance;
        this.experienceGiven = experienceGiven;
    }

    // attacks the player and deals damage
    public abstract void attack(Player player);

    // takes damage depending on the amount given
    public abstract void takeDamage(int damage);

    // displays the enemy's stats (and flavor text if provided in the child class)
    public abstract void inspect();
}
