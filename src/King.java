import java.util.*;

public class King extends EnemyBoss {
    private Phase phase = Phase.PHASE_1;
    private final TextHolder textHolder = new TextHolder();
    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Skills> usedSkills = new ArrayList<>();

    public King() {
        super("The King", 500, 20, 50, 0.0, 9999);
    }

    @Override
    public void attack(Player player) {
        // check if phase can be updated
        updatePhase();
        // check if skill can be used
        useSkill(player);

        // calculate random value for crit chance
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        // check if critical hit was reached
        if(rand.nextDouble(0.00, 1.00) < criticalChance)
        {
            // run critical hit context
            System.out.println(textHolder.getTextInContext(Type.CRITICAL, phase));
            player.takeDamage(damage * 2);

            // if player is currently parrying, run parrying context
            if(player.getActiveSkill() == SkillEnums.PARRY)
            {
                System.out.println(textHolder.getTextInContext(Type.PARRY, phase));
                takeDamage(damage);
            }
        }
        // do standard attack if crit chance was not reached
        else {
            System.out.println(textHolder.getTextInContext(Type.STANDARD, phase));

            // boss loses health in the final phase
            if(phase == Phase.PHASE_3)
            {
                health -= 2000;
            }
            player.takeDamage(damage);
        }
    }

    // will use skill if capable and skill hasn't been already used yet in battle
    public void useSkill(Player player)
    {
        // does a damage down debuff when below 350 health in phase 1
        if(health < 350 && phase == Phase.PHASE_1 && !usedSkills.contains(Skills.DAMAGE_DOWN))
        {
            System.out.println(textHolder.getTextInContext(Skills.DAMAGE_DOWN));
            usedSkills.add(Skills.DAMAGE_DOWN);
            player.getWeapon().damage -= 10;
        }

        // does a defense down debuff when below 650 health in phase 2
        if(health < 650 && phase == Phase.PHASE_2 && !usedSkills.contains(Skills.DEFENSE_DOWN))
        {
            System.out.println(textHolder.getTextInContext(Skills.DEFENSE_DOWN));
            usedSkills.add(Skills.DAMAGE_DOWN);
            player.setDefense(player.getDefense() - 5);
        }
    }

    // checks if the criteria is met to transition to the next phase
    public void updatePhase()
    {
        if(phase == Phase.PHASE_1 && health < 150)
        {
            phase = Phase.PHASE_2;
            System.out.println(textHolder.getTextInContext(Skills.PHASE_2_TRANSITION));
            defense = 0;
            maxHealth = 1000;
            health = maxHealth;
            damage += 10;

            scanner.nextLine();
        }
        else if (phase == Phase.PHASE_2 && health < 200) {
            phase = Phase.PHASE_3;
            System.out.println(textHolder.getTextInContext(Skills.PHASE_3_TRANSITION));
            maxHealth = 10000;
            health = maxHealth;
            damage = 100;
            defense = 9999;

            scanner.nextLine();
        }
    }

    @Override
    public void parry(Player player) {

    }

    @Override
    public void takeDamage(int damage) {
        // prevents boss from taking any damage in phase 3
        if(phase == Phase.PHASE_3)
        {
            return;
        }
        // standard damage logic
        if(damage - defense < 0)
        {
            return;
        }
        health -= (damage - defense);

        // prevents boss from dying early to allow for phase transitions to occur
        if(health <= 0)
        {
            health = 1;
        }
    }

    @Override
    public void inspect() {
        System.out.printf("""
                You've made it this far. No point stopping now.
                
                Name: %s
                Health: %d / %d
                Damage: %d
                Defense: %d
                Critical Hit Chance: %.2f%%
                """, name, health, maxHealth, damage, defense, criticalChance * 100);
    }
}



enum Phase {
    PHASE_1, PHASE_2, PHASE_3
}

enum Type {
    STANDARD, CRITICAL, PARRY
}

enum Skills {
    DAMAGE_DOWN, DEFENSE_DOWN, PHASE_2_TRANSITION, PHASE_3_TRANSITION
}

class TextHolder {
    private final Map<Phase, Map<Type, String>> texts = new HashMap<>();
    private final Map<Skills, String> skillTexts = new HashMap<>();

    public TextHolder()
    {
        // prepares standard text messages
        texts.put(Phase.PHASE_1, new HashMap<>());
        texts.put(Phase.PHASE_2, new HashMap<>());
        texts.put(Phase.PHASE_3, new HashMap<>());

        texts.get(Phase.PHASE_1).put(Type.STANDARD, """
                The King slashes across your body with his axe!
                """);
        texts.get(Phase.PHASE_1).put(Type.CRITICAL, """
                CRITICAL HIT! The king smashes down his hammer, causing debris to fly everywhere!
                """);
        texts.get(Phase.PHASE_1).put(Type.PARRY, """
                The sound of you deflecting the King's axe echoes throughout the throne room!
                """);

        texts.get(Phase.PHASE_2).put(Type.STANDARD, """
                The King whirls with his blade!
                """);

        texts.get(Phase.PHASE_2).put(Type.CRITICAL, """
                CRITICAL HIT! The King flourishes with his axe, casting a magical arc that cuts right through you!
                """);

        texts.get(Phase.PHASE_2).put(Type.PARRY, """
                The King staggers back as his ruthless blow is deflected.
                """);

        texts.get(Phase.PHASE_3).put(Type.STANDARD, """
                Shadowy tendrils protrude from the king and flail wildly!
                
                The King loses 200 HP!
                """);


        // prepares skill text messages
        skillTexts.put(Skills.PHASE_2_TRANSITION, """
                The King sheds his armor!
                Max HP increased to 1000!
                HP restored to full!
                Attack increased by 10!
                DEFENSE DROPPED TO 0!
                """);

        skillTexts.put(Skills.PHASE_3_TRANSITION, """
                The King lets out a harrowing screech!
                MAX HP INCREASED TO 10000!
                HP RESTORED TO FULL!
                ATTACK INCREASED TO 100!
                THE KING IS NOW IMMUNE TO ALL ATTACKS!
                """);

        skillTexts.put(Skills.DAMAGE_DOWN, """
                The King claps his hands together. You feel your arms become weaker.
                Your damage has been reduced by 10!
                """);

        skillTexts.put(Skills.DEFENSE_DOWN, """
                The King claps his hands together. You feel your stance become weaker.
                Your defense has been reduced by 5!
                """);
    }

    public String getTextInContext(Type type, Phase phase)
    {
        return texts.get(phase).get(type);
    }
    public String getTextInContext(Skills skill) { return skillTexts.get(skill); }
}
