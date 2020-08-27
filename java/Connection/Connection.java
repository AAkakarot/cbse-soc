package Connection;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;

public class Connection {

    public static void getConnection(String url) throws Exception {
        URL obj = new URL(url);

        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
/*
        HttpURLConnection.setFollowRedirects(false);
        List<String> cookies = con.getHeaderFields().get("Set-Cookie");

        for (String cookie : cookies) {
            con.addRequestProperty("Cookie", cookie.split(";", 2)[0]);
       }
*/

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        boolean redirect = false;

        // normally, 3xx is redirect
        int status = con.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
            if (status == HttpURLConnection.HTTP_MOVED_TEMP
                    || status == HttpURLConnection.HTTP_MOVED_PERM
                    || status == HttpURLConnection.HTTP_SEE_OTHER)
                redirect = true;
        }

        System.out.println("Response Code ... " + status);

        if (redirect) {

            String newUrl = con.getHeaderField("Location");
            String cookies = con.getHeaderField("Set-Cookie");

            con = (HttpURLConnection) new URL(newUrl).openConnection();
            con.setRequestProperty("Cookie", cookies);
            con.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
            con.addRequestProperty("User-Agent", "Mozilla");
            con.addRequestProperty("Referer", "google.com");

            System.out.println("Redirect to URL : " + newUrl);

        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
    }
}