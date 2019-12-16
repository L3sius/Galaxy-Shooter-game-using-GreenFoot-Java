
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyShip extends Enemy
{
    /**
     * Act - do whatever the EnemyShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       setLocation(getX()-3, getY());
       hitByLaserBullet(); //Hit by laser or reached the end of the map 
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
            
          //World world = getWorld();
          Space space = (Space)world;
          Counter counter = space.getCounter(); //Access the counter through the world
          counter.addScore(); //Addscore method
          Greenfoot.playSound("Explosion.mp3");
          getWorld().removeObject(this);
        }
        else if(world instanceof SpaceTwo)
            {
             //   World world = getWorld();
             getWorld().removeObject(laserBullet);
                SpaceTwo spaceTwo = (SpaceTwo)world;
                Counter counter = spaceTwo.getCounter(); //Access the counter through the world
                counter.addScore(); //Addscore method
                Greenfoot.playSound("Explosion.mp3");
                getWorld().removeObject(this);
            }
            
        }
        else if(getX()==0)
        {
           // World world = getWorld();
           if(world instanceof Space)
            {
            Space space = (Space)world;
            HealthBar healthBar = space.getHealthBar();
            healthBar.loseHealth();
            getWorld().removeObject(this);
        }
        if(world instanceof SpaceTwo)
            {
                SpaceTwo spaceTwo = (SpaceTwo)world;
                HealthBar healthBar = spaceTwo.getHealthBar();
                healthBar.loseHealth();
            getWorld().removeObject(this);
            }
            
            
        }
        
    }
}
