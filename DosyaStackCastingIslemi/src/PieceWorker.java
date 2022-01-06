


public class PieceWorker extends Employee {
    
    private int producedPieces; 
    private int moneyPerPiece; 
    
    
    public PieceWorker(){
        producedPieces=0;
        moneyPerPiece=0;
    
    }
    public PieceWorker(String Ad,String Soyad,String TcKimlikNo, int producedPieces,int moneyPerpiece){
        super(Ad, Soyad, TcKimlikNo);
        this.producedPieces=producedPieces;
        this.moneyPerPiece=moneyPerpiece;
    }
    
    //getler setler
    /**
     * @return the producedPieces
     */
    public int getProducedPieces() {
        return producedPieces;
    }

    /**
     * @param producedPieces the producedPieces to set
     */
    public void setProducedPieces(int producedPieces) {
        this.producedPieces = producedPieces;
    }

    /**
     * @return the moneyPerPiece
     */
    public int getMoneyPerPiece() {
        return moneyPerPiece;
    }

    /**
     * @param moneyPerPiece the moneyPerPiece to set
     */
    public void setMoneyPerPiece(int moneyPerPiece) {
        this.moneyPerPiece = moneyPerPiece;
    }
    //toString() metodu
    public String toString(){
        return ("Ad Soyad: "+getAd()+" "+getSoyad()+"\nTC: "+getTcKimlikNo()+"\nParca sayisi: "+getProducedPieces()+"\nBirim ücret: "+getMoneyPerPiece()+"\nMaas: "+maasAl());
    
    }
    
    @Override
    public double maasAl() {
        return getProducedPieces()*getMoneyPerPiece(); 
    }
}
