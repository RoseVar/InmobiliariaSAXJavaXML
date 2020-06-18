package cat.proven.realestate.persist;


import cat.proven.realestate.model.RealEstate;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;



/**
 * Class for using SAX
 * @author Roser
 */
public class SaxXMLPersist {
    //Attributes to work with
    SAXParserFactory spf;
    SAXParser parser;
    XMLReader xmlreader;
    RealEstate myrealestate;
    String pathFile = "Resources/realstate.xml";
    
    
    
    /**
     * Method for loading data from the XML file into a RealEstate instace
     * @return RealEstate with the XML data 
     *          or null otherwise
     */
    public RealEstate load() throws SAXException, ParserConfigurationException, IOException {
        myrealestate = new RealEstate();
        //create a Parser Factory
        spf = SAXParserFactory.newInstance();
        //create a parser throught Parser Factory
        parser = spf.newSAXParser();
        //create XML reader throught Parser
        xmlreader = parser.getXMLReader();
        //instantiate a contentHandler from the class RealEstateContentHandle I created
        RealEstateContentHandle contentHandler = new RealEstateContentHandle();
        
        //tell the xmlReader with content handler must use
        xmlreader.setContentHandler(contentHandler);

        //ask the xmlReader to read the file (if it is found)
        try {
            xmlreader.parse(pathFile);
        } catch (FileNotFoundException e) {
             myrealestate=null;
        }
        //the Real Estate will be the result of the method getMyRealEstateParsed() of the content handler
        myrealestate= contentHandler.getMyRealEstateParsed();
        
        return myrealestate;
    }
  
    



}
