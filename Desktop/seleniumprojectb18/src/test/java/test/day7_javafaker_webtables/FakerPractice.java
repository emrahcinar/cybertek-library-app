package test.day7_javafaker_webtables;

import com.github.javafaker.Faker;

public class FakerPractice {
    public static void main(String[] args) {
        Faker faker = new Faker();

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        System.out.println("name= "+name);

        String firstName = faker.name().firstName(); // Emory
        System.out.println("firstName= "+firstName);

        String lastName = faker.name().lastName(); // Barton
        System.out.println("lastname= "+lastName);

        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
        System.out.println("streetAdress = "+streetAddress);



    }

}
