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
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equals(nome)) {
                paciente.print();
                System.out.println("--------------------------------");
            }
        }
    }

    public void exibirPacientesComCpf(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equals(cpf)) {
                paciente.print();
                System.out.println("--------------------------------");
            }
        }
    }

    public void exibirDoutoresComNome(String nome) {
        for (Doutor doutor : doutores) {
            if (doutor.getNome().equals(nome)) {
                doutor.print();
                System.out.println("--------------------------------");
            }
        }
    }

    public void exibirDoutoresComEspecialidade(String especialidade) {
        for (Doutor doutor : doutores) {
            if (doutor.getNome().equals(especialidade)) {
                doutor.print();
                System.out.println("--------------------------------");
            }
        }
    }

    //apenas retorna a última ocorrencia do cpf localizado pois o CPF, em teoria, deve ser único
    public int pesquisarPacienteCpf(String cpf) {
        int index = 0;

        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equals(cpf)) {
                index = pacientes.lastIndexOf(paciente);
            }
        }
        return index;
    }

    //esse metodo retorna cada posição do indice da array doutores que o nome foi encontrado
    public ArrayList<Integer> pesquisarDoutorNome(String nome){
        int indices;
        ArrayList<Integer> ocorrenciasIndices = new ArrayList<>();

        for(Doutor doutor : doutores){
            if (doutor.getNome().equals(nome)){
                indices = doutores.indexOf(doutor);
                ocorrenciasIndices.add(indices);
            }
        }

        return ocorrenciasIndices;
    }

    //esse metodo retorna cada posição do indice da array doutores que a especialidade foi encontrado
    public ArrayList<Integer> pesquisarDoutorEspecialidade(String especialidade){
        int indices;
        ArrayList<Integer> ocorrenciasIndices = new ArrayList<>();

        for(Doutor doutor : doutores){
            if (doutor.getNome().equals(especialidade)){
                indices = doutores.indexOf(doutor);
                ocorrenciasIndices.add(indices);
            }
        }

        return ocorrenciasIndices;
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
