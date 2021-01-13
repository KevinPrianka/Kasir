/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.app.models;
/**
 *
 * @author baros
 */
public class Payment {
  int Amount, Payment;
  Productpost productPay;
  
  //SETTER
  public void setProduct(Productpost product) {
      this.productPay = product; 
  }
  
  public void setAmount(int amount) {
    this.Amount = amount;
  }

  public void setPayment(int payment) {
    this.Payment = payment;
  }
  
  //GETTER
     public Productpost getProduct() {
    return productPay; 
  }
   
    public int getAmount() {
    return Amount;
  }
  
    public int getPayment() {
    return Payment;
  }

  //CALCULATION
  public int Bill, moneyChanges;
  public int Bill() {
      return getAmount() * productPay.getPrice();
  }
  public int moneyChanges() {
      return getPayment() - Bill();
  }
} 

