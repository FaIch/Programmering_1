package Oving11;

import java.util.ArrayList;

public class PropertyRegister { //Creates object properties
    ArrayList<Property> properties;

    /**
     * Constructor, creates the arraylist properties
     */
    public PropertyRegister(){
        properties = new ArrayList<Property>(); // Sets properties as an Arraylist og the object Property
    }

    /**
     * Gets number of properties by measuring the size of the arraylist
     * @return number of properties
     */
    public int getNumberOfProperties(){
        return properties.size();
    }

    /**
     * Creates a new object of Property, and adds it in the properties ArrayList
     * Calls tryValue method to ensure correct input from user
     */
    public void newProperty(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, String lotName, double area, String nameOfOwner){
        tryValues4(municipalityNumber, lotNumber, sectionNumber, area);
        Property property = new Property(municipalityNumber, municipalityName, lotNumber, sectionNumber, lotName, area, nameOfOwner);
        properties.add(property);
    }

    /**
     * Creates a deep copy of each object in the properties ArrayList and adds each object to a new list
     * @return return returnList which holds deep copies of all objects in the property list.
     */
    public ArrayList<Property> getProperties(){
        ArrayList<Property> returnList = new ArrayList<Property>();
        for (Property property : properties){
            returnList.add(new Property(property.getMunicipalityNumber(), property.getMunicipalityName(), property.getLotNumber(), property.getSectionNumber(), property.getLotName(), property.getArea(), property.getNameOfOwner()));
        }
        return returnList;
    }

    /**
     * Calls tryValue method to ensure correct input in the parameters.
     * Creates a new object og Property, iterates through the ArrayList, and checks if the property number given in the parameters matches
     * any existing objects. If so, it removes the object from the list.
     */
    public boolean deleteProperty(int municipalityNumber, int lotNumber, int sectionNumber) {
        tryValues3(municipalityNumber, lotNumber, sectionNumber);
        String propertyNumber = municipalityNumber + "-" + lotNumber + "/" + sectionNumber;
        for (Property property : properties) {
            if (property.getPropertyNumber().equals(propertyNumber)) {
                properties.remove(property);
                return false;
            }
        }
        return true;
    }

    /**
     * Creates a new Arraylist of the object Property, creates a string of the parameters given in the method to match
     * the method in "Property" class. Iterates through properties to see if the numbers on each element in properties
     * matches with the numbers in the parameters. If so, it adds the element to the returnProperties Arraylist.
     * @return This method returns an Arraylist of objects that match with the numbers given in the parameters.
     */
    public ArrayList<Property> getPropertyByNumbers(int municipalityNumber, int lotNumber, int sectionNumber){
        tryValues3(municipalityNumber, lotNumber, sectionNumber);
        ArrayList<Property> returnProperties = new ArrayList<Property>();
        String numbers = municipalityNumber + "-" + lotNumber + "/" + sectionNumber;
        for (Property property : properties){
            if (property.getPropertyNumber().equalsIgnoreCase(numbers)){
                Property newProperty = new Property(property.getMunicipalityNumber(),property.getMunicipalityName(), property.getLotNumber(), property.getSectionNumber(), property.getLotName(), property.getArea(), property.getNameOfOwner());
                returnProperties.add(newProperty);
            }
        }
        return returnProperties;
    }

    /**
     * Calculates the average area of the objects in the Arraylist properties.
     * @return returns the area of all objects, divided by number of objects in the list.
     */
    public String getAverageArea(){
        double area = 0;
        for (Property property : properties){
            area += property.getArea();
        }
        area /= getNumberOfProperties();
        return "Average area(m2)" + area;
    }

    /**
     * Adds all objects of properties that have matching lotNumber with the given lotNumber in the parameter.
     * @return Returns a list of properties that have the given lotNumber as in the parameter.
     */
    public ArrayList<Property> getPropertiesByLotNumber(int lotNumber){
        if (lotNumber < 0){
            throw new IllegalArgumentException("Only positive numbers");
        }
        ArrayList<Property> returnProperties = new ArrayList<Property>();
        for (Property property : properties){
            if (property.getLotNumber() == lotNumber){
                returnProperties.add(new Property(property.getMunicipalityNumber(), property. getMunicipalityName(), property.getLotNumber(), property.getSectionNumber(), property.getLotName(), property.getArea(), property.getNameOfOwner()));
            }
        }
        return returnProperties;
    }

    /**
     * Method for IllegalArgumentException, checks that the values are positive, if not, it throws a new IllegalArgumentException
     */
    public void tryValues3(int value1, int value2, int value3){
        if (value1 < 0 || value2 < 0 || value3 < 0){
            throw new IllegalArgumentException("Only positive numbers");
        }
    }

    /**
     * Does the same as the method above
     * @param value4 since some methods required only 3 parameters, while others required 4, the program has a method
     *               for each to ensure correct inputs.
     */
    public void tryValues4(int value1, int value2, int value3, double value4){
        if (value1 < 0 || value2 < 0 || value3 < 0 || value4 < 0){
            throw new IllegalArgumentException("Only positive numbers");
        }
    }

    /**
     * Method for changing the name of the lot. Finds the property using property number, and then changes the name.
     */
    public boolean setLotName(int municipalityNumber, int lotNumber, int sectionNumber, String newLotName){
        String propertyNumber = municipalityNumber + "-" + lotNumber + "/" + sectionNumber;
        tryValues3(municipalityNumber,lotNumber,sectionNumber);
        for (Property property : properties){
            if (property.getPropertyNumber().equals(propertyNumber)){
                property.setLotName(newLotName);
                return false;
            }
        }
        return true;
    }

    /**
     * Method for changing the area of the lot. Works the same as the method for setting name, however this method uses 4
     * number parameters, so it calls tryValues4 instead of tryValues3.
     */
    public boolean setLotArea(int municipalityNumber, int lotNumber, int sectionNumber, double newArea){
        String propertyNumber = municipalityNumber + "-" + lotNumber + "/" + sectionNumber;
        tryValues4(municipalityNumber,lotNumber,sectionNumber, newArea);
        for (Property property : properties){
            if (property.getPropertyNumber().equals(propertyNumber)){
                property.setArea(newArea);
                return false;
            }
        }
        return true;
    }

    /**
     * Method for changing name of owner. Works the same as the other set methods.
     */
    public boolean setOwner(int municipalityNumber, int lotNumber, int sectionNumber, String newOwner){
        String propertyNumber = municipalityNumber + "-" + lotNumber + "/" + sectionNumber;
        tryValues3(municipalityNumber,lotNumber,sectionNumber);
        for (Property property : properties){
            if (property.getPropertyNumber().equals(propertyNumber)){
                property.setNameOfOwner(newOwner);
                return false;
            }
        }
        return true;
    }
}
