package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest {

    public LoginPage fillMail(String text) {
        WebElement element = driver.findElement(By.xpath("//app-root/app-custom-storefront[@role='presentation']//cx-page-layout[@class='LoginPageTemplate ng-star-inserted']/cx-page-slot[@class='LeftContentSlot has-components ng-star-inserted']/app-custom-login-form[@class='ng-star-inserted']/section//app-custom-form-for-login/form//input[@type='text']"));
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public LoginPage fillPassword(String text) {
        WebElement element = driver.findElement(By.xpath("//app-root/app-custom-storefront[@role='presentation']//cx-page-layout[@class='LoginPageTemplate ng-star-inserted']/cx-page-slot[@class='LeftContentSlot has-components ng-star-inserted']/app-custom-login-form[@class='ng-star-inserted']/section//app-custom-form-for-login/form//input[@type='password']"));
        element.clear();
        element.sendKeys(text);
        return this;

    }

    public LoginPage clickLoginButton() {

        driver.findElement(By.cssSelector("[class='round-btns']")).submit();
        return this;
    }
    public String getAccountName(){

        String value=driver.findElement(By.cssSelector("[class='log-box dropper ng-star-inserted']")).getText();
        return value;

    }


    public LoginPage signIn() {

        WebElement element = driver.findElement(By.cssSelector("[class='log-box dropper ng-star-inserted']"));
        element.click();
        return this;

    }

    public LoginPage signIn2() {

        WebElement element = driver.findElement(By.cssSelector("[class='highlighted ng-star-inserted']"));
        element.click();
        return this;
    }
    public String errorMessage(){

        String value = driver.findElement(By.cssSelector(".ng-star-inserted.control-invalid .ng-star-inserted")).getText();
        return value;

    }

    public String errorMessagePassword(){

        String value=driver.findElement(By.cssSelector(".form-group.pusher > cx-form-errors[role='alert'] > .ng-star-inserted")).getText();
        return value;
    }
    public String errorMessage1(){

        String value = driver.findElement(By.xpath("//app-root/app-custom-storefront[@role='presentation']//cx-page-layout[@class='LoginPageTemplate ng-star-inserted']/cx-page-slot[@class='LeftContentSlot has-components ng-star-inserted']/app-custom-login-form[@class='ng-star-inserted']/section//app-custom-form-for-login/form/div[1]/cx-form-errors[@role='alert']/p[@class='ng-star-inserted']")).getText();
        return value;

    }
    public String informationText(){

        String value = driver.findElement(By.id("error-modal")).getText();
        return value;

    }
}