


public class Rectangle implements Shape{
    private double height;
    private double width;
    
    
    public Rectangle(){
        height=0;
        width=0;
    }
    
    public Rectangle(double height, double width){
        this.height=height;
        this.width=width;
    }
    
    public String toString(){
       return  "Rectangle, height= "+getHeight()+" width= "+getWidth();
   }

    @Override
    public double cevreHesapla() {
        return 2*(getHeight()+getWidth());
    }

    @Override
    public double alanHesapla() {
        return getHeight()*getWidth();
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }
    
    
    
}
