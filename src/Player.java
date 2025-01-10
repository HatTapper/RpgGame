import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

// player class, created upon startup, the big class that stores all player data

public class Player implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

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
    private final ArrayList<Skill> skills;                  // the list of skills the player has access to
    private final Map<SkillEnums, Integer> skillCooldowns;  // hashmap containing skills on cooldown, decrements every full turn in an encounter
    private int money;                                // the amount of money the player has
    private int score;                                // the "score" the player has earned. for now, this is just the total EXP gained

    public int currentPrompt; // the current prompt id the player is on, used for pulling save data

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

        this.skills = new ArrayList<>();
        this.activeSkill = SkillEnums.NONE;
        this.skillCooldowns = new HashMap<>();
        this.money = 10;
        this.score = 0;
    }

    // deserialization constructor
    /*public Player(String name, int level, int experience, int experienceToNextLevel, Weapon weapon, int health, int maxHealth, ArrayList<Skill> skills, Map<SkillEnums, Integer> skillCooldowns, int money, int score)
    {
        this.name = name;
        this.level = level;
        this.experience = experience;
        this.experienceToNextLevel = experienceToNextLevel;
        this.weapon = weapon;
        this.health = health;
        this.maxHealth = maxHealth;
        this.skills = skills;
        this.skillCooldowns = skillCooldowns;
        this.money = money;
        this.score = score;
    }*/

    // displays the player's stats to the user
    public void displayStats()
    {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Damage: " + weapon.getDamage(this));
        System.out.println("Experience: " + experience);
        System.out.println("Experience to next level: " + experienceToNextLevel);
        System.out.println("Defense: " + defense);
        System.out.println("Money: " + money);
        System.out.println();
        displaySkills();
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

    public String getName()
        { return name;}

    public Weapon getWeapon()
        {return weapon;}
    public void setWeapon(Weapon weapon)
        { this.weapon = weapon; }

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

    public int getMoney()
        { return money; }
    public void setMoney(int money)
    {
        this.money = money;
        if(this.money < 0) this.money = 0;
    }

    public void guard(boolean guard)
        {guarding = guard;}

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
                skillCooldowns.put(entry.getKey(), 0);
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
        amount = amount - defense;
        if(amount < 0) amount = 0;

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
        defense += 1; // increase defense by 1
        maxHealth += (int) (10 * (1.1 * (level - 1))); // increase max hp by algorithm
        heal(9999); // restore to full hp

        experience = experience - experienceToNextLevel; // removes experience needed to level up
        experienceToNextLevel = calculateExperienceToNextLevel(); // find new value to level up
    }

    // gives experience to the player, leveling them up if they have enough experience
    public void giveExperience(int amount)
    {
        experience += amount;
        score += amount;
        int currentLevel = level;
        while(experience >= experienceToNextLevel)
        {
            levelUp();
        }

        // if player leveled up, wait for their input before proceeding
        if(currentLevel < level)
        {
            System.out.println("You leveled up!");
        }
    }

    public void saveScore() {
        String filePath = "data/highscore.txt";
        String scoreToSave = Integer.toString(score);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(scoreToSave);
        } catch (Exception ignored)
        {}
    }
    public boolean doesPlayerHaveHighScore() {
        String filePath = "data/highscore.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if(line != null)
            {
                int score = Integer.parseInt(line);
                return score <= this.score;
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int getScore()
        { return score; }


}
