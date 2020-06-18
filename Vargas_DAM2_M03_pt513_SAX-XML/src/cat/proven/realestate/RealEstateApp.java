
package cat.proven.realestate;

import cat.proven.realestate.model.Estate;
import cat.proven.realestate.model.RealEstate;
import cat.proven.realestate.persist.SaxXMLPersist;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Roser
 */
public class RealEstateApp {
    
    private static RealEstate myRealEstate;
    private static Scanner scan;
    private static SaxXMLPersist saxPers;
    private static int option;
    private boolean nonExit=true;
    
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        
        RealEstateApp myApp= new RealEstateApp();
        myApp.run();
        
                
        }

    private void run() throws SAXException, ParserConfigurationException, IOException {
        loadData();
        if (myRealEstate!=null) {
            System.out.println("Welcome to Real Estate: \""+ myRealEstate.getName() + "\"");
            do {
                option=loadMenu();
                runOption(option);
            } while (nonExit);
        } else{
            System.out.println("Sorry: File not found. Check the path.");
        }
        
    }

    
    /**
     * Method to transfer data read in XML to our class RealEstate
     * @return a Real Estate with the XML data
     */
    private void loadData() throws SAXException, ParserConfigurationException, IOException {
        saxPers = new SaxXMLPersist();
        myRealEstate= saxPers.load();  
    }
        
    
    
    /**
     * Method for loading menu and return the seleccted option from the user
     * @return an integer that represent the option selected.
     */
    private int loadMenu() {
        int resp =0;
        System.out.println("MENU:");
        System.out.println("0 - Exit.");
        System.out.println("1 - List all estates.");
        System.out.println("2 - List only premises.");
        System.out.println("3 - List only houses.");
        scan = new Scanner(System.in);
        try {
            resp = scan.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("This is not an option");
        }
        return resp;
    }
    
    /**
     * Method to process the option the user choose from the menu
     * @param optionChoosed the number choosed by user
     */
    private void runOption(int optionChoosed) {
        switch (option) {
            case 0:
                //Exit
                System.out.println("Thanks for using the app. Goodbye!");
                nonExit= false;
                break;
            case 1:
                //List all estates
                listAllEstates();
                break;
            case 2:
                //list only premises
                listAllPremises();
                break;
            case 3:
                //list only houses
                listAllHouses();
                break;
            default: 
                System.out.println("Sorry. This is not an option. If you want to leave press 0.");
                break;
        }
    }

    /**
     * Method for create and show a List of all estates in the Real Estate
     */
    private void listAllEstates() {
        showSelectedEstates(myRealEstate.listAllEstates(), "estates");
    }

    
    /**
     * Method for showing in console a List of Estates
     * @param allEstates the list to be shown
     */
    private void showSelectedEstates(List<Estate> allEstates, String type) {
        if (allEstates != null) {
            for (int i=0; i<allEstates.size();i++) {
               System.out.println(allEstates.get(i).toString());
            }
            System.out.format(allEstates.size() +" "+ type +" found\n");
        
        } else {
            System.out.println("Null data!");
        } 
    }

    /**
     * Method for create and show a List of Premises of our Real Estate
     */
    private void listAllPremises() {
        List<Estate> allPremises = myRealEstate.listAllPremises();
        showSelectedEstates(allPremises, "premises");
    }

    /**
     * Method for create and show a List of Houses of our Real Estate
     */
    private void listAllHouses() {
        List<Estate> allHouses = myRealEstate.listAllHouses();
        showSelectedEstates(allHouses, "houses");
    }
    
}
