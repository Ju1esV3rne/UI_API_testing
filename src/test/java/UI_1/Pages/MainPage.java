/**
 * Главная страница
 */
package UI_1.Pages;

import com.codeborne.selenide.ElementsCollection;

import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public static final String LOGIN = "Login";
    public static final String SIGN_UP = "Sign Up";
    // поиск кнопки регистрации
    public final ElementsCollection authButtons = $$x("//p[@class='control']");

    // поиск кнопок навигации
    public final ElementsCollection header = $$x("//a[@class='navbar-item']");

    /**
     * Открытие главной страницы
     * @param url
     */
    public MainPage(String url) {
        open(url);
    }

    /**
     * Доступ к кнопкам авторизации
     * @param keyWorld при вызове на вход передается название кнопки
     */
    public void getAuthElement(String keyWorld){
        if (Objects.equals(keyWorld, "Login")){
            authButtons.findBy(text(LOGIN)).click();
        } else if (Objects.equals(keyWorld, SIGN_UP)){
            authButtons.findBy(text(SIGN_UP)).click();
        }
    }

    /**
     * Меню навигации главной страницы
     */
    public void header(String headerElement) {
        if (headerElement.equals("Pricing")){
            header.findBy(text("Pricing")).click();
        } else if (headerElement.equals("Features")){
            header.findBy(text("Features")).click();
        }
        // ... По необходимости добавить остальные элементы header
        }
    }

