import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class AddContactTest extends TestBase {

    @BeforeMethod
    public void preconditions() {
        if (isElement(By.cssSelector("[href='/login']"))) {
            login("atest@gmail.com", "Test_1234@");
        }

    }

    @Test(invocationCount = 3)
    public void addContact() {
        int index = (int) ((System.currentTimeMillis() / 1000) % 3600);
        wd.findElement(By.cssSelector("[href='/add']")).click();
        fillByLocator(By.cssSelector("[placeholder='Name']"), "Lola" + index);
        fillByLocator(By.cssSelector("[placeholder='Last Name']"), "Now" + index);
        fillByLocator(By.cssSelector("[placeholder='Phone']"), "9876" + index);
        fillByLocator(By.cssSelector("[placeholder='email']"), "Lola" + index + "@gmail.ru");
        fillByLocator(By.cssSelector("[placeholder='Address']"), "Haifa" + index);
        fillByLocator(By.cssSelector("[placeholder='description']"), "University");

        wd.findElement(By.cssSelector(".add_form__2rsm2 button")).click();
        pause(1500);


    }

    @AfterMethod
    public void postconditions() {
        wd.findElement(By.cssSelector("button")).click();

    }
}
