public class SkillDoubleHit extends Skill {
    public SkillDoubleHit() {
        super.skillEnum = SkillEnums.DOUBLE_HIT;
        super.name = "Double Hit";
        super.cooldown = 3;
    }

    @Override
    public void useSkill(Player player, Enemy enemy) {
        System.out.println("""
                You take a step back, lunging forward and landing two savage strikes!
                """);
        player.setActiveSkill(SkillEnums.DOUBLE_HIT);
        player.addSkillCooldown(skillEnum, cooldown);

        player.getWeapon().attack(player, enemy);
        player.getWeapon().attack(player, enemy);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printDescription() {
        System.out.println("""
                Double Hit: Allows you to attack twice in one turn.
                """);
    }
}
