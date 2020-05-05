package ru.job4j.io.bot;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
/**
 *Клиентская сторона бота "Оракл".
 *@author Anton Kondratkov
 *@since 09.08.2019
 */
public class Client {
    private final Socket socket;
    private static final Logger LOG = LoggerFactory.getLogger(Client.class.getName());

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {
        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
             Scanner console = new Scanner(System.in)) {
            boolean working = true;
            String ask;
            String answer;
            do {
                ask = console.nextLine();
                out.println(ask);
                answer = in.readLine();
                while (!answer.isEmpty()) {
                    System.out.println(answer);
                    answer = in.readLine();
                }
                if (ask.equals("exit")) {
                    working = false;
                }
            } while (working);
            System.out.println("Shutdown chat!");
        }
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 1111)) {
            Client client = new Client(socket);
            client.start();
        } catch (IOException e) {
            BasicConfigurator.configure();
            LOG.error("If an I/O error occurs", e);
        }
    }
}
