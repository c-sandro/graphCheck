package nondirectional;

import java.util.ArrayList;
import java.util.HashSet;

public class NonDirectionalAdjacencyList{

    private ArrayList<ArrayList<Integer>> nodeList;
    private ArrayList<ArrayList<String>> edgeList;
    private int nodeAmount;

    public NonDirectionalAdjacencyList(int nodeAmount){
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

        this.nodeList.get(node1).add(node2);
        this.nodeList.get(node2).add(node1);
        this.edgeList.get(node1).add("(" + node1 + ", " + node2 + ")");
        this.edgeList.get(node2).add("(" + node2 + ", " + node1 + ")");
    }

    public String loopDetection(){
        String output = "";

        boolean isTrue = false;
        for(int i = 0; i < this.nodeAmount; i++){
            if(this.nodeList.get(i).indexOf(i) != -1){
                output += "Loop detectado no vértice " + (i + 1) + "\n";
                isTrue = false;
            }
        }
        
        if(!isTrue){
            return "Nenhum loop detectado \n \n";
        }

        output += "\n";
        return output;
    }

    public String parallelEdgeDetection(){
        String output = "Arestas paralelas detectadas: [";
        boolean isTrue = false;

        for(ArrayList<String> arrayList : this.edgeList){
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
            return "Nenhuma aresta paralela detectada \n \n";
        }

        output = output.substring(0, output.length() - 3) + "] \n \n";
        return output;  
    }

    public String nodeDegree(int nodeIndex){
        int degreeValue = this.nodeList.get(nodeIndex).size();
        
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
        String outputNodes = "Lista de Adjacência de Vértices: \n";
        String outputEdges = "Lista de Arestas por Vértice: \n";

        //vértices
        for(int i = 0; i < this.nodeAmount; i++){
            outputNodes += "Vértice " + (i + 1) + ": [";
            for (int node : this.nodeList.get(i)){
                outputNodes += node + ", ";
            }
            outputNodes = outputNodes.substring(0, outputNodes.length() - 3) + "] \n";
        }
        outputNodes += "\n";

        //vértices
        for(int i = 0; i < this.edgeList.size(); i++){
            outputEdges += "Vértice " + (i + 1) + ": [";
            for (String edge : this.edgeList.get(i)){
                outputEdges += edge + ", ";
            }
            outputEdges = outputEdges.substring(0, outputEdges.length() - 3) + "] \n";
        }
        outputEdges += "\n";

        return "Lista de Adjacencia não Direcionada \n" + outputNodes + outputEdges + this.loopDetection() + this.parallelEdgeDetection() + this.allNodesDegree();
    }

}