/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu_banco;
import java.util.Scanner;

/**
 *
 * @author Nauzet
 */
//Clase donde se hacen las recogida de la información por teclado
public class Solicitud {
    Scanner read_keyboard = new Scanner(System.in);
    
    //Método donde pedimos el nombre del titular de la cuenta
    public String ask_holder(){//Pedimos el titular
    String headline = "x";//Titular de la cuenta
    do{
        System.out.println("Introduce el nombre del titular de la cuenta");
        headline = read_keyboard.nextLine();
       }while ((headline.length() <5) || (headline.length() >20));
       return headline;
    }//Ya nuestro metodo tiene un control de caráteres usando un bucle "while" y usando función "length" 
    //letras especificamso un rago de menos 5 a menso 20
    
    
    //Creamo un método para solicitar el número de cuenta
    public String ask_numberaccount(){
        boolean check_numberaccount = false;
        String account = "x";
        do{
        System.out.println("Introduce el número de la cuenta");  
        account = read_keyboard.next();
        //Realizamos un control para comprobar que se introduce un número de cuenta
        if(account.length() != 20){ //La cuenta no puede ser distinta de 20 digitos
           System.out.println("La cuenta no tiene 20 digítos");
           check_numberaccount = false;
        }else{//Si llegamos a este punto la cuenta tiene 20 digitos
            //Chequeamos que los número introducido son enteros
            check_numberaccount = this.number_entero(account);
            if(check_numberaccount == false){//No es entero
                System.out.println("Introduce dígitos enteros");
            }else check_numberaccount = false;
                //Calculamos los dígitos de control y los comparamos con lo introducidos
          if(CuentaBancaria.get_digit_control(account).equals(account.substring(8,10))){
            check_numberaccount = true; // Son correctos los dígitos de control
          }else check_numberaccount = false;
        }
    }while (check_numberaccount == false);
    return account;
    }
   


  public boolean number_entero(String cadena){
    //Recorre la cadena entera comprobando si es número entero o no
    for (int x = 0;x < cadena.length();x++){
      try{
         Integer.parseInt(cadena.substring(x, x+1));
        }catch(NumberFormatException e){ //Se ejecuta cuando no es un nº entero
        System.out.println(cadena.substring(x, x+1)+" no es un entero");
        return false;
        } 
    }
    return true;
    }

 public double give_money() throws Exception{
    String dato;
    double cantidad = 0;
    boolean error;
    do{
      try{
        System.out.println("Introduce la cantidad:");
        error = false;
        dato = read_keyboard.next();
        cantidad = Double.parseDouble(dato);
        if(cantidad < 0){
          throw new Exception("No se puede ingresar una cantidad negativa");
        }
      }catch(NumberFormatException e){
        System.out.println(e.getMessage());
        System.out.println("introduce ún número entero");
        error=true;
      }catch(Exception e){
        System.out.println(e.getMessage());
        //System.out.println("Excepción desconocida");
        error=true;
      }
    }while(error);
    return cantidad;
  }
  
  /**
   * Método para mostrar el menú de opciones 
   * y solicitar la opción a elegir
   * @return opcion
   */
  public String menu(){
        System.out.println("================================ M E N Ú =====================================");//Menu que ve elusuario
            System.out.println("| Opción 1: Ver el número de cuenta completo (CCC - Código Cuenta Cliente|");
            System.out.println("| Opción 2: Ver el titular de la cuenta                                  |");
            System.out.println("| Opción 3: Ver el código de la entidad                                  |");
            System.out.println("| Opción 4: Ver el titular de la oficina                                 |");
            System.out.println("| Opción 5: Ver el número de cuenta                                      |");
            System.out.println("| Opción 6: Ver los dígitos de control de la cuenta                      |");
            System.out.println("| Opción 7: Realizar un ingreso                                          |");
            System.out.println("| Opción 8: Retirar efectivo                                             |");
            System.out.println("| Opción 9: Consultar saldo                                              |");
            System.out.println("| Opción 10: para salir de la aplicación pulse 0                         |");
            System.out.println("| Introduce tu opción a continuación                                     |");
            String option = read_keyboard.next();
            System.out.println("Ejecutando opción: " + option + "...");
            return option;
    }
}