package Lesson1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        RunningAndJumping[] party;
        party = new RunningAndJumping[]{
                new Human(150, 4),
                new Robot(100, 3),
                new Cat(200,5),
                new Human(250,2) };
        Barriers[] course = {
                new Treadmill(50),
                new Wall(1),
                new Wall(2),
                new Treadmill(250)
        };
        for (int i = 0; i < party.length; i++) {
            System.out.println("Забег " + (i + 1) + " участника");
            for (int j = 0; j < course.length; j++) {
                if (course[j] instanceof Treadmill) {
                    if (party[i].getMaxRangeRun() >= course[j].getMaxRange()) {
                        party[i].run();
                        System.out.println((j + 1) + " препятствие");
                    } else {
                        System.out.println((i + 1) + " участник не смог пробежать " + (j + 1) + " препятствие ");
                        break;
                    }
                } else {
                    if (party[i].getMaxRangeJump() >= course[j].getMaxRange()) {
                        party[i].jump();
                        System.out.println((j + 1) + " препятствие");
                    } else {
                        System.out.println((i + 1) + " участник не смог перепрыгнуть " + (j + 1) + " препятствие ");
                        break;
                    }
                }
                if (j == course.length - 1) {
                    System.out.println((i + 1) + " участник прошел всю полосу препятствий!");
                }
            }
            System.out.println("    ");
        }
    }

    private static class Treadmill extends Barriers {
        public Treadmill(int i) {
            super();
        }
    }

    private static class Wall extends Barriers {
        public Wall(int i) {
            super();
        }
    }
}


