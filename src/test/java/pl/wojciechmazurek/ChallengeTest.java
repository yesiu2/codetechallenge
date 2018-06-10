package pl.wojciechmazurek;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ChallengeTest {

    public static final String CSV_DATASET_PATH = "dataset.csv";


    @Test
    public void alaMaKotaTest() {

        String result = Challenge.mainMethod(" Aleasa mp i toK");

        assertThat(result).isEqualTo("Kot ma Ale i psa");
    }

    @Test
    public void testingChallengeClass() {

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_DATASET_PATH))) {

            String line = "";
            while ((line = br.readLine()) != null) {
                String[] datasetArray = line.split(",");

                String result = Challenge.mainMethod(datasetArray[1]);
                String expected = datasetArray[2];

                assertThat(result).isEqualTo(expected);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
