package com.titansoftware.configuration;

import com.titansoftware.common.BaseTeste;
import com.titansoftware.enums.Web;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BaseTeste {

    @Before

    public void beforeTest(){
        super.inicializarDriver(Web.FIREFOX);
    }

    @After
    public void afterTest(Scenario scenario) throws InterruptedException {
        Thread.sleep(2000);
        byte[] Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(Screenshot, "image/png", scenario.getName());
//        driver.findElement(By.id("logout")).click();
      Thread.sleep(2000);
        driver.quit();
    }

}
