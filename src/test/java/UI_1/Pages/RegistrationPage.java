/**
 * Страница регистрации
 */
package UI_1.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    // поиск элемента для подтверждения перехода на страницу регистрации
    public final SelenideElement authPageElement = $x("//*[text()='Create new account.']");

    // поиск элемента для проверки требований обязательных полей ввода
    public final SelenideElement assertPageElement = $x("//div[@class='c-alert c-alert--danger']");
    public final SelenideElement capture = $("#rc-imageselect-response-field");

    // поиск списка элементов регистрации
    public final ElementsCollection authInput = $$x("//input[@class='c-input']");

    // поиск кнопки "Register"
    public final SelenideElement buttonRegister = $x("//button[@id='register_button']");

    /**
     * Возвращает строку для проверки перехода на страницу регистрации
     */
    public String authPageElement() {
        return authPageElement.getText();
    }

    /**
     * Возвращает строку для проверки обязательных полей
     * @return
     */
    public String assertPageElement() {
        try {
            return assertPageElement.getText();
        } catch (Throwable e) {
            capture.exists();
            return "CAPTCHA";
        }
    }

    /**
     * Перегруженный метод для заполнения полей авторизации
     */
    public void authInput(String email){
        authInput.findBy(id("user_email")).setValue(email);
    }
    public void authInput(String email, String password){
        authInput.findBy(id("user_email")).setValue(email);
        authInput.findBy(id("user_password")).setValue(password);
    }
    public void authInput(String email, String password, String password_confirm){
        authInput.findBy(id("user_email")).setValue(email);
        authInput.findBy(id("user_password")).setValue(password);
        authInput.findBy(id("password_confirm")).setValue(password_confirm);
    }

    /**
     * Нажатие кнопки "Register"
     */
    public void buttonRegister() {
        buttonRegister.click();
    }
}
