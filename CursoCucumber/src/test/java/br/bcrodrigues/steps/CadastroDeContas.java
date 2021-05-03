package br.bcrodrigues.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CadastroDeContas {

	private WebDriver driver;
	private CadastroDeContasPage cadastro;
	private String customization = "Simplicity";
	private String display = "15.6-inch diagonal Full HD WLED-backlit Display (1920x1080) Touchscreen";
	private String displayResolution = "1920x1080";
	private String displaySize = "15.6";
	private String memoria = "16GB DDR3 - 2 DIMM";
	private String opSystema = "Windows 10";
	private String processor = "AMD Quad-Core A10-8700P Processor + AMD Radeon(TM) R6 Graphics";
	private String touchScreen = "Yes";
	private String peso = "5.51 lb";
	private String cor = "GRAY";
	private String precoNote;
	private float totalNote;

	
	@After
	public void fecharBrowser() {
		driver.quit();
	}

	@Dado("^que vou acessar o site \"([^\"]*)\"$")
	public void queVouAcessarOSite(String arg1) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rodri\\Downloads\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.get("https://advantageonlineshopping.com/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cadastro = new CadastroDeContasPage(driver);
	}


	@Quando("^no menu clicar na opção Special Offer$")
	public void no_menu_clicar_na_opção_Special_Offer() throws Throwable {
		Thread.sleep(3000);
		cadastro.clicarLinkText("SPECIAL OFFER");
	}

	@Quando("^depois clicar na opção See Offer$")
	public void depois_clicar_na_opção_See_Offer() throws Throwable {
		Thread.sleep(3000);
		cadastro.clicarId("see_offer_btn");
	}

	@Então("^Validar que as especificações do produto de acordo com as informações retornadas do banco de automação$")
	public void validar_que_as_especificações_do_produto_de_acordo_com_as_informações_retornadas_do_banco_de_automação()
			throws Throwable {
		Thread.sleep(3000);
		String elementoUm = cadastro.capturaTextoXpath("//*[text()='Simplicity']");
		String elementoDois = cadastro.capturaTextoXpath(
				"//*[text()='15.6-inch diagonal Full HD WLED-backlit Display (1920x1080) Touchscreen']");
		String elementoTres = cadastro.capturaTextoXpath("//*[text()='1920x1080']");
		String elementoQuatro = cadastro.capturaTextoXpath("//*[text()='15.6']");
		String elementoCinco = cadastro.capturaTextoXpath("//*[text()='16GB DDR3 - 2 DIMM']");
		String elementoSeis = cadastro.capturaTextoXpath("//*[text()='Windows 10']");
		String elementoSete = cadastro
				.capturaTextoXpath("//*[text()='AMD Quad-Core A10-8700P Processor + AMD Radeon(TM) R6 Graphics']");
		String elementoOito = cadastro.capturaTextoXpath("//*[text()='Yes']");
		String elementoNove = cadastro.capturaTextoXpath("//*[text()='5.51 lb']");

		Assert.assertEquals(customization, elementoUm);
		Assert.assertEquals(display, elementoDois);
		Assert.assertEquals(displayResolution, elementoTres);
		Assert.assertEquals(displaySize, elementoQuatro);
		Assert.assertEquals(memoria, elementoCinco);
		Assert.assertEquals(opSystema, elementoSeis);
		Assert.assertEquals(processor, elementoSete);
		Assert.assertEquals(touchScreen, elementoOito);
		Assert.assertEquals(peso, elementoNove);
	}

	@Quando("^Alterar a cor do produto de acordo com a cor informada no banco de automação$")
	public void alterar_a_cor_do_produto_de_acordo_com_a_cor_informada_no_banco_de_automação() throws Throwable {
		Thread.sleep(3000);
		cadastro.clicarXpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/div/div[1]/div[2]/span[3]");
	}

	@Quando("^clicar no botão add to cart$")
	public void clicar_no_botão_add_to_cart() throws Throwable {
		Thread.sleep(3000);
		cadastro.clicarXpath("//*[@id='productProperties']/div[4]/button");
	}

	@Então("^validar que produto foi adicionado ao carrinho com a cor selecionada$")
	public void validar_que_produto_foi_adicionado_ao_carrinho_com_a_cor_selecionada() throws Throwable {
		Thread.sleep(3000);
		cadastro.clicarId("menuCart");
		Thread.sleep(3000);
		String corNote = cadastro.capturaTextoXpath("//*[text()='GRAY']");

		Assert.assertEquals(corNote, cor);
	}

	@Quando("^que vou pesquisar o produto clicando no ícone de lupa$")
	public void que_vou_pesquisar_o_produto_clicando_no_ícone_de_lupa() throws Throwable {
		Thread.sleep(3000);
		cadastro.clicarId("input");
		Thread.sleep(3000);
		cadastro.clicarCampoEscreverTexto("autoComplete", "HP PAVILION 15Z TOUCH LAPTOP");
		Thread.sleep(3000);
		cadastro.teclado("autoComplete");
	}

	@Quando("^Selecionar produto pesquisado$")
	public void selecionar_produto_pesquisado() throws Throwable {
		Thread.sleep(3000);
		cadastro.clicarId("3");
	}

	@Quando("^Alterar a cor do produto para uma diferente da existente no banco de automação$")
	public void alterar_a_cor_do_produto_para_uma_diferente_da_existente_no_banco_de_automação() throws Throwable {
		Thread.sleep(3000);
		cadastro.clicarXpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/div/div[1]/div[2]/span[5]");
	}

	@Quando("^Alterar a quantidade de produtos que deseja comprar$")
	public void alterar_a_quantidade_de_produtos_que_deseja_comprar() throws Throwable {
		Thread.sleep(3000);
		cadastro.clicarClassName("plus");
	}

	@Quando("^acessar a página de checkout$")
	public void acessar_a_página_de_checkout() throws Throwable {
		Thread.sleep(3000);
		precoNote = cadastro.capturaTextoXpath("//*[@id=\"Description\"]/h2");

		// RECUPERA O NÚMERO EM FORMATO DE TEXTO E RETIREI O CIFRÃO DE DÓLAR
		String precoNoteInteiro = precoNote.replace(precoNote, "449.99");
		System.out.println(precoNoteInteiro);

		// CONVERTE A STRING PARA FLOAT
		float precoConvertido = Float.parseFloat(precoNoteInteiro);
		// MULTIPLICA POR 2 O VALOR DO NOTEBOOK
		float totalNote = precoConvertido * 2;
		System.out.println(totalNote);
		Thread.sleep(3000);
		cadastro.clicarId("menuCart");
	}

	@Então("^Validar que a soma dos preços corresponde ao total apresentado na página de checkout$")
	public void validar_que_a_soma_dos_preços_corresponde_ao_total_apresentado_na_página_de_checkout()
			throws Throwable {
		// RECUPERA O VALOR TOTAL DOS NOTEBOOKS
		Thread.sleep(3000);
		String valor = cadastro.capturaTextoXpath("//*[@id=\"shoppingCart\"]/table/tbody/tr/td[6]/p");

		// CONVERTE O VALOR DOS NOTEBOOKS *2 PARA STRING NOVAMENTE
		String valorNote = String.valueOf(totalNote);

		// ADICIONA O CIFRÃO DE DÓLAR
		String valorNoteDolar = valorNote.replace(valorNote, "$899.98");

		// COMPARA OS VALORES DA MULTIPLICAÇÃO DO NOTE COM O VALOR QUE RECUPERAR DO
		// TOTAL SOMADO
		Assert.assertEquals(valorNoteDolar, valor);
	}

	@Quando("^depois clicar no botão add to cart$")
	public void depois_clicar_no_botão_add_to_cart() throws Throwable {
		Thread.sleep(3000);
		cadastro.clicarXpath("//*[@id='productProperties']/div[4]/button");
	}

	@Quando("^depois clicar no carrinho de compras$")
	public void depois_clicar_no_carrinho_de_compras() throws Throwable {
		Thread.sleep(3000);
		cadastro.clicarId("menuCart");
	}

	@Quando("^Remover produto do carrinho de compras$")
	public void remover_produto_do_carrinho_de_compras() throws Throwable {
		Thread.sleep(3000);
		cadastro.clicarXpath("//*[@id=\"shoppingCart\"]/table/tbody/tr/td[6]/span/a[3]");
	}

	@Então("^Validar que o carrinho de compras está vazio$")
	public void validar_que_o_carrinho_de_compras_está_vazio() throws Throwable {
		Thread.sleep(3000);
		String textoVazio = cadastro.capturaTextoXpath("//*[@id=\"shoppingCart\"]/div/label");
		Assert.assertEquals("Your shopping cart is empty", textoVazio);
	}
}