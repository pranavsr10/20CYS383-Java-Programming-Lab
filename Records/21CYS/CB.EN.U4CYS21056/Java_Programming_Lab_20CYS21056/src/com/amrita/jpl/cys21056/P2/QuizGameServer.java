package com.amrita.jpl.cys21056.P2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
abstract class QuizGame {
    public abstract void startGame();
    public abstract void askQuestion();
    public abstract void evaluateAnswer(String answer);
}
interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}
public class QuizGameServer extends QuizGame {
    private ServerSocket serverSocket;
    private DataInputStream dis;
    private DataOutputStream dos;

    public void startGame() {
        try {
            serverSocket = new ServerSocket(2444);
            System.out.println("Server started");

            Socket socket = serverSocket.accept();
            System.out.println("Connected to client");

            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            askQuestion();

            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.out.println("Error" + e.getMessage());
                }
            }
        }
    }

    public void askQuestion() {
        String question = "2+2";
        System.out.println("Question =  " + question);
        sendToClient(question);
    }

    public void evaluateAnswer(String ans) {
        String cans = "4";
        boolean crct = ans.equals(cans);
        sendToClient("Answer =  " + (crct ? "Correct" : "Incorrect"));
    }

    private void sendToClient(String message) {
        try {
            dos.writeUTF(message);
            dos.flush();
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        server.startGame();
    }
}
