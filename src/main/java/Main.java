public class Main {

    public static void main(String... args) {
        try ( NeoDriver movies = new NeoDriver(
                "bolt://localhost:7687",
                "neo4j",
                "password" ) ) {
            movies.printActors();
        }
    }

}
