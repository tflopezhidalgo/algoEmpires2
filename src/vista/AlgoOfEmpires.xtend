package vista

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.stage.StageStyle

class AlgoOfEmpires extends Application {
	def static void main(String[] args) {
		launch(args)
	}

	override void start(Stage primaryStage) {
		var Scene escenaInicial = new Scene(new MenuVista(primaryStage))
		primaryStage.setTitle("Algo of Empires")
		primaryStage.initStyle(StageStyle.UNDECORATED)
		// primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		primaryStage.setMaximized(true)
		primaryStage.setScene(escenaInicial)
		primaryStage.show()
	}
}
