package org.testing.tests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testing.bases.AuthBase;
import org.testing.enity.Post;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(DataProviderRunner.class)
public class PostTest extends AuthBase {

//    private final String POST_TEXT = "Post text";
//    private final Post post = new Post(POST_TEXT);

    private static final String FILE_PATH = "src/test/resources/jsons/post.json";

    @DataProvider
    public static List<List<Post>> postDataProvider() throws ParseException, IOException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(FILE_PATH));
        JSONObject jsonObject = (JSONObject) obj;
        List<String> strings = (List<String>) jsonObject.get("posts");
        List<Post> postList = strings.stream()
                .map(Post::new)
                .collect(Collectors.toList());
        return postList.stream()
                .map(post -> {
                    List<Post> posts = new ArrayList<>();
                    posts.add(post);
                    return posts;
                })
                .collect(Collectors.toList());
    }

    @Test
    @UseDataProvider("postDataProvider")
    public void adding_new_post_test(Post post) throws Exception {
        appManager.getPostHelper().addPost(post);
        boolean isPostLoaded = appManager.getPostHelper().isPostLoaded(post);
        Assert.assertTrue(isPostLoaded);
    }
}
