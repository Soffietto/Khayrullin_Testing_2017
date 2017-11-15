package org.testing.helpers;

import org.openqa.selenium.By;
import org.testing.AppManager;
import org.testing.enity.Comment;

public class CommentHelper extends HelperBase {

    public CommentHelper(AppManager appManager) {
        super(appManager);
    }

    public void addCommentToPost(Comment comment) throws InterruptedException {
        String text = comment.getText();
        driver.findElement(By.linkText("Comments")).click();
        sleep();
        driver.findElement(By.id("text")).clear();
        driver.findElement(By.id("text")).sendKeys(text);
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    }
}
