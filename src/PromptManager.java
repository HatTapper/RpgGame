public class PromptManager {
    private Prompt currentPrompt;
    private final Prompt[] prompts;

    public PromptManager()
    {
        AllPrompts PromptHolder = new AllPrompts();
        this.prompts = PromptHolder.prompts;
        this.currentPrompt = prompts[0];
    }

    public Prompt getCurrentPrompt()
    {
        return currentPrompt;
    }

    public boolean doesPromptHaveChoice(int choiceNumber)
    {
        return currentPrompt.getChoice(choiceNumber) != null;
    }

    public void chooseNextPrompt(int promptId)
    {
        currentPrompt = prompts[promptId];
    }
}
