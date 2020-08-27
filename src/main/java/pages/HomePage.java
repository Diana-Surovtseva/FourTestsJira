package pages;

import org.openqa.selenium.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;


public class HomePage {
    private WebDriver driver = null;
    private By viewIssue = By.xpath("//*[@data-issue-key='WEBINAR-11962']");

    private By toolBar = By.xpath("//*[@class='ops-menus aui-toolbar2']");
    private By createIssueButton = By.id("create_link");
    private By createIssueTitle = By.xpath("//*[h2]//*[@title='Создание задачи']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
    }

    public boolean userIconIsPresent() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(presenceOfElementLocated(By.id("header-details-user-fullname"))).isDisplayed();
    }

    public void clickViewIssue() {

        clickOnElementWithRetry(viewIssue, toolBar, 3, 3);

    }


    private void clickOnElementWithRetry(By elementToBeClicked, By successCriteriaElement, int attempts, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        for (int i = 0; i < attempts; i++) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(successCriteriaElement)).isDisplayed();
                break;
            } catch (TimeoutException e) {
                wait.until(ExpectedConditions.elementToBeClickable(elementToBeClicked));
                driver.findElement(elementToBeClicked).click();
            }
        }
    }

    public WebElement issueIsPresent() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(elementToBeClickable(By.xpath("//*[@data-issue-key='BAK-40']"))).isEnabled();
        return driver.findElement(By.xpath("//*[@data-issue-key='BAK-40']"));
    }

    public boolean isButtonCreateLinkPresent() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(elementToBeClickable(By.id("create_link"))).isDisplayed();
    }

    public void clickCreateIssue() {
        clickOnElementWithRetry(createIssueButton, createIssueTitle, 3, 3);
    }

    public boolean isCreateIssueWindowNotPresent() {
        return ExpectedConditions.invisibilityOfElementLocated(createIssueTitle).apply(WebDriverFactory.getDriver());
    }

}