import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.control.Label; 
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import java.io.*;

public class l10q1 extends Application {
    int b1Data;
    public void start(Stage s) throws Exception
    {
    	s.setTitle("this is my first fx program");
    	s.setWidth(500);
    	s.setHeight(200);


    	Label b = new Label("welcome");

    	TextField b1=new TextField("input number");

    	b1.setOnAction(new EventHandler <ActionEvent>()
    	{
    		@Override
    		public void handle(ActionEvent event)
    		{
    			b1Data=Integer.parseInt(b1.getText());
    			for(int i=1;i<11;i++)
    				System.out.println(String.format("%d x %d = %d", b1Data, i, b1Data*i));
    		}
    	});

    	Label b3= new Label("enter number");

    	b3.setLabelFor(b1);

    	StackPane r= new StackPane();

    	r.getChildren().add(b); 
    	r.getChildren().add(b3); 
    	r.getChildren().add(b1);

    	Scene sc=new Scene(r,200,200);
    	s.show();
    }

    public static void main(String[] args) {
    	launch(args);
    }
}


