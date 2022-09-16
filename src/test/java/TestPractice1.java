import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestPractice1 {

    @BeforeTest
    public void beforeTest() {
        System.out.println("TestPractice1:: Before Test ::");
    }

    @Test(dataProvider = "getData")
    public void firstTest(String userName, String password) {
        System.out.println("TestPractice1:: This is first test");
        System.out.println(userName);
        System.out.println(password);
    }

    @Test
    public void aTest() {
        System.out.println("TestPractice1:: aTest()");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("TestPractice1:: After Test ::");
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[3][2];

        data[0][0] = "first-username";
        data[0][1] = "first-password";

        data[1][0] = "second-username";
        data[1][1] = "second-password";

        data[2][0] = "third-username";
        data[2][1] = "third-password";

        return data;
    }
}
