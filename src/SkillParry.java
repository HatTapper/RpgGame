// Parry skill

public class SkillParry extends Skill {

    public SkillParry() {
        super.skillEnum = SkillEnums.PARRY;
        super.name = "Parry";
        super.cooldown = 3;
    }

    @Override
    public void useSkill(Player player) {
        System.out.println("""
                You take a step back, watching the enemy's movements carefully.
                """);
        player.setActiveSkill(SkillEnums.PARRY);
        player.addSkillCooldown(skillEnum, cooldown);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printDescription() {
        System.out.println("""
                Parry: Allows you to assume a defensive stance. All damage taken will be negated. If the opponent lands
                a critical hit, half of the damage will be reflected back to the opponent.
                """);
    }
}
