//        1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//        2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//        3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
//        4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
//
//        Пункты реализовать в методе main
//        *Пункты реализовать в разных методах
//
//        int i = new Random().nextInt(k); //это кидалка случайных чисел!)


import java.util.Random;

public class Main {


    public static void main(String[] args) {

        int i = new Random().nextInt(2000);
        short maxValue = Short.MAX_VALUE;
        System.out.println(i);
        System.out.print("Highest one bit of the given integer is = ");
        System.out.println(Integer.highestOneBit(i));
        System.out.print("Short.MAX_VALUE = ");
        System.out.println(maxValue);
        System.out.println("All numbers are multiples " + i + " do " + maxValue + " this: ");
        int multiples1 = i;
        while (multiples1 <= maxValue) {
            if (maxValue % multiples1 == 0) {
                System.out.println(multiples1);
            }
            multiples1++;
        }
        short minValue = Short.MIN_VALUE;
        System.out.print("Short.MIN_VALUE = ");
        System.out.println(maxValue);
        System.out.println("All numbers are multiples " + minValue + " do " + i + " this: ");
        while (minValue <= i) {
            if (minValue % i != 0) {
                System.out.println(minValue);
            }
            minValue++;
        }
    }
}







