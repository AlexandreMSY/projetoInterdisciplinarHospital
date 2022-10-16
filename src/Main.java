import Hospital.Hospital;

import java.util.ArrayList;
import java.util.Scanner;

import Hospital.Doutor;
import Hospital.Paciente;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        leia.useDelimiter("\\R");
        Hospital hospital = new Hospital();
        String escolha;
        String nome, cpf, dataNascimento, especialiade;
        int idade;

        do {
            System.out.println(
                    """
                    1 - Adicionar Paciente
                    2 - Remover Paciente
                    3 - Pesquisar Paciente
                    4 - Exibir Pacientes
                    
                    Digite Sair para Sair.
                    """);

            System.out.print("Escolha: ");
            escolha = leia.next();

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
                    break;

                case "3":
                    int tamanhoLista = hospital.getPacientes().size();
                    ArrayList<Paciente> listaPacientes = hospital.getPacientes();

                    System.out.print("Nome: ");
                    nome = leia.next();

                    for (Paciente listaPaciente : listaPacientes) {
                        if (listaPaciente.getNome().equals(nome)){
                            listaPaciente.print();
                        }
                    }

                    break;

                case "4":
                    hospital.exibirTodosPacientes();
                    break;
            }


        }while (escolha != "Sair");
    }
}
