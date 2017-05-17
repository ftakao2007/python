import static org.junit.Assert.*;
import org.junit.Test;

public class JUnitTest {
        public static int num(){
                return 10;
        }

        @Test
        public void test(){
                assertEquals(10, num());
        }
}
