public class Tax {
    private double taxRate;
    public Tax(){
        taxRate=0.1;
    }
    public Tax(double taxRate){
        this.taxRate=taxRate;
    }

    /**
     * @return the taxRate
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     * @param taxRate the taxRate to set
     */
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
    public double applyTax(double total){
       double taxTotal=(total*taxRate+total);
        return taxTotal;
    }
    
    
}
