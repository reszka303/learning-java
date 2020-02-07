package kodilla.modul1.braveKnight;

public class Knight {
    Quest quest;

    public Knight(Quest quest) {
        this.quest = quest;
        this.quest.beginningOfProcess();
        this.quest.process();
    }
}
