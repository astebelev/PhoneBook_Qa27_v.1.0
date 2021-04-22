import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeSuite
    public void init(){
        wd=new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
    }

    @AfterSuite(enabled = false)
    public void tearDown (){
        wd.quit();

    }
    public void fillByElement(WebElement element, String text){
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void fillByLocator(By locator, String text){
        WebElement element= wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);

    }

    public boolean isElement(By locator){
        return wd.findElements(locator).size()>0;
    }


    public void pause(int millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void login(String email, String password){
        wd.findElement(By.cssSelector("[href='/login']")).click();
        fillByLocator(By.cssSelector("input[placeholder='Email']"), email);
        fillByLocator(By.cssSelector("[placeholder='Password']"), password);
        wd.findElement(By.cssSelector("button:first-of-type")).click();
    }
    public void openLogRegForm(){
        wd.findElement(By.xpath("//a[.='LOGIN']")).click();
    }
    public void clickLoginButton(){
        wd.findElement(By.xpath("//button[.=' Login']")).click();
    }
    public void fillLogRegForm(User user){
        fillByLocator(By.xpath("//input[@placeholder='Email']"), user.getEmail());
        fillByLocator(By.xpath("//input[@placeholder='Password']"), user.getPassword());
    }
    public String takeText(By locator){
        return wd.findElement(locator).getText();

    }
    public String takeText(WebElement element){
        return element.getText();
    }
    public boolean isloggin(){
        return isElement(By.xpath("//button[.='Sign Out']"));
    }
    public void openContactForm(){
        wd.findElement(By.xpath("//a[@href='/add']")).click();

    }
    public void fillContactForm(Contact contact){
        fillByLocator(By.xpath("//input[@placeholder='Name']"),contact.getName());
        fillByLocator(By.cssSelector("[placeholder='Last Name']"),contact.getLastName());
        fillByLocator(By.cssSelector("[placeholder='Phone']"),contact.getPhone());
        fillByLocator(By.cssSelector("[placeholder='email']"),contact.getPhone());
        fillByLocator(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        fillByLocator(By.cssSelector("[placeholder='description']"), contact.getDescription());

    }
    public void saveNewContact(){
        wd.findElement(By.xpath("//button/b[text()='Save']")).click();
    }
}