/**
 * Name: Yara Most
 * Class: Object Oriented Programming
 * Date: 04/02/2023
 * Final Project - Luxury Vacation Cruise
 * Description: this program uses ship, cruise, and passenger classes. it displays
 *              a menu system to let the user add, edit or print ships, cruises, and passengers
 *              it ensures ships exist and are in service before adding cruises to them
 *              and cruises exist with available rooms before adding passengers to them.
 *              it uses arraylists of each object type to maintain created objects.
 *
 */
package luxuryvacationcruise;

import java.util.ArrayList;
import java.util.Scanner;

public class LuxuryVacationCruise {

    static Scanner scan = new Scanner(System.in);

    static ArrayList<Ship> shipList = new ArrayList<>();
    static ArrayList<Cruise> cruiseList = new ArrayList<>();
    static ArrayList<Passenger> passengerList = new ArrayList<>();

    public static void main(String[] args) {

        String entry = "0";
        // switch statement for the menu
        do {
            System.out.print("Luxury Vacation Cruise" + "\n"
                    + "[1] Add Ship" + "\t\t" + "[A] Print Ship Names" + "\n"
                    + "[2] Edit Ship" + "\t\t" + "[B] Print Ship In Service List" + "\n"
                    + "[3] Add Cruise" + "\t\t" + "[C] Print Ship Full List" + "\n"
                    + "[4] Edit Cruise" + "\t\t" + "[D] Print Cruise List" + "\n"
                    + "[5] Add Passenger" + "\t" + "[E] Print Cruise Details" + "\n"
                    + "[6] Edit Passenger" + "\t" + "[F] Print Passenger List" + "\n"
                    + "[x] Exit" + "\n"
                    + "Input: ");

            entry = scan.next().toUpperCase();

            scan.nextLine();
            switch (entry) {
                case "1":
                    System.out.println("\n" + "[1] Add Ship:");
                    addShip();
                    break;
                case "2":
                    System.out.println("\n" + "[2] Edit Ship:");
                    editShip();
                    break;
                case "3":
                    System.out.println("\n" + "[3] Add Cruise:");
                    addCruise();
                    break;
                case "4":
                    System.out.println("\n" + "[4] Edit Cruise:");
                    editCruise();
                    break;
                case "5":
                    System.out.println("\n" + "[5] Add Passenger:");
                    addPassenger();
                    break;
                case "6":
                    System.out.println("\n" + "[6] Edit Passenger:");
                    editPassenger();
                    break;
                case "A":
                    System.out.println("\n" + "[A] Print Ship Names:");
                    printShipNames();
                    break;
                case "B":
                    System.out.println("\n" + "[B] Print Ship In Service List:");
                    printShipInService();
                    break;
                case "C":
                    System.out.println("\n" + "[C] Print Ship Full List:");
                    printShipFullList();
                    break;
                case "D":
                    System.out.println("\n" + "[D] Print Cruise List:");
                    printCruiseList();
                    break;
                case "E":
                    System.out.println("\n" + "[E] Print Cruise Details:");
                    printCruiseDetails();
                    break;
                case "F":
                    System.out.println("\n" + "[F] Print Passenger List:");
                    printPassengerList();
                    break;
                case "X":
                    System.out.println("GoodBye.");
                    break;

            }

            System.out.println();

        } while (!entry.equalsIgnoreCase("x"));

    }

    // prompts the user for ship name, cabin capacities, and whether its in service
    // then creates a Ship object and adds it to shipList
    public static void addShip() {
        String name, service;
        int balcony, oceanView, suite, interior;
        boolean inService = true;

        System.out.print("Enter ship name: ");
        name = scan.nextLine();
        System.out.print("Balcony No.: ");
        balcony = scan.nextInt();
        System.out.print("Ocean view No.: ");
        oceanView = scan.nextInt();
        System.out.print("Suite No.: ");
        suite = scan.nextInt();
        System.out.print("Interior No.: ");
        interior = scan.nextInt();
        System.out.print("In service <y/n>: ");
        service = scan.next();

        if (service.equalsIgnoreCase("n")) {
            inService = false;
        }

        shipList.add(new Ship(name, balcony, oceanView, suite, interior, inService));
        System.out.println("Ship \"" + name + "\" has been added.");
    }

    // prompt the user for ship name and look for it in shipList
    // lets the user re-enter its details if found
    // returns if not found
    public static void editShip() {
        String name, service;

        System.out.print("Enter ship name: ");
        name = scan.nextLine();
        for (Ship s : shipList) {
            if (s.getsName().equalsIgnoreCase(name)) {
                System.out.print("Enter new name: ");
                s.setsName(scan.nextLine());
                System.out.print("Balcony No.: ");
                s.setBalcony(scan.nextInt());
                System.out.print("Ocean view No.: ");
                s.setOceanView(scan.nextInt());
                System.out.print("Suite No.: ");
                s.setSuite(scan.nextInt());
                System.out.print("Interior No.: ");
                s.setInterior(scan.nextInt());
                System.out.print("In service <y/n>: ");
                service = scan.next();
                if (service.equalsIgnoreCase("n")) {
                    s.setInService(false);
                } else {
                    s.setInService(true);
                }
                return;
            }
        }
        System.out.println("Ship does not exist.");
        return;

    }

