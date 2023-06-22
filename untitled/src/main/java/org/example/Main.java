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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashMap;

//HOMEWORK1
public class HomeWork1 {
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

//HOMEWORK2
public class homeWork2 {
    //    Дана строка sql-запроса "select * from students where ".
//    Сформируйте часть WHERE этого запроса, используя StringBuilder.
//    Данные для фильтрации приведены ниже в виде json-строки.
//    Если значение null, то параметр не должен попадать в запрос.
//    Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//    В итоге должно получится select * from students where name=Ivanov, country=Russia, city=Moscow, age=null
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("select * from students where");
        String filter = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String filter1  = filter.replace("\"", "")
                .replace("{","").replace("}","")
                .replace(":","=");
        str = new StringBuilder(str + " " + filter1);
        String finishtext2 = str.toString();
        if(finishtext2.contains("age=null")) finishtext2 = finishtext2.replace(", age=null","");
        if(finishtext2.contains("name=null")) finishtext2 = finishtext2.replace(", name=null","");
        if(finishtext2.contains("country=null")) finishtext2 = finishtext2.replace(", country=null","");
        if(finishtext2.contains("city=null")) finishtext2 = finishtext2.replace(", city=null","");

        System.out.println(finishtext2);
    }
}

//HOMEWORK3

public class HomeWork3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Random().nextInt(20));
        }
        System.out.println(list);
        ArrayList<Integer> tempList = new ArrayList<>();
        for (Integer number : list) {
            if (number % 2 != 0) {
                tempList.add(number);
            }
        }
        list = tempList;

        System.out.println(list);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        int min = list.get(0);
        int max = list.get(list.size()-1);
        double middle = 0;

        for (int i = 0; i < list.size(); i++) {
            middle = (middle + list.get(i));
        }
        middle = middle/list.size();
        System.out.println(min+" |" + max + " |"+ middle);
    }
}

//HOMEWORK4

public class HomeWork4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            list.add(input);
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = Integer.parseInt(o2.split(" ")[3]) - Integer.parseInt(o1.split(" ")[3]);
                return result;
            }
        });
        for (String personInfo : list) {
            String[] parts = personInfo.split(" ");
            String lastName = parts[0];
            String firstName = parts[1];
            String middleName = parts[2];
            int age = Integer.parseInt(parts[3]);
            String gender = parts[4];

            String initials = firstName.charAt(0) + ". " + middleName.charAt(0) + ". ";
            String formattedInfo = lastName + " " + initials + age + " " + gender;
            System.out.println(formattedInfo);
        }
    }
}

//HOMEWORK5

public class HomeWork5 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(95287779, "Sergey");
        map.put(95287729, "Sergo");
        map.put(95287739, "Sergey");
        map.put(95287589, "Ivan");
        map.put(95247789, "Oleg");


        HashMap<String, Integer> map2 = new HashMap<>();

        for (Integer phoneNumber : map.keySet()) {
            String name = map.get(phoneNumber);
            map2.put(name, map2.getOrDefault(name, 0) + 1);
        }

        ArrayList<String> list = new ArrayList<>(map2.keySet());
        Collections.sort(list, (name1, name2) -> map2.get(name2) - map2.get(name1));

        for (String name : list) {
            int phoneCount = map2.get(name);
            System.out.println(name + ": " + phoneCount);
        }
    }
}





