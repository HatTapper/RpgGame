public class WeaponPromptFunction implements PromptFunction {
    private final Weapon weaponToGive;
    public WeaponPromptFunction(Weapon weapon)
    {
        this.weaponToGive = weapon;
    }

    public void runFunction(Player player) {
        player.setWeapon(weaponToGive);

        System.out.println("You have equipped a new weapon!");
    }
}
