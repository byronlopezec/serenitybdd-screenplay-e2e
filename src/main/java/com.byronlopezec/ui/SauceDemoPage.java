package com.byronlopezec.ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("page:webdriver.base.url.saucedemo")
public class SauceDemoPage extends PageObject {
    public static final Target INPUT_USERNAME = Target.the("entrada username").locatedBy("//input[@id='user-name']");
    public static final Target INPUT_PASSWORD = Target.the("Entrada password").locatedBy("//input[@id='password']");
    public static final Target BTN_LOGIN = Target.the("click en login").locatedBy("//input[@id='login-button']");

    public static final Target BTN_PRODUCT1 = Target.the("AGREGAR PRODUCTO1").locatedBy("//button[@id='add-to-cart-sauce-labs-backpack']");
    public static final Target BTN_PRODUCT2 = Target.the("AGREGAR PRODUCTO2").locatedBy("//button[@id='add-to-cart-sauce-labs-bike-light']");

    public static final Target BTN_SHOPPING_CART = Target.the("icono ver carrito").locatedBy("//a[@class='shopping_cart_link']");
    public static final Target BTN_CHECKOUT = Target.the("boton continuar compra").locatedBy("//button[@id='checkout']");

    public static final Target INPUT_FORM_FIRSTNAME = Target.the("extrada ed formulario nombre").locatedBy("//input[@id='first-name']");
    public static final Target INPUT_FORM_LASTNAME = Target.the("entrada de formulario apellido").locatedBy("//input[@id='last-name']");
    public static final Target INPUT_FORM_POSTALCODE = Target.the("entrada codigoPostal").locatedBy("//input[@id='postal-code']");
    public static final Target BTN_FORM_CONTINUE_ = Target.the("boton confirmar formulario ").locatedBy("//input[@id='continue']");

    public static final Target BTN_FINISH_PURCHARSE = Target.the("boton de finalizar compra").locatedBy("//button[@id='finish']");
    public static final Target LABEL_COMPLETE_ORDER = Target.the("texto de completado orden").locatedBy("//h2[@class='complete-header']");

}