import java.util.Scanner;

public class Encounter {

    private final Enemy enemy;
    private final String introText;

    public Encounter(int encounterId, String introText, Enemy enemy) {
        this.enemy = enemy;
        this.introText = introText;
    }

    public void printIntro()
    {
        System.out.print(introText);
    }

    private void printBattleMenu(Player player)
    {
        Prompt prompt = new Prompt(String.format("""
                %s: %d / %d HP
                
                %s: %d / %d HP
                """, enemy.name, enemy.health, enemy.maxHealth, player.getName(), player.getHealth(), player.getMaxHealth()),
                new Choice[]{
                        new Choice("Attack", -1, -1),
                        new Choice("Guard", -1, -1)
                }, -1);
        prompt.displayPrompt();
    }

    public void beginBattleLoop(Player player)
    {
        Scanner scanner = new Scanner(System.in);
        while(enemy.health > 0 && player.getHealth() > 0)
        {
            if(player.isGuarding())
            {
                player.guard(false);
            }
            printBattleMenu(player);
            String choice = scanner.nextLine();
            switch(choice)
            {
                case "1":
                    player.getWeapon().attack(player, enemy);
                    break;
                case "2":
                    player.guard(true);
                    break;
            }

            if(enemy.health > 0)
            {
                enemy.attack(player);
            }
        }
    }
}
