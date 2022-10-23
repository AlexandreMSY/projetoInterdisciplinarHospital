package Hospital;

import java.util.ArrayList;

public class Hospital {
    private ArrayList<Doutor> doutores = new ArrayList<>();
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Consulta> consultas = new ArrayList<>();


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

    public void removerPaciente(String cpf){
        int indice = 0;

        for (Paciente paciente : pacientes){
            if (paciente.getCpf().equals(cpf)){
                indice = pacientes.indexOf(paciente);
            }
        }

        pacientes.remove(indice);
    }

    public void editarPaciente(int index, String nome, int idade, String cpf, String dataNascimento){
        pacientes.get(index).setNome(nome);
        pacientes.get(index).setIdade(idade);
        pacientes.get(index).setCpf(cpf);
        pacientes.get(index).setDataNascimento(dataNascimento);
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void adicionarConsulta(Consulta consulta){
        consultas.add(consulta);
    }

    public void removerConsulta(int index){
        consultas.remove(index);
    }

    public void editarColsulta(int index, Paciente paciente, Doutor doutor, String dataConsulta){
        consultas.get(index).setPaciente(paciente);
        consultas.get(index).setDoutor(doutor);
        consultas.get(index).setDataConsulta(dataConsulta);
    }

    public ArrayList<Consulta> getConsultas(){
        return consultas;
    }

    public void exibirPacientesComNome(String nome) {
        int id;

        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equals(nome)) {
                id = pacientes.indexOf(paciente);
                System.out.println("ID: " + id);
                paciente.print();
                System.out.println("--------------------------------");
            }
        }
    }

    public void exibirPacientesComCpf(String cpf) {
        int id;

        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                id = pacientes.indexOf(paciente);
                System.out.println("ID: " + id);
                paciente.print();
                System.out.println("--------------------------------");
            }
        }
    }

    public void exibirDoutoresComNome(String nome) {
        int id;

        for (Doutor doutor : doutores) {
            if (doutor.getNome().equals(nome)) {
                id = doutores.indexOf(doutor);
                System.out.println("ID: " + id);
                doutor.print();
                System.out.println("--------------------------------");
            }
        }
    }

    public void exibirDoutoresComEspecialidade(String especialidade) {
        int id;

        for (Doutor doutor : doutores) {
            if (doutor.getEspecialidade().equals(especialidade)) {
                id = doutores.indexOf(doutor);
                System.out.println("ID: " + id);
                doutor.print();
                System.out.println("--------------------------------");
            }
        }
    }

    public void exibirConsultasComNomeDoPaciente(String nome) {
        int id;

        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().getNome().equals(nome)) {
                id = consultas.indexOf(consulta);
                System.out.println("ID: " + id);
                consulta.print();
                System.out.println("--------------------------------");
            }
        }
    }

    public void exibirConsultasComNomeDoDoutor(String nome) {
        int id;

        for (Consulta consulta : consultas) {
            if (consulta.getDoutor().getNome().equals(nome)) {
                id = consultas.indexOf(consulta);
                System.out.println("ID: " + id);
                consulta.print();
                System.out.println("--------------------------------");
            }
        }
    }

    public void exibirConsultasComEspecialidade(String especialidade) {
        int id;

        for (Consulta consulta : consultas) {
            if (consulta.getDoutor().getEspecialidade().equals(especialidade)) {
                id = consultas.indexOf(consulta);
                System.out.println("ID: " + id);
                consulta.print();
                System.out.println("--------------------------------");
            }
        }
    }

    //apenas retorna a última ocorrencia do cpf localizado pois o CPF, em teoria, deve ser único
    public ArrayList<Integer> indicesPacientesNome(String nome) {
        int indices;
        ArrayList<Integer> ocorrenciasIndices = new ArrayList<>();

        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(nome)) {
                indices = pacientes.indexOf(paciente);
                ocorrenciasIndices.add(indices);
            }
        }

        return ocorrenciasIndices;
    }
    public ArrayList<Integer> indicesPacientesCpf(String cpf) {
        int indices;
        ArrayList<Integer> ocorrenciasIndices = new ArrayList<>();

        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                indices = pacientes.indexOf(paciente);
                ocorrenciasIndices.add(indices);
            }
        }

        return ocorrenciasIndices;
    }

    //esse metodo retorna cada posição do indice da array doutores que o nome foi encontrado
    public ArrayList<Integer> indicesDoutorNome(String nome){
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
    public ArrayList<Integer> indicesDoutorEspecialidade(String especialidade){
        int indices;
        ArrayList<Integer> ocorrenciasIndices = new ArrayList<>();

        for(Doutor doutor : doutores){
            if (doutor.getEspecialidade().equals(especialidade)){
                indices = doutores.indexOf(doutor);
                ocorrenciasIndices.add(indices);
            }
        }

        return ocorrenciasIndices;
    }

    public ArrayList<Integer> indicesConsultasEspecialidade(String especialidade){
        int indices;
        ArrayList<Integer> ocorrenciasIndices = new ArrayList<>();

        for(Consulta consulta : consultas){
            if (consulta.getDoutor().getEspecialidade().equals(especialidade)){
                indices = consultas.indexOf(consulta);
                ocorrenciasIndices.add(indices);
            }
        }

        return ocorrenciasIndices;
    }

    public void exibirTodosDoutores(){
        int id;

        for (Doutor doutor : doutores) {
            id = doutores.indexOf(doutor);
            System.out.println("ID: " + id);
            doutor.print();
            System.out.println("--------------------------------");
        }
    }

    public void exibirTodosPacientes(){
        int id;

        for (Paciente paciente : pacientes) {
            id = pacientes.indexOf(paciente);
            System.out.println("ID: " + id);
            paciente.print();
            System.out.println("--------------------------------");
        }
    }

    public void exibirTodasConsultas(){
        int id;

        for (Consulta consulta : consultas){
            id = consultas.indexOf(consulta);
            System.out.println("ID: " + id);
            consulta.print();
            System.out.println("--------------------------------");
        }
    }

}
