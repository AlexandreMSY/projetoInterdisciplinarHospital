import Hospital.Hospital;

import java.util.Scanner;

import Hospital.Paciente;

public class Main {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        leia.useDelimiter("\\R"); //https://stackoverflow.com/questions/69680170/scanner-skipping-my-nextline-statement-in-constructor
        Hospital hospital = new Hospital();
        String escolha;
        String nome = null, cpf = null, dataNascimento, especialiade;
        int idade;
        int index;

        do {
            System.out.println(
                    """
                    Sistema Hospital
                    1 - Adicionar Paciente
                    2 - Remover Paciente
                    3 - Pesquisar Paciente
                    4 - Editar Paciente
                    5 - Exibir Pacientes
                    
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
                        index = hospital.pesquisarPacienteCpf(cpf);

                        System.out.println("Encontrado: ");
                        hospital.getPacientes().get(index).print();

                        System.out.print("Remover? S/N: ");
                        escolha = leia.next().toUpperCase();

                        if (escolha.equals("S")){
                            hospital.removerPaciente(index);
                        }

                    }else {
                        System.out.println("Cancelado!");
                    }
                    break;

                case "3":
                    System.out.println("""
                            Pesquisar Paciente
                            1 - Pesquisar pelo nome
                            2 - Pesquisar pelo CPF
                            Qualquer outro caractere para voltar para o menu
                            """);

                    escolha = leia.next();

                    if (escolha.equals("1")){
                        System.out.print("Nome: ");
                        nome = leia.next();
                        hospital.exibirPacientesComNome(nome);

                    } else if (escolha.equals("2")) {
                        System.out.println("CPF: ");
                        cpf = leia.next();
                        index = hospital.pesquisarPacienteCpf(cpf);
                        hospital.getPacientes().get(index).print();

                    } else {
                        System.out.println("Cancelado!");
                    }

                case "4":
                    System.out.println("""
                            Editar Paciente
                            1 - Pesquisar pelo CPF
                            Qualquer outro caractere para voltar para o menu""");

                    escolha = leia.next();

                    if (escolha.equals("1")) {
                        cpf = leia.next();
                        index = hospital.pesquisarPacienteCpf(cpf);

                        System.out.println("Encontrado: ");
                        hospital.getPacientes().get(index).print();

                        System.out.print("Deseja modificar? S/N: ");
                        escolha = leia.next().toUpperCase();

                        if(escolha.equals("S")){
                            hospital.getPacientes().get(index);
                        }

                    } else{
                        System.out.println("Cancelado!");
                    }

                case "5":
                    hospital.exibirTodosPacientes();
                    break;
            }
        }while (!escolha.equals("SAIR"));
    }
}
