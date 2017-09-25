import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

import java.io.InputStream;

public class Read_RDF {

    public static void main(String[] args) {

        /**
         * AddType  text/turtle             .ttl
         AddType  application/rdf+xml     .rdf
         AddType  application/n-triples   .nt

         AddType  application/ld+json     .jsonld
         AddType  application/owl+xml     .owl

         AddType  text/trig               .trig
         AddType  application/n-quads     .nq

         AddType  application/trix+xml    .trix
         AddType  application/rdf+thrift  .trdf
         */

        /**
         * Lire un fichier RDF
         */
        final String inputFileName = "file_list/read_file.rdf";

        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.get().open( inputFileName );
        if (in == null) {
            throw new IllegalArgumentException( "File: " + inputFileName + " not found");
        }

        // read the RDF/XML file
        model.read(in, "");

        // write it to standard out
        model.write(System.out);
    }
}


