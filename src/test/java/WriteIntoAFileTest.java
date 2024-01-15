import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class WriteIntoAFileTest {
    @Test
    void should_write_odd_numbers_into_a_file() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("oddNumbers.txt")) {
            fileOutputStream.write(oddNumbersCreator().getBytes(UTF_8));
        } catch (IOException e) {
            System.out.println("There is a problem working with oddNumbers.txt");
            throw new RuntimeException(e);
        }
    }

    private String oddNumbersCreator() {
        StringBuilder tmp = new StringBuilder();
        for (int number = 1; number < 100; number++) {
            tmp.append(number).append("\n");
        }
        return tmp.toString();
    }
}
