import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ProductDescription {
    private String description;
    private double price;
    private int itemID;
    ArrayList<ProductDescription> descriptionList = new ArrayList<>();
    
    public ProductDescription() throws IOException{
        Load();
        
        
    }
    public ProductDescription(String description, double price, int itemID){
        this.description=description;
        this.price=price;
        this.itemID=itemID;
    }
    public void Load() throws FileNotFoundException, IOException{
        FileReader fileReader = new FileReader("Descriptions.txt");
        String line;

        BufferedReader br = new BufferedReader(fileReader);

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line,",");
             while(st.hasMoreTokens()){
                
                 description=st.nextToken();
                 price=Double.parseDouble(st.nextToken());
                 itemID=Integer.parseInt(st.nextToken());
                 ProductDescription product = new ProductDescription(description,price,itemID);
             
             
                descriptionList.add(product);
                 
             }
             
             

        

        }

    br.close();
    }
    @Override
    public String toString(){
        return "Description: "+getDescription()+" Price: "+getPrice()+" ItemID: "+getItemID();
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the itemID
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * @param itemID the itemID to set
     */
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    
    
    
}
