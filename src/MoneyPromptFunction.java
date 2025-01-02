public class MoneyPromptFunction implements PromptFunction {
    public int amount;

    public MoneyPromptFunction(int amount) {
        this.amount = amount;
    }

    public void runFunction(Player player) {
        player.setMoney(player.getMoney() + amount);

        if(amount > 0)
        {
            System.out.printf("Your silver has increased by %d.\n", amount);
        }
        else
        {
            System.out.printf("Your silver has decreased by %d.\n", amount);
        }
    }
}
