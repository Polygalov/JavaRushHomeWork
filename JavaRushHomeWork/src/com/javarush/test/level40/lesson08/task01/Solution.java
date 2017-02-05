package com.javarush.test.level40.lesson08.task01;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/* Отправка GET-запроса через сокет
Перепиши реализацию метода getSite, он должен явно создавать и использовать сокетное соединение Socket с сервером.
Адрес сервера и параметры для GET-запроса получи из параметра url.
Порт используй дефолтный для http.
Классы HttpURLConnection, HttpClient и т.д. не использовать.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {
            Socket clientSocket = new Socket(url.getHost(), url.getDefaultPort());
            String request = "GET " + url.getPath() + " HTTP/1.1\n";
            request += "Host:" + url.getHost() + "\n\n";
            //request+="User-Agent: HTTPClient\n\n";
//получаем OutputStream
            OutputStream outputStream = clientSocket.getOutputStream();
            outputStream.write(request.getBytes());
            outputStream.flush();

//читаем ответ
//            InputStream inputStream = clientSocket.getInputStream();
//            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
//            String answer = in.readLine();


            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String answer;
            while ((answer = in.readLine()) != null) {
                System.out.println(answer);
            }
            clientSocket.close();
            inputStream.close();
            in.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}