import java.util.ArrayList;
import java.util.Scanner;

import Hospital.Doutor;
import Hospital.Paciente;
import Hospital.Hospital;
import Hospital.Consulta;

public class Main {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        leia.useDelimiter("\\R"); //https://stackoverflow.com/questions/69680170/scanner-skipping-my-nextline-statement-in-constructor
        Hospital hospital = new Hospital();
        String escolha, opcao;
        String nome, cpf, data, especialiade;
        int quantidadePacientes, quantidadeDoutores;
        int idade;
        int indice, id, indicePaciente, indiceDoutor;
        ArrayList<Integer> doutoresEncontrados, pacientesEncontrados, consultasEncontradas;

        do {
            quantidadePacientes = hospital.getPacientes().size();
            quantidadeDoutores = hospital.getDoutores().size();

            System.out.println(
                    """
                    
                    Sistema Hospital
                    1 - Adicionar Paciente
                    2 - Remover Paciente
                    3 - Pesquisar Paciente
                    4 - Editar Paciente
                    5 - Exibir Pacientes Cadastrados
                    6 - Adicionar Doutor
                    7 - Remover Doutor
                    8 - Pesquisar Doutor
                    9 - Editar Doutor
                    10 - Exibir Doutores Cadastrados
                    11 - Adicionar Consulta
                    12 - Remover Consulta
                    13 - Pesquisar Consulta
                    14 - Editar Consulta
                    15 - Exibir consultas
                    
                    
                    
                    Digite SAIR para Sair.
                    """);

            System.out.print("Escolha: ");
            escolha = leia.next().toUpperCase();

            switch (escolha){
                //Adicionar Paciente
                case "1":
                    System.out.print("Nome: ");
                    nome = leia.next();
                    System.out.print("Idade: ");
                    idade = leia.nextInt();
                    System.out.print("CPF: ");
                    cpf = leia.next();
                    System.out.print("Data Nascimento: ");
                    data = leia.next();

                    Paciente paciente = new Paciente(
                            nome,
                            idade,
                            cpf,
                            data
                    );

                    hospital.adicionarPaciente(paciente);

                    break;

                //Remover Paciente
                case "2":
                    System.out.println("Remover Paciente");

                    System.out.print("CPF: ");
                    cpf = leia.next();

                    pacientesEncontrados = hospital.indicesPacientesCpf(cpf);

                    System.out.println("Encontrado: ");
                    hospital.exibirPacientesComCpf(cpf);

                    System.out.print("ID para remover: ");
                    indice = leia.nextInt(); //o "id" é nada mais do que a posição do elemento na lista pacientes

                    if (pacientesEncontrados.contains(indice)){
                        System.out.print("Deseja realmente remover? S/N: ");
                        opcao = leia.next().toUpperCase();

                        if(opcao.equals("S")){
                            hospital.removerPaciente(indice);
                            System.out.println("Removido!");
                        }else{
                            System.out.println("Cancelado!");
                        }

                    }else{
                        System.out.println("Invalido");
                    }

                    break;

                //Pesquisar Paciente
                case "3":
                    System.out.println("""
                            
                            Pesquisar Paciente
                            A - Pesquisar pelo nome
                            B - Pesquisar pelo CPF
                            
                            Qualquer outro caractere para voltar para o menu
                            """);
                    System.out.print("Sua escolha: ");
                    opcao = leia.next().toUpperCase();

                    if (opcao.equals("A")){
                        System.out.print("Nome: ");
                        nome = leia.next();
                        System.out.println("Encontrados: ");
                        hospital.exibirPacientesComNome(nome);

                    } else if (opcao.equals("B")) {
                        System.out.print("CPF: ");
                        cpf = leia.next();
                        System.out.println("Encontrado: ");
                        hospital.exibirPacientesComCpf(cpf);

                    } else {
                        System.out.println("Cancelado!");
                    }

                    break;

                //Editar Paciente
                case "4":
                    System.out.println("Editar Paciente");
                    System.out.print("CPF: ");
                    cpf = leia.next();

                    pacientesEncontrados = hospital.indicesPacientesCpf(cpf);

                    System.out.println("Encontrado: ");
                    hospital.exibirPacientesComCpf(cpf);
                    indice = pacientesEncontrados.get(0); //a lista pacientes encontrados deve conter apenas um elemento, pois CPFs são unicos

                    System.out.print("Deseja editar? S/N: ");
                    opcao = leia.next().toUpperCase();

                    if(opcao.equals("S")){
                        System.out.print("Nome: ");
                        nome = leia.next();
                        System.out.print("Idade: ");
                        idade = leia.nextInt();
                        System.out.print("CPF: ");
                        cpf = leia.next();
                        System.out.print("Data nascimento: ");
                        data = leia.next();

                        hospital.editarPaciente(
                                indice,
                                nome,
                                idade,
                                cpf,
                                data
                        );
                    }

                    break;

                    //Exibir Pacientes
                case "5":
                    hospital.exibirTodosPacientes();
                    break;

                    //Adicionar Doutor
                case "6":
                    System.out.print("Nome: ");
                    nome = leia.next();
                    System.out.print("Especialidade: ");
                    especialiade = leia.next();

                    Doutor doutor = new Doutor(
                            nome,
                            especialiade
                    );

                    hospital.adicionarDoutor(doutor);
                    System.out.println("Adicionado!");
                    break;

                    //Remover Doutor
                case "7":
                    int indiceParaRemocao;

                    System.out.print("Nome: ");
                    nome = leia.next();

                    //esse metodo retorna cada posição do indice da array doutores que o nome foi encontrado
                    doutoresEncontrados = hospital.indicesDoutorNome(nome);

                    hospital.exibirDoutoresComNome(nome);

                    System.out.print("ID para remover: ");
                    indiceParaRemocao = leia.nextInt();
                    indice = doutoresEncontrados.indexOf(indiceParaRemocao);

                    hospital.exibirDoutoresComNome(nome);

                    System.out.print("Remover doutor? S/N: ");
                    opcao = leia.next().toUpperCase();

                    if(opcao.equals("S")){
                        hospital.removerDoutor(indice);
                    }else{
                        System.out.println("Cancelado");
                    }

                    break;

                    //Pesquisar Doutores
                case "8":
                    System.out.println("""
                            A - Pesquisar por Nome
                            B - Pesquisar por Especialidade
                            
                            Qualquer outro caractere para sair
                            """);

                    System.out.print("Sua escolha: ");
                    opcao = leia.next().toUpperCase();

                    if (opcao.equals("A")){
                        System.out.print("Nome: ");
                        nome = leia.next();

                        hospital.exibirDoutoresComNome(nome);
                    } else if (opcao.equals("B")){
                        System.out.print("Especialidade: ");
                        especialiade = leia.next();

                        hospital.exibirDoutoresComEspecialidade(especialiade);
                    }else {
                        System.out.println("Cancelado");
                    }

                    break;

                    //editar doutores
                case "9":
                    int idParaRemocao;

                    System.out.println("""
                            A - Pesquisar por Nome
                            B - Pesquisar por Especialidade
                            
                            Qualquer outro caractere para sair
                            """);

                    System.out.print("Sua escolha: ");
                    opcao = leia.next().toUpperCase();

                    if (opcao.equals("A")){
                        System.out.print("Nome: ");
                        nome = leia.next();

                        //esse metodo retorna cada posição do indice da array doutores que a especialidade foi encontrado
                        doutoresEncontrados = hospital.indicesDoutorNome(nome);

                        System.out.println("Encontrados: ");
                        hospital.exibirDoutoresComNome(nome);

                        System.out.print("ID para remoção: ");
                        idParaRemocao = leia.nextInt();
                        indice = doutoresEncontrados.indexOf(idParaRemocao);

                        hospital.getDoutores().get(indice).print();
                        System.out.print("Editar esse doutor? S/N: ");
                        escolha = leia.next().toUpperCase();

                        if(escolha.equals("S")){
                            System.out.print("Nome: ");
                            nome = leia.next();
                            System.out.print("Especialidade: ");
                            especialiade = leia.next();

                            hospital.editarDoutor(indice, nome, especialiade);
                        }
                    } else if (opcao.equals("B")) {
                        System.out.print("Especialidade: ");
                        especialiade = leia.next();

                        doutoresEncontrados = hospital.indicesDoutorEspecialidade(especialiade);

                        System.out.println("Encontrados: ");
                        hospital.exibirDoutoresComEspecialidade(especialiade);

                        System.out.print("ID para remoção: ");
                        idParaRemocao = leia.nextInt();
                        indice = doutoresEncontrados.indexOf(idParaRemocao);
                        System.out.println(indice);

                        hospital.getDoutores().get(indice).print();
                        System.out.print("Editar esse doutor? S/N: ");
                        escolha = leia.next().toUpperCase();

                        if(escolha.equals("S")){
                            System.out.print("Nome: ");
                            nome = leia.next();
                            System.out.print("Especialidade: ");
                            especialiade = leia.next();

                            hospital.editarDoutor(indice, nome, especialiade);
                        }


                    } else {
                        System.out.println("Cancelado");
                    }
                    break;

                    //exibir todos os doutores
                case "10":
                    hospital.exibirTodosDoutores();
                    break;

                    //adicionar consulta
                case "11":
                    if (quantidadeDoutores == 0){
                        System.out.println("Não há doutores!");
                    } else if (quantidadePacientes == 0){
                        System.out.println("Não há pacientes!");
                    } else {
                        System.out.println("Escolher Paciente");
                        System.out.print("CPF do Paciente: ");
                        cpf = leia.next();

                        indicePaciente = hospital.indicesPacientesCpf(cpf).get(0);

                        System.out.println("Adicionado: ");
                        hospital.exibirPacientesComCpf(cpf);

                        System.out.println("Escolher doutor: ");
                        System.out.print("Especialidade: ");
                        especialiade = leia.next();

                        doutoresEncontrados = hospital.indicesDoutorEspecialidade(especialiade);

                        hospital.exibirDoutoresComEspecialidade(especialiade);

                        System.out.print("ID do doutor: ");
                        id = leia.nextInt();

                        indiceDoutor = doutoresEncontrados.indexOf(id);

                        System.out.println("Data para consulta: ");
                        data = leia.next();

                        paciente = hospital.getPacientes().get(indicePaciente);
                        doutor = hospital.getDoutores().get(indiceDoutor);

                        Consulta consulta = new Consulta(
                                paciente,
                                doutor,
                                data
                        );

                        hospital.adicionarConsulta(consulta);
                    }
                    break;
                    //remover consulta
                case "12":
                    System.out.print("Especialidade: ");
                    especialiade = leia.next();

                    consultasEncontradas = hospital.indicesConsultasEspecialidade(especialiade);

                    System.out.println("Encontrados: ");
                    hospital.exibirConsultasComEspecialidade(especialiade);

                    System.out.print("ID para remover: ");
                    id = leia.nextInt();

                    if(consultasEncontradas.contains(id)){
                        hospital.getConsultas().get(id).print();
                        System.out.print("Remover S/N: ");
                        opcao = leia.next().toUpperCase();

                        if(opcao.equals("S")){
                            indice = consultasEncontradas.get(id);
                            hospital.removerConsulta(indice);

                            System.out.println("Removido!");
                        }else{
                            System.out.println("Cancelado");
                        }
                    }else{
                        System.out.println("ID não encontrado!");
                    }
                    break;
                    //pesquisar consulta
                case "13":
                    System.out.println("""
                            
                            Pesquisar Consulta
                            
                            A - Pesquisar por nome do Paciente
                            B - Pesquisar por nome do Doutor
                            C - Pesquisar por especialidade do Doutor
                            
                            Qualquer outro caractere para voltar ao menu
                            """);

                    System.out.print("Escolha: ");
                    escolha = leia.next().toUpperCase();

                    if (escolha.equals("A")){
                        System.out.print("Nome do paciente: ");
                        nome = leia.next();

                        hospital.exibirConsultasComNomeDoPaciente(nome);
                    } else if (escolha.equals("B")) {
                        System.out.print("Nome do doutor: ");
                        nome = leia.next();

                        hospital.exibirConsultasComNomeDoDoutor(nome);
                    } else if (escolha.equals("C")) {
                        System.out.print("Especialidade do Doutor: ");
                        especialiade = leia.next();

                        hospital.exibirConsultasComEspecialidade(especialiade);
                    }else{
                        System.out.println("Cancelado! ");
                    }
                    break;

                    //editar consulta
                case "14":
                    int idConsulta;

                    System.out.print("Especialidade: ");
                    especialiade = leia.next();

                    consultasEncontradas = hospital.indicesConsultasEspecialidade(especialiade);

                    System.out.println("Encontrados: ");
                    hospital.exibirConsultasComEspecialidade(especialiade);

                    System.out.print("ID para editar: ");
                    idConsulta = leia.nextInt();

                    if (consultasEncontradas.contains(idConsulta)){
                        System.out.print("Especialidade do Doutor: ");
                        especialiade = leia.next();

                        hospital.exibirDoutoresComEspecialidade(especialiade);
                        System.out.print("ID para adicionar: ");
                        indiceDoutor = leia.nextInt();

                        doutor = hospital.getDoutores().get(indiceDoutor);

                        System.out.println("CPF do Paciente: ");
                        cpf = leia.next();

                        System.out.println("Adicionado: ");
                        hospital.exibirPacientesComCpf(cpf);

                        indicePaciente = hospital.indicesPacientesCpf(cpf).get(0);
                        paciente = hospital.getPacientes().get(indicePaciente);

                        System.out.print("Data para consulta: ");
                        data = leia.next();

                        hospital.editarColsulta(
                                idConsulta,
                                paciente,
                                doutor,
                                data
                        );
                    }else{
                        System.out.println("Consulta não encontrada!");
                    }
                    //exibir consultas
                case "15":
                    hospital.exibirTodasConsultas();
                    break;
            }
        }while (!escolha.equals("SAIR"));
    }
}
