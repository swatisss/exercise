import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FirstTimeFX extends Application{
   public static void main(String[] args) {
      launch(args);
   }

   @Override
   public void start(Stage stage) throws Exception{

      // 表示させたいものを生成する。
      Label label = new Label("This is JavaFX!!");

      // Sceneに組み込むpaneを生成
      BorderPane pane = new BorderPane();
      // 生成したlabelをpaneに組み込む
      pane.setCenter(label);

      // sceneの生成
      Scene scene = new Scene(pane, 320, 240);

      // SceneをStageにセットする。
      stage.setScene(scene);
      stage.show();
   }
}
