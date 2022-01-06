import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import  static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.NoSuchElementException;





public class MenuTest {
    
    public MenuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

  
    //AŞAGIDA METOTLARIN TESTLERI YAZILMISTIR. 
    @Test
    public void testDosyaAc() {
        Menu menu = new Menu();
        assertThrows(RuntimeException.class, ()-> menu.dosyaAc()); //Run timeda oluşan exceptionların  throw edilip edilmediğini test ediyoruz.
                                                            
    }
    
    @Test
    public void testDosyaOlustur(){
        Menu menu = new Menu();
        assertThrows(NoSuchElementException.class, ()-> menu.dosyaOlustur("anytext")); //Biraz daha spesifik olarak Runtimeda gerçekleşen NoSuchElementException istisnasının throw edilip edilmediğini test ediyoruz.
        
    }
    @Test
    public void testKelimeBulDegistir(){
        Menu menu = new Menu();
        assertThrows(NoSuchElementException.class, ()-> menu.kelimeBulDegistir()); // NoSuchElementException istisnasının throw edilip edilmediği
        
    }
       
    @Test
    public void testYazimHatasi(){
        Menu menu = new Menu();
        assertThrows(NoSuchElementException.class,()-> menu.yazimHatasi()); // NoSuchElementException istisnasının throw edilip edilmediği
    }
    @Test
    public void testHarfSil(){
        Menu menu = new Menu();
        String text="anytext";
        String expected="anytex";
        assertEquals(menu.harfSil(text),expected); //Metodun sonucu beklenen sonuca eşit mi diye test ediliyor.
    }

   
    
}
