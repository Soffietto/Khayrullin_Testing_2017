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
import org.testing.enity.Comment;
import org.testing.enity.Post;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(DataProviderRunner.class)
public class CommentTest extends AuthBase {

//    private final String COMMENT_TEXT = "Comment text";
//    private final Comment comment = new Comment(COMMENT_TEXT);

    private static final String FILE_PATH = "src/test/resources/jsons/comment.json";

    @DataProvider
    public static Object[][] commentDataProvider() throws ParseException, IOException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(FILE_PATH));
        JSONObject jsonObject = (JSONObject) obj;
        List<String> strings = (List<String>) jsonObject.get("comments");
        List<Comment> postList = strings.stream()
                .map(Comment::new)
                .collect(Collectors.toList());
        Comment[][] comments = new Comment[postList.size()][1];
        for (int i = 0; i < postList.size(); i++) {
            comments[i][0] = postList.get(i);
        }
        return comments;
    }

    @Test
    @UseDataProvider("commentDataProvider")
    public void adding_new_comment_test(Comment comment) throws Exception {
        appManager.getCommentHelper().addCommentToPost(comment);
        boolean isCommentLoaded = appManager.getCommentHelper().isCommentOnThePage(comment);
        Assert.assertTrue(isCommentLoaded);
    }
}
