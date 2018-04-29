package com.ase.ova.ro;

import java.io.BufferedWriter;

import com.ase.ova.utils.ro.FileOperation;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.WindowEvent;
import javafx.util.Pair;
import javafx.util.StringConverter;

/**
 * View-Controller
 * 
 * @author Goga Gabriel
 */
public class ovaController {

	@FXML
	private Button btnCautare;

	@FXML
	private TextField txtNume;

	@FXML
	private TextField txtPrenume;

	@FXML
	private TextField txtDataNastere;

	@FXML
	private TextField txtCuvinteCheie;

	@FXML
	private Button btnStergere;

	@FXML
	private MenuItem miDespre;

	@FXML
	private MenuItem miIesire;

	@FXML
	private CheckBox myCheckBox;

	@FXML
	private ComboBox<Person> myComboBox;
	private ObservableList<Person> myComboBoxData = FXCollections.observableArrayList();

	@FXML
	private Hyperlink myHyperlink;

	@FXML
	private Slider mySlider;

	@FXML
	private TextField myTextField;

	@FXML
	private MenuItem miSalvare;

	@FXML
	private MenuItem miDeschidere;

	@FXML
	private ListView<Person> myListView;
	private ObservableList<Person> listViewData = FXCollections.observableArrayList();

	@FXML
	private TextArea outputTextArea;

	private static final String EMPTY = "";
	FileOperation fileOperation = new FileOperation();

	/**
	 * The constructor (is called before the initialize()-method).
	 */
	public ovaController() {
		// Create some sample data for the ComboBox and ListView.
//		myComboBoxData.add(new Person("Hans", "Muster"));
//		myComboBoxData.add(new Person("Ruth", "Mueller"));
//		myComboBoxData.add(new Person("Heinz", "Kurz"));
//		myComboBoxData.add(new Person("Cornelia", "Meier"));
//		myComboBoxData.add(new Person("Werner", "Meyer"));
//
//		listViewData.add(new Person("Lydia", "Kunz"));
//		listViewData.add(new Person("Anna", "Best"));
//		listViewData.add(new Person("Stefan", "Meier"));
//		listViewData.add(new Person("Martin", "Mueller"));
	}

	void showAbout() {
		// Create the custom dialog.
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Realizatori");

		Image image = new Image("/Realizatori1.png", 400, 500, false, false);
		ImageView imageView = new ImageView(image);
		imageView.fitWidthProperty();
		imageView.fitHeightProperty();

		// Set the icon (must be included in the project).

		dialog.setResizable(false);
		dialog.getDialogPane().setPrefSize(280, 290);

		dialog.setGraphic(imageView);

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		// grid.setPadding(new Insets(20, 150, 10, 10));

		TextField username = new TextField();
		username.setPromptText("Username");
		PasswordField password = new PasswordField();
		password.setPromptText("Password");

		grid.add(new Label("Username:"), 0, 0);
		grid.add(username, 1, 0);
		grid.add(new Label("Password:"), 0, 1);
		grid.add(password, 1, 1);

		// Enable/Disable login button depending on whether a username was entered.
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(false);

		// Do some validation (using the Java 8 lambda syntax).
		username.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.show();
	}

	private void clearAll() {
		txtNume.setText(EMPTY);
		txtPrenume.setText(EMPTY);
		txtDataNastere.setText(EMPTY);
		txtCuvinteCheie.setText(EMPTY);
	}

	private void cautare() {
		String stxtNume = "";
		stxtNume = txtNume.getText();

		String stxtPrenume = "";
		stxtPrenume = txtPrenume.getText();

		String stxtDataNastere = "";
		stxtDataNastere = txtDataNastere.getText();

		String stxtCuvinteCheie = "";
		stxtCuvinteCheie = txtCuvinteCheie.getText();

		String[] s = new String[4];
		s[0] = stxtNume;
		s[1] = stxtPrenume;
		s[2] = stxtDataNastere;
		s[3] = stxtCuvinteCheie;

		if (!isValid(s)) {
			showMessageNoDataToFind();
			return;
		}
	}

	private void showMessageNoDataToFind() {
		// Create the custom dialog.
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Informare");

		dialog.setContentText("Trebuie specificat cel putin un criteriu\n\n de cautare");
		dialog.setResizable(false);
		dialog.getDialogPane().setPrefSize(380, 90);

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		// grid.setPadding(new Insets(20, 150, 10, 10));

		TextField username = new TextField();
		username.setPromptText("Username");
		PasswordField password = new PasswordField();
		password.setPromptText("Password");

		grid.add(new Label("Username:"), 0, 0);
		grid.add(username, 1, 0);
		grid.add(new Label("Password:"), 0, 1);
		grid.add(password, 1, 1);

		// Enable/Disable login button depending on whether a username was entered.
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(false);

		// Do some validation (using the Java 8 lambda syntax).
		username.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.show();

	}

	private boolean isValid(String[] s) {
		boolean found = false;
		for (String s1 : s) {
			if (s1.length() > 0) {
				found = true;
				break;
			}
		}

		return found;
	}

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Handle Button Cautare event.
		btnCautare.setOnAction((event) -> {
			cautare();
			System.out.println("ButtonCautare action\n");
			// outputTextArea.appendText("Button Action\n");
		});

