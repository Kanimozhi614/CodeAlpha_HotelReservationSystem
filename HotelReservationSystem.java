import java.text.*;
import java.util.*;

class Room {
    private final int roomNumber;
    private String category;
    private boolean available;
    private double price;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.available = true;
        this.price = price;
    }
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Room number: " + roomNumber +
                ", Category: " + category +
                ", Price: $" + price +"/day"+
                ", Availability: " + (available ? "Available" : "Occupied");
    }
}

class Reservation {
    private Room room;
    private String guestName;
    private int numberOfGuests;
    private String checkInDate;
    private String checkOutDate;
    private String mobileNumber;
    private String city;

    public Reservation(Room room, String guestName, int numberOfGuests, String checkInDate, String checkOutDate, String mobileNumber, String city) {
        this.room = room;
        this.guestName = guestName;
        this.numberOfGuests = numberOfGuests;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.mobileNumber = mobileNumber;
        this.city = city;
    }
    public Room getRoom() {
        return room;
    }

    public String getGuestName() {
        return guestName;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getCity() {
        return city;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }
    

    @Override
    public String toString() {
        return "Reservation details:\n" +
                "Guest Name: " + guestName +
                "\nMobile Number: " + mobileNumber +
                "\nCity: " + city+
                "\nRoom: " + room +
                "\nNumber of Guests: " + numberOfGuests +
                "\nCheck-in Date: " + checkInDate +
                "\nCheck-out Date: " + checkOutDate;
    }
}

public class HotelReservationSystem {
    private Map<String, List<Room>> roomsByCategory;
    private List<Reservation> reservations;

    public HotelReservationSystem() {
        roomsByCategory = new HashMap<>();
        reservations = new ArrayList<>();

        Room singleStandard101 = new Room(101, "Standard Single Bedroom", 500);
        Room doubleStandard102 = new Room(102, "Standard Double Bedroom", 1000);
        Room balconyStandard103 = new Room(103, "Standard Big Balcony", 1200);
        Room singleDeluxe201 = new Room(201, "Deluxe Single Bedroom", 1500);
        Room doubleDeluxe202 = new Room(202, "Deluxe Double Bedroom", 2000);
        Room balconyDeluxe203 = new Room(203, "Deluxe Big Balcony", 2500);

        List<Room> standardRooms = new ArrayList<>();
        standardRooms.add(singleStandard101);
        standardRooms.add(doubleStandard102);
        standardRooms.add(balconyStandard103);

        List<Room> deluxeRooms = new ArrayList<>();
        deluxeRooms.add(singleDeluxe201);
        deluxeRooms.add(doubleDeluxe202);
        deluxeRooms.add(balconyDeluxe203);

        roomsByCategory.put("Standard", standardRooms);
        roomsByCategory.put("Deluxe", deluxeRooms);
    }

    public void displayRoomCategories() {
        System.out.println("\nRoom Categories:");
        System.out.println("1. Standard");
        System.out.println("2. Deluxe");
    }

    public void displayAvailableRooms(String category) {
        List<Room> roomsInCategory = roomsByCategory.get(category);
        if (roomsInCategory == null) {
            System.out.println("Invalid category.");
            return;
        }
        System.out.println("\nAvailable Rooms in " + category + " category:");
        for (Room room : roomsInCategory) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    public void makeReservation(Room room, String guestName, int numberOfGuests, String checkInDate, String checkOutDate, String mobileNumber, String city, double totalPayment) {
        if (!room.isAvailable()) {
            System.out.println("Room is already occupied.");
            return;
        }
        room.setAvailable(false);
        reservations.add(new Reservation(room, guestName, numberOfGuests, checkInDate, checkOutDate,mobileNumber, city));
        System.out.println("Reservation successful:");
        System.out.println("Total Payment: $" + totalPayment);
        System.out.println(room);
    }

    public void cancelReservation(Reservation reservation) {
        Room room = reservation.getRoom();
        room.setAvailable(true); 
        reservations.remove(reservation);
        System.out.println("Reservation canceled for:\n" + room);
    }

    public boolean overlapDates(String startDate1, String endDate1, String startDate2, String endDate2) {
        return false;
    }

    public long calculateDaysBetween(String startDate, String endDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date start = dateFormat.parse(startDate);
        Date end = dateFormat.parse(endDate);
        long difference = end.getTime() - start.getTime();
        return difference / (1000 * 60 * 60 * 24);
    }

    public static void main(String[] args) {
        HotelReservationSystem hotel = new HotelReservationSystem();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to the Hotel Reservation System");

       
        hotel.displayRoomCategories();

        System.out.print("Enter the room category you want to book:");
        int choice = scanner.nextInt();
        scanner.nextLine();
        String category;
        if (choice == 1) {
            category = "Standard";
        } else if (choice == 2) {
            category = "Deluxe";
        } else {
            System.out.println("Invalid choice. Please select a valid option.");
            scanner.close();
            return;
        }

       
        hotel.displayAvailableRooms(category);

        
        System.out.print("Enter room number to reserve:");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); 

        List<Room> roomsInCategory = hotel.roomsByCategory.get(category);
        Room selectedRoom = null;
        if (roomsInCategory != null) {
            for (Room room : roomsInCategory) {
                if (room.getRoomNumber() == roomNumber) {
                    selectedRoom = room;
                    break;
                }
            }
        }

        if (selectedRoom != null) {
            System.out.print("Enter guest name:");
            String guestName = scanner.nextLine();
            System.out.print("Enter mobile number:");
            String mobileNumber = scanner.nextLine();
            System.out.print("Enter city:");
            String city = scanner.nextLine();
            System.out.print("Enter number of guests:");
            int numberOfGuests = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter check-in date:(DD-MM-YYYY): ");
            String checkInDate = scanner.nextLine();
            System.out.print("Enter check-out date:(DD-MM-YYYY): ");
            String checkOutDate = scanner.nextLine();

           
            try {
                long numberOfDays = hotel.calculateDaysBetween(checkInDate, checkOutDate);
                double totalPayment = numberOfDays * selectedRoom.getPrice();

               
                System.out.println("Payment amount: $" + totalPayment);

               
                System.out.println("Press any key to process payment...");
                scanner.nextLine();

                System.out.println("Payment successful. Your room is booked. Have a nice day!");

                hotel.makeReservation(selectedRoom, guestName, numberOfGuests, checkInDate, checkOutDate, mobileNumber, city, totalPayment);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use DD-MM-YYYY.");
            }
        } else {
            System.out.println("Invalid room number or category.");
        }

        scanner.close();
    }
}
