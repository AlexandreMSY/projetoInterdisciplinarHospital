import Hospital.Hospital;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Hospital.Doutor;
import Hospital.Paciente;

public class Main {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        leia.useDelimiter("\\R"); //https://stackoverflow.com/questions/69680170/scanner-skipping-my-nextline-statement-in-constructor
        Hospital hospital = new Hospital();
        ArrayList<Paciente> listaPacientes = hospital.getPacientes();
        String escolha;
        String nome = null, cpf = null, dataNascimento, especialiade;
        int idade;

        do {
            System.out.println(
                    """
                    Sistema Hospital
                    1 - Adicionar Paciente
                    2 - Remover Paciente
                    3 - Pesquisar Paciente
                    4 - Exibir Pacientes
                    
                    Digite SAIR para Sair.
                    """);

            System.out.print("Escolha: ");
            escolha = leia.next().toUpperCase();

            switch (escolha){
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

                case "2":
                    int index = 0;
                    System.out.println("""
                            Remover Paciente
                            
                            1 - Pesquisar pelo nome
                            SAIR para voltar para o menu
                            """);

                    System.out.print("Escolha: ");
                    escolha = leia.next().toUpperCase();

                    if (escolha.equals("SAIR")){
                        System.out.println("Cancelado");
                    }else{
                        System.out.print("Nome: ");
                        nome = leia.next();

                        for(Paciente listaPaciente : listaPacientes) {
                            if (listaPaciente.getNome().equals(nome)) {
                                System.out.println("Encontrado: ");
                                listaPaciente.print();

                                index = listaPacientes.indexOf(listaPaciente);
                            }
                        }

                        System.out.println("Remover? S/N");
                        escolha = leia.next().toUpperCase();

                        if (escolha.equals("S")){
                            hospital.removerPaciente(index);
                        }
                    }
                    break;

                case "3":
                    System.out.println("""
                            Pesquisar Paciente
                            1 - Pesquisar pelo nome
                            2 - Pesquisar pelo CPF
                            Qualquer outro caractere para voltar para o menu""");

                    escolha = leia.next();

                    switch (escolha){
                        case "1":
                            System.out.print("Nome: ");
                            nome = leia.next();

                            for (Paciente listaPaciente : listaPacientes) {
                                if (listaPaciente.getNome().equals(nome)){
                                    System.out.println("Encontrado: ");
                                    listaPaciente.print();
                                }
                            }
                            break;

                        case "2":
                            System.out.println("CPF: ");
                            cpf = leia.next();

                            for (Paciente listaPaciente : listaPacientes) {
                                if (listaPaciente.getCpf().equals(cpf)){
                                    System.out.println("Encontrado");
                                    listaPaciente.print();
                                }
                            }
                            break;

                        default:
                    }
                    break;

                case "4":
                    hospital.exibirTodosPacientes();
                    break;
            }


        }while (!escolha.equals("SAIR"));
    }
}
