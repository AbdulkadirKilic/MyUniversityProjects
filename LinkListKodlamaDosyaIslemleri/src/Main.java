

import java.util.Scanner;
import java.io.IOException;



public class Main  {
    
    
    
    
    public static void main(String[] args) throws IOException {
        Scanner klavye = new Scanner(System.in);
        Liste liste= new Liste();
        liste.dosyadanCek();
        int secim=0;
        
        do{
            System.out.println("Yapmak istediginiz islemin numarasını giriniz:\n"
                + "1-Sporcu Ekle\n"
                + "2-Sporcu Bilgi Yazdir\n"
                + "3-Sporcu Sil\n"
                + "4-Listeyi A'dan Z'ye Yazdir\n"
                + "5-Listeyi Z'den A'ya Yazdir\n"
                + "0-Cikis");
          secim= klavye.nextInt();
        
        if(secim==1){
            liste.Ekle();
        }
        else if(secim==2){
            liste.sporcuBilgiYazdir();
        }
        else if(secim==3){
            liste.sporcuSil();
        }
        else if(secim==4){
            liste.bastanYazdir();
            
        }
        else if(secim==5){
            liste.sondanYazdir();
        }
        else {
            break;
        }
            
        }while(secim!=0);
        
        liste.dosyaYaz();//Sistemden cikildiktan sonra listenin son halini sporcu.txt'ye geri yazdik.
                     
    }
}
