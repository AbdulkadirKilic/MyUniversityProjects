


public abstract class Employee {
   
    private String Ad;
    private String Soyad;
    private String TcKimlikNo;
    
    
    public Employee(){
        Ad=null;
        Soyad=null;
        TcKimlikNo=null;
    
    }
    
    
    public Employee(String Ad,String Soyad,String TcKimlikNo){
        this.Ad=Ad;
        this.Soyad=Soyad;
        this.TcKimlikNo=TcKimlikNo;
    
    }
    //getler setler
    /**
     * @return the Ad
     */
    public String getAd() {
        return Ad;
    }

    /**
     * @param Ad the Ad to set
     */
    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    /**
     * @return the Soyad
     */
    public String getSoyad() {
        return Soyad;
    }

    /**
     * @param Soyad the Soyad to set
     */
    public void setSoyad(String Soyad) {
        this.Soyad = Soyad;
    }

    /**
     * @return the TcKimlikNo
     */
    public String getTcKimlikNo() {
        return TcKimlikNo;
    }

    /**
     * @param TcKimlikNo the TcKimlikNo to set
     */
    public void setTcKimlikNo(String TcKimlikNo) {
        this.TcKimlikNo = TcKimlikNo;
    }
    
   
    public String toString() {
	return "Ad: "+getAd()+" Soyad: "+getSoyad()+" Tc Kimlik No: "+getTcKimlikNo();
    }
    
    //double tipinde deger donduren maasAl isimli soyut metod
    public abstract double maasAl();
    
    
}
