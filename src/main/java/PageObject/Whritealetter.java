package PageObject;

import Base.BaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Whritealetter extends BaseClass {


        public Whritealetter(WebDriver driver) {
            super(driver); }

        //Нажимаем на кнопку "Написать письмо"
        @FindBy(xpath = ".//a[@title='Написать письмо']")
        private WebElement Letter;
        //Форма письма
        @FindBy(xpath = ".//div[@class='scrollview--SiHhk scrollview_main--3Vfg9 scrollview_mainCompressed--2IhQY']")
        private WebElement Form;
        //Поле "Кому"
        @FindBy(xpath = ".//input[@tabindex='100']")
        private WebElement ToWhom;
        //Поле "Тема"
        @FindBy(xpath = ".//input[@name='Subject']")
        private WebElement Subject;
        //Тело письма
        @FindBy(xpath = ".//div[@role='textbox']")
        private WebElement BodyMessage;
        //Кнопка "Отправить"
        @FindBy(xpath = ".//span[@data-title-shortcut='Ctrl+Enter']")
        private WebElement  Enter;
        //Закрываем
        @FindBy(xpath = ".//span[@title='Закрыть']")
        private WebElement  Close;


        @Step("Кликаем по кнопке написать письмо")
        public void clickLetter(){ click(Letter); }
        @Step("Проверяем открытие формы")
        public void waitVisibleForm(){ waitVisibilityOfElement(Form); }
        @Step("Заполняем адрес письма")
        public void settowhom(String text) { setText(ToWhom, text); }
        @Step("Заполняем тему письма")
        public void setsubject(String text) { setText(Subject, text); }
        @Step("Заполняем тело письма")
        public void setbodyMessage(String text) { setText(BodyMessage, text); }
        @Step("Кликаем по кнопке отправить")
        public void clickenter(){ click(Enter); }
        @Step("Кликаем по кнопке закрыть")
        public void clickClose(){ click(Close); }
}
