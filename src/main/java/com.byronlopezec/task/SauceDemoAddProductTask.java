package com.byronlopezec.task;

import com.byronlopezec.ui.SauceDemoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;


public class SauceDemoAddProductTask implements Task {

    private List<String> products;

    public SauceDemoAddProductTask() {
    }

    public SauceDemoAddProductTask(List<String> products) {
        this.products = products;
    }

    public static Performable addProducts(List<String> products) {

        return Tasks.instrumented(SauceDemoAddProductTask.class, products);

    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        this.products.forEach(product -> {
            actor.attemptsTo(
                    WaitUntil.the(SauceDemoPage.GET_BTN_PRODUCT(product), WebElementStateMatchers.isVisible()).forNoMoreThan(2).seconds(),
                    Click.on(SauceDemoPage.GET_BTN_PRODUCT(product))
            );
        });


    }

}
