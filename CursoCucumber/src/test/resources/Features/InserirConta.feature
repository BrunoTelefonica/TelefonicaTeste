#language: pt
Funcionalidade: Cadastro de contas

Como um usuário 
Gostaria de cadastrar contas
Para que eu possa distribuir meu dinheiro de uma forma mais organizada


Cenário: Validar especificações do produto
Dado que vou acessar o site "https://advantageonlineshopping.com"
Quando no menu clicar na opção Special Offer
E depois clicar na opção See Offer
Então Validar que as especificações do produto de acordo com as informações retornadas do banco de automação


Cenário: Validar alteração de cor do produto no carrinho
Dado que vou acessar o site "https://advantageonlineshopping.com"
Quando no menu clicar na opção Special Offer
E depois clicar na opção See Offer
E Alterar a cor do produto de acordo com a cor informada no banco de automação
E clicar no botão add to cart
Então validar que produto foi adicionado ao carrinho com a cor selecionada


Cenário: Validar página de checkout
Dado que vou acessar o site "https://advantageonlineshopping.com"
Quando que vou pesquisar o produto clicando no ícone de lupa
E Selecionar produto pesquisado
E Alterar a cor do produto para uma diferente da existente no banco de automação
E Alterar a quantidade de produtos que deseja comprar
E clicar no botão add to cart
E acessar a página de checkout
Então Validar que a soma dos preços corresponde ao total apresentado na página de checkout


Cenário: Remover produto do carrinho de compras
Dado que vou acessar o site "https://advantageonlineshopping.com"
Quando no menu clicar na opção Special Offer
E depois clicar na opção See Offer
E depois clicar no botão add to cart
E depois clicar no carrinho de compras
E Remover produto do carrinho de compras
Então Validar que o carrinho de compras está vazio
