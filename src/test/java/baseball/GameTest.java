package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class GameTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams(){System.setOut(new PrintStream(output));}

    @AfterEach
    public void restoreStreams(){
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void start() {
    }

    @Test
    void printMessage() {
        Game game = new Game();
        game.printMessage(Settings.START_MESSAGE);
        String result = Settings.START_MESSAGE + "\r\n";
        assertThat(result).isEqualTo(output.toString());
    }

    @Test
    void isStartStatus_시작상태인경우() {
        Game game = new Game();
        boolean result = true;
        assertThat(result).isEqualTo(game.isStartStatus());
    }

    @Test
    void isStartStatus_종료상태인경우() {
        Game game = new Game();
        game.setStatus(Settings.TERMINATE_STATUS);
        boolean result = false;
        assertThat(result).isEqualTo(game.isStartStatus());
    }

    @Test
    void requestAnswer() {
    }

    @Test
    void checkAnswer() {
    }

    @Test
    void countResult() {
    }

    @Test
    void setStatusByProblemSolver() {
    }
}