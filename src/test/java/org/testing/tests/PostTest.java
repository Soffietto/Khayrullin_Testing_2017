package org.testing.tests;

import org.junit.Test;
import org.testing.enity.Post;

public class PostTest extends AuthBase{

    private final String POST_TEXT = "Post text";
    private final Post post = new Post(POST_TEXT);

    @Test
    public void adding_new_post_test() throws Exception {
        appManager.getPostHelper().addPost(post);
    }
}
