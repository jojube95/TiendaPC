package Modelo;
    
import javax.xml.bind.annotation.XmlRootElement;
import es.upv.inf.Product;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;

@XmlRootElement
public class PC {
	private String nombre;
    private String precioString;
    private Double precio;
    private Product PB;
    private Product PR;
    private Product MR;
    private Product GPU;
    private Product DD;
    private Product TO;
    private Product TE;
    private Product RA;
    private Product MO;
    private Product AL;
    private Product MU;
    private Product GR;
    private Product VE;
    private Product FA;
    private int cantPB;
    private int cantPR;
    private int cantMR;
    private int cantGPU;
    private int cantDD;
    private int cantTO;
    private int cantTE;
    private int cantRA;
    private int cantMO;
    private int cantAL;
    private int cantMU;
    private int cantGR;
    private int cantVE;
    private int cantFA;
    
    public PC(){
	}
    
    public PC(String nombre,  Product PB, Product PR, Product MR, Product GPU, Product DD, Product TO,
            int cantPB, int cantPR, int cantMR, int cantGPU, int cantDD, int cantTO){
        this.nombre = nombre;
    	this.PB = PB;
        this.PR = PR;
        this.MR = MR;
        this.GPU = GPU;
        this.DD = DD;
        this.TO = TO;
        this.cantPB = cantPB;
        this.cantPR = cantPR;
        this.cantMR = cantMR;
        this.cantGPU = cantGPU;
        this.cantDD = cantDD;
        this.cantTO = cantTO;
        recalcularPrecio();
    }
    
    public PC(String nombre,  Product PB, Product PR, Product MR, Product GPU, Product DD, Product TO,
            Product TE, Product RA, Product MO, Product AL, Product MU, Product GR, Product VE, Product FA, 
            int cantPB, int cantPR, int cantMR, int cantGPU, int cantDD, int cantTO,
            int cantTE, int cantRA, int cantMO, int cantAL, int cantMU, int cantGR, int cantVE, int cantFA){
        this.nombre = nombre;
        this.PB = PB;
        this.PR = PR;
        this.MR = MR;
        this.GPU = GPU;
        this.DD = DD;
        this.TO = TO;
         this.TE = TE;
        this.RA = RA;
        this.MO = MO;
        this.AL = AL;
        this.MU = MU;
        this.GR = GR;
        this.VE = VE;
        this.FA = FA;
        this.cantPB = cantPB;
        this.cantPR = cantPR;
        this.cantMR = cantMR;
        this.cantGPU = cantGPU;
        this.cantDD = cantDD;
        this.cantTO = cantTO;
        this.cantTE = cantTE;
        this.cantRA = cantRA;
        this.cantAL = cantAL;
        this.cantMU = cantMU;
        this.cantGR = cantGR;
        this.cantVE = cantVE;
        this.cantFA = cantFA;
        this.cantMO = cantMO;
        recalcularPrecio();
    }
    
