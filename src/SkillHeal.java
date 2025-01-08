public class SkillHeal extends Skill {
    public SkillHeal() {
        super.skillEnum = SkillEnums.HEAL;
        super.name = "Quick Heal";
        super.cooldown = 3;
    }

    @Override
    public void useSkill(Player player, Enemy enemy) {
        System.out.println("""
                You take a step back, clasping your hands together and mumbling a short phrase...
                
                You get healed for 50 health points!
                """);
        player.setActiveSkill(SkillEnums.HEAL);
        player.addSkillCooldown(skillEnum, cooldown);

        player.heal(50);
    }

    @Override
    public void useSkill(Player player, EnemyBoss enemy) {
        System.out.println("""
                You take a step back, clasping your hands together and mumbling a short phrase...
                
                You get healed for 50 health points!
                """);
        player.setActiveSkill(SkillEnums.HEAL);
        player.addSkillCooldown(skillEnum, cooldown);

        player.heal(50);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printDescription() {
        System.out.println("""
                Quick Heal: Heals you for 50 health points.
                """);
    }
}
