public class Sword extends Weapon {
    public Sword() {
        super("Sword", 25, 0.4);
    }

    @Override
    public void printAttack(Player player, Enemy enemy) {
        System.out.println("You slash with your sword!");
    }

    @Override
    public void printAttack(Player player, EnemyBoss enemy) {
        System.out.println("You slash with your sword!");
    }
}
