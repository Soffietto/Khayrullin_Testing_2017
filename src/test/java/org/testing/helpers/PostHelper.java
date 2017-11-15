package org.testing.helpers;

import org.openqa.selenium.By;
import org.testing.AppManager;
import org.testing.enity.Post;

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
}
