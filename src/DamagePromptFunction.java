public class DamagePromptFunction implements PromptFunction {
    public int amount;

    public DamagePromptFunction(int amount) {
        this.amount = amount;
    }

    public void runFunction(Player player) {
        player.getWeapon().damage += amount;

        if(amount > 0)
        {
            System.out.printf("Your damage has increased by %d.\n", amount);
        }
        else
        {
            System.out.printf("Your damage has decreased by %d.\n", amount);
        }
    }
}
