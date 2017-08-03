package Controlador;

import Modelo.PC;
import Modelo.Tienda;
import es.upv.inf.Product;
import es.upv.inf.Product.Category;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConfiguracionController implements Initializable {
       
    private Stage primaryStage;
    @FXML
    private Button addGPU;
    @FXML
    private Button anyGPU;
    @FXML
    private Button resGPU;
    @FXML
    private Button edGPU;
    @FXML
    private Button boGPU;
    @FXML
    private Label sivaGPU;
    @FXML
    private Label civaGPU;
    @FXML
    private Button addPB;
    @FXML
    private Button addPR;
    @FXML
    private Button addMR;
    @FXML
    private Button addGR;
    @FXML
    private Button addDD;
    @FXML
    private Button addTO;
    @FXML
    private Button addTE;
    @FXML
    private Button addRA;
    @FXML
    private Button addMO;
    @FXML
    private Button addAL;
    @FXML
    private Button addMU;
    @FXML
    private Button addVE;
    @FXML
    private Button addFA;
    @FXML
    private TextField cantPB;
    @FXML
    private TextField cantPR;
    @FXML
    private TextField cantMR;
    @FXML
    private TextField cantGR;
    @FXML
    private TextField cantGPU;
    @FXML
    private TextField cantDD;
    @FXML
    private TextField cantTO;
    @FXML
    private TextField cantTE;
    @FXML
    private TextField cantRA;
    @FXML
    private TextField cantMO;
    @FXML
    private TextField cantAL;
    @FXML
    private TextField cantMU;
    @FXML
    private TextField cantVE;
    @FXML
    private TextField cantFA;
    @FXML
    private TextField txtNombre;
    @FXML
    private Button anyPB;
    @FXML
    private Button resPB;
    @FXML
    private Button edPB;
    @FXML
    private Button boPB;
    @FXML
    private Button anyPR;
    @FXML
    private Button resPR;
    @FXML
    private Button edPR;
    @FXML
    private Button boPR;
    @FXML
    private Button anyMR;
    @FXML
    private Button resMR;
    @FXML
    private Button edMR;
    @FXML
    private Button boMR;
    @FXML
    private Button anyGR;
    @FXML
    private Button resGR;
    @FXML
    private Button edGR;
    @FXML
    private Button boGR;
    @FXML
    private Button anyDD;
    @FXML
    private Button resDD;
    @FXML
    private Button edDD;
    @FXML
    private Button boDD;
    @FXML
    private Button anyTO;
    @FXML
    private Button resTO;
    @FXML
    private Button edTO;
    @FXML
    private Button boTO;
    @FXML
    private Button anyTE;
    @FXML
    private Button resTE;
    @FXML
    private Button edTE;
    @FXML
    private Button boTE;
    @FXML
    private Button anyRA;
    @FXML
    private Button resRA;
    @FXML
    private Button edRA;
    @FXML
    private Button boRA;
    @FXML
    private Button anyMO;
    @FXML
    private Button resMO;
    @FXML
    private Button edMO;
    @FXML
    private Button boMO;
    @FXML
    private Button anyAL;
    @FXML
    private Button resAL;
    @FXML
    private Button edAL;
    @FXML
    private Button boAL;
    @FXML
    private Button anyMU;
    @FXML
    private Button resMU;
    @FXML
    private Button edMU;
    @FXML
    private Button boMU;
    @FXML
    private Button anyVE;
    @FXML
    private Button resVE;
    @FXML
    private Button edVE;
    @FXML
    private Button boVE;
    @FXML
    private Button anyFA;
    @FXML
    private Button resFA;
    @FXML
    private Button edFA;
    @FXML
    private Button boFA;
    @FXML
    private Button bGuardar;
    @FXML
    private Button bCancelar;
    @FXML
    private Button bReset;
    @FXML
    private Label sivaPB;
    @FXML
    private Label civaPB;
    @FXML
    private Label sivaPR;
    @FXML
    private Label civaPR;
    @FXML
    private Label sivaMR;
    @FXML
    private Label sivaGR;
    @FXML
    private Label civaGR;
    @FXML
    private Label civaMR;
    @FXML
    private Label sivaDD;
    @FXML
    private Label sivaTO;
    @FXML
    private Label civaDD;
    @FXML
    private Label civaTO;
    @FXML
    private Label sivaTE;
    @FXML
    private Label civaTE;
    @FXML
    private Label sivaRA;
    @FXML
    private Label civaRA;
    @FXML
    private Label sivaMO;
    @FXML
    private Label civaMO;
    @FXML
    private Label sivaAL;
    @FXML
    private Label civaAL;
    @FXML
    private Label sivaMU;
    @FXML
    private Label civaMU;
    @FXML
    private Label sivaVE;
    @FXML
    private Label civaVE;
    @FXML
    private Label civaFA;
    @FXML
    private Label sivaFA;
    @FXML
    private Label totalciva;
    @FXML
    private Label totalsiva;
    @FXML
    private Label lPB;
    @FXML
    private Label lPR;
    @FXML
    private Label lMR;
    @FXML
    private Label lGPU;
    @FXML
    private Label lDD;
    @FXML
    private Label lTO;
    @FXML
    private Label lTE;
    @FXML
    private Label lRA;
    @FXML
    private Label lMO;
    @FXML
    private Label lAL;
    @FXML
    private Label lMU;
    @FXML
    private Label lGR;
    @FXML
    private Label lVE;
    @FXML
    private Label lFA;
            
    private PC pc;
    private PC tempPC;
    private boolean okClicked = false;
    private Tienda tienda;
    //Atributos de la configuracion:
    //Cantidades:
    private int cantiPB;
    private int cantiPR;
    private int cantiMR;
    private int cantiGPU;
    private int cantiDD;
    private int cantiTO;
    private int cantiTE;
    private int cantiRA;
    private int cantiMO;
    private int cantiAL;
    private int cantiMU;
    private int cantiGR;
    private int cantiVE;
    private int cantiFA;
    //Descripciones:
    private String desPB;
    private String desPR;
    private String desMR;
    private String desGPU;
    private String desDD;
    private String desTO;
    private String desTE;
    private String desRA;
    private String desMO;
    private String desAL;
    private String desMU;
    private String desGR;
    private String desVE;
    private String desFA;
    //Precio sin IVA:
    private double psivaPB;
    private double psivaPR;
    private double psivaMR;
    private double psivaGPU;
    private double psivaDD;
    private double psivaTO;
    private double psivaTE;
    private double psivaRA;
    private double psivaMO;
    private double psivaAL;
    private double psivaMU;
    private double psivaGR;
    private double psivaVE;
    private double psivaFA;
    //Precio con IVA:
    private double pcivaPB;
    private double pcivaPR;
    private double pcivaMR;
    private double pcivaGPU;
    private double pcivaDD;
    private double pcivaTO;
    private double pcivaTE;
    private double pcivaRA;
    private double pcivaMO;
    private double pcivaAL;
    private double pcivaMU;
    private double pcivaGR;
    private double pcivaVE;
    private double pcivaFA;
    //Totales:
    private double ptotalsiva;
    private double ptotalciva;
    
    public ConfiguracionController(){
    }
    
    public void setTienda(Tienda tienda){
        this.tienda = tienda;
    }
    
    public void initStage(Stage stage){
        primaryStage = stage;
        primaryStage.setTitle("Configuracion");
    }
    public double Redondear(double numero){
       return Math.rint(numero*100)/100;
    }
    
    public void iniciarTempPC(PC pc){
        this.pc = pc;
        this.tempPC = new PC(pc.getNombre(),  pc.getPB(), pc.getPR(), pc.getMR(), pc.getGPU(), pc.getDD(), pc.getTO(),
        		pc.getTE(), pc.getRA(), pc.getMO(), pc.getAL(), pc.getMU(), pc.getGR(), pc.getVE(), pc.getFA(),
        		pc.getCantPB(), pc.getCantPR(), pc.getCantMR(), pc.getCantGPU(), pc.getCantDD(), pc.getCantTO(),
        		pc.getCantTE(), pc.getCantRA(), pc.getCantMO(), pc.getCantAL(), pc.getCantMU(), pc.getCantGR(), pc.getCantVE(), pc.getCantFA());
      	txtNombre.setText(this.tempPC.getNombre());
    }
    
    public void iniciarVariables(){
        if(tempPC.getPB() != null){
        	this.setCantiPB(tempPC.getCantPB());
        	this.setDesPB(tempPC.getPB().getDescription());
        	this.setPsivaPB(Double.valueOf(Redondear(tempPC.getCantPB()*(tempPC.getPB().getPrice()))));
        	this.setPcivaPB(Double.valueOf(Redondear(psivaPB * 1.21)));
        }
        else{
        	this.setCantiPB(0);
        	this.setDesPB("OBLIGATORIO");
        	this.setPsivaPB(0);
        	this.setPcivaPB(0);
        }
		if(tempPC.getPR() != null){
			this.setDesPR(tempPC.getPR().getDescription());
			this.setCantiPR(tempPC.getCantPR());
	        this.setPsivaPR(Double.valueOf(Redondear((tempPC.getCantPR()*(tempPC.getPR().getPrice())))));
	        this.setPcivaPR(Double.valueOf(Redondear(psivaPR * 1.21)));
        }
		else{
        	this.setCantiPR(0);
        	this.setDesPR("OBLIGATORIO");
        	this.setPsivaPR(0);
        	this.setPcivaPR(0);
        }
		if(tempPC.getMR() != null){
			
			this.setDesMR(tempPC.getMR().getDescription());
			this.setCantiMR(tempPC.getCantMR());
			this.setPsivaMR(Double.valueOf(Redondear((tempPC.getCantMR()*(tempPC.getMR().getPrice())))));
			this.setPcivaMR(Double.valueOf(Redondear(psivaMR * 1.21)));
        }
		else{
        	this.setCantiMR(0);
        	this.setDesMR("OBLIGATORIO");
        	this.setPsivaMR(0);
        	this.setPcivaMR(0);
        }
		if(tempPC.getGPU() != null){
			this.setDesGPU(tempPC.getGPU().getDescription());
			this.setCantiGPU(tempPC.getCantGPU());
			this.setPsivaGPU(Double.valueOf(Redondear((tempPC.getCantGPU()*(tempPC.getGPU().getPrice())))));
			this.setPcivaGPU(Double.valueOf(Redondear(psivaGPU * 1.21)));
		}
		else{
        	this.setCantiGPU(0);
        	this.setDesGPU("OBLIGATORIO");
        	this.setPsivaGPU(0);
        	this.setPcivaGPU(0);
        }
		if(tempPC.getDD() != null){
			this.setDesDD(tempPC.getDD().getDescription());
			this.setCantiDD(tempPC.getCantDD());
			this.setPsivaDD(Double.valueOf(Redondear((tempPC.getCantDD()*(tempPC.getDD().getPrice())))));
			this.setPcivaDD(Double.valueOf(Redondear(psivaDD * 1.21)));
		}
		else{
        	this.setCantiDD(0);
        	this.setDesDD("OBLIGATORIO");
        	this.setPsivaDD(0);
        	this.setPcivaDD(0);
        }
		if(tempPC.getTO() != null){
			this.setDesTO(tempPC.getTO().getDescription());
			this.setCantiTO(tempPC.getCantTO());
			this.setPsivaTO(Double.valueOf(Redondear((tempPC.getCantTO()*(tempPC.getTO().getPrice())))));
			this.setPcivaTO(Double.valueOf(Redondear(psivaTO * 1.21)));
        }
		else{
        	this.setCantiTO(0);
        	this.setDesTO("OBLIGATORIO");
        	this.setPsivaTO(0);
        	this.setPcivaTO(0);
        }
		if(tempPC.getTE() != null){
			this.setDesTE(tempPC.getTE().getDescription());
			this.setCantiTE(tempPC.getCantTE());
			this.setPsivaTE(Double.valueOf(Redondear((tempPC.getCantTE()*(tempPC.getTE().getPrice())))));
			this.setPcivaTE(Double.valueOf(Redondear(psivaTE * 1.21)));
        }
		else{
        	this.setCantiTE(0);
        	this.setDesTE("OPCIONAL");
        	this.setPsivaTE(0);
        	this.setPcivaTE(0);
        	anyTE.setDisable(true);
        	edTE.setDisable(true);
        	boTE.setDisable(true);
        	
        }
		if(tempPC.getRA() != null){
			this.setDesRA(tempPC.getRA().getDescription());
			this.setCantiRA(tempPC.getCantRA());
			this.setPsivaRA(Double.valueOf(Redondear((tempPC.getCantRA()*(tempPC.getRA().getPrice())))));
			this.setPcivaRA(Double.valueOf(Redondear(psivaRA * 1.21)));
		}
		else{
        	this.setCantiRA(0);
        	this.setDesRA("OPCIONAL");
        	this.setPsivaRA(0);
        	this.setPcivaRA(0);
        	anyRA.setDisable(true);
        	edRA.setDisable(true);
        	boRA.setDisable(true);
        }
		if(tempPC.getMO() != null){
			this.setDesMO(tempPC.getMO().getDescription()); 
			this.setCantiMO(tempPC.getCantMO());
			this.setPsivaMO(Double.valueOf(Redondear((tempPC.getCantMO()*(tempPC.getMO().getPrice())))));
			this.setPcivaMO(Double.valueOf(Redondear(psivaMO * 1.21)));
    	}
		else{
        	this.setCantiMO(0);
        	this.setDesMO("OPCIONAL");
        	this.setPsivaMO(0);
        	this.setPcivaMO(0);
        	anyMO.setDisable(true);
        	edMO.setDisable(true);
        	boMO.setDisable(true);
        }
		if(tempPC.getAL() != null){
			this.setDesAL(tempPC.getAL().getDescription());
			this.setCantiAL(tempPC.getCantAL());
			this.setPsivaAL(Double.valueOf(Redondear((tempPC.getCantAL()*(tempPC.getAL().getPrice())))));
			this.setPcivaAL(Double.valueOf(Redondear(psivaAL * 1.21)));
		}
		else{
        	this.setCantiAL(0);
        	this.setDesAL("OPCIONAL");
        	this.setPsivaAL(0);
        	this.setPcivaAL(0);
        	anyAL.setDisable(true);
        	edAL.setDisable(true);
        	boAL.setDisable(true);
        }
		if(tempPC.getMU() != null){
			this.setDesMU(tempPC.getMU().getDescription());
			 this.setCantiMU(tempPC.getCantMU());
			 this.setPsivaMU(Double.valueOf(Redondear((tempPC.getCantMU()*(tempPC.getMU().getPrice())))));
			 this.setPcivaMU(Double.valueOf(Redondear(psivaMU * 1.21)));
		}
		else{
        	this.setCantiMU(0);
        	this.setDesMU("OPCIONAL");
        	this.setPsivaMU(0);
        	this.setPcivaMU(0);
        	anyMU.setDisable(true);
        	edMU.setDisable(true);
        	boMU.setDisable(true);
        }
		if(tempPC.getGR() != null){
			this.setDesGR(tempPC.getGR().getDescription()); 
			this.setCantiGR(tempPC.getCantGR());
			this.setPsivaGR(Double.valueOf(Redondear((tempPC.getCantGR()*(tempPC.getGR().getPrice())))));
			this.setPcivaGR(Double.valueOf(Redondear(psivaGR * 1.21)));
        }
		else{
        	this.setCantiGR(0);
        	this.setDesGR("OPCIONAL");
        	this.setPsivaGR(0);
        	this.setPcivaGR(0);
        	anyGR.setDisable(true);
        	edGR.setDisable(true);
        	boGR.setDisable(true);
        }
		if(tempPC.getVE() != null){
			this.setDesVE(tempPC.getVE().getDescription());
			this.setCantiVE(tempPC.getCantVE());
			this.setPsivaVE(Double.valueOf(Redondear((tempPC.getCantVE()*(tempPC.getVE().getPrice())))));
			this.setPcivaVE(Double.valueOf(Redondear(psivaVE * 1.21)));
	        
		}
		else{
        	this.setCantiVE(0);
        	this.setDesVE("OPCIONAL");
        	this.setPsivaVE(0);
        	this.setPcivaVE(0);
        	anyVE.setDisable(true);
        	edVE.setDisable(true);
        	boVE.setDisable(true);
        }
		if(tempPC.getFA() != null){
			this.setDesFA(tempPC.getFA().getDescription());
			this.setCantiFA(tempPC.getCantFA());
			this.setPsivaFA(Double.valueOf(Redondear((tempPC.getCantFA()*(tempPC.getFA().getPrice())))));
			this.setPcivaFA(Double.valueOf(Redondear(psivaFA * 1.21)));
		}
		else{
        	this.setCantiFA(0);
        	this.setDesFA("OPCIONAL");
        	this.setPsivaFA(0);
        	this.setPcivaFA(0);
        	anyFA.setDisable(true);
        	edFA.setDisable(true);
        	boFA.setDisable(true);
        }
		
        this.setPtotalsiva(Double.valueOf(Redondear(psivaPB +psivaPR +psivaMR +psivaGPU +psivaDD +psivaTO +
                psivaTE +psivaRA +psivaMO +psivaAL +psivaMU +psivaGR +psivaVE +psivaFA)));
        this.setPtotalciva(Double.valueOf(Redondear(pcivaPB +pcivaPR +pcivaMR +pcivaGPU +pcivaDD +pcivaTO +
                pcivaTE +pcivaRA +pcivaMO +pcivaAL +pcivaMU +pcivaGR +pcivaVE +pcivaFA)));
    }
    
    public void mostrarConfiguracion(){
    	//Inicia los labels de las descripciones
        lPB.setText(this.desPB);
        lPR.setText(this.desPR);
        lMR.setText(this.desMR);
        lGPU.setText(this.desGPU);
        lDD.setText(this.desDD);
        lTO.setText(this.desTO);
        lTE.setText(this.desTE);
        lRA.setText(this.desRA);
        lMO.setText(this.desMO);
        lAL.setText(this.desAL);
        lMU.setText(this.desMU);
        lGR.setText(this.desGR);
        lVE.setText(this.desVE);
        lFA.setText(this.desFA);
        //Inicia los labels de las cantidades
        cantPB.setText(Integer.toString(this.cantiPB));
        cantPR.setText(Integer.toString(this.cantiPR));
        cantMR.setText(Integer.toString(this.cantiMR));
        cantGPU.setText(Integer.toString(this.cantiGPU));
        cantDD.setText(Integer.toString(this.cantiDD));
        cantTO.setText(Integer.toString(this.cantiTO));
        cantTE.setText(Integer.toString(this.cantiTE));
        cantRA.setText(Integer.toString(this.cantiRA));
        cantMO.setText(Integer.toString(this.cantiMO));
        cantAL.setText(Integer.toString(this.cantiAL));
        cantMU.setText(Integer.toString(this.cantiMU));
        cantGR.setText(Integer.toString(this.cantiGR));
        cantVE.setText(Integer.toString(this.cantiVE));
        cantFA.setText(Integer.toString(this.cantiFA));
        //Inicia los labels del precio sin IVA
        sivaPB.setText(Double.toString(this.psivaPB));
        sivaPR.setText(Double.toString(this.psivaPR));
        sivaMR.setText(Double.toString(this.psivaMR));
        sivaGPU.setText(Double.toString(this.psivaGPU));
        sivaDD.setText(Double.toString(this.psivaDD));
        sivaTO.setText(Double.toString(this.psivaTO));
        sivaTE.setText(Double.toString(this.psivaTE));
        sivaRA.setText(Double.toString(this.psivaRA));
        sivaMO.setText(Double.toString(this.psivaMO));
        sivaAL.setText(Double.toString(this.psivaAL));
        sivaMU.setText(Double.toString(this.psivaMU));
        sivaGR.setText(Double.toString(this.psivaGR));
        sivaVE.setText(Double.toString(this.psivaVE));
        sivaFA.setText(Double.toString(this.psivaFA));
        //Inicia los labels del precio con IVA
        civaPB.setText(Double.toString(this.pcivaPB));
        civaPR.setText(Double.toString(this.pcivaPR));
        civaMR.setText(Double.toString(this.pcivaMR));
        civaGPU.setText(Double.toString(this.pcivaGPU));
        civaDD.setText(Double.toString(this.pcivaDD));
        civaTO.setText(Double.toString(this.pcivaTO));
        civaTE.setText(Double.toString(this.pcivaTE));
        civaRA.setText(Double.toString(this.pcivaRA));
        civaMO.setText(Double.toString(this.pcivaMO));
        civaAL.setText(Double.toString(this.pcivaAL));
        civaMU.setText(Double.toString(this.pcivaMU));
        civaGR.setText(Double.toString(this.pcivaGR));
        civaVE.setText(Double.toString(this.pcivaVE));
        civaFA.setText(Double.toString(this.pcivaFA));
        //Inicializar el total sin iva y con iva
        totalsiva.setText(Double.toString(this.ptotalsiva));
        totalciva.setText(Double.toString(this.ptotalciva));
    }
    
    public boolean isOkClicked() {
        return okClicked;
    }
    @FXML
    private void pulsarGuardar(ActionEvent event){
    	String mPB = "";
    	String mPR = "";
    	String mMR = "";
    	String mGPU = "";
    	String mDD = "";
    	String mTO = "";
    	
    	if(this.tempPC.getPB()==null || this.tempPC.getPR()==null || this.tempPC.getMR()==null || this.tempPC.getGPU()==null || this.tempPC.getDD()==null || this.tempPC.getTO()==null){
			if(this.tempPC.getPB()==null){mPB = "-Falta la Placa Base.\n";}
			if(this.tempPC.getPR()==null){mPR = "-Falta el Procesador.\n";}
			if(this.tempPC.getMR()==null){mMR = "-Falta la Memória Ram.\n";}
			if(this.tempPC.getGPU()==null){mGPU = "-Falta la Gráfica.\n";}
			if(this.tempPC.getDD()==null){mDD = "-Falta el Disco Duro.\n";}
			if(this.tempPC.getTO()==null){mTO = "-Falta la Torre.\n";}
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("Faltan componentes obligatorios:");
			alert.setContentText(mPB + mPR + mMR + mGPU + mDD + mTO);
			alert.showAndWait();
		}
    	else{
    		if(txtNombre.getText()==null){
    			this.tempPC.setNombre("Configuración id: "+this.tienda.getId());
    			this.tienda.sumarId();
    		}
    		else{
	    	this.tempPC.setNombre(txtNombre.getText());
    		}
	        this.pc = this.tempPC;
	        tienda.getPrincipalController().setPcConfigurado(this.pc);
	        tienda.getPrincipalController().setTienda(tienda);
	        okClicked = true;
	        primaryStage.close();
		}
    }
    
    @FXML
    private void cancelar(ActionEvent event){
    	this.tempPC = null;
        tienda.getPrincipalController().setPcConfigurado(this.pc);
        tienda.getPrincipalController().setTienda(tienda);
    	okClicked = false;
    	primaryStage.close();
    	System.out.println("Cancelar pulsado");
    }
    
    @FXML
    private void resetear(ActionEvent event){
    	this.tempPC = new PC(this.pc.getNombre(),  this.pc.getPB(), this.pc.getPR(), this.pc.getMR(), this.pc.getGPU(), this.pc.getDD(), this.pc.getTO(),
        		this.pc.getTE(), this.pc.getRA(), this.pc.getMO(), this.pc.getAL(), this.pc.getMU(), this.pc.getGR(), this.pc.getVE(), this.pc.getFA(),
        		this.pc.getCantPB(), this.pc.getCantPR(), this.pc.getCantMR(), this.pc.getCantGPU(), this.pc.getCantDD(), this.pc.getCantTO(),
        		this.pc.getCantTE(), this.pc.getCantRA(), this.pc.getCantMO(), this.pc.getCantAL(), this.pc.getCantMU(), this.pc.getCantGR(), this.pc.getCantVE(), this.pc.getCantFA());
    	iniciarVariables();
    	mostrarConfiguracion();
    	System.out.println("Resetear pulsado");
    	
    }
    
    @FXML
    private void sumaPB(ActionEvent event){
    	this.tempPC.sumarPB();
        this.cantiPB++;
        this.psivaPB = Double.valueOf(Redondear((this.tempPC.getPB().getPrice()*this.cantiPB)));
        this.pcivaPB = Double.valueOf(Redondear((this.psivaPB * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) + Double.valueOf(Redondear((this.tempPC.getPB().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void sumaPR(ActionEvent event){
    	this.tempPC.sumarPR();
        this.cantiPR++;
        this.psivaPR = Double.valueOf(Redondear((this.tempPC.getPR().getPrice()*this.cantiPR)));
        this.pcivaPR = Double.valueOf(Redondear((this.psivaPR * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) + Double.valueOf(Redondear((this.tempPC.getPR().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void sumaMR(ActionEvent event){
    	this.tempPC.sumarMR();
        this.cantiMR++;
        this.psivaMR = Double.valueOf(Redondear((this.tempPC.getMR().getPrice()*this.cantiMR)));
        this.pcivaMR = Double.valueOf(Redondear((this.psivaMR * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) + Double.valueOf(Redondear((this.tempPC.getMR().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    
    @FXML
    private void sumaGPU(ActionEvent event){
    	this.tempPC.sumarGPU();
        this.cantiGPU++;
        this.psivaGPU = Double.valueOf(Redondear((this.tempPC.getGPU().getPrice()*this.cantiGPU)));
        this.pcivaGPU = Double.valueOf(Redondear((this.psivaGPU * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) + Double.valueOf(Redondear((this.tempPC.getGPU().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void sumaDD(ActionEvent event){
    	this.tempPC.sumarDD();
        this.cantiDD++;
        this.psivaDD = Double.valueOf(Redondear((this.tempPC.getDD().getPrice()*this.cantiDD)));
        this.pcivaDD = Double.valueOf(Redondear((this.psivaDD * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) + Double.valueOf(Redondear((this.tempPC.getDD().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    
    @FXML
    private void sumaTO(ActionEvent event){
    	this.tempPC.sumarTO();
        this.cantiTO++;
        this.psivaTO = Double.valueOf(Redondear((this.tempPC.getTO().getPrice()*this.cantiTO)));
        this.pcivaTO = Double.valueOf(Redondear((this.psivaTO * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) + Double.valueOf(Redondear((this.tempPC.getTO().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void sumaTE(ActionEvent event){
    	this.tempPC.sumarTE();
        this.cantiTE++;
        this.psivaTE = Double.valueOf(Redondear((this.tempPC.getTE().getPrice()*this.cantiTE)));
        this.pcivaTE = Double.valueOf(Redondear((this.psivaTE * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) + Double.valueOf(Redondear((this.tempPC.getTE().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void sumaRA(ActionEvent event){
    	this.tempPC.sumarRA();
        this.cantiRA++;
        this.psivaRA = Double.valueOf(Redondear((this.tempPC.getRA().getPrice()*this.cantiRA)));
        this.pcivaRA = Double.valueOf(Redondear((this.psivaRA * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) + Double.valueOf(Redondear((this.tempPC.getRA().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void sumaMO(ActionEvent event){
    	this.tempPC.sumarMO();
        this.cantiMO++;
        this.psivaMO = Double.valueOf(Redondear((this.tempPC.getMO().getPrice()*this.cantiMO)));
        this.pcivaMO = Double.valueOf(Redondear((this.psivaMO * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) + Double.valueOf(Redondear((this.tempPC.getMO().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void sumaAL(ActionEvent event){
    	this.tempPC.sumarAL();
        this.cantiAL++;
        this.psivaAL = Double.valueOf(Redondear((this.tempPC.getAL().getPrice()*this.cantiAL)));
        this.pcivaAL = Double.valueOf(Redondear((this.psivaAL * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) + Double.valueOf(Redondear((this.tempPC.getAL().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void sumaMU(ActionEvent event){
    	this.tempPC.sumarMU();
        this.cantiMU++;
        this.psivaMU = Double.valueOf(Redondear((this.tempPC.getMU().getPrice()*this.cantiMU)));
        this.pcivaMU = Double.valueOf(Redondear((this.psivaMU * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) + Double.valueOf(Redondear((this.tempPC.getMU().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void sumaGR(ActionEvent event){
    	this.tempPC.sumarGR();
        this.cantiGR++;
        this.psivaGR = Double.valueOf(Redondear((this.tempPC.getGR().getPrice()*this.cantiGR)));
        this.pcivaGR = Double.valueOf(Redondear((this.psivaGR * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) + Double.valueOf(Redondear((this.tempPC.getGR().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void sumaVE(ActionEvent event){
    	this.tempPC.sumarVE();
        this.cantiVE++;
        this.psivaVE = Double.valueOf(Redondear((this.tempPC.getVE().getPrice()*this.cantiVE)));
        this.pcivaVE = Double.valueOf(Redondear((this.psivaVE * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) + Double.valueOf(Redondear((this.tempPC.getVE().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void sumaFA(ActionEvent event){
    	this.tempPC.sumarFA();
        this.cantiFA++;
        this.psivaFA = Double.valueOf(Redondear((this.tempPC.getFA().getPrice()*this.cantiFA)));
        this.pcivaFA = Double.valueOf(Redondear((this.psivaFA * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) + Double.valueOf(Redondear((this.tempPC.getFA().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void restaPB(ActionEvent event){
    	this.tempPC.restarPB();
        this.cantiPB--;
        this.psivaPB = Double.valueOf(Redondear((this.tempPC.getPB().getPrice()*this.cantiPB)));
        this.pcivaPB = Double.valueOf(Redondear((this.psivaPB * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Double.valueOf(Redondear((this.tempPC.getPB().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void restaPR(ActionEvent event){
    	this.tempPC.restarPR();
        this.cantiPR--;
        this.psivaPR = Double.valueOf(Redondear((this.tempPC.getPR().getPrice()*this.cantiPR)));
        this.pcivaPR = Double.valueOf(Redondear((this.psivaPR * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Double.valueOf(Redondear((this.tempPC.getPR().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void restaMR(ActionEvent event){
    	this.tempPC.restarMR();
        this.cantiMR--;
        this.psivaMR = Double.valueOf(Redondear((this.tempPC.getMR().getPrice()*this.cantiMR)));
        this.pcivaMR = Double.valueOf(Redondear((this.psivaMR * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Double.valueOf(Redondear((this.tempPC.getMR().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void restaGPU(ActionEvent event){
    	this.tempPC.restarGPU();
        this.cantiGPU--;
        this.psivaGPU = Double.valueOf(Redondear((this.tempPC.getGPU().getPrice()*this.cantiGPU)));
        this.pcivaGPU = Double.valueOf(Redondear((this.psivaGPU * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Double.valueOf(Redondear((this.tempPC.getGPU().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void restaDD(ActionEvent event){
    	this.tempPC.restarDD();
        this.cantiDD--;
        this.psivaDD = Double.valueOf(Redondear((this.tempPC.getDD().getPrice()*this.cantiDD)));
        this.pcivaDD = Double.valueOf(Redondear((this.psivaDD * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Double.valueOf(Redondear((this.tempPC.getDD().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    
    @FXML
    private void restaTO(ActionEvent event){
    	this.tempPC.restarTO();
        this.cantiTO--;
        this.psivaTO = Double.valueOf(Redondear((this.tempPC.getTO().getPrice()*this.cantiTO)));
        this.pcivaTO = Double.valueOf(Redondear((this.psivaTO * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Double.valueOf(Redondear((this.tempPC.getTO().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void restaTE(ActionEvent event){
    	this.tempPC.restarTE();
        this.cantiTE--;
        this.psivaTE = Double.valueOf(Redondear((this.tempPC.getTE().getPrice()*this.cantiTE)));
        this.pcivaTE = Double.valueOf(Redondear((this.psivaTE * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Double.valueOf(Redondear((this.tempPC.getTE().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void restaRA(ActionEvent event){
    	this.tempPC.restarRA();
        this.cantiRA--;
        this.psivaRA = Double.valueOf(Redondear((this.tempPC.getRA().getPrice()*this.cantiRA)));
        this.pcivaRA = Double.valueOf(Redondear((this.psivaRA * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Double.valueOf(Redondear((this.tempPC.getRA().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void restaMO(ActionEvent event){
    	this.tempPC.restarMO();
        this.cantiMO--;
        this.psivaMO = Double.valueOf(Redondear((this.tempPC.getMO().getPrice()*this.cantiMO)));
        this.pcivaMO = Double.valueOf(Redondear((this.psivaMO * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Double.valueOf(Redondear((this.tempPC.getMO().getPrice()))));
        this.ptotalciva = Double.valueOf(Redondear((this.ptotalsiva * 1.21)));
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void restaAL(ActionEvent event){
    	this.tempPC.restarAL();
        this.cantiAL--;
        this.psivaAL = Double.valueOf(Redondear((this.tempPC.getAL().getPrice()*this.cantiAL)));
        this.pcivaAL = Double.valueOf(Redondear((this.psivaAL * 1.21)));
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getAL().getPrice()));
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void restaMU(ActionEvent event){
    	this.tempPC.restarMU();
        this.cantiMU--;
        this.psivaMU = Redondear(this.tempPC.getMU().getPrice()*this.cantiMU);
        this.pcivaMU = Redondear(this.psivaMU * 1.21);
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getMU().getPrice()));
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void restaGR(ActionEvent event){
    	this.tempPC.restarGR();
        this.cantiGR--;
        this.psivaGR = Redondear(this.tempPC.getGR().getPrice()*this.cantiGR);
        this.pcivaGR = Redondear(this.psivaGR * 1.21);
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getGR().getPrice()));
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void restaVE(ActionEvent event){
    	this.tempPC.restarVE();
        this.cantiVE--;
        this.psivaVE = Redondear(this.tempPC.getVE().getPrice()*this.cantiVE);
        this.pcivaVE = Redondear(this.psivaVE * 1.21);
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getVE().getPrice()));
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    @FXML
    private void restaFA(ActionEvent event){
    	this.tempPC.restarFA();
        this.cantiFA--;
        this.psivaFA = Redondear(this.tempPC.getFA().getPrice()*this.cantiFA);
        this.pcivaFA = Redondear(this.psivaFA * 1.21);
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getFA().getPrice()));
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        this.tempPC.setPrecio(this.ptotalsiva);
        mostrarConfiguracion();
    }
    
    @FXML
    private void borrarPB(ActionEvent event){
    	this.tempPC.setCantPB(0);
        this.desPB = "OBLIGATORIO";
        this.psivaPB = 0;
        this.pcivaPB = 0;
        if(this.tempPC.getPB() != null){
        	this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getPB().getPrice() * this.cantiPB));
        	this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        	this.tempPC.setPrecio(this.ptotalsiva);
        }
        this.cantiPB = 0;
        this.tempPC.setPB(null);
        mostrarConfiguracion();
    }
    @FXML
    private void borrarPR(ActionEvent event){
    	this.tempPC.setCantPR(0);
        this.desPR = "OBLIGATORIO";
        this.psivaPR = 0;
        this.pcivaPR = 0;
        if(this.tempPC.getPR() != null){
	        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getPR().getPrice() * this.cantiPR));
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
	        this.tempPC.setPrecio(this.ptotalsiva);
        }
        this.cantiPR = 0;
        this.tempPC.setPR(null);
        mostrarConfiguracion();
    }
    @FXML
    private void borrarMR(ActionEvent event){
    	this.tempPC.setCantMR(0);
        this.desMR = "OBLIGATORIO";
        this.psivaMR = 0;
        this.pcivaMR = 0;
        if(this.tempPC.getMR() != null){
	        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getMR().getPrice() * this.cantiMR));
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
	        this.tempPC.setPrecio(this.ptotalsiva);
        }
        this.cantiMR = 0;
        this.tempPC.setMR(null);
        mostrarConfiguracion();
    }
    @FXML
    private void borrarGPU(ActionEvent event){
    	this.tempPC.setCantGPU(0);
        this.desGPU = "OBLIGATORIO";
        this.psivaGPU = 0;
        this.pcivaGPU = 0;
        if(this.tempPC.getGPU() != null){
	        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getGPU().getPrice() * this.cantiGPU));
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
	        this.tempPC.setPrecio(this.ptotalsiva);
        }
        this.cantiGPU = 0;
        this.tempPC.setGPU(null);
        mostrarConfiguracion();
    }
    @FXML
    private void borrarDD(ActionEvent event){
    	this.tempPC.setCantDD(0);
        this.desDD = "OBLIGATORIO";
        this.psivaDD = 0;
        this.pcivaDD = 0;
        if(this.tempPC.getDD() != null){
	        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getDD().getPrice() * this.cantiDD));
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
	        this.tempPC.setPrecio(this.ptotalsiva);
        }
        this.cantiDD = 0;
        this.tempPC.setDD(null);
        mostrarConfiguracion();
    }
    
    @FXML
    private void borrarTO(ActionEvent event){
    	this.tempPC.setCantTO(0);
        this.desTO = "OBLIGATORIO";
        this.psivaTO = 0;
        this.pcivaTO = 0;
        if(this.tempPC.getTO() != null){
	        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getTO().getPrice() * this.cantiTO));
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
	        this.tempPC.setPrecio(this.ptotalsiva);
        }
        this.cantiTO = 0;
        this.tempPC.setTO(null);
        mostrarConfiguracion();
    }
    @FXML
    private void borrarTE(ActionEvent event){
    	this.tempPC.setCantTE(0);
        this.desTE = "OPCIONAL";
        this.psivaTE = 0;
        this.pcivaTE = 0;
        if(this.tempPC.getTE() != null){
	        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getTE().getPrice() * this.cantiTE));
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
	        this.tempPC.setPrecio(this.ptotalsiva);
        }
        this.cantiTE = 0;
        this.tempPC.setTE(null);
        mostrarConfiguracion();
    }
    @FXML
    private void borrarRA(ActionEvent event){
    	this.tempPC.setCantRA(0);
        this.desRA = "OPCIONAL";
        this.psivaRA = 0;
        this.pcivaRA = 0;
        if(this.tempPC.getRA() != null){
	        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getRA().getPrice() * this.cantiRA));
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
	        this.tempPC.setPrecio(this.ptotalsiva);
        }
        this.cantiRA = 0;
        this.tempPC.setRA(null);
        mostrarConfiguracion();
    }
    @FXML
    private void borrarMO(ActionEvent event){
    	this.tempPC.setCantMO(0);
        this.desMO = "OPCIONAL";
        this.psivaMO = 0;
        this.pcivaMO = 0;
        if(this.tempPC.getMO() != null){
	        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getMO().getPrice() * this.cantiMO));
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
	        this.tempPC.setPrecio(this.ptotalsiva);
        }
        this.cantiMO = 0;
        this.tempPC.setMO(null);
        mostrarConfiguracion();
    }
    @FXML
    private void borrarAL(ActionEvent event){
    	this.tempPC.setCantAL(0);
        this.desAL = "OPCIONAL";
        this.psivaAL = 0;
        this.pcivaAL = 0;
        if(this.tempPC.getAL() != null){
	        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getAL().getPrice() * this.cantiAL));
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
	        this.tempPC.setPrecio(this.ptotalsiva);
        }
        this.cantiAL = 0;
        this.tempPC.setAL(null);
        mostrarConfiguracion();
    }
    @FXML
    private void borrarMU(ActionEvent event){
    	this.tempPC.setCantMU(0);
        this.desMU = "OPCIONAL";
        this.psivaMU = 0;
        this.pcivaMU = 0;
        if(this.tempPC.getMU() != null){
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getMU().getPrice() * this.cantiMU));
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        this.tempPC.setPrecio(this.ptotalsiva);
        }
        this.cantiMU = 0;
        this.tempPC.setMU(null);
        mostrarConfiguracion();
    }
    @FXML
    private void borrarGR(ActionEvent event){
    	this.tempPC.setCantGR(0);
        this.desGR = "OPCIONAL";
        this.psivaGR = 0;
        this.pcivaGR = 0;
        if(this.tempPC.getGR() != null){
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getGR().getPrice() * this.cantiGR));
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        this.tempPC.setPrecio(this.ptotalsiva);
        }
        this.cantiGR = 0;
        this.tempPC.setGR(null);
        mostrarConfiguracion();
    }
    @FXML
    private void borrarVE(ActionEvent event){
    	this.tempPC.setCantVE(0);
        this.desVE = "OPCIONAL";
        this.psivaVE = 0;
        this.pcivaVE = 0;
        if(this.tempPC.getVE() != null){
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getVE().getPrice() * this.cantiVE));
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        this.tempPC.setPrecio(this.ptotalsiva);
        }
        this.cantiVE = 0;
        this.tempPC.setVE(null);
        mostrarConfiguracion();
    }
    @FXML
    private void borrarFA(ActionEvent event){
    	this.tempPC.setCantFA(0);
        this.desFA = "OPCIONAL";
        this.psivaFA = 0;
        this.pcivaFA = 0;
        if(this.tempPC.getFA() != null){
        this.ptotalsiva = Redondear(Double.valueOf(Redondear(this.ptotalsiva)) - Redondear(this.tempPC.getFA().getPrice() * this.cantiFA));
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        this.tempPC.setPrecio(this.ptotalsiva);
        }
        this.cantiFA = 0;
        this.tempPC.setFA(null);
        mostrarConfiguracion();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
        cantPB.textProperty().addListener((observable, oldValue, newValue) -> {
        if(Integer.parseInt(newValue)==0){
            resPB.setDisable(true);
        }
        else{
            resPB.setDisable(false);
        }
    });
        cantPR.textProperty().addListener((observable, oldValue, newValue) -> {
        if(Integer.parseInt(newValue)==0){
            resPR.setDisable(true);
        }
        else{
            resPR.setDisable(false);
        }
    });
        cantMR.textProperty().addListener((observable, oldValue, newValue) -> {
        if(Integer.parseInt(newValue)==0){
            resMR.setDisable(true);
        }
        else{
            resMR.setDisable(false);
        }
    });
        cantGPU.textProperty().addListener((observable, oldValue, newValue) -> {
        if(Integer.parseInt(newValue)==0){
            resGPU.setDisable(true);
        }
        else{
            resGPU.setDisable(false);
        }
    });
        cantDD.textProperty().addListener((observable, oldValue, newValue) -> {
        if(Integer.parseInt(newValue)==0){
            resDD.setDisable(true);
        }
        else{
            resDD.setDisable(false);
        }
    });
        cantTO.textProperty().addListener((observable, oldValue, newValue) -> {
            if(Integer.parseInt(newValue)==0){
                resTO.setDisable(true);
            }
            else{
                resTO.setDisable(false);
            }
    });
        cantTE.textProperty().addListener((observable, oldValue, newValue) -> {
        if(Integer.parseInt(newValue)==0){
            resTE.setDisable(true);
        }
        else{
            resTE.setDisable(false);
        }
    });
        cantRA.textProperty().addListener((observable, oldValue, newValue) -> {
        if(Integer.parseInt(newValue)==0){
            resRA.setDisable(true);
        }
        else{
            resRA.setDisable(false);
        }
    });
        cantMO.textProperty().addListener((observable, oldValue, newValue) -> {
        if(Integer.parseInt(newValue)==0){
            resMO.setDisable(true);
        }
        else{
            resMO.setDisable(false);
        }
    });
        cantAL.textProperty().addListener((observable, oldValue, newValue) -> {
        if(Integer.parseInt(newValue)==0){
            resAL.setDisable(true);
        }
        else{
            resAL.setDisable(false);
        }
    });
        cantMU.textProperty().addListener((observable, oldValue, newValue) -> {
        if(Integer.parseInt(newValue)==0){
            resMU.setDisable(true);
        }
        else{
            resMU.setDisable(false);
        }
    });
        cantGR.textProperty().addListener((observable, oldValue, newValue) -> {
        if(Integer.parseInt(newValue)==0){
            resGR.setDisable(true);
        }
        else{
            resGR.setDisable(false);
        }
    });
        cantVE.textProperty().addListener((observable, oldValue, newValue) -> {
        if(Integer.parseInt(newValue)==0){
            resVE.setDisable(true);
        }
        else{
            resVE.setDisable(false);
        }
    });
        cantFA.textProperty().addListener((observable, oldValue, newValue) -> {
        if(Integer.parseInt(newValue)==0){
            resFA.setDisable(true);
        }
        else{
            resFA.setDisable(false);
        }
    });
        
        lPB.textProperty().addListener((observable, oldValue, newValue) -> {
        if(this.desPB.equals("OBLIGATORIO")){
            anyPB.setDisable(true);
            resPB.setDisable(true);
            edPB.setDisable(true);
            boPB.setDisable(true);
            addPB.setDisable(false);
        }
        else{
            anyPB.setDisable(false);
            resPB.setDisable(false);
            edPB.setDisable(false);
            boPB.setDisable(false);
            addPB.setDisable(true);
        }
    });
        
        lPR.textProperty().addListener((observable, oldValue, newValue) -> {
        if(this.desPR.equals("OBLIGATORIO")){
            anyPR.setDisable(true);
            resPR.setDisable(true);
            edPR.setDisable(true);
            boPR.setDisable(true);
            addPR.setDisable(false);
        }
        else{
            anyPR.setDisable(false);
            resPR.setDisable(false);
            edPR.setDisable(false);
            boPR.setDisable(false);
            addPR.setDisable(true);
        }
    });
        
        lMR.textProperty().addListener((observable, oldValue, newValue) -> {
        if(this.desMR.equals("OBLIGATORIO")){
            anyMR.setDisable(true);
            resMR.setDisable(true);
            edMR.setDisable(true);
            boMR.setDisable(true);
            addMR.setDisable(false);
        }
        else{
            anyMR.setDisable(false);
            resMR.setDisable(false);
            edMR.setDisable(false);
            boMR.setDisable(false);
            addMR.setDisable(true);
        }
    });
        
        lGPU.textProperty().addListener((observable, oldValue, newValue) -> {
        if(this.desGPU.equals("OBLIGATORIO")){
            anyGPU.setDisable(true);
            resGPU.setDisable(true);
            edGPU.setDisable(true);
            boGPU.setDisable(true);
            addGPU.setDisable(false);
        }
        else{
            anyGPU.setDisable(false);
            resGPU.setDisable(false);
            edGPU.setDisable(false);
            boGPU.setDisable(false);
            addGPU.setDisable(true);
        }
    });
        
        lDD.textProperty().addListener((observable, oldValue, newValue) -> {
        if(this.desDD.equals("OBLIGATORIO")){
            anyDD.setDisable(true);
            resDD.setDisable(true);
            edDD.setDisable(true);
            boDD.setDisable(true);
            addDD.setDisable(false);
        }
        else{
            anyDD.setDisable(false);
            resDD.setDisable(false);
            edDD.setDisable(false);
            boDD.setDisable(false);
            addDD.setDisable(true);
        }
    });
        
        lTO.textProperty().addListener((observable, oldValue, newValue) -> {
        if(this.desTO.equals("OBLIGATORIO")){
            anyTO.setDisable(true);
            resTO.setDisable(true);
            edTO.setDisable(true);
            boTO.setDisable(true);
            addTO.setDisable(false);
        }
        else{
            anyTO.setDisable(false);
            resTO.setDisable(false);
            edTO.setDisable(false);
            boTO.setDisable(false);
            addTO.setDisable(true);
        }
    });
        
        lTE.textProperty().addListener((observable, oldValue, newValue) -> {
        if(this.desTE.equals("OPCIONAL")){
            anyTE.setDisable(true);
            resTE.setDisable(true);
            edTE.setDisable(true);
            boTE.setDisable(true);
            addTE.setDisable(false);
        }
        else{
            anyTE.setDisable(false);
            resTE.setDisable(false);
            edTE.setDisable(false);
            boTE.setDisable(false);
            addTE.setDisable(true);
        }
    });
        
        lRA.textProperty().addListener((observable, oldValue, newValue) -> {
        if(this.desRA.equals("OPCIONAL")){
            anyRA.setDisable(true);
            resRA.setDisable(true);
            edRA.setDisable(true);
            boRA.setDisable(true);
            addRA.setDisable(false);
        }
        else{
            anyRA.setDisable(false);
            resRA.setDisable(false);
            edRA.setDisable(false);
            boRA.setDisable(false);
            addRA.setDisable(true);
        }
    });
        
        lMO.textProperty().addListener((observable, oldValue, newValue) -> {
        if(this.desMO.equals("OPCIONAL")){
            anyMO.setDisable(true);
            resMO.setDisable(true);
            edMO.setDisable(true);
            boMO.setDisable(true);
            addMO.setDisable(false);
        }
        else{
            anyMO.setDisable(false);
            resMO.setDisable(false);
            edMO.setDisable(false);
            boMO.setDisable(false);
            addMO.setDisable(true);
        }
    });
        
        lAL.textProperty().addListener((observable, oldValue, newValue) -> {
        if(this.desAL.equals("OPCIONAL")){
            anyAL.setDisable(true);
            resAL.setDisable(true);
            edAL.setDisable(true);
            boAL.setDisable(true);
            addAL.setDisable(false);
        }
        else{
            anyAL.setDisable(false);
            resAL.setDisable(false);
            edAL.setDisable(false);
            boAL.setDisable(false);
            addAL.setDisable(true);
        }
    });
        
        lMU.textProperty().addListener((observable, oldValue, newValue) -> {
        if(this.desMU.equals("OPCIONAL")){
            anyMU.setDisable(true);
            resMU.setDisable(true);
            edMU.setDisable(true);
            boMU.setDisable(true);
            addMU.setDisable(false);
        }
        else{
            anyMU.setDisable(false);
            resMU.setDisable(false);
            edMU.setDisable(false);
            boMU.setDisable(false);
            addMU.setDisable(true);
        }
    });
        
        lGR.textProperty().addListener((observable, oldValue, newValue) -> {
        if(this.desGR.equals("OPCIONAL")){
            anyGR.setDisable(true);
            resGR.setDisable(true);
            edGR.setDisable(true);
            boGR.setDisable(true);
            addGR.setDisable(false);
        }
        else{
            anyGR.setDisable(false);
            resGR.setDisable(false);
            edGR.setDisable(false);
            boGR.setDisable(false);
            addGR.setDisable(true);
        }
    });
        
        lVE.textProperty().addListener((observable, oldValue, newValue) -> {
        if(this.desVE.equals("OPCIONAL")){
            anyVE.setDisable(true);
            resVE.setDisable(true);
            edVE.setDisable(true);
            boVE.setDisable(true);
            addVE.setDisable(false);
        }
        else{
            anyVE.setDisable(false);
            resVE.setDisable(false);
            edVE.setDisable(false);
            boVE.setDisable(false);
            addVE.setDisable(true);
        }
    });
        
        lFA.textProperty().addListener((observable, oldValue, newValue) -> {
        if(this.desFA.equals("OPCIONAL")){
            anyFA.setDisable(true);
            resFA.setDisable(true);
            edFA.setDisable(true);
            boFA.setDisable(true);
            addFA.setDisable(false);
        }
        else{
            anyFA.setDisable(false);
            resFA.setDisable(false);
            edFA.setDisable(false);
            boFA.setDisable(false);
            addFA.setDisable(true);
        }
    });
    }
       
    @FXML
    private void irABusquedaCPU(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.CPU);
        tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaSPEAKER(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.SPEAKER);
        tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaHDD(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.HDD);
        tienda.mostrarBusqueda(productoSel);
    }
            
    @FXML
    private void irABusquedaPOWER_SUPPLY(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.POWER_SUPPLY);
        tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaDVD_WRITER(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.DVD_WRITER);
        tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaRAM(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.RAM);
        tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaSCREEN(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.SCREEN);
        tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaMULTIREADER(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.MULTIREADER);
        tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaMOTHERBOARD(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.MOTHERBOARD);
        tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaMOUSE(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.MOUSE);
        tienda.mostrarBusqueda(productoSel);
    }
    @FXML
    private void irABusquedaGPU(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.GPU);
        tienda.mostrarBusqueda(productoSel);
    }
    @FXML
    private void irABusquedaKEYBOARD(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.KEYBOARD);
        tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaCASE(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.CASE);
        tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaFAN(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.FAN);
        tienda.mostrarBusqueda(productoSel);
    }
    void salirAccion(ActionEvent event) {
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }
    
    public void setCantiPB(int cantiPB) {
        this.cantiPB = cantiPB;
    }
    public void setCantiPR(int cantiPR) {
        this.cantiPR = cantiPR;
    }
	public void setCantiMR(int cantiMR) {
        this.cantiMR = cantiMR;
    }
	public void setCantiGPU(int cantiGPU) {
        this.cantiGPU = cantiGPU;
    }
	public void setCantiDD(int cantiDD) {
        this.cantiDD = cantiDD;
    }
	public void setCantiTO(int cantiTO) {
        this.cantiTO = cantiTO;
    }
	public void setCantiTE(int cantiTE) {
        this.cantiTE = cantiTE;
    }
	public void setCantiRA(int cantiRA) {
        this.cantiRA = cantiRA;
    }
	public void setCantiMO(int cantiMO) {
        this.cantiMO = cantiMO;
    }
	public void setCantiAL(int cantiAL) {
        this.cantiAL = cantiAL;
    }
	public void setCantiMU(int cantiMU) {
        this.cantiMU = cantiMU;
    }
	public void setCantiGR(int cantiGR) {
        this.cantiGR = cantiGR;
    }
 	public void setCantiVE(int cantiVE) {
        this.cantiVE = cantiVE;
    }
 	public void setCantiFA(int cantiFA) {
        this.cantiFA = cantiFA;
    }
	public void setDesPB(String desPB) {
        this.desPB = desPB;
    }
	public void setDesPR(String desPR) {
        this.desPR = desPR;
    }
	public void setDesMR(String desMR) {
        this.desMR = desMR;
    }
	public void setDesGPU(String desGPU) {
        this.desGPU = desGPU;
    }
	public void setDesDD(String desDD) {
        this.desDD = desDD;
    }
	public void setDesTO(String desTO) {
        this.desTO = desTO;
    }
	public void setDesTE(String desTE) {
        this.desTE = desTE;
    }
	public void setDesRA(String desRA) {
        this.desRA = desRA;
    }
	public void setDesMO(String desMO) {
        this.desMO = desMO;
    }
	public void setDesAL(String desAL) {
        this.desAL = desAL;
    }
	public void setDesMU(String desMU) {
        this.desMU = desMU;
    }
	public void setDesGR(String desGR) {
        this.desGR = desGR;
    }
	public void setDesVE(String desVE) {
        this.desVE = desVE;
    }
	public void setDesFA(String desFA) {
        this.desFA = desFA;
    }
	public void setPsivaPB(double psivaPB) {
        this.psivaPB = psivaPB;
    }
	public void setPsivaPR(double psivaPR) {
        this.psivaPR = psivaPR;
    }
	public void setPsivaMR(double psivaMR) {
        this.psivaMR = psivaMR;
    }
	public void setPsivaGPU(double psivaGPU) {
        this.psivaGPU = psivaGPU;
    }
	public void setPsivaDD(double psivaDD) {
        this.psivaDD = psivaDD;
    }
	public void setPsivaTO(double psivaTO) {
        this.psivaTO = psivaTO;
    }
	public void setPsivaTE(double psivaTE) {
        this.psivaTE = psivaTE;
    }
	public void setPsivaRA(double psivaRA) {
        this.psivaRA = psivaRA;
    }
	public void setPsivaMO(double psivaMO) {
        this.psivaMO = psivaMO;
    }
	public void setPsivaAL(double psivaAL) {
        this.psivaAL = psivaAL;
    }
	public void setPsivaMU(double psivaMU) {
        this.psivaMU = psivaMU;
    }
	public void setPsivaGR(double psivaGR) {
        this.psivaGR = psivaGR;
    }
	public void setPsivaVE(double psivaVE) {
        this.psivaVE = psivaVE;
    }
	public void setPsivaFA(double psivaFA) {
        this.psivaFA = psivaFA;
    }
	public void setPcivaPB(double pcivaPB) {
        this.pcivaPB = pcivaPB;
    }
	public void setPcivaPR(double pcivaPR) {
        this.pcivaPR = pcivaPR;
    }
	public void setPcivaMR(double pcivaMR) {
        this.pcivaMR = pcivaMR;
    }
	public void setPcivaGPU(double pcivaGPU) {
        this.pcivaGPU = pcivaGPU;
    }
	public void setPcivaDD(double pcivaDD) {
        this.pcivaDD = pcivaDD;
    }
	public void setPcivaTO(double pcivaTO) {
        this.pcivaTO = pcivaTO;
    }
	public void setPcivaTE(double pcivaTE) {
        this.pcivaTE = pcivaTE;
    }
	public void setPcivaRA(double pcivaRA) {
        this.pcivaRA = pcivaRA;
    }
	public void setPcivaMO(double pcivaMO) {
        this.pcivaMO = pcivaMO;
    }
	public void setPcivaAL(double pcivaAL) {
        this.pcivaAL = pcivaAL;
    }
	public void setPcivaMU(double pcivaMU) {
        this.pcivaMU = pcivaMU;
    }
	public void setPcivaGR(double pcivaGR) {
        this.pcivaGR = pcivaGR;
    }
	public void setPcivaVE(double pcivaVE) {
        this.pcivaVE = pcivaVE;
    }
	public void setPcivaFA(double pcivaFA) {
        this.pcivaFA = pcivaFA;
    }
	public void setPtotalsiva(double ptotalsiva) {
        this.ptotalsiva = ptotalsiva;
    }
	public void setPtotalciva(double ptotalciva) {
        this.ptotalciva = ptotalciva;
    }
	public PC getPc() {
		return pc;
	}
	public void setPc(PC pc) {
		this.pc = pc;
	}
	public PC getTempPC() {
		return tempPC;
	}
	public void setTempPC(PC tempPC) {
		this.tempPC = tempPC;
	}
}
