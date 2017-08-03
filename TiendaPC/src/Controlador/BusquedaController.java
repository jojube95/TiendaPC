package Controlador;

import static es.upv.inf.Database.getProductByCategory;
import static es.upv.inf.Database.getProductByCategoryDescriptionAndPrice;
import es.upv.inf.Product;
import es.upv.inf.Product.Category;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    private boolean okClicked = false;
    private Product product;
    ObservableList<Product> productList = null;
    
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
    private CheckBox cSSD;
    @FXML
    private Button bBuscar;
    @FXML
    private TableView<Product> tvTabla;
    @FXML
    private TableColumn<Product, String> tcDesc;
    @FXML
    private TableColumn<Product, Double> tcPrec;
    @FXML
    private TableColumn<Product, Integer> tcDisponibilidad;
    @FXML
    private Button bAnyadir;
    @FXML
    private Button bCancelar;
    
    public void setTienda(Tienda tienda){
        this.tienda = tienda;
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
    	List<Product> productos = new ArrayList<Product>();
    	switch(this.product.getCategory()){
        
        case HDD:
        	if(cSSD.isSelected()){
        		productos= getProductByCategoryDescriptionAndPrice(Category.HDD_SSD, tDesc.getText(), sMin.getValue(), sMax.getValue(), cDisp.isSelected());
        	}
        	else{
        		productos= getProductByCategoryDescriptionAndPrice(Category.HDD, tDesc.getText(), sMin.getValue(), sMax.getValue(), cDisp.isSelected());
        		productos.removeAll(getProductByCategoryDescriptionAndPrice(Category.HDD_SSD, tDesc.getText(), sMin.getValue(), sMax.getValue(), cDisp.isSelected()));
        	}
            productList = FXCollections.observableArrayList(productos);
            tvTabla.setItems(productList);
    	break;
        case HDD_SSD:
        	if(cSSD.isSelected()){
        		productos= getProductByCategoryDescriptionAndPrice(Category.HDD_SSD, tDesc.getText(), sMin.getValue(), sMax.getValue(), cDisp.isSelected());
        	}
        	else{
        		productos= getProductByCategoryDescriptionAndPrice(Category.HDD, tDesc.getText(), sMin.getValue(), sMax.getValue(), cDisp.isSelected());
        		productos.removeAll(getProductByCategoryDescriptionAndPrice(Category.HDD_SSD, tDesc.getText(), sMin.getValue(), sMax.getValue(), cDisp.isSelected()));
        	}
            productList = FXCollections.observableArrayList(productos);
            tvTabla.setItems(productList);
    	break;
        default:
        	productos= getProductByCategoryDescriptionAndPrice(product.getCategory(), tDesc.getText(), sMin.getValue(), sMax.getValue(), cDisp.isSelected());
            productList = FXCollections.observableArrayList(productos);
            tvTabla.setItems(productList);
        }
    }
    
    @FXML
    void cancelar(ActionEvent event){
    	System.out.println("Cancelar pulsado");
    	okClicked = false;
        primaryStage.close();
    }
    
    @FXML
    void anyadir(ActionEvent event){
        Product nuevoProducto = tvTabla.getSelectionModel().getSelectedItem();
        
        try{
        switch(nuevoProducto.getCategory()){
        
        case SPEAKER:
        	this.tienda.getConfiguracionController().getTempPC().setAL(nuevoProducto);
        	this.tienda.getConfiguracionController().getTempPC().setCantAL(1);
    	break;
        	        	
        case HDD:
        	this.tienda.getConfiguracionController().getTempPC().setDD(nuevoProducto);
        	this.tienda.getConfiguracionController().getTempPC().setCantDD(1);
    	break;
        	
    	case HDD_SSD:
    		this.tienda.getConfiguracionController().getTempPC().setDD(nuevoProducto);
    		this.tienda.getConfiguracionController().getTempPC().setCantDD(1);
    	break;
        	
        case POWER_SUPPLY:
        	this.tienda.getConfiguracionController().getTempPC().setFA(nuevoProducto);
        	this.tienda.getConfiguracionController().getTempPC().setCantFA(1);
    	break;
        	
        case DVD_WRITER:
        	this.tienda.getConfiguracionController().getTempPC().setGR(nuevoProducto);
        	this.tienda.getConfiguracionController().getTempPC().setCantGR(1);
    	break;
        	
        case RAM:
        	this.tienda.getConfiguracionController().getTempPC().setMR(nuevoProducto);
        	this.tienda.getConfiguracionController().getTempPC().setCantMR(1);
    	break;
        	
        case SCREEN:
        	this.tienda.getConfiguracionController().getTempPC().setMO(nuevoProducto);
        	this.tienda.getConfiguracionController().getTempPC().setCantMO(1);
    	break;
        	
        case MULTIREADER:
        	this.tienda.getConfiguracionController().getTempPC().setMU(nuevoProducto);
        	this.tienda.getConfiguracionController().getTempPC().setCantMU(1);
    	break;
        	
        case MOTHERBOARD:
        	this.tienda.getConfiguracionController().getTempPC().setPB(nuevoProducto);
        	this.tienda.getConfiguracionController().getTempPC().setCantPB(1);
    	break;
        	
        case CPU:
        	this.tienda.getConfiguracionController().getTempPC().setPR(nuevoProducto);
        	this.tienda.getConfiguracionController().getTempPC().setCantPR(1);
    	break;
        	
        case MOUSE:
        	this.tienda.getConfiguracionController().getTempPC().setRA(nuevoProducto);
        	this.tienda.getConfiguracionController().getTempPC().setCantRA(1);
    	break;
        	
        case GPU:
        	this.tienda.getConfiguracionController().getTempPC().setGPU(nuevoProducto);
        	this.tienda.getConfiguracionController().getTempPC().setCantGPU(1);
    	break;
        	
        case KEYBOARD:
        	this.tienda.getConfiguracionController().getTempPC().setTE(nuevoProducto);
        	this.tienda.getConfiguracionController().getTempPC().setCantTE(1);
    	break;
        	
        case CASE:
        	this.tienda.getConfiguracionController().getTempPC().setTO(nuevoProducto);
        	this.tienda.getConfiguracionController().getTempPC().setCantTO(1);
    	break;
        	
        case FAN:
        	this.tienda.getConfiguracionController().getTempPC().setVE(nuevoProducto);
        	this.tienda.getConfiguracionController().getTempPC().setCantVE(1);
    	break;
    	
        default:
        	System.out.println("Fallo en el anyadir");
        }
        
        this.tienda.getConfiguracionController().getTempPC().recalcularPrecio();
        this.tienda.getConfiguracionController().iniciarVariables();
        this.tienda.getConfiguracionController().mostrarConfiguracion();
        okClicked = true;
        primaryStage.close();
        
        }catch(NullPointerException e){
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("ERROR");
        	alert.setHeaderText("No has seleccionado ningún componente.");
        	alert.setContentText("Selecciona uno antes de añadir.");
        	alert.showAndWait();
        }
     }
    
    public void setProduct(Product product){
        this.product = product;
        List<Product> productos = new ArrayList<Product>();
                
        switch(product.getCategory()){
        
        case HDD:
        	productos = getProductByCategory(Category.HDD);
        	productos.addAll(getProductByCategory(Category.HDD_SSD));
        	productList = FXCollections.observableArrayList(productos);
            tvTabla.setItems(productList);
        	cSSD.setDisable(false);
    	break;
        case HDD_SSD:
        	productos = getProductByCategory(Category.HDD);
        	productos.addAll(getProductByCategory(Category.HDD_SSD));
        	productList = FXCollections.observableArrayList(productos);
            tvTabla.setItems(productList);
        	cSSD.setDisable(false);
    	break;
        default:
        	productos = getProductByCategory(product.getCategory());
        	productList = FXCollections.observableArrayList(productos);
            tvTabla.setItems(productList);
        	cSSD.setDisable(true);
        }
   }
                
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sMin.setMin(0);
        sMin.setMax(800);
        sMax.setMin(0);
        sMax.setMax(800);
        sMin.setValue(0);
        sMax.setValue(800);
        lMin.setText("Precio minimo: "+String.format("%.2f", 0.0));
        lMax.setText("Precio minimo: "+String.format("%.2f", 800.0));
        
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
        
        tcDisponibilidad.setCellValueFactory(new Callback<CellDataFeatures<Product, Integer>, ObservableValue<Integer>>() {
 			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<Integer> call(CellDataFeatures<Product, Integer> p) {
      	         return new ReadOnlyObjectWrapper(p.getValue().getStock());
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
            
        });
    	}    
    }