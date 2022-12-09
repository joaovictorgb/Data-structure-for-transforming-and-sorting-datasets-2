import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException{

        long tempoInicialTotal;//variável para iniciar o tempo em ms

        System.out.println("execução iniciada");
        tempoInicialTotal = System.currentTimeMillis();//inicia o tempo total da aplicacao

        //transformacoes
        System.out.println("Iniciando transformacoes");

        Transformacao1 t1 = new Transformacao1();        
        t1.Transformacao();

        Transformacao2 t2 = new Transformacao2();
        t2.filtraArquivo();

        Transformacao3 t3 = new Transformacao3();
        t3.filtraArquivo();

        //ordenacoes
        System.out.println("Iniciando ordenacoes");

        Ordenacao1 ordenaStation = new Ordenacao1();
        ordenaStation.OrdenaStartStation();

        Ordenacao2 ordenaDuration = new Ordenacao2();
        ordenaDuration.OrdenaDuration();

        Ordenacao3 ordenaTempo = new Ordenacao3();
        ordenaTempo.OrdenaStartTime();

        long tempoFinal = (System.currentTimeMillis() - tempoInicialTotal);
        System.out.println("execução terminada em: "+ tempoFinal +" ms"); //mostra tempo total gasto para executar
    }
}
