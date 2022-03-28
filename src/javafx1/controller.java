/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.sql.*;
/**
 *
 * @author Windows.10
 */
public class controller extends Application{

    
    @Override
    public void start(Stage primaryStage) throws Exception {
        view v=new view();
        remittanceDAO b=new remittanceDAO();
        presentor p=new presentor(v,b);
        Scene scene = new Scene(v, 500, 500,Color.BLUE);
        primaryStage.setTitle("remittance system");
        primaryStage.setScene(scene);
        primaryStage.show();
       

    }
    public static void main(String[] args) {
        launch(args);
       
    }
}
