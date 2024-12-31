import java.util.Scanner;

// wrapper class for all encounters in the game
// handles the battle menu and the order of turns
public class Encounter {
    // the enemy the player is fighting
    private final Enemy enemy;
    // the text that will be displayed at the beginning of the encounter
    private final String introText;

    // constructor
    public Encounter(int encounterId, String introText, Enemy enemy) {
        this.enemy = enemy;
        this.introText = introText;
    }

    // prints the intro to the user
    public void printIntro()
    {
        System.out.print(introText);
    }

    // prints the battle menu and the choices the player can use
    private void printBattleMenu(Player player)
    {
        Prompt prompt = new Prompt(String.format("""
                
                ||| IN BATTLE |||
                
                %s: %d / %d HP
                
                %s: %d / %d HP
                """, enemy.name, enemy.health, enemy.maxHealth, player.getName(), player.getHealth(), player.getMaxHealth()),
                new Choice[]{
                        new Choice("Attack", -1, -1),
                        new Choice("Guard", -1, -1),
                        new Choice("Skills", -1, -1),
                        new Choice("Inspect", -1, -1),
                }, -1, new PromptFunction[]{new EmptyPromptFunction()});
        prompt.displayPrompt();
    }

    // battle loop function, will be constantly running until the battle ends
    public void beginBattleLoop(Player player)
    {
        // input
        Scanner scanner = new Scanner(System.in);

        // used to manage when certain attributes are updated that are dependent on a full turn passing
        // a full turn in this context is both the player and the enemy committing an action
        boolean turnTaken = false;

        // this will run until either the enemy or the player run out of health
        while(enemy.health > 0 && player.getHealth() > 0)
        {
            // resets attributes and updates skill cooldowns only if a full turn has passed
            if(turnTaken)
            {
                player.guard(false);
                player.setActiveSkill(SkillEnums.NONE);
                player.decrementSkillCooldowns();
            }
            // resets the value for this turn
            turnTaken = false;

            // grab player choice
            printBattleMenu(player);
            String choice = scanner.nextLine();
            switch(choice)
            {
                case "1": // attacks
                    player.getWeapon().attack(player, enemy);
                    break;
                case "2": // guards
                    player.guard(true);
                    break;
                case "3": // displays skill menu
                    // displays skills to player and grabs their choice
                    player.displaySkills();
                    choice = scanner.nextLine();

                    // put in a try catch in the case that the player submits an invalid choice
                    try {
                        // acquire the skill the player inputted for
                        Skill skill = player.getSkills().get(Integer.parseInt(choice) - 1);

                        // checks if the given skill is currently on cooldown, if so, cancel the player's turn
                        // and allow them to make a new choice without consuming a full turn
                        if(player.isSkillOnCooldown(skill.skillEnum))
                        {
                            System.out.println("This skill is on cooldown.");
                            continue;
                        }

                        // use skill if it's off cooldown
                        skill.useSkill(player);
                        break;

                    } catch (Exception ignored)
                    {}
                    // if player submitted a bad option, simply reset their turn
                    System.out.println("Invalid choice.");
                    continue;
                case "4": // inspects the enemy, does not take a full turn
                    enemy.inspect();
                    scanner.nextLine();
                    continue;
                default: // if the player submits something that isn't valid, they lose their turn
                    System.out.println("You try to do whatever strange action you came up with, fumbling around mindlessly. \n(Hint: make sure you're inputting a valid option!)\n");
            }

            // enemy will attack only if its health is above 0
            if(enemy.health > 0)
            {
                turnTaken = true;
                enemy.attack(player);
            }
        }

        // if player survived the encounter, give them the experience from the enemy
        if(player.getHealth() > 0)
        {
            // resets all cooldowns after encounter
            player.resetAllSkillCooldowns();
            player.giveExperience(enemy.experienceGiven);
        }
    }
}
