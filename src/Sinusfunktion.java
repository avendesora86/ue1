/**
 * Created by shari on 21.10.2017.
 */
import javafx.application.Application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Sinusfunktion extends Application {

    private Group root;

    int cursorX = 0;
    int cursorY = 200;

    double f = 1.99;
    double b = 1;
    double z0;
    double z1 = 8;  // Amplitude
    double z2 = 0;
    int i = 0;
    private Group curve;


    public void sinus() {
        if(i > 600)
            return;
        z0 = f * z1 - b*z2;
        z2 = z1;
        z1 = z0;
        System.out.println(i + " " + (int)z0 );
        drawLine(i, (int)z0) ;
        i++;
        //f -= 0.01;
        sinus();
    }

    public static void main(String[] args) {
        launch(args);

    }

    void drawLine(int x, int y) {
        int endX =  x;
        int endY =  200 - y;
        Line line = new Line(cursorX, cursorY, endX , endY);
        cursorX = endX;
        cursorY = endY;
        line.setStroke(Color.RED);
        curve.getChildren().add(line);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        root = new Group();
        curve = new Group();

        Label  fLabel = new Label("Wähle f:");
        Slider fSlider = new Slider();
        fSlider.setMin(1.95);
        fSlider.setMax(1.99);
        fSlider.setValue(1.99);
        fSlider.setShowTickLabels(true);
        fSlider.setShowTickMarks(true);
        fSlider.setBlockIncrement(0.3);

        fSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                i = 0;
                z1 = 8;
                z2 = 0;
                curve.getChildren().clear();
                cursorX = 0;
                f = (double)newValue;
                sinus();

                            }
        });
/*
        Label  zLabel = new Label("Wähle z1:");
        Slider zSlider = new Slider();
        zSlider.setMin(0);
        zSlider.setMax(16);
        zSlider.setValue(8);
        zSlider.setShowTickLabels(true);
        zSlider.setShowTickMarks(true);
        zSlider.setBlockIncrement(2);

        zSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                i = 0;
                z1 = 8;
                z0 = 0;
                curve.getChildren().clear();
                cursorX = 0;
                b = (double)newValue;
                sinus();
            }
        }); */

        Label  bLabel = new Label("Wähle b:");
        Slider bSlider = new Slider();
        bSlider.setMin(0.9);
        bSlider.setMax(1.1);
        bSlider.setValue(1);
        bSlider.setShowTickLabels(true);
        bSlider.setShowTickMarks(true);

        bSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                i = 0;
                z1 = 8;
                z2 = 0;
                curve.getChildren().clear();
                cursorX = 0;
                b = (double)newValue;
                sinus();
            }
        });

        HBox slideBox = new HBox(10);
        slideBox.getChildren().addAll(fLabel,fSlider,bLabel,bSlider);



        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sinusfunktion");

        Rectangle panel = new Rectangle(600, 400, Color.WHITESMOKE);
        root.getChildren().addAll(panel, slideBox);
        root.getChildren().add(curve);

        primaryStage.show();

        sinus();
    }
}
