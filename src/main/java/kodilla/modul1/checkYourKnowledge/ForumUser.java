package kodilla.modul1.checkYourKnowledge;

public class ForumUser extends User {
    private String userName;
    private int numberOfPosts;
    private boolean logged;

    public ForumUser(String firstName, String secondName, char sex, int age, String email, String userName, int numberOfPosts, boolean logged) {
        super(firstName, secondName, sex, age, email);
        this.userName = userName;
        this.numberOfPosts = numberOfPosts;
        this.logged = logged;
    }

    public void publishedPost() {
        System.out.println("Your post has successfully posted!");
    }

    public void commentOfPost() {
        System.out.println("You have successfully added a comment of that post");
    }

    public void userIntroduction(ForumUser forumUser) {
        System.out.println("First name: " + getFirstName());
        System.out.println("Second name: " + getSecondName());
        System.out.println("Sex: " + getSex());
        System.out.println("Age: " + getAge());
        System.out.println("Email: " + getEmail());
        System.out.println("Name Of user: " + getNameOfUser());
        System.out.println("Number Of posts: " + getNumberOfPosts());
        System.out.println("Status of log: " + isLogged(logged));
    }

    public String getNameOfUser() {
        return userName;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public String isLogged(boolean logged) {
        if(logged == true) {
            return "Online";
        } else {
            return "Offline";
        }
    }
}
