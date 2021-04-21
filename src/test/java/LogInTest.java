import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LogInTest extends TestBase {
    @Test
    public void loginTest() {
        wd.findElement(By.linkText("LOGIN")).click();
        List<WebElement> inputs = wd.findElements(By.tagName("input"));
        fillByElement(inputs.get(0), "atest@gmail.com");
        fillByElement(inputs.get(1), "Test_1234@");

        pause(7000);

        List<WebElement> buttons = wd.findElements(By.tagName("button"));
        buttons.get(0).click();

        pause(1000);

        String text = wd.findElement(By.tagName("button")).getText();
        Assert.assertEquals(text, "Sign Out");

    }

    @Test
    public void loginTest2() {
        //wd.findElement(By.linkText("LOGIN")).click();
        wd.findElement(By.cssSelector("[href='/login']")).click();
        fillByLocator(By.cssSelector("input[placeholder='Email']"), "atest@gmail.com");
        fillByLocator(By.cssSelector("[placeholder='Password']"), "Test_1234@");


        wd.findElement(By.cssSelector("button:first-of-type")).click();


        String text = wd.findElement(By.tagName("button")).getText();
        Assert.assertEquals(text, "Sign Out");

    }
}
