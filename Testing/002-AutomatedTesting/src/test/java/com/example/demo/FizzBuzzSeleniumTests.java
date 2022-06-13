package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FizzBuzzSeleniumTests {
    List<String> expectedRules = Arrays.asList("If the number is divisible by 3, then we print 'fizz'.",
            "If the number is divisible by 5, then we print 'buzz'.",
            "If the number is divisible by both, we print 'fizzbuzz'.",
            "If a none of the rules apply output the number.");
    @LocalServerPort
    private int port;
    private WebDriver driver;
    private String base;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        this.base = "http://localhost:" + port;
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void testTitle() {
        // Open the webpage
        driver.get(this.base + "/fizzbuzz");
        // Get the title
        String title = driver.getTitle();
        // Check it is what we expect it to be
        assertThat(title).contains("Getting Started: Serving Web Content");
    }

    @Test
    void testRules() {
        // Open the webpage
        driver.get(this.base + "/fizzbuzz");

        // Find the div containing all of the rules
        WebElement rules = driver.findElement(By.id("rules"));

        // Get the children (first level only)
        List<WebElement> children = rules.findElements(By.xpath(".//*[not(*)]")); // Use Xpath to get the first level children

        // Create a list to store the rules
        List<String> actualRules = new ArrayList<String>();
        for (WebElement child : children) {
            // Get the text from each rule and store it in the list
            actualRules.add(child.getText());
        }

        // Check the list contains what we expected
        assertEquals(expectedRules, actualRules);
    }

    @Test
    void InvalidInputTest(){
        driver.get(this.base + "/fizzbuzz");
        WebElement inputBox = driver.findElement(By.id("fbinput"));
        inputBox.sendKeys("qwerty");
        WebElement inputButton = driver.findElement(By.id("button-addon2"));
        inputButton.click();
        WebElement error = driver.findElement(By.id("error-message"));
        String errorMessage = error.getText();
        assertEquals(errorMessage, "Input must be an integer");
    }

    @Test
    void MultipleOfThreeTest(){
        driver.get(this.base + "/fizzbuzz");
        WebElement inputBox = driver.findElement(By.id("fbinput"));
        inputBox.sendKeys("3");
        WebElement inputButton = driver.findElement(By.id("button-addon2"));
        inputButton.click();
        WebElement result = driver.findElement(By.id("result"));
        String resultText = result.getText();
        assertEquals(resultText, "fizz");
    }

    @Test
    void MultipleOfFiveTest(){
        driver.get(this.base + "/fizzbuzz");
        WebElement inputBox = driver.findElement(By.name("fbinput"));
        inputBox.sendKeys("5");
        WebElement inputButton = driver.findElement(By.id("button-addon2"));
        inputButton.click();
        WebElement result = driver.findElement(By.id("result"));
        String resultText = result.getText();
        assertEquals(resultText, "buzz");
    }

    @Test
    void MultipleOfFiveAndThreeTest(){
        driver.get(this.base + "/fizzbuzz");
        WebElement inputBox = driver.findElement(By.name("fbinput"));
        inputBox.sendKeys("15");
        WebElement inputButton = driver.findElement(By.id("button-addon2"));
        inputButton.click();
        WebElement result = driver.findElement(By.id("result"));
        String resultText = result.getText();
        assertEquals(resultText, "fizzbuzz");
    }

    @Test
    void GenerateTest(){
        driver.get(this.base + "/fizzbuzz");
        WebElement generateButton = driver.findElement(By.id("generate"));

//        WebElement inputButton = driver.findElement(By.id("button-addon2"));
//        inputButton.click();
//        WebElement result = driver.findElement(By.id("result"));
//        String resultText = result.getText();

        assertTrue(generateButton.isDisplayed());
    }


}