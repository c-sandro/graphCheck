package nondirectional;

import java.util.ArrayList;

public class NonDirectionalIncidentMatrix{

    private ArrayList<ArrayList<Integer>> matrix;
    private int nodeAmount;

    public NonDirectionalIncidentMatrix(int nodeAmount){

        this.nodeAmount = nodeAmount;
        this.matrix = new ArrayList<>();

    }

    public void addEdge(int node1, int node2){
        if(node1 > this.nodeAmount || node2 > this.nodeAmount){
            System.out.println("ERRO: nó recebido não existe \n");
            return;
        }
        matrix.add(new ArrayList<Integer>());
        for(int i = 0; i < this.matrix.size(); i++){
            if(i != node1 && i != node2){
                this.matrix.get(i).add(0);
            }else{
                this.matrix.get(i).add(1);
            }
        }
    }

    public void loopDetection(){

        boolean isTrue = false;
        
        for(ArrayList<Integer> arrayList : matrix){
            if(arrayList.indexOf(1) == arrayList.lastIndexOf(1)){
                System.out.println("Loop detectado no vértice " + (arrayList.indexOf(2) + 1) + "\n");
                isTrue = true;
            }
        }
        if(!isTrue){
            System.out.println("Nenhum loop detectado \n");
        }

    }

    public void parallelEdgeDetection(){

        boolean isTrue = false;
        String output = "[";

        for(ArrayList<Integer> arrayList : matrix){
            if(this.matrix.indexOf(arrayList) != this.matrix.lastIndexOf(arrayList)){
                output += "(" + (arrayList.indexOf(1) + 1) + ", " + (arrayList.lastIndexOf(1) + 1) + "), ";
                isTrue = true;
            }
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

        for(ArrayList<Integer> arrayList : matrix){

            if(arrayList.get(nodeIndex) == 0){
                continue;
            }
            degreeValue++;
            
        }

        System.out.println("Grau do nó " + nodeIndex + ": " + degreeValue + "\n");

    }

    

}