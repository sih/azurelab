package eu.waldonia.azurelab;

import com.microsoft.azure.spring.data.documentdb.repository.DocumentDbRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sih
 */
@Repository
public interface PersonRepo extends DocumentDbRepository<Person, String> {

    // Person findByName(String name);
}
