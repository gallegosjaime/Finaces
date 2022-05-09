import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

public class Login {
    WebDriverWait wait;
    @FindBy(name = "username")
    WebElement username;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(css = "[type='submit']")
    WebElement login;
    @FindBy(className = "alert")
    WebElement alert;

    public void setWait(WebDriverWait Wait){
        wait = Wait;
    }

    public void login(String usernametxt, String passwordtxt){
        validarVisibilidad(username);
        username.sendKeys(usernametxt);
        password.sendKeys(passwordtxt);
        login.click();
        validarVisibilidad(alert);
        assertEquals(alert.getText(), "Welcome back "+usernametxt);
    }

    public void validarVisibilidad(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}