    public static void addCruise() {
        String cruiseName, cruiseShipName, departure, returnPort, yn = "y";
        int balcony = 0, oceanView = 0, suite = 0, interior = 0;
        System.out.print("Enter cruise name: ");
        cruiseName = scan.nextLine();
        // loop to keep prompting user for an exisiting ship name
        do {
            System.out.print("Enter ship name: ");
            cruiseShipName = scan.nextLine();
            // no need to look for ship if there are no ships
            if (shipList.isEmpty()) {
                // let the user go back to main menu
                System.out.println("Ship does not exist. Try again? <y/n>.");
                yn = scan.nextLine();
                if (yn.equalsIgnoreCase("n")) {
                    return;
                }
            } else {
                for (Ship s : shipList) {
                    // get the ship's cabin capacities
                    if (s.getsName().equalsIgnoreCase(cruiseShipName) && s.isInService()) {
                        balcony = s.getBalcony();
                        oceanView = s.getOceanView();
                        suite = s.getSuite();
                        interior = s.getInterior();
                        yn = "n";
                    }
                }
                if (yn == "y") {
                    System.out.println("Ship does not exist or not in service. Try again? <y/n>.");
                    yn = scan.nextLine();
                    if (yn.equalsIgnoreCase("n")) {
                        return;
                    }
                }
            }
        } while (yn.equalsIgnoreCase("y"));

        System.out.print("Enter departure port: ");
        departure = scan.nextLine();
        System.out.print("Enter return port: ");
        returnPort = scan.nextLine();

        // creates Cruise object and add it to cruiseList
        Cruise c;
        cruiseList.add(c = new Cruise(cruiseName, cruiseShipName, departure, returnPort));
        c.setBalconyTotal(balcony);
        c.setInteriorTotal(interior);
        c.setOceanViewTotal(oceanView);
        c.setSuiteTotal(suite);
        System.out.println("Cruise \"" + cruiseName + "\" has been added.");

    }

    // prompt the user for an existing cruise name then let them re-enter
    // the details similar to addCruise()
    public static void editCruise() {
        String cruiseName, cruiseShipName, yn = "y";
        int balcony = 0, oceanView = 0, suite = 0, interior = 0;
        System.out.print("Enter cruise name: ");
        cruiseName = scan.nextLine();

        for (Cruise c : cruiseList) {
            if (c.getCruiseName().equalsIgnoreCase(cruiseName)) {
                System.out.print("Enter new Name: ");
                c.setCruiseName(scan.nextLine());
                do {
                    System.out.print("Enter ship name: ");
                    cruiseShipName = scan.nextLine();

                    for (Ship s : shipList) {
                        if (s.getsName().equalsIgnoreCase(cruiseShipName) && s.isInService()) {
                            c.setCruiseShipName(cruiseShipName);
                            c.setBalconyTotal(balcony);
                            c.setInteriorTotal(interior);
                            c.setOceanViewTotal(oceanView);
                            c.setSuiteTotal(suite);
                            yn = "n";
                        }
                    }
                    if (yn == "y") {
                        System.out.println("Ship does not exist or not in Service. Try again? <y/n>.");
                        yn = scan.nextLine();
                        if (yn.equalsIgnoreCase("n")) {
                            return;
                        }
                    }

                } while (yn.equalsIgnoreCase("y"));

                System.out.print("Enter departure port: ");
                c.setDeparture(scan.nextLine());
                System.out.print("Enter return port: ");
                c.setReturnPort(scan.nextLine());
                return;
            }
        }
        System.out.println("Cruise does not exist.");
    }

    // prompts the user to add a passenger
    // checks if cruise exists with available rooms
    public static void addPassenger() {
        String passName, passCruiseName, roomType = "", yn = "y";

        System.out.print("Enter Passenger name: ");
        passName = scan.nextLine();
        // keep asking for an existing cruise
        do {
            System.out.print("Enter cruise name: ");
            passCruiseName = scan.nextLine();
            if (cruiseList.isEmpty()) {
                System.out.println("Cruise does not exist. Try again? <y/n>.");
                yn = scan.nextLine();
                if (yn.equalsIgnoreCase("n")) {
                    return;
                }
            } else {
                for (Cruise c : cruiseList) {
                    if (c.getCruiseName().equalsIgnoreCase(passCruiseName)) {
                        // cruise exists prompts the user for room type
                        // and decrement the counter in Cruise class
                        System.out.print("Enter room type: ");
                        roomType = scan.nextLine();
                        if (roomType.equalsIgnoreCase("balcony")) {
                            if (c.getBalconyTotal() > 0) {
                                c.setBalconyTotal(c.getBalconyTotal() - 1);
                                yn = "n";
                            } else {
                                System.out.println("Balcony is full.");
                                //return;
                            }
                        } else if (roomType.equalsIgnoreCase("ocean view")) {
                            if (c.getOceanViewTotal() > 0) {
                                c.setOceanViewTotal(c.getOceanViewTotal() - 1);
                                yn = "n";
                            } else {
                                System.out.println("Ocean view is full.");
                                //return;
                            }
                        } else if (roomType.equalsIgnoreCase("suite")) {
                            if (c.getSuiteTotal() > 0) {
                                c.setSuiteTotal(c.getSuiteTotal() - 1);
                                yn = "n";
                            } else {
                                System.out.println("Suite is full.");
                                //return;
                            }
                        } else if (roomType.equalsIgnoreCase("interior")) {
                            if (c.getInteriorTotal() > 0) {
                                c.setInteriorTotal(c.getInteriorTotal() - 1);
                                yn = "n";
                            } else {
                                System.out.println("Interior is full.");
                                //return;
                            }
                        }

                    }
                }
                if (yn == "y") {
                    System.out.println("Cruise does not exist. Try again? <y/n>.");
                    yn = scan.nextLine();
                    if (yn.equalsIgnoreCase("n")) {
                        return;
                    }
                }

            }
        } while (yn.equalsIgnoreCase("y"));

        passengerList.add(new Passenger(passName, passCruiseName, roomType));
        System.out.println("Passenger \"" + passName + "\" has been added.");
    }

