package com.titansoftware.common;

import com.titansoftware.interfaces.AplicacaoWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTeste {

    protected static WebDriver driver;
    protected static WebDriverWait wait;



    protected void inicializarDriver(AplicacaoWeb aplicacaoWeb) {
        driver = aplicacaoWeb.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
}

