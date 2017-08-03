package Modelo;

import Controlador.BusquedaController;
import Controlador.ConfiguracionController;
import Controlador.PrincipalController;
import es.upv.inf.Database;
import es.upv.inf.Product;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Tienda extends Application {
    private ObservableList<PC> configuraciones = FXCollections.observableArrayList();
    private ConfiguracionController configuracionController;
    private PrincipalController principalController;
    private BusquedaController busquedaController;
    
    public Tienda(){
        Product speaker = Database.getProductByCategory(Product.Category.SPEAKER).get(0);
        Product hdd = Database.getProductByCategory(Product.Category.HDD).get(0);
        Product power_supply = Database.getProductByCategory(Product.Category.POWER_SUPPLY).get(0);
        Product dvd_writer = Database.getProductByCategory(Product.Category.DVD_WRITER).get(0);
        Product ram = Database.getProductByCategory(Product.Category.RAM).get(0);
        Product screen = Database.getProductByCategory(Product.Category.SCREEN).get(0);
        Product multireader = Database.getProductByCategory(Product.Category.MULTIREADER).get(0);
        Product motherboard = Database.getProductByCategory(Product.Category.MOTHERBOARD).get(0);
        Product cpu = Database.getProductByCategory(Product.Category.CPU).get(0);
        Product mouse = Database.getProductByCategory(Product.Category.MOUSE).get(0);
        Product gpu = Database.getProductByCategory(Product.Category.GPU).get(0);
        Product keyboard = Database.getProductByCategory(Product.Category.KEYBOARD).get(0);
        Product tower = Database.getProductByCategory(Product.Category.CASE).get(0);
        Product fan = Database.getProductByCategory(Product.Category.FAN).get(0);
                
        PC pc1 = new PC("Prueba1",  motherboard, cpu, ram, gpu, hdd, tower,
            keyboard, mouse, screen, speaker, multireader, dvd_writer, fan, power_supply,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
        
        speaker = Database.getProductByCategory(Product.Category.SPEAKER).get(3);
        hdd = Database.getProductByCategory(Product.Category.HDD).get(3);
        power_supply = Database.getProductByCategory(Product.Category.POWER_SUPPLY).get(3);
        dvd_writer = Database.getProductByCategory(Product.Category.DVD_WRITER).get(3);
        ram = Database.getProductByCategory(Product.Category.RAM).get(3);
        screen = Database.getProductByCategory(Product.Category.SCREEN).get(3);
        multireader = Database.getProductByCategory(Product.Category.MULTIREADER).get(3);
        motherboard = Database.getProductByCategory(Product.Category.MOTHERBOARD).get(3);
        cpu = Database.getProductByCategory(Product.Category.CPU).get(3);
        mouse = Database.getProductByCategory(Product.Category.MOUSE).get(3);
        gpu = Database.getProductByCategory(Product.Category.GPU).get(3);
        keyboard = Database.getProductByCategory(Product.Category.KEYBOARD).get(3);
        tower = Database.getProductByCategory(Product.Category.CASE).get(3);
        fan = Database.getProductByCategory(Product.Category.FAN).get(3);
        
        PC pc2 = new PC("Prueba2" ,  motherboard, cpu, ram, gpu, hdd, tower,
            keyboard, mouse, screen, speaker, multireader, dvd_writer, fan, power_supply,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
        
        configuraciones.add(pc1);
        configuraciones.add(pc2);
          
    }
    @Override
    public void start(Stage primaryStage) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Principal.fxml"));
        AnchorPane root = (AnchorPane) loader.load();
        Scene scene = new Scene(root,600,400);
        primaryStage.setTitle("Multi ventanas");
        primaryStage.setScene(scene);
        //Darle acceso al mainapp desde el controlador:
        this.principalController = loader.getController();
        this.principalController.setTienda(this);
        primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean mostrarConfiguracion(PC pc){
        try {
        // Load the fxml file and create a new stage for the popup dialog.
        Stage estageActual = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Configuracion.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Scene scene = new Scene(page,700,500);
        estageActual.setScene(scene);
        estageActual.initModality(Modality.APPLICATION_MODAL);
        // Set the pc into the controller.
        this.configuracionController = loader.getController();
        this.configuracionController.initStage(estageActual);
        this.configuracionController.setTienda(this);
        this.configuracionController.setPC(pc);
        estageActual.showAndWait();
        return this.configuracionController.isOkClicked();
        } catch (IOException e) {
        e.printStackTrace();
            return false;
        }
    }
    
    public boolean mostrarBusqueda(Product producto){
        try {
        // Load the fxml file and create a new stage for the popup dialog.
        Stage estageActual = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Busqueda.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Scene scene = new Scene(page,600,400);
        estageActual.setScene(scene);
        estageActual.initModality(Modality.APPLICATION_MODAL);
        // Set the person into the controller.
        this.busquedaController = loader.getController();
        this.busquedaController.initStage(estageActual);
        this.busquedaController.setTienda(this);
        this.busquedaController.setConfiguracionController(this.configuracionController);
        this.busquedaController.setProduct(producto);
        estageActual.show();
        return this.busquedaController.isOkClicked();
        } catch (IOException e) {
        e.printStackTrace();
            return false;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }

    /**
     * @return the configuraciones
     */
    public ObservableList<PC> getConfiguraciones() {
        return configuraciones;
    }

    /**
     * @param configuraciones the configuraciones to set
     */
    public void setConfiguraciones(ObservableList<PC> configuraciones) {
        this.configuraciones = configuraciones;
    }

    /**
     * @return the configuracionController
     */
    public ConfiguracionController getConfiguracionController() {
        return configuracionController;
    }

    /**
     * @return the principalController
     */
    public PrincipalController getPrincipalController() {
        return principalController;
    }
    
}
