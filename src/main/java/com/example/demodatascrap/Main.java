package com.example.demodatascrap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(); //크롬 브라우저를 연다
        driver.get("https://place.map.kakao.com/13499817");
        Thread.sleep(1000);

        WebElement webElementReviewMore = driver.findElement(By.xpath("//div[@id='kakaoWrap']/div[@id='kakaoContent']/div[@id='mArticle']/div[@data-viewid = 'comment']/div[@class='evaluation_review']/a[@class='link_more']"));
        webElementReviewMore.sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        while(true) {
            try {
                WebElement elementReviewMore = driver.findElement(By.xpath("//div[@id='kakaoWrap']/div[@id='kakaoContent']/div[@id='mArticle']/div[@data-viewid = 'comment']/div[@class='evaluation_review']/a[@class='link_more']"));
                elementReviewMore.sendKeys(Keys.ENTER);
                Thread.sleep(1000);
            } catch(org.openqa.selenium.NoSuchElementException e) {
                System.out.println("후기를 전부 펼쳤습니다");
                break;
            }
        }


        List<WebElement> elementTextReview = driver.findElements(By.xpath("//ul[@class = 'list_evaluation']/li"));

        Thread.sleep(1000);

        for (int i = 0; i < 10; i++) {
            System.out.println("리뷰 정답 = " + elementTextReview.get(i).getText());
            Thread.sleep(1000);

        }

        //System.out.println("review.getText() = " + review.getText());
        //System.out.println();
        List<WebElement> elements1 =driver.findElements(By.xpath("//span[@class = 'ico_star star_rate']/span"));
        Thread.sleep(1000);

        System.out.println("elements1.size() = " + elements1.size());
        Thread.sleep(1000);


        for (int i = 0; i < 30; i++) {
            System.out.println("elements" + i + " = " +  elements1.get(i).getAttribute("style"));
            Thread.sleep(1000);

        }

    }
}
