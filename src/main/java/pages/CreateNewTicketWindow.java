package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class CreateNewTicketWindow {
    private WebDriver driver = null;

    private By projectField = By.id("project-field");
    private By issueTypeField = By.id("issuetype-field");
    private By summaryField = By.id("summary");
    private By reporterField = By.id("reporter-field");
    private By createIssueButton = By.id("create-issue-submit");
    private By auiFlagContainer = By.id("aui-flag-container");

    public CreateNewTicketWindow(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProjectFieldDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.elementToBeClickable(projectField)).isDisplayed();
    }

    public void clearProjectField() {
        driver.findElement(projectField).clear();
    }

    public void inputProjectField(String text) {
        driver.findElement(projectField).sendKeys(text);
    }

    public void pressTabAfterProjectField() {
        driver.findElement(projectField).sendKeys(Keys.TAB);
    }

    public boolean isIssueTypeFieldDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(issueTypeField)).isDisplayed();
    }

    public void clearIssueTypeField() {
        driver.findElement(issueTypeField).clear();
    }

    public void enterIssueTypeField(String text) {
        driver.findElement(issueTypeField).sendKeys(text);
    }

    public void pressTabAfterIssueTypeField() {
        driver.findElement(issueTypeField).sendKeys(Keys.TAB);
    }

    public boolean isSummaryFieldDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(summaryField)).isDisplayed();
    }

    public void enterSummary(String text) {
        driver.findElement(summaryField).sendKeys(text);
    }

    public void clearReporterField() {
        driver.findElement(reporterField).clear();
    }

    public void enterReporterField(String text) {
        driver.findElement(reporterField).sendKeys(text);
    }

    public void pressCreateIssueButton() {
        driver.findElement(createIssueButton).click();
    }

    public boolean isPopUpPresent() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(presenceOfElementLocated(auiFlagContainer)).isDisplayed();
    }

    public String getPopUpText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String popUpText = wait.until(presenceOfElementLocated(auiFlagContainer)).getText();
        return popUpText;
    }
    public void pressCancelButton(){
        driver.findElement(By.xpath("//*[@class='buttons']//*[@class='cancel']")).click();
    }
    public void acceptPopUpWindow(){
        driver.switchTo().alert().accept();
    }

}


