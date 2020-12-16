package barbershop.modelo;

import java.util.ArrayList;

public class Cliente extends ObservadorServico {
    
    public int id;
    public String nome;
    public String email;
    public String cpf;

    public void processarCadastro(Servico s) {
        System.out.println("cliente "+this.nome+"um novo serviço foi cadastrado:"+s.nomeServico);
    }
   
}
