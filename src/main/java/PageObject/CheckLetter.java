package PageObject;

import Base.BaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckLetter extends BaseClass {
    public CheckLetter(WebDriver driver) {
        super(driver); }
    //Проверка наличия письма
    @FindBy(xpath = ".//span[contains(text(), 'Автотестирование')]")
    private WebElement  SubjectCheck;
    //Открываем письмо
    @FindBy(xpath = ".//div[@class='mt-h-c__content']")
    private WebElement  OpenLetter;
    @FindBy(xpath = "(.//div[@class='llc__container'])[1]")
    private WebElement  OpenLet;
    //Проверка соответствия темы
    @FindBy(xpath = ".//h2[contains(text(), 'Автотестирование')]")
    private WebElement  SubjectCheck2;
    //Проверка соответствия текста письма
    @FindBy(xpath = ".//div[contains(text(), 'Это сообщение написано автоматически')]")
    private WebElement  CheckBody;
    //Отмечаем необходимые письма для удаления
    @FindBy(xpath = "(.//div[3]/button)[2]")
    private WebElement  DeleteLetter;
    @FindBy(xpath = "(.//div[3]/button)[3]")
    private WebElement  DeleteLetter1;
    //удалить письма
    @FindBy(xpath = ".//span[@title= 'Удалить']")
    private WebElement  Delete;
    //Проверяем, что письма отстутствуют в списке
    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/div/div/a[1]/div[4]")
    private WebElement  Check;


    @Step("Выполняем проверку наличия письма")
    public void waitVisibleSubjectCheck(){ waitVisibilityOfElement(SubjectCheck); }
    @Step("Кликаем по кнопке Открыть письмо")
    public void clickOpenLetter() {click(OpenLetter); }
    public void clickOpenLet() {click(OpenLet); }
    @Step("Выполняем проверку соответствия темы письма")
    public void waitVisibleSubjectCheck2(){ waitVisibilityOfElement(SubjectCheck2); }
    @Step("Выполняем проверку соответствия текста письма")
    public void waitVisibleCheckBody(){ waitVisibilityOfElement(CheckBody); }
    @Step("Кликаем по чек-боксу необходимых писем для удаления")
    public void clickDeleteLetter(){ click(DeleteLetter); }
    public void clickDeleteLetter1(){ click(DeleteLetter1); }
    @Step("Кликаем на кнопку удалния")
    public void clickDelete(){ click(Delete); }
    @Step("Проверяем отсутствие писем в списке")
    public void waitVisibleCheck(){ waitVisibilityOfElement(Check); }
}
