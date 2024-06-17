package cajero;

import java.io.IOException;
import javax.swing.JOptionPane;

public class Cajero {

    public static void main(String[] args) throws IOException {
        int opcion = 0;
        Transacciones objTrans = new Transacciones();
        Login objLogin = new Login();
        
        try {
        	if(!objLogin.login()) {
        		System.exit(0);
        	}
        	
            while(opcion != 4) {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción: "
                        + "\n 1. Consultar saldo. "
                        + "\n 2. Realizar retiro. "
                        + "\n 3. Realizar deposito. "
                        + "\n 4. Salir."));

                switch(opcion) {
                    case 1: objTrans.consultar(); break;
                    case 2: objTrans.retirar(); break;
                    case 3: objTrans.depositar(); break;
                    case 4: JOptionPane.showMessageDialog(null, "¡Gracias! Vuelva pronto."); break;
                    default: JOptionPane.showMessageDialog(null, "Opción no valida, por favor seleccione nuevamente."); break;
                }
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "¡ERROR EN EL SISTEMA! " + ex);
        }
    }
}
