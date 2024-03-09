/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luxuryvacationcruise;

/**
 *
 * @author yaksh
 */
public class Ship {
    private String sName;
    private int balcony;
    private int oceanView;
    private int suite;
    private int interior;
    private boolean inService; 

    /**
     *
     * @param sName
     * @param balcony
     * @param oceanView
     * @param suite
     * @param interior
     * @param inService
     */
    public Ship(String sName, int balcony, int oceanView, int suite, int interior, boolean inService) {
        this.sName = sName;
        this.balcony = balcony;
        this.oceanView = oceanView;
        this.suite = suite;
        this.interior = interior;
        this.inService = inService;
    }

    /**
     *
     */
    public Ship() {
        
    }
    
    /**
     *
     * @return
     */
    public String getsName() {
        return sName;
    }

    /**
     *
     * @return
     */
    public int getBalcony() {
        return balcony;
    }

    /**
     *
     * @return
     */
    public int getOceanView() {
        return oceanView;
    }

    /**
     *
     * @return
     */
    public int getSuite() {
        return suite;
    }

    /**
     *
     * @return
     */
    public int getInterior() {
        return interior;
    }

    /**
     *
     * @return
     */
    public boolean isInService() {
        return inService;
    }

    /**
     *
     * @param sName
     */
    public void setsName(String sName) {
        this.sName = sName;
    }

    /**
     *
     * @param balcony
     */
    public void setBalcony(int balcony) {
        this.balcony = balcony;
    }

    /**
     *
     * @param oceanView
     */
    public void setOceanView(int oceanView) {
        this.oceanView = oceanView;
    }

    /**
     *
     * @param suite
     */
    public void setSuite(int suite) {
        this.suite = suite;
    }

    /**
     *
     * @param interior
     */
    public void setInterior(int interior) {
        this.interior = interior;
    }
    
    /**
     *
     * @param inService
     */
    public void setInService(boolean inService) {
        this.inService = inService;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Name: " + sName + "\n"
                + "Balcony: " + balcony + "\t" + "Ocean view: " + oceanView 
                + "\t" +"Suite: " + suite + "\t" + "Interior: " + interior + "\n"
                + "In service: " + inService + "\n";
    }
    
    
}
