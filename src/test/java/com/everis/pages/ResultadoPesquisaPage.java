package com.everis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.everis.util.Hooks;

public class ResultadoPesquisaPage extends BasePage {

	@FindBy(xpath = "//a[@href='/view_cart' and contains(., 'View Cart')]")
	protected WebElement botaoVisualizarCarrinho;
	
	public ResultadoPesquisaPage() {
		PageFactory.initElements(Hooks.getDriver(), this);
	}

	public void adicionarProdutoAoCarrinho(String nomeProduto) {
		WebElement nomeProdutoTela = waitElement(By.xpath("//div[contains(@class,'productinfo')]//p[normalize-space()='" + nomeProduto + "']"), 10);
		moveToElement(nomeProdutoTela);
		waitElement(By.xpath("//div[contains(@class,'productinfo')][.//p[normalize-space()='" + nomeProduto + "']]//a[contains(@class,'add-to-cart')]"), 10).click();
		waitElement(botaoVisualizarCarrinho, 10).click();
		log("Adicionou o produto [" + nomeProduto + "] ao carrinho");
	}

	public void acessarProduto(String nomeProduto) {
		WebElement botaoVisualizarProduto = waitElement(By.xpath("//div[contains(@class,'product-image-wrapper')][.//p[normalize-space()='" + nomeProduto + "']]//a[contains(@href,'/product_details/')]"), 10);
		String urlDetalheProduto = botaoVisualizarProduto.getAttribute("href");
		driver.navigate().to(urlDetalheProduto);
		log("Acessou o produto [" + nomeProduto + "]");
	}
}
