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

    public void editarDoutor(int index, String nome, String especialidade){
        doutores.get(index).setNome(nome);
        doutores.get(index).setEspecialidade(especialidade);
    }

    public ArrayList<Doutor> getDoutores() {
        return doutores;
    }

    public void adicionarPaciente(Paciente paciente){
        pacientes.add(paciente);
    }

    public void removerPaciente(int index){
        pacientes.remove(index);
    }

    public void editarPaciente(int index, String nome, int idade, String cpf, String dataNascimento){
        pacientes.get(index).setNome(nome);
        pacientes.get(index).setIdade(idade);
        pacientes.get(index).setCpf(cpf);
        pacientes.get(index).setDataNascimento(dataNascimento);
    }

    public void exibirPacientesComNome(String nome) {
        for (Paciente listaPaciente : pacientes) {
            if (listaPaciente.getNome().equals(nome)) {
                listaPaciente.print();
                System.out.println("--------------------------------");
            }
        }
    }

    public int pesquisarPacienteCpf(String cpf) {
        int index = 0;

        for (Paciente listaPaciente : pacientes) {
            if (listaPaciente.getNome().equals(cpf)) {
                index = pacientes.indexOf(listaPaciente);
            }
        }
        return index;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void exibirTodosDoutores(){
        for (Doutor doutores : doutores) {
            doutores.print();
            System.out.println("--------------------------------");
        }
    }

    public void exibirTodosPacientes(){
        for (Paciente paciente : pacientes) {
            paciente.print();
            System.out.println("--------------------------------");
        }
    }

}
