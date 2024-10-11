package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BaseTest {

    public MainPage acceptCoocies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("banner-accept-button")));
        element.click();
        return this;

    }

    public MainPage categoryMakeUp(){

        WebElement element= driver.findElement(By.cssSelector("[class='category-501 mega-menu-drop ng-star-inserted']"));
        element.click();
        return this;

    }
    public MainPage searchBox(String text){

        WebElement element= driver.findElement(By.cssSelector("[class='search-input']"));
        element.sendKeys(text);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        return this;

    }

}