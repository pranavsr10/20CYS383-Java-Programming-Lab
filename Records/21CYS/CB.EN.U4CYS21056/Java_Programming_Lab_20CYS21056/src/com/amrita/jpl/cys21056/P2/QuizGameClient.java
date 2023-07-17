package com.amrita.jpl.cys21056.P2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class QuizGameClient extends QuizGame implements QuizGameListener {
    private QuizGameServer server;
    private String currentQuestion;
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public QuizGameClient() {
        this.server = server;
    }

    @Override
    public void startGame() {
        try {
            socket = new Socket("localhost", 2444);
            System.out.println("Server connected");

            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String question = inputStream.readUTF();
                if (question.equals("END")) {
                    break;
                }
                currentQuestion = question;
                onQuestionAsked(currentQuestion);
                askQuestion();
            }

            socket.close();
        } catch (IOException e) {
            System.out.println("Error"+e.getMessage());
        }
    }

    @Override
    public void askQuestion() {
        System.out.print("Enter answer = ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        evaluateAnswer(answer);
    }

    @Override
    public void evaluateAnswer(String answer) {
        try {
            outputStream.writeUTF(answer);
            outputStream.flush();

            boolean isCorrect = inputStream.readBoolean();
            onAnswerEvaluated(isCorrect);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    @Override
    public void onQuestionAsked(String question) {
        System.out.println("Question: " + question);
    }

    @Override
    public void onAnswerEvaluated(boolean crct) {
        System.out.println("Answer = " + (crct ? "correct!" : "incorrect!"));
    }

    public static void main(String[] args) {
        QuizGameClient client = new QuizGameClient();
        client.startGame();
    }
}
