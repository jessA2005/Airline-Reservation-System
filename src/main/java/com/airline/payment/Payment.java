package com.airline.payment;

public class Payment {
    private String paymentId;
    private double amount;
    private PaymentStatus status;
    private PaymentMethod paymentMethod;

    public Payment(String paymentId,double amount){
        this.paymentId=paymentId;
        this.amount=amount;
        this.status=PaymentStatus.PENDING;
        this.paymentMethod= null;
    }

    public String getPaymentId(){
        return paymentId;
    }
    public double getAmount(){
        return amount;
    }
    public PaymentStatus getPaymentStatus(){
        return status;
    }
    public PaymentMethod getPaymentMethod(){
        return paymentMethod;
    }

    public void setStatus(PaymentStatus status){
        this.status=status;
    }

    public boolean processPayment(PaymentMethod method){        
        if(method==null){
            this.status=PaymentStatus.FAILED;
            return false;   
        }
        this.paymentMethod=method;
        try{
            boolean isPaid=method.pay(this.amount);
                if(isPaid){
                    this.status=PaymentStatus.SUCCESSFUL;
                    return true;
                }
                    else{
                    this.status=PaymentStatus.FAILED;
                    return false;
                }
        }
        catch(IllegalArgumentException e){
                this.status=PaymentStatus.FAILED;
                System.out.println("payment failed: "+ e.getMessage());
                return false;
        }
        
    }
    public void cancelPayment(){
        if(this.status==PaymentStatus.PENDING){
            this.status=PaymentStatus.FAILED;
            System.out.println("[Payment] Payment " + paymentId + " has been cancelled successfully.");
        }
            else if(this.status==PaymentStatus.SUCCESSFUL){
            throw new IllegalStateException("Cannot cancel completed payment (" + paymentId + "). Please initiate a refund instead.");
        }
        else System.out.println("Payment " + paymentId + " cannot be cancelled because it is already " + status + ".");
        

    }
    public String displayInfo(){
        String name;
        if(this.paymentMethod!=null){
            name=this.paymentMethod.getClass().getSimpleName();
            
        }
        else {
            name= "Not Selected";
        }
        return "Payment Id: "+paymentId +"\n Amount: " + amount +"\n Status: " + status +"\n Method: "+name;  

    }

    
}
