package PageObject;

import Base.BaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BaseClass {

    public Login(WebDriver driver) {
        super(driver);
    }

    //Ввод логина
    @FindBy(xpath = ".//input[@name='login']")
    private WebElement Login;
    //Кликаем "ввести пароль"
    @FindBy(xpath = ".//input[@value='Ввести пароль']")
    private WebElement EntryLogin;
    //Ввод пароля
    @FindBy(xpath = ".//input[@name='password'][1]")
    private WebElement Password;
    //Кликаем "войти"
    @FindBy(xpath = ".//input[@value='Ввести пароль']")
    private WebElement EntryPassword;

    @Step("Вводим логин почты")
    public void setLogin(String text) {
        setText(Login, text);
    }
    @Step("Кликаем по кнопке ввести пароль")
    public void clickEntryLogin() { click(EntryLogin);  }
    @Step("Вводим пароль почты")
    public void setPassword(String text) { setText(Password, text); }
    @Step("Кликаем по кнопке Войти в почту")
    public void clickcEntryPassword() {
        click(EntryPassword);
    }
}