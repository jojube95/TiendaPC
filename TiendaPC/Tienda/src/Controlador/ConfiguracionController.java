package Controlador;
import Modelo.PC;
import Modelo.Tienda;
import es.upv.inf.Database;
import es.upv.inf.Product;
import es.upv.inf.Product.Category;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    
    public void setPC(PC pc){
        this.pc = pc;
        //Inicia las descripciones
        if(pc.getPB() != null){
        	this.setCantiPB(pc.getCantPB());
        	this.setDesPB(pc.getPB().getDescription());
        	this.setPsivaPB(Redondear(pc.getCantPB()*(pc.getPB().getPrice())));
        	this.setPcivaPB(Redondear(psivaPB * 1.21));
        }
		if(pc.getPR() != null){
			this.setDesPR(pc.getPR().getDescription());
			this.setCantiPR(pc.getCantPR());
	        this.setPsivaPR(Redondear(pc.getCantPR()*(pc.getPR().getPrice())));
	        this.setPcivaPR(Redondear(psivaPR * 1.21));
        }
		if(pc.getMR() != null){
			
			this.setDesMR(pc.getMR().getDescription());
			this.setCantiMR(pc.getCantMR());
			this.setPsivaMR(Redondear(pc.getCantMR()*(pc.getMR().getPrice())));
			this.setPcivaMR(Redondear(psivaMR * 1.21));
        }
		if(pc.getGPU() != null){
			this.setDesGPU(pc.getGPU().getDescription());
			this.setCantiGPU(pc.getCantGPU());
			this.setPsivaGPU(Redondear(pc.getCantGPU()*(pc.getGPU().getPrice())));
			this.setPcivaGPU(Redondear(psivaGPU * 1.21));
		}
		if(pc.getDD() != null){
			this.setDesDD(pc.getDD().getDescription());
			this.setCantiDD(pc.getCantDD());
			this.setPsivaDD(Redondear(pc.getCantDD()*(pc.getDD().getPrice())));
			this.setPcivaDD(Redondear(psivaDD * 1.21));
		}
		if(pc.getTO() != null){
			this.setDesTO(pc.getTO().getDescription());
			this.setCantiTO(pc.getCantTO());
			this.setPsivaTO(Redondear(pc.getCantTO()*(pc.getTO().getPrice())));
			this.setPcivaTO(Redondear(psivaTO * 1.21));
        }
		if(pc.getTE() != null){
			this.setDesTE(pc.getTE().getDescription());
			this.setCantiTE(pc.getCantTE());
			this.setPsivaTE(Redondear(pc.getCantTE()*(pc.getTE().getPrice())));
			this.setPcivaTE(Redondear(psivaTE * 1.21));
        }
		if(pc.getRA() != null){
			this.setDesRA(pc.getRA().getDescription());
			this.setCantiRA(pc.getCantRA());
			this.setPsivaRA(Redondear(pc.getCantRA()*(pc.getRA().getPrice())));
			this.setPcivaRA(Redondear(psivaRA * 1.21));
		}
		if(pc.getMO() != null){
			this.setDesMO(pc.getMO().getDescription()); 
			this.setCantiMO(pc.getCantMO());
			this.setPsivaMO(Redondear(pc.getCantMO()*(pc.getMO().getPrice())));
			this.setPcivaMO(Redondear(psivaMO * 1.21));
    	}
		if(pc.getAL() != null){
			this.setDesAL(pc.getAL().getDescription());
			this.setCantiAL(pc.getCantAL());
			this.setPsivaAL(Redondear(pc.getCantAL()*(pc.getAL().getPrice())));
			this.setPcivaAL(Redondear(psivaAL * 1.21));
		}
		if(pc.getMU() != null){
			this.setDesMU(pc.getMU().getDescription());
			 this.setCantiMU(pc.getCantMU());
			 this.setPsivaMU(Redondear(pc.getCantMU()*(pc.getMU().getPrice())));
			 this.setPcivaMU(Redondear(psivaMU * 1.21));
		}
		if(pc.getGR() != null){
			this.setDesGR(pc.getGR().getDescription()); 
			this.setCantiGR(pc.getCantGR());
			this.setPsivaGR(Redondear(pc.getCantGR()*(pc.getGR().getPrice())));
			this.setPcivaGR(Redondear(psivaGR * 1.21));
        }
		if(pc.getVE() != null){
			this.setDesVE(pc.getVE().getDescription());
			this.setCantiVE(pc.getCantVE());
			this.setPsivaVE(Redondear(pc.getCantVE()*(pc.getVE().getPrice())));
			this.setPcivaVE(Redondear(psivaVE * 1.21));
	        
		}
		if(pc.getFA() != null){
			this.setDesFA(pc.getFA().getDescription());
			this.setCantiFA(pc.getCantFA());
			this.setPsivaFA(Redondear(pc.getCantFA()*(pc.getFA().getPrice())));
			this.setPcivaFA(Redondear(psivaFA * 1.21));
		}
		
		//Inicializar el total sin iva y con iva
        this.setPtotalsiva(psivaPB +psivaPR +psivaMR +psivaGPU +psivaDD +psivaTO +
                psivaTE +psivaRA +psivaMO +psivaAL +psivaMU +psivaGR +psivaVE +psivaFA);
        
        this.setPtotalciva(pcivaPB +pcivaPR +pcivaMR +pcivaGPU +pcivaDD +pcivaTO +
                pcivaTE +pcivaRA +pcivaMO +pcivaAL +pcivaMU +pcivaGR +pcivaVE +pcivaFA);
        inicializarConfiguracion();
    }
    
    public void inicializarConfiguracion(){
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
        //Comprovar si esta bien
        this.pc.setPB(Database.getProductByCategoryAndDescription(Category.MOTHERBOARD, lPB.getText(), true).get(0));
        this.pc.setPR(Database.getProductByCategoryAndDescription(Category.CPU, lPR.getText(), true).get(0));
        this.pc.setMR(Database.getProductByCategoryAndDescription(Category.RAM, lMR.getText(), true).get(0));
        this.pc.setGPU(Database.getProductByCategoryAndDescription(Category.GPU, lGPU.getText(), true).get(0));
        this.pc.setDD(Database.getProductByCategoryAndDescription(Category.HDD, lDD.getText(), true).get(0));
        this.pc.setTO(Database.getProductByCategoryAndDescription(Category.CASE, lTO.getText(), true).get(0));
        
        this.pc.setTE(Database.getProductByCategoryAndDescription(Category.KEYBOARD, lTE.getText(), true).get(0));
        this.pc.setRA(Database.getProductByCategoryAndDescription(Category.MOUSE, lRA.getText(), true).get(0));
        this.pc.setMO(Database.getProductByCategoryAndDescription(Category.SCREEN, lMO.getText(), true).get(0));
        this.pc.setAL(Database.getProductByCategoryAndDescription(Category.SPEAKER, lAL.getText(), true).get(0));
        this.pc.setMU(Database.getProductByCategoryAndDescription(Category.MULTIREADER, lMU.getText(), true).get(0));
        this.pc.setGR(Database.getProductByCategoryAndDescription(Category.DVD_WRITER, lGR.getText(), true).get(0));
        this.pc.setVE(Database.getProductByCategoryAndDescription(Category.FAN, lVE.getText(), true).get(0));
        this.pc.setFA(Database.getProductByCategoryAndDescription(Category.POWER_SUPPLY, lFA.getText(), true).get(0));
        
        this.pc.setCantPB(Integer.parseInt(cantPB.getText()));
        this.pc.setCantPR(Integer.parseInt(cantPR.getText()));
        this.pc.setCantMR(Integer.parseInt(cantMR.getText()));
        this.pc.setCantGPU(Integer.parseInt(cantGPU.getText()));
        this.pc.setCantDD(Integer.parseInt(cantDD.getText()));
        this.pc.setCantTO(Integer.parseInt(cantTO.getText()));
        this.pc.setCantTE(Integer.parseInt(cantTE.getText()));
        this.pc.setCantRA(Integer.parseInt(cantRA.getText()));
        this.pc.setCantMO(Integer.parseInt(cantMO.getText()));
        this.pc.setCantAL(Integer.parseInt(cantAL.getText()));
        this.pc.setCantMU(Integer.parseInt(cantMU.getText()));
        this.pc.setCantGR(Integer.parseInt(cantGR.getText()));
        this.pc.setCantVE(Integer.parseInt(cantVE.getText()));
        this.pc.setCantFA(Integer.parseInt(cantFA.getText()));
        
        this.pc.recalcularPrecio();
        
        okClicked = true;
        tienda.getPrincipalController().setPcConfigurado(this.pc);
        tienda.getPrincipalController().setTienda(tienda);
        primaryStage.close();
    }
    
    @FXML
    private void sumaPB(ActionEvent event){
        this.cantiPB++;
        this.psivaPB = Redondear(this.pc.getPB().getPrice()*this.cantiPB);
        this.pcivaPB = Redondear(this.psivaPB * 1.21);
        this.ptotalsiva = this.ptotalsiva + Redondear(this.pc.getPB().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void sumaPR(ActionEvent event){
        this.cantiPR++;
        this.psivaPR = Redondear(this.pc.getPR().getPrice()*this.cantiPR);
        this.pcivaPR = Redondear(this.psivaPR * 1.21);
        this.ptotalsiva = this.ptotalsiva + Redondear(this.pc.getPR().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void sumaMR(ActionEvent event){
        this.cantiMR++;
        this.psivaMR = Redondear(this.pc.getMR().getPrice()*this.cantiMR);
        this.pcivaMR = Redondear(this.psivaMR * 1.21);
        this.ptotalsiva = this.ptotalsiva + Redondear(this.pc.getMR().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    
    @FXML
    private void sumaGPU(ActionEvent event){
        this.cantiGPU++;
        this.psivaGPU = Redondear(this.pc.getGPU().getPrice()*this.cantiGPU);
        this.pcivaGPU = Redondear(this.psivaGPU * 1.21);
        this.ptotalsiva = this.ptotalsiva + Redondear(this.pc.getGPU().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void sumaDD(ActionEvent event){
        this.cantiDD++;
        this.psivaDD = Redondear(this.pc.getDD().getPrice()*this.cantiDD);
        this.pcivaDD = Redondear(this.psivaDD * 1.21);
        this.ptotalsiva = this.ptotalsiva + Redondear(this.pc.getDD().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void sumaTO(ActionEvent event){
        this.cantiTO++;
        this.psivaTO = Redondear(this.pc.getTO().getPrice()*this.cantiTO);
        this.pcivaTO = Redondear(this.psivaTO * 1.21);
        this.ptotalsiva = this.ptotalsiva + Redondear(this.pc.getTO().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void sumaTE(ActionEvent event){
        this.cantiTE++;
        this.psivaTE = Redondear(this.pc.getTE().getPrice()*this.cantiTE);
        this.pcivaTE = Redondear(this.psivaTE * 1.21);
        this.ptotalsiva = this.ptotalsiva + Redondear(this.pc.getTE().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void sumaRA(ActionEvent event){
        this.cantiRA++;
        this.psivaRA = Redondear(this.pc.getRA().getPrice()*this.cantiRA);
        this.pcivaRA = Redondear(this.psivaRA * 1.21);
        this.ptotalsiva = this.ptotalsiva + Redondear(this.pc.getRA().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void sumaMO(ActionEvent event){
        this.cantiMO++;
        this.psivaMO = Redondear(this.pc.getMO().getPrice()*this.cantiMO);
        this.pcivaMO = Redondear(this.psivaMO * 1.21);
        this.ptotalsiva = this.ptotalsiva + Redondear(this.pc.getMO().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void sumaAL(ActionEvent event){
        this.cantiAL++;
        this.psivaAL = Redondear(this.pc.getAL().getPrice()*this.cantiAL);
        this.pcivaAL = Redondear(this.psivaAL * 1.21);
        this.ptotalsiva = this.ptotalsiva + Redondear(this.pc.getAL().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void sumaMU(ActionEvent event){
        this.cantiMU++;
        this.psivaMU = Redondear(this.pc.getMU().getPrice()*this.cantiMU);
        this.pcivaMU = Redondear(this.psivaMU * 1.21);
        this.ptotalsiva = this.ptotalsiva + Redondear(this.pc.getMU().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void sumaGR(ActionEvent event){
        this.cantiGR++;
        this.psivaGR = Redondear(this.pc.getGR().getPrice()*this.cantiGR);
        this.pcivaGR = Redondear(this.psivaGR * 1.21);
        this.ptotalsiva = this.ptotalsiva + Redondear(this.pc.getGR().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void sumaVE(ActionEvent event){
        this.cantiVE++;
        this.psivaVE = Redondear(this.pc.getVE().getPrice()*this.cantiVE);
        this.pcivaVE = Redondear(this.psivaVE * 1.21);
        this.ptotalsiva = this.ptotalsiva + Redondear(this.pc.getVE().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void sumaFA(ActionEvent event){
        this.cantiFA++;
        this.psivaFA = Redondear(this.pc.getFA().getPrice()*this.cantiFA);
        this.pcivaFA = Redondear(this.psivaFA * 1.21);
        this.ptotalsiva = this.ptotalsiva + Redondear(this.pc.getFA().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void restaPB(ActionEvent event){
        this.cantiPB--;
        this.psivaPB = Redondear(this.pc.getPB().getPrice()*this.cantiPB);
        this.pcivaPB = Redondear(this.psivaPB * 1.21);
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getPB().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void restaPR(ActionEvent event){
        this.cantiPR--;
        this.psivaPR = Redondear(this.pc.getPR().getPrice()*this.cantiPR);
        this.pcivaPR = Redondear(this.psivaPR * 1.21);
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getPR().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void restaMR(ActionEvent event){
        this.cantiMR--;
        this.psivaMR = Redondear(this.pc.getMR().getPrice()*this.cantiMR);
        this.pcivaMR = Redondear(this.psivaMR * 1.21);
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getMR().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void restaGPU(ActionEvent event){
        this.cantiGPU--;
        this.psivaGPU = Redondear(this.pc.getGPU().getPrice()*this.cantiGPU);
        this.pcivaGPU = Redondear(this.psivaGPU * 1.21);
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getGPU().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void restaDD(ActionEvent event){
        this.cantiDD--;
        this.psivaDD = Redondear(this.pc.getDD().getPrice()*this.cantiDD);
        this.pcivaDD = Redondear(this.psivaDD * 1.21);
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getDD().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void restaTO(ActionEvent event){
        this.cantiTO--;
        this.psivaTO = Redondear(this.pc.getTO().getPrice()*this.cantiTO);
        this.pcivaTO = Redondear(this.psivaTO * 1.21);
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getTO().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void restaTE(ActionEvent event){
        this.cantiTE--;
        this.psivaTE = Redondear(this.pc.getTE().getPrice()*this.cantiTE);
        this.pcivaTE = Redondear(this.psivaTE * 1.21);
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getTE().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void restaRA(ActionEvent event){
        this.cantiRA--;
        this.psivaRA = Redondear(this.pc.getRA().getPrice()*this.cantiRA);
        this.pcivaRA = Redondear(this.psivaRA * 1.21);
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getRA().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void restaMO(ActionEvent event){
        this.cantiMO--;
        this.psivaMO = Redondear(this.pc.getMO().getPrice()*this.cantiMO);
        this.pcivaMO = Redondear(this.psivaMO * 1.21);
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getMO().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void restaAL(ActionEvent event){
        this.cantiAL--;
        this.psivaAL = Redondear(this.pc.getAL().getPrice()*this.cantiAL);
        this.pcivaAL = Redondear(this.psivaAL * 1.21);
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getAL().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void restaMU(ActionEvent event){
        this.cantiMU--;
        this.psivaMU = Redondear(this.pc.getMU().getPrice()*this.cantiMU);
        this.pcivaMU = Redondear(this.psivaMU * 1.21);
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getMU().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void restaGR(ActionEvent event){
        this.cantiGR--;
        this.psivaGR = Redondear(this.pc.getGR().getPrice()*this.cantiGR);
        this.pcivaGR = Redondear(this.psivaGR * 1.21);
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getGR().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void restaVE(ActionEvent event){
        this.cantiVE--;
        this.psivaVE = Redondear(this.pc.getVE().getPrice()*this.cantiVE);
        this.pcivaVE = Redondear(this.psivaVE * 1.21);
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getVE().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    @FXML
    private void restaFA(ActionEvent event){
        this.cantiFA--;
        this.psivaFA = Redondear(this.pc.getFA().getPrice()*this.cantiFA);
        this.pcivaFA = Redondear(this.psivaFA * 1.21);
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getFA().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        inicializarConfiguracion();
    }
    
    @FXML
    private void borrarPB(ActionEvent event){
        this.cantiPB = 0;
        this.desPB = "OBLIGATORIO";
        this.psivaPB = 0;
        this.pcivaPB = 0;
        if(this.pc.getPB() != null){
        	this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getPB().getPrice());
        	this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        }
        this.pc.setPB(null);
        inicializarConfiguracion();
    }
    @FXML
    private void borrarPR(ActionEvent event){
        this.cantiPR = 0;
        this.desPR = "OBLIGATORIO";
        this.psivaPR = 0;
        this.pcivaPR = 0;
        if(this.pc.getPR() != null){
	        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getPR().getPrice());
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        }
        this.pc.setPB(null);
        inicializarConfiguracion();
    }
    @FXML
    private void borrarMR(ActionEvent event){
        this.cantiMR = 0;
        this.desMR = "OBLIGATORIO";
        this.psivaMR = 0;
        this.pcivaMR = 0;
        if(this.pc.getMR() != null){
	        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getMR().getPrice());
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        }
        this.pc.setMR(null);
        inicializarConfiguracion();
    }
    @FXML
    private void borrarGPU(ActionEvent event){
        this.cantiGPU = 0;
        this.desGPU = "OBLIGATORIO";
        this.psivaGPU = 0;
        this.pcivaGPU = 0;
        if(this.pc.getGPU() != null){
	        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getGPU().getPrice());
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        }
        this.pc.setGPU(null);
        inicializarConfiguracion();
    }
    @FXML
    private void borrarDD(ActionEvent event){
        this.cantiDD = 0;
        this.desDD = "OBLIGATORIO";
        this.psivaDD = 0;
        this.pcivaDD = 0;
        if(this.pc.getDD() != null){
	        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getDD().getPrice());
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        }
        this.pc.setDD(null);
        inicializarConfiguracion();
    }
    @FXML
    private void borrarTO(ActionEvent event){
        this.cantiTO = 0;
        this.desTO = "OBLIGATORIO";
        this.psivaTO = 0;
        this.pcivaTO = 0;
        if(this.pc.getTO() != null){
	        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getTO().getPrice());
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        }
        this.pc.setTO(null);
        inicializarConfiguracion();
    }
    @FXML
    private void borrarTE(ActionEvent event){
        this.cantiTE = 0;
        this.desTE = "OPCIONAL";
        this.psivaTE = 0;
        this.pcivaTE = 0;
        if(this.pc.getTE() != null){
	        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getTE().getPrice());
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        }
        this.pc.setTE(null);
        inicializarConfiguracion();
    }
    @FXML
    private void borrarRA(ActionEvent event){
        this.cantiRA = 0;
        this.desRA = "OPCIONAL";
        this.psivaRA = 0;
        this.pcivaRA = 0;
        if(this.pc.getRA() != null){
	        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getRA().getPrice());
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        }
        this.pc.setRA(null);
        inicializarConfiguracion();
    }
    @FXML
    private void borrarMO(ActionEvent event){
        this.cantiMO = 0;
        this.desMO = "OPCIONAL";
        this.psivaMO = 0;
        this.pcivaMO = 0;
        if(this.pc.getMO() != null){
	        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getMO().getPrice());
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        }
        this.pc.setMO(null);
        inicializarConfiguracion();
    }
    @FXML
    private void borrarAL(ActionEvent event){
        this.cantiAL = 0;
        this.desAL = "OPCIONAL";
        this.psivaAL = 0;
        this.pcivaAL = 0;
        if(this.pc.getAL() != null){
	        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getAL().getPrice());
	        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        }
        this.pc.setAL(null);
        inicializarConfiguracion();
    }
    @FXML
    private void borrarMU(ActionEvent event){
        this.cantiMU = 0;
        this.desMU = "OPCIONAL";
        this.psivaMU = 0;
        this.pcivaMU = 0;
        if(this.pc.getMU() != null){
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getMU().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        }
        this.pc.setMU(null);
        inicializarConfiguracion();
    }
    @FXML
    private void borrarGR(ActionEvent event){
        this.cantiGR = 0;
        this.desGR = "OPCIONAL";
        this.psivaGR = 0;
        this.pcivaGR = 0;
        if(this.pc.getGR() != null){
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getGR().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        }
        this.pc.setGR(null);
        inicializarConfiguracion();
    }
    @FXML
    private void borrarVE(ActionEvent event){
        this.cantiVE = 0;
        this.desVE = "OPCIONAL";
        this.psivaVE = 0;
        this.pcivaVE = 0;
        if(this.pc.getVE() != null){
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getVE().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        }
        this.pc.setVE(null);
        inicializarConfiguracion();
    }
    @FXML
    private void borrarFA(ActionEvent event){
        this.cantiFA = 0;
        this.desFA = "OPCIONAL";
        this.psivaFA = 0;
        this.pcivaFA = 0;
        if(this.pc.getFA() != null){
        this.ptotalsiva = this.ptotalsiva - Redondear(this.pc.getFA().getPrice());
        this.ptotalciva = Redondear(this.ptotalsiva * 1.21);
        }
        this.pc.setFA(null);
        inicializarConfiguracion();
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
        boolean okClicked = tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaSPEAKER(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.SPEAKER);
        boolean okClicked = tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaHDD(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.HDD);
        boolean okClicked = tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaPOWER_SUPPLY(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.POWER_SUPPLY);
        boolean okClicked = tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaDVD_WRITER(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.DVD_WRITER);
        boolean okClicked = tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaRAM(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.RAM);
        boolean okClicked = tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaSCREEN(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.SCREEN);
        boolean okClicked = tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaMULTIREADER(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.MULTIREADER);
        boolean okClicked = tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaMOTHERBOARD(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.MOTHERBOARD);
        boolean okClicked = tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaMOUSE(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.MOUSE);
        boolean okClicked = tienda.mostrarBusqueda(productoSel);
    }
    @FXML
    private void irABusquedaGPU(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.GPU);
        boolean okClicked = tienda.mostrarBusqueda(productoSel);
    }
    @FXML
    private void irABusquedaKEYBOARD(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.KEYBOARD);
        boolean okClicked = tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaCASE(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.CASE);
        boolean okClicked = tienda.mostrarBusqueda(productoSel);
    }
    
    @FXML
    private void irABusquedaFAN(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.FAN);
        boolean okClicked = tienda.mostrarBusqueda(productoSel);
    }
    
    private void irABusquedaHDD_SSD(ActionEvent event) {
        Product productoSel = new Product("", 0.0, 0, Category.HDD_SSD);
        boolean okClicked = tienda.mostrarBusqueda(productoSel);
    }
    
    void salirAccion(ActionEvent event) {
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }

    /**
     * @param cantiPB the cantiPB to set
     */
    public void setCantiPB(int cantiPB) {
        this.cantiPB = cantiPB;
    }

    /**
     * @param cantiPR the cantiPR to set
     */
    public void setCantiPR(int cantiPR) {
        this.cantiPR = cantiPR;
    }

    /**
     * @param cantiMR the cantiMR to set
     */
    public void setCantiMR(int cantiMR) {
        this.cantiMR = cantiMR;
    }

    /**
     * @param cantiGPU the cantiGPU to set
     */
    public void setCantiGPU(int cantiGPU) {
        this.cantiGPU = cantiGPU;
    }

    /**
     * @param cantiDD the cantiDD to set
     */
    public void setCantiDD(int cantiDD) {
        this.cantiDD = cantiDD;
    }

    /**
     * @param cantiTO the cantiTO to set
     */
    public void setCantiTO(int cantiTO) {
        this.cantiTO = cantiTO;
    }

    /**
     * @param cantiTE the cantiTE to set
     */
    public void setCantiTE(int cantiTE) {
        this.cantiTE = cantiTE;
    }

    /**
     * @param cantiRA the cantiRA to set
     */
    public void setCantiRA(int cantiRA) {
        this.cantiRA = cantiRA;
    }

    /**
     * @param cantiMO the cantiMO to set
     */
    public void setCantiMO(int cantiMO) {
        this.cantiMO = cantiMO;
    }

    /**
     * @param cantiAL the cantiAL to set
     */
    public void setCantiAL(int cantiAL) {
        this.cantiAL = cantiAL;
    }

    /**
     * @param cantiMU the cantiMU to set
     */
    public void setCantiMU(int cantiMU) {
        this.cantiMU = cantiMU;
    }

    /**
     * @param cantiGR the cantiGR to set
     */
    public void setCantiGR(int cantiGR) {
        this.cantiGR = cantiGR;
    }

    /**
     * @param cantiVE the cantiVE to set
     */
    public void setCantiVE(int cantiVE) {
        this.cantiVE = cantiVE;
    }

    /**
     * @param cantiFA the cantiFA to set
     */
    public void setCantiFA(int cantiFA) {
        this.cantiFA = cantiFA;
    }

    /**
     * @param desPB the desPB to set
     */
    public void setDesPB(String desPB) {
        this.desPB = desPB;
    }

    /**
     * @param desPR the desPR to set
     */
    public void setDesPR(String desPR) {
        this.desPR = desPR;
    }

    /**
     * @param desMR the desMR to set
     */
    public void setDesMR(String desMR) {
        this.desMR = desMR;
    }

    /**
     * @param desGPU the desGPU to set
     */
    public void setDesGPU(String desGPU) {
        this.desGPU = desGPU;
    }

    /**
     * @param desDD the desDD to set
     */
    public void setDesDD(String desDD) {
        this.desDD = desDD;
    }

    /**
     * @param desTO the desTO to set
     */
    public void setDesTO(String desTO) {
        this.desTO = desTO;
    }

    /**
     * @param desTE the desTE to set
     */
    public void setDesTE(String desTE) {
        this.desTE = desTE;
    }

    /**
     * @param desRA the desRA to set
     */
    public void setDesRA(String desRA) {
        this.desRA = desRA;
    }

    /**
     * @param desMO the desMO to set
     */
    public void setDesMO(String desMO) {
        this.desMO = desMO;
    }

    /**
     * @param desAL the desAL to set
     */
    public void setDesAL(String desAL) {
        this.desAL = desAL;
    }

    /**
     * @param desMU the desMU to set
     */
    public void setDesMU(String desMU) {
        this.desMU = desMU;
    }

    /**
     * @param desGR the desGR to set
     */
    public void setDesGR(String desGR) {
        this.desGR = desGR;
    }

    /**
     * @param desVE the desVE to set
     */
    public void setDesVE(String desVE) {
        this.desVE = desVE;
    }

    /**
     * @param desFA the desFA to set
     */
    public void setDesFA(String desFA) {
        this.desFA = desFA;
    }

    /**
     * @param psivaPB the psivaPB to set
     */
    public void setPsivaPB(double psivaPB) {
        this.psivaPB = psivaPB;
    }

    /**
     * @param psivaPR the psivaPR to set
     */
    public void setPsivaPR(double psivaPR) {
        this.psivaPR = psivaPR;
    }

    /**
     * @param psivaMR the psivaMR to set
     */
    public void setPsivaMR(double psivaMR) {
        this.psivaMR = psivaMR;
    }

    /**
     * @param psivaGPU the psivaGPU to set
     */
    public void setPsivaGPU(double psivaGPU) {
        this.psivaGPU = psivaGPU;
    }

    /**
     * @param psivaDD the psivaDD to set
     */
    public void setPsivaDD(double psivaDD) {
        this.psivaDD = psivaDD;
    }

    /**
     * @param psivaTO the psivaTO to set
     */
    public void setPsivaTO(double psivaTO) {
        this.psivaTO = psivaTO;
    }

    /**
     * @param psivaTE the psivaTE to set
     */
    public void setPsivaTE(double psivaTE) {
        this.psivaTE = psivaTE;
    }

    /**
     * @param psivaRA the psivaRA to set
     */
    public void setPsivaRA(double psivaRA) {
        this.psivaRA = psivaRA;
    }

    /**
     * @param psivaMO the psivaMO to set
     */
    public void setPsivaMO(double psivaMO) {
        this.psivaMO = psivaMO;
    }

    /**
     * @param psivaAL the psivaAL to set
     */
    public void setPsivaAL(double psivaAL) {
        this.psivaAL = psivaAL;
    }

    /**
     * @param psivaMU the psivaMU to set
     */
    public void setPsivaMU(double psivaMU) {
        this.psivaMU = psivaMU;
    }

    /**
     * @param psivaGR the psivaGR to set
     */
    public void setPsivaGR(double psivaGR) {
        this.psivaGR = psivaGR;
    }

    /**
     * @param psivaVE the psivaVE to set
     */
    public void setPsivaVE(double psivaVE) {
        this.psivaVE = psivaVE;
    }

    /**
     * @param psivaFA the psivaFA to set
     */
    public void setPsivaFA(double psivaFA) {
        this.psivaFA = psivaFA;
    }

    /**
     * @param pcivaPB the pcivaPB to set
     */
    public void setPcivaPB(double pcivaPB) {
        this.pcivaPB = pcivaPB;
    }

    /**
     * @param pcivaPR the pcivaPR to set
     */
    public void setPcivaPR(double pcivaPR) {
        this.pcivaPR = pcivaPR;
    }

    /**
     * @param pcivaMR the pcivaMR to set
     */
    public void setPcivaMR(double pcivaMR) {
        this.pcivaMR = pcivaMR;
    }

    /**
     * @param pcivaGPU the pcivaGPU to set
     */
    public void setPcivaGPU(double pcivaGPU) {
        this.pcivaGPU = pcivaGPU;
    }

    /**
     * @param pcivaDD the pcivaDD to set
     */
    public void setPcivaDD(double pcivaDD) {
        this.pcivaDD = pcivaDD;
    }

    /**
     * @param pcivaTO the pcivaTO to set
     */
    public void setPcivaTO(double pcivaTO) {
        this.pcivaTO = pcivaTO;
    }

    /**
     * @param pcivaTE the pcivaTE to set
     */
    public void setPcivaTE(double pcivaTE) {
        this.pcivaTE = pcivaTE;
    }

    /**
     * @param pcivaRA the pcivaRA to set
     */
    public void setPcivaRA(double pcivaRA) {
        this.pcivaRA = pcivaRA;
    }

    /**
     * @param pcivaMO the pcivaMO to set
     */
    public void setPcivaMO(double pcivaMO) {
        this.pcivaMO = pcivaMO;
    }

    /**
     * @param pcivaAL the pcivaAL to set
     */
    public void setPcivaAL(double pcivaAL) {
        this.pcivaAL = pcivaAL;
    }

    /**
     * @param pcivaMU the pcivaMU to set
     */
    public void setPcivaMU(double pcivaMU) {
        this.pcivaMU = pcivaMU;
    }

    /**
     * @param pcivaGR the pcivaGR to set
     */
    public void setPcivaGR(double pcivaGR) {
        this.pcivaGR = pcivaGR;
    }

    /**
     * @param pcivaVE the pcivaVE to set
     */
    public void setPcivaVE(double pcivaVE) {
        this.pcivaVE = pcivaVE;
    }

    /**
     * @param pcivaFA the pcivaFA to set
     */
    public void setPcivaFA(double pcivaFA) {
        this.pcivaFA = pcivaFA;
    }

    /**
     * @param ptotalsiva the ptotalsiva to set
     */
    public void setPtotalsiva(double ptotalsiva) {
        this.ptotalsiva = ptotalsiva;
    }

    /**
     * @param ptotalciva the ptotalciva to set
     */
    public void setPtotalciva(double ptotalciva) {
        this.ptotalciva = ptotalciva;
    }

	public PC getPc() {
		return pc;
	}

	public void setPc(PC pc) {
		this.pc = pc;
	}
            
}