		// Handle Button Stergere event.
		btnStergere.setOnAction((event) -> {
			clearAll();
			System.out.println("ButtonStergere action\n");
			// outputTextArea.appendText("Button Action\n");
		});

		miDespre.setOnAction((event) -> {
			showAbout();
			System.out.println("ShowAbout action\n");
		});

		miIesire.setOnAction((event) -> {
			Platform.exit();
			System.exit(0);
			System.out.println("Iesire action\n");
		});

		miSalvare.setOnAction((event) -> {
			salvareCautare();
			System.out.println("Salvare action\n");
		});

		miDeschidere.setOnAction((event) -> {
			deschidereCautare();
			System.out.println("Deschidere action\n");
		});

		//
		// // Handle CheckBox event.
		// myCheckBox.setOnAction((event) -> {
		// boolean selected = myCheckBox.isSelected();
		// outputTextArea.appendText("CheckBox Action (selected: " + selected + ")\n");
		// });
		//
		// // Init ComboBox items.
		// myComboBox.setItems(myComboBoxData);
		//
		// // Define rendering of the list of values in ComboBox drop down.
		// myComboBox.setCellFactory((comboBox) -> {
		// return new ListCell<Person>() {
		// @Override
		// protected void updateItem(Person item, boolean empty) {
		// super.updateItem(item, empty);
		//
		// if (item == null || empty) {
		// setText(null);
		// } else {
		// setText(item.getFirstName() + " " + item.getLastName());
		// }
		// }
		// };
		// });

		// // Define rendering of selected value shown in ComboBox.
		// myComboBox.setConverter(new StringConverter<Person>() {
		// @Override
		// public String toString(Person person) {
		// if (person == null) {
		// return null;
		// } else {
		// return person.getFirstName() + " " + person.getLastName();
		// }
		// }
		//
		// @Override
		// public Person fromString(String personString) {
		// return null; // No conversion fromString needed.
		// }
		// });
		//
		// // Handle ComboBox event.
		// myComboBox.setOnAction((event) -> {
		// Person selectedPerson = myComboBox.getSelectionModel().getSelectedItem();
		// outputTextArea.appendText("ComboBox Action (selected: " +
		// selectedPerson.toString() + ")\n");
		// });
		//
		// // Handle Hyperlink event.
		// myHyperlink.setOnAction((event) -> {
		// outputTextArea.appendText("Hyperlink Action\n");
		// });

		// // Init ListView.
		// myListView.setItems(listViewData);
		// myListView.setCellFactory((list) -> {
		// return new ListCell<Person>() {
		// @Override
		// protected void updateItem(Person item, boolean empty) {
		// super.updateItem(item, empty);
		//
		// if (item == null || empty) {
		// setText(null);
		// } else {
		// setText(item.getFirstName() + " " + item.getLastName());
		// }
		// }
		// };
		// });
		//
		// // Handle ListView selection changes.
		// myListView.getSelectionModel().selectedItemProperty().addListener((observable,
		// oldValue, newValue) -> {
		// outputTextArea.appendText("ListView Selection Changed (selected: " +
		// newValue.toString() + ")\n");
		// });
		//
		// // Handle Slider value change events.
		// mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
		// outputTextArea.appendText("Slider Value Changed (newValue: " +
		// newValue.intValue() + ")\n");
		// });
		//
		// // Handle TextField text changes.
		// myTextField.textProperty().addListener((observable, oldValue, newValue) -> {
		// outputTextArea.appendText("TextField Text Changed (newValue: " + newValue +
		// ")\n");
		// });
		//
		// // Handle TextField enter key event.
		// myTextField.setOnAction((event) -> {
		// outputTextArea.appendText("TextField Action\n");
		// });

	}

	private void deschidereCautare() {
		String[] s = fileOperation.open("cautare.txt");

		txtNume.setText(s[0]);
		txtPrenume.setText(s[1]);
		txtDataNastere.setText(s[2]);
		txtCuvinteCheie.setText(s[3]);
	}

	private void salvareCautare() {
		String line = "";
		int contor = 0;

		String[] s = new String[4];
		s[0] = txtNume.getText();
		s[1] = txtPrenume.getText();
		s[2] = txtDataNastere.getText();
		s[3] = txtCuvinteCheie.getText();

		if (!isValid(s)) {
			showEmptyFileCannotSaveMessage();
			return;
		}

		for (String s1 : s) {
			if (contor < 3)
				line += s1 + "#";
			else
				line += s1;
			contor++;
		}

		fileOperation.save("cautare.txt", line);
	}

	private void showEmptyFileCannotSaveMessage() {
		// Create the custom dialog.
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Nu se poate salva");

		dialog.setContentText("Trebuie specificat cel putin un criteriu\n\n de cautare");
		dialog.setResizable(false);
		dialog.getDialogPane().setPrefSize(380, 90);

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		
		TextField username = new TextField();
		username.setPromptText("Username");
		PasswordField password = new PasswordField();
		password.setPromptText("Password");

		grid.add(new Label("Username:"), 0, 0);
		grid.add(username, 1, 0);
		grid.add(new Label("Password:"), 0, 1);
		grid.add(password, 1, 1);

		// Enable/Disable login button depending on whether a username was entered.
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(false);

		// Do some validation (using the Java 8 lambda syntax).
		username.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		dialog.show();

	}

}