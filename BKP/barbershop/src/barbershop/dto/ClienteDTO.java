/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.dto;

public class ClienteDTO {
    
    private String nome;
    private String sobreNome;
    private String cpf;
    private String genero;
    private String contato;

    public ClienteDTO(String nome, String sobreNome, String cpf, String genero, String contato) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.cpf = cpf;
        this.genero = genero;
        this.contato = contato;
    }
    
    public void validarCpf(String cpr){
        // TODO implementar um metodo que valide o CPF do caboco
    }
    
    public String getNomeCompleto(String nome, String sobreNome){
        return nome.concat(sobreNome);
    }
    
    // CODIGO GERADO get() and set()
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    
}

