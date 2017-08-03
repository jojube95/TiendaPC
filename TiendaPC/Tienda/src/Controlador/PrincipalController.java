package Controlador;

import Modelo.PC;
import Modelo.Tienda;

import java.net.URL;
import java.util.ResourceBundle;

import es.upv.inf.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class PrincipalController implements Initializable {
    private Tienda tienda;
    
   @FXML
    private MenuItem mAbrir;
    @FXML
    private MenuItem mGuardar;
    @FXML
    private MenuItem mCerrar;
    @FXML
    private MenuItem mNuevo;
    @FXML
    private MenuItem mEditar;
    @FXML
    private MenuItem mBorrar;
    @FXML
    private MenuItem mAyuda;
    @FXML
    private CheckMenuItem mMostrar;
    @FXML
    private TableView<PC> tvTabla;
    @FXML
    private TableColumn<PC, String> tcNombre;
    @FXML
    private TableColumn<PC, Double> tcPrecio;
    @FXML
    private TextArea tResumen;
    @FXML
    private Button bNuevo;
    @FXML
    private Button bEditar;
    @FXML
    private Button bEliminar;
    @FXML
    private Button bImprimir;
    
    private PC pcConfigurado;
    
    public void setTabla(){
        tvTabla.setItems(tienda.getConfiguraciones());
    }
    public PrincipalController(){
        
    }
    
    public void setTienda(Tienda tienda){
        this.tienda = tienda;
        //Codigo para iniciar daros que pase Tienda(PC preconfigurados);
        tvTabla.setItems(tienda.getConfiguraciones());
    }
    
    /**
     * Initializes the controller class.
     */
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tcNombre.setCellValueFactory(
        		cellData -> cellData.getValue().getNombre());
        tcPrecio.setCellValueFactory(
        		cellData -> cellData.getValue().getPrecioObservable());
        
        tvTabla.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            mostrarDetallesPC(newSelection);
        }
        });
        
        tvTabla.setRowFactory( tv -> {
            TableRow<PC> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                PC pcSel = row.getItem();
                pulsarEditar(null);
                
            }
            });
            return row;
            
}       );
    }
    
    @FXML
    void salirAccion(ActionEvent event) {
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }
    
    @FXML
    private void pulsarNuevo(ActionEvent event){
        PC tempPC = new PC();
        boolean okClicked = tienda.mostrarConfiguracion(tempPC);
            if (okClicked) {
                tienda.getConfiguraciones().add(this.pcConfigurado);
        }
        
    }
    
        
    @FXML
    private void pulsarEditar(ActionEvent event){
        PC selectedPC = tvTabla.getSelectionModel().getSelectedItem();
        int index = tvTabla.getSelectionModel().getSelectedIndex();
        if (selectedPC != null) {
            boolean okClicked = tienda.mostrarConfiguracion(selectedPC);
                if (okClicked) {
                    tienda.getConfiguraciones().set(index, this.pcConfigurado);
                    mostrarDetallesPC(selectedPC);
                    
                }

        }
        
    }
    
    @FXML
    private void pulsarEliminar(ActionEvent event){
        int i = tvTabla.getSelectionModel().getSelectedIndex();
        PC pcSel = tvTabla.getSelectionModel().getSelectedItem();
        if (pcSel != null) {
            this.tienda.getConfiguraciones().remove(i);

        }
        
    }
    
    public void mostrarDetallesPC(PC pc){
        //Codigo para mostrar detalles en el textPane del lado
        String mensaje ="";
        mensaje = mensaje+"              "+pc.getNombre()+"                            \n";
        mensaje = mensaje+"Componente     Cantidad Descripcion                   Precio\n";
        mensaje = mensaje+"PLACA BASE     X"+pc.getCantPB()+"   "+pc.getPB().getDescription()+"   "+(pc.getCantPB()*pc.getPB().getPrice())+"E\n";
        mensaje = mensaje+"PROCESADOR     X"+pc.getCantPR()+"   "+pc.getPR().getDescription()+"   "+(pc.getCantPR()*pc.getPR().getPrice())+"E\n";
        mensaje = mensaje+"MEMORIA RAM    X"+pc.getCantMR()+"   "+pc.getMR().getDescription()+"   "+(pc.getCantMR()*pc.getMR().getPrice())+"E\n";
        mensaje = mensaje+"GRAFICA        X"+pc.getCantGPU()+"   "+pc.getGPU().getDescription()+"   "+(pc.getCantGPU()*pc.getGPU().getPrice())+"E\n";
        mensaje = mensaje+"DISCO DURO     X"+pc.getCantDD()+"   "+pc.getDD().getDescription()+"   "+(pc.getCantDD()*pc.getDD().getPrice())+"E\n";
        mensaje = mensaje+"TORRE          X"+pc.getCantTO()+"   "+pc.getTO().getDescription()+"   "+(pc.getCantTO()*pc.getTO().getPrice())+"E\n";
        mensaje = mensaje+"TECLADO        X"+pc.getCantTE()+"   "+pc.getTE().getDescription()+"   "+(pc.getCantTE()*pc.getTE().getPrice())+"E\n";
        mensaje = mensaje+"RATON          X"+pc.getCantRA()+"   "+pc.getRA().getDescription()+"   "+(pc.getCantRA()*pc.getRA().getPrice())+"E\n";
        mensaje = mensaje+"MONITOR        X"+pc.getCantMO()+"   "+pc.getMO().getDescription()+"   "+(pc.getCantMO()*pc.getMO().getPrice())+"E\n";
        mensaje = mensaje+"ALTAVOZ        X"+pc.getCantAL()+"   "+pc.getAL().getDescription()+"   "+(pc.getCantAL()*pc.getAL().getPrice())+"E\n";
        mensaje = mensaje+"MULTILECTOR    X"+pc.getCantMU()+"   "+pc.getMU().getDescription()+"   "+(pc.getCantMU()*pc.getMU().getPrice())+"E\n";
        mensaje = mensaje+"GRABADORA      X"+pc.getCantGR()+"   "+pc.getGR().getDescription()+"   "+(pc.getCantGR()*pc.getGR().getPrice())+"E\n";
        mensaje = mensaje+"VENTILADOR     X"+pc.getCantVE()+"   "+pc.getVE().getDescription()+"   "+(pc.getCantVE()*pc.getVE().getPrice())+"E\n";
        mensaje = mensaje+"FUENTE ALIM    X"+pc.getCantFA()+"   "+pc.getFA().getDescription()+"   "+(pc.getCantFA()*pc.getFA().getPrice())+"E\n";
        tResumen.setText(mensaje);
        
    }

    /**
     * @return the pcConfigurado
     */
    public PC getPcConfigurado() {
        return pcConfigurado;
    }

    /**
     * @param pcConfigurado the pcConfigurado to set
     */
    public void setPcConfigurado(PC pcConfigurado) {
        this.pcConfigurado = pcConfigurado;
    }
    
}
