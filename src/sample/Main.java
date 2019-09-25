package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox vLayout = new VBox();
        vLayout.setPadding(new Insets(20,20,20,20));
        Scene scene = new Scene(vLayout, 800,600);

        // starting value ui:
        HBox startingValueLayout = new HBox();
        startingValueLayout.getChildren().add(new Label("starting value:\t"));
        TextField startingValueTxt = new TextField();
        startingValueLayout.getChildren().add(startingValueTxt);

        // target value ui:
        HBox targetValueLayout = new HBox();
        targetValueLayout.getChildren().add(new Label("target value:\t"));
        TextField targetValueTxt = new TextField();
        targetValueLayout.getChildren().add(targetValueTxt);

        HBox maxDepthLayout = new HBox();
        TextField maxDepthTxt = new TextField("5");
        maxDepthTxt.disableProperty().setValue(true);
        Button plusMaxDepth = new Button("+");
        plusMaxDepth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                maxDepthTxt.setText(Integer.toString(Integer.parseInt(maxDepthTxt.getText()) + 1));
            }
        });
        Button minusMaxDepth = new Button("-");
        minusMaxDepth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int maxDepth = Integer.parseInt(maxDepthTxt.getText());
                if(maxDepth > 0) {
                    maxDepthTxt.setText(Integer.toString(maxDepth-1));
                }
            }
        });
        maxDepthLayout.getChildren().add(maxDepthTxt);
        maxDepthLayout.getChildren().add(plusMaxDepth);
        maxDepthLayout.getChildren().add(minusMaxDepth);


        HBox wikiNodes = new HBox();
        wikiNodes.setPadding(new Insets(0,20,0,0));
        wikiNodes.getChildren().add(new WikiNode(WikiEngine.Instance().get("SOLRAD_2")));
        wikiNodes.getChildren().add(new WikiNode(WikiEngine.Instance().get("Lothagam_North_Pillar_Site")));
        wikiNodes.getChildren().add(new WikiNode(WikiEngine.Instance().get("The_Black_Cloth")));



        // adding all nodes to the root layout (vLayout)
        vLayout.getChildren().add(startingValueLayout);
        vLayout.getChildren().add(targetValueLayout);
        vLayout.getChildren().add(maxDepthLayout);
        vLayout.getChildren().add(wikiNodes);


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
