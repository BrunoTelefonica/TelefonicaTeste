package br.bcrodrigues.runners;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\rodri\\eclipse-workspace\\CursoCucumber\\src\\test\\resources\\Features\\InserirConta.feature",
				glue = "br.bcrodrigues.steps",
				tags = {"~@ignore"},
				plugin = "pretty",
				monochrome = false,
				snippets = SnippetType.CAMELCASE,
				dryRun = false,    //VALIDA SE TODOS OS MÉTODOS ESTÃO OK, CASO NÃO IRÁ AVISAR, CASO SIM, É SÓ SETAR O VALOR COMO FALSE
				strict = false) 
public class Runner {

}

