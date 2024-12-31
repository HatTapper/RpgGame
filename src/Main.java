import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        // determines if game loop will keep going
        boolean playing = true;

        // get name from user and create new player and prompt manager
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, traveller! Please enter your name.");

        String name = scanner.nextLine();
        Player player = new Player(name);
        PromptManager promptManager = new PromptManager();

        // use these for testing
        //player.addSkill(new SkillParry());
        //promptManager.chooseNextPrompt(7);

        // GAME LOOP
        while(playing) {
            // if player has no health left, end the game and show them their final stats
            if(player.getHealth() <= 0)
            {
                System.out.println("\nYou lose!\n");
                System.out.println("Your final stats:");
                player.displayStats();
                break;
            }

            // displays the next prompt and runs its prompt function
            promptManager.getCurrentPrompt().displayPrompt();
            promptManager.getCurrentPrompt().runFunction(player);

            // grab player's choice
            String choice = scanner.nextLine();
            Choice currentChoice;

            /* determine if player submitted a valid choice
             * if they did, check if the prompt allows said choice
             * if the choice leads to an encounter, begin the encounter game loop
             * if the player submits an invalid choice, ask for a resubmit
             */
            switch (choice) {
                case "1": // standard choice
                    currentChoice = promptManager.getCurrentPrompt().getChoice(1);
                    promptManager.chooseNextPrompt(currentChoice.nextPromptId());

                    if(currentChoice.encounterId() >= 0)
                    {
                        Encounter encounter = new AllEncounters().encounters[currentChoice.encounterId()];
                        encounter.printIntro();
                        encounter.beginBattleLoop(player);
                    }
                    break;
                case "2": // standard choice
                    if(promptManager.doesPromptHaveChoice(2))
                    {
                        currentChoice = promptManager.getCurrentPrompt().getChoice(2);
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
                case "q": // quits the game immediately
                    System.out.println("Goodbye!");
                    playing = false;
                    break;
                case "stats": // displays the player's stats
                    player.displayStats();
                    scanner.nextLine();
                    break;
                default: // default case, ask for resubmit
                    System.out.println("Invalid choice.");
                    scanner.nextLine();
            }
        }
    }
}
