

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;



public class Liste {
    
    Bilgi head=null;
    Bilgi tail=null;
    Scanner input = new Scanner(System.in);
    ArrayList<Bilgi> siralama_listesi;//Dosyadan cekilen elemanlari atip siralamak icin Arraylist
    
    
    //DOSYADAN SPORCULARI CEKIP ALFABETIK SIRALAYAN METOT
    public void dosyadanCek()  throws IOException{
        File file = new File("sporcu.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String satir = reader.readLine();
 
        this.siralama_listesi = new ArrayList<Bilgi>();
        
        
        while(satir!=null){
         Bilgi yeni_nesne = new Bilgi();
        ArrayList<String> takim_list=new ArrayList<>();
                
        StringTokenizer st = new StringTokenizer(satir,",");
        yeni_nesne.setAdSoyad(st.nextToken());
        yeni_nesne.setBirthDate(st.nextToken());
        
        
        while(st.hasMoreTokens()){
            takim_list.add(st.nextToken());
            
        }
        yeni_nesne.setTakimlar(takim_list);
        
        siralama_listesi.add(yeni_nesne);
        satir=reader.readLine();
        }
       
        Collections.sort(siralama_listesi);//SPORCULARI ALFABETIK SIRALAR
         
         //SIRALI LİSTEDEKİ ELEMANLARI ÇİFT BAĞLI LİSTEYE ATAMA
         for(int i=0;i<siralama_listesi.size();i++){
             Bilgi yeni_eleman= siralama_listesi.get(i);
             
             if(head==null){
                 
                 head=yeni_eleman;
                 tail=yeni_eleman;
                 
                 
             }
             else {
                 tail.next=yeni_eleman;
                 yeni_eleman.previous=tail;
                 tail=yeni_eleman;
                 
            }
             
         }
             
    }
    
    //SPORCU EKLEME METODU
    public void Ekle(){
        Bilgi yeni_eleman;
        ArrayList<String> takim_girdiler= new ArrayList<>();
        
        
        System.out.println("Sporcunun ad ve soyadını giriniz:");
        String ad_soyad=input.nextLine();
        
        System.out.println("Doğum tarihini örnekteki sekilde giriniz:ornek: 12/3/1995");
        String birtdate=input.nextLine();
        
        System.out.println("Sporcunun oynadigi kulupleri sirasiyla giriniz:(cikis=0)");
        String kulup=input.nextLine();
        do{
            takim_girdiler.add(kulup);
            
            System.out.println("Sonraki kulubu giriniz:(cikis=0)");
            kulup=input.nextLine();
            
        }while(!kulup.equals("0"));       
        
        yeni_eleman = new Bilgi(ad_soyad,birtdate,takim_girdiler);
        siralama_listesi.add(yeni_eleman); //Eklenen sporcuyu listeye atma
        Collections.sort(siralama_listesi);//Listeyi tekrar siralama
        head=null;
        
        //Siralanan liste tekrar bagli listeye atandi
        for(int i=0;i<siralama_listesi.size();i++){
              yeni_eleman= siralama_listesi.get(i);
              
              if(head==null){
                 
                  head=yeni_eleman;
                  tail=yeni_eleman;
              }
              else{
                 head.previous=null;
                 tail.next=yeni_eleman;
                 yeni_eleman.previous=tail;
                 yeni_eleman.next=null;
                 tail=yeni_eleman;
              }
             
                 
        }
        System.out.println("SPORCU EKLENDI...");
    }
    //LISTEDEKI SPORCULARI A'DAN Z'YE YAZDIRMA METODU
    public void bastanYazdir(){
        Bilgi pointer =head;
        System.out.println("------------------------A'DAN Z'YE ---------------------------------------");
        while(pointer!=null){
            System.out.println(pointer.getAdSoyad()+" "+pointer.getBirthDate()+" "+pointer.getTakimlar());
            pointer=pointer.next;   
    }
        
        System.out.println("------------------------A'DAN Z'YE-----------------------------------------");
    }
    
    //LISTEDEKI SPORCULARI Z'DEN A'YA YAZDIRMA METODU
    public void sondanYazdir(){
        Bilgi pointer=tail;
        System.out.println("------------------------Z'DEN A'YA ---------------------------------------");
        while(pointer!=null){
            
            System.out.println(pointer.getAdSoyad()+" "+pointer.getBirthDate()+" "+pointer.getTakimlar());
            pointer=pointer.previous;
        }
        System.out.println("------------------------Z'DEN A'YA ---------------------------------------");       
    }
    
    //AD SOYADI GIRILEN SPORCU BILGISI YAZDIRMA METODU
    public void sporcuBilgiYazdir(){
        Bilgi pointer =head;
        System.out.println("Bilgilerini görmek istediginiz sporcunun adi ve soyadini giriniz:");
        String adsoyad= input.nextLine();
        
        while(pointer!=null){
            if(pointer.getAdSoyad().equalsIgnoreCase(adsoyad)){
                System.out.println("------------------------TEXT AREA---------------------------");
                System.out.println("Ad Soyad: "+pointer.getAdSoyad()+"\nDogum Tarihi: "+pointer.getBirthDate()+"\nOynadigi Kulupler: "+pointer.getTakimlar());
                System.out.println("------------------------TEXT AREA---------------------------");
            }
            pointer=pointer.next;
            
        }
    }
    
    //AD SOYADI GIRILEN SPORCU SILME METODU
    public void sporcuSil(){
        Bilgi pointer=head;
        System.out.println("Silmek istediginiz sporcunun adi ve soyadini giriniz:");
        String ad_soyad= input.nextLine();
        
        while(pointer!=null){
            
            if(pointer.getAdSoyad().equalsIgnoreCase(ad_soyad)){  
                break;               
            }
            
            pointer=pointer.next;
        }
        
        if(pointer==head){
            if(head==tail){
                head=null;
                tail=null;
            }
            else{
                head=pointer.next;
                head.previous=null;
                
            }                    
        }
        
        else if(pointer==tail){
                tail=pointer.previous;
                tail.next=null;         
        }
        
        else{
            pointer.previous.next=pointer.next;
            pointer.next.previous=pointer.previous;           
        }
        System.out.println("SPORCU SILINDI..");           
            
    }
    //LISTENIN SON HALINI DOSYAYA GERI YAZAN METOT
    public void dosyaYaz()throws IOException{
        File f= new File("sporcu.txt");
        
            FileWriter yazici= new FileWriter(f);
            
                
                
            for(int i=0;i<siralama_listesi.size();i++){
                yazici.write(siralama_listesi.get(i).getAdSoyad()+","+siralama_listesi.get(i).getBirthDate()+","+siralama_listesi.get(i).getTakimlar()+"\n");
                
                
            }
            yazici.close();
            
            
        
    }
    
}
    
    
    
    
    
    
    

    
        
        
        
    
    


