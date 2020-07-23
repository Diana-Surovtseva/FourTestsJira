import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

public class TestWithParametrs {

//    @Parameters({"waitTimeOutInSeconds"})
//    @Test
//    public static void testWithParametrAnnotation(String waitTimeOutInSeconds){
//        System.out.println("TimeOut: "+ waitTimeOutInSeconds);
//    }
//
//    @Test
//    public static void testWithParametrInListener(){
//    }

    @Parameters({"browserName"})
    @Test
    public static void testBrowserWithParametrAnnotation(String browserName){
        WebDriverFactory.createInstance(browserName);
        System.out.println("Browser name for this test is: "+ browserName);
    }
}
