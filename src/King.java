import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class King extends EnemyBoss {
    private boolean usedAttackDebuff = false;
    private Phase phase = Phase.PHASE_1;
    private Type type;
    private TextHolder textHolder = new TextHolder();

    public King() {
        super("The King", 500, 15, 50, 0.0, 9999);
    }

    @Override
    public void attack(Player player) {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        if(rand.nextDouble(0, 1) < criticalChance)
        {
            System.out.println(textHolder.getTextInContext(Type.CRITICAL, phase));
            player.takeDamage(damage * 2);

            if(player.getActiveSkill() == SkillEnums.PARRY)
            {
                System.out.println(textHolder.getTextInContext(Type.PARRY, phase));
                takeDamage(damage);
            }
        }
        else {
            System.out.println(textHolder.getTextInContext(Type.STANDARD, phase));
            player.takeDamage(damage);
        }
    }

    @Override
    public void parry(Player player) {

    }

    @Override
    public void takeDamage(int damage) {
        health -= (damage - defense);
    }

    @Override
    public void inspect() {

    }
}



enum Phase {
    PHASE_1, PHASE_2, PHASE_3
}

enum Type {
    STANDARD, CRITICAL, PARRY
}

class TextHolder {
    private Map<Phase, Map<Type, String>> texts = new HashMap<>();

    public TextHolder()
    {
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
    }

    public String getTextInContext(Type type, Phase phase)
    {
        return texts.get(phase).get(type);
    }
}
