package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Create and configure the main circle of the main choice
        Circle face  = new Circle(125, 125, 80);
        face.setFill(Color.YELLOW);
        face.setStroke(Color.RED);

        //create and configure the circle for the right eye
        Circle rightEye = new Circle(86, 100,10);
        rightEye.setFill(Color.YELLOW);
        rightEye.setStroke(Color.BLUE);

        //create and configure the circle for the left eye
        Circle leftEye = new Circle(162, 100,10);
        leftEye.setFill(Color.YELLOW);
        leftEye.setStroke(Color.BLUE);

        //Create and configure a smiling mouth(this is how it will start)
        Arc mouth = new Arc(125, 150, 45, 35, 0, -180);
         mouth.setFill(Color.YELLOW);
         mouth.setStroke(Color.BLUE);
         mouth.setType(ArcType.OPEN);

        //Create and configure the text
        Text caption = new Text(80, 240, "Changing Face");
        caption.setFill(Color.BLUE);
        caption.setFont(Font.font("Verdana", 15));

        //Create a group that hold all the features
        Group group = new Group(face, rightEye, leftEye, mouth, caption);

        //Create a button that will make the face to smile
        Button smileBtn = new Button("Smile");

        //Create a button to make the face to frown
        Button frownBtn = new Button("Frown");

        //Create and configure a horizontal container to hold the buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);

        //add the buttons to the container
        buttonBox.getChildren().addAll(smileBtn, frownBtn);

        //Create and configure a vertical container to hold the button box and the face
        VBox root  = new VBox(10);
        root.setBackground(Background.EMPTY);
        root.setAlignment(Pos.CENTER);

        //Create and configure a new scene
        Scene scene = new Scene(root, 250, 275, Color.YELLOW);

        //code to execute when the smile btn is pressed
        smileBtn.setOnAction(e -> mouth.setLength(-180));

        //
        frownBtn.setOnAction(e -> mouth.setLength(180));

        //Add the button box and the face group to the vertical container
        root.getChildren().addAll(buttonBox, group);

        //add the scene to the stage, then set the title
        primaryStage.setScene(scene);
        primaryStage.setTitle("Changing Face");

        //show the stage
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
