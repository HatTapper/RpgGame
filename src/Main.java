import java.util.Scanner;

public class Main {
    private static void endGame(Player player, PromptManager promptManager, Choice currentChoice)
    {
        EncounterBoss finalEncounter = new EncounterBoss("", new King());
        finalEncounter.printIntro();
        finalEncounter.beginBattleLoop(player);

        if(player.getHealth() <= 0)
        {
            return;
        }

        promptManager.chooseNextPrompt(currentChoice.nextPromptId());
        promptManager.getCurrentPrompt().displayPrompt();
        new Scanner(System.in).nextLine();
    }


    public static void main(String[] args)
    {
        final int BOSS_ENCOUNTER_ID = 8;
        final SaveManager saveManager = new SaveManager();
        final Scanner scanner = new Scanner(System.in);
        final PromptManager promptManager = new PromptManager();

        // determines if game loop will keep going
        boolean playing = true;

        Player player = saveManager.getSaveData();
        if(player == null)
        {
            System.out.println("Welcome, traveller! Please enter your name.");

            String name = scanner.nextLine();
            player = new Player(name);
        }
        else
        {
            System.out.println("A save file has been detected. If you do not want to use this save data, enter 'n'");
            player.displayStats();
            String choice = scanner.nextLine();

            if(choice.equals("n"))
            {
                System.out.println("Welcome, traveller! Please enter your name.");

                String name = scanner.nextLine();
                player = new Player(name);
            }
            else
            {
                promptManager.chooseNextPrompt(player.currentPrompt);
            }
        }

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
            promptManager.getCurrentPrompt().runFunction(player);
            promptManager.getCurrentPrompt().displayPrompt();


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
                    player.currentPrompt = currentChoice.nextPromptId();

                    if(currentChoice.encounterId() >= 0)
                    {
                        if(currentChoice.encounterId() == BOSS_ENCOUNTER_ID)
                        {
                            endGame(player, promptManager, currentChoice);
                            playing = false;
                            break;
                        }
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
                        player.currentPrompt = currentChoice.nextPromptId();

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
                    }
                    break;
                case "3":
                    if(promptManager.doesPromptHaveChoice(3))
                    {
                        currentChoice = promptManager.getCurrentPrompt().getChoice(3);
                        promptManager.chooseNextPrompt(currentChoice.nextPromptId());
                        player.currentPrompt = currentChoice.nextPromptId();

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
                    }
                    break;
                case "4":
                    if(promptManager.doesPromptHaveChoice(4))
                    {
                        currentChoice = promptManager.getCurrentPrompt().getChoice(4);
                        promptManager.chooseNextPrompt(currentChoice.nextPromptId());
                        player.currentPrompt = currentChoice.nextPromptId();

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
                    }
                    break;
                case "q": // quits the game immediately
                    System.out.println("Ending the game early...\n");
                    playing = false;
                    break;
                case "stats": // displays the player's stats
                    player.displayStats();
                    scanner.nextLine();
                    break;
                default: // default case, ask for resubmit
                    System.out.println("Invalid choice.");
            }
        }

        // game has ended
        System.out.println("Game over! Your final score was: " + player.getScore());
        if(player.doesPlayerHaveHighScore())
        {
            player.saveScore();
            System.out.printf("NEW HIGHSCORE! Your highscore has been saved to %s\\data\\highscore.txt\n\n", System.getProperty("user.dir"));
        }
        if(player.getHealth() <= 0)
        {
            player.currentPrompt -= 1;
        }
        player.heal(9999);
        saveManager.saveData(player);
    }
}
