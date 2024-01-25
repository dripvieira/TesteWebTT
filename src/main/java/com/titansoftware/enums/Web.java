package com.titansoftware.enums;

import com.titansoftware.interfaces.AplicacaoWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public enum Web implements AplicacaoWeb {


    CHROME {
        @Override
        public WebDriver getDriver () {
            return new ChromeDriver();
        }
    }
        ,
        FIREFOX {
            @Override
            public WebDriver getDriver () { return new FirefoxDriver();  }
        }
        ,
        EDGE {
            @Override
            public WebDriver getDriver() {return new EdgeDriver();}
        }
        ,
        EXPLORER {
            @Override
            public WebDriver getDriver() {return new InternetExplorerDriver();}
        }
}