    public void recalcularPrecio(){
    	double precioPB = 0;
    	double precioPR = 0;
    	double precioMR = 0;
    	double precioGPU = 0;
    	double precioDD = 0;
    	double precioTO = 0;
    	double precioTE = 0;
    	double precioRA = 0;
    	double precioMO = 0;
    	double precioAL = 0;
    	double precioMU = 0;
    	double precioGR = 0;
    	double precioVE = 0;
    	double precioFA = 0;
    	
    	if(PB != null){
    		precioPB = PB.getPrice()*cantPB;   		
    	}
    	if(PR != null){
    		precioPR = PR.getPrice()*cantPR;   		
    	}
    	if(MR != null){
    		precioMR = MR.getPrice()*cantMR;   		
    	}
    	if(GPU != null){
    		precioGPU = GPU.getPrice()*cantGPU;   		
    	}
    	if(DD != null){
    		precioDD = DD.getPrice()*cantDD;   		
    	}
    	if(TO != null){
    		precioTO = TO.getPrice()*cantTO;   		
    	}
    	if(TE != null){
    		precioTE = TE.getPrice()*cantTE;   		
    	}
    	if(RA != null){
    		precioRA = RA.getPrice()*cantRA;   		
    	}
    	if(MO != null){
    		precioMO = MO.getPrice()*cantMO;   		
    	}
    	if(AL != null){
    		precioAL = AL.getPrice()*cantAL;   		
    	}
    	if(MU != null){
    		precioMU = MU.getPrice()*cantMU;   		
    	}
    	if(GR != null){
    		precioGR = GR.getPrice()*cantGR;   		
    	}
    	if(VE != null){
    		precioVE = VE.getPrice()*cantVE;   		
    	}
    	if(FA != null){
    		precioFA = FA.getPrice()*cantFA;   		
    	}
    	this.precio = precioPB + precioPR + precioMR + precioGPU + precioDD + precioTO + 
        		precioTE + precioRA + precioMO + precioAL + precioMU + precioGR + precioVE + 
        		precioFA;
        this.precioString = this.precio.toString();
    }
    

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
	public Double getPrecio() {
        return precio;
    }
   public ObservableValue<Double> getPrecioObservable(){
        ObservableValue<Double> obsDouble = new ReadOnlyObjectWrapper<>(getPrecio());
        return obsDouble;
    }
   public void setPrecio(Double precio) {
    	recalcularPrecio();
        this.precio = precio;
        this.precioString = precio.toString();
    }
	public Product getPB() {
        return PB;
    }
	public void setPB(Product PB) {
        this.PB = PB;
    }
    public void sumarPB(){
    	this.cantPB++;
    }
    public void restarPB(){
    	this.cantPB--;
    }
    public Product getPR() {
        return PR;
    }
	public void setPR(Product PR) {
        this.PR = PR;
    }
    public void sumarPR(){
    	this.cantPR++;
    }
    public void restarPR(){
    	this.cantPR--;
    }
    public Product getMR() {
        return MR;
    }
	public void setMR(Product MR) {
        this.MR = MR;
    }
    public void sumarMR(){
    	this.cantMR++;
    }
    public void restarMR(){
    	this.cantMR--;
    }
    public Product getGPU() {
        return GPU;
    }
	public void setGPU(Product GPU) {
        this.GPU = GPU;
    }
    public void sumarGPU(){
    	this.cantGPU++;
    }
    public void restarGPU(){
    	this.cantGPU--;
    }
    public Product getDD() {
        return DD;
    }
	public void setDD(Product DD) {
        this.DD = DD;
    }
    public void sumarDD(){
    	this.cantDD++;
    }
    public void restarDD(){
    	this.cantDD--;
    }
    public Product getTO() {
        return TO;
    }
    public void setTO(Product TO) {
        this.TO = TO;
    }
    public void sumarTO(){
    	this.cantTO++;
    }
    public void restarTO(){
    	this.cantTO--;
    }
    public Product getTE() {
        return TE;
    }
	public void setTE(Product TE) {
        this.TE = TE;
    }
    public void sumarTE(){
    	this.cantTE++;
    }
    public void restarTE(){
    	this.cantTE--;
    }
    public Product getRA() {
        return RA;
    }
	public void setRA(Product RA) {
        this.RA = RA;
    }
    public void sumarRA(){
    	this.cantRA++;
    }
    public void restarRA(){
    	this.cantRA--;
    }
    public Product getMO() {
        return MO;
    }
	public void setMO(Product MO) {
        this.MO = MO;
    }
    public void sumarMO(){
    	this.cantMO++;
    }
    public void restarMO(){
    	this.cantMO--;
    }
    public Product getAL() {
        return AL;
    }
	public void setAL(Product AL) {
        this.AL = AL;
    }
    public void sumarAL(){
    	this.cantAL++;
    }
    public void restarAL(){
    	this.cantAL--;
    }
    public Product getMU() {
        return MU;
    }
	public void setMU(Product MU) {
        this.MU = MU;
    }
    public void sumarMU(){
    	this.cantMU++;
    }
    public void restarMU(){
    	this.cantMU--;
    }
    public Product getGR() {
        return GR;
    }
	public void setGR(Product GR) {
        this.GR = GR;
    }
    public void sumarGR(){
    	this.cantGR++;
    }
    public void restarGR(){
    	this.cantGR--;
    }
    public Product getVE() {
        return VE;
    }
	public void setVE(Product VE) {
        this.VE = VE;
    }
    public void sumarVE(){
    	this.cantVE++;
    }
    public void restarVE(){
    	this.cantVE--;
    }
    public Product getFA() {
        return FA;
    }
	public void setFA(Product FA) {
        this.FA = FA;
    }
    public void sumarFA(){
    	this.cantFA++;
    }
    public void restarFA(){
    	this.cantFA--;
    }
    public int getCantPB() {
        return cantPB;
    }
	public void setCantPB(int cantPB) {
        this.cantPB = cantPB;
    }
	public int getCantPR() {
        return cantPR;
    }
	public void setCantPR(int cantPR) {
        this.cantPR = cantPR;
    }
	public int getCantMR() {
        return cantMR;
    }
	public void setCantMR(int cantMR) {
        this.cantMR = cantMR;
    }
	public int getCantGPU() {
        return cantGPU;
    }
	public void setCantGPU(int cantGPU) {
        this.cantGPU = cantGPU;
    }
	public int getCantDD() {
        return cantDD;
    }
	public void setCantDD(int cantDD) {
        this.cantDD = cantDD;
    }
	public int getCantTO() {
        return cantTO;
    }
	public void setCantTO(int cantTO) {
        this.cantTO = cantTO;
    }
   	public int getCantTE() {
        return cantTE;
    }
	public void setCantTE(int cantTE) {
        this.cantTE = cantTE;
    }
	public int getCantRA() {
        return cantRA;
    }
	public void setCantRA(int cantRA) {
        this.cantRA = cantRA;
    }
	public int getCantMO() {
        return cantMO;
    }
	public void setCantMO(int cantMO) {
        this.cantMO = cantMO;
    }
	public int getCantAL() {
        return cantAL;
    }
	public void setCantAL(int cantAL) {
        this.cantAL = cantAL;
    }
	public int getCantMU() {
        return cantMU;
    }
	public void setCantMU(int cantMU) {
        this.cantMU = cantMU;
    }
	public int getCantGR() {
        return cantGR;
    }
	public void setCantGR(int cantGR) {
        this.cantGR = cantGR;
    }
	public int getCantVE() {
        return cantVE;
    }
	public void setCantVE(int cantVE) {
        this.cantVE = cantVE;
    }
    public int getCantFA() {
        return cantFA;
    }
	public void setCantFA(int cantFA) {
        this.cantFA = cantFA;
    }
 	public String getPrecioString() {
        return precioString;
    }
 	public void setPrecioString(String precioString) {
        this.precioString = precioString;
    }
}
