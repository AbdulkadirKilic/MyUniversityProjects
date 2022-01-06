import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class ProductCatalog  {
    ProductDescription productDesc = new ProductDescription();
    ArrayList<ProductDescription> fruits = new ArrayList<ProductDescription>();
    ArrayList<ProductDescription> vegetables = new ArrayList<ProductDescription>();
    ArrayList<ProductDescription> basic_needs = new ArrayList<ProductDescription>();
    ArrayList<ProductDescription> personel_care = new ArrayList<ProductDescription>();
    ArrayList<ProductDescription> others = new ArrayList<ProductDescription>();
    Scanner input = new Scanner(System.in);
    
    public ProductCatalog() throws IOException{
        for(int i=0; i<productDesc.descriptionList.size();i++){
            if(1<productDesc.descriptionList.get(i).getItemID() && productDesc.descriptionList.get(i).getItemID()<2000){
                fruits.add(productDesc.descriptionList.get(i));
                
            }
            else if(2000<productDesc.descriptionList.get(i).getItemID() && productDesc.descriptionList.get(i).getItemID()<3000){
                vegetables.add(productDesc.descriptionList.get(i));
            }
            else if(3000<productDesc.descriptionList.get(i).getItemID() && productDesc.descriptionList.get(i).getItemID()<4000){
                basic_needs.add(productDesc.descriptionList.get(i));
            }
            else if(4000<productDesc.descriptionList.get(i).getItemID() && productDesc.descriptionList.get(i).getItemID()<5000){
               personel_care.add(productDesc.descriptionList.get(i));
            }
            else{
                others.add(productDesc.descriptionList.get(i));
            }
            
        }
        
    }
    public void getProductDescription(){
        while(true){
        System.out.println("Which category would you like to look at?");
        System.out.println("1. Fruits"+"\n2. Vegetables"+"\n3. Basic Needs"+"\n4. Personel Care"+"\n5. Others"+"\n0. Exit");
        System.out.println("Please enter a number:");
        int no = input.nextInt();
        
        
            if(no==1){
                for(int i=0; i<fruits.size();i++){
                System.out.println((i+1)+" "+fruits.get(i));
                }
                
            }
                else if(no==2){
                    for(int i=0; i<vegetables.size();i++){
                    System.out.println((i+1)+" "+vegetables.get(i));
            }
                       
        }
            else if(no==3){
                for(int i=0; i<basic_needs.size();i++){
                System.out.println((i+1)+" "+basic_needs.get(i));
            }
            
            
        }
            else if(no==4){
                for(int i=0; i<personel_care.size();i++){
                System.out.println((i+1)+" "+personel_care.get(i));
            }
            
        }
            else if(no==5){
                for(int i=0; i<others.size();i++){
                System.out.println((i+1)+" "+others.get(i));
            }
            
            
            
        }
        else if(no==0){
            break;
        }
        System.out.println("0. Exit"+" 6. Turn Back\nEnter please:");
        int num=input.nextInt();
        if(num==0)
            break;
        
         else if(num==6){
                
        }
        }
                
               }

            
        
        
        
}

    
    

