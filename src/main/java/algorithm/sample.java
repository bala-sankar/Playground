package algorithm;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

// SQL
// select ID, NAME from CUSTOMER where COUNTRY = "USA" and CREDITS > 100000 order by ID asc

public class sample {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
//        System.out.println(maxOccuringCharacter("aAAAbbbc"));

        System.out.println(getCapitalCity("Oceania"));
        System.out.println(getCapitalCity("Afghanistan"));
    }

    private static char maxOccuringCharacter(String text) {
        // aAAAbbbc

        HashMap<Character, Integer> countChar = new HashMap<>();
        HashMap<Character, Integer> posChar = new HashMap<>();
        // Char counts
        int posInc = 0;
        // text -> [a,A,A,A,b,b,b,c]
        for (char x : text.toCharArray()) {
            // x -> A
            // posInc -> 2
            // count -> 2
            /*
                countChar
                a -> 1
                A -> 3
             */
            /*
                posChar
                a -> 1
                A -> 2
             */
            if (!countChar.containsKey(x)) {
                // Array List
                posChar.put(x, posInc++); // won't execute
            }
            // get "A" from countChar, if not present then return 0
            int count = countChar.getOrDefault(x, 0);
            countChar.put(x, count + 1);
        }
        /*
            countChar
            b -> 3
            A -> 3
            c -> 1
            a -> 1
        */
        /*
            posChar
            A -> 2
            a -> 1
            c -> 4
            b -> 3
        */
        // Get the max chars
        int maxCount = -1;
        char maxChar = Character.SPACE_SEPARATOR; // Non-existing character
        // a, b, A, c
        for (char key : countChar.keySet()) {
            // maxCount -> 3
            // maxChar -> 'A'
            // key -> c
            // 1 > 3
            if (countChar.get(key) > maxCount) {
                maxCount = countChar.get(key); // 3
                maxChar = key; // b
            }
            // 1 == 3
            else if (countChar.get(key) == maxCount) {
                // 3
                int prevMaxCharPosition = posChar.get(maxChar);
                // 2
                int currMaxCharPosition = posChar.get(key);
                // 2 < 3
                if (currMaxCharPosition < prevMaxCharPosition) {
                    // A
                    maxChar = key;
                }
            }
        }
        return maxChar; // A
    }

    public static String getCapitalCity(String country) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://jsonmock.hackerrank.com/api/countries?name=" + country))
                .GET()
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject responseData = new JsonParser().parse(response.body()).getAsJsonObject();
//        Gson gson = new Gson();
//        Data data = gson.fromJson(response.body(), Data.class);
//        Arrays.stream(data.city).findFirst()
        if (responseData == null
                || responseData.get("data") == null
                || responseData.get("data").getAsJsonArray().isEmpty()
                || responseData.get("data").getAsJsonArray().get(0).getAsJsonObject() == null
                || responseData.get("data").getAsJsonArray().get(0).getAsJsonObject().get("capital") == null) {
            return "-1";
        }
        /*
        // Response
        {
            a: b,
            data: [
                {
                  c: d
                  capital: abcd
                },
                {
                }
            ]
        }
         */
        // "abcd"
        return responseData.get("data").getAsJsonArray().get(0).getAsJsonObject().get("capital").getAsString();
    }
    class Data {
        City[] city;

    }

    class City {
        String capital;
    }
}
