package java8stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamQuestionSample {



    public static void main(String[] args) {
        int a[] = {1, 12, 13, 41, 612, 7131, 612, 131, 912, 1131, 142, 1371, 129, 173};
        //  a = IntStream.of(a).sorted().toArray();
        List<Integer> t = Arrays.asList(1, 12, 13, 41, 612, 7131, 612, 131, 912, 1131, 142, 1371, 129, 173);
//     t =   t.stream().sorted().collect(Collectors.toList());
        //   t =   t.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());   // sort in reverse
        //  t =   t.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList()); // top 3 elements
       // t = t.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
   //     printData(t);

        /******************************************************/

        Employee e1 = new Employee("it",  3232,"Aa");
        Employee e2 = new Employee("market",23, "Ha");
        Employee e3 = new Employee("sales", 523,"Ba");
        Employee e4 = new Employee("market",9875, "Da");
        Employee e5 = new Employee("it", 962,"Ca");
        Employee e6 = new Employee( "it", 111,"Ea");
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);

        employees = employees.stream()
                .sorted((o1, o2) -> 0)
                .collect(Collectors.toList());

      /*employees=  employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .collect(Collectors.toList());*/
/*
     employees= employees.stream()
              .sorted(Comparator.comparing(Employee::getDept))
              .collect(Collectors.toList());*/

   /* Map<String,List<Employee>> map = employees.stream()           //  gorup by dept
            .collect(Collectors.groupingBy(Employee::getDept));*/

        /*Optional<Employee> x = employees.stream()       // 3rd height age
                 .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .skip(2)
                .findFirst();
        System.out.println(" third height salary" + x.get());*/


        Map<String, Employee> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)), Optional::get)));
      //  printDataMap(collect);

       /* employees.stream().sorted(Map.Entry.<String,Employee>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry<String,Employee>::getKey,Map.Entry<String,Employee>::getValue,(e,r)->e, LinkedHashMap::new));

        */
        //printData(employees);


        List<Integer> list = Arrays.asList(1, 12, 13, 41, 612, 1, 612, 131, 912, 1131, 142, 1371, 129, 173);
       /* Map<Integer, Long> collect = list.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));*/

      //  collect.entrySet().stream().forEach(key-> System.out.println(key.getKey()+"=> "+key.getValue()));


        Map<String, Long> collect1 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.counting()))
                        .entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                        .collect(Collectors.toMap(Map.Entry<String,Long>::getKey,Map.Entry::getValue,(c,b)-> c, LinkedHashMap::new));


        employees.stream()
                .collect(Collectors.groupingBy(Employee::getName,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),Optional::get)));

        String[] data = new String[]{"kailash"," karki", "test"," data" ,"ishappen"};
        Map<String,Integer> finalItem =  Arrays.stream(data)
                .collect(Collectors.toMap(String::toString,String::length));
//You are given a list of integers. Write a Java 8 stream program to find the second smallest number in the list.
        List<Integer> listsmall = Arrays.asList(1, 12, 13, 41, 612, 11, 612, 131, 912, 1131, 142, 1371, 129, 173);

        Optional<Integer> first = listsmall.stream()
                .sorted()
                .skip(1)
                .findFirst();
        System.out.println(" Second smalles no is "+ first.get());


        //You are given a list of strings. Write a Java 8 stream program to find the most frequently occurring word in the list.
        List<String> freStrig = List.of("kailash","karki", "test","karki" ,"karki","test","karki","karki");
        Map<String, Long> mostfrequency = freStrig.stream()
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(c,b)-> c, LinkedHashMap::new));

        Map.Entry<String, Long> next = mostfrequency.entrySet().iterator().next();
        System.out.println("most frequently occurring word ===> "+next);
    //You are given a list of integers. Write a Java 8 stream program to find the sum of the squares of all the positive numbers in the list.
        List<Integer> sumInt = Arrays.asList(1, -2, 3, 4);


        int reduce = sumInt.stream()
                .filter(e -> e > 0)
                .mapToInt(e -> e * e)
                .reduce(0, (d, b) -> d + b);

        System.out.println("sum of squre "+ reduce);

   // Write a Java 8 stream program to find the number of words in the list that have more than five letters.
        List<String> pStrig = List.of("kailash"," aabaa", "dad"," dalad" ,"kk");
        Optional<String> collect2 = pStrig.stream()
                .filter(e -> e.length() > 0).max(Comparator.comparingInt(e -> e.length()));
        System.out.println(collect2.get());

    }

    public static void printData(int a[]) {
        IntStream.of(a).forEach(System.out::println);
    }
    public static void printData(Map<String,List<Employee>> map) {
        map.entrySet().stream().forEach(key-> System.out.println(key.getKey()+"=> "+key.getValue()));
    }
    public static void printDataMap(Map<String,Employee> map) {
        map.entrySet().stream().forEach(key-> System.out.println(key.getKey()+"=> "+key.getValue()));
    }
    public static void printDataMapInt(Map<String,Integer> map) {
        map.entrySet().stream().forEach(key-> System.out.println(key.getKey()+"=> "+key.getValue()));
    }
    public static void printData(List l) {
        l.forEach(System.out::println);
    }

    public static void printData1(List<Employee> e) {
        e.forEach(System.out::println);
    }
}

