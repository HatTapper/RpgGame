public class SkillWarcry extends Skill {
    public SkillWarcry() {
        super.skillEnum = SkillEnums.WAR_CRY;
        super.name = "War Cry";
        super.cooldown = 99;
    }

    @Override
    public void useSkill(Player player, Enemy enemy) {
        System.out.println("""
                You take a step back, shouting at the top of your lungs.
                """);
        player.setActiveSkill(SkillEnums.WAR_CRY);
        player.addSkillCooldown(skillEnum, cooldown);

        // this will allow defense to be negated entirely and instead deal a static 100 dmg
        player.setDefense(player.getDefense() + 5);
        player.getWeapon().damage += 5;
    }

    @Override
    public void useSkill(Player player, EnemyBoss enemy) {
        System.out.println("""
                You take a step back, shouting at the top of your lungs.
                """);
        player.setActiveSkill(SkillEnums.WAR_CRY);
        player.addSkillCooldown(skillEnum, cooldown);

        // this will allow defense to be negated entirely and instead deal a static 100 dmg
        player.setDefense(player.getDefense() + 5);
        player.getWeapon().damage += 5;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printDescription() {
        System.out.println("""
                War Cry: Shout at the top of your lungs, increasing your attack and defense by 5 for the remainder of
                the battle.
                """);
    }

}
