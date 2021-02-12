package com.ipiecoles.horoscope;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//                                              Input , Output
public class Handler implements RequestHandler<HoroscopeData , GatewayResponse> {
    @Override
    public GatewayResponse handleRequest(HoroscopeData input, Context context) {

        Horoscope horoscope = new Horoscope();
        try {
            String signe = input.getSigne();

            HoroscopeOutPut horoscopeOutPut = horoscope.getHoroscopeFromSigne(signe);

            //recuperer la description
            Genson genson = new GensonBuilder().useRuntimeType(true).create();
            String body = genson.serialize(horoscopeOutPut);

            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type","applicatton/json");
            headers.put("access-Control-Allow-Origin","https://pjvilloud.github.io");
            int statusCode = 200;

            GatewayResponse gatewayResponse = new GatewayResponse(body, headers, statusCode);
            return new GatewayResponse(body, headers, statusCode);
        } catch (IOException e) {
            String body = "Une erreur a été rencontrée";
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type","applicatton/json");
            headers.put("access-Control-Allow-Origin","https://pjvilloud.github.io");
            int statusCode = 400;
            e.printStackTrace();
            GatewayResponse gatewayResponse = new GatewayResponse(body, headers, statusCode);
            return new GatewayResponse(body, headers, statusCode);
        }
    }
}
