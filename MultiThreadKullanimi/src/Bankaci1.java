

public class Bankaci1 implements Runnable{
    private Hesap hesap_degiskeni;
    
    public Bankaci1(){
        hesap_degiskeni=null;
    }
    
    public Bankaci1(Hesap hesap_degiskeni){
        
        this.hesap_degiskeni=hesap_degiskeni;
    }
    
    @Override
    public void run(){
        //Aşagıdaki try metodunun içinde para çekme ve yatırma işlemlerinden sonra 1.5 saniye, bakiye görüntüleme işlemlerinden sonra 1 saniye beklenmektedir.
        //Aynı zamanda para yatırma ve çekme işlemlerindeki miktar, sıfır ile her işlem sonrası elde edilen son bakiye arasında random bir değer atanarak belirlendi.
        
        try {
            System.out.println("Bankaci1 için "+getHesap_degiskeni().bakiyeOgren()+" TL");
            Thread.sleep(1500); // 1.5 saniye bekleme 
           
             System.out.println("Bankaci1 için "+getHesap_degiskeni().paraYatir(getHesap_degiskeni().randomMiktar())+" TL para yatırıldı.");
             Thread.sleep(1500);
             
             System.out.println("Bankaci1 için "+getHesap_degiskeni().bakiyeOgren()+" TL");             
             Thread.sleep(1000); // 1 saniye bekleme
             
             System.out.println("Bankaci1 için "+getHesap_degiskeni().paraCek(getHesap_degiskeni().randomMiktar())+" TL para çekildi.");            
             Thread.sleep(1500);
             
             System.out.println("Bankaci1 için "+getHesap_degiskeni().bakiyeOgren()+" TL");
            
                                                                      
        } 
        catch (Exception e) {
            System.out.println("Hata algılandı.");
        }
        
    }

    /**
     * @return the hesap_degiskeni
     */
    public Hesap getHesap_degiskeni() {
        return hesap_degiskeni;
    }

    /**
     * @param hesap_degiskeni the hesap_degiskeni to set
     */
    public void setHesap_degiskeni(Hesap hesap_degiskeni) {
        this.hesap_degiskeni = hesap_degiskeni;
    }
    
    
    
    
    
}
