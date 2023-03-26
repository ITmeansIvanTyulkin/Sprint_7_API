package testing_feline;

import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestingFeline {

    Feline feline = new Feline();

    @Test
    public void listOfMeatIsCorrect() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void belongsToFelineFamily() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void returnedCorrectFixNumberOfKittens() {
        int expectedNumber = feline.getKittens();
        int actualNumber = 1;
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void returnedCorrectAnyNumberOfKittens() {
        int expected = 9;
        int actual = feline.getKittens(9);
        Assert.assertEquals(expected, actual);
    }
}