import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SafeInputObjectTest
{
    @Test
    void defaultConstructor()
    {
        SafeInputObject sio = new SafeInputObject();

        //Checks if null
        assertNotNull(sio);
    }

    @Test
    void scannerConstructor()
    {
        Scanner scanner = new Scanner(System.in);

        SafeInputObject sio =
                new SafeInputObject(scanner);

        //Checks if null
        assertNotNull(sio);
    }
}