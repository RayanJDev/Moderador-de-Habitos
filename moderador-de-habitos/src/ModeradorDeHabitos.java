import java.time.*;
import java.util.*;
import java.time.format.*;

public class ModeradorDeHabitos {

    public static void main(String[] args) {

        HashMap<String, Integer> habitos = new HashMap<>();

        Scanner in = new Scanner(System.in); // A variavel "in" pertecente a classe Scanner vai ser usada para receber valores via terminal
        // Obtém a data e hora atuais automaticamente
        LocalDate data = LocalDate.now(); // A variavel "data" pertencente a classe LocalDate vai definir o valor do dia atual sem a necessidade de inserir valores
        LocalTime hora = LocalTime.now();  // A variavel "hora" pertencente a classe LocalTime vai definir o valor do horario atual local sem a necessidade de inserir valores

        // Define o formato da saída no terminal
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //Define o formato da data em dia, mes e ano
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm"); //Define o formato da hora em horas e minutos, pode adicionar o segundos

        System.out.println("INICIO DE LOGIN ***");
        System.out.println(" ");
        System.out.print("INSIRA SEU NOME PARA INICIO DE CADASTRO: ");
        String nome = in.next();

        System.out.print("INSIRA SUA IDADE: ");
        int idade = in.nextInt();

        LocalDate dataNascimento = solicitarDataNascimento(in);

        System.out.println("_____________________________");
        System.out.println("*** INICIANDO MODERADOR DE ROTINA ***");
        System.out.println("Olá " + nome + ", seja bem vindo ao nosso aplicativo!");
        System.out.println("É um prazer te-ló conosco, estamos iniciando hoje em " + data.format(formatoData) + " às " + hora.format(formatoHora) + " do horario atual de Brasilia");
        System.out.println("Gostaria de iniciar as atividades?");
        String resposta = in.next();

        String Sim = "Sim";
        String Nao = "Não";

        if (resposta.equalsIgnoreCase(Sim)) {
            resposta = Sim;
            System.out.print("CARREGANDO MENU");
            try {
                for (int ponto = 0; ponto < 3; ponto++) {
                    Thread.sleep(1000); //Temporiza o tempo em que o Terminal imprime o conteúdo
                    System.out.print(".");
                    Thread.sleep(500);//Dá um tempo de 0,5 segundos a mais para que o MENU demore para aparecer
                }
                System.out.println(" ");
                System.out.println("TUDO PRONTO, PARA COMEÇAR!");
            }catch (InterruptedException e){
                System.out.println("ERRO NO CARREGAMENTO");
            }
            boolean rodando = true;
            while (rodando) {
                System.out.println("*** HOME MENU ***");
                System.out.println("1 - Registrar hábito");
                System.out.println("2 - Insira o hábito executado");
                System.out.println("3 - Exibir progresso");
                System.out.println("4 - Excluir hábito");
                System.out.println("5 - Sair");
                System.out.print("Escolha uma opção: ");

                int escolha = in.nextInt();
                in.nextLine();  // Limpa o buffer

                switch (escolha) {

                    case 1:   //Aqui se registra o nome do hábito
                        System.out.println("_____________________________");
                        System.out.print("Digite o nome do hábito: ");
                        String novoHabito = in.nextLine();
                        habitos.put(novoHabito, 0);
                        System.out.println("REGISTRO FEITO COM SUCESSO!");
                        break;

                    case 2:  //Aqui se insere o nome da atividade que foi feita
                        System.out.println("_____________________________");
                        System.out.print("Insira as atividades feitas: ");
                        String habito = in.nextLine();
                        if (habitos.containsKey(habito)) {
                            habitos.put(habito, habitos.get(habito) + 1);
                            System.out.println("Registro atualizado!");
                        } else {
                            System.out.println("Hábito não encontrado.");
                        }
                        break;

                    case 3: // Aqui é mostrado quantas vezes a atividade foi executada
                        System.out.println("_____________________________");
                        System.out.println("*** Progresso dos Hábitos ...");
                        for (String h : habitos.keySet()) {
                            System.out.println(h + ": " + habitos.get(h));
                        }
                        break;

                    case 4: // Nova opção para excluir um hábito
                        System.out.println("_____________________________");
                        System.out.print("Digite o nome do hábito a ser excluído: ");
                        String habitoExcluir = in.nextLine();
                        if (habitos.containsKey(habitoExcluir)) {
                            habitos.remove(habitoExcluir);
                            System.out.println("Hábito removido com sucesso.");
                        } else {
                            System.out.println("Hábito não encontrado.");
                        }
                        break;

                    case 5:
                        rodando = false;
                        System.out.println("_____________________________");
                        System.out.print("FINALIZANDO TAREFAS ");
                        try {
                            for (int ponto = 0; ponto < 3; ponto++) {
                                Thread.sleep(1000); //Temporiza o tempo em que o Terminal imprime o conteúdo
                                System.out.print(".");
                                Thread.sleep(500);//Dá um tempo de 0,5 segundos a mais para que o MENU demore para aparecer
                            }
                            System.out.println(" ");
                            System.out.println("ATÉ A PROXIMA!!!");
                        } catch (InterruptedException e) {
                            System.out.println("Exception");
                        }
                        break;

                    default:
                        System.out.println("_____________________________");
                        System.out.println("OPÇÃO INVALIDA");
                }
            }

        } else if (resposta.equalsIgnoreCase(Nao)){
            resposta = Nao;
            System.out.println("_____________________________");
            System.out.print("FINALIZANDO TAREFAS ");

            try {
                for (int ponto = 0; ponto < 3; ponto++) {
                    Thread.sleep(1000); //Temporiza o tempo em que o console imprime o conteúdo
                    System.out.print(".");
                    Thread.sleep(500);//Dá um tempo de 0,5 segundos a mais para que o MENU demore para aparecer
                }
                System.out.println(" ");
                System.out.println("ATÉ A PROXIMA!!!");
            }catch (InterruptedException e){
                System.out.println("ERRO NA FINALIZAÇÃO");
            }


        }
        in.close();
    }
    public static LocalDate solicitarDataNascimento(Scanner scanner) {
        // Define o formato esperado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = null;
        // CORREÇÃO 1: Inicializar a variável como false para que o loop comece
        boolean inputValido = false;

        // O loop continua ENQUANTO inputValido for FALSE (!inputValido)
        while (!inputValido) {
            String inputUsuario = scanner.nextLine();

            // CORREÇÃO 2: Usar try-catch para validar a data real
            try {
                // Tenta converter a string para um objeto LocalDate usando o formato definido
                data = LocalDate.parse(inputUsuario, formatter);
                inputValido = true; // Se chegou aqui, o formato e a data são válidos (SUCESSO)

            } catch (DateTimeParseException e) {
                // Se a conversão falhou, a exceção DateTimeParseException é lançada.
                // inputValido já é false (ERRO)
                System.out.println("INSIRA SUA DATA DE NASCIMENTO: Use dd/mm/AAAA (ex: 25/12/1990)");
                // O loop continua automaticamente
            }

            // Note que o bloco 'if(!inputValido)' e o 'else' que você tinha foram removidos,
            // pois o try-catch faz esse trabalho de forma mais eficiente.
        }
        return data;
    }
}


