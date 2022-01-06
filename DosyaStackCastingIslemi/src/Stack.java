

public class Stack {
    int topOfStack;
    int capacity;
    Employee[] dizi;

    public Stack(int capacity) { 
        this.capacity=capacity;
        dizi = new Employee[capacity];
        topOfStack=-1;
    }
    
   public void push(Employee element){ //stacke eleman ekler.
       if(isFull()){
           System.out.println("STACK DOLU!");
           
       }
       else{
           topOfStack++;
           dizi[topOfStack]=element;
           System.out.println(element.toString()+"\n----------EKLENDI--------------"); //EKLENEN HER ELEMANIN BILGILERINI YAZDIRMA.
       }
   }
   public Employee pop(){ // stackten en üstteki elemanı alır.
       if(isEmpty()){
           System.out.println("STACK BOŞ!");
           return null;
       }
       else{
           Employee element = dizi[topOfStack];
           topOfStack--;
           return element;
       }
   }
   public boolean isFull(){ // stack dolu mu diye kontrol eder.
       return (topOfStack==capacity-1);
       
   }
   public boolean isEmpty(){ //Stack boş mu diye kontrol eder.
       return (topOfStack<0);
   }
   
    
    

}