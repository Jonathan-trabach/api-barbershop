package grid;

import barbershop.modelo.Atendimento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class GridListaAtendemento extends AbstractTableModel {

    private String colunas[] = {"HORA", "CLIENTE", "SERVICO"};
    private List<Atendimento> dados;

    @Override
    public int getRowCount() {
        if(dados == null){
            return 0;
        }
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int l, int c) {
        Atendimento atendimento = dados.get(l);
        switch (c) {
            case 0:
                return atendimento.dataInicio;
            case 1:
                return atendimento.idCliente;
            case 2:
                return atendimento.idServico;
            default:
                throw new IndexOutOfBoundsException("Coluna inexistente!");
        }
    }

    @Override
    public String getColumnName(int c) {
        return colunas[c];
    }

    @Override
    public boolean isCellEditable(int l, int c) {
        return false;
    }

    public void setDados(List<Atendimento> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Atendimento getRowValue(int l) {
        return dados.get(l);
    }
}
