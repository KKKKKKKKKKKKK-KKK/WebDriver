import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test_tesla {
    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "C:/Webdriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tesla.com/");
        new WebDriverWait(driver,50).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='locale-modal' and @open]")));
        WebElement region =  new WebDriverWait(driver,50).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='region-item i18n-en_us']/child::a[@title='United States' and text()='United States']")));
        region.click();
        WebElement model3 = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//nav[@id='block-mainheadernavigation']/descendant::li[@class='tds-menu-header-nav--list_item']/child::a[text()='Model 3']")));
        model3.click();
        WebElement orderNow= new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='tds-btn tds-o-btn tds-btn--outline tds-btn--white tcl-button' and text()='Order Now']/parent::div[@class='hero-callouts--button cmp-animate--to_reveal cmp-animate--revealed']")));
        orderNow.click();
        WebElement payment= new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class='packages-options--nav-title']/child::span[text()='Payment']")));
        payment.click();
        WebElement firstName=new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='FIRST_NAME']")));
        firstName.sendKeys("Sasha");
        WebElement lastName=driver.findElement(By.xpath("//input[@id='LAST_NAME']"));
        lastName.sendKeys("Kachan");
        WebElement email=driver.findElement(By.xpath("//input[@id='EMAIL']"));
        email.sendKeys("test@gmail.com");
        WebElement phone=driver.findElement(By.xpath("//input[@id='PHONE_NUMBER']"));
        phone.sendKeys("+375297052890");
        WebElement cardNumber=driver.findElement(By.xpath("//input[@id='CREDIT_CARD']"));
        cardNumber.sendKeys("5189967822379436");
        WebElement date=driver.findElement(By.xpath("//input[@id='EXPIRATION_DATE']"));
        date.sendKeys("1021");
        WebElement cvv=driver.findElement(By.xpath("//input[@id='CVV']"));
        cvv.sendKeys("123");
        WebElement zipCode=driver.findElement(By.xpath("//input[@id='BILLING_ZIPCODE']"));
        zipCode.sendKeys("210210");
        WebElement order = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='tds-btn tds-btn--blue tds-btn--large tds-btn--full' and text()='Place Order']")));
        order.click();
        WebElement finaL=new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='error credit-card--payment-error' and text()='There was a problem processing your payment. Please check and try a different payment method or contact your card issuing bank.']")));
        String lol=finaL.getText();
        Assert.assertTrue("lol", lol.equals("There was a problem processing your payment. Please check and try a different payment method or contact your card issuing bank."));
        driver.quit();
    }
}
