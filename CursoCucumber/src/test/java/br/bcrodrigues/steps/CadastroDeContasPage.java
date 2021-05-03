package br.bcrodrigues.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CadastroDeContasPage {
	
	private WebDriver driver;

	public CadastroDeContasPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clicarLinkText (String valorLinkText) {
		driver.findElement(By.linkText(valorLinkText)).click();
	}

	public void clicarId (String valorId) {
		driver.findElement(By.id(valorId)).click();
	}
	
	public void clicarXpath (String valorXpath) {
		driver.findElement(By.xpath(valorXpath)).click();;
	}
	
	public void clicarClassName (String valorClassName) {
		driver.findElement(By.className(valorClassName)).click();
	}
	
	public String capturaTextoXpath (String texto) {
		return driver.findElement(By.xpath(texto)).getText(); 
	}
	
	public void clicarCampoEscreverTexto (String campo, String texto) {
		driver.findElement(By.id(campo)).sendKeys(texto);
	}
	
	public void teclado (String teclado) {
		driver.findElement(By.id(teclado)).sendKeys(Keys.ENTER);
	}

}
