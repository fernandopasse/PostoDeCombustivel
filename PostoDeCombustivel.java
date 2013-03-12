package trabalho;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Fernando e Felipe
 */
public class PostoDeCombustivel {

    public static Vector<BombaCombustivel> bombas = new Vector<>(10);
    public static Vector<Vendas> dados = new Vector<>(10, 10);
    public static Vector<ClientePostoCartao> clientes = new Vector<>(10, 10);
    private static final Locale loc = new Locale("pt", "BR");
    private static NumberFormat valor = NumberFormat.getCurrencyInstance(loc);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte opcao = 0;
        boolean repete = true;
        while (true) {
            System.out.println("-------------Posto de Combustivel-----------");
            System.out.println("1 - Cadastrar bomba");
            System.out.println("2 - Consultar bombas ativas / ativar, desativar e excluir");
            System.out.println("3 - Consultar Cliente");
            System.out.println("4 - Consultar Vendas");
            System.out.println("5 - Abastecer");
            System.out.println("6 - Sair");
            System.out.println("--------------------------------------------");
            System.out.println("Digite o número da opções desejada:");
            while (repete) {
                try {
                    while (repete) {
                        opcao = sc.nextByte();
                        if (opcao > 0 && opcao < 7) {
                            repete = false;
                        } else {
                            System.out.println("Opção inválida");
                            System.out.println("Digite novamente: ");
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Opção inválida");
                    System.out.println("Digite novamente:");
                    sc.nextLine();
                }
            }
            repete = true; // retorno de menu com validação
            switch (opcao) {
                case 1:
                    cadastrarBomba();
                    break;
                case 2:
                    consultarBomba();
                    break;
                case 3:
                    consultarClientes();
                    break;
                case 4:
                    consultarVendas();
                    break;
                case 5:
                    abastecer();
                    break;
                case 6:
                    System.exit(1);
                    break;
            }
        }
    }

    public static void cadastrarBomba() {
        Scanner sc = new Scanner(System.in);
        int numeroDoLacre = 0;
        byte tipo = 0;
        boolean repete = true;
        //double quantidadeDeCombustivel = 0;
        double valorDoLitro = 0;
        String bandeira;
        if (bombas.size() < 9) {
            System.out.println("------ Cadastro de Bomba -----");
            System.out.println("Digite o número do lacre:");
            while (repete) {
                try {
                    numeroDoLacre = sc.nextInt();
                    repete = false;
                } catch (InputMismatchException e) {
                    System.out.println("Número inválido:");
                    System.out.println("Digite novamente:");
                    sc.nextLine();
                }
            }
            repete = true; //Prepara "repete" para validar próxima opção
            System.out.println("-----Tipo de Combustível-----");
            System.out.println("1- Gasolina");
            System.out.println("2- Álcool");
            System.out.println("3- Óleo diesel");
            System.out.println("-----------------------------");
            System.out.println("Digite o número da opção:");
            while (repete) {
                try {
                    while (repete) {
                        tipo = sc.nextByte();
                        if (tipo > 0 && tipo < 4) {
                            repete = false;
                        } else {
                            System.out.println("Opção inválida");
                            System.out.println("Digite novamente: ");
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Opção inválida");
                    System.out.println("Digite novamente:");
                    sc.nextLine();
                }
            }
            /*
             * repete = true; //Para nova validação
             * System.out.println("Quantidade de combustivel inicial:"); while
             * (repete) { try { quantidadeDeCombustivel = sc.nextDouble();
             * repete = false; } catch (InputMismatchException e) {
             * System.out.println("Quantidade combustivel não é valida.");
             * System.out.println("Digite novamente:"); sc.nextLine(); } }
             */
            repete = true; //Para nova validação
            System.out.println("Valor do litro:");
            while (repete) {
                try {
                    valorDoLitro = sc.nextDouble();
                    repete = false;
                } catch (InputMismatchException e) {
                    System.out.println("Valor do litro não é valido.");
                    System.out.println("Digite novamente:");
                    sc.nextLine();
                }
            }
            System.out.println("Bandeira:");
            bandeira = sc.next();
            BombaCombustivel bc = new BombaCombustivel(numeroDoLacre, valorDoLitro, bandeira, tipo);
            bombas.add(bc);
            System.out.println("Bomba cadastrada com sucesso!");
            System.out.println("Número do lacre: " + numeroDoLacre);
            System.out.print("Tipo de Combustivel: ");
            switch (tipo) {
                case 1:
                    System.out.print("Gasolina");
                    break;
                case 2:
                    System.out.print("Álcool");
                    break;
                case 3:
                    System.out.print("Óleo diesel");
                    break;
            }
            System.out.println("\nValor do litro: " + valorDoLitro);
            System.out.println("Bandeira: " + bandeira);
        } else {
            System.out.println("O máximo de bombas permitidas já foi cadastrado!");
        }

    }

    public static void consultarBomba() {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        boolean repete = true;
        int bomba;
        if (bombas.isEmpty()) {
                System.out.println("Nenhuma bomba ativa");
                return;
        }
        for (int i = 0; i < bombas.size(); i++) {
            System.out.println("Bomba " + (i + 1) + " - " + bombas.get(i).getTipo() + ": " + ((bombas.get(i).getStatus() == true) ? "Ativa" : "Inativa"));
            System.out.println("Digite o número da bomba que deseja modificar:");
            while (repete) {
                try {
                    while (repete) {
                        opcao = sc.nextByte();
                        if (opcao > 0 && opcao <= (bombas.size() + 1)) {
                            repete = false;
                        } else {
                            System.out.println("Opção inválida");
                            System.out.println("Digite novamente: ");
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Opção inválida");
                    System.out.println("Digite novamente:");
                    sc.nextLine();
                }
            }
            bomba = opcao - 1;
            repete = true;
            System.out.println("--------- Ativa e desativar bomba -----------");
            System.out.println("1- Ativar. A bomba inativa/ativa é reabastecida");
            System.out.println("2- Desativar");
            System.out.println("3- Excluir");
            System.out.println("-----------------------------------------");
            System.out.println("Digite o número da opção desejada: ");
            while (repete) {
                try {
                    while (repete) {
                        opcao = sc.nextByte();
                        if (opcao > 0 && opcao < 4) {
                            repete = false;
                        } else {
                            System.out.println("Opção inválida");
                            System.out.println("Digite novamente: ");
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Opção inválida");
                    System.out.println("Digite novamente:");
                    sc.nextLine();
                }
            }
            switch (opcao) {
                case 1:
                    System.out.println("Bomba " + (bomba + 1) + " foi ativada.");
                    bombas.get(bomba).setStatus(true);
                    break;
                case 2:
                    System.out.println("Bomba " + (bomba + 1) + " foi desativada.");
                    bombas.get(bomba).setStatus(false);
                    break;
                case 3:
                    bombas.get(bomba).setLimita(BombaCombustivel.limita - 1);
                    bombas.remove(bomba);
                    break;
            }
        }
    }

    public static void pagamentoCartaoDinheiro(double valor) {
        Scanner sc = new Scanner(System.in);
        boolean repete = true;
        byte opcao = 0;
        double dinheiro;
        double valorTroco;
        String nome;
        long cpf = 0;
        String testacpf;
        int cartao = 0;
        ClientePostoCartao cpc;
        System.out.println("---------Escolha a forma de pagamento-----------");
        System.out.println("1- Dinheiro");
        System.out.println("2- Cartão");
        System.out.println("-----------------------------------------");
        System.out.println("Digite o número da opção desejada: ");
        while (repete) {
            try {
                while (repete) {
                    opcao = sc.nextByte();
                    if (opcao > 0 && opcao < 3) {
                        repete = false;
                    } else {
                        System.out.println("Opção inválida");
                        System.out.println("Digite novamente: ");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida");
                System.out.println("Digite novamente:");
                sc.nextLine();
            }
        }
        repete = true; // Torna o repete true para nova validação
        switch (opcao) {
            case 1:
                System.out.println("Digite o valor recebido:");
                dinheiro = sc.nextDouble();
                interrompe:
                while (true) {
                    if (dinheiro < valor) {
                        System.out.println("Este valor não supre o total a ser pago!");
                        System.out.println("Complemente o valor:");
                        while (repete) {
                            try {
                                dinheiro = sc.nextDouble();
                                repete = false;
                            } catch (InputMismatchException e) {
                                System.out.println("Valor digitado não é valido.");
                                System.out.println("Digite novamente:");
                                sc.nextLine();
                            }
                        }
                    } else {
                        break interrompe;
                    }
                }
                if (dinheiro > valor) {
                    valorTroco = dinheiro - valor;
                    System.out.println("O valor do troco a ser devolvido é:" + valorTroco);
                }
                break;
            case 2:
                System.out.println("Digite o nome do cliente:"); //Registrando o cliente
                nome = sc.next();
                System.out.println("Digite o número do CPF:");
                do {
                    testacpf = sc.next();
                    if (!ValidaCPF.isCPF(testacpf)) {
                        System.out.println("Número de CPF não é válido.");
                        System.out.println("Digite novamente:");
                    }
                } while (!(ValidaCPF.isCPF(testacpf)));
                cpf = Long.parseLong(testacpf);
                System.out.println("Digite o número do cartão:");
                while (repete) {
                    try {
                        cartao = sc.nextInt();
                        repete = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Número de cartão não é valido.");
                        System.out.println("Digite novamente:");
                        sc.nextLine();
                    }
                }
                cpc = new ClientePostoCartao(nome, cpf, cartao); //Cria um objeto para o cliente
                clientes.add(cpc);  // Adiciona o cliente ao vetor
                break;
        }

    }

    public static void iniciaAbastecimento(int indexBomba) {
        Scanner sc = new Scanner(System.in);
        byte opcao = 0;
        Vendas rd;
        double valorLitro = 0;
        double valorReais = 0;
        double valorTotal;
        boolean repete = true;

        System.out.println("---------Escolha a forma de abastecimento-----------");
        System.out.println("1- Valor em Litros");
        System.out.println("2- Valor em dinheiro");
        System.out.println("-----------------------------------------");
        System.out.println("Digite o número da opção desejada: ");
        while (repete) {
                try {
                    while (repete) {
                        opcao = sc.nextByte();
                        if (opcao > 0 && opcao < 3) {
                            repete = false;
                        } else {
                            System.out.println("Opção inválida");
                            System.out.println("Digite novamente: ");
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Opção inválida");
                    System.out.println("Digite novamente:");
                    sc.nextLine();
                }
        }
        repete = true;
        switch (opcao) {
            case 1:
                System.out.println("Digite a quantidade em litros: ");
                while (repete) {
                    while (repete) {
                        try {
                            valorLitro = sc.nextDouble();
                            repete = false;
                        } catch (InputMismatchException e) {
                            System.out.println("Valor digitado não é valido.");
                            System.out.println("Digite novamente:");
                            sc.nextLine();
                        }
                    }
                    try {
                        bombas.get(indexBomba).abastecerLitros(valorLitro);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        repete = true;
                        System.out.println("Digite outro valor: ");
                        sc.nextLine();
                    }
                }
                valorTotal = valorLitro * bombas.get(indexBomba).getValorDoLitro();
                System.out.println("Valor total a ser pago: " + valor.format(valorTotal));
                rd = new Vendas(bombas.get(indexBomba).getNumeroDoLacre(), valorTotal, bombas.get(indexBomba).getTipo());
                dados.add(rd);
                pagamentoCartaoDinheiro(valorTotal);
                break;
            case 2:
                System.out.println("Digite a quantidade em reais(R$): ");
                while (repete) {
                    while (repete) {
                        try {
                            valorReais = sc.nextDouble();
                            repete = false;
                        } catch (InputMismatchException e) {
                            System.out.println("Valor digitado não é valido.");
                            System.out.println("Digite novamente:");
                            sc.nextLine();
                        }
                    }
                    try {
                        bombas.get(indexBomba).abastecerValor(valorReais);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        repete = true;
                        System.out.println("Digite outro valor(R$): ");
                        sc.nextLine();
                    }
                }
                valorTotal = valorReais / bombas.get(indexBomba).getValorDoLitro();
                System.out.println("Valor total em litros: " + valorTotal);
                rd = new Vendas(bombas.get(indexBomba).getNumeroDoLacre(), (valorTotal*bombas.get(indexBomba).getValorDoLitro()), bombas.get(indexBomba).getTipo());
                dados.add(rd);
                pagamentoCartaoDinheiro((valorTotal*bombas.get(indexBomba).getValorDoLitro()));
                break;

        }
    }

    public static void abastecer() {
        if (BombaCombustivel.limita < 1) {
            System.out.println("Número minimo de bombas não foi ativado!");
            return;
        }
        if (BombaCombustivel.limita > 10) {
            System.out.println("Existe " + (BombaCombustivel.limita - 10) + " além do permitido!");
            return;
        }
        
        Scanner sc = new Scanner(System.in);
        byte opcao = 0;
        boolean repete = true;
        int cont = 0;
        System.out.println("--------------Abastecimento--------------");
        System.out.println("---------Escolha o combustivel-----------");
        System.out.println("1- Gasolina");
        System.out.println("2- Álcool");
        System.out.println("3- Óleo diesel");
        System.out.println("-----------------------------------------");
        System.out.println("Digite o número da opção desejada: ");
        int bomba_encontrada;
        while (repete) {
            try {
                while (repete) {
                    opcao = sc.nextByte();
                    if (opcao > 0 && opcao < 4) {
                        repete = false;
                    } else {
                        System.out.println("Opção inválida");
                        System.out.println("Digite novamente: ");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida");
                System.out.println("Digite novamente:");
                sc.nextLine();
            }
        }
        switch (opcao) {
            case 1:
                /*
                 * Procura bomba ativa para combustivel gasolina
                 */
                if (bombas.isEmpty()) {
                    //Verifica se existe uma bomba cadastrada...
                    System.out.println("Nenhuma bomba cadastrada!");
                } else {
                    //Loop para encontrar bomba do tipo gasolina e status true
                    encontrou:
                    for (int i = 0; i < bombas.size(); i++) {
                        if (bombas.get(i).getTipo().equals("Gasolina") && (bombas.get(i).getStatus() == true)) {
                            bomba_encontrada = i;
                            iniciaAbastecimento(bomba_encontrada);
                            break encontrou;
                        }
                    }
                    if((cont - 1) == -1){
                        System.out.println("Bomba de Gasolina inexistente ou inativa!");
                    }
                }
                break;
            case 2:
                /*
                 * Procura bomba ativa para combustivel Álcool
                 */
                if (bombas.isEmpty()) {
                    //Verifica se existe uma bomba cadastrada...
                    System.out.println("Nenhuma bomba cadastrada!");
                } else {
                    //Loop para encontrar bomba do tipo Álcool e status true
                    encontrou:
                    for (int i = 0; i < bombas.size(); i++) {
                        if (bombas.get(i).getTipo().equals("Álcool") && (bombas.get(i).getStatus() == true)) {
                            bomba_encontrada = i;
                            iniciaAbastecimento(bomba_encontrada);
                            break encontrou;
                        }
                    }
                    if((cont - 1) == -1){
                        System.out.println("Bomba de Álcool inexistente ou inativa!");
                    }
                }
                break;
            case 3:
                /*
                 * Procura bomba ativa para combustivel Óleo diesel
                 */
               
                if (bombas.isEmpty()) {
                    //Verifica se existe uma bomba cadastrada...
                    System.out.println("Nenhuma bomba cadastrada!");
                } else {
                    //Loop para encontrar bomba do tipo Óleo diesel e status true
                    encontrou:
                    for (int i = 0; i < bombas.size(); i++) {
                        if (bombas.get(i).getTipo().equals("Óleo diesel") && (bombas.get(i).getStatus() == true)) {
                            bomba_encontrada = i;
                            cont++;
                            iniciaAbastecimento(bomba_encontrada);
                            break encontrou;
                        }
                    }
                    if((cont - 1) == -1){
                        System.out.println("Bomba de Óleo diesel inexistente ou inativa!");
                    }
                }
                break;
        }

    }

    public static void consultarClientes() {
        if (clientes.isEmpty()) {
                System.out.println("Nenhum cliente cadastrado!");
                return;
        }
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("Nome: " + clientes.get(i).getNome());
            System.out.println("CPF: " + ValidaCPF.imprimeCPF(Long.toString(clientes.get(i).getCpf())));
            System.out.println("Número do Cartão: " + clientes.get(i).getNumeroDoCartao());
        }
    }

    public static void consultarVendas() {
        if (dados.isEmpty()) {
                System.out.println("Não existem vendas cadastradas!");
                return;
        }
        for (int i = 0; i < dados.size(); i++) {
            System.out.println("Venda número: " + (i+1));
            System.out.println("Lacre: " + dados.get(i).getLacreDaBomba());
            System.out.println("Valor Total: " + valor.format(dados.get(i).getValorTotal()));
            System.out.println("Tipo do combustível: " + dados.get(i).getTipoDeCombustivel());
        }
    }
}
