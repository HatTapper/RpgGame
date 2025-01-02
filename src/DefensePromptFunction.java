public class DefensePromptFunction implements PromptFunction {
    public int amount;

    public DefensePromptFunction(int amount) {
        this.amount = amount;
    }

    public void runFunction(Player player) {
        player.setDefense(player.getDefense() + amount);

        if(amount > 0)
        {
            System.out.printf("Your defense has increased by %d.\n", amount);
        }
        else
        {
            System.out.printf("Your defense has decreased by %d.\n", amount);
        }
    }
}
