package directional;

import java.util.ArrayList;

public class DirectionalIncidencyMatrix{

    private ArrayList<ArrayList<Integer>> matrix;
    private int nodeAmount;
    private int edgeAmount;

    public DirectionalIncidencyMatrix(int nodeAmount){
        this.nodeAmount = nodeAmount;
        this.matrix = new ArrayList<>();
        this.edgeAmount = 0;
    }

    public void addEdge(int node1, int node2){
        node1--;
        node2--;
        if(node1 > this.nodeAmount || node2 > this.nodeAmount){
            System.out.println("ERRO: nó recebido não existe \n");
            return;
        }
        this.matrix.add(new ArrayList<Integer>());
        for(int i = 0; i < this.nodeAmount; i++){
            if(i != node1 && i != node2){
                this.matrix.get(this.edgeAmount).add(0);
            }else if(i != node2){
                this.matrix.get(this.edgeAmount).add(1);
            }else if(i != node1){
                this.matrix.get(this.edgeAmount).add(-1);
            }else{
                this.matrix.get(this.edgeAmount).add(2);
            }
        }
        this.edgeAmount++;
    }

    public String loopDetection(){
        String output = "";

        boolean isTrue = false;
        for(ArrayList<Integer> arrayList : matrix){
            if(arrayList.contains(2)){
                output += "Loop detectado no vértice " + (arrayList.indexOf(2) + 1) + "\n";
                isTrue = true;
            }
        }

        if(!isTrue){
            return "Nenhum loop detectado \n \n";
        }

        output += "\n";
        return output;
    }

    public String parallelEdgeDetection(){
        String output = "[";

        boolean isTrue = false;
        for(ArrayList<Integer> arrayList : this.matrix){
            if(this.matrix.indexOf(arrayList) != this.matrix.lastIndexOf(arrayList)){
                output += "(" + (arrayList.indexOf(-1) + 1) + ", " + (arrayList.indexOf(1) + 1) + "), ";
                isTrue = true;
            }
        }

        if(!isTrue){
            return "Nenhuma aresta paralela detectada \n \n";
        }
        
        output = output.substring(0, output.length() - 2) + "] \n \n";
        return output;
    }

    public String nodeDegree(int nodeIndex){
        String output = "";

        int indegreeValue = 0;
        int outdegreeValue = 0;

        for(ArrayList<Integer> arrayList : this.matrix){
            if(arrayList.get(nodeIndex) == 0){
                continue;
            }
            if(arrayList.get(nodeIndex) != 1){
                indegreeValue++;
            }else if(arrayList.get(nodeIndex) != -1){
                outdegreeValue++;
            }
        }

        output += "O grau de entrada do vértice " + (nodeIndex + 1) + " é " + indegreeValue + "\n";
        output += "O grau de saida do vértice " + (nodeIndex + 1) + " é " + outdegreeValue + "\n \n";

        return output;
    }

    public String allNodesDegree(){
        String output = "";

        for(int i = 0; i < this.nodeAmount; i++){
            output += this.nodeDegree(i);
        }
        output += "\n";
        return output;
    }

    @Override
    public String toString(){
        String output = "Matriz de Incidência Direcionada: \n \n      ";

        //vértices
        for(int i = 0; i < edgeAmount; i++){
            output += ((i < 9) ? "   " + (i + 1) : "  " + (i + 1)) + " |";
        }
        output += "\n";

        for(int i = 0; i < nodeAmount; i++){
            output += ((i < 9) ? "   " + (i + 1) : "  " + (i + 1)) + " |";
            for(int j = 0; j < edgeAmount; j++){
                output += ((this.matrix.get(j).get(i) > -1 && this.matrix.get(j).get(i) < 9) ? "   " + this.matrix.get(j).get(i) : "  " + this.matrix.get(j).get(i)) + " |";
            }
            output += "\n";
        }
        output += "\n";

        return output + this.loopDetection() + this.parallelEdgeDetection() + this.allNodesDegree();
    }

}