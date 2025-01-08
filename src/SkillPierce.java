public class SkillPierce extends Skill {

    public SkillPierce() {
        super.skillEnum = SkillEnums.PIERCING;
        super.name = "Piercing Strike";
        super.cooldown = 5;
    }

    @Override
    public void useSkill(Player player, Enemy enemy) {
        System.out.println("""
                You take a step back, an ethereal spear materializing in your hands...
                
                You then lunge forward, directing the point at your opponent's center mass!
                """);
        player.setActiveSkill(SkillEnums.PIERCING);
        player.addSkillCooldown(skillEnum, cooldown);

        // this will allow defense to be negated entirely and instead deal a static 100 dmg
        enemy.takeDamage(100 + enemy.getDefense());
    }

    @Override
    public void useSkill(Player player, EnemyBoss enemy) {
        System.out.println("""
                You take a step back, an ethereal spear materializing in your hands...
                
                You then lunge forward, directing the point at your opponent's center mass!
                """);
        player.setActiveSkill(SkillEnums.PIERCING);
        player.addSkillCooldown(skillEnum, cooldown);

        // this will allow defense to be negated entirely and instead deal a static 100 dmg
        enemy.takeDamage(100 + enemy.defense);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printDescription() {
        System.out.println("""
                Piercing Strike: Conjure a magical spear in your hands and lunge forward at your opponent. This will deal
                a static 100 damage that entirely ignores defense.
                """);
    }
}
