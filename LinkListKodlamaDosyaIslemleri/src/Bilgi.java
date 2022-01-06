

import java.util.ArrayList;

public class Bilgi extends Date implements Comparable<Bilgi> {
    
    private String adSoyad;
    Bilgi next;
    Bilgi previous;
    private ArrayList takimlar; //Sonradan eklenen sporcunun takimlarini tutmak icin arraylist
    
    public Bilgi(){
        
        adSoyad=null;
        
        
    }
    
    public Bilgi(String adSoyad, String birthDate,ArrayList takimlar){
        super(birthDate);
        this.adSoyad=adSoyad;
        this.takimlar=takimlar;
        next=null;
        previous=null;
    }
     @Override
    public String toString(){
        return (getAdSoyad()+" "+getBirthDate()+" "+getTakimlar());
    }
    
    //Arraylist ICINDEKI NESNELERI adSoyad'a GORE SIRALAMAK ICIN compareTo METODU OVERRIDE EDILDI.
     @Override
    public int compareTo(Bilgi d) {
      return (this.getAdSoyad()).compareTo(d.getAdSoyad());
   }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public ArrayList getTakimlar() {
        return takimlar;
    }

    public void setTakimlar(ArrayList takimlar) {
        this.takimlar = takimlar;
    }
    
    
  
    

    
    
    
    
    
}
