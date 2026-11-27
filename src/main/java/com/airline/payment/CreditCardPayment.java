package com.airline.payment;

public class CreditCardPayment implements Refundable,PaymentMethod {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber , String cardHolderName){
        this.cardHolderName=cardHolderName;
        this.cardNumber=cardNumber;

    }
    public String getCardHolderName() {
        return cardHolderName;
    }
    
    public String getCardNumber(){
        return cardNumber;
    }

    @Override 
    public boolean pay(double amount)throws IllegalArgumentException{
        if(amount<=0)  throw new IllegalArgumentException("Payment amount must be greater than zero");
        else if(cardHolderName==null||cardHolderName.trim().isEmpty())   throw new IllegalArgumentException("Cardholder name cannot be null or empty.");
        else if(cardNumber==null) throw new IllegalArgumentException("Card number cannot be null or empty");
        else if(cardNumber.trim().length()<16)    throw new IllegalArgumentException("Card number must contain at least 16 digits.");
        else  {
            System.out.println("[Credit Card] Payment of $" + amount + " processed successfully for " + cardHolderName );
            return true;
        }
    }

    @Override 
    public boolean refund(double amount) throws IllegalArgumentException {
       if(amount<=0)  throw new IllegalArgumentException("Refund amount must be greater than zero");
        else if(cardHolderName==null||cardHolderName.trim().isEmpty())   throw new IllegalArgumentException("Cardholder name cannot be null or empty.");
        else if(cardNumber==null) throw new IllegalArgumentException("Card number cannot be null or empty");
        else if(cardNumber.trim().length()<16)    throw new IllegalArgumentException("Card number must contain at least 16 digits.");
        else  {
            System.out.println("[Credit Card] Refund of $" + amount + " initiated for " + cardHolderName + ". Funds will reflect within 3-5 business days." );
            return true;
        }

    }
    
}
