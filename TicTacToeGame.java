package TicTacToeGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeGame extends Application {
    private char currentPlayer = 'X';
    private Board board;
    private boolean gameEnded = false;

    @Override
    public void start(Stage primaryStage) {
        int boardSize = 5;
        board = new Board(boardSize);

        GridPane gridPane = new GridPane();
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                final int r = row;
                final int c = col;
                board.getButton(row, col).setOnAction(e -> makeMove(r, c));
                gridPane.add(board.getButton(row, col), col, row);
            }
        }

        Scene scene = new Scene(gridPane, 350, 350);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void makeMove(int row, int col) {
        Button button = board.getButton(row, col);
        if (!gameEnded && button.getText().isEmpty()) {
            button.setText(Character.toString(currentPlayer));
            if (checkForWin(row, col)) {
                System.out.println(currentPlayer + " wins!");
                gameEnded = true;
            } else if (isBoardFull()) {
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private boolean checkForWin(int row, int col) {
    
        StringBuilder rowMarks = new StringBuilder();
        for (int c = 0; c < 5; c++) {
            rowMarks.append(board.getButton(row, c).getText());
        }
        if (rowMarks.toString().contains("XXXXX") || rowMarks.toString().contains("OOOOO")) {
            return true;
        }

    
        StringBuilder colMarks = new StringBuilder();
        for (int r = 0; r < 5; r++) {
            colMarks.append(board.getButton(r, col).getText());
        }
        if (colMarks.toString().contains("XXXXX") || colMarks.toString().contains("OOOOO")) {
            return true;
        }

        
        StringBuilder diagonal1 = new StringBuilder();
        StringBuilder diagonal2 = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            diagonal1.append(board.getButton(i, i).getText());
            diagonal2.append(board.getButton(i, 4 - i).getText());
        }
        if (diagonal1.toString().contains("XXXXX") || diagonal1.toString().contains("OOOOO")) {
            return true;
        }
        return diagonal2.toString().contains("XXXXX") || diagonal2.toString().contains("OOOOO");
    }

    private boolean isBoardFull() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (board.getButton(row, col).getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
