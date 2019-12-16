import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceTwo extends ScrollWorld
{
    Counter counter = new Counter(); //Access information between classes
    HealthBar healthBar = new HealthBar();
    LevelName levelName = new LevelName("Level: 2"); 
     private int spawnTimer;
    /**
     * Constructor for objects of class SpaceTwo.
     * 
     */
    public SpaceTwo()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, 1000, 700); 
        prepare();
    }
    public void act()
    {
        checkForSpawning(); //In order to spawn enemy
        changeLevel();
    }
    public void prepare()
    {

        addObject(counter,50,383);
        addObject(levelName,60,20);
        MainShip mainShip = new MainShip();
        addCameraFollower(mainShip,50,200);
        mainShip.setLocation(50,200);
        addObject(healthBar,150,383);

    }
    public void changeLevel()
{
    if(counter.score >= 20)
    {
      // levelName.addLevel();
       Greenfoot.setWorld(new SpaceThree());
    }
}
    public HealthBar getHealthBar()
    {
        return healthBar;
    }
    private void checkForSpawning()
    {
        spawnTimer = (spawnTimer+1)%30;
        if(spawnTimer == 0)
        {
            EnemyShip enemyShip = new EnemyShip();
            addObject(enemyShip, 600, Greenfoot.getRandomNumber(350-50)+50);
            //addCameraFollower(enemyShip, 600, Greenfoot.getRandomNumber(350-50)+50);
            enemyShip.setLocation(600,Greenfoot.getRandomNumber(350-50)+50);

            EnemyShip2 enemyShip2 = new EnemyShip2();
            addObject(enemyShip2, 600, Greenfoot.getRandomNumber(350-50)+50);
            //addCameraFollower(enemyShip2, 600, Greenfoot.getRandomNumber(350-50)+50);
            enemyShip2.setLocation(600,Greenfoot.getRandomNumber(350-50)+50);
        }
    }

    public Counter getCounter()
    {
        return counter;
    }
}
