public class Payment{
    private double amount;
    private double change;
    
    public Payment(){
        amount=0;
        change=0;
    }
    
    public Payment(double amount){
        this.amount=amount;
        
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the change
     */
    public double getChange() {
        return change;
    }

    /**
     * @param change the change to set
     */
    public void setChange(double change) {
        this.change = change;
    }
    
    
    
    
    
}