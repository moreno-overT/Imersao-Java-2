import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.Key;
import java.util.List;
import java.util.Map;

public class App {
   
    public static void main(String[] args) throws Exception {
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereço = URI.create(url);
        var cliente = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereço).GET().build();
        HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString());
        String body = response.body();
       

        var parser = new JsonParser();
        List<Map<String, String>> listadefilmes = parser.parse(body);
        System.out.println("\u001b[33m \u001b[1mTop 10 filmes mais bem avaliados no IMDB 🍿 \u001b[m");
        for (Map<String, String> filme : listadefilmes) {
            System.out.println("\u001b[37m \u001b[1m  「\u001b[m "+ filme.get("title"));
            System.out.println("\u001b[34m \u001b[4m🏅 | Ranking: \u001b[m "+ filme.get("rank"));
            System.out.println("\u001b[34m \u001b[4m📅 | Year: \u001b[m "+ filme.get("year"));
            System.out.println("\u001b[34m \u001b[4m⭐ | Rating: \u001b[m "+ filme.get("imDbRating"));
            System.out.println("         ");
        

    }

    System.out.println("                        – Sapere aude!🌻");
}

}
