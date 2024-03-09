/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luxuryvacationcruise;


public class Cruise {
    private String cruiseName;
    private String cruiseShipName;
    private String departure;
    private String returnPort;
    private int balconyTotal;
    private int oceanViewTotal;
    private int suiteTotal;
    private int interiorTotal;

    public Cruise(String cruiseName, String cruiseShipName, String departure, String returnPort) {
        this.cruiseName = cruiseName;
        this.cruiseShipName = cruiseShipName;
        this.departure = departure;
        this.returnPort = returnPort;
    }
    
    public Cruise() {
        
    }

    public String getCruiseName() {
        return cruiseName;
    }

    public String getCruiseShipName() {
        return cruiseShipName;
    }

    public String getDeparture() {
        return departure;
    }

    public String getReturnPort() {
        return returnPort;
    }
    
    public int getBalconyTotal() {
        return balconyTotal;
    }

    public int getOceanViewTotal() {
        return oceanViewTotal;
    }

    public int getSuiteTotal() {
        return suiteTotal;
    }

    public int getInteriorTotal() {
        return interiorTotal;
    }

    public void setCruiseName(String cruiseName) {
        this.cruiseName = cruiseName;
    }

    public void setCruiseShipName(String cruiseShipName) {
        this.cruiseShipName = cruiseShipName;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setReturnPort(String returnPort) {
        this.returnPort = returnPort;
    }

    public void setBalconyTotal(int balconyTotal) {
        this.balconyTotal = balconyTotal;
    }

    public void setOceanViewTotal(int oceanViewTotal) {
        this.oceanViewTotal = oceanViewTotal;
    }

    public void setSuiteTotal(int suiteTotal) {
        this.suiteTotal = suiteTotal;
    }

    public void setInteriorTotal(int interiorTotal) {
        this.interiorTotal = interiorTotal;
    }

    @Override
    public String toString() {
        return "Cruise name: " + cruiseName + "\nShip name: " + cruiseShipName + "\nDeparture: " + departure + "\t\tReturn port: " + returnPort + "\n"
                + "Balcony: " + balconyTotal + " available"
                + "\nOcean View: " + oceanViewTotal + " available"
                + "\nSuite: " + suiteTotal + " available"
                + "\nInterior: " + interiorTotal + " available";
    }
    
}
