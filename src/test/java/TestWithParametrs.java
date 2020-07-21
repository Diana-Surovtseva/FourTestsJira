import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestWithParametrs {

    @Parameters({"waitTimeOutInSeconds"})
    @Test
    public static void testWithParametrAnnotation(String waitTimeOutInSeconds){
        System.out.println("TimeOut: "+ waitTimeOutInSeconds);
    }

    @Test
    public static void testWithParametrInListener(){
    }
}
