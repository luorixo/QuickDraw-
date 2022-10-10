package nz.ac.auckland.se206;

import ai.djl.ModelException;
import java.io.IOException;
import java.net.URISyntaxException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/** */
public class LandingPageController {

  @FXML private Button startButton;

  /**
   * JavaFX calls this method once the GUI elements are loaded. In our case we create a listener for
   * the drawing, and we load the ML model.
   *
   * @throws URISyntaxException
   * @throws ModelException If there is an error in reading the input/output of the DL model.
   * @throws IOException If the model cannot be found on the file system.
   */
  public void initialize() throws URISyntaxException {

    MusicPlayer.intilalise();
    MusicPlayer.playBackgroundSong();
  }

  @FXML
  private void onStartGame(ActionEvent event) throws URISyntaxException {
    Button button = (Button) event.getSource();
    Scene currentScene = button.getScene();

    MusicPlayer.playButtonSoundEffect();

    try {
      // change scene from landing page to the canvas
      currentScene.setRoot(App.loadFxml("userprofilescene"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
