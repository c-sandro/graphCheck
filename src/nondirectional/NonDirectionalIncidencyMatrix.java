package nondirectional;

import java.util.ArrayList;

public class NonDirectionalIncidencyMatrix{

    private ArrayList<ArrayList<Integer>> matrix;
    private int nodeAmount;
    private int edgeAmount;

    public NonDirectionalIncidencyMatrix(int nodeAmount){
        this.nodeAmount = nodeAmount;
        this.matrix = new ArrayList<>();
        this.edgeAmount = 0;
    }

    public void addEdge(int node1, int node2){
        if(node1 > this.nodeAmount || node2 > this.nodeAmount){
            System.out.println("ERRO: nó recebido não existe \n");
            return;
        }
        matrix.add(new ArrayList<Integer>());
        this.edgeAmount++;
        for(int i = 0; i < this.matrix.size(); i++){
            if(i != node1 && i != node2){
                this.matrix.get(i).add(0);
            }else{
                this.matrix.get(i).add(1);
            }
        }
    }

    public String loopDetection(){
        String output = "";

        boolean isTrue = false;
        for(ArrayList<Integer> arrayList : this.matrix){
            if(arrayList.indexOf(1) == arrayList.lastIndexOf(1)){
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
                output += "(" + (arrayList.indexOf(1) + 1) + ", " + (arrayList.lastIndexOf(1) + 1) + "), ";
                isTrue = true;
            }
        }

        if(!isTrue){
            return "Nenhuma aresta paralela detectada \n \n";
        }
        
        output = output.substring(0, output.length() - 3) + "] \n \n";
        return output;

    }

    public String nodeDegree(int nodeIndex){
        int degreeValue = 0;
        for(ArrayList<Integer> arrayList : this.matrix){
            if(arrayList.get(nodeIndex) == 0){
                continue;
            }
            degreeValue++;
        }

        return "O grau do vértice " + (nodeIndex + 1) + "é " + degreeValue + "\n";
    }

    public String allNodesDegree(){
        String output = "";

        for(int i = 0; i < this.nodeAmount; i++){
            output += this.nodeDegree(i);
        }
        output += "\n";
        return output;
    }

    public String toString(){
        String output = "Matriz de Incidência não Direcionada: \n \n  ";

        //vértices
        for(int i = 0; i < edgeAmount; i++){
            output += (i < 9) ? "  " + (i + 1) : " " + (i + 1);
        }
        output += "\n";

        for(int i = 0; i < nodeAmount; i++){
            output += output += (i < 9) ? " " + (i + 1) : (i + 1);
            for(int j = 0; j < edgeAmount; j++){
                output += (i < 9) ? "  " + this.matrix.get(i).get(j) : " " + this.matrix.get(i).get(j);
            }
            output += "\n";
        }
        output += "\n";

        return output + this.loopDetection() + this.parallelEdgeDetection() + this.allNodesDegree();
    }

}