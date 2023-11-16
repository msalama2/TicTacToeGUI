package TicTacToeGame;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Board {
    private Button[][] buttons;

    public Board(int size) {
        buttons = new Button[size][size];
        initializeBoard(size);
    }

    private void initializeBoard(int size) {
        
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Button button = new Button();
                button.setMinSize(70, 70);
                buttons[row][col] = button;
            }
        }
    }

    public Button getButton(int row, int col) {
        return buttons[row][col];
    }

}
