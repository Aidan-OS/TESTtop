package testtop;
/*
 *  TESTtop. Making a better TTS for a happier experience.
 */

/**
 * @version 0.1
 * @author Leone Shamoth
 */
public class DiceSet
{  
    private String damageType;
    private int dieType;
    private int dieCount;
    
    public DiceSet ()
    {
        this.damageType = "";
        this.dieType = 0;
        this.dieCount = 0;
    }
    
    public DiceSet (String damageType, int dieType, int dieCount)
    {
        this.damageType = damageType;
        this.dieType = dieType;
        this.dieCount = dieCount;
    }
    
    public void setDamageType (String damageType)
    {
        this.damageType = damageType;
    }
    
    public String getDamageType ()
    {
        return (this.damageType);
    }
    
    public void setDieType (int dieType)
    {
        this.dieType = dieType;
    }
    
    public int getDieType ()
    {
        return (this.dieType);
    }
    
    public void setDieCount (int dieCount)
    {
        this.dieCount = dieCount;
    }
    
    public int getDieCount ()
    {
        return (this.dieCount);
    }
    
    public int rollDamage (int dmgModifier)
    {
        return (Roll.rollDie(dieCount, dieType) + dmgModifier);
    }
}
