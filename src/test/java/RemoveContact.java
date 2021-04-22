import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class RemoveContact extends TestBase{

    @BeforeMethod
    public void preconditions(){
        if(isElement(By.cssSelector("[href='/login']"))){
            login("Mona447233@mail.com","Mona12$447233");
        }
    }
    @Test
    public void removeOneContact(){
        wd.findElement(By.cssSelector("[href='/contacts']")).click();
        WebElement contact= wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
        contact.click();
        WebElement removeBtn= wd.findElement(By.cssSelector(".contact-item-detailed_card__50dTS button:last-of-type"));
        removeBtn.click();

    }

    @Test
    public void removeAllContact(){
        wd.findElement(By.cssSelector("[href='/contacts']")).click();
        List<WebElement> contacts =wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));

//        System.out.println(contacts.size());
//        for (WebElement el:contacts) {
//            el.click();
//            wd.findElement(By.cssSelector(".contact-item-detailed_card__50dTS button:last-of-type")).click();
//        }
        int size=contacts.size();
        for (int i = 0; i < size; i++) {
            WebElement contact= wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
            contact.click();
            pause(500);
            WebElement removeBtn= wd.findElement(By.xpath("//button[.='Remove']"));
            removeBtn.click();
            pause(500);

        }

    }
    @Test
    public void removeAll(){
        wd.findElement(By.cssSelector("[href='/contacts']")).click();
        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()!=0){
            wd.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
            pause(500);
            wd.findElement(By.xpath("//button[.='Remove']")).click();
            pause(500);
        }
    }

    @AfterMethod
    public void postConditions(){

    }
    @Test
    public void removeAllContacts(){
        WebElement contact;
        do {
            try {
                contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
            } catch (Exception e) {
                System.out.println("hello"+ e.getMessage());
                // Contact element not found - nothing to remove
                return;
            }
            ClickAndRemove(contact);
            pause(500);
            //wd.navigate().refresh(); // without refresh() removes only 1 or 2 items and fails...
        } while (true);
    }

    private void ClickAndRemove(WebElement contact) {
        contact.click();
        WebElement removeBtn= wd.findElement(By.cssSelector(".contact-item-detailed_card__50dTS button:last-of-type"));
        removeBtn.click();
    }
}
