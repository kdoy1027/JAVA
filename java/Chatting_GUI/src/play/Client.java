package play;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//Client.java
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Client extends JFrame {
 private static final int BOARD_SIZE = 15;
 private static final int CELL_SIZE = 30;

 private Socket socket;
 private PrintWriter out;
 private BufferedReader in;
 private JPanel boardPanel;
 private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
 private Color[] colors = {Color.BLACK, Color.WHITE, Color.RED, Color.BLUE};
 private boolean myTurn = false;
 private int playerNumber;

 public Client(String serverAddress) {
     try {
         socket = new Socket(serverAddress, 5000);
         out = new PrintWriter(socket.getOutputStream(), true);
         in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

         setTitle("Omok Game");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(new BorderLayout());

         boardPanel = new JPanel() {
             @Override
             protected void paintComponent(Graphics g) {
                 super.paintComponent(g);
                 drawBoard(g);
                 drawStones(g);
             }
         };
         boardPanel.setPreferredSize(new Dimension(BOARD_SIZE * CELL_SIZE, BOARD_SIZE * CELL_SIZE));
         boardPanel.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 if (myTurn) {
                     int x = e.getX() / CELL_SIZE;
                     int y = e.getY() / CELL_SIZE;
                     out.println(x + "," + y);
                 }
             }
         });

         add(boardPanel, BorderLayout.CENTER);

         JButton startButton = new JButton("Start Game");
         startButton.addActionListener(e -> out.println("start"));
         add(startButton, BorderLayout.SOUTH);

         pack();
         setLocationRelativeTo(null);
         setVisible(true);

         // Start a thread to receive messages from the server
         new Thread(this::receiveMessages).start();

     } catch (IOException e) {
         e.printStackTrace();
     }
 }

 private void drawBoard(Graphics g) {
     for (int i = 0; i < BOARD_SIZE; i++) {
         g.drawLine(CELL_SIZE / 2, i * CELL_SIZE + CELL_SIZE / 2,
                    BOARD_SIZE * CELL_SIZE - CELL_SIZE / 2, i * CELL_SIZE + CELL_SIZE / 2);
         g.drawLine(i * CELL_SIZE + CELL_SIZE / 2, CELL_SIZE / 2,
                    i * CELL_SIZE + CELL_SIZE / 2, BOARD_SIZE * CELL_SIZE - CELL_SIZE / 2);
     }
 }

 private void drawStones(Graphics g) {
     for (int i = 0; i < BOARD_SIZE; i++) {
         for (int j = 0; j < BOARD_SIZE; j++) {
             if (board[i][j] != 0) {
                 g.setColor(colors[board[i][j] - 1]);
                 g.fillOval(i * CELL_SIZE + 2, j * CELL_SIZE + 2, CELL_SIZE - 4, CELL_SIZE - 4);
             }
         }
     }
 }

 private void receiveMessages() {
     try {
         String message;
         while ((message = in.readLine()) != null) {
             if (message.startsWith("You are the host")) {
                 playerNumber = 0;
             } else if (message.startsWith("MOVE")) {
                 String[] parts = message.split(",");
                 int player = Integer.parseInt(parts[1]);
                 int x = Integer.parseInt(parts[2]);
                 int y = Integer.parseInt(parts[3]);
                 board[x][y] = player + 1;
                 boardPanel.repaint();
             } else if (message.contains("'s turn")) {
                 myTurn = message.contains(getColorName(playerNumber));
             }
             System.out.println(message);
         }
     } catch (IOException e) {
         e.printStackTrace();
     }
 }

 private String getColorName(int playerNumber) {
     switch (playerNumber) {
         case 0: return "Black";
         case 1: return "White";
         case 2: return "Red";
         case 3: return "Blue";
         default: return "Unknown";
     }
 }

 public static void main(String[] args) {
     SwingUtilities.invokeLater(() -> new Client("192.168.0.41"));
 }
}