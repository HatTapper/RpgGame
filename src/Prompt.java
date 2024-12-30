public class Prompt {
    private final String promptText;
    private final Choice[] choices;
    private final int promptId;

    public Prompt(String promptText, Choice[] choices, int promptId)
    {
        this.promptText = promptText;
        this.choices = choices;
        this.promptId = promptId;
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
}
