import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

public class vender {
    WebDriverWait wait;
    @FindBy (css="[href='/sell']")
    WebElement paginavender;
    @FindBy (css="[value='AMZN']")
    WebElement opcion;
    @FindBy (name="qty")
    WebElement cantidad;
    @FindBy (css="[type='submit']")
    WebElement vender;
    @FindBy(className = "alert")
    WebElement alert;

    public void setWait(WebDriverWait Wait){
        wait = Wait;
    }
    public void vender(String ingresarCantidad){
        paginavender.click();
        validarVisibilidad(cantidad);
        cantidad.sendKeys(ingresarCantidad);
        vender.click();
        validarVisibilidad(alert);
        assertEquals(alert.getText(),"You sold "+ingresarCantidad+" share(s) from AMZN");
    }

    public void validarVisibilidad(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}


