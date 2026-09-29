package com.everis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.everis.util.Config;
import com.everis.util.Hooks;
import com.everis.util.Urls;

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
		if (!driver.getCurrentUrl().contains("/payment")) {
			driver.navigate().to(Urls.PAGAMENTO);
		}
		waitElement(campoNomeCartao, 10).sendKeys(obterConfiguracao("name", "NAME"));
		waitElement(campoNumeroCartao, 10).sendKeys(obterConfiguracao("number", "NUMBER"));
		waitElement(campoCvc, 10).sendKeys(obterConfiguracao("cvc", "CVC"));
		waitElement(campoMesExpiracao, 10).sendKeys(obterConfiguracao("expiry.month", "EXPIRY_MONTH"));
		waitElement(campoAnoExpiracao, 10).sendKeys(obterConfiguracao("expiry.year", "EXPIRY_YEAR"));
		waitElement(botaoConfirmarPagamento, 10).click();
		log("Confirmou o pagamento");
	}

	private String obterConfiguracao(String propriedade, String variavelAmbiente) {
		return Config.obter("automationexercise.card." + propriedade, "AUTOMATION_EXERCISE_CARD_" + variavelAmbiente);
	}

	public boolean apresentouMensagem(String mensagemEsperada) {
		try {
			waitElement(By.xpath("//*[contains(normalize-space(), '" + mensagemEsperada + "')]"), 10);
			log("Apresentou a mensagem [" + mensagemEsperada + "] conforme esperado.");
			return true;
		} catch (Exception e) {
			logFail("Nao apresentou a mensagem [" + mensagemEsperada + "] conforme esperado.");
			return false;
		}
	}
}
