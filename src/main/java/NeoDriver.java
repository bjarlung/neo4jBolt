import org.neo4j.driver.*;

public class NeoDriver implements AutoCloseable {

    private final Driver driver;

    public NeoDriver( String uri, String user, String password ) {
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }

    @Override
    public void close() {
        driver.close();
    }

    public void printActors() {
        try( Session session = driver.session()) {
            Result result = session.run("MATCH (a:Actor)" +
                    "RETURN a.name AS name LIMIT 100");
            while (result.hasNext()) {
                Record record = result.next();
                System.out.println(record.get("name").asString());
            }
        }

    }
}
