package day01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class Practice2 {

    @Test
    public void test1() {

        //assert 5+4 is 9

        int num1 = 5;
        int num2 = 4;
        //we need these two import for this work
        //import static org.hamcrest.Matchers.*;
        //import static org.hamcrest.MatcherAssert.assertThat;

        //hamcrest library use the assertThat method for all assertions
        //hamcrest use built in matchers to do assertion
        //cpouple common ones are:
              //is(some value)
             //eqaulTo(some value)
             //or optionally is (equalTo(some value))


        assertThat(num1+num2 ,is (9));
        assertThat(num1 + num2, equalTo(9));
        assertThat(num1 + num2, is(equalTo(9)));

        //not(some value)
        //is(not(some value)
        //not(equalTo(some value))
        assertThat(num1+num2 ,not (11));
        assertThat(num1+num2,is(not(11)));
        assertThat(num1 + num2,not( equalTo(11)));


        String name="Emrah ";//there is a space at the end
        String lastname="CINAR";

        assertThat(name+lastname,is("Emrah CINAR"));
       assertThat(name+lastname,equalTo("Emrah CINAR"));
        assertThat(name+lastname,is(equalTo("Emrah CINAR")));

        assertThat(name+lastname,not("EmrahCINAR"));
        assertThat(name+lastname,is(not("EmrahCINAR")));
        assertThat(name+lastname,not(equalTo("EmrahCINAR")));

        //how to check in caseInsensitive manner
        assertThat(name,equalToIgnoringCase("emrah "));

        //how to ignore all whitespaces
        assertThat(name,equalToCompressingWhiteSpace("Emrah"));

    }

    @DisplayName("Support for collection")
    @Test
    public void test2(){

        List<Integer> numList= Arrays.asList(11,44,3,55,88,5);
        //checking the list size is 6
        assertThat(numList,hasSize(6));
        //checking the list contains 114
        assertThat(numList,hasItem(11));
        //checking the list contains more than one items in any order :11,44,55
        assertThat(numList,containsInAnyOrder(11,44,3,55,88,5));
    }
}
