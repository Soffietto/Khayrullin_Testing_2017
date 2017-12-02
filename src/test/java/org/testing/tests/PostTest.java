package org.testing.tests;

import org.junit.Assert;
import org.junit.Test;
import org.testing.bases.AuthBase;
import org.testing.enity.Post;

public class PostTest extends AuthBase {

    private final String POST_TEXT = "Post text";
    private final Post post = new Post(POST_TEXT);

    @Test
    public void adding_new_post_test() throws Exception {
        appManager.getPostHelper().addPost(post);
        boolean isPostLoaded = appManager.getPostHelper().isPostLoaded(post);
        Assert.assertTrue(isPostLoaded);
    }
}
