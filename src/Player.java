import java.util.Scanner;

public class Player {
    private String name;
    private int level;
    private int experience;
    private int experienceToNextLevel;
    private int health;
    private int maxHealth;
    private boolean guarding;
    private Weapon weapon;

    private int calculateExperienceToNextLevel()
    {
        return (int) (level * 100);
    }

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
    }

    public void displayStats()
    {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Damage: " + weapon.getDamage(this));
        System.out.println("Experience: " + experience);
        System.out.println("Experience to next level: " + experienceToNextLevel);
    }

    public int getLevel()
    {
        return level;
    }
    public int getExperience()
    {
        return experience;
    }
    public int getExperienceToNextLevel()
    {
        return experienceToNextLevel;
    }
    public String getName()
    {
        return name;
    }
    public Weapon getWeapon()
    {
        return weapon;
    }
    public int getHealth()
    {
        return health;
    }
    public int getMaxHealth()
    {
        return maxHealth;
    }

    public void takeDamage(int amount)
    {
        if(guarding)
        {
            System.out.printf("Sheesh, blocking that attack shaved off the edge, only hurting you for %d damage!\n", amount / 2);
            health -= amount / 2;
        }
        else
        {
            System.out.printf("Ouch! You got hurt for %d damage!\n", amount);
            health -= amount;
        }
    }

    public void heal(int amount)
    {
        health += amount;
        if(health > maxHealth)
        {
            health = maxHealth;
        }
    }

    private void levelUp()
    {
        level++;
        maxHealth += 10;
        heal(9999);

        experience = experience - experienceToNextLevel;
        experienceToNextLevel = calculateExperienceToNextLevel();


        System.out.println("You leveled up! Here are your new stats:");
        displayStats();
    }

    public void giveExperience(int amount)
    {
        experience += amount;
        int currentLevel = level;
        while(experience >= experienceToNextLevel)
        {
            levelUp();
        }
        if(currentLevel < level)
        {
            new Scanner(System.in).nextLine();
        }
    }

    public void guard(boolean guard)
    {
        guarding = guard;
    }
    public boolean isGuarding()
        { return guarding; }
}
