import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditContactTest extends TestBase{
    @BeforeMethod
    public void preconditions() {
        if (isElement(By.cssSelector("[href='/login']"))) {
            login("atest@gmail.com", "Test_1234@");
        }

    }
    @Test
    public void editTest(){
        wd.findElement(By.xpath("//a[text()='CONTACTS']")).click();
        wd.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
        //pause(500);
        wd.findElement(By.xpath("//button[text()='Edit']")).click();
        String text = wd.findElement(By.xpath("//input[@placeholder='Name']")).getText();

        String txt = wd.findElement(By.xpath("//input[@placeholder='Name']")).getAttribute("value");
        System.out.println(txt);

        fillByLocator(By.xpath("//input[@placeholder='Name']"),txt+"*");
        //pause(500);
        //=========================================================================
        wd.findElement(By.xpath("//input[@placeholder='Last Name']")).click();
        String text1 = wd.findElement(By.xpath("//input[@placeholder='Last Name']")).getText();

        String txt1 = wd.findElement(By.xpath("//input[@placeholder='Last Name']")).getAttribute("value");
        System.out.println(txt1);

        fillByLocator(By.xpath("//input[@placeholder='Last Name']"),txt1+"*");
        //==========================================================================
        wd.findElement(By.xpath("//input[@placeholder='Phone']")).click();
        String text2 = wd.findElement(By.xpath("//input[@placeholder='Phone']")).getText();

        String txt2 = wd.findElement(By.xpath("//input[@placeholder='Phone']")).getAttribute("value");
        System.out.println(txt2);

        fillByLocator(By.xpath("//input[@placeholder='Phone']"),txt2+"*");
        //==========================================================================
        wd.findElement(By.xpath("//input[@placeholder='email']")).click();
        String text3 = wd.findElement(By.xpath("//input[@placeholder='email']")).getText();

        String txt3 = wd.findElement(By.xpath("//input[@placeholder='email']")).getAttribute("value");
        System.out.println(txt3);

        fillByLocator(By.xpath("//input[@placeholder='email']"),txt3+"*");
        //==========================================================================
        wd.findElement(By.xpath("//input[@placeholder='Address']")).click();
        String text4 = wd.findElement(By.xpath("//input[@placeholder='Address']")).getText();

        String txt4 = wd.findElement(By.xpath("//input[@placeholder='Address']")).getAttribute("value");
        System.out.println(txt4);

        fillByLocator(By.xpath("//input[@placeholder='Address']"),txt4+"*");
        //=========================================================================
//        wd.findElement(By.xpath("//input[@placeholder='desc']")).click();
//        String text5 = wd.findElement(By.xpath("//input[@placeholder='desc']")).getText();
//
//        String txt5 = wd.findElement(By.xpath("//input[@placeholder='desc']")).getAttribute("value");
//        System.out.println(txt5);
//
//        fillByLocator(By.xpath("//input[@placeholder='desc']"),txt5+"*");
//                                  ?[object Undefined]?
        wd.findElement(By.xpath("//button[.='Save']")).click();
    }

}
