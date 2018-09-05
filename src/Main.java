import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(new File("template.json"), Person.class);
        mapper.writeValue(new File("file1.json"), person.getConfig1ByTemplate());
        mapper.writeValue(new File("file2.json"), person.getConfig2ByTemplate());
        mapper.writeValue(new File("file3.json"), person.getConfig3ByTemplate());
    }
}
