import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ListaEncadeada {
    private NóMain primeiro;

    //constructor
    public ListaEncadeada(){
        primeiro = null;
    }

    //funcionalidades
        //inserir ordenado
        public void inserirStart_station(NóMain novoNó) {

            if(primeiro == null){
                primeiro = novoNó;
            }else{
                NóMain atual = primeiro;
                NóMain anterior = null;
    
                //itera pela lista procurando a posição certa
                while(atual != null){

                    if(atual.getStart_station().compareTo(novoNó.getStart_station()) > 0){
                        break;
                    }
                    //
                    anterior = atual;
                    atual = atual.getProximoDado();
                }
                if(anterior == null){
                    primeiro.setDadoAnterior(novoNó);
                    novoNó.setProximoDado(primeiro);
                    primeiro = novoNó;
                }else{
                    anterior.setProximoDado(novoNó);
                    novoNó.setDadoAnterior(anterior);
                    novoNó.setProximoDado(atual);
                    if(atual != null){
                        atual.setDadoAnterior(novoNó);
                    }else{
                        novoNó.setProximoDado(null);
                    }
                }
    
            }
        }

       public void inserirDuration(NóMain novoNó) {

            if(primeiro == null){
                primeiro = novoNó;
            }else{
                NóMain atual = primeiro;
                NóMain anterior = null;
    
                //itera pela lista procurando a posição certa
                while(atual != null){
                    if(atual.getDuration() > novoNó.getDuration() ){
                        break;
                    }

                    anterior = atual;
                    atual = atual.getProximoDado();
                }
                if(anterior == null){
                    primeiro.setDadoAnterior(novoNó);
                    novoNó.setProximoDado(primeiro);
                    primeiro = novoNó;
                }else{
                    anterior.setProximoDado(novoNó);
                    novoNó.setDadoAnterior(anterior);
                    novoNó.setProximoDado(atual);
                    if(atual != null){
                        atual.setDadoAnterior(novoNó);
                    }else{
                        novoNó.setProximoDado(null);
                    }
                }
    
            }
        }

    public void inserirStart_Time(NóMain novoNó) {

        if(primeiro == null){
            primeiro = novoNó;
        }else{
            NóMain atual = primeiro;
            NóMain anterior = null;

            //itera pela lista procurando a posição certa
            while(atual != null){
                //lista[1].compareToIgnoreCase(lista[0]
                if(atual.getDataFormatada().compareTo(novoNó.getDataFormatada()) > 0){
                    break;
                }
                //
                anterior = atual;
                atual = atual.getProximoDado();
            }
            if(anterior == null){
                primeiro.setDadoAnterior(novoNó);
                novoNó.setProximoDado(primeiro);
                primeiro = novoNó;
            }else{
                anterior.setProximoDado(novoNó);
                novoNó.setDadoAnterior(anterior);
                novoNó.setProximoDado(atual);
                if(atual != null){
                    atual.setDadoAnterior(novoNó);
                }else{
                    novoNó.setProximoDado(null);
                }
            }

        }
    }


    public void escreveCSV(String nomeArquivo) throws IOException{
        NóMain atual = primeiro;

        File product = new File(nomeArquivo);//determina onde será escrito
        FileWriter escritor = new FileWriter(product);//escreve em arquivo
        BufferedWriter bufEscritor = new BufferedWriter(escritor);// escreve as informações no arquivo
        bufEscritor.write("trip_id,duration,start_time,end_time,bike_id,trip_route_category,plan_duration,passholder_type,bike_type,start_station,end_station,start_lat,start_lon,end_lat,end_lon,taxicab_distance");//escreve os títulos
        bufEscritor.newLine();//new line no arquivo

        while(atual !=null){
            bufEscritor.write(atual.getTrip_id()+","+atual.getDuration()+","+atual.getStart_time()+","+atual.getEnd_time()+","+atual.getBike_id()+","+atual.getTrip_route_category()+","+atual.getPlan_duration()+","+atual.getPassholder_type()+","+atual.getBike_type()+","+atual.getStart_station()+","+atual.getEnd_station()+","+atual.getStart_lat()+","+atual.getStart_lon()+","+atual.getEnd_lat()+","+atual.getEnd_lon()+","+atual.getTaxicab_distance());
            bufEscritor.newLine();

            atual = atual.getProximoDado();
        }

        bufEscritor.close();// fecha o escritor do buffer
        escritor.close();// fecha o escritor de arquivo
    }
}
