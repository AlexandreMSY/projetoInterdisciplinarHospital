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
        String escolha;
        String nome = null, cpf = null, dataNascimento, especialiade;
        int idade;
        int indice;

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
                    8 - Exibir Doutores (debug)
                    
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
                    System.out.println("""
                            Remover Paciente
                            
                            1 - Pesquisar pelo CPF
                            Qualquer outro caractere para voltar para o menu
                            """);

                    System.out.print("Escolha: ");
                    escolha = leia.next().toUpperCase();

                    if(escolha.equals("1")){
                        System.out.print("CPF: ");
                        cpf = leia.next();
                        indice = hospital.pesquisarPacienteCpf(cpf);

                        System.out.println("Encontrado: ");
                        hospital.getPacientes().get(indice).print();

                        System.out.print("Remover? S/N: ");
                        escolha = leia.next().toUpperCase();

                        if (escolha.equals("S")){
                            hospital.removerPaciente(indice);
                        }

                    }else {
                        System.out.println("Cancelado!");
                    }
                    break;

                //Pesquisar Paciente
                case "3":
                    System.out.println("""
                            Pesquisar Paciente
                            1 - Pesquisar pelo nome
                            2 - Pesquisar pelo CPF
                            Qualquer outro caractere para voltar para o menu
                            """);
                    System.out.print("Sua escolha: ");
                    escolha = leia.next();

                    if (escolha.equals("1")){
                        System.out.print("Nome: ");
                        nome = leia.next();
                        hospital.exibirPacientesComNome(nome);

                    } else if (escolha.equals("2")) {
                        System.out.println("CPF: ");
                        cpf = leia.next();
                        indice = hospital.pesquisarPacienteCpf(cpf);
                        hospital.getPacientes().get(indice).print();

                    } else {
                        System.out.println("Cancelado!");
                    }
                    break;

                //Editar Paciente
                case "4":
                    System.out.println("""
                            Editar Paciente
                            1 - Pesquisar pelo CPF
                            Qualquer outro caractere para voltar para o menu""");

                    System.out.print("Sua escolha: ");
                    escolha = leia.next();

                    if (escolha.equals("1")) {
                        System.out.println("CPF");
                        cpf = leia.next();
                        indice = hospital.pesquisarPacienteCpf(cpf);

                        System.out.println("Encontrado: ");
                        hospital.getPacientes().get(indice).print();

                        System.out.print("Deseja modificar? S/N: ");
                        escolha = leia.next().toUpperCase();

                        if(escolha.equals("S")){
                            System.out.println("Nome: ");
                            nome = leia.next();
                            System.out.println("Idade: ");
                            idade = leia.nextInt();
                            System.out.println("CPF: ");
                            cpf = leia.next();
                            System.out.println("Data nascimento: ");
                            dataNascimento = leia.next();

                            hospital.editarPaciente(
                                    indice,
                                    nome,
                                    idade,
                                    cpf,
                                    dataNascimento
                            );
                        }

                    } else{
                        System.out.println("Cancelado!");
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
                    ArrayList<Integer> doutoresEncontrados;
                    int indiceParaRemocao;
                    System.out.print("Nome: ");
                    nome = leia.next();

                    //esse metodo retorna cada posição do indice da array doutores que o nome foi encontrado
                    doutoresEncontrados = hospital.pesquisarDoutorNome(nome);
                    System.out.println(doutoresEncontrados);

                    //este loop printa todas as vezes que o nome foi encontrado
                    for(int doutorEncontrado : doutoresEncontrados){
                        indice = doutoresEncontrados.lastIndexOf(doutorEncontrado);
                        System.out.println("ID: " + indice);
                        hospital.getDoutores().get(indice).print();
                    }

                    System.out.print("ID para remover: ");
                    indiceParaRemocao = leia.nextInt();
                    indice = doutoresEncontrados.get(indiceParaRemocao);

                    hospital.getDoutores().get(indice).print();

                    System.out.print("Remover doutor? S/N: ");
                    escolha = leia.next().toUpperCase();

                    if(escolha.equals("S")){
                        hospital.getDoutores().remove(indice);
                    }else{
                        System.out.println("Cancelado");
                    }


                    break;

                    //Exibir Doutores (debug)
                case "8":
                    hospital.exibirTodosDoutores();
                    break;

            }
        }while (!escolha.equals("SAIR"));
    }
}
