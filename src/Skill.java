// abstract class to store data for a skill that can be used by the player

public abstract class Skill {
    public String name; // name of the skill
    public int cooldown; // the amount of turns it will be on cooldown for when used
    public SkillEnums skillEnum; // the SkillEnum equivalent of the skill

    public abstract void useSkill(Player player);
    public abstract String getName();
    public abstract void printDescription();
}
