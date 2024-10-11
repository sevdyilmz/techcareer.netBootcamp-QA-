import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Feature("Login Test Senaryoları")
public class LoginTests extends BaseTest {

    LoginPage login = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test (description = "Başarılı giriş")
    public void LoginSuccessful() throws InterruptedException {

        mainPage.acceptCoocies();
        login.signIn()
                .signIn2();
        sleep(2000);
        login.fillMail(mail)
                .fillPassword(password)
                .clickLoginButton();

        sleep(3000);
        String value = login.getAccountName();
        assertEquals(value, "Java İntellij\n"+
                "Hesabım");

    }

    @Test (description = "Zorunlu alanlar")
    public void requiredMailPasswordControl() throws InterruptedException {

        mainPage.acceptCoocies();
        login.signIn()
                .signIn2();
        sleep(3000);
        login.clickLoginButton();
        sleep(3000);
        String value = login.errorMessage();
        assertEquals(value, "Bu alan zorunludur");

    }

    @Test  (description = "Mailin girilmeme durumu")
    public void requiredMailControl() throws InterruptedException {

        mainPage.acceptCoocies();
        login.signIn()
                .signIn2();
        sleep(3000);
        login.fillPassword(password)
                .clickLoginButton();
        sleep(3000);
        String value = login.errorMessage();
        assertEquals(value, "Bu alan zorunludur");

    }
    @Test (description = "Şifrenin girilmeme durumu")
    public void requiredPasswordControl() throws InterruptedException {

        mainPage.acceptCoocies();
        login.signIn()
                .signIn2();
        sleep(3000);
        login.fillMail(mail)
                .clickLoginButton();
        sleep(3000);
        String value = login.errorMessagePassword();
        assertEquals(value, "Bu alan zorunludur");

    }
    @Test (description = "Geçersiz mail formatı")
    public void invalidMailControl() throws InterruptedException {

        mainPage.acceptCoocies();
        login.signIn()
                .signIn2();
        sleep(3000);

        login.fillMail("aaaa")
                .fillPassword(password)
                .clickLoginButton();
        sleep(3000);
        String value = login.errorMessage1();
        assertEquals(value, "Bu geçerli bir e-posta formatı değil");

    }

    @Test (description = "Geçersiz şifre")
    public void invalidPasswordControl() throws InterruptedException {

        mainPage.acceptCoocies();
        login.signIn()
                .signIn2();
        sleep(3000);
        login.fillMail(mail)
                .fillPassword("987654Sev")
                .clickLoginButton();
        sleep(3000);
        String value = login.informationText();
        assertEquals(value, "Yanlış şifre veya email/cep telefonu.\n" +
                "Lütfen Tekrar Deneyin");

    }
}
