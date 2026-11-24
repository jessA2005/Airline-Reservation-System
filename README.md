```mermaid
classDiagram
direction TB

class Airline {
-String airlineId
-String name
-String country
-String contactNumber
+addFlight(Flight flight) void
+removeFlight(String flightId) void
+getFlights() List~Flight~
}

class Flight {
<<abstract>>
#String flightId
#Airport origin
#Airport destination
#LocalDateTime departureTime
#LocalDateTime arrivalTime
#double basePrice
#FlightStatus status
+calculatePrice() double
+getFlightDetails() String
+compareTo(Flight other) int
}

class DomesticFlight {
-double domesticTax
+calculatePrice() double
+getFlightDetails() String
}

class InternationalFlight {
-double internationalTax
-String visaRequirements
+calculatePrice() double
+getFlightDetails() String
}

class Airport {
-String airportCode
-String name
-String city
-String country
+getAirportDetails() String
}

class Passenger {
<<abstract>>
#String passengerId
#String fullName
#String email
#String phoneNumber
#String passportNumber
+getPassengerDetails() String
}

class StandardPassenger {
+getPassengerDetails() String
}

class FrequentFlyerPassenger {
-int loyaltyPoints
-String membershipLevel
+addPoints(int points) void
+redeemPoints(int points) void
+getPassengerDetails() String
}

class Seat {
-String seatNumber
-SeatClass seatClass
-boolean isAvailable
+reserve() void
+release() void
+getSeatDetails() String
}

class Booking {
-String bookingId
-LocalDateTime bookingDate
-BookingStatus status
-double totalAmount
+confirmBooking() void
+cancelBooking() void
+calculateTotal() double
+getBookingDetails() String
}

class Payment {
-String paymentId
-double amount
-LocalDateTime paymentDate
-PaymentStatus status
+processPayment(PaymentMethod method) boolean
+refund() boolean
}

class PaymentMethod {
<<interface>>
+pay(double amount) boolean
}

class CreditCardPayment {
-String cardHolder
-String cardNumber
+pay(double amount) boolean
}

class DigitalWalletPayment {
-String walletId
+pay(double amount) boolean
}

class ReservationSystem {
-List~Airline~ airlines
-List~Passenger~ passengers
-List~Booking~ bookings
+registerPassenger(Passenger p) void
+searchFlights(String from, String to) List~Flight~
+createBooking(Passenger p, Flight f, Seat s) Booking
+cancelBooking(String bookingId) void
+findBooking(String bookingId) Booking
}

class FlightSorter {
+sort~T~(List~T~ items) void
}

class FlightStatus {
<<enumeration>>
SCHEDULED
DELAYED
CANCELLED
COMPLETED
}

class BookingStatus {
<<enumeration>>
PENDING
CONFIRMED
CANCELLED
}

class PaymentStatus {
<<enumeration>>
PENDING
SUCCESS
FAILED
REFUNDED
}

class SeatClass {
<<enumeration>>
ECONOMY
BUSINESS
FIRST_CLASS
}

Airline "1" o-- "0.._" Flight : operates
Flight <|-- DomesticFlight
Flight <|-- InternationalFlight
Flight "1" --> "1" Airport : origin
Flight "1" --> "1" Airport : destination
Flight "1" _-- "1..\*" Seat : contains

Passenger <|-- StandardPassenger
Passenger <|-- FrequentFlyerPassenger

Passenger "1" --> "0.._" Booking : makes
Booking "0.._" --> "1" Flight : reserves
Booking "0.._" --> "1" Seat : selects
Booking "1" _-- "0..1" Payment : has

Payment --> PaymentMethod : uses
PaymentMethod <|.. CreditCardPayment
PaymentMethod <|.. DigitalWalletPayment

ReservationSystem o-- Airline
ReservationSystem o-- Passenger
ReservationSystem o-- Booking
ReservationSystem ..> Flight : searches

FlightSorter ..> Flight : sorts
Flight ..> FlightStatus
Booking ..> BookingStatus
Payment ..> PaymentStatus
Seat ..> SeatClass
```
