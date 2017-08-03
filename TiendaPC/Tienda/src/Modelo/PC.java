package Modelo;
    
import es.upv.inf.Database;
import es.upv.inf.Product;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author Joan
 */
public class PC {
    private StringProperty nombre;
    
    private StringProperty precioString;
    //private ArrayList componentes;
    private DoubleProperty precio;
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
        this.nombre = new SimpleStringProperty("Nuevo");
        
        /*this.PB = new Product("OBLIGATORIO", 0.0, 0, Category.MOTHERBOARD);
        this.PR = new Product("OBLIGATORIO", 0.0, 0, Category.CPU);
        this.MR = new Product("OBLIGATORIO", 0.0, 0, Category.RAM);
        this.GPU = new Product("OBLIGATORIO", 0.0, 0, Category.GPU);
        this.DD = new Product("OBLIGATORIO", 0.0, 0, Category.HDD);
        this.TO = new Product("OBLIGATORIO", 0.0, 0, Category.CASE);
        
        this.TE = new Product("OPCIONAL", 0.0, 0, Category.KEYBOARD);
        this.RA = new Product("OPCIONAL", 0.0, 0, Category.MOUSE);
        this.MO = new Product("OPCIONAL", 0.0, 0, Category.SCREEN);
        this.AL = new Product("OPCIONAL", 0.0, 0, Category.SPEAKER);
        this.MU = new Product("OPCIONAL", 0.0, 0, Category.POWER_SUPPLY);
        this.GR = new Product("OPCIONAL", 0.0, 0, Category.DVD_WRITER);
        this.VE = new Product("OPCIONAL", 0.0, 0, Category.FAN);
        this.FA = new Product("OPCIONAL", 0.0, 0, Category.POWER_SUPPLY);*/
        this.AL = Database.getProductByCategory(Product.Category.SPEAKER).get(2);
        this.DD = Database.getProductByCategory(Product.Category.HDD).get(2);
        this.FA = Database.getProductByCategory(Product.Category.POWER_SUPPLY).get(2);
        this.GR = Database.getProductByCategory(Product.Category.DVD_WRITER).get(2);
        this.MR = Database.getProductByCategory(Product.Category.RAM).get(2);
        this.MO = Database.getProductByCategory(Product.Category.SCREEN).get(2);
        this.MU = Database.getProductByCategory(Product.Category.MULTIREADER).get(2);
        this.PB = Database.getProductByCategory(Product.Category.MOTHERBOARD).get(2);
        this.PR = Database.getProductByCategory(Product.Category.CPU).get(2);
        this.RA = Database.getProductByCategory(Product.Category.MOUSE).get(2);
        this.GPU = Database.getProductByCategory(Product.Category.GPU).get(2);
        this.TE = Database.getProductByCategory(Product.Category.KEYBOARD).get(2);
        this.TO = Database.getProductByCategory(Product.Category.CASE).get(2);
        this.VE = Database.getProductByCategory(Product.Category.FAN).get(2);
        
        this.cantPB = 1;
        this.cantPR = 1;
        this.cantMR = 1;
        this.cantGPU = 1;
        this.cantDD = 1;
        this.cantTO = 1;

