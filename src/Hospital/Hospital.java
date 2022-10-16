package Hospital;

import java.util.ArrayList;

public class Hospital {
    private ArrayList<Doutor> doutores = new ArrayList<>();
    private ArrayList<Paciente> pacientes = new ArrayList<>();

    public void adicionarDoutor(Doutor doutor){
        doutores.add(doutor);
    }

    public void removerDoutor(int index){
        doutores.remove(index);
    }

    public void editarDoutor(int index, String novoNome, String novaEspecialidade){
        doutores.get(index).setNome(novoNome);
        doutores.get(index).setEspecialidade(novaEspecialidade);
    }

    public ArrayList<Doutor> getDoutores() {
        return doutores;
    }

    public void exibirTodosDoutores(){
        for(int index = 0; index < doutores.size(); index++){
            doutores.get(index).print();
            System.out.println("");
        }
    }
}
