import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LaserBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LaserBullet extends Actor
{
    /**
     * Act - do whatever the LaserBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        travelSpeed();
        removeFromWorld();
      
    } 
    public void travelSpeed()
    {
        setLocation(getX()+10, getY());
    }
    public void removeFromWorld()
    {
        /*Actor enemy = getOneIntersectingObject(Enemy.class);
        if(enemy != null)
        {
           getWorld().removeObject(enemy);
           getWorld().removeObject(this);
        }
        else */if(getX() == 599)
        {
            getWorld().removeObject(this);
        }
    }


  
}
