package nondirectional;

import java.util.ArrayList;
import java.util.HashSet;

public class NonDirectionalAdjacentList{

    private ArrayList<ArrayList<Integer>> nodeList;
    private ArrayList<ArrayList<String>> edgeList;
    private int nodeAmount;

    public NonDirectionalAdjacentList(int nodeAmount){

        this.nodeAmount = nodeAmount;
        this.nodeList = new ArrayList<>();

        for(int i = 0; i < nodeAmount; i++){
            this.nodeList.add(new ArrayList<>());
            this.edgeList.add(new ArrayList<>());
        }

    }

    public void addEdge(int node1, int node2){
        if(node1 > this.nodeAmount || node2 > this.nodeAmount){
            System.out.println("ERRO: nó recebido não existe \n");
            return;
        }

        nodeList.get(node1).add(node2);
        nodeList.get(node2).add(node1);
        edgeList.get(node1).add("(" + node1 + ", " + node2 + ")");
        edgeList.get(node2).add("(" + node2 + ", " + node1 + ")");
    }

    public void loopDetection(){

        boolean isTrue = false;
        for(int i = 0; i < this.nodeAmount; i++){
            if(this.nodeList.get(i).indexOf(i) != -1){
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

        for(ArrayList<String> arrayList : edgeList){
            if(arrayList.size() == (new HashSet<String>(arrayList)).size()){
                continue;
            }

            for(String string : arrayList){
                if(arrayList.indexOf(string) != arrayList.lastIndexOf(string)){
                    output += string + ", ";
                    break;
                }   
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

        int degreeValue = nodeList.get(nodeIndex).size();
        
        System.out.println("Grau de entrada do nó " + nodeIndex + ": " + degreeValue + "\n");

    }

}