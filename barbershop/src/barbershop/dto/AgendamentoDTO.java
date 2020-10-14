/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.dto;

import java.util.Date;
import java.util.List;

public class AgendamentoDTO {
    
    private ClienteDTO cliente; 
    private List<ServicosDTO> servico;
    private Date dataAgendamento;

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public List<ServicosDTO> getServico() {
        return servico;
    }

    public void setServico(List<ServicosDTO> servico) {
        this.servico = servico;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }
}
