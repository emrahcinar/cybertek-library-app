package cybertek_test;

import com.github.javafaker.Faker;

public class FakerTest {

    public static void main(String[] args) {

        com.github.javafaker.Faker faker=new com.github.javafaker.Faker();

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.address().cityName());
        System.out.println(faker.animal().name());


    }
}
