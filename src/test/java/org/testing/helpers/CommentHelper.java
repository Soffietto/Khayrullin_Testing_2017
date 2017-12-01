package org.testing.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testing.AppManager;
import org.testing.enity.Comment;

import java.util.List;

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

    public boolean isCommentOnThePage(Comment comment) throws InterruptedException {
        String text = comment.getText();
        sleep();
        List<WebElement> elements = driver.findElements(By.id("comment_text"));
        String lastComment = elements.get(elements.size() - 1).getText().substring(6);
        return lastComment.equals(text);
    }
}
