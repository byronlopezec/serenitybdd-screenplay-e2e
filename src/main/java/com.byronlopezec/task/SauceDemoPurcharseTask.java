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


public class SauceDemoPurcharseTask implements Task {

    private String firstName;
    private String lastName;
    private String postalCode;

    public SauceDemoPurcharseTask() {
    }

    public SauceDemoPurcharseTask(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public static Performable completeForm(String firstName, String lastName, String postalCode) {
        return Tasks.instrumented(SauceDemoPurcharseTask.class, firstName, lastName, postalCode);

    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(SauceDemoPage.INPUT_FORM_FIRSTNAME, WebElementStateMatchers.isVisible()).forNoMoreThan(2).seconds(),
                Enter.theValue(this.firstName).into(SauceDemoPage.INPUT_FORM_FIRSTNAME),

                WaitUntil.the(SauceDemoPage.INPUT_FORM_LASTNAME, WebElementStateMatchers.isVisible()).forNoMoreThan(2).seconds(),
                Enter.theValue(this.lastName).into(SauceDemoPage.INPUT_FORM_LASTNAME),

                WaitUntil.the(SauceDemoPage.INPUT_FORM_POSTALCODE, WebElementStateMatchers.isVisible()).forNoMoreThan(2).seconds(),
                Enter.theValue(this.postalCode).into(SauceDemoPage.INPUT_FORM_POSTALCODE),

                WaitUntil.the(SauceDemoPage.BTN_FORM_CONTINUE, WebElementStateMatchers.isVisible()).forNoMoreThan(2).seconds(),
                Click.on(SauceDemoPage.BTN_FORM_CONTINUE),

                WaitUntil.the(SauceDemoPage.BTN_FINISH_PURCHARSE, WebElementStateMatchers.isVisible()).forNoMoreThan(2).seconds(),
                Click.on(SauceDemoPage.BTN_FINISH_PURCHARSE),

                WaitUntil.the(SauceDemoPage.LABEL_COMPLETE_ORDER, WebElementStateMatchers.isVisible()).forNoMoreThan(2).seconds()
        );
    }
}
