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
            health -= amount / 2;
        }
        else
        {
            health -= amount;
        }
    }

    public void addExperience(int amount)
    {
        experience += amount;
        if (experience >= experienceToNextLevel)
        {
            level++;
            experience = 0;
            experienceToNextLevel = calculateExperienceToNextLevel();
        }
    }

    public void guard(boolean guard)
    {
        guarding = guard;
    }
    public boolean isGuarding()
        { return guarding; }
}
