package Lesson2;


public class Exception {

    public static void main(String[] args) {

        String[][] arr = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"1", "2", "3", "4"}, {"5", "6", "7", "8"}};
        try {
            try {
                int result = method(arr);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println(" ");
            }
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка в ячейке: " + e.i + "x" + e.j);
        }

    }
    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
            int c = 0;
            if (arr.length != 4) {
                throw new MyArraySizeException("Размер массива превышен!");
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != 4) {
                    throw new MyArraySizeException("Неправильное значение массива!");
                }
                for (int j = 0; j < arr[i].length; j++) {
                    try {
                        c = c + Integer.parseInt(arr[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j);

                    }


                }
            }
            return c;

        }}

