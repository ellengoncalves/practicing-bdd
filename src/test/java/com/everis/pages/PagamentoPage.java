package com.everis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.everis.util.Hooks;

public class PagamentoPage extends BasePage {

	@FindBy(css = "input[data-qa='name-on-card']")
	protected WebElement campoNomeCartao;

	@FindBy(css = "input[data-qa='card-number']")
	protected WebElement campoNumeroCartao;

	@FindBy(css = "input[data-qa='cvc']")
	protected WebElement campoCvc;

	@FindBy(css = "input[data-qa='expiry-month']")
	protected WebElement campoMesExpiracao;

	@FindBy(css = "input[data-qa='expiry-year']")
	protected WebElement campoAnoExpiracao;

	@FindBy(css = "button[data-qa='pay-button']")
	protected WebElement botaoConfirmarPagamento;

	public PagamentoPage() {
		PageFactory.initElements(Hooks.getDriver(), this);
	}

	public void confirmarPagamento() {
		waitElement(campoNomeCartao, 10).sendKeys("Teste Automatizado");
		waitElement(campoNumeroCartao, 10).sendKeys("4111111111111111");
		waitElement(campoCvc, 10).sendKeys("123");
		waitElement(campoMesExpiracao, 10).sendKeys("12");
		waitElement(campoAnoExpiracao, 10).sendKeys("2030");
		waitElement(botaoConfirmarPagamento, 10).click();
		log("Confirmou o pagamento");
	}

	public boolean apresentouMensagem(String mensagemEsperada) {
		boolean apresentouMensagem = isElementDisplayed(By.xpath("//*[normalize-space()='" + mensagemEsperada + "']"));
		if (apresentouMensagem) {
			log("Apresentou a mensagem [" + mensagemEsperada + "] conforme esperado.");
			return true;
		}
		logFail("Nao apresentou a mensagem [" + mensagemEsperada + "] conforme esperado.");
		return false;
	}
}
