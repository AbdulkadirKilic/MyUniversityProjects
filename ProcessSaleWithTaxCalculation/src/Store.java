
import java.io.IOException;


public class Store {
     String address= "Izmir/Bornova";
     String name ="Ege Market";
    
    ProductCatalog catalog = new ProductCatalog();
    Register register = new Register( catalog );
     
     public Store() throws IOException{
      
     
     }
     
     public Register getRegister(){ 
         return register;
     } 
    
    
}
