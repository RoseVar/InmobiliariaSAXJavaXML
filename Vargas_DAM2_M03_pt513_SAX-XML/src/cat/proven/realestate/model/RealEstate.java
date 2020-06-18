
package cat.proven.realestate.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ADT for the Real Estate
 * @author Roser
 */
public class RealEstate {
    //Attributes
    String name;
    List <Estate> estates;

    
    //Constructor with all details
    public RealEstate(String name, List<Estate> estates) {
        this.name = name;
        this.estates = estates;
    }

    //Constructor default
    public RealEstate() {
    }
    
    //Constructor copy
    public RealEstate (RealEstate realEstate) {
        this.name= realEstate.name;
        this.estates= realEstate.estates;
    }
    
    //Getters & setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public List<Estate> getEstates() {
        return estates;
    }

    public void setEstates(List<Estate> estates) {
        this.estates = estates;
    }
    
    
    //Override hashcode method
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.estates);
        return hash;
    }
    
    /**
     * Override method for comparing a object with a RealEstate
     * @param o the object to compare 
     * @return true if the given object is the same as our RealEstate
     *          false if the given object is not the same as our RealEstate
     */
    @Override
    public boolean equals(Object obj) {
        boolean b;
        //if the object is null
        if (obj == null){ 
            b= false;
        //if the object is not null    
        } else {
            //if the object is the same object
            if (this== obj) { 
                b= true;
            //if they are not the same object    
            } else {
                //if the object is a instance of this class
                if (obj instanceof RealEstate) { 
                    //parse the object from Object class to this class
                    RealEstate newObj = (RealEstate) obj;
                    //if this attribute is the same...
                    if (this.name.equals((newObj.name))) {
                        b= true;
                    //if this attribute is not the same
                    } else{
                        b= false;
                    }
                //if object is not an instance of this class
                } else {
                    b= false;
                }
            }
        }
        return b;
    }    

    /**
     * override toString method
     * @return data of RealEstae in string format
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RealEstate [");
        sb.append("Name: "); sb.append(name); sb.append(", ");
        
        for (Estate estate: estates){
            sb.append(estate.toString());
        }
        sb.append("].");
        
        return sb.toString();
    }
    
    /**
     * Method for searching all estates in RealEstate
     * @return List of estates or empty list it there is no one
     */ 
    public List <Estate> listAllEstates() {
        return this.estates;
    }
    
    
    /**
     * Method for searching all premises in RealEstate
     * @return List of estates type premise or empty list it there is no one
     */
       public List <Estate> listAllPremises() {
        List<Estate> allPremises = new ArrayList<Estate>();
        for (Estate est: estates) {
            if (est.getType().equalsIgnoreCase("Premise")) {
                allPremises.add(est);
            }
        }
        return allPremises;
    }
       
    /**
     * Method for searching all houses in RealEstate
     * @return List of estates type house or empty list it there is no one
     */
       public List <Estate> listAllHouses() {
       List<Estate> allHouses = new ArrayList<Estate>();
        for (Estate est: estates) {
            if (est.getType().equalsIgnoreCase("House")) {
                allHouses.add(est);
            }
        }
        return allHouses;
    }
}

