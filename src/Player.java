import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;

// player class, created upon startup, the big class that stores all player data

public class Player {
    private final String name;                        // the player's name
    private int level;                                // the player's level
    private int experience;                           // the player's experience (used in leveling up)
    private int experienceToNextLevel;                // the experience needed to level up
    private int health;                               // the player's current health
    private int maxHealth;                            // the player's max health
    private int defense;                              // the player's defense (reduces damage taken)
    private boolean guarding;                         // if the player is guarding or not (reduces damage taken by 75%)
    private Weapon weapon;                            // the weapon the player is holding
    private SkillEnums activeSkill;                   // the current skill that the player is using, important for status-based skills
    private ArrayList<Skill> skills;                  // the list of skills the player has access to
    private Map<SkillEnums, Integer> skillCooldowns;  // hashmap containing skills on cooldown, decrements every full turn in an encounter

    // calculates the experience needed to get to the next level, scales linearly in relation to player's level
    private int calculateExperienceToNextLevel()
    {
        return (level * 100);
    }

    // constructor
    public Player(String name)
    {
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.experienceToNextLevel = 100;
        this.weapon = new Fists();
        this.guarding = false;

        this.health = 100;
        this.maxHealth = 100;

        this.skills = new ArrayList<Skill>();
        this.activeSkill = SkillEnums.NONE;
        this.skillCooldowns = new HashMap<>();
    }

    // displays the player's stats to the user
    public void displayStats()
    {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Damage: " + weapon.getDamage(this));
        System.out.println("Experience: " + experience);
        System.out.println("Experience to next level: " + experienceToNextLevel);
    }

    // displays the player's skills to the user
    public void displaySkills()
    {
        // if there are no skills, end early
        if(skills.isEmpty())
        {
            System.out.println("You have no skills.");
            return;
        }

        StringBuilder skillList = new StringBuilder();
        int num = 1; // used to add an incremental list that is displayed to the user
        for(Skill skill : skills)
        {
            skillList.append(num++)
                    .append(". ")
                    .append(skill.getName());

            // if skill is on cooldown, show it to the user
            if(skillCooldowns.getOrDefault(skill.skillEnum, 0) > 0)
            {
                skillList.append(" (cooldown: ").append(skillCooldowns.getOrDefault(skill.skillEnum, 0)).append(")");
            }

            skillList.append("\n");
        }

        // print full list all at once
        System.out.println("Skills:\n" + skillList);
    }

    public int getLevel()
        { return level; }
    public int getExperience()
        { return experience; }
    public int getExperienceToNextLevel()
        { return experienceToNextLevel; }

    public String getName()
        { return name;}

    public Weapon getWeapon()
        {return weapon;}

    public int getHealth()
        {return health;}
    public int getMaxHealth()
        {return maxHealth;}

    public int getDefense()
        { return defense; }
    public void setDefense(int defense)
        { this.defense = defense; }

    public SkillEnums getActiveSkill()
        { return activeSkill; }
    public void setActiveSkill(SkillEnums activeSkill)
        { this.activeSkill = activeSkill; }

    public ArrayList<Skill> getSkills()
        { return skills; }
    public void addSkill(Skill skill)
        { skills.add(skill); }

    public void guard(boolean guard)
        {guarding = guard;}
    public boolean isGuarding()
        { return guarding; }

    public void addSkillCooldown(SkillEnums skillType, int cooldown)
        { skillCooldowns.put(skillType, cooldown); }

    // decrements all active skill cooldowns by 1
    public void decrementSkillCooldowns()
    {
        for(Map.Entry<SkillEnums, Integer> entry : skillCooldowns.entrySet())
        {
            skillCooldowns.put(entry.getKey(), entry.getValue() - 1);
            if(entry.getValue() <= 0)
            {
                // remove entry if cooldown has reached 0
                skillCooldowns.remove(entry.getKey());
            }
        }
    }

    // return true if skill is on cooldown
    public boolean isSkillOnCooldown(SkillEnums skillType)
        { return skillCooldowns.getOrDefault(skillType, 0) > 0; }

    // clears cooldown hashmap, effectively removing all cooldowns
    public void resetAllSkillCooldowns()
        { skillCooldowns.clear(); }

    // causes the player to take damage
    public void takeDamage(int amount)
    {
        // if player is parrying, negate all incoming damage
        if(activeSkill == SkillEnums.PARRY)
        {
            System.out.println("You effortlessly parry the attack, negating all damage!");
            return;
        }
        // if player is guarding, negate approx. 75% of incoming damage
        if(guarding)
        {
            System.out.printf("Sheesh, blocking that attack shaved off the edge, only hurting you for %d damage!\n", amount / 4);
            health -= amount / 4;
        }
        // take normal damage
        else
        {
            System.out.printf("Ouch! You got hurt for %d damage!\n", amount);
            health -= amount;
        }
    }

    // heals the player for the given amount, up to their max hp
    public void heal(int amount)
    {
        health += amount;
        if(health > maxHealth)
        {
            health = maxHealth;
        }
    }

    // levels up the player
    /*
    NOTE: the player's damage will increase by 2 per level, this is outlined in the Weapon class
     */
    private void levelUp()
    {
        level++; // increment level
        maxHealth += 10; // increase max hp by 10
        heal(9999); // restore to full hp

        experience = experience - experienceToNextLevel; // removes experience needed to level up
        experienceToNextLevel = calculateExperienceToNextLevel(); // find new value to level up

        System.out.println("You leveled up! Here are your new stats:");
        displayStats(); // displays updated stats to user
    }

    // gives experience to the player, leveling them up if they have enough experience
    public void giveExperience(int amount)
    {
        experience += amount;
        int currentLevel = level;
        while(experience >= experienceToNextLevel)
        {
            levelUp();
        }

        // if player leveled up, wait for their input before proceeding
        if(currentLevel < level)
        {
            new Scanner(System.in).nextLine();
        }
    }
}
