package UI_1.Pages;

import static com.codeborne.selenide.Selenide.$$x;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class TariffsPage {

    /**
     * Список тарифов, в тестах не используется, оставляю для возможных переборов списка
     */
    public final ElementsCollection plan_header = $$x(
            "//section[@class='section is-hidden-mobile']//div[@class='plan-header']"
    );

    /**
     * Список услуг по тарифам
     */
    public final ElementsCollection plan_item = $$x(
            "//div[@class='pricing-table is-comparative']//div[contains(@class,'pricing-plan is-features')]//div[@class='plan-item']"
    );

    /**
     * Значения по предоставляемым услугам, задается динамически, по параметру метода tariffs
     */
    public ElementsCollection plan_value;


    /**
     * @param tariff  тариф по которому получаем данные из таблицы
     * @param plan_items услуги по которым получам данные из таблицы
     * @return
     */
    public String tariffs (String tariff, String plan_items){
        plan_value = $$x(
                String.format("//div[@class='pricing-table is-comparative']//div[contains(text(),'%s')]//..//div[@class='plan-item']", tariff));

        //Перебор списка услуг осуществляется для поиска индекса
        //Индекс услуги необходим для сравнения со значениями услуг по тарифам,
        int i = 0;
        for (SelenideElement selenideElement : plan_item){  // поиск желаемой услуги
            if (selenideElement.getText().equals(plan_items)) {  // поиск индекса по переденной услуге plan_items
                 return plan_value.get(i).getText();  // Возвращем наименование услуги по найденному индексу
            }
            i++;
        }

        return tariff;
    }

}
