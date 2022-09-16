import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPractice2 {

    @BeforeTest
    public void beforeTest() {
        System.out.println("TestPractice2:: Before Test ::");
    }

    @Test(enabled = false)
    public void firstTest() {
        System.out.println("TestPractice2:: This is first test");
    }

    @Test
    public void secondTest() {
        System.out.println("TestPractice2:: This is second test");
    }

    @Test
    public void thirdTest() {
        System.out.println("TestPractice2:: This is third test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("TestPractice2:: After Test ::");
    }

}
