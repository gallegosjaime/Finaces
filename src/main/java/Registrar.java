
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

public class Registrar{
    WebDriverWait wait;
    @FindBy(xpath = "//a[@href='/register']")
    WebElement registrar;
    @FindBy(name = "first_name")
    WebElement FirstName;
    @FindBy(name = "last_name")
    WebElement LasttName;
    @FindBy(name = "username")
    WebElement Username;
    @FindBy(name = "email")
    WebElement Email;
    @FindBy(name = "password")
    WebElement Password;
    @FindBy(name = "repeat_password")
    WebElement RepeatPassword;
    @FindBy(name = "phone")
    WebElement Phone;
    @FindBy(name = "birthdate")
    WebElement Birthdate;
    @FindBy(name = "cc")
    WebElement Cc;
    @FindBy(name = "expiration")
    WebElement Expiration;
    @FindBy(name = "cvv")
    WebElement Cvv;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;
    @FindBy(className = "alert")
    WebElement alert;
    public void paginaRegistrar(){
        registrar.click();
    }
    public void registrar(String firstName, String lastName, String username, String email, String password, String phone, String birthdate, String cc, String expiration, String cvv){
        validarVisibilidad(FirstName);
        FirstName.sendKeys(firstName);
        LasttName.sendKeys(lastName);
        Username.sendKeys(username);
        Email.sendKeys(email);
        Password.sendKeys(password);
        RepeatPassword.sendKeys(password);
        Phone.sendKeys(phone);
        Birthdate.sendKeys(birthdate);
        Cc.sendKeys(cc);
        Expiration.sendKeys(expiration);
        Cvv.sendKeys(cvv);
        submit.click();
        validarVisibilidad(alert);
        assertEquals(alert.getText(),username+" was succesfully registered.");
    }
    public void setWait(WebDriverWait Wait){
        wait = Wait;
    }
    public void validarVisibilidad(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
