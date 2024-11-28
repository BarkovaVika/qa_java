import com.example.Animal;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class AnimalParamTest {
    private final String animalKind;
    private final List<String> expectedListFood;

    public AnimalParamTest(String animalKind, List<String> expectedListFood) {
        this.animalKind = animalKind;
        this.expectedListFood = expectedListFood;
    }

    @Parameterized.Parameters(name = "Animal. Тип животного: {0}")
    public static Object[][] setParamsForTest() {
        return new Object[][] {
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Травоядное", List.of("Трава", "Различные растения")}
        };
    }

    @Test
    public void getFoodCorrect() throws Exception {
        MatcherAssert.assertThat("Неправильный набор еды",
                new Animal().getFood(animalKind),
                equalTo(this.expectedListFood)
        );
    }

}
