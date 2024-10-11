import Base.BaseTest;
import Pages.MainPage;
import Pages.ProductPage;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.regex.Pattern;

@Feature("Filtreleme Test Senaryoları")
public class FilterTests extends BaseTest {

    MainPage mainPage = new MainPage();
    ProductPage productPage = new ProductPage();

    @Test (description = "Arama Çubuğu'na yazılan kelime ile filtreleme")
    public void searchBoxControl() throws InterruptedException {

        mainPage.searchBox("ruj");
        sleep(3000);
        List<WebElement> productList = driver.findElements(By.cssSelector("[class='cx-product-name']"));
        System.out.println(productList.size());

        for (WebElement product : productList) {
            String productName = product.getText();
            System.out.println(productName);
            Assert.assertTrue(productName.toLowerCase().contains("ruj"), "Ürün adı 'ruj' içermiyor: " + productName);

        }

    }

    @Test (description = "Alt kategori seçilerek filtreleme")
    public void subFiltersControl() throws InterruptedException {

        mainPage.searchBox("ruj");
        sleep(3000);
        productPage.subCategory();
        sleep(3000);
        List<WebElement> productList = driver.findElements(By.cssSelector("[class='cx-product-name']"));
        System.out.println(productList.size());

        for (WebElement product : productList) {
            String productName = product.getText();
            System.out.println(productName);
            //Assert.assertTrue(productName.toLowerCase().contains("likit"), "Ürün adı 'likit' içermiyor: " + productName);
            Assert.assertTrue(Pattern.compile("(?i)ruj|dolgun").matcher(productName).find(), "Ürün adı 'ruj' veya 'dolgun' kelimelerinden birini içermiyor: " + productName);
        }

    }
}
