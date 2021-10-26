package Lesson5;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) {
       OneMethod();
       TwoMethod();

        }

    public static void OneMethod(){
        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = 1;}

        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
            System.out.println(System.currentTimeMillis() - a + " ms");

    }

    public static void TwoMethod(){

        for (int i = 0; i < size; i++) {
            arr[i] = 1;}

        long a = System.currentTimeMillis();

        float [] leftHalf = new  float[h];
        float [] rightHalf = new  float[h];

        System.arraycopy(arr, 0, leftHalf, 0, h);
        System.arraycopy(arr, h, rightHalf, 0, h);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                leftHalf[i] = (float)(leftHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                rightHalf[i] = (float)(rightHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(leftHalf, 0, arr, 0, h);
        System.arraycopy(rightHalf, 0, arr, h, h);

        System.out.println(System.currentTimeMillis() - a + " ms");

    }
    }














