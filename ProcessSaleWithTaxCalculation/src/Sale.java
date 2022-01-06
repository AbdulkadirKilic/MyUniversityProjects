import java.util.ArrayList;
import java.util.Date;
public class Sale {
    ArrayList<SalesLineItem> saleLineitems = new ArrayList<SalesLineItem>();
    Date date =new Date();
    
    Payment payment;
    
    
    public double getTotal(){
        double subtotal;
        double total=0;
         for ( SalesLineItem lineItem : saleLineitems ){
             subtotal = lineItem.getSubtotal();
             
             total+=subtotal;
             
             
         }
         
         return total;
    }
    public double getBalance(){
        payment.setChange(payment.getAmount()-getTotal()); 
        return payment.getChange();
    }
    
    public void makeLineItem ( ProductDescription desc, int quantity ) {
        SalesLineItem lineItem= new SalesLineItem(desc, quantity);
        saleLineitems.add(lineItem ); 
    }
    
    public void makePayment( double amount ){
         payment = new Payment( amount); 
    }
    
    
    
    
}
