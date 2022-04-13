package com.eventoapp.eventoapp.automatizado;



import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    private static  WebDriver driver ;
    private static String baseUrl = "http://localhost:8080";


    public static void  AbrirNavegador() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    public void fecharNavegador() {
        driver.quit();
    }
}
