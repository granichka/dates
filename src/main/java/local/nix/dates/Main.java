package local.nix.dates;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        LocalDateTime date1 = LocalDateTime.of(2020, Month.JULY, 20, 12, 1, 20);

        LocalDateTime date2 = LocalDateTime.of(2020, Month.JUNE, 5, 17, 30, 40);

        LocalDateTime date3 = LocalDateTime.of(2020, Month.MARCH, 18, 9, 15, 05);

        LocalDateTime date4 = LocalDateTime.of(2020, Month.MARCH, 18, 15, 25, 45);

        List<LocalDateTime> list = new ArrayList<>(Arrays.asList(date1, date2, date3, date4));

        System.out.println("Исходные данные:");

        System.out.println(list);

        System.out.println("1. Для списка объектов типа LocalDateTime вернуть ассоциативный массив (Map) LocalDate -> Set<LocalTime>, \n" +
                  "сгруппировав дату/время по дате. Записи в map отсортировать по порядку дат.");

        Map<LocalDate, Set<LocalTime>> map =
                list.stream()
                        .collect(Collectors.groupingBy(LocalDateTime::toLocalDate, TreeMap::new ,Collectors.mapping(LocalDateTime::toLocalTime, Collectors.toSet())));

        System.out.println("Результат решения первой задачи:");
        System.out.println(map);

        System.out.println("2. Дан список дат (LocalDateTime). Найти наибольшее расстояние (Duration) между двумя датами.");

        TreeSet<Duration> treeSet = new TreeSet<>();

        list.stream().forEach(s -> {

            int i = list.indexOf(s);
            for(int j = i + 1; j < list.size(); j++) {
                treeSet.add(Duration.between(s, list.get(j)));
            }
        });

        System.out.println("Результат решения второй задачи:");

        System.out.println(treeSet.first());


    }
}
