/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dooapp.fxform.FXForm;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import javahive.domain.Student;

/**
 * 
 * @author mgr
 */
public class SimpleController implements Initializable {

	@FXML
	private TableView<Student> table;

	@FXML
	private Label label;

	@FXML
	private void handleButtonAction(ActionEvent event) {
		label.setText("Hello World!");
	}

	@FXML
	private Pane pane;


	public void initialize(URL arg0, ResourceBundle arg1) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:javafxapplication2/applicationContext.xml");
		List<Student> student = ctx.getBean(SpringClass.class).test();
		ObservableList<Student> observableList = FXCollections
				.observableList(student);
		System.out.println(table);
		TableColumn<Student, String> firstNameCol = new TableColumn<Student, String>(
				"First Name");
		firstNameCol
				.setCellValueFactory(new PropertyValueFactory<Student, String>(
						"imie"));
		TableColumn<Student, String> sNameCol = new TableColumn<Student, String>(
				"Nazwisko");
		sNameCol.setCellValueFactory(new PropertyValueFactory<Student, String>(
				"nazwisko"));

		table.getColumns().add(firstNameCol);
		table.getColumns().add(sNameCol);
		table.setItems(observableList);

		final FXForm<Student> f = new FXForm();
		//pane.getChildren().clear();
		pane.getChildren().add(f);

		table.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<Student>() {
					public void changed(
							ObservableValue<? extends Student> arg0,
							Student arg1, Student nowyWybor) {

						f.setSource(nowyWybor);
					}
				});
	}
}
