package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class TicketPage {

    private WebDriver driver = null;
    private By viewIssue = By.xpath("//*[@data-issue-key='WEBINAR-11962']");
    private By footerFieldComment = By.id("footer-comment-button");
    private By newComment = By.xpath("//*[@id='issue_actions_container']//child::*[@class='issue-data-block activity-comment twixi-block  expanded focused']//child::*[@class='action-body flooded']");
    private By lastComment = By.id("issue_actions_container");
    WebDriverWait wait;
    private String currCommentText;
    //private By commentArea = By.id("comment");
    //private String myComment = "My comment";

    public TicketPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public boolean sumIsPresent() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(presenceOfElementLocated(By.id("summary-val"))).isDisplayed();
    }

    public boolean urlContains() {
        return driver.getCurrentUrl().contains("WEBINAR-11962");
    }

    public void openExistTicket() {
        clickOnElementWithRetry(viewIssue, footerFieldComment, 3, 3);
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

    public void addComment() {
        driver.findElement(footerFieldComment).click();
        driver.findElement(By.id("comment")).sendKeys("My comment");
        driver.findElement(By.id("issue-comment-add-submit")).click();
    }

    private String getTextFromElementWithRetry(By elementIsDisplayed, By successCriteriaElement, int attempts, int timeOutInSeconds) {
        String resultString = "";
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        for (int i = 0; i < attempts; i++) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(successCriteriaElement)).isDisplayed();
                break;
            } catch (TimeoutException e) {
                wait.until(ExpectedConditions.presenceOfElementLocated(elementIsDisplayed));
            }
        }
        resultString = driver.findElement(elementIsDisplayed).getText();
        return resultString;
    }

    public boolean isCommentAdded() {
        String commentText = getTextFromElementWithRetry(newComment, newComment, 3, 3);
        return commentText.contains("My comment");
    }

    public String getLastComment() {
        wait.until(elementToBeClickable(By.id("issue_actions_container"))).isEnabled();
        WebElement LastComment = driver.findElement(By.xpath("//*[@class='issue-data-block activity-comment twixi-block  expanded'][last()]//child::*[@class='action-body flooded']")
        );
        return LastComment.getText();
    }

    public void clickCommentDelButton() {

        WebElement elementList = driver.findElement(By.xpath("//*[@class='issue-data-block activity-comment twixi-block  expanded'][last()]//child::*[@title='Delete']"));
        elementList.click();
    }

    public void SubmitDelete() {
        wait.until(elementToBeClickable(By.id("comment-delete-submit"))).isEnabled();
        driver.findElement(By.id("comment-delete-submit")).click();
    }

    public void updateListComments() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
