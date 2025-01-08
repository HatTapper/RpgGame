public class Greatsword extends Weapon {
    public Greatsword() {
        super("Greatsword", 40, 0.4);
    }

    @Override
    public void printAttack(Player player, Enemy enemy) {
        System.out.println("You perform a devastating sweep attack!");
    }

    @Override
    public void printAttack(Player player, EnemyBoss enemy) {
        System.out.println("You perform a devastating sweep attack!");
    }
}