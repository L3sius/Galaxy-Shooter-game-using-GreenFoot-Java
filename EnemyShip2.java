import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyShip2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyShip2 extends Enemy
{
    int timesHit = 2;
    /**
     * Act - do whatever the EnemyShip2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX()-2, getY());
        hitByLaserBullet();
    }    

    public void hitByLaserBullet()
    {
        Actor laserBullet = getOneIntersectingObject(LaserBullet.class);
        World world = getWorld();
        if(laserBullet != null)
        {
            if(world instanceof Space)
            {
            getWorld().removeObject(laserBullet);
            timesHit--;
            if(timesHit == 0)
            {
               // World world = getWorld();
                Space space = (Space)world; //Access counter
                Counter counter = space.getCounter(); //Access the counter through the world
                counter.addScore(); //Addscore method
                Greenfoot.playSound("Explosion.mp3");
                getWorld().removeObject(this);
            }
        }
        else if(world instanceof SpaceTwo)
            {
                getWorld().removeObject(laserBullet);
            timesHit--;
            if(timesHit == 0)
            {
             //   World world = getWorld();
                SpaceTwo spaceTwo = (SpaceTwo)world;
                Counter counter = spaceTwo.getCounter(); //Access the counter through the world
                counter.addScore(); //Addscore method
                Greenfoot.playSound("Explosion.mp3");
                getWorld().removeObject(this);
            }
            }
        }
        else if(getX()==0)
        {
            if(world instanceof Space)
            {
            //World world = getWorld();
            Space space = (Space)world;
            HealthBar healthBar = space.getHealthBar();
            healthBar.loseHealth();
            healthBar.loseHealth(); //Twice because we want to lose two health
            getWorld().removeObject(this);
        }
        if(world instanceof SpaceTwo)
        {
            SpaceTwo spaceTwo = (SpaceTwo)world;
            HealthBar healthBar = spaceTwo.getHealthBar();
            healthBar.loseHealth();
            healthBar.loseHealth(); //Twice because we want to lose two health
            getWorld().removeObject(this);
        }

    }
}
}
