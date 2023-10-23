import java.util.List;
import java.util.Set;

public class Main{
    public static void main(String[] args) {
        Movie r1 = new Movie("Rocky", 1976);
Movie r2 = new Movie("Rocky II", 1979, r1);
Movie r3 = new Movie("Rocky III", 1982, r2);
Movie f = new Movie("Apocalypse Now", 1979);
Set<Movie> movies1979 = Movie.selectByYear(1979);
System.out.println(movies1979);
List<Movie> rockys = r2.getSeries();
System.out.println(rockys);
    }
}