#language: pt
#encoding: utf-8

#@test
Funcionalidade: Realizar Compra no E-commerce

  Como um comprador
  Quero ver a lista de produtos disponiveis
  Para que eu possa escolher qual devo comprar

  Cenario: Adicionar produto ao carrinho
    Dado que um usuario acessa o site "https://automationexercise.com"
    E pesquisa pelo produto "Blue Top"
    Quando adiciona o produto "Blue Top" ao carrinho
    Entao o produto "Blue Top" deve estar presente no carrinho

  #@test
  Cenário: Aumentar a quantidade de produto através da página de detalhes do produto
    Dado que um usuario acessa o site "https://automationexercise.com"
    E pesquisa pelo produto "Winter Top"
    E acessa o produto "Winter Top"
    E aumenta a quantidade produto
    Quando adiciona o produto ao carrinho pela pagina de detalhes
    Entao o produto "Winter Top" deve possuir a quantidade 2
    #Entao o produto "Winter Top" deve estar presente no carrinho

  @test
  Cenario: Realizar compra
    Dado que um usuario acessa o site "https://automationexercise.com"
    E pesquisa pelo produto "Stylish Dress"
    E adiciona o produto "Stylish Dress" ao carrinho
    E acessa o checkout
    E realiza o login
    E confirma o endereco de entrega
    E escolhe a forma de transporte
    Quando o pagamento for confirmado
    Entao deve ser apresentado a mensagem "Your order has been placed successfully!"
