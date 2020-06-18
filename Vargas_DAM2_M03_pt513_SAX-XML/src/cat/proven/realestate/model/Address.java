
package cat.proven.realestate.model;

import java.util.Objects;

/**
 * ADT for address of the estates
 * @author Roser
 */
public class Address {
    //Attributes 
    String street;
    int number;
    int floor;
    int door;
    
    //Constructor with all details
    public Address(String street, int number, int floor, int door) {
        this.street = street;
        this.number = number;
        this.floor = floor;
        this.door = door;
    }
    
    //constructor by default
    public Address() {
    }
    
    //constructor by copy
        public Address(Address address) {
        this.street = address.street;
        this.number = address.number;
        this.floor = address.floor;
        this.door = address.door;
    }
        
    //Getters & Setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }
     
    
    //Override method hashcode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.street);
        hash = 29 * hash + this.number;
        return hash;
    }

    /**
     * Override method to create the information of an object of this class
     * in string format
     * @return a string with the information formated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address [");
        sb.append("Street: "); sb.append(street); sb.append(", ");
        sb.append("Number: "); sb.append(number); sb.append(", ");
        sb.append("Floor: "); sb.append(floor); sb.append(",");
        sb.append("Door: "); sb.append(door); sb.append("]");
        return sb.toString();
    }

    /**
     * Override method for comparing a object with an Address object
     * @param o the object to compare 
     * @return true if the given object is the same as our address object
     *          false if the given object is not the same as our address object
     */
    @Override
    public boolean equals(Object o) {
        boolean b;
        //if the object is null
        if (o == null){ 
            b= false;
        //if the object is not null    
        } else {
            //if the object is the same object
            if (this== o) { 
                b= true;
            //if they are not the same object    
            } else {
                //if the object is a instance of this class
                if (o instanceof Address) { 
                    //parse the object from Object class to this class
                    Address obj = (Address) o;
                    //if the 4 attributes are the same
                    if (this.street.equals(obj.street) & (this.number==obj.number) & (this.floor==obj.floor) & (this.door==obj.door)) {
                        b= true;
                    //if the 4 attributes are not the same
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
    
    
}
