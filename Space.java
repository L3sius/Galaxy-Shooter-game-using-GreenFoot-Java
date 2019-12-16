import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends ScrollWorld
{
    Counter counter = new Counter(); //Access information between classes
    HealthBar healthBar = new HealthBar();
    
    //String currentLevel = "Level: 1";
   
    LevelName levelName = new LevelName("Level: 1"); //variable from LevelName Class
    //Not needed
    private int imageCount = 0;
    private GreenfootImage bgImage = new GreenfootImage("space.jpg");
    //
    /**
     * Constructor for objects of class Space.
     * 
     */
    private int spawnTimer;
    public HealthBar getHealthBar()
    {
        return healthBar;
    }
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, 1000, 700); 
        prepare();
    }

    public void act()
    {
        checkForSpawning(); //In order to spawn enemy
        changeLevel();
        //imageCount -= 3; //(or any other value; small -> slow moving, big -> fast movement)
        //drawBackgroundImage();
    }
public void changeLevel()
{
    if(counter.score >= 15)
    {
      // levelName.addLevel();
       Greenfoot.setWorld(new SpaceTwo());
    }
}
    public void drawBackgroundImage()
    {
        if (imageCount < -bgImage.getWidth()) {
            imageCount += bgImage.getWidth();
        }
        int temp = imageCount;
        getBackground().drawImage(bgImage, temp, 0);
        getBackground().drawImage(bgImage, temp + bgImage.getWidth(), 0);
    }

    private void checkForSpawning()
    {
        spawnTimer = (spawnTimer+1)%100;
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
   /* public LevelName getLevelName()
    {
        return level;
    }*/

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(counter,50,383);
       // addObject(levelName,50,20);
  
       addObject(levelName,60,20);
        MainShip mainShip = new MainShip();
        addCameraFollower(mainShip,50,200);
        mainShip.setLocation(50,200);
        addObject(healthBar,150,383);
    }

}
