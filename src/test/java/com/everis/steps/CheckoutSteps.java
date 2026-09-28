package com.everis.steps;

import com.everis.pages.CarrinhoPage;
import com.everis.pages.CheckoutPage;
import com.everis.pages.LoginPage;
import com.everis.pages.PagamentoPage;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;

public class CheckoutSteps {

	@E("^acessa o checkout$")
	public void acessarCheckout() {
		CarrinhoPage carrinhoPage = new CarrinhoPage();
		carrinhoPage.acessarCheckout();
	}

	@E("^realiza o login$")
	public void realizarLogin() {
		LoginPage loginPage = new LoginPage();
		loginPage.realizarLogin();
	}

	@E("^confirma o endereco de entrega$")
	public void confirmarEnderecoEntrega() {
		CheckoutPage checkoutPage = new CheckoutPage();
		checkoutPage.confirmarEnderecoEntrega();
	}

	@E("^escolhe a forma de transporte$")
	public void escolherFormaDeTransporte() {
		CheckoutPage checkoutPage = new CheckoutPage();
		checkoutPage.escolherFormaDeTransporte();
	}

	@Quando("^o pagamento for confirmado$")
	public void confirmarPagamento() {
		CheckoutPage checkoutPage = new CheckoutPage();
		checkoutPage.acessarPagamento();

		PagamentoPage pagamentoPage = new PagamentoPage();
		pagamentoPage.confirmarPagamento();
	}
}
