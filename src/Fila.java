import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Fila {
    private NóMain primeiro;
    private NóMain topo;

    //constructor
    public Fila(){
        this.primeiro = null;
        this.topo = this.primeiro;
    }

    //inserir
    public void inserir(NóMain novo){
        if(isEmpty()){
            this.primeiro = novo;
            this.topo = this.primeiro;
        }else{
            if(primeiro == topo){
                this.topo = novo;
                this.primeiro.setProximoDado(novo);
                novo.setDadoAnterior(this.primeiro);
            }else{
                NóMain aux = this.topo;
                this.topo = novo;
                aux.setProximoDado(novo); 
                this.topo.setDadoAnterior(aux);
            }
        }
    }

    //remover
    public NóMain remover(){
        if(isEmpty()){
            return null;
        }else{
            NóMain aux = this.primeiro;
            this.primeiro = aux.getProximoDado();
            return aux;
        }
    }

    public boolean isEmpty(){
        return (primeiro == null);
    }
    public void imprime(){
        NóMain aux = this.primeiro;

        do{
            System.out.println(aux.getTrip_id());
            aux = aux.getProximoDado();
        }while(aux!=null);

    }

    public void escreveCSV(String nomeArquivo){
        try {
            NóMain atual = this.primeiro;

            File product = new File(nomeArquivo);//determina onde será escrito
            FileWriter escritor = new FileWriter(product);//escreve em arquivo
            BufferedWriter bufEscritor = new BufferedWriter(escritor);// escreve as informações no arquivo
            bufEscritor.write("trip_id,duration,start_time,end_time,bike_id,trip_route_category,plan_duration,passholder_type,bike_type,start_station,end_station,start_lat,start_lon,end_lat,end_lon,taxicab_distance");//escreve os títulos
            bufEscritor.newLine();//new line no arquivo

            int contador = 0;

            while(atual != null){
                bufEscritor.write(atual.getTrip_id()+","+atual.getDuration()+","+atual.getStart_time()+","+atual.getEnd_time()+","+atual.getBike_id()+","+atual.getTrip_route_category()+","+atual.getPlan_duration()+","+atual.getPassholder_type()+","+atual.getBike_type()+","+atual.getStart_station()+","+atual.getEnd_station()+","+atual.getStart_lat()+","+atual.getStart_lon()+","+atual.getEnd_lat()+","+atual.getEnd_lon()+","+atual.getTaxicab_distance());
                bufEscritor.newLine();

                atual = atual.getProximoDado();

                if(contador % 1000 == 0){
                    System.out.println(contador);
                }
                contador++;
            }

            bufEscritor.close();// fecha o escritor do buffer
            escritor.close();// fecha o escritor de arquivo
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public NóMain cabeca(){
        return this.primeiro;
    }
    
}
