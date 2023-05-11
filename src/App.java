import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;

class App {

    static void printSeparately(List list) { list.forEach(element -> System.out.println(element)); } 

    static void removeEvens(List<Integer> list) { list.removeIf(number -> number % 2 == 0); }

    static int countOdds(List<Integer> list) { return (int) list.stream().filter(number -> number % 2 != 0).count(); }

    static void printAs(List<String> list) { list.forEach(string ->  {if (string.substring(0, 1).equals("a")) System.out.println(string);}); }

    static void doubleNumbers(List<Integer> list) { 
        List<Integer> newList = list.stream().map(number -> number * 2).collect(Collectors.toList());
        
        list.clear();
        list.addAll(newList);
    }

    List<Integer> square56(List<Integer> nums) { return nums.stream().map(number -> number * number + 10).filter(number -> number % 10 != 5 && number % 10 != 6).collect(Collectors.toList()); }

    static void applyTax(List<Double> doubles) {
        List<Double> newList = doubles.stream().map(number -> (double) Math.round(number * 112) / 100).collect(Collectors.toList());
        
        doubles.clear();
        doubles.addAll(newList);
    }

    static void printSum(List<Integer> nums) { System.out.println(nums.stream().reduce(0, (a, b) -> a + b)); }

    static void printTaxedSum(List<Integer> nums) { System.out.println(Math.round(nums.stream().mapToDouble(n -> (double) n).reduce(.0, (a, b) -> a + b * 1.12) * 100) / 100.0);}

    static int largest(List<Integer> nums) { return nums.stream().max(Integer::compare).get(); }

    static void createButton() {
        JButton button = new JButton("Click here");
        JFrame frame = new JFrame("Button test");
        //window to contain the button
        button.addActionListener(e -> System.out.println("Button clicked!"));
        
        frame.setSize(200, 200);
        //set the size of the container window
        frame.add(button);
        //add button to the window
        frame.setVisible(true);
        //make frame visible
    }

    static class Person {
        String name;
        int age;
        
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return this.name + ", " + this.age;
        }
        
        int getAge() { return this.age; }
    }

    static int oldestAge(List<Person> people) { return people.stream().mapToInt(person -> person.getAge()).max().getAsInt(); }


    public static void main(String[] args) throws Exception {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<String> list = new ArrayList<>(Arrays.asList("hello", "and", "goodbye"));
        List<Double> doubles = new ArrayList<>(Arrays.asList(1.23, 2.09, 3.45));

        List<Person> users = new ArrayList<>();
        users.add(new Person("Sarah", 40));
        users.add(new Person("Peter", 50));
        users.add(new Person("Lucy", 60));
        users.add(new Person("Albert", 20));
        users.add(new Person("Charlie", 30));
    

        printSeparately(nums);
        System.out.println();

        removeEvens(nums);
        printSeparately(nums);
        System.out.println();
        
        System.out.println(countOdds(nums));
        printAs(list);
        System.out.println();

        doubleNumbers(nums);
        printSeparately(nums);
        System.out.println();

        applyTax(doubles);
        printSeparately(doubles);
        System.out.println();

        printSum(nums);
        System.out.println();

        printTaxedSum(nums);
        System.out.println();

        System.out.println(largest(nums));

        // createButton();

        System.out.println(oldestAge(users));
    }
}
