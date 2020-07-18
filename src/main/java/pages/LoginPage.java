package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
