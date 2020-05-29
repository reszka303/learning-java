package javaStart.task_18_Polymorphism.exercise2.mySolution;

public class TeamApp {
    public static void main(String[] args) {
        GameCharacter character1 = new Defender(
                "Tomb Guardian",
                50,
                100,
                100,
                0.0);

        GameCharacter character2 = new Attacker(
                "Ghostly Murderer",
                50,
                100,
                100,
                0.0);

        GameCharacter character3 =
                new Defender(
                "Necromatic Minion",
                50,
                100,
                100,
                0.0);

        GameCharacter character4 =
                new Defender(
                "Arachnotron",
                50,
                100,
                100,
                0.0);

        GameCharacter character5 = new Attacker(
                "Hell Knight",
                50,
                100,
                100,
                0.0);

        GameCharacter character6 = new Defender(
                "Revenant",
                50,
                100,
                100,
                0.0);

        Team team1 = new Team("Riders of apocalypse");
        team1.addCharacter(character1);
        team1.addCharacter(character2);
        team1.addCharacter(character3);

        Team team2  = new Team("Legion of doom");
        team2.addCharacter(character4);
        team2.addCharacter(character5);
        team2.addCharacter(character6);

        System.out.println(team1.getName());
        System.out.println(team1.getInfo());
        System.out.println(team2.getName());
        System.out.println(team2.getInfo());



    }
}
