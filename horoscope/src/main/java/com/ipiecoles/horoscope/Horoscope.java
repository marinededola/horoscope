package com.ipiecoles.horoscope;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.util.StringJoiner;

public class Horoscope {

    private String getPageContents(String address) throws IOException {
        BufferedReader br = null;
        StringJoiner lines = new StringJoiner(System.lineSeparator());
        try {
            URL url = new URL(address);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return lines.toString();

    }
    public HoroscopeData getHoroscope(String signe, String donneesSigne){
        if (signe == null){
            return null;
        }

        return null;
    }
}
