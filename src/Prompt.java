public class Prompt {
    private final String promptText;
    private final Choice[] choices;
    private final int promptId;
    private final PromptFunction[] functions;
    private boolean functionRan;

    public Prompt(String promptText, Choice[] choices, int promptId, PromptFunction[] functions)
    {
        this.promptText = promptText;
        this.choices = choices;
        this.promptId = promptId;
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

        System.out.println(fullText);
    }

    public Choice getChoice(int choiceId)
    {
        return choices[choiceId - 1];
    }
    public int getPromptId() {
        return promptId;
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
