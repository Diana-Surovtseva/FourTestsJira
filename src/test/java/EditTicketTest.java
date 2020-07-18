import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.TicketPage;
import utils.WebDriverFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.testng.Assert.assertTrue;

public class EditTicketTest {


    WebDriver driver = null;
    LoginPage loginPage = null;
    HomePage homePage = null;
    TicketPage ticketPage = null;


    @BeforeMethod
    public void setUp() {
        WebDriverFactory.createInstance("Chrome");
        driver = WebDriverFactory.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        ticketPage = new TicketPage(driver);
        homePage.navigateTo();
        loginPage.enterUserName("DianaSurovtseva");
        loginPage.setUserPassInput("DianaSurovtseva");
        loginPage.clickLogBut();
        homePage.clickViewIssue();
    }

    @Test
    public void addCommentToTicket() {

        ticketPage.openExistTicket();
        ticketPage.addComment();

        assertTrue(ticketPage.isCommentAdded());
    }

    @Test

    public void dellCommentFromTicket() {
        ticketPage.openExistTicket();
        String textLastComment = ticketPage.getLastComment();
        ticketPage.clickCommentDelButton();
        ticketPage.SubmitDelete();
        ticketPage.updateListComments();
     String textLastComment2 = ticketPage.getLastComment();

       assertTrue(!textLastComment2.contains(textLastComment));

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
