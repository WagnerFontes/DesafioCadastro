# language: pt

Funcionalidade: Criar conta
	Como um usuario 
	Eu quero me cadastrar no site
	Para fazer compras no site
	@ignore
Cenario: Cadastro com sucesso 
	Dado que o cliente opte por fazer o cadastro 
	Quando escrever um e-mail valido
	E clicar no botao Crie a sua conta aqui
	Entao deve apesenta a tela para o preenchimento das Suas informacoes pessoais
	Quando preecher todos os campos com sucesso
	E clicar no botao Registro
	Entao apesenta a tela de boas-vindas 
@ignore
Cenario: Deve preencher um e-mail invalido 
	Dado que o cliente digitou um e-mail invalido 
	Quando clicar no botao, Crie a sua conta aqui
	Entao deve apesenta a mensagem de alerta, X endereco de e-mail invalido
	
Cenario: registrar a conta sem preenche o formulario 
  Dado que o cliente esteja na tela de Autenticacao
  E preecheu um email valido
  Quando clicar no botao, Crie a sua conta aqui
  Entao deve aparecer o fomulario para preecher seas informacoes perssoais 
	Quando ele clicar no botao Registro sem preecher seus dados 
	Entao deve apesenta no inicio da tela um quadro na cor vermelha, contendo as informacoes obrigatorias que devem ser preenchidos
	 @ignore
	Cenario: Login com sucesso
	Dado que o cliente digitou o e-mail cadastrado
	E a Senha 
	Quando clicar no botao entrar 
	Entao deve apesentar a tela de boas-vindas 
