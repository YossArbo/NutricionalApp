/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package nutricionalappfx.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nutricionalappfx.dominio.pojo.Paciente;

/**
 * FXML Controller class
 *
 * @author heyoa
 */
public class FXMLAdmiPacientesController implements Initializable {

    @FXML
    private int idNutriologo;
    @FXML
    private TextField tfBuscarPaciente;
    @FXML 
    private TableView<Paciente> tvPacientes;
    @FXML
    private TableColumn colCodigo;
    @FXML 
     private TableColumn colNombre;
    @FXML 
     private TableColumn colApellidoPaterno;
    @FXML 
     private TableColumn colApellidoMaterno;
    @FXML 
     private TableColumn colFechaNacimiento;
    @FXML 
     private TableColumn colPesoInicial;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarColumnasTabla();
        //tvPacientes.setItems();
    }    
    
    private void configurarColumnasTabla() {
        colCodigo.setCellFactory(new PropertyValueFactory("codigo"));
        colNombre.setCellFactory(new PropertyValueFactory("nombre"));
        colApellidoPaterno.setCellFactory(new PropertyValueFactory("apellidoPaterno"));
        colApellidoMaterno.setCellFactory(new PropertyValueFactory("apellidoMaterno"));
        colFechaNacimiento.setCellFactory(new PropertyValueFactory("fechaNacimiento"));
        colPesoInicial.setCellFactory(new PropertyValueFactory("pesoInicial"));
    }
    
    public void recibirInformacion(int idNutriologo) {
        this.idNutriologo = idNutriologo;
    }
    
    private void handlerIrFormularioAltaPaciente(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/nutricionalappfx/vista/FXMLFormularioPaciente.fxml"));
            Parent vista = loader.load();
            
            Scene escena = new Scene(vista);
            Stage stagePacientes = new Stage();
            stagePacientes.setScene(escena);
            stagePacientes.setTitle("Administrador de pacientes");
            stagePacientes.initModality(Modality.APPLICATION_MODAL);
            stagePacientes.showAndWait();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handlerRegresarAPrincipal(ActionEvent event) {
        Stage stagePacientes = (Stage) tfBuscarPaciente.getScene().getWindow();
        stagePacientes.close();
    }
    
    @FXML
    private void handlerBuscarPaciente(ActionEvent event) {
        
    }

    @FXML
    private void handleBtnRegistrar(ActionEvent event) {
    }

    @FXML
    private void handleBtnEditar(ActionEvent event) {
    }

    @FXML
    private void handleBtnEliminar(ActionEvent event) {
    }
}
