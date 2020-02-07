package kodilla.modul1.checkYourKnowledge;

public class User {
    private String firstName;
    private String secondName;
    private char sex;
    private int age;
    private String email;

    public User(String firstName, String secondName, char sex, int age, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.sex = sex;
        this.age = age;
        this.email = email;
    }

    public void logging() {
        System.out.println("Logging has successfully been!");
    }

    public void deleteAccount() {
        System.out.println("The account has successfully removed");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public char getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}

