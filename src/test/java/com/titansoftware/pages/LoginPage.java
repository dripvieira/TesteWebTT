package com.titansoftware.pages;

import org.openqa.selenium.By;

public class LoginPage {


    By campoUsuarioRegistrado = By.id("strUser");
    By campoSenhaRegistrada = By.id("strPwd");
    By botaoLogon = By.id("logonBtn");

    By msgtOk = By.xpath("//input[@value='Ok']");

    By msgUsuarioLogado = By.xpath("//span[contains(.,'Usuário: ADM')]");


    By getMsgErroLogin = By.id("place4msg");


    public By getCampoUsuarioRegistrado() {
        return campoUsuarioRegistrado;
    }

    public By getCampoSenhaRegistrada() {

        return this.campoSenhaRegistrada;
    }

    public By getBotaoLogon() {
        return botaoLogon;
    }

    public By getMsgtOk() {
        return msgtOk;
    }

    public By getMsgUsuarioLogado() {
        return msgUsuarioLogado;
    }

    public By getGetMsgErroLogin() {
        return getMsgErroLogin;
    }

    By popUp = By.id("dQdPopUpObj2");

    public By getPopUp() {
        return popUp;
    }
}

