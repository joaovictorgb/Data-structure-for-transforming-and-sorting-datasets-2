import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Ordenacao1{
    ListaEncadeada ListaStartStation;

    public Ordenacao1(){
        this.ListaStartStation = new ListaEncadeada();
    }

    public void OrdenaStartStation(){
        String path = "./arquivos/LAMetroTrips.csv";
        
        String ArquivoStartStation = "./arquivos/LAMetroTripsStartStation.csv";

        String line = "";
        //le arquivo
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();

            while((line = br.readLine()) != null){
                String[] linha = line.split(",");    
                //insere ja ordenado na lista encadeada
                this.ListaStartStation.inserirStart_station(new NóMain(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]), linha[2], linha[3], linha[4], linha[5], Integer.parseInt(linha[6]), linha[7], linha[8], linha[9], linha[10], linha[11], linha[12], linha[13], linha[14], linha[15]));

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ListaStartStation.escreveCSV(ArquivoStartStation);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    

}