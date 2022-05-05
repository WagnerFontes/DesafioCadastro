package br.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Page.CriarContaPage;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CriarContaSteps {

	private static WebDriver driver;
	private CriarContaPage page;

	// Cenario: Cadastro com sucesso

	@Dado("que o cliente opte por fazer o cadastro")
	public void queOClienteOptePorFazerOCadastro() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\WAGNER\\Documents\\CURSOS JAVA\\chrome_driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		page = new CriarContaPage(driver);

	}

	@Quando("escrever um e-mail valido")
	public void escreverUmEMailValido() {
		page.setEmail("messy.test@gmail.com");
		Assert.assertEquals("messy.test@gmail.com", driver.findElement(By.id("email_create")).getAttribute("value"));
	}

	@E("clicar no botao Crie a sua conta aqui")
	public void clicarNoBotaoCrieASuaContaAqui() {
		page.setBotãoCriarConta();
	}

	@Entao("deve apesenta a tela para o preenchimento das Suas informacoes pessoais")
	public void deveApesentaATelaParaOPreenchimentoDasSuasInformacoesPessoais() throws InterruptedException {
		Assert.assertEquals("CREATE AN ACCOUNT", driver.findElement(By.className("page-subheading")).getText());
		Thread.sleep(5000);
	}

	@Quando("preecher todos os campos com sucesso")
	public void preecherTodosOsCamposComSucesso() {
		// Selecionando o botão checkbox Senhor
		page.setBotãoSenhor();
		Assert.assertTrue(driver.findElement(By.id("id_gender1")).isSelected());

		// Campo nome
		page.setNome("fulano");
		Assert.assertEquals("fulano", driver.findElement(By.id("customer_firstname")).getAttribute("value"));

		// Sobrenome
		page.setSobrenome("beutrano");
		Assert.assertEquals("beutrano", driver.findElement(By.id("customer_lastname")).getAttribute("value"));

		// Email
		Assert.assertEquals("messy.test@gmail.com", driver.findElement(By.id("email")).getAttribute("value"));

		// Senha
		page.setSenha("8Va@sd5rd@!e6Ne");
		Assert.assertEquals("8Va@sd5rd@!e6Ne", driver.findElement(By.id("passwd")).getAttribute("value"));

		// Data de nascimento
		// Dia
		page.setDia();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"days\"]/option[8]")).isSelected());

		// Mes
		page.setMes();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"months\"]/option[8]")).isSelected());

		// Ano
		page.setAno();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"years\"]/option[17]")).isSelected());

		// Checklist Assine a nossa newsletter!
		driver.findElement(By.id("newsletter")).click();
		Assert.assertTrue(driver.findElement(By.id("newsletter")).isSelected());

		// Checklist Receba ofertas especiais de nossos parceiros!
		driver.findElement(By.id("uniform-optin")).click();
		Assert.assertTrue(driver.findElement(By.id("uniform-optin")).isSelected());

		// Endereço campo Nome
		page.setNome2("fulano");
		Assert.assertEquals("fulano", driver.findElement(By.id("firstname")).getAttribute("value"));

		// Sobrenome
		page.setSobrenome2("beutrano");
		Assert.assertEquals("beutrano", driver.findElement(By.id("lastname")).getAttribute("value"));

		// Companhia
		page.setCompanhia("Teste teste");

		// Endereço
		page.setEndereço("Rua do meio");
		Assert.assertEquals("Rua do meio", driver.findElement(By.id("address1")).getAttribute("value"));

		// Cidade
		page.setCidade("Cidade do lado");
		Assert.assertEquals("Cidade do lado", driver.findElement(By.id("city")).getAttribute("value"));

		// Estado
		page.setEstado();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"id_state\"]/option[3]")).isSelected());

		// CEP
		page.setCep("00000");
		Assert.assertEquals("00000", driver.findElement(By.id("postcode")).getAttribute("value"));

		// País
		page.setPaís();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\\\"id_country\\\"]/option[2]")).isSelected());

		// Informação adicional
		page.setInfoemação("Teste Automação");
		Assert.assertEquals("Teste Automação", driver.findElement(By.id("other")).getAttribute("value"));

		// Telefone residencial
		page.setTelefone("123456789");
		Assert.assertEquals("123456789", driver.findElement(By.id("phone")).getAttribute("value"));

		// Telefone Celular
		page.setCelular("987654321");
		Assert.assertEquals("987654321", driver.findElement(By.id("phone_mobile")).getAttribute("value"));

		// Endereço alternativo
		page.setEndereço2("rua do lado");
		Assert.assertEquals("rua do lado", driver.findElement(By.id("alias")).getAttribute("value"));
	}

	@Quando("clicar no botao Registro")
	public void clicarNoBotaoRegistro() {
		page.setBotãoRegistro();

	}

	@Entao("apesenta a tela de boas-vindas")
	public void apesentaATelaDeBoasVindas() {
		Assert.assertEquals("Minha conta",
				driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/font/font")).getText());
	}

	// Cenario: Deve preencher um e-mail invalido

	@Dado("que o cliente digitou um e-mail invalido")
	public void queOClienteDigitouUmEMailInvalido() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\WAGNER\\Documents\\CURSOS JAVA\\chrome_driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		page = new CriarContaPage(driver);

		page.setEmailInvalido("email");
		Assert.assertEquals("email", driver.findElement(By.id("email_create")).getAttribute("value"));
	}

	@Quando("clicar no botao, Crie a sua conta aqui")
	public void clicaNoBotaoCrieASuaContaAqui() {
		page.setBotãoCriarContaAqui();
	}

	@Entao("deve apesenta a mensagem de alerta, X endereco de e-mail invalido")
	public void deveApesentaAMensagemDeAlertaXEnderecoDeEMailInvalido() {
		Assert.assertEquals("Invalid email address.", driver.findElement(By.id("create_account_error")).getText());

	}

	// Cenario: registrar conta com sucesso

	@Dado("que o cliente esteja na tela de Autenticacao")
	public void queOClienteEstejaNaTelaDeAutenticacao() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\WAGNER\\Documents\\CURSOS JAVA\\chrome_driver\\chromedriver.exe");
		driver = new ChromeDriver();
		page = new CriarContaPage(driver);
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		Assert.assertEquals("AUTHENTICATION", driver.findElement(By.xpath("//h1[@class='page-heading']")).getText());
	}

	@E("preecheu um email valido")
	public void preecheuUmEmailValido() {
		page.setEmail("messy.test@gmail.com");
		Assert.assertEquals("messy.test@gmail.com", driver.findElement(By.id("email_create")).getAttribute("value"));
	}

	@Entao("deve aparecer o fomulario para preecher seas informacoes perssoais")
	public void deveAparecerOFomularioParaPreecherSeasInformacoesPerssoais() {
		Assert.assertEquals("CREATE AN ACCOUNT", driver.findElement(By.className("page-subheading")).getText());
	}

	@Quando("ele clicar no botao Registro sem preecher seus dados")
	public void eleClicarNoBotaoRegistroSemPreecherSeusDados() throws InterruptedException {
		Thread.sleep(5000);
		page.setBotãoRegistro();
		Thread.sleep(3000);
		driver.quit();
	}

	@Entao("deve apesenta no inicio da tela um quadro na cor vermelha, contendo as informacoes obrigatorias que devem ser preenchidos")
	public void deveApesentaNoInicioDaTelaUmQuadroNaCorVermelhaContendoAsInformacoesObrigatoriasQueDevemSerPreenchidos() {
		Assert.assertEquals(
				"You must register at least one phone number.\n" + "lastname is required.\n"
						+ "firstname is required.\n" + "passwd is required.\n" + "address1 is required.\n"
						+ "city is required.\n"
						+ "The Zip/Postal code you've entered is invalid. It must follow this format: 00000\n"
						+ "This country requires you to choose a State.",
				driver.findElement(By.tagName("ol")).getText());
	}

	// Cenario: Login com sucesso
	@Dado("que o cliente digitou o e-mail cadastrado")
	public void queOClienteDigitouOEMailCadastrado() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\WAGNER\\Documents\\CURSOS JAVA\\chrome_driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		page = new CriarContaPage(driver);
		page.setEmailLogin("messyteste@gmail.com");
		Assert.assertEquals("messyteste@gmail.com", driver.findElement(By.id("email")).getAttribute("value"));
	}

	@E("a Senha")
	public void aSenha() throws InterruptedException {
		page.setSenha("Dkz!Q6MLyd$9A@@");
		Assert.assertEquals("Dkz!Q6MLyd$9A@@", driver.findElement(By.id("passwd")).getAttribute("value"));

	}

	@Quando("clicar no botao entrar")
	public void clicarNoBotaoEntrar() {
		page.setBotãoEntrar();

	}

	@Entao("deve apesentar a tela de boas-vindas")
	public void deveApesentarATelaDeBoasVindas() {
		Assert.assertEquals("MY ACCOUNT", driver.findElement(By.tagName("h1")).getText());
		driver.quit();
	}

}
