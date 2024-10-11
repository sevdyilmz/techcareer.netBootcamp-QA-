package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasketPage extends BaseTest {

    public String count(){

        String value=driver.findElement(By.cssSelector("[class='count']")).getText();
        return value;
    }
    public BasketPage clickBasketIcon(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-custom-storefront/div/header/app-header/app-header-one/div[2]/div/div[2]/ul/li[2]/cx-page-slot/app-custom-mini-cart/a")));
        element.click();
        return this;
        //WebElement element= driver.findElement(By.xpath("/html/body/app-root/app-custom-storefront/div/header/app-header/app-header-one/div[2]/div/div[2]/ul/li[2]/cx-page-slot/app-custom-mini-cart/a"));
        //element.click();
       // return this;

    }
    public BasketPage goToBasket(){

        WebElement element= driver.findElement(By.cssSelector("[class='round-btns arrowed']"));
        element.click();
        return this;

    }

    public BasketPage deleteTheProduct(){

        WebElement element= driver.findElement(By.cssSelector("[class='delete cursor-pointer']"));
        element.click();
        return this;

    }
    public String emptyBasketMessage(){

        String value= driver.findElement(By.cssSelector("[class='empty-msg-card higher type3']")).getText();
        return value;

    }
}
