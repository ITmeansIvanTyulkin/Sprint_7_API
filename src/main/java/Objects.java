import com.example.Feline;
import com.example.Lion;

public class Objects {

    // Чтобы заменить льва на, например, волка, достаточно вызвать new Wolf().
    public static void main(String[] args) throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline);
    }
}