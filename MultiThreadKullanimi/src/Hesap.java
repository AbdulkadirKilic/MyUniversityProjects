


import java.text.DecimalFormat;

public class Hesap {
    
    private double bakiye;
    
    public Hesap(){
        bakiye=0;
    }
    
    public Hesap(double bakiye){
        this.bakiye=bakiye;
    }
    
     // Para çekme,yatırma ve bakiyeOgren metotları void olarak da gerçekleştirildi ama double ve String döndüren şekilde yapılarak 
    //hangi işlemin hangi bankacıya ait oldugunun gösterimi daha anlaşılır yapılabildiği için bu şekilde tercih edildi.  
    public double paraCek(double miktar){
        setBakiye(getBakiye() - miktar);
        return miktar;
        
    }
    
    public double paraYatir(double miktar){
        setBakiye(getBakiye() + miktar);
        return miktar;
        
    }
    
    public String bakiyeOgren(){
        return "Bakiye= "+getBakiye();
    }
    
    // 0 ile o anki bakiye arasında virgülden sonra 2 basamak olacak şekilde random double sayı üreten metot, test gösterimi için tercihen oluşturuldu.
    public double randomMiktar(){
        double random = (Math.random()*((getBakiye())+1)); 
        DecimalFormat df = new DecimalFormat("#.##");
        String x =df.format(random);
         x = x.replace(',', '.');
        double y =Double.parseDouble(x);
        return y;
    }

    /**
     * @return the bakiye
     */
    public double getBakiye() {
        return bakiye;
    }

    /**
     * @param bakiye the bakiye to set
     */
    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }
    
    
}
