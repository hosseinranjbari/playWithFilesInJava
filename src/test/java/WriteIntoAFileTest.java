import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

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

    @Test
    void should_write_even_numbers_into_a_file() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("evenNumbers.txt")) {
            fileOutputStream.write(evenNumbersCreator().getBytes(UTF_8));
        } catch (IOException e) {
            System.out.println("There is a problem working with evenNumbers.txt");
            throw new RuntimeException(e);
        }
    }

    @Test
    void should_read_from_a_file() {
        try (FileInputStream fileInputStream = new FileInputStream("evenNumbers.txt")) {
            int read;
            while ((read = fileInputStream.read()) != -1) {
                System.out.print(((char) read));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String evenNumbersCreator() {
        StringBuilder evenNumbers = new StringBuilder();
        for (int number = 0; number < 100; number += 2) {
            evenNumbers.append(number).append("\n");
        }
        return evenNumbers.toString();
    }

    private String oddNumbersCreator() {
        StringBuilder tmp = new StringBuilder();
        for (int number = 1; number < 100; number += 2) {
            tmp.append(number).append("\n");
        }
        return tmp.toString();
    }
}
