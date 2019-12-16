import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBullets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBullets extends Actor
{
    /**
     * Act - do whatever the EnemyBullets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        travelSpeed();
        removeFromWorld();

    } 

    public void travelSpeed()
    {
        setLocation(getX()-8, getY());
    }

    public void removeFromWorld()
    {
        if(getX() == 0)
        {
            getWorld().removeObject(this);
        }
    }
}
