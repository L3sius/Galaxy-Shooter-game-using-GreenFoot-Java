import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Enemy
{
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean moveY = false;
    boolean goBot = false;
    boolean goTop = true;
    int timesHit = 30;
    private int spawnTimer;
    public void act() 
    {
        BossMovement();  
        hitByLaserBullet(); //Hit by laser or reached the end of the map 
        spawnTimer = (spawnTimer+1)%50;
        if(spawnTimer == 0)
        {
            shoot();
            shootTop();
            shootBot();
        }
    }  
public void shoot()
    {
        getWorld().addObject(new EnemyBullets(), getX()-85, getY());
    }
    public void shootTop()
    {
        getWorld().addObject(new EnemyBullets(), getX()-85, getY()-70);
    }
    public void shootBot()
    {
        getWorld().addObject(new EnemyBullets(), getX()-85, getY()+70);
    }
    public void BossMovement()
    {
        if(getX() > 500)
        {
            setLocation(getX()-1, getY());
            if(getX()==500) moveY=true;

        }
        if(moveY == true)
        {
            if(goTop== true)
            {
                setLocation(getX(), getY()-1);
                if(getY()<=100)
                {
                    goTop=false;
                    goBot=true;
                }
            }
            else if(goBot == true)
            {
                setLocation(getX(), getY()+1);
                if(getY()>=300)
                {
                    goBot = false;
                    goTop = true;
                }
            }
        } 
    }

    

    public void hitByLaserBullet()
    {
        Actor laserBullet = getOneIntersectingObject(LaserBullet.class);
        World world = getWorld();
        if(laserBullet != null)
        {
            getWorld().removeObject(laserBullet);
            timesHit--;
            if(timesHit == 0)
            {
                //SpaceThree spaceThree = (SpaceThree)world;
                // Counter counter = spaceThree.getCounter(); //Access the counter through the world
                // counter.addScore(); //Addscore method
                Greenfoot.playSound("Explosion.mp3");

                getWorld().addObject(new YouWon(), 290, 190);
                getWorld().removeObject(this);
                Greenfoot.stop();
            }
        } 
        else if(getX()==0)
        {          
            SpaceThree spaceThree = (SpaceThree)world;
            HealthBar healthBar = spaceThree.getHealthBar();
            for(int i = 0; i < 20; i++)
            {
                healthBar.loseHealth();
            }
            getWorld().removeObject(this);
        }

    }
}
