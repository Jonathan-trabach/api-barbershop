/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.dto;

public class ServicosDTO {
    
    private String nomeServico;
    private double preco;
    private double tempoEstimado;

    public ServicosDTO(String nomeServico, double preco, double tempoEstimado) {
        this.nomeServico = nomeServico;
        this.preco = preco;
        this.tempoEstimado = tempoEstimado;
    }
   
    
    // CODIGO GERADO
    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(double tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }
    
}
