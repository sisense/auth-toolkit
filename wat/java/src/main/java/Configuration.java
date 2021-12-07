import org.json.JSONObject;
import org.json.JSONArray;

public class Configuration {

    static JSONObject tokenHeader = new JSONObject()
             // Unique identifier of the token configuration
            .put("kid", "6102ad6c86792300351fd952");

    // Public key generated as part of token configuration
    static String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
                "miibijanbgkqhkig9w0baqefaaocaq8amiibcgkcaqea6nxbx\n" +
                "mi.............................................70\n" +
                "d1.######..#.....#.######..#.......###..#####..k7\n" +
                "kv.#.....#.#.....#.#.....#.#........#..#.....#.zh\n" +
                "zc.######..#.....#.######..#........#..#.......72\n" +
                "hg.#.......#.....#.#.....#.#........#..#.....#.ry\n" +
                "zh.#........#####..######..#######.###..#####..j0\n" +
                "mi.............................................t9\n" +
                "d1.#....#.#######.#.....#......................70\n" +
                "kv.#..#...#.........#.#........................k7\n" +
                "zc.###....#####......#.........................zh\n" +
                "hg.#..#...#..........#.........................2r\n" +
                "zh.#....#.#######....#.........................yj\n" +
                "zq.............................................0t\n" +
                "miibijanbgkqhkig9w0baqefaaocaq8amiibcgkcaqea6nxbx\n" +
                "-----END PUBLIC KEY-----";

    // Sample of the Filter object
    // Please refer to documentation for details
    // https://sisense.dev/reference/js/metadata-item.html
    // https://sisense.dev/reference/jaql/
    public static final String sampleFilterString = "{\n" +
            "      \"jaql\": {\n" +
            "        \"table\": \"Commerce\",\n" +
            "        \"column\": \"Condition\",\n" +
            "        \"dim\": \"[Commerce.Condition]\",\n" +
            "        \"datatype\": \"text\",\n" +
            "        \"filter\": {\n" +
            "          \"members\": [\n" +
            "            \"New\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"title\": \"Condition\"\n"+
            "       }"+
            "}";

    static JSONObject tokenPayload = new JSONObject()
            // Sisense user id in that is associated with the token
            .put("sub", "60c8a1513dc0ba002c5f8816")
            // Time to live for the token. The timestamp at which the token will expire (not exists = infinite)
            .put("exp", 1975878357)
            // Token not before time, or the time before which the WAT will NOT be accepted. Measured as seconds since epoch
            .put("nbf", 1475878357)
            // The list of permissions that the token grants
            .put("grants", new JSONObject()
                    // List of Dashboard IDs of the assets allowed to be accessed via token
                    .put("res", new JSONArray().put("dashboards/60ec626ffd920200358e7766"))
                    // Dashboard / Widget filters
                    .put("flt", new JSONArray().put(new JSONObject(Configuration.sampleFilterString)))
                    // Permissions set / grants (for dashboard/widget context)
                    // Possible values ["filter", "export"]
                    .put("prm", new JSONArray().put("filter")
            ));

}
