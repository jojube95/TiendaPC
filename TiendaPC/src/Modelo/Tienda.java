package Modelo;

import Controlador.BusquedaController;
import Controlador.ConfiguracionController;
import Controlador.PrincipalController;
import es.upv.inf.Product;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Tienda extends Application {
    private ObservableList<PC> configuraciones = FXCollections.observableArrayList();
    private ConfiguracionController configuracionController;
    private PrincipalController principalController;
    private BusquedaController busquedaController;
    private int id = 0;
    
    public Tienda(){
	}
    @Override
    public void start(Stage primaryStage) {
    	try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Principal.fxml"));
        AnchorPane root = (AnchorPane) loader.load();
        Scene scene = new Scene(root,810,410);
        primaryStage.setTitle("HardTech");
        primaryStage.getIcons().add(new Image("file:Icono/icono.png"));
        primaryStage.setScene(scene);
        this.principalController = loader.getController();
        this.principalController.setTienda(this);
        primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    	Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Preconfiguraciones");
        alert.setHeaderText("Quiere seleccionar una preconfiguración?");
        alert.setContentText("Seleccione una o cancele para crear una propia:");
        ButtonType buttonTypeOne = new ButtonType("Basico");
        ButtonType buttonTypeTwo = new ButtonType("Trabajo");
        ButtonType buttonTypeThree = new ButtonType("Gamer");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
        	File file = new File("Configuraciones/Basico");
            this.principalController.importarPreconfiguracion(file);
        } else if (result.get() == buttonTypeTwo) {
        	File file = new File("Configuraciones/Trabajo");
        	this.principalController.importarPreconfiguracion(file);
        } else if (result.get() == buttonTypeThree) {
        	File file = new File("Configuraciones/Gaming");
        	this.principalController.importarPreconfiguracion(file);
        }
    }
    
    public boolean mostrarConfiguracion(PC pc){
        try {
        Stage estageActual = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Configuracion.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Scene scene = new Scene(page,700,535);
        estageActual.setTitle("Configuración");
        estageActual.getIcons().add(new Image("file:Icono/icono.png"));
        estageActual.setScene(scene);
        estageActual.initModality(Modality.APPLICATION_MODAL);
        this.configuracionController = loader.getController();
        this.configuracionController.initStage(estageActual);
        this.configuracionController.iniciarTempPC(pc);
        this.configuracionController.iniciarVariables();
        this.configuracionController.mostrarConfiguracion();
        this.configuracionController.setTienda(this);
        estageActual.showAndWait();
        return this.configuracionController.isOkClicked();
        } catch (IOException e) {
        e.printStackTrace();
            return false;
        }
    }
    
    public boolean mostrarBusqueda(Product producto){
        try {
        Stage estageActual = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Busqueda.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Scene scene = new Scene(page,680,400);
        estageActual.setTitle("Componente");
        estageActual.getIcons().add(new Image("file:Icono/icono.png"));
        estageActual.setScene(scene);
        estageActual.initModality(Modality.APPLICATION_MODAL);
        this.busquedaController = loader.getController();
        this.busquedaController.initStage(estageActual);
        this.busquedaController.setTienda(this);
        this.busquedaController.setProduct(producto);
        estageActual.show();
        return this.busquedaController.isOkClicked();
        } catch (IOException e) {
        e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    
    public ObservableList<PC> getConfiguraciones() {
        return configuraciones;
    }
    public void setConfiguraciones(ObservableList<PC> configuraciones) {
        this.configuraciones = configuraciones;
    }
	public ConfiguracionController getConfiguracionController() {
        return configuracionController;
    }
	public PrincipalController getPrincipalController() {
        return principalController;
    }
	public int getId() {
		return id;
	}
	public void sumarId() {
		this.id++;
	}
}
