import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.VCARD;

public class Main {

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
         * Déclaration de l'itérateur
         */
        StmtIterator iter = model.listStatements();


        /**
         * Parcours de l'itérateur
         * Resource
         * Property
         * RDFNode
         */
        while (iter.hasNext()) {

            Statement stmt = iter.nextStatement();

            Resource subject = stmt.getSubject();

            Property predicate = stmt.getPredicate();

            RDFNode object = stmt.getObject();

            /**
             * Bloc d'affichage des Triplets RDF
             */
            System.out.print(subject.toString());
            System.out.print(" " + predicate.toString() + " ");
            if (object instanceof Resource)
                System.out.print(object.toString());
            else
                System.out.print(" \"" + object.toString() + "\"");
            System.out.println(" .");
        }
    }
}