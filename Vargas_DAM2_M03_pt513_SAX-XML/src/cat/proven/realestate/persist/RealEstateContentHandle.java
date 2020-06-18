package cat.proven.realestate.persist;

import cat.proven.realestate.model.Address;
import cat.proven.realestate.model.Estate;
import cat.proven.realestate.model.RealEstate;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Roser
 */
public class RealEstateContentHandle extends DefaultHandler {
    //Attributes to work with
    RealEstate myRealEstate;
    Estate myEstate;
    Address myAddress;
    List<Estate> myEstates;
        
    String temp;
    
    
    /**
     * Method used when the document starts, instantiate a RealEstate object and a 
     * List of Estates object, to work with in the document.     
     * @throws SAXException 
     */
    @Override
    public void startDocument() throws SAXException {
        myRealEstate = new RealEstate();
        myEstates= new ArrayList<Estate>();
    }

    /**
     * Method no overrided still.
     * @throws SAXException 
     */
    @Override
    public void endDocument() throws SAXException {
        
    }

    /**
     * Method for adding in buffer every element the XMLreader finds
     * @param uri: 
     * @param localName: name of the element
     * @param qName: namespace + name
     * @param attributes: attributes of the element 
     * @throws SAXException 
     */
    @Override
    public void startElement(String uri, String localName,String qName, Attributes attributes)  throws SAXException {
        temp = "";
        //change the Qname into Lower case for not having problem with camelcase format
        String tempQName = qName.toLowerCase();
        
        switch (tempQName) {
            //if element is realestate, save the name of it
            case "realestate":
                myRealEstate.setName(attributes.getValue("name"));
                break;
            //if element is an estate, save the id of it, and instantiate element
            case "estate":
                myEstate = new Estate();
                myEstate.setId(attributes.getValue("id"));                                  
                break;
            //if element is an address,it does not have any XML attributes. Only instantiate element.
            case "address": 
                myAddress = new Address();
                break;
            //any other case
            default:
                    break;
            }
        
    }
    
    @Override
    public void characters(char[] buffer, int start, int lenght) throws SAXException {
        temp= new String(buffer, start, lenght);
    }

    /**
     * Method that explain the behaviour of the xmlReader when find endElement labels
     * if any number element can not parse data string into its number format, this element
     * will be 0 / 0.0.
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException 
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //change the Qname into Lower case for not having problem with camelcase format
        String tempQName = qName.toLowerCase();
        
        switch (tempQName) {
            //if it is type element, save value of it in the object attribute
            case "type":
                myEstate.setType(temp);
                break;
            //if it is surface element, save value of it in the object attribute. If it can not be parsed into double, set value 0
            case "surface": 
                try{
                    myEstate.setSurface(Double.parseDouble(temp));
                } catch (NumberFormatException e) {
                    myEstate.setSurface(0.0);
                }
                break;    
            //if it is street element, save value of it in the object attribute.
            case "street":
                myAddress.setStreet(temp);
                break;
            //if it is number element, save value of it in the object attribute. If it can not be parsed into integer, set value 0    
            case "number":
                try{
                    myAddress.setNumber(Integer.parseInt(temp));
                } catch (NumberFormatException e) {
                    myAddress.setNumber(0);
                }
                break;
            //if it is floor element, save value of it in the object attribute. If it can not be parsed into integer, set value 0    
            case "floor":
                try{
                    myAddress.setFloor(Integer.parseInt(temp));
                } catch (NumberFormatException e) {
                    myAddress.setFloor(0);
                }
                break;    
            //if it is door element, save value of it in the object attribute. If it can not be parsed into integer, set value 0    
            case "door":
                try{
                    myAddress.setDoor(Integer.parseInt(temp));
                } catch (NumberFormatException e) {
                    myAddress.setDoor(0);
                }
                break;
            //if it is address element, save value of it in the object attribute. It will be have all its attributes saved before, while closing its elements (street, etc)  
            case "address":
                myEstate.setAddress(myAddress);
                break;
            //if it is price element, save value of it in the object attribute. If it can not be parsed into double, set value 0    
            case "price": 
                try{
                    myEstate.setPrice(Double.parseDouble(temp));
                } catch (NumberFormatException e) {
                    myEstate.setPrice(0.0);
                }
                break;  
            //if it is estate element, save value of it in the temporal List of Estates. It will be have all its attributes saved before, while closing its elements (surface, etc)  
            case "estate":
                myEstates.add(myEstate);
            //if it is realEstate element, save temporal List of Estates in the object attribute that is the list of estates of the Real Estate
            case "realestate":
                myRealEstate.setEstates(myEstates);
                break;
        }
    }  
    
    /**
     * Method to return the Real Estate create in parsing
     */
    public RealEstate getMyRealEstateParsed() {
        return this.myRealEstate;
    }
     
}
