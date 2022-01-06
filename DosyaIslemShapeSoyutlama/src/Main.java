

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
        Shape[] shapes = new Shape[5];
        
        File file = new File("girdi.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String satir = reader.readLine();
        Shape nesne=null;
        
        
        int sayac=0;
        

            while (satir!=null) {
                StringTokenizer st = new StringTokenizer(satir," ");
                String ilk=st.nextToken(); //ilk token hangi shape oldugun anlamak için alındı.
                
            	
                //Şekle göre tokenlar double'a çevirildi ve uygun nesneler yaratıldı.
                
               if (ilk.equals("Circle")){
                   double x=Double.parseDouble(st.nextToken());
                    nesne = new Circle(x);
                   
               }
                
               else if (ilk.equals("Rectangle")){
                   double x=Double.parseDouble(st.nextToken());
                   double y=Double.parseDouble(st.nextToken());
                    nesne = new Rectangle(x,y);
                   
               }
               else if (ilk.equals("DikUcgen")){
                   double x=Double.parseDouble(st.nextToken());
                   double y=Double.parseDouble(st.nextToken());
                    nesne = new DikUcgen(x,y);
                   
               }
               
               shapes[sayac]=  nesne; //her nesne listeye eklendi.
               sayac++;
                

                
                satir=reader.readLine();
                            
            }
            
            for(int i=0;i<shapes.length;i++){
                System.out.println(shapes[i].toString()+" Alan= "+shapes[i].alanHesapla()+" Cevre= "+shapes[i].cevreHesapla());
                
                if(shapes[i] instanceof DikUcgen) {      //Nesne tipi kontrolü            
                  ((DikUcgen) shapes[i]).tangentValues();
                }
                System.out.println("------------------------------");
                
                
                
            }
            
        
        
        
        
        
        
        
    }
    
}
