import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTest extends TestBase {
    @BeforeMethod
    public void preconditions(){

        if(isElement(By.cssSelector("[href='/login']"))){
            login("atest@gmail.com","Test_1234@");
        }

    }

    @Test
    public void logoutTest(){

        wd.findElement(By.cssSelector("button")).click();
        //sign out
    }
}
