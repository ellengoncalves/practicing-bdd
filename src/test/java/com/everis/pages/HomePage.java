package com.everis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.everis.util.Hooks;

public class HomePage extends BasePage {

	@FindBy(css = "a[href='/products']")
	protected WebElement menuProdutos;

	@FindBy(css = "#search_product")
	protected WebElement campoBusca;
	
	@FindBy(css = "#submit_search")
	protected WebElement botaoLupaBuscar;
	
	public HomePage() {
		PageFactory.initElements(Hooks.getDriver(), this);
	}

	public void pesquisarProduto(String nomeProduto) {
		if (!isElementDisplayed(By.cssSelector("#search_product"))) {
			waitElement(menuProdutos, 10).click();
		}
		waitElement(By.cssSelector("#search_product"), 10).sendKeys(nomeProduto);
		waitElement(botaoLupaBuscar, 10).click();
		log("Pesquisou pelo produto: " + nomeProduto);
	}

}
