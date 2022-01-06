


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;



public class Main {
    
    public static void main(String[] args) throws IOException,FileNotFoundException {
        int stack_size=0;
        
        
      
        File file = new File("bilgiler.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String satir = reader.readLine();
 
       
        
        
        while(satir!=null){ // Dosyada kaç tane nesne olduğunu hesaplar.
            stack_size++;
            
            satir=reader.readLine();
        }
       
        Stack yigit = new Stack(stack_size); //Stack boyutunu hesaba göre atadık. Amaç her dosyaya uygun olsun diye.
        
        reader.close(); // readerı durdurduk
        
        
        reader = new BufferedReader(new FileReader(file)); // dosyayı baştan okumaya başladık
        satir = reader.readLine();
        
        
        
        while(satir!=null){
            StringTokenizer st = new StringTokenizer(satir," ");
            String ilk=st.nextToken();
            if(ilk.equalsIgnoreCase("piece")){
             
                Employee calisan = new PieceWorker();
                calisan.setAd(st.nextToken());
                calisan.setSoyad(st.nextToken());
                calisan.setTcKimlikNo(st.nextToken());
                
                int x= Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                
                ((PieceWorker) calisan).setProducedPieces(x);
                ((PieceWorker) calisan).setMoneyPerPiece(y);
                yigit.push(calisan);
            
            
        }
                   
            
            else if(ilk.equalsIgnoreCase("hourly")){
                
                Employee calisan = new HourlyEmployee();
                calisan.setAd(st.nextToken());
                calisan.setSoyad(st.nextToken());
                calisan.setTcKimlikNo(st.nextToken());
                
                int x= Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                ((HourlyEmployee) calisan).setWorkHours(x);
                ((HourlyEmployee) calisan).setWage(y);
                
                yigit.push(calisan);                
                
            }
            
            satir = reader.readLine();
                 
         
        }
        
        System.out.println("ÇIKAN \n"+yigit.pop());
        
        System.out.println();
        System.out.println("YIGIT YAZDIRILIYOR...");
        
        for(int i=yigit.topOfStack;i>=0;i--){
            System.out.println(yigit.dizi[i]);
            System.out.println();
        }
    }  
        
        
}
        
       
        
         
        
             
    
        
    
    
    
    

