public class ExperiencePromptFunction implements PromptFunction {
    public int amount;

    public ExperiencePromptFunction(int amount) {
        this.amount = amount;
    }

    public void runFunction(Player player) {
        player.giveExperience(amount);
        System.out.printf("You gained %d experience!\n", amount);
    }
}
