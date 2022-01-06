import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
public class Register {
    private ProductCatalog catalog;    
    private Sale currentSale;
    Scanner input = new Scanner(System.in);
    
    
    public Register( ProductCatalog catalog ){
        this.catalog = catalog;
    }
    
    public void endSale() throws IOException{
        
        for(int j=0;j<currentSale.saleLineitems.size();j++){
            
            System.out.println(currentSale.saleLineitems.get(j)+" Taxtotal: "+currentSale.saleLineitems.get(j).getSubtotal()+" Date: "+currentSale.date);
            
            
            
           
            
        }
        System.out.println("Taxtotal Price: "+currentSale.getTotal());
        
        System.out.println("Enter the amount you want to pay:");
            double amount=input.nextDouble();
            currentSale.makePayment(amount);
            currentSale.getBalance();
            System.out.println("Total Price: "+currentSale.getTotal());
            
            System.out.println("Amount Paid: "+currentSale.payment.getAmount());
            System.out.println("Change "+currentSale.payment.getChange());
            System.out.println("SaleLine Items saving..");
            saleLineRecord();
            System.out.println("Saving is completed.");
            
    }
    ProductDescription descrip =null;
    public void enterItem( int itemID, int quantity ){
        
        for(int i=0; i<catalog.productDesc.descriptionList.size();i++){
           if( catalog.productDesc.descriptionList.get(i).getItemID()==itemID){
               descrip = catalog.productDesc.descriptionList.get(i);
               
               break;
               
           }
           
            
        }
        
        currentSale.makeLineItem( descrip, quantity );
        
         
       
        
    }
    
    public void makeNewSale(){
        currentSale = new Sale();
        
    }
    public void makePayment( double amount ){
         currentSale.makePayment( amount );
    }
    public void startRegister() throws IOException{
        System.out.println("Sale starting...");
        makeNewSale();
        int condition=1;
        while(condition==1){
            
            System.out.println("What would you like to do?");
            System.out.println("1-Show Catalog"+"\n2- Continued Sales"+"\n3- Exit");
            System.out.println("Please enter the number:");
            int num=input.nextInt();
            if(num==1){
                catalog.getProductDescription();
    
            }
            else if(num==2){
                System.out.println("Enter the itemID:");
                int id=input.nextInt();
                System.out.println("Enter the quantity:");
                int quant = input.nextInt();
                currentSale.date= new Date();
                enterItem(id, quant);
                currentSale.getTotal();
                System.out.println("Sale successfull");
                System.out.println("Choose what you want to do:");
                System.out.println("3- Continue Selling"+" 4- End of Sale");
                int choose = input.nextInt();
                if(choose==3){
                    condition=1;
                }
                else if(choose==4){
                    condition=0;
                }
                
                
                
                
            }
            else if(num==3){
                condition=0;
            }
            
            
            
        }
        endSale();
        
        
    }
    public void saleLineRecord() throws IOException{
        File f= new File("saleLineitemRecords.txt");
        
            FileWriter yazici= new FileWriter(f);
            
                
                
            for(int i=0;i<currentSale.saleLineitems.size();i++){
                yazici.write(currentSale.saleLineitems.get(i).getProduct()+","+"Quantity:"+currentSale.saleLineitems.get(i).getQuantity()+","+"Subtotal:"+currentSale.saleLineitems.get(i).getSubtotal()+"\n");
                
                
            }
            yazici.close();
            
            
        
    }

        
}

