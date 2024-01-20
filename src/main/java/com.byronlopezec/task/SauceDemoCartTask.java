package com.byronlopezec.task;

import com.byronlopezec.ui.SauceDemoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;


public class SauceDemoCartTask implements Task {

    private List<String> products;

    public SauceDemoCartTask() {
    }

    public SauceDemoCartTask(List<String> products) {
        this.products = products;
    }

    public static Performable viewCartWith(List<String> products) {

        return Tasks.instrumented(SauceDemoCartTask.class, products);

    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(SauceDemoPage.BTN_SHOPPING_CART, WebElementStateMatchers.isVisible()).forNoMoreThan(2).seconds(),
                Click.on(SauceDemoPage.BTN_SHOPPING_CART)
        );

        this.products.forEach(product -> {
            actor.attemptsTo(
                    WaitUntil.the(SauceDemoPage.FIND_LABEL_PRODUCT(product), WebElementStateMatchers.isVisible()).forNoMoreThan(2).seconds()
            );
        });

        actor.attemptsTo(
                WaitUntil.the(SauceDemoPage.BTN_CHECKOUT, WebElementStateMatchers.isVisible()).forNoMoreThan(2).seconds(),
                Click.on(SauceDemoPage.BTN_CHECKOUT)
        );
    }

}
