public class Prompt {
    private final String promptText;
    private final Choice[] choices;
    private final PromptFunction[] functions;
    private boolean functionRan;

    public Prompt(String promptText, Choice[] choices, PromptFunction[] functions)
    {
        this.promptText = promptText;
        this.choices = choices;
        this.functions = functions;
        this.functionRan = false;
    }

    public void displayPrompt()
    {
        StringBuilder fullText = new StringBuilder(promptText);
        int choiceCount = 1;

        for(Choice choice : choices)
        {
            fullText.append("\n").append(choiceCount++).append(") ").append(choice.text());
        }

        System.out.println(fullText + "\n");
    }

    public Choice getChoice(int choiceId)
    {
        if(choiceId < 1 || choiceId > choices.length) return null;
        return choices[choiceId - 1];
    }

    public void runFunction(Player player)
    {
        if(functionRan) return;

        for( PromptFunction function : functions)
        {
            function.runFunction(player);
            functionRan = true;
        }
    }
}
