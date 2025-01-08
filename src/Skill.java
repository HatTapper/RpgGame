// abstract class to store data for a skill that can be used by the player

import java.io.Serial;
import java.io.Serializable;

public abstract class Skill implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public String name; // name of the skill
    public int cooldown; // the amount of turns it will be on cooldown for when used
    public SkillEnums skillEnum; // the SkillEnum equivalent of the skill

    public abstract void useSkill(Player player, Enemy enemy);
    public abstract void useSkill(Player player, EnemyBoss enemy);
    public abstract String getName();
    public abstract void printDescription();
}
