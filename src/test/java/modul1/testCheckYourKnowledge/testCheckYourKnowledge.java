package modul1.testCheckYourKnowledge;

import kodilla.modul1.checkYourKnowledge.ForumUser;
import org.junit.Test;

public class testCheckYourKnowledge {
    @Test
    public void displayingForumUser() {
        //Given - Arrange
        ForumUser forumUser1 = new ForumUser("David", "Line",'M', 30,
                "david.line@gmail.com","dave", 12, true);

        //When - Act
        forumUser1.logging();
        forumUser1.userIntroduction(forumUser1);
        forumUser1.publishedPost();
        forumUser1.commentOfPost();
        forumUser1.deleteAccount();
    }
}
