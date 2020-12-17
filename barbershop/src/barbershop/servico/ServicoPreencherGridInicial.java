package barbershop.servico;

import barbershop.modelo.Atendimento;
import barbershop.persistencia.AtendimentoDAO;
import java.awt.Color;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ServicoPreencherGridInicial {

    static List<Atendimento> atendimentos;
    static JTable jTable = new JTable();
    
    public static void preecherGridAtendimento(JTable jTableFila) throws Exception{
        atendimentos = AtendimentoDAO.buscarAtendimentos();
        carregarGrade(jTableFila);
      
    }
      
    private static void carregarGrade( JTable jTableFila) {
        jTable = jTableFila; 
        String status = "Esperando";
        
        DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[]{"HORA", "CLIENTE", "SERVICO", "STATUS"}, 0);
        
        for(int i = 0;i < atendimentos.size(); i++){
            
            if(atendimentos.get(i).dataFim != null){
                status = "Finalizado";
            }else{
                status = "Esperando";
            }
            
            Object linha[] = new Object[]{
                    atendimentos.get(i).dataInicio.toString().substring(11, 16),
                    atendimentos.get(i).cliente.nome,
                    atendimentos.get(i).servico.nomeServico,
                    status,    
                    };
           
           defaultTableModel.addRow(linha);
        }
 
        estilizacaoTabela(jTableFila, defaultTableModel);
    }
    
    private static void estilizacaoTabela(JTable jTableFila, DefaultTableModel defaultTableModel){
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Color.DARK_GRAY);
        headerRenderer.setForeground(Color.WHITE);
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                
        jTableFila.setModel(defaultTableModel);
        jTableFila.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTableFila.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTableFila.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTableFila.getColumnModel().getColumn(3).setCellRenderer(centralizado);
       
        
        jTableFila.getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
        jTableFila.getColumnModel().getColumn(1).setHeaderRenderer(headerRenderer);
        jTableFila.getColumnModel().getColumn(2).setHeaderRenderer(headerRenderer);
        jTableFila.getColumnModel().getColumn(3).setHeaderRenderer(headerRenderer);
       
        ;
    }
}
