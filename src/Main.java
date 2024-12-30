import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        boolean playing = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, traveller! Please enter your name.");

        String name = scanner.nextLine();
        Player player = new Player(name);
        PromptManager promptManager = new PromptManager();

        while(playing) {
            promptManager.getCurrentPrompt().displayPrompt();
            String choice = scanner.nextLine();
            Choice currentChoice;

            switch (choice) {
                case "1":
                    currentChoice = promptManager.getCurrentPrompt().getChoice(1);
                    promptManager.chooseNextPrompt(currentChoice.nextPromptId());
                    if(currentChoice.encounterId() >= 0)
                    {
                        Encounter encounter = new AllEncounters().encounters[currentChoice.encounterId()];
                        encounter.printIntro();
                        encounter.beginBattleLoop(player);
                    }
                    break;
                case "2":
                    if(promptManager.doesPromptHaveChoice(2))
                    {
                        currentChoice = promptManager.getCurrentPrompt().getChoice(2);
                        promptManager.chooseNextPrompt(currentChoice.nextPromptId());
                        if(currentChoice.encounterId() >= 0)
                        {
                            Encounter encounter = new AllEncounters().encounters[currentChoice.encounterId()];
                            encounter.printIntro();
                            encounter.beginBattleLoop(player);

                            if(player.getHealth() <= 0)
                            {
                                playing = false;
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Invalid choice.");
                        scanner.nextLine();
                    }
                    break;
                case "3":
                    if(promptManager.doesPromptHaveChoice(3))
                    {
                        currentChoice = promptManager.getCurrentPrompt().getChoice(3);
                        promptManager.chooseNextPrompt(currentChoice.nextPromptId());
                        if(currentChoice.encounterId() >= 0)
                        {
                            Encounter encounter = new AllEncounters().encounters[currentChoice.encounterId()];
                            encounter.printIntro();
                            encounter.beginBattleLoop(player);
                        }
                    }
                    else
                    {
                        System.out.println("Invalid choice.");
                        scanner.nextLine();
                    }
                    break;
                case "4":
                    if(promptManager.doesPromptHaveChoice(4))
                    {
                        currentChoice = promptManager.getCurrentPrompt().getChoice(4);
                        promptManager.chooseNextPrompt(currentChoice.nextPromptId());
                        if(currentChoice.encounterId() >= 0)
                        {
                            Encounter encounter = new AllEncounters().encounters[currentChoice.encounterId()];
                            encounter.printIntro();
                            encounter.beginBattleLoop(player);
                        }
                    }
                    else
                    {
                        System.out.println("Invalid choice.");
                        scanner.nextLine();
                    }
                    break;
                case "q":
                    System.out.println("Goodbye!");
                    playing = false;
                    break;
                case "stats":
                    player.displayStats();
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    scanner.nextLine();
            }
        }
    }
}
