package org.testing.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testing.AppManager;
import org.testing.bases.HelperBase;
import org.testing.enity.Post;

import java.util.List;

public class PostHelper extends HelperBase {
    public PostHelper(AppManager appManager) {
        super(appManager);
    }

    public void addPost(Post post) throws InterruptedException {
        String text = post.getText();
        sleep();
        driver.findElement(By.id("text")).clear();
        driver.findElement(By.id("text")).sendKeys(text);
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    }

    public boolean isPostLoaded(Post post) throws InterruptedException {
        String text = post.getText();
        sleep();
        List<WebElement> elements = driver.findElements(By.id("post_text"));
        return elements.get(elements.size() - 1).getText().equals(text);
    }
}
