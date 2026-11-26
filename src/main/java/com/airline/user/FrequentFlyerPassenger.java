package com.airline.user;

public class FrequentFlyerPassenger extends Passenger {

    private int loyaltyPoints;
    private String membershipLevel;

    public FrequentFlyerPassenger(
            int userId,
            String name,
            String email,
            String password,
            String passportNumber,
            String phoneNumber,
            int loyaltyPoints,
            String membershipLevel) {

        super(
                userId,
                name,
                email,
                password,
                passportNumber,
                phoneNumber);

        if (loyaltyPoints < 0) {
            throw new IllegalArgumentException("Loyalty points cannot be negative.");
        }
        if (membershipLevel == null || membershipLevel.isEmpty()) {
            throw new IllegalArgumentException("Membership level cannot be null or empty.");
        }

        this.loyaltyPoints = loyaltyPoints;
        this.membershipLevel = membershipLevel;
    }

    public void addPoints(int points) {
        if (points <= 0) {
            throw new IllegalArgumentException("Points to add must be positive.");
        }

        loyaltyPoints += points;
        System.out.println("Points added successfully.\n Your balance: " + this.loyaltyPoints);
    }

    public boolean redeemPoints(int points) {
        if (points <= 0) {
            throw new IllegalArgumentException("Points to redeem must be positive.");
        }
        if (this.loyaltyPoints >= points) {
            this.loyaltyPoints -= points;
            System.out.println(points + " points redeemed.\nRemaining balance: " + this.loyaltyPoints);
            return true;
        }
        System.out.println("Insufficient points for redemption.");
        return false;
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Frequent Flyer Passenger" + this.getProfile() + "\nPassportNumber: " + passportNumber
                        + "\nPhonenumber: " + phoneNumber + "\nMembershiplevel: " + membershipLevel
                        + "\nPoints: " + loyaltyPoints);
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }
}
