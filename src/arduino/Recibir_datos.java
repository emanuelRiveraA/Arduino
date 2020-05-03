/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduino;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import com.sun.glass.ui.Window.Level;
import java.util.logging.Logger;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author Idalia
 */
public class Recibir_datos {
    
    //Se crea una instancia de la librería PanamaHitek_Arduino
    private static PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    private static final SerialPortEventListener listener = new SerialPortEventListener() {
        public void serialEvent(SerialPortEvent spe) {
           
            try {
                if (ino.isMessageAvailable()) {
                    //Se imprime el mensaje recibido en la consola
                    System.out.println(ino.printMessage());
                }
            } catch (SerialPortException ex) {
                Logger.getLogger(Recibir_datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (ArduinoException ex) {
                Logger.getLogger(Recibir_datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
           

        }

       
    };
    
     public static void main(String[] args) throws ArduinoException, SerialPortException {
        
            ino.arduinoRX("COM3", 9600, listener);
        
    }
}
