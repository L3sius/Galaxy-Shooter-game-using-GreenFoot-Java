import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainShip extends ScrollActor
{
    boolean FireOn = true;
    boolean EdgeLeft = false;
    boolean EdgeTop = false;
    boolean EdgeRight = false;
    boolean EdgeBot = false;
    private static final int MOVE_AMOUNT = 2;
    /**
     * Act - do whatever the MainShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Movement();
        HitByEnemyBullet();
        HitByEnemyShip();
    }
    public void HitByEnemyShip()
    {
        Actor collision = getOneIntersectingObject(Enemy.class);
        World world = getWorld();
        if(collision != null)
        {
            if(world instanceof Space)
            {
                getWorld().removeObject(collision);
                Space space = (Space)world;       
                Greenfoot.playSound("Explosion.mp3");
                HealthBar healthBar = space.getHealthBar();
                healthBar.loseHealth();
            }
            if(world instanceof SpaceTwo)
            {
                getWorld().removeObject(collision);
                SpaceTwo spaceTwo = (SpaceTwo)world;       
                Greenfoot.playSound("Explosion.mp3");
                HealthBar healthBar = spaceTwo.getHealthBar();
                healthBar.loseHealth();
            }
            if(world instanceof SpaceThree)
            {
                //getWorld().removeObject(collision);
                SpaceThree spaceThree = (SpaceThree)world;       
                Greenfoot.playSound("Explosion.mp3");
                HealthBar healthBar = spaceThree.getHealthBar();
                for(int i = 0; i < 4; i++)healthBar.loseHealth();
                setLocation(50,200);
            }
        }
    }
    public void Movement()
    {
        if(Greenfoot.isKeyDown("w")){
            if(getY() <= 25)
            {
                EdgeTop = true;
            }
            if(getY() > 25) 
            {
                EdgeTop = false;
            } 
            if(EdgeTop == false)
            {
                setLocation(getX(),getY()-MOVE_AMOUNT);
                //getWorld().moveCamera(-MOVE_AMOUNT);
            }
        }  
        if(Greenfoot.isKeyDown("s")){
            if(getY() >= 340)
            {
                EdgeBot = true;
            }
            if(getY() < 340)
            {
                EdgeBot = false;
            }
            if(EdgeBot == false)
            {
                setLocation(getX(),getY()+MOVE_AMOUNT);
                //getWorld().moveCamera(MOVE_AMOUNT);
            }
        } 
        if(Greenfoot.isKeyDown("a")){
            if(getX() <= 50)
            {
                EdgeLeft = true;
            }
            if(getX() > 50) 
            {
                EdgeLeft = false;
            } 
            if(EdgeLeft == false)
            {
                setLocation(getX()-MOVE_AMOUNT,getY());
                getWorld().moveCamera(-MOVE_AMOUNT);
            }
        }  
        if(Greenfoot.isKeyDown("d")){
            if(getX() >= 540)
            {
                EdgeRight = true;
            }
            if(getX() < 540)
            {
                EdgeRight = false;
            }
            if(EdgeRight == false)
            {
                setLocation(getX()+MOVE_AMOUNT,getY());
                getWorld().moveCamera(MOVE_AMOUNT);
            }
        }  
        if(Greenfoot.isKeyDown("space") && FireOn == true)
        {
            Greenfoot.playSound("laserShot.mp3");
            shoot();
        }
        else if(!Greenfoot.isKeyDown("space"))
        {
            FireOn = true;
        }
    }

    public void HitByEnemyBullet()
    {
        Actor enemyBullet = getOneIntersectingObject(EnemyBullets.class);
        World world = getWorld();
        if(enemyBullet != null)
        {
            if(world instanceof SpaceThree)
            {
                getWorld().removeObject(enemyBullet);
                SpaceThree spaceThree = (SpaceThree)world;              
                HealthBar healthBar = spaceThree.getHealthBar();
                healthBar.loseHealth();
            }
        }
    }

    public void shoot()
    {
        getWorld().addObject(new LaserBullet(), getX()+65, getY());
        FireOn = false;
    }
}