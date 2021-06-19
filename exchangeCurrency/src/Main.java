
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    //Color Code
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
    //Color Code



    public static void main(String[] args) throws IOException, InterruptedException {

        String reply;
        do {

            HashMap<Integer, String> currencyCode = new HashMap<Integer, String>();
            //Country Tags
            currencyCode.put(1, "USD");
            currencyCode.put(2, "EUR");
            currencyCode.put(3, "JPY");
            currencyCode.put(4, "GBP");
            currencyCode.put(5, "AUD");
            currencyCode.put(6, "CAD");
            currencyCode.put(7, "TRY");
            //Country Tags
            String fromCode, toCode;
            double amount;
            String MoneyEmoji = "\uD83D\uDCB0";
            Scanner scanner = new Scanner(System.in);

            Boolean runing = false;



            System.out.println(CYAN_BOLD + MoneyEmoji + " Döviz Çeviriciye Hoş Geldiniz! " + MoneyEmoji  );
            System.out.println(PURPLE_BOLD + MoneyEmoji + " Hangi Para Birimini Dönüştürmek İstersin " + MoneyEmoji  );

            System.out.println(CYAN_BOLD + "1:USD(Amerikan Doları)\t   2:EUR(Avrupa Euro)\t  3:JPY(Japon Yeni)\t  4:GBP(İngiliz Sterlini)\t  5:AUD(Avustralya Doları)\t  6:CAD(Kanada Doları)\t  7:TRY(Türk Lirası)\t" );
            fromCode = currencyCode.get(scanner.nextInt());

            System.out.println(PURPLE_BOLD+" Hangi Para Biriminine Dönüştürmek İstersin");
            System.out.println(CYAN_BOLD + "1:USD(Amerikan Doları)\t   2:EUR(Avrupa Euro)\t  3:JPY(Japon Yeni)\t  4:GBP(İngiliz Sterlini)\t  5:AUD(Avustralya Doları)\t  6:CAD(Kanada Doları)\t  7:TRY(Türk Lirası)\t" );
            toCode = currencyCode.get(scanner.nextInt());

            System.out.println(BLUE_BOLD+MoneyEmoji +" Dönüştürkmek İstediğiniz Miktar ?  " + MoneyEmoji);
            amount = scanner.nextFloat();
            //****************************************
            String API_KEY = "(YOUR-KEY)";

            //****************************************
            String url_str = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + fromCode + "/" + toCode + "/" + amount + "";

            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

// Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

// Accessing object
            String req_result = jsonobj.get("conversion_result").getAsString();
            System.out.println(RED_BOLD + toCode + " " + req_result );
            Thread.sleep(1200);

            System.out.println(WHITE_BOLD+MoneyEmoji+"Tekrar Çalıştırmak İstermisiniz  E/Y "+MoneyEmoji);
            reply = scanner.next();




        }while (reply.equals("E"));
    }
}