        this.cantTE = 1;
        this.cantRA = 1;
        this.cantMO = 1;
        this.cantAL = 1;
        this.cantMU = 1;
        this.cantGR = 1;
        this.cantVE = 1;
        this.cantFA = 1;
             
        
        this.precio = new SimpleDoubleProperty(this.PB.getPrice()*cantPB + this.PR.getPrice()*cantPR + this.MR.getPrice()*cantMR + this.GPU.getPrice()*cantGPU + this.DD.getPrice()*cantDD + this.TO.getPrice()*cantTO + 
                this.TE.getPrice()*cantTE + this.RA.getPrice()*cantRA + this.MO.getPrice()*cantMO + this.AL.getPrice()*cantAL + this.MU.getPrice()*cantMU + this.GR.getPrice()*cantGR + this.VE.getPrice()*cantVE + 
                this.FA.getPrice()*cantFA);
        this.precioString = new SimpleStringProperty(this.precio.toString());
    }
    public PC(String nombre,  Product PB, Product PR, Product MR, Product GPU, Product DD, Product TO,
            int cantPB, int cantPR, int cantMR, int cantGPU, int cantDD, int cantTO){
        this.nombre = new SimpleStringProperty(nombre);
        
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

        //calcular precio
        if(PB==null || PR==null || MR==null || GPU==null || DD==null || TO==null ){
            this.precio = new SimpleDoubleProperty(0);
            this.precioString = new SimpleStringProperty("0");
        }
        else{
            this.precio = new SimpleDoubleProperty(PB.getPrice()*cantPB + PR.getPrice()*cantPR + MR.getPrice()*cantMR + GPU.getPrice()*cantGPU + DD.getPrice()*cantDD + TO.getPrice()*cantTO);
            this.precioString = new SimpleStringProperty(this.precio.toString());
        }
        
    }
    
    public PC(String nombre,  Product PB, Product PR, Product MR, Product GPU, Product DD, Product TO,
            Product TE, Product RA, Product MO, Product AL, Product MU, Product GR, Product VE, Product FA,
            int cantPB, int cantPR, int cantMR, int cantGPU, int cantDD, int cantTO,
            int cantTE, int cantRA, int cantMO, int cantAL, int cantMU, int cantGR, int cantVE, int cantFA){
        this.nombre = new SimpleStringProperty(nombre);
        
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
        //calcular precio
        this.precio = new SimpleDoubleProperty(PB.getPrice()*cantPB + PR.getPrice()*cantPR + MR.getPrice()*cantMR + GPU.getPrice()*cantGPU + DD.getPrice()*cantDD + TO.getPrice()*cantTO + 
                TE.getPrice()*cantTE + RA.getPrice()*cantRA + MO.getPrice()*cantMO + AL.getPrice()*cantAL + MU.getPrice()*cantMU + GR.getPrice()*cantGR + VE.getPrice()*cantVE + 
                FA.getPrice()*cantFA);
                this.precioString = new SimpleStringProperty(this.precio.toString());
    }
    
    public void recalcularPrecio(){
        this.precio = new SimpleDoubleProperty(PB.getPrice()*cantPB + PR.getPrice()*cantPR + MR.getPrice()*cantMR + GPU.getPrice()*cantGPU + DD.getPrice()*cantDD + TO.getPrice()*cantTO + 
                TE.getPrice()*cantTE + RA.getPrice()*cantRA + MO.getPrice()*cantMO + AL.getPrice()*cantAL + MU.getPrice()*cantMU + GR.getPrice()*cantGR + VE.getPrice()*cantVE + 
                FA.getPrice()*cantFA);
        this.precioString = new SimpleStringProperty(this.precio.toString());
    }
    

    /**
     * @return the nombre
     */
    public StringProperty getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(StringProperty nombre) {
        this.nombre = nombre;
    }

        /**
     * @return the precio
     */
    public DoubleProperty getPrecio() {
        return precio;
    }
    
    public ObservableValue<Double> getPrecioObservable(){
        ObservableValue<Double> obsDouble = new ReadOnlyObjectWrapper<>(getPrecio().getValue());
        return obsDouble;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(DoubleProperty precio) {
        this.precio = precio;
    }

    /**
     * @return the PB
     */
    public Product getPB() {
        return PB;
    }

    /**
     * @param PB the PB to set
     */
    public void setPB(Product PB) {
        this.PB = PB;
    }

    /**
     * @return the PR
     */
    public Product getPR() {
        return PR;
    }

    /**
     * @param PR the PR to set
     */
    public void setPR(Product PR) {
        this.PR = PR;
    }

    /**
     * @return the MR
     */
    public Product getMR() {
        return MR;
    }

    /**
     * @param MR the MR to set
     */
    public void setMR(Product MR) {
        this.MR = MR;
    }

    /**
     * @return the GPU
     */
    public Product getGPU() {
        return GPU;
    }

    /**
     * @param GPU the GPU to set
     */
    public void setGPU(Product GPU) {
        this.GPU = GPU;
    }

    /**
     * @return the DD
     */
    public Product getDD() {
        return DD;
    }

    /**
     * @param DD the DD to set
     */
    public void setDD(Product DD) {
        this.DD = DD;
    }

    /**
     * @return the TO
     */
    public Product getTO() {
        return TO;
    }

    /**
     * @param TO the TO to set
     */
    public void setTO(Product TO) {
        this.TO = TO;
    }

    /**
     * @return the TE
     */
    public Product getTE() {
        return TE;
    }

    /**
     * @param TE the TE to set
     */
    public void setTE(Product TE) {
        this.TE = TE;
    }

    /**
     * @return the RA
     */
    public Product getRA() {
        return RA;
    }

    /**
     * @param RA the RA to set
     */
    public void setRA(Product RA) {
        this.RA = RA;
    }

    /**
     * @return the MO
     */
    public Product getMO() {
        return MO;
    }

    /**
     * @param MO the MO to set
     */
    public void setMO(Product MO) {
        this.MO = MO;
    }

    /**
     * @return the AL
     */
    public Product getAL() {
        return AL;
    }

    /**
     * @param AL the AL to set
     */
    public void setAL(Product AL) {
        this.AL = AL;
    }

    /**
     * @return the MU
     */
    public Product getMU() {
        return MU;
    }

    /**
     * @param MU the MU to set
     */
    public void setMU(Product MU) {
        this.MU = MU;
    }

    /**
     * @return the GR
     */
    public Product getGR() {
        return GR;
    }

    /**
     * @param GR the GR to set
     */
    public void setGR(Product GR) {
        this.GR = GR;
    }

    /**
     * @return the VE
     */
    public Product getVE() {
        return VE;
    }

    /**
     * @param VE the VE to set
     */
    public void setVE(Product VE) {
        this.VE = VE;
    }

    /**
     * @return the FA
     */
    public Product getFA() {
        return FA;
    }

    /**
     * @param FA the FA to set
     */
    public void setFA(Product FA) {
        this.FA = FA;
    }

    /**
     * @return the cantPB
     */
    public int getCantPB() {
        return cantPB;
    }

    /**
     * @param cantPB the cantPB to set
     */
    public void setCantPB(int cantPB) {
        this.cantPB = cantPB;
    }

    /**
     * @return the cantPR
     */
    public int getCantPR() {
        return cantPR;
    }

    /**
     * @param cantPR the cantPR to set
     */
    public void setCantPR(int cantPR) {
        this.cantPR = cantPR;
    }

    /**
     * @return the cantMR
     */
    public int getCantMR() {
        return cantMR;
    }

    /**
     * @param cantMR the cantMR to set
     */
    public void setCantMR(int cantMR) {
        this.cantMR = cantMR;
    }

    /**
     * @return the cantGPU
     */
    public int getCantGPU() {
        return cantGPU;
    }

    /**
     * @param cantGPU the cantGPU to set
     */
    public void setCantGPU(int cantGPU) {
        this.cantGPU = cantGPU;
    }

    /**
     * @return the cantDD
     */
    public int getCantDD() {
        return cantDD;
    }

    /**
     * @param cantDD the cantDD to set
     */
    public void setCantDD(int cantDD) {
        this.cantDD = cantDD;
    }

    /**
     * @return the cantTO
     */
    public int getCantTO() {
        return cantTO;
    }

    /**
     * @param cantTO the cantTO to set
     */
    public void setCantTO(int cantTO) {
        this.cantTO = cantTO;
    }

    /**
     * @return the cantTE
     */
    public int getCantTE() {
        return cantTE;
    }

    /**
     * @param cantTE the cantTE to set
     */
    public void setCantTE(int cantTE) {
        this.cantTE = cantTE;
    }

    /**
     * @return the cantRA
     */
    public int getCantRA() {
        return cantRA;
    }

    /**
     * @param cantRA the cantRA to set
     */
    public void setCantRA(int cantRA) {
        this.cantRA = cantRA;
    }

    /**
     * @return the cantMO
     */
    public int getCantMO() {
        return cantMO;
    }

    /**
     * @param cantMO the cantMO to set
     */
    public void setCantMO(int cantMO) {
        this.cantMO = cantMO;
    }

    /**
     * @return the cantAL
     */
    public int getCantAL() {
        return cantAL;
    }

    /**
     * @param cantAL the cantAL to set
     */
    public void setCantAL(int cantAL) {
        this.cantAL = cantAL;
    }

    /**
     * @return the cantMU
     */
    public int getCantMU() {
        return cantMU;
    }

    /**
     * @param cantMU the cantMU to set
     */
    public void setCantMU(int cantMU) {
        this.cantMU = cantMU;
    }

    /**
     * @return the cantGR
     */
    public int getCantGR() {
        return cantGR;
    }

    /**
     * @param cantGR the cantGR to set
     */
    public void setCantGR(int cantGR) {
        this.cantGR = cantGR;
    }

    /**
     * @return the cantVE
     */
    public int getCantVE() {
        return cantVE;
    }

    /**
     * @param cantVE the cantVE to set
     */
    public void setCantVE(int cantVE) {
        this.cantVE = cantVE;
    }

    /**
     * @return the cantFA
     */
    public int getCantFA() {
        return cantFA;
    }

    /**
     * @param cantFA the cantFA to set
     */
    public void setCantFA(int cantFA) {
        this.cantFA = cantFA;
    }

    /**
     * @return the precioString
     */
    public StringProperty getPrecioString() {
        return precioString;
    }

    /**
     * @param precioString the precioString to set
     */
    public void setPrecioString(StringProperty precioString) {
        this.precioString = precioString;
    }

    
}
