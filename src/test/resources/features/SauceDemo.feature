@SauceDemoChallenger
Feature: Compra de Produtos en SauceDemo

  Scenario Outline: Proceso de compra exitosa
    Given que el cliente ingresa a la url saucedemo.com
    When se autentica con el usuario <username> y password <password>
    Then agrega dos productos producto1 <product1> y producto2 <product2> al carrito y lo visualizo
    And completa el formulario con los datos <firstName>, <lastName> y <postalCode> y finaliza compra hasta confirmar 'THANK YOU FOR YOUR ORDER'
    Examples:
      | username      | password     | firstName | lastName | postalCode | product1            | product2              |
      | standard_user | secret_sauce | Byron     | Lopez    | 170361     | Sauce Labs Backpack | Sauce Labs Bike Light |