import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest{
    protected WebDriver driver;
    protected Registrar registrar;
    protected Login login;
    protected Compra compra;
    protected WebDriverWait wait;
    protected vender Vender;

    @Before
    public void beforeTest(){
        //instancias
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        registrar = new Registrar();
        login = new Login();
        compra = new Compra();
        Vender = new vender();

        //Pagina inicial
        driver.get("https://vamonos-finance.herokuapp.com/login");

        //inicializar elementos como el findby
        PageFactory.initElements(driver,registrar);
        PageFactory.initElements(driver,login);
        PageFactory.initElements(driver,compra);
        PageFactory.initElements(driver, Vender);

        //Inicializar esperas
        registrar.setWait(wait);
        login.setWait(wait);
        compra.setWait(wait);
        Vender.setWait(wait);
    }
    @After
    public void closeTest(){
        driver.close();
    }
}
