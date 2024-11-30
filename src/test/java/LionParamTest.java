import com.example.Feline;
import com.example.Lion;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import static org.hamcrest.CoreMatchers.equalTo;


@RunWith(Parameterized.class)
public class LionParamTest {
    @Mock
    Feline feline;

    private final String sex;
    private final boolean hasMane;

    public LionParamTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "Lion. Пол: {0}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeCorrectTest() throws Exception {
        MatcherAssert.assertThat("Грива есть только у льва",
                new Lion(this.sex, feline).doesHaveMane(),
                equalTo(hasMane)
        );
    }
}
