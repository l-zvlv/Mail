package Mail;;
import PageObject.CheckLetter;
import PageObject.Login;
import PageObject.Setting;
import PageObject.Whritealetter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;




public class Proverka extends ChromeClass {
    @Test
    public void metod () {
        getDriver().get("https://mail.ru");
        getDriver().manage().window().maximize();
        Login in = new Login(getDriver());
        Whritealetter ln = new Whritealetter(getDriver());
        CheckLetter km = new CheckLetter(getDriver());
        Setting st = new Setting(getDriver());
        //Вводим логин
        in.setLogin("hometest99");
        // Кликаем "Ввести пароль"
        in.clickEntryLogin();
        //Вводим пароль
        in.setPassword("fentazi75");
        //Кликаем "Войти"
        in.clickcEntryPassword();
        //Кликаем "написать письмо"
        ln.clickLetter();
        //проверяем окрытие формы
        ln.waitVisibleForm();
        //Заполняем поле "Кому"
        ln.settowhom("hometest99@mail.ru");
        //Заполняем тему письма
        ln.setsubject("Автотестирование");
        //Заполняем тело письма
        ln.setbodyMessage("Это сообщение написано автоматически");
        //Кликаем "Отправить"
        ln.clickenter();
        //Нажмаем закрыть
        ln.clickClose();
        //Проверяем есть ли письмо с указанной темой
        km.waitVisibleSubjectCheck();
        //Открываем письмо
         km.clickOpenLetter();
         km.clickOpenLet();
        //Проверка соответствие темы письма
        km.waitVisibleSubjectCheck2();
        //проверяем соответствие текста письма
        km.waitVisibleCheckBody();
        //Возвращаемся на главную станицу почты
        getDriver().get("https://e.mail.ru/inbox");
        //Переходим в настройки(у меня долго прогружалась страница и тест падал т.к. не находил локатор, я написала условие, чтобы он ожилал 15 секунд)
        try {

            getDriver().findElement(By.xpath(".//div[@class=\"settings\"]")).click();
        }
        catch (NoSuchElementException e) {
            try {
                Thread.sleep(15000);
            }
            catch(InterruptedException ex) {

            }
            getDriver().findElement(By.xpath(".//div[@class=\"settings\"]")).click();
        }
        //открытие всех настроек
        st.clickAllSetting();
        getDriver().get("https://e.mail.ru/settings/general#messages");
        //Кликаем на "настройки по умолчанию"
        st.clickDefaults();
        //Вводим новую подпись
        st.setSignature("Новая тестовая подпись");
        //Cохраняем изменения
        st.clickSaveSignature();
        //Возвращаемся во входящие сообщения
        st.clickReturnMail();
        //Нажимаем "Написать письмо"
        ln.clickLetter();
        //Проверяем открытие формы письма
        ln.waitVisibleForm();
        //Проверяем соответствие подписи изменениям
        st.waitVisibleTestSignature();
        //Заполняем поле "Кому"
        ln.settowhom("hometest99@mail.ru");
        //Заполняем тему письма
        ln.setsubject("Автотестирование");
        //Вводим текст сообщения
        ln.setbodyMessage("Это письмо написанно автоматически");
        //Отправляем
        ln.clickenter();
        //Закрываем форму
        ln.clickClose();
        //Проверяем наличие письма
        km.waitVisibleSubjectCheck();
        //Открываем письмо
        km.clickOpenLetter();
        km.clickOpenLet();
        //Проверяем соответствие темы
        km.waitVisibleSubjectCheck2();
        //Проверяем соответствие текста
        km.waitVisibleCheckBody();
        //Проверяем подпись
        st.waitVisibleTestSignature();
        //Возвращаемся во входящие сообщения
        st.clickReturnMail2();
        //Выбираем два последних письма
        km.clickDeleteLetter();
        km.clickDeleteLetter1();
        //Удаляем
        km.clickDelete();
        //Проверяем, что они отсутствуют в списке
        km.waitVisibleCheck();


    }
}