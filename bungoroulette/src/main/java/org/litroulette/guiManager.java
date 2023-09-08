package org.litroulette;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
public class guiManager extends Application{
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bungo Roulette");
        BorderPane borderPane = new BorderPane();
        String [] genres = {"Adventure", "Comedy", "Drama", "Horror", "Romance", "Fantasy", "Mystery", "Science Fiction"};
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text logotitle = new Text("Bungo Roullete");
        logotitle.setId("welcome-text");
        HBox logoBox = new HBox(logotitle);
        logoBox.setAlignment(Pos.TOP_LEFT);
        

        Text scenetitle = new Text("choose a genre and hit submit, 5 books in that genre will be randomly chosen for you!");
        scenetitle.setId("regular-text");
        scenetitle.setTextAlignment(TextAlignment.CENTER);
        grid.add(scenetitle, 0, 0);

        ChoiceBox<String> genreChoice = new ChoiceBox<String>(FXCollections.observableArrayList(genres));
        grid.add(genreChoice,0,1);

        Button submitButton = new Button("submit");
        grid.add(submitButton,1,1);
        final Text actionTarget = new Text();
        grid.add(actionTarget,1,2);
        actionTarget.setId("actiontarget");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle (ActionEvent e)
            {
                String choice = genreChoice.getValue();
                if(choice == null)
                {
                    actionTarget.setText("Please select a genre");
                }
                else
                {
                    bungoRouletteOutput(choice.toLowerCase());
                }
            }

        });

        borderPane.setTop(logoBox);
        borderPane.setCenter(grid);
        //grid.getStyleClass().add("grid-pane");
        Scene scene = new Scene(borderPane, 800, 500);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(guiManager.class.getResource("guicss.css").toExternalForm());
        primaryStage.show();
    }
    public void bungoRouletteOutput(String options)
    {
        int bookNum=0;
        Stage newStage = new Stage();
        JSONObject[] works;
        works = (JSONObject[]) bookRandomAndSelect.getRandomBooks(options);
        Text [] books = new Text[5];
        VBox vbox = new VBox(2);
        for(Object workObj: works)
            {
                JSONObject work = (JSONObject) workObj;
                String title = (String) work.get("title");
                books[bookNum] = new Text();
                books[bookNum].setText(title);
                books[bookNum++].setId("book-title");

            }
        vbox.setAlignment(Pos.CENTER);
        Scene newScene = new Scene(vbox, 800, 500);
        vbox.getChildren().addAll(books[0], books[1], books[2], books[3], books[4]);
        newScene.getStylesheets().add(guiManager.class.getResource("guicss.css").toExternalForm());
        newStage.setScene(newScene);
        newStage.setTitle("5 randomly chosen " + options + " books");
        newStage.show();


    }
}