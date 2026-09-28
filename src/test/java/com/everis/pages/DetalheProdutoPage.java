package com.everis.pages;

import com.everis.util.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetalheProdutoPage extends BasePage {

	@FindBy(xpath = "//a[@href='/view_cart' and contains(., 'View Cart')]")
	protected WebElement botaoVisualizarCarrinho;

	@FindBy(css = "button.cart")
	protected WebElement botaoAdicionarAoCarrinho;

	@FindBy(css = "#quantity")
	protected WebElement campoQuantidade;

	public DetalheProdutoPage() {
		PageFactory.initElements(Hooks.getDriver(), this);
	}

	public void aumentarQuantidadeProduto() {
		WebElement quantidade = waitElement(campoQuantidade, 10);
		quantidade.clear();
		quantidade.sendKeys("2");
		log("Aumentou a quantidade do produto para 2");
	}

	public void adicionarProdutoAoCarrinho() {
		waitElement(botaoAdicionarAoCarrinho, 10).click();
		waitElement(botaoVisualizarCarrinho, 10).click();
		log("Adicionou o produto ao carrinho pela pagina de detalhes");
	}
}
