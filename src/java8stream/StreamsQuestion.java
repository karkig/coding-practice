   // select employee order by salary for each dept. We can also find 3rd highest salary of each dept
package java8stream;

   import java.util.*;
   import java.util.stream.Collectors;
/*   import java.util.Map;
   import java.util.Optional;
   import java.util.stream.Collectors;

   import static java.util.Comparator.comparingInt;
   import static java.util.stream.Collectors.maxBy;*/

   public class StreamsQuestion{
   public static void main(String[] args) {
      List<Employee> allEmployees = List.of(
              new Employee("Ram",3002,"IT"),
              new Employee("Sita",8373,"IT"),
              new Employee("Josi",9271,"HR"),
              new Employee("Geeta",4203,"HR"),
              new Employee("Panku",2023,"Sales"),
              new Employee("Deep",2994,"IT"));

      Map<String, Employee> collect = allEmployees.stream()
              .collect(Collectors.groupingBy(Employee::getDepartment,
                      Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)), Optional::get)));

      String[] words = {"i", "love", "i", "love", "coding", "love"};

      Map<String, Long> collect1 = Arrays.stream(words).collect(Collectors.groupingBy(e -> e, Collectors.counting()));

      System.out.println(collect1);
   }
}



/*


 */



















/*

  Map<String, Employee> topEmployees =
              allEmployees.stream()
                      .collect(Collectors.groupingBy(
                              Employee::getDepartment,
                              Collectors.collectingAndThen(maxBy(comparingInt(Employee::getSalary)), Optional::get)
                      ));
 */