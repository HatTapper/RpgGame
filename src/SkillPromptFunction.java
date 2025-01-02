public class SkillPromptFunction implements PromptFunction {
    public Skill skill;

    public SkillPromptFunction(Skill skill) {
        this.skill = skill;
    }

    public void runFunction(Player player) {
        player.addSkill(skill);
        System.out.println("You have learned a new skill: " + skill.getName());
        skill.printDescription();
    }
}
