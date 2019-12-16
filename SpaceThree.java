import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceThree extends ScrollWorld
{
    Counter counter = new Counter();
    HealthBar healthBar = new HealthBar();
    LevelName levelName = new LevelName("Level: BOSS"); 
    /**
     * Constructor for objects of class SpaceThree.
     * 
     */
    public SpaceThree()
    {
        super(600, 400, 1, 1000, 700); 
        prepare();
    }
     public void prepare()
    {
        addObject(counter, 50,383);
        addObject(levelName,100,20);
        MainShip mainShip = new MainShip();
        addCameraFollower(mainShip,50,200);
        mainShip.setLocation(50,200);
        addObject(healthBar,150,383);
        Boss boss = new Boss();
            addObject(boss, 600, 200);
            //addCameraFollower(enemyShip, 600, Greenfoot.getRandomNumber(350-50)+50);
            boss.setLocation(600,200);

    }
    public HealthBar getHealthBar()
    {
        return healthBar;
    }
     public Counter getCounter()
    {
        return counter;
    }
}
