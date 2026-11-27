package com.airline.payment;

public class DigitalWalletPayment implements Refundable , PaymentMethod {
    private String walletProvider;
    private String walletAccount;

    public DigitalWalletPayment(String walletProvider, String walletAccount){
        this.walletAccount=walletAccount;
        this.walletProvider=walletProvider;
    }
    public String getWalletProvider(){
        return walletProvider;
    }
    public String getWalletAccount(){
        return walletAccount;
    }

    @Override 
    public boolean pay(double amount) throws IllegalArgumentException {
        if(amount <=0) throw new IllegalArgumentException("Payment amount must be greater than zero");
        else if(amount >5000) throw new IllegalArgumentException("paymemt amount excceded the max amount ");
        else if (walletProvider==null||walletProvider.trim().isEmpty()) throw new IllegalArgumentException("Wallet provider cannot be null or empty.");
        else if (walletAccount==null||walletAccount.trim().isEmpty())  throw new IllegalArgumentException("Wallet account cannot be null or empty.");
        else  {
            System.out.println("[Digital Wallet] Payment of $" + amount + " processed successfully via " + walletProvider + " (" + walletAccount + ").");
            return true;
        }

    }

    @Override 
    public boolean refund(double amount) throws IllegalArgumentException{
        if(amount<=0)  throw new IllegalArgumentException("Refund amount must be greater than zero");
        else if(walletProvider==null||walletProvider.trim().isEmpty())   throw new IllegalArgumentException("Wallet provider cannot be null or empty.");
        else if(walletAccount==null||walletAccount.trim().isEmpty()) throw new IllegalArgumentException("Wallet account cannot be null or empty.");
        else  {
            System.out.println("[Digital Wallet] Instant refund of $" + amount + " credited to " + walletProvider + " account (" + walletAccount + ")." );
            System.out.println(" Zero refund fees");
            return true;
        }


    }
}
