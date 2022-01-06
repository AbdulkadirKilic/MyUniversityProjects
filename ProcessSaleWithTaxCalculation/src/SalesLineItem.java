import java.util.Scanner;
class SalesLineItem {
    private int quantity;
    private ProductDescription product;
    Scanner input = new Scanner(System.in);
    Tax tax = new Tax();
    
    public SalesLineItem(ProductDescription product,int quantity){
        this.product=product;
        this.quantity=quantity;
    }
    
    public double getSubtotal(){
        double subtotal=getProduct().getPrice()*getQuantity();
        double tax_subtotal=tax.applyTax(subtotal);
        return tax_subtotal;
        
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the product
     */
    public ProductDescription getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(ProductDescription product) {
        this.product = product;
    }
    public String toString(){
        return("Product: "+getProduct()+" Quantity: "+getQuantity());
    }
}
