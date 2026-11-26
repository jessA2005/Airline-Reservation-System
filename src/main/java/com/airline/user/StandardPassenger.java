package com.airline.user;

public class StandardPassenger extends Passenger {

    public StandardPassenger(
            int userId,
            String name,
            String email,
            String password,
            String passportNumber,
            String phoneNumber) {

        super(
                userId,
                name,
                email,
                password,
                passportNumber,
                phoneNumber);

    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Standard Passenger" + this.getProfile() +
                        "\nPassportNumber: " + passportNumber +
                        "\nPhonenumber: " + phoneNumber);
    }
}
