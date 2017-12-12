package eu.waldonia.azurelab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author sih
 */
@Component
public class PeopleMaker {

    private static final Logger LOGGER = LoggerFactory.getLogger(PeopleMaker.class);

    private String[] firstNames;
    private String[] lastNames;
    public PeopleMaker() {
        firstNames = new String[] {"Jeanne", "Jean", "Aaron", "Aamir", "Ruth", "Sandra", "Jack", "Jacq", "Shirley", "Alice", "Bob",
        "Cuthbert", "Zach", "Naomi", "Colette", "Dieter", "Keith", "Sara", "Steve", "Laura", "Rick", "Janice",
        "Jamie", "Soraya", "Karen", "Genevive", "Gene", "Harriet"};

        lastNames = new String[] {"Doe", "Deaux", "Doh", "Smith", "Smythe", "Khan", "Carney", "Cohen"};

    }

    @Autowired
    private PersonRepo personRepo;

    public void makePeople(int numPeople) {
        try {

            for(int i = 0; i < numPeople; i++) {
                String id = UUID.randomUUID().toString();
                int fn = (int)(Math.random()*firstNames.length);
                int ln = (int)(Math.random()*lastNames.length);
                String name = firstNames[fn]+" "+lastNames[ln];


                Person p = new Person(id, name);
                personRepo.save(p);
            }

        } catch (Exception e) {
            LOGGER.error("Couldn't make person ", e);
        }
    }


}
