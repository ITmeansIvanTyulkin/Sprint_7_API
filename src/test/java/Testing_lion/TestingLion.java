package Testing_lion;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class TestingLion {
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    private final String sex;
    private final boolean hasMane;

    @Mock
    Feline feline;

    public TestingLion(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    // Проверка наличия гривы.
    @Test
    public void maleHasManeButFemaleHasNoMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", hasMane, lion.doesHaveMane());
    }

    // Проверка, что метод вызывается.
    @Test
    public void getKittensTest() {
        Lion lion = new Lion(feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    // Проверка на возврат стаба.
    @Test
    public void lionHasCorrectNumberOfKittens() throws Exception {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    // // Проверка, что лев - хищник.
    @Test
    public void lionFeedsLikePredator() throws Exception {
        Lion lion = new Lion(feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        Assert.assertEquals("Лев питается не как хищник", expected, lion.getFood());
    }
}