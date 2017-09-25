import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.VCARD;

public class Save_RDF{

    public static void main(String[] args) {

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
        // Sauvegarde "RDF/XML"
        System.out.println(System.getProperty("line.separator") + "RDF/XML");
        model.write(System.out, "RDF/XML");

        // Sauvegarde "RDF/XML-ABBREV" */
        System.out.println(System.getProperty("line.separator") + "RDF/XML-ABBREV");
        model.write(System.out, "RDF/XML-ABBREV");

        // Sauvegarde "N3" */
        System.out.println(System.getProperty("line.separator") + "N3");
        model.write(System.out, "N3");

    }
}