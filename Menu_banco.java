


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
public class Menu_banco {
    static CuentaBancaria account;
    static Solicitud give;
            
    public static void main(String[]args)throws Exception{//Desde esta clase llamamos a todas las demás clases 
        //Instaciamos la clase para solicitar por tecladolo que me introducen en Solicitud
        give = new Solicitud();
        //Instaciamos la CuentaBancaria
        account = new CuentaBancaria(give.ask_holder(),give.ask_numberaccount());
        
        int option;//Guardamos la opción del usuario
       
        //El bucle se realiza hasta que pulsamos la option 0 y salimos del mismo
        do{
          try{
            option = Integer.parseInt(give.menu());//Se ve el menu
          }catch (NumberFormatException nfe){
            System.out.println("Sólo valores entre 0 y 9 carácteres no");
            option = 10;
          }
            switch(option){
                case 1:
                       System.out.println(account.see_number_account());
                    break;
                case 2:
                    System.out.println("El titular de la cuenta es "+account.getHolder());
                    break;
                case 3:
                    System.out.println("El código de entidad es "+account.see_entidad());
                    break;
                case 4:
                    System.out.println("El código de oficina es "+account.see_office());
                    break;
                case 5:
                    System.out.println("Los 10 dígitos de la cuenta son "+account.see_digit_account());
                    break;
                case 6:
                    System.out.println("El dígito de control es: "+CuentaBancaria.get_digit_control(account.getNumber_account()));                    
                    break;
                case 7:
                    account.entry_money(give.give_money());
                    break;
                case 8:
                    account.out_money(give.give_money());
                    break;
                case 9:
                    System.out.println("El saldo actual es de "+account.getbalance()+"€");
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Introduzca un opción del 1 al 10");
                    break;                
            }
        }while(option !=0);       
    }
}
