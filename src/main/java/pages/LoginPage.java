package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginPage {


    private WebDriver driver = null;
    private By userNameInput = (By.id("login-form-username"));
    private By userPassInput = (By.id("login-form-password"));
    private By loginButton = (By.id("login"));

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String name) {
        driver.findElement(userNameInput).sendKeys(name);
    }

    public void setUserPassInput(String passInput) {
        driver.findElement(userPassInput).sendKeys(passInput);
    }

    public void clickLogBut() {
        driver.findElement(loginButton).click();
    }
    public void navigateTo(){
        driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
    }
    public boolean errorMessageIsPresent(String message){
        return driver.findElement(By.xpath("//*[contains(text(),'" + message + "')]")).isDisplayed();
    }
    public void errorMessageIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(presenceOfElementLocated(By.id("usernameerror"))).isDisplayed();
    }
}
