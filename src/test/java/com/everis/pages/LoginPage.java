package com.everis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.everis.util.Hooks;

public class LoginPage extends BasePage {

	@FindBy(xpath = "//u[normalize-space()='Register / Login']/ancestor::a")
	protected WebElement linkLogin;

	@FindBy(xpath = "//a[contains(., 'Logged in as')]")
	protected WebElement textoUsuarioLogado;

	@FindBy(css = "input[data-qa='login-email']")
	protected WebElement campoEmail;

	@FindBy(css = "input[data-qa='login-password']")
	protected WebElement campoSenha;

	@FindBy(css = "button[data-qa='login-button']")
	protected WebElement botaoLogin;

	@FindBy(css = "a[href='/view_cart']")
	protected WebElement linkCarrinho;

	@FindBy(xpath = "//a[contains(@class,'check_out') and contains(., 'Proceed To Checkout')]")
	protected WebElement botaoProceedCheckout;

	public LoginPage() {
		PageFactory.initElements(Hooks.getDriver(), this);
	}

	public void realizarLogin() {
		waitElement(linkLogin, 10).click();
		waitElement(campoEmail, 10).sendKeys(obterConfiguracao("automationexercise.email", "AUTOMATION_EXERCISE_EMAIL"));
		waitElement(campoSenha, 10).sendKeys(obterConfiguracao("automationexercise.password", "AUTOMATION_EXERCISE_PASSWORD"));
		waitElement(botaoLogin, 10).click();
		waitElement(textoUsuarioLogado, 10);
		waitElement(linkCarrinho, 10).click();
		waitElement(botaoProceedCheckout, 10).click();
		log("Realizou login e acessou novamente o checkout");
	}

	private String obterConfiguracao(String propriedade, String variavelAmbiente) {
		String valor = System.getProperty(propriedade);
		if (valor == null || valor.trim().isEmpty()) {
			valor = System.getenv(variavelAmbiente);
		}
		if (valor == null || valor.trim().isEmpty()) {
			throw new IllegalStateException("Informe " + propriedade + " nas VM options ou a variavel de ambiente " + variavelAmbiente);
		}
		return valor;
	}
}
