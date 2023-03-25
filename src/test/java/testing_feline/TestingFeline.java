package testing_feline;

import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestingFeline {

    @Mock
    Feline feline = new Feline();

    // Проверка вида животного класса "Хищник".
    @Test
    public void listOfMeatIsCorrect() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, feline.eatMeat());
    }

    // Проверка, что метод вызывается.
    @Test
    public void getFamilyTest() {
        feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();
    }

    // Проверка, что стаб возвращает String.
    @Test
    public void getFamilyTestReturningString() {
        Mockito.when(feline.getFamily()).thenReturn("Кошачьи");
        Assert.assertEquals("Кошачьи", feline.getFamily());
        System.out.println(feline.getFamily());
    }

    // Проверка, что ожидаемый результат соответствует фактическому.
    @Test
    public void belongsToFelineFamily() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        Assert.assertEquals(expected, actual);
    }

    // Проверка, что метод вызывается.
    @Test
    public void getKittensTest() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    // Проверка, что стаб возвращает Int.
    @Test
    public void getKittensReturningInt() {
        int expectedNumber = feline.getKittens();
        int actualNumber = 0;
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    // Проверка счётчика котят.
    @Test
    public void returnedCorrectFixNumberOfKittens() {
        Feline feline = new Feline();
        int expected = feline.getKittens();
        int actual = 1;
        Assert.assertEquals(expected, actual);
    }

    // Проверка ожидаемого результата и фактического.
    @Test
    public void returnedCorrectAnyNumberOfKittens() {
        Feline feline = new Feline();
        int expected = 9;
        int actual = feline.getKittens(9);
        Assert.assertEquals(expected, actual);
    }
}