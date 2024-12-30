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

    public abstract void attack(Player player, Enemy enemy);
}
