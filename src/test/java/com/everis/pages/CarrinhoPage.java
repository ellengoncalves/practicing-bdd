package com.everis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.everis.util.Hooks;

public class CarrinhoPage extends BasePage {

	@FindBy(xpath = "//a[contains(@class,'check_out') and contains(., 'Proceed To Checkout')]")
	protected WebElement botaoProceedCheckout;
	
	public CarrinhoPage() {
		PageFactory.initElements(Hooks.getDriver(), this);
	}
	
	public boolean apresentouProdutoEsperadoNoCarrinho(String nomeProduto) {
		boolean apresentouProdutoEsperadoNoCarrinho = isElementDisplayed(By.xpath("//tr[contains(@id,'product-')]//td[contains(@class,'cart_description')]//a[normalize-space()='" + nomeProduto + "']"));
		if (apresentouProdutoEsperadoNoCarrinho) {
			log("Apresentou o produto [" + nomeProduto + "] no carrinho conforme esperado.");
			return true;
		}
		logFail("Deveria ter apresentado o produto [" + nomeProduto + "] no carrinho.");
		return false;
	}

	public boolean oProdutoApresentouQuantidadeEsperada(String nomeProduto, String quantidadeProdutoEsperada) {
		WebElement quantidadeProduto = waitElement(By.xpath("//tr[contains(@id,'product-')][.//td[contains(@class,'cart_description')]//a[normalize-space()='" + nomeProduto + "']]//td[contains(@class,'cart_quantity')]//button"), 10);
		boolean oProdutoApresentouQuantidadeEsperada = quantidadeProdutoEsperada.equals(quantidadeProduto.getText().trim());
		if (oProdutoApresentouQuantidadeEsperada) {
			log("Apresentou a quantidade [" + quantidadeProdutoEsperada + "] do produto [" + nomeProduto + "] conforme esperado.");
			return true;
		}
		logFail("Nao apresentou a quantidade [" + quantidadeProdutoEsperada + "] do produto [" + nomeProduto + "] conforme esperado.");
		return false;
	}

	public void acessarCheckout() {
		waitElement(botaoProceedCheckout, 10).click();
		log("Acessou o checkout");
	}
}
