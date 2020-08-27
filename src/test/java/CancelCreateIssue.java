import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateNewTicketWindow;
import pages.HomePage;
import pages.LoginPage;
import pages.TicketPage;
import utils.WebDriverFactory;

import static org.testng.Assert.assertTrue;

public class CancelCreateIssue {
    HomePage homePage = null;
    LoginPage loginPage = null;
    TicketPage ticketPage = null;
    CreateNewTicketWindow createNewTicketWindow = null;

    @BeforeMethod
    public void setUp() {
        WebDriverFactory.createInstance("Chrome");
        homePage = new HomePage(WebDriverFactory.getDriver());
        loginPage = new LoginPage(WebDriverFactory.getDriver());
        ticketPage = new TicketPage(WebDriverFactory.getDriver());
        createNewTicketWindow = new CreateNewTicketWindow(WebDriverFactory.getDriver());
        homePage.navigateTo();
        loginPage.enterUserName("DianaSurovtseva");
        loginPage.setUserPassInput("DianaSurovtseva");
        loginPage.clickLogBut();
    }

    @Test
    public void cancelCreateIssueTest() {
        homePage.isButtonCreateLinkPresent();
        homePage.clickCreateIssue();

        createNewTicketWindow.isSummaryFieldDisplayed();
        createNewTicketWindow.enterSummary("Test summary");
        createNewTicketWindow.pressCancelButton();
        createNewTicketWindow.acceptPopUpWindow();
        assertTrue(homePage.isCreateIssueWindowNotPresent());
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.getDriver().quit();
    }

}