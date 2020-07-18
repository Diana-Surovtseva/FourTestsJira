import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {

    WebDriver driver = null;
    LoginPage loginPage = null;
    HomePage homePage = null;

    @BeforeMethod
    public void setUp() {
        WebDriverFactory.createInstance("Chrome");
        driver = WebDriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

        @Test
        public void successfulLoginTest () {
            homePage.navigateTo();
            loginPage.enterUserName("DianaSurovtseva");
            loginPage.setUserPassInput("DianaSurovtseva");
            loginPage.clickLogBut();


            assertTrue(homePage.userIconIsPresent());
        }

        @Test
        public void failedTest () {
            homePage.navigateTo();
            assertEquals(1, 2);
        }

        @AfterMethod
        public void tearDown () {
            driver.quit();
        }
    }
