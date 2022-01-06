

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class Menu {
    
    Scanner input = new Scanner(System.in);
    private ArrayList<String> wordsList = new ArrayList<>(); //Yazım hatası kontrolunde sozluk olarak daha rahat bir şekilde kullanmak için words.txt dosyasını aktarmak için arraylist.
    private ArrayList<String> yanlis_kelimeler=new ArrayList<>(); //Yazım hatası olan kelimeleri words.txt ile kıyaslayıp doğrusuyla değiştirmek için hatalı yazımları eklediğimiz arralist.
    
      
    
    //İSTENEN BİR DOSYAYI AÇIP OKUMAYI SAĞLAYAN METOT.   
    public void dosyaAc() throws FileNotFoundException, IOException{
        
        System.out.println("Açmak istediğiniz dosyanın adını uzantısız bir şekilde giriniz.");
        String string=input.next()+".txt";
        File file = new File(string);
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String satir = reader.readLine();
        
        while (satir!=null){
                
                System.out.println(satir);
                
                satir=reader.readLine();
            	                                               
        }
                    
    }
     
    //DOSYA OLUŞTURUP KAYDETMEMİZİ SAĞLAYAN METOT, MEVCUT DOSYANIN UZERINE YAZILIP YAZILMAMA TERCIHI DE SUNMAKTA.
    //BURADAKİ String text PARAMETRESİ NOTEPAD (FORM) UZERINDEKI METINI AKTARMAK İÇİN KONULMUŞTUR.
    public void dosyaOlustur(String text) throws IOException{
        System.out.println("Dosya adını uzantısız bir şekilde giriniz:");
        String dosya_adi=input.next()+".txt";
            
        File f= new File(dosya_adi);
        if(!f.exists()){
        
            FileWriter yazici= new FileWriter(f);
                        
            yazici.write(text);
                 
            yazici.close();
            System.out.println("Dosya Oluşturuldu.");
        }
         
        else{
             
            System.out.println("Bu adda bir dosya zaten mevcut. Üzerine yazılsın mı?\n1-Evet\n2-Hayır");
            int secim=input.nextInt();
            
            if(secim==1){
                FileWriter yazici= new FileWriter(f);
                                         
                yazici.write(text);
                yazici.close();
                System.out.println("Dosya Oluşturuldu.");
                 
            }
            else{
                 dosyaOlustur(text); //aynı adlı dosyanın üzerine yazmak istemiyorsa, kullanıcı farklı ad girene veya kaydetmekten vazgecene kadar recursion bir şekilde metot çağırılır.
            }
        }
    }
    
    //İSTENEN BİR DOSYADAN ARANAN KELİMEYİ BULUP DEĞİŞTİREN METOT.
    public void  kelimeBulDegistir() throws FileNotFoundException, IOException{
       
        System.out.println("İslem yapmak istediğiniz txt dosyasının adını uzantısız bir şekilde giriniz:");
        String string_dosya= input.next()+".txt";
        File file = new File(string_dosya);
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String satir = reader.readLine();
        
        System.out.println("Aramak istediginiz kelimeyi giriniz:");
        String kelime=input.next();
        System.out.println("Aradığınız kelimeyi değiştirmek istediğiniz kelimeyi giriniz:");
        String degistir=input.next();
        
        File fileToBeModified = file;
         
        String oldContent = "";
        
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //İlk içeriği okuma
             
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            //eski ve yeni içeriği yer değiştirme
             
            String newContent = oldContent.replaceAll(kelime, degistir);
             
            //değiştirilmiş yeni içeriği dosyaya yazma
             
            writer = new FileWriter(string_dosya);
             
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Kaynakları kapatma
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
        
        System.out.println("Kelime veya kelimeler değiştirildi.");              
    }
    
    
//AŞAĞIDA KELİME BULMA VE DEĞİŞTİRME METODUNU, YAZIM HATALARINI DUZELTME METODUNUN İÇİNDE 
    //UYGUN BİR ŞEKİLDE KULLANABİLMEK İÇİN PARAMETRELİ BİR ŞEKİLDE POLİMORF ETTİK.
    public void kelimeBulDegistir(File f, String degisecek_kelime, String degistirilecek_kelime) throws FileNotFoundException, IOException{
        
        File file = f;
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String satir = reader.readLine();
                      
        File fileToBeModified =  file;
         
        String oldContent = "";
                
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
                                    
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
                        
            String newContent = oldContent.replaceAll(degisecek_kelime, degistirilecek_kelime); //Kelimeler arasındaki değişim işlemini yapma.
                                    
            writer = new FileWriter(f);
             
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //kaynakları kapat
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
                               
    }
    
//YAZIM HATASINI BULUP DUZELTEN METOT
    public void yazimHatasi() throws IOException{
        File file = new File("words.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String satir = reader.readLine();
           
        while(satir!=null){
                       
        StringTokenizer st = new StringTokenizer(satir," ");
               
        while(st.hasMoreTokens()){
                getWordsList().add(st.nextToken()); //word.txt dosyasını wordsList adlı arrayListe aktardık.
                       
        }
               
        satir=reader.readLine();
        }
                
        
        System.out.println("Kontrol edilmesi istenen txt dosyasının adını uzantısız bir şekilde giriniz:"); //Yazım hatalarını kontrol etmek istediğimiz dosyanın seçimi.
        String string_dosya=input.next()+".txt";
        file = new File(string_dosya);       
        reader = new BufferedReader(new FileReader(file));
        satir = reader.readLine();
        int dogru_sayac=0;
        int yanlis_sayac=0;
        
        while (satir!=null) {
                StringTokenizer st = new StringTokenizer(satir,".,;!?  ");
                
                while(st.hasMoreTokens()){
                    String siradaki_token=st.nextToken(); //tokenler üzerinde işlem yapma durumumuzdan dolayı her token önce değişkene atanıp elde tutulur.
                    
                    try{
                        //try sağlanıyorsa bir sayısal değerdir ve direk doğru kabul edebiliriz.
                        
                       int x = Integer.parseInt(siradaki_token); //sayısal degerlerin yazımını direk dogru kabul etme. (dönüşüm oluyorsa sayısal değerdir.)
                       dogru_sayac++;
                        
                    }
                    
                    catch(Exception e){ //try saglanmıyorsa, yani sayısal değer değilse kelimenin yazımının dogru mu yanlıs mı olduguna bakmaya baslarız.
                        
                        if(getWordsList().contains(siradaki_token)){ //token wordListte varsa yazımını direk doğru kabul edebiliriz.
                        dogru_sayac++;
                        
                        
                        }
                        
                        else{
                            
                        getYanlis_kelimeler().add(siradaki_token); //yazımı yanlış olan her kelimeyi  arrayliste atarız. Sonra bunların single transpositionlarını bulup kontrol edebilmek için.
                        yanlis_sayac++;
                        System.out.println(yanlis_sayac+". Yanlış Kelime: "+siradaki_token);
                        }
                    }
                
                }
                satir=reader.readLine();           	
                               
        }
        
        System.out.println("Yanlış Kelime Sayısı: "+getYanlis_kelimeler().size());
        
        //AŞAĞIDAKİ FOR DONGUSUNDE YAZIMI YANLIS OLAN HER KELİMENİN SINGLE TRANSPOSITIONLARI BULUNARAK, HER TRANSPOSITIONUN word.txt İÇERİSİNDE OLUP OLMADIINA BAKILIR.
        //EĞER words.txt İÇERİSİNDE TRANSPOSITIONLARDAN BIRI VARSA, TRANSPOSITIONIN SAHİBİ OLAN KELIME METIN ICERISINDE DOGRU OLAN YAZIM HALIYLE DEGISTIRILIR.        
        for(int i=0;i<getYanlis_kelimeler().size();i++){
        String kelime=getYanlis_kelimeler().get(i);
           
        int uzunluk=kelime.length();
        int sayac=0;
        int diger_sayac=0;
        
        char gecici = 0;
        char[] array= new char[kelime.length()]; //Kelimenin ilk halini tutan ve yeni kombinasyom oluşturmak için kelimenin transposition olan hallerini sıfırlayıp kendi değişime uğramayacak char listesi
        
        for(int r=0;r<array.length;r++){
            array[r]=kelime.charAt(r);
            
        }
        
        char [] reset_list= new char[array.length]; //Her defasında kelimenin ilk haline döndürüp transposition için kombinasyonları sağlama işlemi yapacağımız char listesi.
        
        for(int t=0;t<array.length;t++){
                  reset_list[t]=array[t]; //işlem yapılacak listeyi kelimenin ilk haline eşitledik.
              }
        
        String yeni_kelime="";
        
        //BURADAKI SAYACLAR KELIMENIN HARFLERI ARASINDAKI DEGISIME UYGUN OLACAK SEKILDE BUTUN SINGLE TRANSPOSITION (IKILI TAKASLARI) SAGLAYACAK SEKILDE AYARLANMISTIR.     
        while(sayac<uzunluk){
            diger_sayac=sayac+1;
            
            while(diger_sayac<uzunluk){
                
                                     
                gecici=array[sayac];
                reset_list[sayac]=array[diger_sayac];
                reset_list[diger_sayac]=gecici;
                
            for(int x=0;x<reset_list.length;x++){
                yeni_kelime+=reset_list[x];     //charları yer değişen kelimenin son halinin string bir şekilde oluşturulması
            }
             
            if(     getWordsList().contains(yeni_kelime)){  // oluşan transpositionlu kelime words.txtde var mı diye bakılır.
                
                 kelimeBulDegistir(file,kelime, yeni_kelime); //eğer var ise o transpositionun sahibi olan kelime sözlükteki doğru yazımı ile değiştirilir.
            }
            
             
              yeni_kelime="";               
                
            for(int t=0;t<array.length;t++){  //işlem yapılan reset_list kelimenin ilk haline döndürülerek sıradaki transposition işlemi için hazır hale getirilir.
                  reset_list[t]=array[t];
            }
                
            diger_sayac++;
             
             
            }
            
            sayac++;
        }
    
        }
        
         System.out.println("KELIMELER DOGRULARIYLA DEGISTIRILDI.");
         
    }
    
    //NOTEPADTEKİ TEXTI HARF HARF SILMEYI SAGLAYAN METOT
    public String harfSil(String text){
        String metin="";
        
        for(int i=0;i<text.length()-1;i++){
            metin+=text.charAt(i);
            
        }
        return metin;
    }

    /**
     * @return the wordsList
     */
    public ArrayList<String> getWordsList() {
        return wordsList;
    }

    /**
     * @param wordsList the wordsList to set
     */
    public void setWordsList(ArrayList<String> wordsList) {
        this.wordsList = wordsList;
    }

    /**
     * @return the yanlis_kelimeler
     */
    public ArrayList<String> getYanlis_kelimeler() {
        return yanlis_kelimeler;
    }

    /**
     * @param yanlis_kelimeler the yanlis_kelimeler to set
     */
    public void setYanlis_kelimeler(ArrayList<String> yanlis_kelimeler) {
        this.yanlis_kelimeler = yanlis_kelimeler;
    }
}
