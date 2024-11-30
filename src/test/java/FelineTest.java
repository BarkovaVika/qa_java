
import com.example.Feline;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;


public class FelineTest {
    @Test
    public void getFamilyCorrectTest() {
        String expectedFelineFamilyName = "Кошачьи";
        MatcherAssert.assertThat("Некорректное название семейства кошачьих",
                new Feline().getFamily(),
                equalTo(expectedFelineFamilyName)
        );
    }

    @Test
    public void getKittensCountCorrectTest() {
        int expectedCount = 7;
        MatcherAssert.assertThat("Не верное количество котят",
                new Feline().getKittens(expectedCount),
                equalTo(expectedCount)
        );
    }

    @Test
    public void getKittensDefaultCorrectTest() {
        int expectedCount = 1;
        MatcherAssert.assertThat("Не верное количество котят",
                new Feline().getKittens(),
                equalTo(expectedCount)
        );
    }

    @Test
    public void eatMeatCorrectTest() throws Exception {
        Feline feline = new Feline();
        MatcherAssert.assertThat("Не верный список еды", feline.eatMeat(),
                equalTo(feline.getFood("Хищник"))
        );

        }

    }

