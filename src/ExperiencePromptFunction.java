public class ExperiencePromptFunction implements PromptFunction {
    public int amount;

    public ExperiencePromptFunction(int amount) {
        this.amount = amount;
    }

    public void runFunction(Player player) {
        System.out.printf("You gained %d additional experience!\n", amount);
        player.giveExperience(amount);
    }
}
