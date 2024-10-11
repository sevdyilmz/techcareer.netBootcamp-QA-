package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BaseTest {

    public ProductPage liquidLipstick(){

        WebElement element=driver.findElement(By.cssSelector("[class='cx-product-image is-initialized']"));
        element.click();
        return this;

    }
    public ProductPage addToBasket(){

        WebElement element=driver.findElement(By.cssSelector("[class='add-to-basket round-btns fat']"));
        element.click();
        return this;

    }
    public ProductPage closeTheChat(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='jetlink-launcher launcher-custom active launcher-circle']")));
        element.click();
        return this;
        //WebElement element=driver.findElement(By.cssSelector("[class='close-widget']"));
       // element.click();
        //return this;
    }
    public ProductPage subCategory(){

        WebElement element=driver.findElement(By.xpath("//span[text()='Likit Ruj']"));
        element.click();
        return this;
    }
}
