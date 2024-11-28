
    import com.example.Animal;
    import org.junit.Test;
    import static org.junit.Assert.*;
    public class AnimalTest {

        @Test
        public void getFamilyTest() {

            String expectedString = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

            assertEquals("Некорректный перечень семейств", expectedString, new Animal().getFamily());
        }

        @Test
        public void getFoodThrowsExceptionTest() {
            try {
                new Animal().getFood("");

                fail("Ожидалось исключение");
            } catch (Exception e) {

                assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
            }
        }
    }

