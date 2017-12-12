package eu.waldonia.azurelab;

import com.microsoft.azure.spring.data.documentdb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.Objects;

/**
 * @author sih
 */
@Document(collection = "person")
public class Person {

    @Id
    private String id;
    private String name;

    public Person() {

    }

    public Person(final String id, final String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "{\"_class\":\"Person\", " +
                "\"id\":" + (id == null ? "null" : "\"" + id + "\"") + ", " +
                "\"name\":" + (name == null ? "null" : "\"" + name + "\"") +
                "}";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
