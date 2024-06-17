# HotelReservationSystem

This Java program is a simple yet effective console-based hotel reservation system.

Features
Room Categories: Supports different room categories such as Standard and Deluxe, with various room types.
Room Availability: Displays available rooms in each category.
Reservations: Allows users to make and cancel reservations.
Payment Calculation: Calculates total payment based on stay duration and room price.
User-Friendly: Clean and modular design with a class-based structure.
Input Validation: Ensures valid user inputs for room selection and reservation details.
Error Handling: Handles invalid date formats and room selection errors gracefully.
Design
Class-Based Structure: The program is organized into distinct classes:

Room: Represents a hotel room with attributes like room number, category, availability, and price.
Reservation: Represents a reservation with details like room, guest name, number of guests, check-in and check-out dates, mobile number, and city.
HotelReservationSystem: Manages room categories, reservations, and overall hotel operations.
Switch-Case Statement: The main program uses a switch-case statement to determine the user's choice and execute the corresponding operation.

Private Helper Methods: Mathematical operations are implemented as private methods within the class, promoting encapsulation and code organization.

Menu Display Method: The displayRoomCategories() method is responsible for displaying the room categories to the user.

Input Validation: The program includes input validation to handle invalid choices from the user, such as incorrect room categories and invalid date formats.

Error Handling:

Division by zero is handled with an appropriate error message.
Modulus by zero is handled with an error message.
Looping Mechanism: The program runs in a loop until the user chooses to exit.

Output Formatting: The program provides clear and formatted output for the details of available rooms, reservations, and payment amounts.

Graceful Exit: The program exits gracefully with a thank-you message when the user chooses to exit.
