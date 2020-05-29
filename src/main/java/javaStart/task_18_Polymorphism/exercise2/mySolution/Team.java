package javaStart.task_18_Polymorphism.exercise2.mySolution;

public class Team {
    private String name;
    private static final int MAX_CHARACTER = 10;
    private GameCharacter[] characters = new GameCharacter[MAX_CHARACTER];
    private int numberCharacters = 0;

    public Team(String name) {
        this.name = name;
    }

    public Team() {
    }

    public String getName() {
        return name;
    }

    GameCharacter[] addCharacter(GameCharacter gameCharacter) {
        if (numberCharacters < MAX_CHARACTER) {
            characters[numberCharacters] = gameCharacter;
            numberCharacters++;
        }
        return characters;
    }

    String getInfo() {
        String info = "";
        if (numberCharacters == 0) {
            System.out.println("There is no characters");
        } else {
            for (int i = 0; i < numberCharacters ; i++) {
                info = info + characters[i].getInfo() + "\n";
            }
        }
        return info;
    }
}
