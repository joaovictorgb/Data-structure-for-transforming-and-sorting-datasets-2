import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Ordenacao3{
    ListaEncadeada ListaStartTime;

    public Ordenacao3(){
        this.ListaStartTime = new ListaEncadeada();
    }

    public void OrdenaStartTime(){
        String path = "./arquivos/LAMetroTrips.csv";

        String ArquivoStartTime = "./arquivos/LAMetroTripsStartTime.csv";
    
        String line = "";
        //le arquivo
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
    
            while((line = br.readLine()) != null){
                String[] linha = line.split(",");
                //insere ja ordenado na lista encadeada
                this.ListaStartTime.inserirStart_Time(new NóMain(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]), linha[2], linha[3], linha[4], linha[5], Integer.parseInt(linha[6]), linha[7], linha[8], linha[9], linha[10], linha[11], linha[12], linha[13], linha[14], linha[15]));
    
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        try {
            ListaStartTime.escreveCSV(ArquivoStartTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}