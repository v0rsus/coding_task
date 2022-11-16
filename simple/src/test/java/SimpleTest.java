import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleTest
{
    @Test
    void check()
    {
        int i = 1;
        Assertions.assertEquals(1, i);
    }
}
