import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraSeguro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double valorSeguro = 0.0;
        
        try {
            System.out.print("Digite a idade do condutor: ");
            int idade = scanner.nextInt();

            if (idade < 18) {
                throw new IdadeInvalidaException("Idade do condutor inválida!");
            }

            System.out.print("Digite o valor do veículo: ");
            double valorVeiculo = scanner.nextDouble();

            if (valorVeiculo <= 0) {
                throw new IllegalArgumentException("Valor do veículo inválido!");
            }

            // Cálculo do seguro
            valorSeguro = valorVeiculo * 0.05;

            if (idade < 25) {
                valorSeguro += valorVeiculo * 0.02;
            }

            System.out.printf("Valor do seguro: R$ %.2f\n", valorSeguro);

        } catch (IdadeInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Digite apenas números.");
        } finally {
            System.out.println("Processo encerrado.");
            scanner.close();
        }
    }
}