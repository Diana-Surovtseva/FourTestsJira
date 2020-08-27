
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.TicketPage;
import utils.WebDriverFactory;


import static org.testng.Assert.assertTrue;

public class ViewTicketTest {

    WebDriver driver = null;
    HomePage homePage = null;
    LoginPage loginPage = null;
    TicketPage ticketPage = null;

    @BeforeMethod
    public void setUp() {
        WebDriverFactory.createInstance("Chrome");
        driver = WebDriverFactory.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        ticketPage = new TicketPage(driver);
    }

    @Test
    public void viewTicket() {
        homePage.navigateTo();
        loginPage.enterUserName("DianaSurovtseva");
        loginPage.setUserPassInput("DianaSurovtseva");
        loginPage.clickLogBut();
        homePage.clickViewIssue();

        assertTrue(ticketPage.sumIsPresent());

        assertTrue(ticketPage.urlContains());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
