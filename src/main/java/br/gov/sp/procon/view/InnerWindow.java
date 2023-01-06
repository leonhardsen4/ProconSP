package br.gov.sp.procon.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.MinimizeIcon;
import jfxtras.labs.scene.control.window.Window;

public class InnerWindow extends Application{

    private static int count = 1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button("Nova Janela");
        AnchorPane anchorPane = new AnchorPane(btn);

        btn.setOnAction(a->{
            //Slider para controlar a opacidade da Janela(Window - JFXtras)
            Slider slider = new Slider(0,1,1);

            Text text = new Text();
            text.setText("Janela: " + count);
            text.setFill(Color.WHITE);
            text.setFont(Font.font(15));

            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(text);
            borderPane.setBottom(slider);


            //Criando nossa janela
            Window window = new Window("Janela : " +count);

            //Posicionado na tela
            window.setLayoutX(300);
            window.setLayoutY(150);

            //Definindo o tamanho
            window.setPrefSize(300, 300);

            //Add. icones close e minimize
            window.getLeftIcons().addAll(new CloseIcon(window));
            window.getRightIcons().addAll(new MinimizeIcon(window));

            //Add. o borderPane na Window
            window.getContentPane().getChildren().addAll(borderPane);

            //Fazendo o bind da opacidade com o slider
            window.opacityProperty().bind(slider.valueProperty());

            anchorPane.getChildren().addAll(window);
            count++;
        });

        primaryStage.setScene(new Scene(anchorPane, 800, 600));
        primaryStage.show();

    }
    public static void main(String[] args) {launch(args);}

}
