/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.modelo;

import barbershop.persistencia.AtendimentoDAO;
import java.util.List;
import javax.swing.JOptionPane;


public class AtendimentoCombo extends Atendimento{
    
    public boolean criarComboParaDesconto () throws Exception {
        List<Atendimento> buscarAtendimentos = AtendimentoDAO.buscarAtendimentos();
        int idClientePromocao = 1;
        for (Atendimento atendimento: buscarAtendimentos) {
            if (atendimento.cliente.id == idClientePromocao){
                JOptionPane.showMessageDialog(null, "Você ganhou 10% de desconto!");
                return true;
            }
        }
        return false;
    }
    
}
