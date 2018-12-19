package testtop;
/*
 *  TESTtop. Making a better TTS for a happier experience.
 */

/**
 * @version 0.1
 * @author Leone Shamoth
 */
import java.util.HashMap;

public class Attack
{
    private boolean isSave;
    private boolean isAttackRoll;
    private DiceSet[] dice = new DiceSet[10];
    
    private String description;
    private boolean descriptionOn;
    
    private String saveEffect;
    private String saveType;
    
    private int distance;
    private int longDistance;
    
    /**
     * The blank constructor for attacks
     */
    public Attack ()
    {
        this.isSave = false;
        this.isAttackRoll = true;
        
        this.description = "";
        this.descriptionOn = false;
        
        this.saveEffect = "";
        this.saveType = "STRENGTH";
        
        this.distance = 5;
        this.longDistance = 0;
    }
    
    /**
     * Full constructor for attacks
     * @param isSave Does the attack have a save component
     * @param isAttackRoll Does the attack have an attack roll
     * @param description The attacks description
     * @param descriptionOn If the description should be displayed on an attack
     * @param saveEffect The affect that occurs on a successful saving throw
     * @param distance The distance the attack can reach
     */
    public Attack (boolean isSave, boolean isAttackRoll, String description, boolean descriptionOn, String saveEffect, String saveType, int distance, int longDistance)
    {
        this.isSave = isSave;
        this.isAttackRoll = isAttackRoll;
        
        this.description = description;
        this.descriptionOn = descriptionOn;
        
        this.saveEffect = saveEffect;
        this.saveType = saveType;
        
        this.distance = distance;
        this.longDistance = longDistance;
    }
 
///////////////////////////////////////GETTERS AND SETTERS//////////////////////////////
    public void setSave (boolean isSave)
    {
        this.isSave = isSave;
    }
    
    public boolean getSave ()
    {
        return (this.isSave);
    }
    
    public void setIsAttackRoll (boolean isAttackRoll)
    {
        this.isAttackRoll = isAttackRoll;
    }
    
    public boolean getIsAttackRoll ()
    {
        return (this.isAttackRoll);
    }
    
    public void setDescription (String descripton)
    {
        this.description = description;
    }
    
    public String getDescription ()
    {
        return (this.description);
    }
    
    public void setDescriptionDisplay (boolean descriptionOn)
    {
        this.descriptionOn = descriptionOn;
    }
    
    public boolean getDescriptionDisplay ()
    {
        return (this.descriptionOn);
    }
    
    public void setSaveEffect (String saveEffect)
    {
        this.saveEffect = saveEffect;
    }
    
    public String getSaveEffect ()
    {
        return (this.saveEffect);
    }
    
    public void setSaveType (String saveType)
    {
        this.saveType = saveType;
    }
    
    public String getSaveType ()
    {
        return (this.saveType);
    }
    
    public void setDistance (int distance)
    {
        this.distance = distance;
    }
    
    public int getDistance ()
    {
        return (this.distance);
    }
    
    public void setLongDistance (int longDistance)
    {
        this.longDistance = longDistance;
    }
    
    public int getLongDistance ()
    {
        return (this.longDistance);
    }
    
    public void setDice (DiceSet[] dice)
    {
        this.dice = dice;
    }
    
    public DiceSet[] getDice ()
    {
        return (this.dice);
    }
    
    /////////////////////////////////////////////////////////Utility Functions///////////////////////////////////////////////
    
    public void addDie (String type, int die, int count)
    {
        int length;
        for (length = 0; dice[length] != null && length < 10; length++);
        
        if (length == 9 && dice[9] != null)
        {
            System.out.println ("Not enought space!");
            return;
            // TODO Add real error print here
        }
        
        dice[length] = new DiceSet (type, die, count);
    }
    
    public HashMap<String, Integer> rollAttack (int toHitModifier, int damageModifier)
    {
        HashMap<String, Integer> toHitnDmg = new HashMap();
        
        toHitnDmg.put ("ToHit", Roll.rollDie(1, 20) + toHitModifier);
        
        for (int i = 0; i < dice.length; i++)
        {
            toHitnDmg.put (dice[i].getDamageType(), dice[i].rollDamage(damageModifier));
        }
        
        return (toHitnDmg);
    }
}
