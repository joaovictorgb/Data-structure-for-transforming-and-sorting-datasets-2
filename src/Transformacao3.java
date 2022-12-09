import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Transformacao3 {
    private int somaTotal;
    private int contagemViagens;
    private int media;

    public Transformacao3(){
        try {
            String path = "./arquivos/LAMetroTrips.csv";
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
            String line;
            while((line = br.readLine()) != null){
                String[] linha = line.split(",");
                this.somaTotal += Integer.parseInt(linha[1]);
                this.contagemViagens += 1;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.media = this.somaTotal / this.contagemViagens;
    }

    public void filtraArquivo(){
        Fila ArquivoFiltrado = new Fila();

        try {
            String path = "./arquivos/LAMetroTrips.csv";
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
            String line;


            while((line = br.readLine()) != null){
                String[] linha = line.split(",");

                if(Integer.parseInt(linha[1]) > this.media){
                    ArquivoFiltrado.inserir(new NóMain(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]), linha[2], linha[3], linha[4], linha[5], Integer.parseInt(linha[6]), linha[7], linha[8], linha[9], linha[10], linha[11], linha[12], linha[13], linha[14], linha[15]));
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            File product = new File("./arquivos/LAMetroTrips_F2.csv");//determina onde será escrito
            FileWriter escritor = new FileWriter(product);//escreve em arquivo
            BufferedWriter bufEscritor = new BufferedWriter(escritor);// escreve as informações no arquivo
            bufEscritor.write("trip_id,duration,start_time,end_time,bike_id,trip_route_category,plan_duration,passholder_type,bike_type,start_station,end_station,start_lat,start_lon,end_lat,end_lon,taxicab_distance");//escreve os títulos
            bufEscritor.newLine();//new line no arquivo

            while(!ArquivoFiltrado.isEmpty()){
                NóMain atual = ArquivoFiltrado.remover();

                bufEscritor.write(atual.getTrip_id()+","+atual.getDuration()+","+atual.getStart_time()+","+atual.getEnd_time()+","+atual.getBike_id()+","+atual.getTrip_route_category()+","+atual.getPlan_duration()+","+atual.getPassholder_type()+","+atual.getBike_type()+","+atual.getStart_station()+","+atual.getEnd_station()+","+atual.getStart_lat()+","+atual.getStart_lon()+","+atual.getEnd_lat()+","+atual.getEnd_lon()+","+atual.getTaxicab_distance());
                bufEscritor.newLine();

                atual = atual.getProximoDado();
            }

            bufEscritor.close();// fecha o escritor do buffer
            escritor.close();// fecha o escritor de arquivo
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
