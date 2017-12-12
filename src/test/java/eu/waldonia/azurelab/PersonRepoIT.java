package eu.waldonia.azurelab;

import com.microsoft.azure.documentdb.Document;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.documentdb.FeedResponse;
import com.microsoft.azure.spring.data.documentdb.DocumentDbFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertNotNull;

/**
 * @author sih
 */
@SpringBootTest(classes = AzurelabApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonRepoIT {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonRepoIT.class);

    @Autowired
    private PersonRepo repo;

    private Person janeDoe;

    private static final String JANE_DOE_ID = "123";

    private static final String JANE_DOE_NAME = "Jane Doe";

    @Before
    public void setUp() {
        janeDoe = new Person(JANE_DOE_ID, JANE_DOE_NAME);
    }

    @Test
    public void saveShouldSaveNewEntity() {
        try {
            repo.save(janeDoe);
        } catch (Exception e) {
            LOGGER.error("Failed", e);
            fail("Shouldn't have thrown exception");
        }
    }


    @Test
    public void findByNameStartsWithShouldFindRows() {
        try {
            DocumentDbFactory factory = new DocumentDbFactory("db", "key");
            DocumentClient client = factory.getDocumentClient();

            FeedResponse<Document> results =
                    client.queryDocuments("/dbs/foo/colls/person",
                    "SELECT * FROM person WHERE STARTSWITH(person.name,  \"Jeanne\")",
                    null);

            assertNotNull(results);
            Iterator<Document> docs = results.getQueryIterator();

            while (docs.hasNext()) {
                Document doc = docs.next();
                LOGGER.info(doc.toJson());


            }


//            Person jd = repo.findByName("Jeanne Doe");
            // TODO work out how you query the document db rather than find by id


        } catch (Exception e) {
            LOGGER.error("Failed", e);
            fail("Shouldn't have thrown exception");
        }
    }

}