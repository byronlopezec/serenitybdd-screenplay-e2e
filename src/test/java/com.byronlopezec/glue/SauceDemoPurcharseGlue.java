package com.byronlopezec.glue;

import com.byronlopezec.task.SauceDemoAddProductTask;
import com.byronlopezec.task.SauceDemoCartTask;
import com.byronlopezec.task.SauceDemoLoginTask;
import com.byronlopezec.task.SauceDemoPurcharseTask;
import com.byronlopezec.ui.SauceDemoPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.ArrayList;
import java.util.List;

public class SauceDemoPurcharseGlue {

    private static final String ACTOR_NAME = "cliente";

    @Before
    public void setTheStag() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^que el (.*) ingresa a la url saucedemo.com$")
    public void ingresaASaucedemo(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(Open.browserOn().the(SauceDemoPage.class));

    }

    @When("^se autentica con el usuario (.*) y password (.*)$")
    public void seAutenticaConSuUsuario(String username, String password) {

        GivenWhenThen.when(OnStage.theActorInTheSpotlight()).wasAbleTo(
                SauceDemoLoginTask.loginWithCredentials(username, password)
        );
    }

    @Then("^agrega dos productos producto1 (.*) y producto2 (.*) al carrito y lo visualizo$")
    public void completesTask(String producto1, String producto2) {

        List<String> products = new ArrayList<>();
        products.add(producto1);
        products.add(producto2);

        GivenWhenThen.then(OnStage.theActorInTheSpotlight()).wasAbleTo(
                SauceDemoAddProductTask.addProducts(products),
                SauceDemoCartTask.viewCartWith(products)
        );
    }

    @And("^completa el formulario con los datos (.*), (.*) y (.*) y finaliza compra hasta confirmar 'THANK YOU FOR YOUR ORDER'$")
    public void completaFormularioDeCompraYFinalizaParaverMensaje(String firstName, String lastName, String postalcode) {
        GivenWhenThen.and(OnStage.theActorInTheSpotlight()).wasAbleTo(
                SauceDemoPurcharseTask.completeForm(firstName, lastName, postalcode)
        );
    }
}
