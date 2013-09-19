/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Builder;
import javafx.util.BuilderFactory;
import javafx.util.Callback;

/**
 *
 * @author mgr
 */
public class JavaFXApplication2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:javafxapplication2/applicationContext.xml");
    	
    	URL location = getClass().getResource("Simple.fxml");
    	FXMLLoader fxmlLoader = new FXMLLoader();
    	fxmlLoader.setLocation(location);
    	
    	fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
			public Object call(Class<?> arg0) {
				return ctx.getBean(arg0);
			}
		});
    	
    	Parent root = (Parent) fxmlLoader.load(location.openStream());    	
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	try{
        launch(args);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    
}
