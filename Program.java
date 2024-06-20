import exceptions.CustomErrorException;
import models.ContaBancaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        //Objetos para teste:
        List<ContaBancaria> contas = new ArrayList<>();
        contas.add(new ContaBancaria(1L, "Yago", "101.942.654-39", 1, 1000));
        contas.add(new ContaBancaria(2L, "Germana", "030.161.424-57", 1, 2500));
        //------------------------------------

        //Operacao:
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o seu cpf:" );
        String cpfDigitado = scanner.nextLine();

        // Encontrar a conta vinculada ao CPF digitado:
        Optional<ContaBancaria> contaLogada = contas.stream()
                .filter(conta -> conta.getCpf().equals(cpfDigitado))
                .findFirst();

        //Operacao:
        int operacao = 0;
        double valor = 0;
        if (contaLogada.isPresent()) {
            while (operacao != 4) {
                System.out.println("Escolha uma dentre as operações que queira realizar:");
                System.out.println("(1) Verificar dados da conta; (2) Depositar; (3) Sacar; (4) Sair");
                operacao = scanner.nextInt();

                switch (operacao){
                    case 1:
                        System.out.println(contaLogada.get());
                        break;
                    case 2:
                        System.out.println("Digite o valor que queira depositar: ");
                        valor = scanner.nextDouble();
                        try {
                            contaLogada.get().depositar(valor);
                            System.out.println("Valor depositado com sucesso.");
                        } catch (CustomErrorException message){
                            System.out.println("Erro: " + message.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("Digite o valor que queira sacar: ");
                        valor = scanner.nextDouble();
                        try {
                            contaLogada.get().sacar(valor);
                            System.out.println("Saque realizado com sucesso.");
                        } catch (CustomErrorException message) {
                            System.out.println("Erro: " + message.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println("Encerrando a aplicaçao.");
                        break;
                    default:
                        System.out.println("Opção de escolha inválida! Tente novamente.");
                }
            }
        } else {
            System.out.println("Conta não encontrada! Aplicação encerrada.");
        }







    }
}
