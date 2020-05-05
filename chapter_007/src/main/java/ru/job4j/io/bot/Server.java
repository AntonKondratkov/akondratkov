package ru.job4j.io.bot;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
/**
 *Серверная сторона бота "Оракл".
 *@author Anton Kondratkov
 *@since 09.08.2019
 */
public class Server {
    private final Socket socket;
    private static final Logger LOG = LoggerFactory.getLogger(Server.class.getName());

    /**
     * Коллекция с ответами.
     */
    private final Map<String, String> digest = new HashMap<>();

    public Server(Socket socket) {
        this.socket = socket;
        init();
    }

    public void start() throws IOException {
        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()))) {
            boolean working = true;
            String ask;
            String answer;
            do {
                System.out.println("wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                answer = digest.get(ask);
                if  (answer == null) {
                    answer = "Random phrase.";
                }
                if ("exit".equals(ask)) {
                    working = false;
                }
                out.println(answer);
                out.println();
            } while (working);
            System.out.println("Shutdown server");
        }
    }
    /**
     * Метод добавляет в коллекцию digest пару вопрос - ответ.
     */
    private void init() {
        this.digest.put("hello", "Hello, dear friend, I'm a oracle.");
        this.digest.put("exit", "GoodBye, my friend, let the force be with you!");
    }

    public static void main(String[] args) {
        try (Socket socket = new ServerSocket(1111).accept()) {
            Server server = new Server(socket);
            server.start();
        } catch (IOException e) {
            BasicConfigurator.configure();
            LOG.error("If an I/O error occurs", e);
        }
    }
}
