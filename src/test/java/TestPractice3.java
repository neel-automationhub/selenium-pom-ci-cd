import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPractice3 {

    @BeforeTest
    public void beforeTest() {
        System.out.println("TestPractice3:: Before Test ::");
    }

    @Parameters({"url"})
    @Test
    public void firstTest(String url) {
        System.out.println("TestPractice3:: This is first test :: "+ url);
    }

    @Test
    public void secondTest() {
        System.out.println("TestPractice3:: This is second test");
    }

    @Test(groups = {"smoke"})
    public void thirdTest() {
        System.out.println("TestPractice3:: This is third test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("TestPractice3:: After Test ::");
    }

}
