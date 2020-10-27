package UDEMY._15_;

import org.testng.Assert;
import org.testng.annotations.Test;
import sun.rmi.transport.StreamRemoteCall;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class test1 {

    // @Test
    public void regular() {
        ArrayList<String> names = new ArrayList<String>();

        names.add("Abhijeet");
        names.add("Don");
        names.add("Alekhya");
        names.add("Adam");
        names.add("Ram");
        int count = 0;

        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if (actual.startsWith("A")) {
                count++;
            }


        }

        System.out.println(count);

    }


    public static void main(String[] args) {


        ArrayList<String> names = new ArrayList<String>();

        names.add("Abhijeet");
        names.add("Don");
        names.add("Alekhya");
        names.add("Adam");
        names.add("Ram");

        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);

        long d = Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Ram").filter(s ->

        {
            return s.startsWith("A");

        }).count();
        System.out.println(d);

        //names.stream().filter(s -> s.length()>4).forEach(s-> System.out.println(s));
        names.stream().filter(s -> s.length() > 4.).limit(1).forEach(s -> System.out.println(s));

        System.out.println("===============================================");

        //MAP

        ArrayList<String> names2 = new ArrayList<String>();

        names2.add("man");
        names2.add("Don");
        names2.add("women");


        Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));
        System.out.println("===============================================");
        List<String> name1 = Arrays.asList("Azbhijeet", "Don", "Alekhya", "Adam", "Ram");
        name1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        Stream<String> newStream = Stream.concat(names2.stream(), name1.stream());
        //   newStream.sorted().forEach(s -> System.out.println(s));

        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Adam"));
        System.out.println(flag);
        Assert.assertTrue(flag);


        System.out.println("==============Collectors==================");

        List<String> ls = Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(ls.get(0));




        List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);

        values.stream().distinct().forEach(s-> System.out.println(s));
        System.out.println("********");
      List<Integer> li=  values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));

    }


}
