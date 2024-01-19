package com.byronlopezec.task;

import com.byronlopezec.ui.SauceDemoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;


public class SauceDemoLoginTask implements Task {

    private String username;
    private String password;

    public SauceDemoLoginTask() {
    }

    public SauceDemoLoginTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Performable loginWithCredentials(String username, String password) {

        return Tasks.instrumented(SauceDemoLoginTask.class, username, password);

    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SauceDemoPage.INPUT_USERNAME, WebElementStateMatchers.isVisible()).forNoMoreThan(2).seconds(),
                Enter.theValue(username).into(SauceDemoPage.INPUT_USERNAME),

                WaitUntil.the(SauceDemoPage.INPUT_PASSWORD, WebElementStateMatchers.isVisible()).forNoMoreThan(2).seconds(),
                Enter.theValue(password).into(SauceDemoPage.INPUT_PASSWORD),

                WaitUntil.the(SauceDemoPage.BTN_LOGIN, WebElementStateMatchers.isVisible()).forNoMoreThan(2).seconds(),
                Click.on(SauceDemoPage.BTN_LOGIN)
        );
    }

}
