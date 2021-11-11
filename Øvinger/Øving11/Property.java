package Oving11;

public class Property {
    /**
     * defining object variables. Setting the values that will not be changed, to final.
     */
    private final int municipalityNumber;
    private final String municipalityName;
    private final int lotNumber;
    private final int sectionNumber;
    private String lotName;
    private double area;
    private String nameOfOwner;

    public Property(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, String lotName, double area, String nameOfOwner){
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.lotName = lotName;
        this.area = area;
        this.nameOfOwner = nameOfOwner;
    }

    /**
     * Setting get methods for all variables
     */
    public int getMunicipalityNumber() {
        return municipalityNumber;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public String getLotName() {
        return lotName;
    }

    public double getArea() {
        return area;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    /**
     * Set methods for changing relevant values
     */

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setNameOfOwner(String nameOfOwner) {
        this.nameOfOwner = nameOfOwner;
    }

    /**
     * Gets the unique property number of a given property
     * @return returns a string in the form og municipality number, lot number and section number. Easily identifies and objects
     * for further use in the program
     */
    public String getPropertyNumber(){
        return municipalityNumber + "-" + lotNumber + "/" + sectionNumber;
    }

    /**
     * toString method for the object Property
     * @return returns a string with information on the object.
     */
    public String toString(){
        return this.getMunicipalityNumber() + " " + this.getMunicipalityName() + ", lot number: " + this.getLotNumber()
                + ", section number: " + this.getSectionNumber() + ", lot name: " + this.getLotName() + ", area: " +
                this.getArea() + ", name of owner: " + this.getNameOfOwner();
    }

}
