/**
 * Created by shari on 21.10.2017.
 */
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Fouriersynthese extends Application {

    private Group root;

    int cursorX = 0;
    int cursorY = 200;


    double z0;
    double z1 = 8;  // Amplitude
    double z2 = 0;
    int i = 0;


    public void wave() {

        double n = 0;
//        double synthese = 0;
        for(int i = 0; i<= 600; i++) {

            n = (50. * Math.sin(4 * Math.PI * i / 600))
                    + ((50./9.) * Math.sin((-3*4) * Math.PI * i / 600))
                    + ((50./25.) * Math.sin((5*4) * Math.PI * i / 600))
                    + ((50./9.) * Math.sin((-7*4) * Math.PI * i / 600));
//            synthese += n;
            drawLine(i, (int) n);
        }
//        System.out.println(synthese);
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
        root.getChildren().add(line);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        root = new Group();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fouriersynthese");

        Rectangle panel = new Rectangle(600, 400, Color.WHITESMOKE);
        root.getChildren().add(panel);
        primaryStage.show();

        wave();
    }
}