    // prompt the user for an existing passenger name then let them re-enter
    // the details similar to addPassenger()
    public static void editPassenger() {
        String passName, newPassName, passCruiseName, roomType = "", yn = "y";
        System.out.print("Enter Passenger name: ");
        passName = scan.nextLine();
        for (Passenger p : passengerList) {
            if (p.getPassengerName().equalsIgnoreCase(passName)) {
                System.out.print("Enter new passenger name: ");
                newPassName = scan.nextLine();
                do {
                    System.out.print("Enter cruise name: ");
                    passCruiseName = scan.nextLine();
                    for (Cruise c : cruiseList) {
                        if (c.getCruiseName().equalsIgnoreCase(passCruiseName)) {
                            System.out.print("Enter room type: ");
                            roomType = scan.nextLine();
                            if (roomType.equalsIgnoreCase("balcony")) {
                                if (c.getBalconyTotal() > 0) {
                                    c.setBalconyTotal(c.getBalconyTotal() - 1);
                                    yn = "n";
                                } else {
                                    System.out.println("Balcony is full.");
                                    return;
                                }
                            } else if (roomType.equalsIgnoreCase("ocean view")) {
                                if (c.getOceanViewTotal() > 0) {
                                    c.setOceanViewTotal(c.getOceanViewTotal() - 1);
                                    yn = "n";
                                } else {
                                    System.out.println("Ocean View is full.");
                                    return;
                                }
                            } else if (roomType.equalsIgnoreCase("suite")) {
                                if (c.getSuiteTotal() > 0) {
                                    c.setSuiteTotal(c.getSuiteTotal() - 1);
                                    yn = "n";
                                } else {
                                    System.out.println("Suite is full.");
                                    return;
                                }
                            } else if (roomType.equalsIgnoreCase("interior")) {
                                if (c.getInteriorTotal() > 0) {
                                    c.setInteriorTotal(c.getInteriorTotal() - 1);
                                    yn = "n";
                                } else {
                                    System.out.println("Interior is full.");
                                    return;
                                }
                            }

                            if (p.getRoomType().equalsIgnoreCase("balcony")) {
                                c.setBalconyTotal(c.getBalconyTotal() + 1);
                            } else if (p.getRoomType().equalsIgnoreCase("ocean view")) {
                                c.setOceanViewTotal(c.getOceanViewTotal() + 1);
                            } else if (p.getRoomType().equalsIgnoreCase("suite")) {
                                c.setSuiteTotal(c.getSuiteTotal() + 1);
                            } else if (p.getRoomType().equalsIgnoreCase("interior")) {
                                c.setInteriorTotal(c.getInteriorTotal() + 1);
                            }

                        }
                    }
                    if (yn == "y") {
                        System.out.println("Cruise does not exist. Enter n to exit.");
                        yn = scan.nextLine();
                        if (yn.equalsIgnoreCase("n")) {
                            return;
                        }
                    }

                } while (yn.equalsIgnoreCase("y"));

                p.setPassengerName(newPassName);
                p.setPassengerCruiseName(passCruiseName);
                p.setRoomType(roomType);
                return;
            }
        }
        System.out.println("Passenger does not exist.");

    }

    public static void printShipNames() {
        for (Ship s : shipList) {
            System.out.println(s.getsName());
        }
    }

    public static void printShipInService() {
        for (Ship s : shipList) {
            if (s.isInService()) {
                System.out.println(s.getsName());
            }
        }
    }

    public static void printShipFullList() {
        for (Ship s : shipList) {
            System.out.println(s.toString());
        }
    }

    private static void printCruiseList() {
        for (Cruise c : cruiseList) {
            System.out.println(c.getCruiseName());
        }
    }

    private static void printCruiseDetails() {
        for (Cruise c : cruiseList) {
            System.out.println(c.toString());
        }
    }

    private static void printPassengerList() {
        for (Passenger p : passengerList) {
            System.out.println(p.toString());
        }
    }
}
