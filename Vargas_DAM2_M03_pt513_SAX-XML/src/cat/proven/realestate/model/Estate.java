
package cat.proven.realestate.model;

import java.util.Objects;

/**
 * ADT for details of a Estate
 * @author Roser
 */
public class Estate {
    //Attributes
    String id;
    String type;
    Double surface;
    Address address;
    Double price;


    //Constructor with all details
    public Estate(String id, String type, Double surface, Address address, Double price) {
        this.id = id;
        this.type = type;
        this.surface = surface;
        this.address = address;
        this.price = price;
    }

    //Constructor default
    public Estate() {
    }
    
    //Constructor copy
    public Estate (Estate estate){
        this.id = estate.id;
        this.type = estate.type;
        this.surface = estate.surface;
        this.address = estate.address;
        this.price = estate.price;
    }
    
    //Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getSurface() {
        return surface;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    //Override method of hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Override method for comparing an object with a Estate object
     * @param o the object to compare 
     * @return true if the given object is the same as our Estate
     *          false if the given object is not the same as our Estate
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
                if (obj instanceof Estate) { 
                    //parse the object from Object class to this class
                    Estate newObj = (Estate) obj;
                    //if this attribute is the same...
                    if (this.id.equals((newObj.id))) {
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
     * Override toString method
     * @return data of RealEstae in string format
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estate [");
        sb.append("ID: "); sb.append(id); sb.append(", ");
        sb.append("Type: "); sb.append(type); sb.append(", ");
        sb.append("Surface: "); sb.append(surface); sb.append(", ");
        sb.append(address.toString()); 
        sb.append("Price: "); sb.append(price); sb.append("]"); 
        return sb.toString();
    }
    
}