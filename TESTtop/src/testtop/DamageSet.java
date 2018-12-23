/*
 *  TESTtop. Making a better TTS for a happier experience.
 */
package testtop;

/**
 * @version 0.1
 * @author Leone Shamoth
 */
public class DamageSet
{
    private String damageType;
    private int damageAmount;
    private String damageSources;
    
    public DamageSet ()
    {
        this.damageType = "";
        this.damageAmount = 0;
        this.damageSources = "0";
    }
    
    public DamageSet (String damageType, int damageAmount)
    {
        this.damageType = damageType;
        this.damageAmount = damageAmount;
        this.damageSources = Integer.toString(damageAmount);
    }
    
    public String getDamageSources ()
    {
        return (this.damageSources);
    }
    
    public void setDamageType (String damageType)
    {
        this.damageType = damageType;
    }
    
    public String getDamageType ()
    {
        return (this.damageType);
    }
    
    public void setDamageAmount (int damageAmount)
    {
        this.damageAmount = damageAmount;
    }
    
    public int getDamageAmount ()
    {
        return (this.damageAmount);
    }
    
    /**
     * A utility function for merging damage amounts
     * @param toMerge The other damage to merge
     * @return If a merge occurred
     */
    public boolean merge (DamageSet toMerge)
    {
        if (toMerge.getDamageType().equals (this.damageType))
        {
            this.damageAmount += toMerge.getDamageAmount ();
            
            if (damageSources.equals(""))
            {
                this.damageSources = Integer.toString(damageAmount);
            }
            
            else
            {
                this.damageSources += " + " + Integer.toString(damageAmount);
            }
            return (true);
        }
        
        else
        {
            return (false);
        }
    }
    
    @Override
    public boolean equals (Object o)
    {
        if (o == this)
        {
            return (true);
        }
        
        else if (o instanceof DamageSet)
        {
            DamageSet toCompare = (DamageSet) o;
            
            if (toCompare.getDamageType().equals(this.damageType))
            {
                return (true);
            }
        }
        
        return (false);
    }
}
