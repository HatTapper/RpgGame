public class Dagger extends Weapon {
    public Dagger() {
        super("Dagger", 20, 0.8);
    }

    @Override
    public void printAttack(Player player, Enemy enemy) {
        System.out.println("You swipe at the enemy's weakpoint!");
    }

    @Override
    public void printAttack(Player player, EnemyBoss enemy) {
        System.out.println("You swipe at the enemy's weakpoint!");
    }
}
