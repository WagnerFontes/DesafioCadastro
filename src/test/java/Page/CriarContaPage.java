package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.steps.CriarContaSteps;

public class CriarContaPage extends CriarContaSteps {
	private static WebDriver driver;

	public CriarContaPage(WebDriver driver) {
	
		super();
		this.driver = driver;
	}

	public void setEmail(String email) {
		driver.findElement(By.id("email_create")).sendKeys(email);

	}

	public void setBot�oCriarConta() {
		driver.findElement(By.id("SubmitCreate")).click();

	}

	public void setBot�oSenhor() {
		driver.findElement(By.id("id_gender1")).click();

	}

	public void setNome(String nome) {
		driver.findElement(By.id("customer_firstname")).click();

	}

	public void setSobrenome(String sobrenome) {
		driver.findElement(By.id("customer_firstname")).sendKeys(sobrenome);

	}

	public void setSenha(String senha) {
		driver.findElement(By.id("passwd")).sendKeys(senha);

	}

	public void setDia() {
		driver.findElement(By.xpath("//*[@id='days']/option[8]")).click();

	}

	public void setMes() {
		driver.findElement(By.xpath("//*[@id='months']/option[8]")).click();

	}

	public void setAno() {
		driver.findElement(By.xpath("//*[@id='years']/option[17]")).click();

	}

	public void setBot�oAssine() {
		driver.findElement(By.id("newsletter")).click();

	}

	public void setBot�oReceba() {
		driver.findElement(By.id("uniform-optin")).click();

	}

	public void setNome2(String nome2) {
		driver.findElement(By.id("firstname")).sendKeys(nome2);

	}

	public void setSobrenome2(String sobrenome2) {
		driver.findElement(By.id("lastname")).sendKeys(sobrenome2);

	}

	public void setCompanhia(String companhia) {
		driver.findElement(By.id("company")).sendKeys(companhia);

	}

	public void setEndere�o(String endere�o) {
		driver.findElement(By.id("address1")).sendKeys(endere�o);

	}

	public void setCidade(String cidade) {
		driver.findElement(By.id("city")).sendKeys(cidade);

	}

	public void setEstado() {
		driver.findElement(By.xpath("//*[@id=\"id_state\"]/option[3]")).click();

	}

	public void setCep(String cep) {
		driver.findElement(By.id("postcode")).sendKeys(cep);

	}

	public void setPa�s() {
		driver.findElement(By.xpath("//*[@id=\"id_country\"]/option[2]")).click();

	}

	public void setInfoema��o(String informa��o) {
		driver.findElement(By.id("other")).sendKeys(informa��o);
	}

	public void setTelefone(String telefone) {
		driver.findElement(By.id("phone")).sendKeys(telefone);

	}

	public void setCelular(String celular) {
		driver.findElement(By.id("phone_mobile")).sendKeys(celular);

	}

	public void setEndere�o2(String endere�o2) {
		driver.findElement(By.id("alias")).sendKeys(endere�o2);

	}

	public void setBot�oRegistro() {
		driver.findElement(By.id("submitAccount")).click();

	}

	public void setBot�oCriarContaAqui() {
		driver.findElement(By.id("SubmitCreate")).click();

	}

	public void setEmailInvalido(String emailInvalido) {
		driver.findElement(By.id("email_create")).sendKeys(emailInvalido);;

	}

	public void setEmailLogin(String emaillogin) {
		driver.findElement(By.id("email")).sendKeys(emaillogin);
		
	}

	public void setSenhaLogin(String senhaLogin) {
		driver.findElement(By.id("passwd")).sendKeys(senhaLogin);
	}

	public void setBot�oEntrar() {
		driver.findElement(By.id("SubmitLogin")).click();

	}
}
