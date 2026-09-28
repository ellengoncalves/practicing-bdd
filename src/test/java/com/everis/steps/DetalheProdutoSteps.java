package com.everis.steps;

import com.everis.pages.DetalheProdutoPage;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;

public class DetalheProdutoSteps {

	@E("^aumenta a quantidade produto$")
	public  void aumentarQuantidadeProduto() {
		DetalheProdutoPage detalheProdutoPage = new DetalheProdutoPage();
		detalheProdutoPage.aumentarQuantidadeProduto();
	}

	@Quando("^adiciona o produto ao carrinho pela pagina de detalhes$")
	public void adicionarProdutoAoCarrinhoPelaPaginaDeDetalhes() {
		DetalheProdutoPage detalheProdutoPage = new DetalheProdutoPage();
		detalheProdutoPage.adicionarProdutoAoCarrinho();
	}
}
