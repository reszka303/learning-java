package questions.DDiamondProblem_4;

public class DiamondProblem {
    public static void main(String[] args) {
        Character character = new Character();
        character.move();
        Human human = new Character();
        human.move();

    }

    private interface Moveable {
        void move();
    }

    private interface Human extends Moveable {
        @Override
        default void move() {
            System.out.println("Moving Human");
        }
    }

    private interface Robot extends Moveable {
        @Override
        default void move() {
            System.out.println("Moving Robot");
        }
    }

    private interface Robocop extends Human, Robot {
        @Override
        default void move() {
            System.out.println("Moving like Robocop");
        }
    }

    private static class Character implements Human, Robot, Robocop {
        @Override
        public void move() {
            Robocop.super.move();
        }
    }
}
