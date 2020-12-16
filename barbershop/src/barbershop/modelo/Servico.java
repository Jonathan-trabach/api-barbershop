package barbershop.modelo;

import barbershop.modelo.Cliente;
import java.util.ArrayList;

public class Servico {
    
 
    public String nomeServico;
    public String precoServico;
    public static ArrayList<ObservadorServico> observadores = new ArrayList<ObservadorServico>() ;
    
    
    public static void registarObervador(ObservadorServico observador){
        observadores.add(observador);
    }
    
    public static void notificarObervadores(Servico s){
        for(ObservadorServico observador: observadores){
            observador.processarCadastro(s);
        }
    }

    
}
