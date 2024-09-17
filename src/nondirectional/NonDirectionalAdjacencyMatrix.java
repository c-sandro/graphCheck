package nondirectional;

import java.util.ArrayList;
import java.util.Collections;

public class NonDirectionalAdjacencyMatrix{

    private ArrayList<ArrayList<Integer>> matrix;
    private int nodeAmount;

    public NonDirectionalAdjacencyMatrix(int nodeAmount){
        this.nodeAmount = nodeAmount;
        this.matrix = new ArrayList<>();

        for(int i = 0; i < nodeAmount; i++){
            this.matrix.add(new ArrayList<>());
            for(int j = 0; j < nodeAmount; j++){
                this.matrix.get(i).add(0);
            }
        }
    }

    public void addEdge(int node1, int node2){
        if(node1 > this.nodeAmount || node2 > this.nodeAmount){
            System.out.println("ERRO: nó recebido não existe \n");
            return;
        }

        this.matrix.get(node1).set(node2, this.matrix.get(node1).get(node2) + 1);
        this.matrix.get(node2).set(node1, this.matrix.get(node2).get(node1) + 1);
    }

    public String loopDetection(){
        String output = "";

        boolean isTrue = false;
        for(int i = 0; i < this.nodeAmount; i++){
            if(this.matrix.get(i).get(i) > 0){
                output += "Loop detectado no vértice " + (i + 1) + "\n \n";
                isTrue = false;
            }
        }

        if(!isTrue){
            return "Nenhum loop detectado \n \n";
        }

        return output;
    }

    public String parallelEdgeDetection(){
        String output = "Arestas paralelas detectadas: [";
        
        boolean isTrue = false;
        for(int i = 0; i < this.nodeAmount; i++){
            if((Collections.frequency(this.matrix.get(i), 0) + Collections.frequency(this.matrix.get(i), 1)) == this.nodeAmount){
                continue;
            }

            int node1 = i, node2 = 0;
            for(int j = 0; j < i; j++){
                if(this.matrix.get(i).get(j) > 1){
                    node2 = j;
                    break;
                }
            }
            output += "(" + node1 + ", " + node2 + "), ";
        }

        if(!isTrue){
            return "Nenhuma aresta paralela detectada \n \n";
        }

        output = output.substring(0, output.length() - 3) + "] \n \n";
        return output;
    }

    public String nodeDegree(int nodeIndex){
        int degreeValue = 0;
        for(int node : this.matrix.get(nodeIndex)){
            degreeValue += node;
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
        String output = "Matriz de Adjacência não Direcionada: \n \n  ";

        //vértices
        for(int i = 0; i < this.nodeAmount; i++){
            output += (i < 9) ? "  " + (i + 1) : " " + (i + 1);
        }
        output += "\n";

        for(int i = 0; i < this.nodeAmount; i++){
            output += output += (i < 9) ? " " + (i + 1) : (i + 1);
            for(int j = 0; j < nodeAmount; j++){
                output += (i < 9) ? "  " + this.matrix.get(i).get(j) : " " + this.matrix.get(i).get(j);
            }
            output += "\n";
        }
        output += "\n";

        return output + this.loopDetection() + this.parallelEdgeDetection() + this.allNodesDegree();
    }

}