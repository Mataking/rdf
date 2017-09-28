import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Modification_RDF {
    public static void main(String[] args) throws IOException{

        final String inputFileName = "file_list/read_file.rdf";
        String johnSmithURI = "http://somewhere/JohnSmith/";

        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open(inputFileName);
        if (in == null) {
            throw new IllegalArgumentException("File: " + inputFileName + " not found");
        }

        // read the RDF/XML file
        model.read(in, "");


        // Modification
        Resource johnSmith
                = model.createResource(johnSmithURI)
                    .addProperty(VCARD.N,
                        model.createResource()
                                .addProperty(VCARD.EMAIL, "bob@gmail.com"));

        // write it to standard out
        model.write(System.out, "TURTLE");

        System.out.println(System.getProperty("line.separator") + "RDF/XML-ABBREV");
        model.write(new FileOutputStream("C:/Users/Mata/Downloads/modification_file.rdf"), "RDF/XML-ABBREV", null);
    }
}