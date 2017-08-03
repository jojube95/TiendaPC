package Controlador;

import static es.upv.inf.Database.getProductByCategory;
import static es.upv.inf.Database.getProductByCategoryDescriptionAndPrice;
import es.upv.inf.Product;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import Modelo.Tienda;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;

public class BusquedaController implements Initializable {
   
	private Stage primaryStage;
    private Tienda tienda;
    private ConfiguracionController configuracionController;
            
    private boolean okClicked = false;
    
    @FXML
    private Label lMin;
    @FXML
    private Slider sMin;
    @FXML
    private Label lMax;
    @FXML
    private Slider sMax;
    @FXML
    private TextField tDesc;
    @FXML
    private CheckBox cDisp;
    @FXML
    private Button bBuscar;
    @FXML
    private TableView<Product> tvTabla;
    @FXML
    private TableColumn<Product, String> tcDesc;
    @FXML
    private TableColumn<Product, Double> tcPrec;
    @FXML
    private Button bAnyadir;
    @FXML
    private Button bCancelar;
    
    private Product product;
    
    ObservableList<Product> productList = null;

    
    
    public void setTienda(Tienda tienda){
        this.tienda = tienda;
    }
    
    public void setConfiguracionController(ConfiguracionController configuracionController){
        this.configuracionController = configuracionController;
    }
    public void initStage(Stage stage){
        primaryStage = stage;
        primaryStage.setTitle("Configuracion");
    }
    public boolean isOkClicked() {
        return okClicked;
    }
    
    @FXML
    void buscar(ActionEvent event){
        List<Product> productos= getProductByCategoryDescriptionAndPrice(product.getCategory(), tDesc.getText(), sMin.getValue(), sMax.getValue(), cDisp.isSelected());
        productList = FXCollections.observableArrayList(productos);
        tvTabla.setItems(productList);
    }
    
    @FXML
    void anyadir(ActionEvent event){
        Product nuevoProducto = tvTabla.getSelectionModel().getSelectedItem();
        
        switch(nuevoProducto.getCategory()){
        
        case SPEAKER:
        	this.configuracionController.getPc().setAL(nuevoProducto);
    	break;
        	        	
        case HDD:
        	this.configuracionController.getPc().setDD(nuevoProducto);
    	break;
        	
    	case HDD_SSD:
        	this.configuracionController.getPc().setDD(nuevoProducto);
    	break;
        	
        case POWER_SUPPLY:
        	this.configuracionController.getPc().setFA(nuevoProducto);
    	break;
        	
        case DVD_WRITER:
        	this.configuracionController.getPc().setGR(nuevoProducto);
    	break;
        	
        case RAM:
        	this.configuracionController.getPc().setMR(nuevoProducto);
    	break;
        	
        case SCREEN:
        	this.configuracionController.getPc().setMO(nuevoProducto);
    	break;
        	
        case MULTIREADER:
        	this.configuracionController.getPc().setMU(nuevoProducto);
    	break;
        	
        case MOTHERBOARD:
        	this.configuracionController.getPc().setPB(nuevoProducto);
    	break;
        	
        case CPU:
        	this.configuracionController.getPc().setPR(nuevoProducto);
    	break;
        	
        case MOUSE:
        	this.configuracionController.getPc().setRA(nuevoProducto);
    	break;
        	
        case GPU:
        	this.configuracionController.getPc().setGPU(nuevoProducto);
    	break;
        	
        case KEYBOARD:
        	this.configuracionController.getPc().setTE(nuevoProducto);
    	break;
        	
        case CASE:
        	this.configuracionController.getPc().setTO(nuevoProducto);
    	break;
        	
        case FAN:
        	this.configuracionController.getPc().setVE(nuevoProducto);
    	break;
    	
        default:
        	System.out.println("Fallo en el anyadir");
        }
        this.configuracionController.setPC(this.configuracionController.getPc());
        okClicked = true;
        primaryStage.close();
        
    }
    
    public void setProduct(Product product){
        this.product = product;
        List<Product> productos = getProductByCategory(product.getCategory());
        productList = FXCollections.observableArrayList(productos);
        tvTabla.setItems(productList);
    }
    
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sMin.setMin(0);
        sMin.setMax(800);
        sMax.setMin(0);
        sMax.setMax(800);
        
        sMin.valueProperty().addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable,
            Number oldValue, Number newValue) {

            lMin.setText("Precio minimo: "+String.format("%.2f", newValue));
        }
        });
        
        sMax.valueProperty().addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable,
            Number oldValue, Number newValue) {

            lMax.setText("Precio maximo: "+String.format("%.2f", newValue));
        }
        });
        
        
        
        tvTabla.setItems(productList);
        
        tcDesc.setCellValueFactory(new Callback<CellDataFeatures<Product, String>, ObservableValue<String>>() {
 			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Product, String> p) {
      	         return new ReadOnlyObjectWrapper(p.getValue().getDescription());
      	     }
	
   		});
        
        tcPrec.setCellValueFactory(new Callback<CellDataFeatures<Product, Double>, ObservableValue<Double>>() {
 			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<Double> call(CellDataFeatures<Product, Double> p) {
      	         return new ReadOnlyObjectWrapper(p.getValue().getPrice());
      	     }
	
   		});
        
             
        tvTabla.setRowFactory( tv -> {
            TableRow<Product> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                Product rowData = row.getItem();
                anyadir(null);
                this.product = rowData;
                primaryStage.close();
            }
            });
            return row;
            
}       );
        
        
        
    }    
    
}
