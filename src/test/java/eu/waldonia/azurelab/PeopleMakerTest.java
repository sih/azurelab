package eu.waldonia.azurelab;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.fail;

/**
 * @author sih
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PeopleMakerTest {

    @Autowired
    PeopleMaker peopleMaker;

    @Test
    public void shouldMakeSomePeople() {
        try {
            peopleMaker.makePeople(100);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }

}