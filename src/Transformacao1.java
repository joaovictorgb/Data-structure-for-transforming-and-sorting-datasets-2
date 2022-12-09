import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class Transformacao1 {
    HashMap<Integer, String> stations = new HashMap<Integer, String>();

    public Transformacao1(){
        iniciaHashmap();
    }

    public void iniciaHashmap(){
        try {
            String path = "./arquivos/stations.csv";
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
            String line;
            while((line = br.readLine()) != null){
                String[] linha = line.split(",");
                stations.put(Integer.parseInt(linha[0]), linha[1]);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Transformacao(){
        Fila arquivo = new Fila();
        try {
            String path = "./arquivos/LA_Metro_BikeSharing_CLEANED_2016quater3-2021q3.csv";
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
            String line;

            while((line = br.readLine()) != null){
                String[] linha = line.split(",");
                arquivo.inserir(new NóMain(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]), linha[2], linha[3], linha[4], linha[5], Integer.parseInt(linha[6]), linha[7], linha[8], linha[9], linha[10], linha[11], linha[12], linha[13], linha[14], linha[15]));

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            File product = new File("./arquivos/LAMetroTrips.csv");//determina onde será escrito
            FileWriter escritor = new FileWriter(product);//escreve em arquivo
            BufferedWriter bufEscritor = new BufferedWriter(escritor);// escreve as informações no arquivo
            bufEscritor.write("trip_id,duration,start_time,end_time,bike_id,trip_route_category,plan_duration,passholder_type,bike_type,start_station,end_station,start_lat,start_lon,end_lat,end_lon,taxicab_distance");//escreve os títulos
            bufEscritor.newLine();//new line no arquivo

            while(!arquivo.isEmpty()){
                NóMain atual = arquivo.remover();

                atual.setStart_station(this.stations.get(Integer.parseInt(atual.getStart_station())));
                atual.setEnd_station(this.stations.get(Integer.parseInt(atual.getEnd_station())));

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

    public HashMap<Integer, String> getStations(){
        return this.stations;
    }
}
