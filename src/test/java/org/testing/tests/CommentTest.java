package org.testing.tests;

import org.junit.Assert;
import org.junit.Test;
import org.testing.bases.AuthBase;
import org.testing.enity.Comment;

public class CommentTest extends AuthBase {

    private final String COMMENT_TEXT = "Comment text";
    private final Comment comment = new Comment(COMMENT_TEXT);

    @Test
    public void adding_new_comment_test() throws Exception {
        appManager.getCommentHelper().addCommentToPost(comment);
        boolean isCommentLoaded = appManager.getCommentHelper().isCommentOnThePage(comment);
        Assert.assertTrue(isCommentLoaded);
    }
}
