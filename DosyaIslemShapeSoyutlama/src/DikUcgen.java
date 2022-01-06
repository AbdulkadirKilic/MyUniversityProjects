


public class DikUcgen implements Shape{
    private double a;
    private double b;
    private double c;
    
    public DikUcgen(){
        a=0;
        b=0;
        c=0;
    }
    
    public DikUcgen(double a, double b){
        this.a= a;
        this.b= b;
        this.c= Math.sqrt((a*a)+(b*b));
    }
    void tangentValues(){
        System.out.println("Tanjant değerleri: a/b= "+getA()/getB()+" b/a= "+getB()/getA());
    }
    
    public String toString(){
       return   "DikUcgen, a= "+getA()+" b= "+getB()+" c= "+getC();
   }

    @Override
    public double cevreHesapla() {
        return getA()+getB()+getC();
    }

    @Override
    public double alanHesapla() {
        return (getA()*getB())/2;
    }

    /**
     * @return the a
     */
    public double getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public double getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(double b) {
        this.b = b;
    }

    /**
     * @return the c
     */
    public double getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(double c) {
        this.c = c;
    }
    
    
    
}
