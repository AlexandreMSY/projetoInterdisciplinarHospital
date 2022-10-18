import java.util.ArrayList;
import java.util.Scanner;

import Hospital.Doutor;
import Hospital.Paciente;
import Hospital.Hospital;

public class Main {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        leia.useDelimiter("\\R"); //https://stackoverflow.com/questions/69680170/scanner-skipping-my-nextline-statement-in-constructor
        Hospital hospital = new Hospital();
        String escolha, opcao;
        String nome, cpf, dataNascimento, especialiade;
        int idade;
        int indice, id;
        ArrayList<Integer> doutoresEncontrados;

        do {
            System.out.println(
                    """
                    
                    Sistema Hospital
                    1 - Adicionar Paciente
                    2 - Remover Paciente
                    3 - Pesquisar Paciente
                    4 - Editar Paciente
                    5 - Exibir Pacientes
                    6 - Adicionar Doutor
                    7 - Remover Doutor
                    8 - Pesquisar Doutor
                    9 - Editar Doutor
                    
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
                    dataNascimento = leia.next();

                    Paciente paciente = new Paciente(
                            nome,
                            idade,
                            cpf,
                            dataNascimento
                    );

                    hospital.adicionarPaciente(paciente);

                    break;

                //Remover Paciente
                case "2":
                    System.out.println("Remover Paciente");

                    System.out.print("CPF: ");
                    cpf = leia.next();
                    indice = hospital.pesquisarPacienteCpf(cpf);

                    System.out.println("Encontrado: ");
                    hospital.getPacientes().get(indice).print();

                    System.out.print("Remover? S/N: ");
                    opcao = leia.next().toUpperCase();

                    if (opcao.equals("S")){
                        hospital.removerPaciente(indice);
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
                        hospital.exibirPacientesComNome(nome);

                    } else if (opcao.equals("B")) {
                        System.out.print("CPF: ");
                        cpf = leia.next();
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
                    indice = hospital.pesquisarPacienteCpf(cpf); //retorna a posição do cpf encontrado na lista paciente, o cpf no cadastro deve ser UNICO

                    System.out.println("Encontrado: ");
                    hospital.getPacientes().get(indice).print();

                    System.out.print("Deseja modificar? S/N: ");
                    opcao = leia.next().toUpperCase();

                    if(opcao.equals("S")){
                        System.out.print("Nome: ");
                        nome = leia.next();
                        System.out.print("Idade: ");
                        idade = leia.nextInt();
                        System.out.print("CPF: ");
                        cpf = leia.next();
                        System.out.print("Data nascimento: ");
                        dataNascimento = leia.next();

                        hospital.editarPaciente(
                                indice,
                                nome,
                                idade,
                                cpf,
                                dataNascimento
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
                    break;

                    //Remover Doutor
                case "7":
                    int indiceParaRemocao;

                    System.out.print("Nome: ");
                    nome = leia.next();

                    //esse metodo retorna cada posição do indice da array doutores que o nome foi encontrado
                    doutoresEncontrados = hospital.pesquisarDoutorNome(nome);

                    hospital.exibirDoutoresComNome(nome);

                    System.out.print("ID para remover: ");
                    indiceParaRemocao = leia.nextInt();
                    indice = doutoresEncontrados.indexOf(indiceParaRemocao);

                    hospital.getDoutores().get(indice).print();

                    System.out.print("Remover doutor? S/N: ");
                    opcao = leia.next().toUpperCase();

                    if(opcao.equals("S")){
                        hospital.getDoutores().remove(indice);
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

                        doutoresEncontrados = hospital.pesquisarDoutorNome(nome);

                        System.out.println("Encontrados: ");
                        for(Integer doutorEncontrado : doutoresEncontrados){
                            id = doutorEncontrado;
                            System.out.println("ID: " + id);
                            hospital.getDoutores().get(doutorEncontrado).print();
                        }

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
                    } /*else if (escolha.equals("B")) {
                        System.out.print("Especialidade: ");
                        especialiade = leia.next();

                    } */
                    else {
                        System.out.println("Cancelado");
                    }
                    break;
            }
        }while (!escolha.equals("SAIR"));
    }
}
