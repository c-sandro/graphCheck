package nondirectional;

import java.util.ArrayList;
import java.util.Collections;

public class NonDirectionalAdjacentMatrix{

    private ArrayList<ArrayList<Integer>> matrix;
    private int nodeAmount;

    public NonDirectionalAdjacentMatrix(int nodeAmount){

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

        matrix.get(node1).set(node2, matrix.get(node1).get(node2) + 1);
        matrix.get(node2).set(node1, matrix.get(node2).get(node1) + 1);
        
    }

    public void loopDetection(){

        boolean isTrue = false;
        for(int i = 0; i < this.nodeAmount; i++){
            if(this.matrix.get(i).get(i) > 0){
                System.out.println("Loop detectado no vértice " + (i + 1) + "\n");
                isTrue = false;
            }
        }
        if(!isTrue){
            System.out.println("Nenhum loop detectado \n");
        }

    }

    public void parallelEdgeDetection(){

        boolean isTrue = false;
        String output = "[";
        for(int i = 0; i < this.nodeAmount; i++){
            if((Collections.frequency(matrix.get(i), 0) + Collections.frequency(matrix.get(i), 1)) == this.nodeAmount){
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
            System.out.println("Nenhuma aresta paralela detectada \n");
            return;
        }

        output = output.substring(0, output.length() - 3) + "]";
        System.out.println(output + "\n");

    }

    public void nodeDegree(int nodeIndex){

        int degreeValue = 0;

        for(int node : matrix.get(nodeIndex)){
            degreeValue += node;
        }

        System.out.println("Grau do nó " + nodeIndex + ": " + degreeValue + "\n");

    }

}