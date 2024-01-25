package com.titansoftware.funcs;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginFunc extends BaseTeste {

    LoginPage loginPage = new LoginPage();
    Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void acessarTelaLogin() {
        driver.get("http://192.168.2.253/testeqa/index.php");
    }

    public void realizarLogin(String dadosUsuario, String senha) {
        driver.findElement(loginPage.getCampoUsuarioRegistrado()).sendKeys(dadosUsuario);
        driver.findElement(loginPage.getCampoSenhaRegistrada()).sendKeys(senha);
        driver.findElement(loginPage.getBotaoLogon()).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(loginPage.getMsgtOk()),
                ExpectedConditions.invisibilityOfElementLocated(By.id("carregando_loadObject\" class=\"ui-draggable"))

        ));
        try {
            js.executeScript("document.getElementById('tudo').style.display='none';");
            wait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getPopUp()));
            driver.findElement(loginPage.getMsgtOk()).click();
        } catch (Exception e) {
        }
    }

    public void loginDadosIncorretos(String dadosUsuario, String senha) {
        driver.findElement(loginPage.getCampoUsuarioRegistrado()).sendKeys(dadosUsuario);
        driver.findElement(loginPage.getCampoSenhaRegistrada()).sendKeys(senha);
        driver.findElement(loginPage.getBotaoLogon()).click();
    }

    public String getUsuarioLogado() {
        return driver.findElement(loginPage.getMsgUsuarioLogado()).getText();
    }

    public String getMsgErroLogin() {
        return driver.findElement(loginPage.getGetMsgErroLogin()).getText();
    }
}
