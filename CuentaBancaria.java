/*
 * Clase con que realiza todas las operaciones en el menú
 * 
 * 
 */
package Menu_banco;

/**
 *
 * @author Nauzet
 */
public class CuentaBancaria {
        //Definimos las propiedades de la clase 
        private String holder;//titular de la cuenta
        private String number_account;//número de cuenta
        private double balance;//Saldo de la cuenta
        private boolean correct = false;
        
        
        //Creamos un constructor que rellena las variables titular y la cuenta
    public CuentaBancaria(String holder, String account)throws Exception{
        //Solo guarda los datos cuando son correctos
        //Ya que se comprueban el método que se piden los datos
        this.holder = holder;//titular
        this.number_account = account;//numero de cuenta
        this.balance = 0;//saldo
        }//Creamos constructor cuenta, rellenamos los datos puesto en clase CuentaBancaria que seria neustro formulario


    public String getHolder() { //Obtenemos titular 
        return holder;
    }//Metodo que devuelve el titular de la cuenta

    public String getNumber_account() {
        return number_account;
    }//Metodo que devuelve el número de cuenta solamente
    
    //Método que nos devuelve el número de cuenta ordenado
    public String see_number_account(){
        String account;
        account  = "El número de cuenta es:";
        account += this.number_account.substring(0,4) + ("-");
        account += this.number_account.substring(4,8) + ("-");
        account += CuentaBancaria.get_digit_control(this.number_account) + ("-");
        account += this.number_account.substring(10,20) + ("-");
        return account;       
    }

    //Método que devuelve el número de entidad
    public String see_entidad(){
        return this.getNumber_account().substring(0,4);
    }
    
    
    //Método que devuelve el número de la oficina
    public String see_office(){
        return this.getNumber_account().substring(4,8);
    }
    
    //Método que nos devuelve los 10 dígitos de la cuenta
    public String see_digit_account(){
        return this.getNumber_account().substring(10,20);
    }
    
    //Método que ingresa dienero en la cuenta
    public void entry_money(double quantity){
       this.balance = this.balance + quantity;
    }
    
    //Creamos un método con una estructura de control para evitar que se pueda sacar dinero que no tienes.
    public void out_money(double quantity){
        if (quantity > this.balance){
            System.out.println ("No tiene saldo suficiente");
        }else{
            this.balance = this.balance - quantity;
        }
    }
    
    
    //Método que nos devuelve el saldo de la cuenta
    public double getbalance(){
        return balance;
    }
    
    //Código para calcular los dígitos de control
    public static String get_digit_control(String number_account){
        int digit1 = 0;
        int digit2 = 0;
        int count;
        //Creamos un array donde introducimos los multiplicadores que necesitamos para realizar la multiplicación 
        int[] multiplica ={1,2,4,8,5,10,9,7,3,6};
        //Sumamos cada digito del array, 
        //las pisiciones del array multiplica cada número de la cuenta
        //Omitimos las 2 primeros número de la cuenta
        
        for (count = 0; count < (multiplica.length - 2);count ++){
        digit1 += multiplica[count+2] * Integer.parseInt(number_account.substring(count, count+1));        
       }
        //Summaos cada digito de la cuenta por cada número del array
        for (count = 0; count < multiplica.length;count ++){
        digit2 += multiplica[count] * Integer.parseInt(number_account.substring((count+10),(count+10+1)));        
       }
     
        //Restamos 11 al resto de la división del resultado obtenido 
        digit1 = 11 - (digit1%11);
        digit2 = 11 - (digit2%11);
        
        //Si el resto es 10 el digito es 1. si es 11 es 0
        String digit = String.valueOf(digit1) + String.valueOf(digit2);
        return digit;     
    }         
}
