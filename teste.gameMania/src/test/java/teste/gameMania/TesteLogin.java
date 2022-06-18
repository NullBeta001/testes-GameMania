package teste.gameMania;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
	
	private WebDriver driver;
	
	@Before
	public void ConfigurarTeste() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://localhost:4200/");
		
		//*[@id="menu"]/a[1] -> XPath do link
		driver.findElement(By.xpath("//*[@id=\"menu\"]/a[1]")).click();
	}
	
	@Test
	public void TestarLogin() {
		
		WebElement campoEmail = driver.findElement(By.id("email"));
		WebElement campoSenha = driver.findElement(By.id("senha"));
		WebElement botao = driver.findElement(By.id("botao-enviar"));
		
		String[] listaEmails = {"pedro@gmail.com", "fabiooliveira@gmail.com", "fabiooliveira@gmail.com"};
		String[] listaSenhas = {"fret312@", "fabio231@", "fabio123@"};
		
		try {
			
			for(int contador = 0; contador < 3; contador++ ) {
				campoEmail.sendKeys(listaEmails[contador]);
				campoSenha.sendKeys(listaSenhas[contador]);
				botao.click();
				
				Thread.sleep(3000);
				
				campoEmail.clear();
				campoSenha.clear();
			}
						
			/*
			//Caso de teste de e-mail incorreto
			campoEmail.sendKeys("pedro@gmail.com");
			campoSenha.sendKeys("fret312@");
			botao.click();
			
			Thread.sleep(3000);
			
			campoEmail.clear();
			campoSenha.clear();
			
			//Caso de teste de senha incorreta
			campoEmail.sendKeys("fabiooliveira@gmail.com");
			campoSenha.sendKeys("fabio231@");
			botao.click();
			
			Thread.sleep(3000);
			
			campoEmail.clear();
			campoSenha.clear();
			
			//Caso de teste usuário e senha correto
			campoEmail.sendKeys("fabiooliveira@gmail.com");
			campoSenha.sendKeys("fabio123@");
			botao.click();
			
			Thread.sleep(5000);
			
			campoEmail.clear();
			campoSenha.clear();
			
			*/
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@After
	public void EncerrarTeste() {
		driver.quit();
	}
}
