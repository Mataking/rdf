import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.util.FileManager;

public class Sparql {
    public static void main(String args[]) {

        Model model = FileManager.get().loadModel("file_list/sparql.rdf");

        //get all givenName in the file
        String queryString = "SELECT ?givenName\n" +
                "WHERE\n" +
                "  { "+
                "    ?y  <http://www.w3.org/2001/vcard-rdf/3.0#Given>  ?givenName .\n" +
                "  }";

        //get all givenName where Family is "Smith"
        String queryString2 = "SELECT ?givenName\n" +
                "WHERE\n" +
                "  { ?y  <http://www.w3.org/2001/vcard-rdf/3.0#Family>  \"Smith\" .\n"+
                "    ?y  <http://www.w3.org/2001/vcard-rdf/3.0#Given>  ?givenName .\n" +
                "  }";

        //

        Query query = QueryFactory.create(queryString) ;
        QueryExecution qexec= QueryExecutionFactory.create(query,model);
        try {
            ResultSet results = qexec.execSelect() ;
            for ( ; results.hasNext() ; ) {

                QuerySolution soln = results.nextSolution() ;
                RDFNode rdfNode = soln.get("givenName");


                if (rdfNode != null) {
                    System.out.println(rdfNode.toString());
                }
            }
        } finally { qexec.close(); }

        query = QueryFactory.create(queryString2) ;
        qexec= QueryExecutionFactory.create(query,model);
        try {
            System.out.println("Requete sparql 2");
            ResultSet results = qexec.execSelect() ;
            for ( ; results.hasNext() ; ) {

                QuerySolution soln = results.nextSolution() ;
                RDFNode rdfNode = soln.get("givenName");

                if (rdfNode != null) {
                    System.out.println(rdfNode.toString());
                }
            }
        } finally { qexec.close(); }
    }

}

