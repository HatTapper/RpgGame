public abstract class Enemy {
    public String name;
    public int health;
    public int maxHealth;
    public int damage;
    public int defense;
    public double criticalChance;

    public Enemy(String name, int health, int damage, int defense, double criticalChance) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
        this.defense = defense;
        this.criticalChance = criticalChance;
    }

    public abstract void attack(Player player);
    public abstract void takeDamage(int damage);
}
