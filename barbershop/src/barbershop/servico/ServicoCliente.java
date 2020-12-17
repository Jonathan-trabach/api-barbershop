package barbershop.servico;

import barbershop.controlador.CIH_Atendimento;
import barbershop.persistencia.ClienteDAO;
import java.util.List;
import barbershop.modelo.Cliente;
import barbershop.modelo.Servico;
import barbershop.visao.JanelaAtendimento;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

public class ServicoCliente {
          
   private static ClienteDAO clienteDAO = new ClienteDAO();
    
    public static void criarCliente(Cliente c) throws Exception{
        //montar objeto
        clienteDAO.inserir(c);
        Servico.registarObervador(c);
        
    }
    
    public static void preecnherComboBoxClientes(JComboBox jComboBoxClientes){
        jComboBoxClientes.removeAllItems();
        try {
            List <Cliente> result = CIH_Atendimento.preencherComboBoxCliente();
            for(Cliente c : result){
                jComboBoxClientes.addItem(c.nome);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(JanelaAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
