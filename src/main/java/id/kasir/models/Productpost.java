package kasir.app.models;
import kasir.app.models.Productpost;

public class Productpost {
   
    private String Code;
    private String Name;
    private int Price;
    private int Stock;
 //deklarasi variable dengan modifier private agar hanya dapat diakses class itu sendiri.  
  //SETTER
  public void setCode(String code) { 
    this.Code = code;
  }

  public void setName(String name) {
    this.Name = name;
  }

  public void  setPrice(int price) {
    this.Price = price;
  }
  public void  setStock(int stock) {
    this.Stock = stock;
  }

 

  //GETTER
  public String getCode() {
    return Code;
  }
  
  public int getPrice() {
    return Price;
  }
  
  public String getName() {
    return Name;
  }
  
  public int getStock() {
    return Stock;
  }
 }
