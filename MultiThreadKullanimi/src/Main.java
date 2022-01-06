

public class Main {
   
    
    public static void main(String[] args) {
        Hesap hesap1 = new Hesap(1000); // bankaci1 için 1000 TL bakiyeli hesap1 nesnesi oluşturma.
        Hesap hesap2 = new Hesap(5000); // bankaci2 için 5000 TL bakiyeli hesap2 nesnesi oluşturma.
        
        Bankaci1 bankaci1 = new Bankaci1(hesap1);
        Bankaci2 bankaci2 = new Bankaci2(hesap2);
        
        Thread t1 = new Thread(bankaci1); //Threadler
        Thread t2 = new Thread(bankaci2);
        
        t1.start(); // Threadleri başlatma.
        t2.start();
        
        
        
       
        
        
       
        
    
        
        
        
        
   
}
    
}
