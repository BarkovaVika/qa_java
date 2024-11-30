import com.example.Feline;
import com.example.Lion;
import org.hamcrest.MatcherAssert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {


    @Mock
    Feline feline;


    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedCount = 5;
        when(feline.getKittens()).thenReturn(expectedCount);
        MatcherAssert.assertThat("Некорректное количество котят", lion.getKittens(),
                equalTo(expectedCount));
    }

    @Test
    public void doesHaveManeMaleLionTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expectedMane = true;
        boolean actualMane = lion.doesHaveMane();
        assertTrue(String.valueOf(expectedMane), actualMane);
    }


    @Test(expected = Exception.class)
    public void methodThatShouldThrowExceptionTest() throws Exception {
        Lion lion = new Lion("Другое", feline);
        lion.doesHaveMane();
    }

    @Test
    public void getKittensCorrectTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedCount = 5;
        when(feline.getKittens()).thenReturn(expectedCount);

        MatcherAssert.assertThat("Некорректное количество котят",
                lion.getKittens(),
                equalTo(expectedCount)
        );
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedFood = Arrays.asList("Мясо", "Рыба", "Птица");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        MatcherAssert.assertThat(actualFood, equalTo(expectedFood));
    }
}

