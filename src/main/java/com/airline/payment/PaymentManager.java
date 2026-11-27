package com.airline.payment;
import java.util.List;
import java.util.ArrayList;

public class PaymentManager {

    private List<Payment> payments;

    public PaymentManager(){
        this.payments=new  ArrayList<>();
    }

    public boolean processPayment(Payment payment, PaymentMethod method)throws IllegalArgumentException{
        if(payment==null||method==null) throw new IllegalArgumentException("Payment transaction and payment method cannot be null.");
        else if (findPayment(payment.getPaymentId())!=null) throw new IllegalArgumentException("Duplicate transaction: Payment with ID " + payment.getPaymentId() + " already exists.");
        boolean isSuccess=payment.processPayment(method);
        payments.add(payment);
        return isSuccess;
    }
    public Payment findPayment(String paymentId){
        for(Payment p : payments){
            if (p.getPaymentId().equals(paymentId)) {
                return p;
            }
        }
        return null;
         
    }
    public void cancelPayment(String paymentId)throws IllegalArgumentException{
        Payment payment=findPayment(paymentId);
        if(payment==null) throw new IllegalArgumentException("Payment with ID "+paymentId+" is not found");
        else { 
            try{
                payment.cancelPayment();
            }
            catch(IllegalStateException e){
                System.out.println(e.getMessage());

            }
        }
    }
    public boolean processRefund(String paymentId){
        Payment payment=findPayment(paymentId);
        if(payment==null){
            System.out.println("[PaymentManager] Refund failed: Payment with ID " + paymentId + " not found.");
            return false;
        }
        else {
            if(payment.getPaymentStatus()!=PaymentStatus.SUCCESSFUL){
                System.out.println("[PaymentManager] Cannot refund payment " + paymentId + " because its status is " + payment.getPaymentStatus() + ".");
                return false;
            }
            PaymentMethod method =payment.getPaymentMethod();
            if(!(method instanceof Refundable)){
                System.out.println("[PaymentManager] Refund failed: This payment method does not support refunds.");
                return false;
            }
            else {
                Refundable refundableMethod=(Refundable) method;
                try{
                    boolean isRefundable=refundableMethod.refund(payment.getAmount());
                    if(isRefundable){
                        payment.setStatus(PaymentStatus.REFUNDED);
                        return true;
                    }
                }catch(IllegalArgumentException e){
                    System.out.println("Refund Failed: "+ e.getMessage());
                    return false;
                }

            }
        }
        return false;

    }
    public void displayPayments(){
        if(payments.isEmpty()){
            System.out.println("[Payment Manager] No payment records found");

        }
        else{
            for(Payment p: payments){
                System.out.println(p.displayInfo());
                System.out.println("--------------------");
            }
        }
    }

}