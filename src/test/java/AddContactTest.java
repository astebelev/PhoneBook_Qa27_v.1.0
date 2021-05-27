import models.Contact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase{

    @BeforeMethod
    public void preconditions(){
        if(isElement(By.cssSelector("[href='/login']"))){
            login("atest@gmail.com", "Test_1234@");
        }
    }

    @Test(invocationCount = 1)
    public void addContact(){
        int index=(int)((System.currentTimeMillis()/1000)%3600);
        wd.findElement(By.cssSelector("[href='/add']")).click();

        fillByLocator(By.cssSelector("[placeholder='Name']"),"Lolalololololololololo"+index);
        fillByLocator(By.cssSelector("[placeholder='Last Name']"),"Nowolololololo"+index);
        fillByLocator(By.cssSelector("[placeholder='Phone']"),"9875"+index);
        fillByLocator(By.cssSelector("[placeholder='email']"),"Lola5555"+index+"@mail.ru");
        fillByLocator(By.cssSelector("[placeholder='Address']"),"Haifa/"+index);
        fillByLocator(By.cssSelector("[placeholder='description']"),"university friend");

        wd.findElement(By.cssSelector(".add_form__2rsm2 button")).click();
        pause(1500);


    }
    @Test
    public void addContactByModel(){

        int index=(int)((System.currentTimeMillis()/1000)%3600);
        Contact contact= new Contact()
                .withName("Lola"+index)
                .withLastName("Marck"+index)
                .withPhone("9875"+index)
                .withEmail("Lola"+index+"@mail.ru")
                .withAddress("Haifa")
                .withDescription("Friend");
        openContactForm();
        fillContactForm(contact);
        saveNewContact();
        pause(2000);
        //Assert.assertTrue(wd.findElement(By.xpath("//h2")).getText().contains(contact.getName()));
        Assert.assertTrue(wd.findElement(By.xpath("//a[@class='active']")).getText().contains("CONTACTS"));
    }
    @AfterMethod
    public void postconditions(){
        wd.findElement(By.cssSelector("button")).click();
    }
}