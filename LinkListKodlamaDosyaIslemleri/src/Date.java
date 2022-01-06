

public class Date {
    private String  birthDate;
    
    public Date(){
         birthDate=null;
    }
    
    public Date(String dogum_tarihi){
        this.birthDate=dogum_tarihi;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    
}
