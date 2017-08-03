package Controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Modelo.ListPCWrapper;
import Modelo.PC;
import Modelo.Tienda;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class PrincipalController implements Initializable {
    private Tienda tienda;
    private File fileActual = null;
    private boolean guardado = true;
    private PC pcConfigurado;
    private PC pcSeleccionado = null;
    private int n = 0;
    
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
    private MenuItem mNuevo2;    
    @FXML
    private MenuItem mGuardarComo;
    @FXML
    private MenuItem mImportar;
    @FXML
    private MenuItem mExportar;
    @FXML
    private CheckMenuItem mMostrar;
    @FXML
    private TableView<PC> tvTabla;
    @FXML
    private TableColumn<PC, String> tcNombre;
    @FXML
    private TableColumn<PC, String> tcPrecio;
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
    
    public PrincipalController(){
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcPrecio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrecioString()));
        tvTabla.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
        	this.pcSeleccionado = newSelection;
            mostrarDetallesPC(newSelection);
            
            
            
        }
       });
        tvTabla.setRowFactory( tv -> {
            TableRow<PC> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                pulsarEditar(null);}
            });
            return row;
           });
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
                this.fileActual = null;
                this.guardado = false;
                mGuardar.setDisable(false);
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
                    this.guardado = false;
                    mGuardar.setDisable(false);
                    
                }
                else{
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
            this.guardado = false;
            mGuardar.setDisable(false);
    	}
    }
    
    @FXML
    private void abrir(ActionEvent event){
    	if(this.tienda.getConfiguraciones().isEmpty()){
    		FileChooser fileChooser = new FileChooser();
    		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Configuraciones (*.list)", "*.list");
    		fileChooser.getExtensionFilters().add(extFilter);
	    	File selectedFile = fileChooser.showOpenDialog(null);
	    	
	    	if (selectedFile != null) {
	    		try {
	    			JAXBContext jaxbContext = JAXBContext.newInstance(ListPCWrapper.class);
	    			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    			ListPCWrapper listaWrapper = (ListPCWrapper) jaxbUnmarshaller.unmarshal(selectedFile);
	    			ObservableList<PC> configuraciones = FXCollections.observableList(listaWrapper.getPCList());
	    			tienda.setConfiguraciones(configuraciones);
	    			tienda.getPrincipalController().setTienda(tienda);
	    			this.fileActual = selectedFile;
	    			this.mGuardar.setDisable(true);
	    			this.guardado = true;
	    			} catch (UnmarshalException e) {
	    				Alert alert2 = new Alert(AlertType.ERROR);
	    				alert2.setTitle("ERROR");
	    				alert2.setHeaderText("Archivo incorrecto");
	    				alert2.setContentText("El archivo seleccionado es incorrecto.");
    					alert2.showAndWait();
	    			} catch (JAXBException e){
	    				e.printStackTrace();
	    			}
    		}
    	}
    	else{//Si la lista no esta vacia
	    	if(this.guardado == false){
	    		Alert alert = new Alert(AlertType.CONFIRMATION);
	    		alert.setTitle("Confirmación");
	    		alert.setHeaderText("No has guardado los cambios.");
	    		alert.setContentText("Continuar sin guardar?");
	    		Optional<ButtonType> result = alert.showAndWait();
	    		if (result.get() == ButtonType.OK){
	    			FileChooser fileChooser = new FileChooser();
	    	    	File selectedFile = fileChooser.showOpenDialog(null);
	    	    	if (selectedFile != null) {
	    	    		try {
	    	    			JAXBContext jaxbContext = JAXBContext.newInstance(ListPCWrapper.class);
	    	    			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    	    			ListPCWrapper listaWrapper = (ListPCWrapper) jaxbUnmarshaller.unmarshal(selectedFile);
	    	    			ObservableList<PC> configuraciones = FXCollections.observableList(listaWrapper.getPCList());
	    	    			tienda.setConfiguraciones(configuraciones);
	    	    			tienda.getPrincipalController().setTienda(tienda);
	    	    			this.fileActual = selectedFile;
	    	    			this.mGuardar.setDisable(true);
	    	    			this.guardado = true;
	    	    			} catch (UnmarshalException e) {
	    	    				Alert alert2 = new Alert(AlertType.ERROR);
	    	    				alert2.setTitle("ERROR");
	    	    				alert2.setHeaderText("Archivo incorrecto");
	    	    				alert2.setContentText("El archivo seleccionado es incorrecto.");
    	    					alert2.showAndWait();
	    	    			} catch (JAXBException e){
	    	    				e.printStackTrace();
	    	    			}
	    	    	}
    	    	}
	    	}
	    	else{//Si ya se ha guardado
	    		FileChooser fileChooser = new FileChooser();
	    		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Configuraciones (*.list)", "*.list");
	    		fileChooser.getExtensionFilters().add(extFilter);
		    	File selectedFile = fileChooser.showOpenDialog(null);
		    	if (selectedFile != null) {
		    		try {
		    			JAXBContext jaxbContext = JAXBContext.newInstance(ListPCWrapper.class);
		    			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    			ListPCWrapper listaWrapper = (ListPCWrapper) jaxbUnmarshaller.unmarshal(selectedFile);
		    			ObservableList<PC> configuraciones = FXCollections.observableList(listaWrapper.getPCList());
		    			tienda.setConfiguraciones(configuraciones);
		    			tienda.getPrincipalController().setTienda(tienda);
		    			this.fileActual = selectedFile;
		    			this.mGuardar.setDisable(true);
		    			this.guardado = true;
		    			} catch (UnmarshalException e) {
		    				Alert alert2 = new Alert(AlertType.ERROR);
		    				alert2.setTitle("ERROR");
		    				alert2.setHeaderText("Archivo incorrecto");
		    				alert2.setContentText("El archivo seleccionado es incorrecto.");
	    					alert2.showAndWait();
		    			} catch (JAXBException e){
		    				e.printStackTrace();
		    			}
		    	}
	    	}
    	}
    }
    
    @FXML
    private void guardar(ActionEvent event){
    	if(fileActual==null){
    		guardarComo(null);
    	}
    	else{
    		if(this.tienda.getConfiguraciones().isEmpty()){
    	    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	    	alert.setTitle("CONFIRMAR");
    	    	alert.setHeaderText("Va a guardar una lista vacía.");
    	    	alert.setContentText("Esta seguro?");
    	    	Optional<ButtonType> result = alert.showAndWait();
    	    	if (result.get() == ButtonType.OK){
    	    		ListPCWrapper listToSave = new ListPCWrapper();
    	        	listToSave.setPCList(tienda.getConfiguraciones());
    	        	if (fileActual != null) {
    	        		try {
    	        			JAXBContext jaxbContext = JAXBContext.newInstance(ListPCWrapper.class);
    	        			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    	        			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    	        			jaxbMarshaller.marshal(listToSave, fileActual);
    	        			jaxbMarshaller.marshal(listToSave, System.out);
    	        			mGuardar.setDisable(true);
    	        			this.guardado = true;
    	        			} catch (JAXBException e) {
    	        			e.printStackTrace();
    	        			}
    	        	}
    	    	}
    		}
	    	else{
	    		ListPCWrapper listToSave = new ListPCWrapper();
	        	listToSave.setPCList(tienda.getConfiguraciones());
	        	if (fileActual != null) {
	        		try {
	        			JAXBContext jaxbContext = JAXBContext.newInstance(ListPCWrapper.class);
	        			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	        			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        			jaxbMarshaller.marshal(listToSave, fileActual);
	        			jaxbMarshaller.marshal(listToSave, System.out);
	        			mGuardar.setDisable(true);
	        			this.guardado = true;
	        			} catch (JAXBException e) {
	        			e.printStackTrace();
	        			}
	        	}
	        	else {
	        		
	        	}
	    		
	    	}
    	    	
    	}
    	
    }
    
    @FXML
    private void guardarComo(ActionEvent event){
    	if(this.tienda.getConfiguraciones().isEmpty()){
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("CONFIRMAR");
	    	alert.setHeaderText("Va a guardar una lista vacía.");
	    	alert.setContentText("Esta seguro?");
	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK){
	    		FileChooser fileChooser = new FileChooser();
	    		fileChooser.setInitialFileName("Nombre"+n);
	        	File selectedFile = fileChooser.showSaveDialog(null);
	        	selectedFile = new File(selectedFile+".list");
	        	ListPCWrapper listToSave = new ListPCWrapper();
	        	listToSave.setPCList(tienda.getConfiguraciones());
	        	if (selectedFile != null) {
	        		try {
	        			JAXBContext jaxbContext = JAXBContext.newInstance(ListPCWrapper.class);
	        			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	        			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        			jaxbMarshaller.marshal(listToSave, selectedFile);
	        			jaxbMarshaller.marshal(listToSave, System.out);
	        			mGuardar.setDisable(true);
	        			this.fileActual = selectedFile;
	        			this.guardado = true;
	        			n++;
	        			} catch (JAXBException e) {
	        			e.printStackTrace();
	        			}
	        	}
	    	}
        }
    	else{
    		FileChooser fileChooser = new FileChooser();
    		fileChooser.setInitialFileName("Nombre"+n);
        	File selectedFile = fileChooser.showSaveDialog(null);
        	selectedFile = new File(selectedFile+".list");
        	ListPCWrapper listToSave = new ListPCWrapper();
        	listToSave.setPCList(tienda.getConfiguraciones());
        	if (selectedFile != null) {
        		try {
        			JAXBContext jaxbContext = JAXBContext.newInstance(ListPCWrapper.class);
        			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        			jaxbMarshaller.marshal(listToSave, selectedFile);
        			jaxbMarshaller.marshal(listToSave, System.out);
        			mGuardar.setDisable(true);
        			this.fileActual = selectedFile;
        			n++;
        			} catch (JAXBException e) {
        			e.printStackTrace();
        			}
        	}
    	}
	}
    
    
    @FXML
    private void importar(ActionEvent event){
    	FileChooser fileChooser = new FileChooser();
    	FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PC (*.pc)", "*.pc");
		fileChooser.getExtensionFilters().add(extFilter);
    	File selectedFile = fileChooser.showOpenDialog(null);
    	if (selectedFile != null) {
    		try {
    			JAXBContext jaxbContext = JAXBContext.newInstance(PC.class);
    			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    			PC pcImportado = (PC) jaxbUnmarshaller.unmarshal(selectedFile);
    			tienda.getConfiguraciones().add(pcImportado);
    			tienda.getPrincipalController().setTienda(tienda);
    			} catch (UnmarshalException e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR");
					alert.setHeaderText("Archivo incorrecto");
					alert.setContentText("El archivo seleccionado es incorrecto.");
					alert.showAndWait();
    			} catch (JAXBException e) {
    				e.printStackTrace();
    			}
    	}
    }
    
    public void importarPreconfiguracion(File file){
    	
    	try {
			JAXBContext jaxbContext = JAXBContext.newInstance(PC.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			PC pcImportado = (PC) jaxbUnmarshaller.unmarshal(file);
			tienda.getConfiguraciones().add(pcImportado);
			tienda.getPrincipalController().setTienda(tienda);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
    }
    
    @FXML
    private void mostrarPreconfiguraciones(){
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
            importarPreconfiguracion(file);
        } else if (result.get() == buttonTypeTwo) {
        	File file = new File("Configuraciones/Trabajo");
        	importarPreconfiguracion(file);
        } else if (result.get() == buttonTypeThree) {
        	File file = new File("Configuraciones/Gaming");
        	importarPreconfiguracion(file);
        }
    }
    @FXML
    private void exportar(ActionEvent event){
    	PC selectedPC = tvTabla.getSelectionModel().getSelectedItem();
    	if(selectedPC == null){
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("No ha seleccionado una configuración");
			alert.setContentText("Seleccione una configuración.");
			alert.showAndWait();
    	}
    	else{
    		FileChooser fileChooser = new FileChooser();
    		fileChooser.setInitialFileName("Pc"+n);
        	File selectedFile = fileChooser.showSaveDialog(null);
        	selectedFile = new File(selectedFile+".pc");
    		if (selectedFile != null) {
        		try {
        			JAXBContext jaxbContext = JAXBContext.newInstance(PC.class);
        			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        			jaxbMarshaller.marshal(selectedPC, selectedFile); // save to a file
        			jaxbMarshaller.marshal(selectedPC, System.out); // echo to the console
        			} catch (JAXBException e) {
        			e.printStackTrace();
        			}
        	}
    	}  	
    }
    
    public void mostrarDetallesPC(PC pc){
    	Calendar fecha = Calendar.getInstance();
        int anyo = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String mensaje ="";
        mensaje+="              "+pc.getNombre()+"                            \n";
        mensaje = mensaje+"Componente     Cantidad Descripcion                   Precio\n";
        if(pc.getPB()!=null){
        mensaje = mensaje+"PLACA BASE       X"+pc.getCantPB()+"   "+pc.getPB().getDescription()+"   "+(pc.getCantPB()*pc.getPB().getPrice())+"E\n";
        }
        if(pc.getPR()!=null){
        mensaje = mensaje+"PROCESADOR    X"+pc.getCantPR()+"   "+pc.getPR().getDescription()+"   "+(pc.getCantPR()*pc.getPR().getPrice())+"E\n";
        }
        if(pc.getMR()!=null){
        mensaje = mensaje+"MEMORIA RAM  X"+pc.getCantMR()+"   "+pc.getMR().getDescription()+"   "+(pc.getCantMR()*pc.getMR().getPrice())+"E\n";
        }
        if(pc.getGPU()!=null){
        mensaje = mensaje+"GRAFICA             X"+pc.getCantGPU()+"   "+pc.getGPU().getDescription()+"   "+(pc.getCantGPU()*pc.getGPU().getPrice())+"E\n";
        }
        if(pc.getDD()!=null){
        mensaje = mensaje+"DISCO DURO      X"+pc.getCantDD()+"   "+pc.getDD().getDescription()+"   "+(pc.getCantDD()*pc.getDD().getPrice())+"E\n";
        }
        if(pc.getTO()!=null){
        mensaje = mensaje+"TORRE                 X"+pc.getCantTO()+"   "+pc.getTO().getDescription()+"   "+(pc.getCantTO()*pc.getTO().getPrice())+"E\n";
        }
        if(pc.getTE()!=null){
        mensaje = mensaje+"TECLADO            X"+pc.getCantTE()+"   "+pc.getTE().getDescription()+"   "+(pc.getCantTE()*pc.getTE().getPrice())+"E\n";
        }
        if(pc.getRA()!=null){
        mensaje = mensaje+"RATON               X"+pc.getCantRA()+"   "+pc.getRA().getDescription()+"   "+(pc.getCantRA()*pc.getRA().getPrice())+"E\n";
        }
        if(pc.getMO()!=null){
        mensaje = mensaje+"MONITOR           X"+pc.getCantMO()+"   "+pc.getMO().getDescription()+"   "+(pc.getCantMO()*pc.getMO().getPrice())+"E\n";
        }
        if(pc.getAL()!=null){
        mensaje = mensaje+"ALTAVOZ            X"+pc.getCantAL()+"   "+pc.getAL().getDescription()+"   "+(pc.getCantAL()*pc.getAL().getPrice())+"E\n";
        }
        if(pc.getMU()!=null){
        mensaje = mensaje+"MULTILECTOR    X"+pc.getCantMU()+"   "+pc.getMU().getDescription()+"   "+(pc.getCantMU()*pc.getMU().getPrice())+"E\n";
        }
        if(pc.getGR()!=null){
        mensaje = mensaje+"GRABADORA      X"+pc.getCantGR()+"   "+pc.getGR().getDescription()+"   "+(pc.getCantGR()*pc.getGR().getPrice())+"E\n";
        }
        if(pc.getVE()!=null){
        mensaje = mensaje+"VENTILADOR      X"+pc.getCantVE()+"   "+pc.getVE().getDescription()+"   "+(pc.getCantVE()*pc.getVE().getPrice())+"E\n";
        }
        if(pc.getFA()!=null){
        mensaje = mensaje+"FUENTE ALIM     X"+pc.getCantFA()+"   "+pc.getFA().getDescription()+"   "+(pc.getCantFA()*pc.getFA().getPrice())+"E\n";
        }
        mensaje = mensaje+"\n";
        mensaje = mensaje +"Fecha de confección: "+ dia + "/" + mes + "/" + anyo+"\n";
        fecha.add(Calendar.DAY_OF_MONTH, 7);
        anyo = fecha.get(Calendar.YEAR);
        mes = fecha.get(Calendar.MONTH)+1;
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        mensaje = mensaje +"Esta configuración es válida hasta: "+ dia + "/" + mes + "/" + anyo+"\n";
        tResumen.setText(mensaje);
   }
    
    @FXML
    private void imprimir(ActionEvent event){
    	System.out.println("Imprimir pulsado");
    	try{
		Calendar fecha = Calendar.getInstance();
        int anyo = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        
    	Document documento = new Document();
    	FileOutputStream ficheroPdf;
		FileChooser fileChooser = new FileChooser();
    	File selectedFile = fileChooser.showSaveDialog(null);
    	selectedFile = new File(selectedFile+".pdf");
		ficheroPdf = new FileOutputStream(selectedFile);
		PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
		documento.open();
    	documento.add(new Paragraph("Nombre: "+pcSeleccionado.getNombre()));
    	documento.add(new Paragraph("Fecha: "+ dia + "/" + mes + "/" + anyo));
    	fecha.add(Calendar.DAY_OF_MONTH, 7);
        anyo = fecha.get(Calendar.YEAR);
        mes = fecha.get(Calendar.MONTH)+1;
        dia = fecha.get(Calendar.DAY_OF_MONTH);
    	documento.add(new Paragraph("Válido hasta: "+ dia + "/" + mes + "/" + anyo));
    	Image foto = Image.getInstance("Icono/icono.png");
    	foto.scaleToFit(100, 100);
    	foto.setAlignment(Chunk.ALIGN_MIDDLE);
    	documento.add(foto);
    	documento.add(new Paragraph("\n"));
    	PdfPTable tabla = new PdfPTable(5);
    	float[] medidaCeldas = {1.25f, 0.70f, 2.25f, 0.6f, 0.6f};
    	tabla.setWidths(medidaCeldas);
    	DecimalFormat df=new DecimalFormat("0.00");
    	tabla.addCell("Componente"); tabla.addCell("Cantidad"); tabla.addCell("Descripcion"); tabla.addCell("Precio sinIVA"); tabla.addCell("Precio conIVA");
		if(pcSeleccionado.getPB()!=null){
			tabla.addCell("PLACA BASE");
			tabla.addCell(Integer.toString(pcSeleccionado.getCantPB()));
			tabla.addCell(pcSeleccionado.getPB().getDescription());
			tabla.addCell(Double.toString(pcSeleccionado.getPB().getPrice()*pcSeleccionado.getCantPB()));
			tabla.addCell(df.format(pcSeleccionado.getPB().getPrice()*pcSeleccionado.getCantPB()*1.21));
        }
        if(pcSeleccionado.getPR()!=null){
        	tabla.addCell("PROCESADOR");
			tabla.addCell(Integer.toString(pcSeleccionado.getCantPR()));
			tabla.addCell(pcSeleccionado.getPR().getDescription());
			tabla.addCell(Double.toString(pcSeleccionado.getPR().getPrice()*pcSeleccionado.getCantPR()));
			tabla.addCell(df.format(pcSeleccionado.getPR().getPrice()*pcSeleccionado.getCantPR()*1.21));
        }
        if(pcSeleccionado.getMR()!=null){
        	tabla.addCell("MEMORIA RAM");
			tabla.addCell(Integer.toString(pcSeleccionado.getCantMR()));
			tabla.addCell(pcSeleccionado.getMR().getDescription());
			tabla.addCell(Double.toString(pcSeleccionado.getMR().getPrice()*pcSeleccionado.getCantMR()));
			tabla.addCell(df.format(pcSeleccionado.getMR().getPrice()*pcSeleccionado.getCantMR()*1.21));
        }
        if(pcSeleccionado.getGPU()!=null){
        	tabla.addCell("GRÁFICA");
			tabla.addCell(Integer.toString(pcSeleccionado.getCantGPU()));
			tabla.addCell(pcSeleccionado.getGPU().getDescription());
			tabla.addCell(Double.toString(pcSeleccionado.getGPU().getPrice()*pcSeleccionado.getCantGPU()));
			tabla.addCell(df.format(pcSeleccionado.getGPU().getPrice()*pcSeleccionado.getCantGPU()*1.21));
        }
        if(pcSeleccionado.getDD()!=null){
        	tabla.addCell("DISCO DURO");
			tabla.addCell(Integer.toString(pcSeleccionado.getCantDD()));
			tabla.addCell(pcSeleccionado.getDD().getDescription());
			tabla.addCell(Double.toString(pcSeleccionado.getDD().getPrice()*pcSeleccionado.getCantDD()));
			tabla.addCell(df.format(pcSeleccionado.getDD().getPrice()*pcSeleccionado.getCantDD()*1.21));
        }
        if(pcSeleccionado.getTO()!=null){
        	tabla.addCell("TORRE");
			tabla.addCell(Integer.toString(pcSeleccionado.getCantTO()));
			tabla.addCell(pcSeleccionado.getTO().getDescription());
			tabla.addCell(Double.toString(pcSeleccionado.getTO().getPrice()*pcSeleccionado.getCantTO()));
			tabla.addCell(df.format(pcSeleccionado.getTO().getPrice()*pcSeleccionado.getCantTO()*1.21));
        }
        if(pcSeleccionado.getTE()!=null){
        	tabla.addCell("TECLADO");
			tabla.addCell(Integer.toString(pcSeleccionado.getCantTE()));
			tabla.addCell(pcSeleccionado.getTE().getDescription());
			tabla.addCell(Double.toString(pcSeleccionado.getTE().getPrice()*pcSeleccionado.getCantTE()));
			tabla.addCell(df.format(pcSeleccionado.getTE().getPrice()*pcSeleccionado.getCantTE()*1.21));
        }
        if(pcSeleccionado.getRA()!=null){
        	tabla.addCell("RATÓN");
			tabla.addCell(Integer.toString(pcSeleccionado.getCantRA()));
			tabla.addCell(pcSeleccionado.getRA().getDescription());
			tabla.addCell(Double.toString(pcSeleccionado.getRA().getPrice()*pcSeleccionado.getCantRA()));
			tabla.addCell(df.format(pcSeleccionado.getRA().getPrice()*pcSeleccionado.getCantRA()*1.21));
        }
        if(pcSeleccionado.getMO()!=null){
        	tabla.addCell("MONITOR");
			tabla.addCell(Integer.toString(pcSeleccionado.getCantMO()));
			tabla.addCell(pcSeleccionado.getMO().getDescription());
			tabla.addCell(Double.toString(pcSeleccionado.getMO().getPrice()*pcSeleccionado.getCantMO()));
			tabla.addCell(df.format(pcSeleccionado.getMO().getPrice()*pcSeleccionado.getCantMO()*1.21));
        }
        if(pcSeleccionado.getAL()!=null){
        	tabla.addCell("ALTAVOZ");
			tabla.addCell(Integer.toString(pcSeleccionado.getCantAL()));
			tabla.addCell(pcSeleccionado.getAL().getDescription());
			tabla.addCell(Double.toString(pcSeleccionado.getAL().getPrice()*pcSeleccionado.getCantAL()));
			tabla.addCell(df.format(pcSeleccionado.getAL().getPrice()*pcSeleccionado.getCantAL()*1.21));
        }
        if(pcSeleccionado.getMU()!=null){
        	tabla.addCell("MULTILECTOR");
			tabla.addCell(Integer.toString(pcSeleccionado.getCantMU()));
			tabla.addCell(pcSeleccionado.getMU().getDescription());
			tabla.addCell(Double.toString(pcSeleccionado.getMU().getPrice()*pcSeleccionado.getCantMU()));
			tabla.addCell(df.format(pcSeleccionado.getMU().getPrice()*pcSeleccionado.getCantMU()*1.21));
        }
        if(pcSeleccionado.getGR()!=null){
        	tabla.addCell("GRABADORA");
			tabla.addCell(Integer.toString(pcSeleccionado.getCantGR()));
			tabla.addCell(pcSeleccionado.getGR().getDescription());
			tabla.addCell(Double.toString(pcSeleccionado.getGR().getPrice()*pcSeleccionado.getCantGR()));
			tabla.addCell(df.format(pcSeleccionado.getGR().getPrice()*pcSeleccionado.getCantGR()*1.21));
        }
        if(pcSeleccionado.getVE()!=null){
        	tabla.addCell("VENTILADOR");
			tabla.addCell(Integer.toString(pcSeleccionado.getCantVE()));
			tabla.addCell(pcSeleccionado.getVE().getDescription());
			tabla.addCell(Double.toString(pcSeleccionado.getVE().getPrice()*pcSeleccionado.getCantVE()));
			tabla.addCell(df.format(pcSeleccionado.getVE().getPrice()*pcSeleccionado.getCantVE()*1.21));
        }
        if(pcSeleccionado.getFA()!=null){
        	tabla.addCell("FUENTE DE ALIMENTACIÓN");
			tabla.addCell(Integer.toString(pcSeleccionado.getCantFA()));
			tabla.addCell(pcSeleccionado.getFA().getDescription());
			tabla.addCell(Double.toString(pcSeleccionado.getFA().getPrice()*pcSeleccionado.getCantFA()));
			tabla.addCell(df.format(pcSeleccionado.getFA().getPrice()*pcSeleccionado.getCantFA()*1.21));
        }	
        tabla.addCell("TOTAL: ");
        tabla.addCell("");
        tabla.addCell("");
        tabla.addCell("sinIVA: "+pcSeleccionado.getPrecio());
        tabla.addCell("conIVA: "+df.format(pcSeleccionado.getPrecio()*1.21));
        documento.add(tabla);
        documento.close();
    	} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
    }
    
    public PC getPcConfigurado() {
        return pcConfigurado;
    }
    public void setPcConfigurado(PC pcConfigurado) {
        this.pcConfigurado = pcConfigurado;
    }
    public void setTabla(){
        tvTabla.setItems(tienda.getConfiguraciones());
    }
    public void setTienda(Tienda tienda){
        this.tienda = tienda;
        tvTabla.setItems(tienda.getConfiguraciones());
    }
}
