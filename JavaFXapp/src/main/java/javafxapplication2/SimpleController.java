/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.dooapp.fxform.FXForm;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javahive.domain.Student;

/**
 * 
 * @author mgr
 */
@Component
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
	
	@Inject
	private SpringClass springClass;

	public void initialize(URL arg0, ResourceBundle arg1) {

		List<Student> student = springClass.test();
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
		pane.getChildren().clear();
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
