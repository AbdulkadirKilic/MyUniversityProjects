


public class Circle implements Shape{
    private double radius;

   public Circle(){
       radius=0;
   }
   public Circle(double radius){
       this.radius=radius;
   }
   public String toString(){
       return  "Circle, radius= "+getRadius();
   }

    @Override
    public double cevreHesapla() {
        return 2 * Math.PI * getRadius();
    }

    @Override
    public double alanHesapla() {
        return Math.PI * getRadius() * getRadius();
    }

    /**
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
   
    
}
