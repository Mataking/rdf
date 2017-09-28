import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

import java.io.FileOutputStream;
import java.io.IOException;

public class Save_RDF{

    public static void main(String[] args) throws IOException{

        String personURI = "http://somewhere/JohnSmith";
        String givenName = "John";
        String familyName = "Smith";
        String fullName = givenName + " " + familyName;


        /**
         * Déclaration de model de type Model
         */
        Model model = ModelFactory.createDefaultModel();


        /**
         * Ajout de propriétés au model (ici 4)
         * Création de johnSmith de type Resource
         */
        Resource johnSmith
                = model.createResource(personURI)
                .addProperty(VCARD.FN, fullName)
                .addProperty(VCARD.N,
                        model.createResource()
                                .addProperty(VCARD.Given, givenName)
                                .addProperty(VCARD.Family, familyName));


        /**
         * Sauvegarde
         */
        System.out.println(System.getProperty("line.separator") + "RDF/XML");
        model.write(new FileOutputStream("C:/Users/Mata/Downloads/write_file_RDF_XML.rdf"), "RDF/XML", null);

        // Sauvegarde "RDF/XML-ABBREV" */
        System.out.println(System.getProperty("line.separator") + "RDF/XML-ABBREV");
        model.write(new FileOutputStream("C:/Users/Mata/Downloads/write_file_RDF_XML_ABBREV.rdf"), "RDF/XML-ABBREV", null);

        // Sauvegarde "N3" */
        System.out.println(System.getProperty("line.separator") + "N3");
        model.write(new FileOutputStream("C:/Users/Mata/Downloads/write_file_N3.rdf"), "N3", null);
    }
}