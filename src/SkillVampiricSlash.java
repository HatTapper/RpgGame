public class SkillVampiricSlash extends Skill {
    public SkillVampiricSlash() {
        super.skillEnum = SkillEnums.VAMPIRE;
        super.name = "Vampiric Slash";
        super.cooldown = 7;
    }

    @Override
    public void useSkill(Player player, Enemy enemy) {
        System.out.println("""
                You take a step back, a red aura forming around the blade of your dagger...
                
                You lunge forward and slash, blood trailing the tip of your blade!
                """);
        player.setActiveSkill(SkillEnums.VAMPIRE);
        player.addSkillCooldown(skillEnum, cooldown);

        enemy.takeDamage((int) (player.getWeapon().damage * 1.5));
        player.heal(player.getWeapon().damage);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printDescription() {
        System.out.println("""
                Vampiric Slash: Call upon the blood magic in the dagger to cut deep into your enemy. Deals 1.5x damage
                and heals you the same amount as your weapon's damage stat.
                """);
    }
}
