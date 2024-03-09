/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luxuryvacationcruise;


public class Passenger {
    private String passengerName;
    private String passengerCruiseName;
    private String roomType;

    public Passenger(String passengerName, String passengerCruiseName, String roomType) {
        this.passengerName = passengerName;
        this.passengerCruiseName = passengerCruiseName;
        this.roomType = roomType;
    }

    public Passenger() {
        
    }
    
    public String getPassengerName() {
        return passengerName;
    }

    public String getPassengerCruiseName() {
        return passengerCruiseName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setPassengerCruiseName(String passengerCruiseName) {
        this.passengerCruiseName = passengerCruiseName;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Passenger name: " + passengerName + "\nCruise name: " + passengerCruiseName + "\nRoom type: " + roomType + "\n";
    }
    
    
}
