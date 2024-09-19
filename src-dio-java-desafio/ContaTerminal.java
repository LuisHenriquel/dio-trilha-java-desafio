import javax.print.DocFlavor;
import java.util.Scanner;


public class ContaTerminal {
    public static void main(String[] args) {
        int saldo = 0;
        String[] agencias = new String[3];

        //TODO:Conhecer e importar a classe Scanner
        Scanner scanner = new Scanner(System.in);
        while(true) {
         System.out.println("----------BEM-VINDO-AO-SISTEMA-DE-BANCO----------");
         System.out.println("Para criar uma conta seleciona [1]");
         System.out.println("Para acessar sua conta bancaria digite [2]");
         System.out.println("Para sair do sistema digite [3]");
         int opcao = scanner.nextInt();
        scanner.nextLine();

         switch (opcao) {
             case 1:
                 System.out.println("Digite seu nome completo");
                 String nome = scanner.nextLine();

                 System.out.println("Digite o número da agência");
                 String cadastro_agencia = scanner.next();


                 System.out.println("Olá " + nome + " obrigado por criar uma conta em nosso banco, sua agência é " + cadastro_agencia + " conta 1021 e seu saldo já está disponível para depositos e saque. ");
                 for (int i = 0; i < agencias.length; i++) {
                     if (agencias[i] == null) { // Procura uma posição vazia
                         agencias[i] = cadastro_agencia;
                         break;
                     }
                 }
                 break;
             case 2:
                 System.out.println("Digite o numero da agencia para entrar");
                 String numeroAgencia = scanner.nextLine();

                 boolean agenciaEncontrada = false;

                 // Verifica se a agência está no array
                 for (String a : agencias) {
                     if (numeroAgencia.equals(a)) {
                         agenciaEncontrada = true;
                         break;
                     }
                 }

                 if (agenciaEncontrada) {
                     System.out.println("Acesso permitido à sua conta na agência " + numeroAgencia);
                     System.out.println("Escolha a opção");
                     System.out.println("Para depositar digite [1]");
                     System.out.println("Para sacar digite [2]");
                     System.out.println("Para ver seu saldo digite [3]");

                     int escolhido = scanner.nextInt();
                     scanner.nextLine();
                     switch (escolhido){
                         case 1:
                             System.out.println("Você deseja depositar quanto ");
                             int deposito = scanner.nextInt();
                             scanner.nextLine();
                             saldo = saldo + deposito;
                             System.out.println("Seu deposito foi feito corretamente ");
                         break;
                         case 2:
                             System.out.println("Você deseja sacar quanto ");
                             int saque  = scanner.nextInt();
                             scanner.nextLine();
                             if(saque > 0 && saque <= saldo){
                                 System.out.println("Seu saque foi feito corretamente" );
                                 saldo -= saque;
                                 }
                             else if(saque > saldo){
                                 System.out.println("Você não pode sacar essa quantida, atualmente você tem " + saldo +"R$");

                             }
                             else {

                                 System.out.println("[ERRO] O valor do saque deve ser positivo.");
                             }
                         break;
                         case 3:
                             System.out.println("Você tem " + saldo +"R$ na sua conta bancaria" );
                 }
                 } else {
                     System.out.println("[ERRO] Agência não encontrada.");
                 }

                 break;
             case 3:
                 System.out.println("Saindo do sistema. Até logo!....");

                 return;

             default:
                 System.out.println("[ERRO] Selecione alguma opção");
         }

     }

    }

}