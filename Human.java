package Lesson1;

public class Human implements RunningAndJumping{

    private int run;
    private  int jump;

    public Human(int i, int i1) {
    }


    @Override
    public void run() {
        System.out.println("Человек пробежал");
        
    }

    @Override
    public void jump() {
        System.out.println("Человек прыгнул");

    }

    @Override
    public int getMaxRangeRun() {
        return 0;
    }

    @Override
    public int getMaxRangeJump() {
        return 0;
    }
}




