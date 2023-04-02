package contabanco;
/**
 *
 * @author tiago
 */
public class ContaBanco {
    
//    Variables
   
    public int numConta;
    protected String tipo;
    private String dono;
    private double saldo;
    private boolean status;

//    Constructors

    public ContaBanco() {
        this.saldo = 0.0;
        this.status = false;
    }
    
//    Getters and Setters
    
    public int getNumConta() {
        return numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void setStatus(boolean status){
        this.status = status;
    }
    
    public boolean getStatus(){
        return this.status;
    }
    
//    Logic

    public void abrirConta(String tipo){
        switch (tipo) {
            case "cc":
                this.setSaldo(50);
                this.setTipo(tipo);
                this.setStatus(true);
                break;
            case "cp":
                this.setSaldo(150);
                this.setTipo(tipo);
                this.setStatus(true);
                break;
            default:
                System.out.println("[-] Tipo inválido.");
                break;
        }
    }
    
    public void sacar(float valorSaque){
        if (valorSaque <= this.getSaldo() && this.getStatus())
            this.setSaldo(this.getSaldo() - valorSaque);
        else
            System.out.println("[-] Valor inválido.");
    }
    
    public void depositar(float valorDeposito){
        if (this.getStatus())
            this.setSaldo(this.getSaldo() + valorDeposito);
        else
            System.out.println("[-] Conta fechada.");
    }
    
    public void mensalidade(){
        if (this.getStatus() && this.getTipo().equals("cc"))
            this.setSaldo(this.getSaldo() - 12);
        if (this.getStatus() && this.getTipo().equals("cp")){
            this.setSaldo(this.getSaldo() - 20);
        }
    }
    
    public void fecharConta(){
        if (this.getSaldo() > 0 && getSaldo() < 0){
            System.out.println("[-] Conta com saldo ou débito.");
        } else {
            this.setStatus(false);
        }
    }       
}
