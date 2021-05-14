import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void main() {
        Main main = new Main();
        Assert.assertEquals(1, main.get());
    }
}