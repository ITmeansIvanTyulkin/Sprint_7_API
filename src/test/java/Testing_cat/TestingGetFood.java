package Testing_cat;

import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestingGetFood {

    @Mock
    Feline feline;

    @Test
    public void catMustEatMeat() throws Exception {
        Cat cat = new Cat(feline);
        List catEat = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(catEat);
        Assert.assertEquals("Кошка - хищник. Питается мясом (животными, птицей и рыбой)", catEat, cat.getFood());
    }
}