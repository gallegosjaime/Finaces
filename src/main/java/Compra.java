import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

public class Compra {
    WebDriverWait wait;
    @FindBy(css = "[href='/buy']")
    WebElement paginaComprar;
    @FindBy(name = "symbol")
    WebElement simboloInp;
    @FindBy(name = "qty")
    WebElement cantidadInp;
    @FindBy(css = "[type='submit']")
    WebElement botoncomprar;
    @FindBy(className = "alert")
    WebElement alert;

    public void setWait(WebDriverWait Wait){
        wait = Wait;
    }
    public void comprar(String simbolo, String cantidad){
        paginaComprar.click();
        validarVisibilidad(simboloInp);
        simboloInp.sendKeys(simbolo);
        cantidadInp.sendKeys(cantidad);
        botoncomprar.click();
        validarVisibilidad(alert);
        assertEquals(alert.getText(),"You bought 1 share(s) from "+simbolo);
    }


    public void validarVisibilidad(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
