package testing_lion;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestingLionThrowExeption {

    @Mock
    private Feline feline;

    @Test(expected = Exception.class)
    public void lionIncorrectInstance() throws Exception {
        new Lion("SheMale", feline);
    }
}