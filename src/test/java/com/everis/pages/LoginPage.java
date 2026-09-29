package com.everis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.everis.util.Config;
import com.everis.util.Hooks;
import com.everis.util.Urls;

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

	public LoginPage() {
		PageFactory.initElements(Hooks.getDriver(), this);
	}

	public void realizarLogin() {
		waitElement(linkLogin, 10).click();
		waitElement(campoEmail, 10).sendKeys(obterConfiguracao("automationexercise.email", "AUTOMATION_EXERCISE_EMAIL"));
		waitElement(campoSenha, 10).sendKeys(obterConfiguracao("automationexercise.password", "AUTOMATION_EXERCISE_PASSWORD"));
		waitElement(botaoLogin, 10).click();
		waitElement(textoUsuarioLogado, 10);
		driver.navigate().to(Urls.CHECKOUT);
		log("Realizou login e acessou o checkout");
	}

	private String obterConfiguracao(String propriedade, String variavelAmbiente) {
		return Config.obter(propriedade, variavelAmbiente);
	}
}
