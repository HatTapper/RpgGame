public class HealthPromptFunction implements PromptFunction {
    public int amount;

    public HealthPromptFunction(int amount) {
        this.amount = amount;
    }

    public void runFunction(Player player) {
        player.heal(amount);
        if(player.getHealth() == player.getMaxHealth())
        {
            System.out.println("Your health has been healed to full.");
            return;
        }
        if(amount > 0)
        {
            System.out.printf("Your health has increased by %d.\n", amount);
        }
        else
        {
            System.out.printf("Your health has decreased by %d.\n", amount);
        }
    }
}
