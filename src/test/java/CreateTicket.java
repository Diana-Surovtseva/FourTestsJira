
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateNewTicketWindow;
import pages.HomePage;
import pages.LoginPage;
import pages.TicketPage;
import utils.WebDriverFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateTicket {

    WebDriver driver = null;
    //WebDriverWait wait;
    HomePage homePage = null;
    LoginPage loginPage = null;
    TicketPage ticketPage = null;
    CreateNewTicketWindow createNewTicketWindow = null;

    @BeforeMethod
    public void setUp() {
        WebDriverFactory.createInstance("Chrome");
        driver = WebDriverFactory.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        ticketPage = new TicketPage(driver);
        createNewTicketWindow = new CreateNewTicketWindow(driver);
        homePage.navigateTo();
        loginPage.enterUserName("DianaSurovtseva");
        loginPage.setUserPassInput("DianaSurovtseva");
        loginPage.clickLogBut();
    }


    @Test

    public void createTicket() {

        homePage.isButtonCreateLinkPresent();
        homePage.clickCreateIssue();
        createNewTicketWindow.isProjectFieldDisplayed();
        createNewTicketWindow.clearProjectField();
        createNewTicketWindow.inputProjectField("Webinar (WEBINAR)");
        createNewTicketWindow.pressTabAfterProjectField();

        createNewTicketWindow.isIssueTypeFieldDisplayed();
        createNewTicketWindow.clearIssueTypeField();
        createNewTicketWindow.enterIssueTypeField("Task");
        createNewTicketWindow.pressTabAfterIssueTypeField();

        createNewTicketWindow.isSummaryFieldDisplayed();
        createNewTicketWindow.enterSummary("Test task");
        createNewTicketWindow.clearReporterField();
        createNewTicketWindow.enterReporterField("DianaSurovtseva");

        createNewTicketWindow.pressCreateIssueButton();

        assertTrue(createNewTicketWindow.isPopUpPresent());
        assertTrue(createNewTicketWindow.getPopUpText().contains("WEBINAR"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
