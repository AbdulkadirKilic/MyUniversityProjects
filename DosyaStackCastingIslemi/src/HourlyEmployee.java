

public class HourlyEmployee extends Employee {
    private int workHours; // kaç saat çalışması
    private int wage; // saatlik ücret
    
    public HourlyEmployee(){
        workHours=0;
        wage=0;
    }
    
    public HourlyEmployee(String Ad,String Soyad,String TcKimlikNo, int workHours, int wage){
        super(Ad, Soyad, TcKimlikNo);
        this.workHours=workHours;
        this.wage=wage;
    }

   
    /**
     * @return the workHours
     */
    public int getWorkHours() {
        return workHours;
    }

    /**
     * @param workHours the workHours to set
     */
    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    /**
     * @return the wage
     */
    public int getWage() {
        return wage;
    }

    /**
     * @param wage the wage to set
     */
    public void setWage(int wage) {
        this.wage = wage;
    }
    
     public String toString(){
         return ("Ad Soyad: "+getAd()+" "+getSoyad()+"\nTC: "+getTcKimlikNo()+"\nÇalisma saati:"+getWorkHours()+"\nSaat ücreti:"+getWage()+"\nMaas: "+maasAl());
    
    }
    
    @Override
    public double maasAl() {
        return getWorkHours()*getWage();
    }
    
}
