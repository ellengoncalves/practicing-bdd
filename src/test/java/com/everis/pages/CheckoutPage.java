package com.everis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.everis.util.Hooks;
import com.everis.util.Urls;

public class CheckoutPage extends BasePage {

	@FindBy(css = "#address_delivery")
	protected WebElement enderecoEntrega;

	@FindBy(css = "#cart_info")
	protected WebElement resumoPedido;

	@FindBy(css = "textarea[name='message']")
	protected WebElement campoComentario;

	@FindBy(xpath = "//a[contains(@class,'check_out') and contains(., 'Place Order')]")
	protected WebElement botaoPlaceOrder;

	public CheckoutPage() {
		PageFactory.initElements(Hooks.getDriver(), this);
	}

	public void confirmarEnderecoEntrega() {
		if (!driver.getCurrentUrl().contains("/checkout")) {
			driver.navigate().to(Urls.CHECKOUT);
		}
		waitElement(enderecoEntrega, 10);
		waitElement(resumoPedido, 10);
		log("Confirmou o endereco de entrega e o resumo do pedido");
	}

	public void acessarPagamento() {
		waitElement(campoComentario, 10).sendKeys("Pedido criado por teste automatizado.");
		waitElement(botaoPlaceOrder, 10).click();
		if (!driver.getCurrentUrl().contains("/payment")) {
			driver.navigate().to(Urls.PAGAMENTO);
		}
		log("Acessou a pagina de pagamento");
	}
}
