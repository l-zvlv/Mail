package PageObject;

import Base.BaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Setting extends BaseClass {

    public Setting(WebDriver driver) {
        super(driver); }

    //Переход на вкладку все настройки
    @FindBy(xpath = ".//div[contains(text(), 'Все настройки')]")
    private WebElement  AllSetting;
    //Выбираем раздел "Имя и подпись"
    //@FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div/a[1]/div/div]")
    //private WebElement Name;
    //Выбор настроек по умолчанию
    @FindBy(xpath = ".//button[@data-test-id='edit']")
    private WebElement  Defaults;
    //Поле для ввода новой подписи
    @FindBy(xpath = ".//div[@role='textbox']")
    private WebElement Signature;
    //Сохраняем изменение подписи
    @FindBy(xpath = "(.//span[contains(text(), 'Сохранить')])[2]")
    private WebElement  SaveSignature;
    //Возвращаемся в почту
    @FindBy(xpath = ".//span[contains(text(), 'Вернуться в почту')]")
    private WebElement  ReturnMail;
    //Проверяем подпись
    @FindBy(xpath = ".//div[contains(text(), 'Новая тестовая подпись')]")
    private WebElement  TestSignature;
    //Возвращаемся во входящие сообщения
    @FindBy(xpath = ".//span[@title='Вернуться']")
    private WebElement  ReturnMail2;


    @Step("Кликаем по кнопке Все настройки")
    public void clickAllSetting(){ click(AllSetting); }
    //@Step("Кликаем по кнопке Все настройки")
    //public void clickName(){ click(Name); }
    @Step("Кликаем по кнопке Настройки по умолчанию")
    public void clickDefaults(){ click(Defaults); }
    @Step("Вводим новую подпись")
    public void setSignature(String text) { setTextClear(Signature, text); }
    @Step("Сохраняем изменения подписи")
    public void clickSaveSignature(){ click(SaveSignature); }
    @Step("Возвращаемся во входящие сообщения")
    public void clickReturnMail(){ click(ReturnMail); }
    @Step("Проверяем соответствие подписи изменениям")
    public void waitVisibleTestSignature(){ waitVisibilityOfElement(TestSignature); }
    @Step("Возвращаемся во входящие сообщения")
    public void clickReturnMail2(){ click(ReturnMail2); }
}
