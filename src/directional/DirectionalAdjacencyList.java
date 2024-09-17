package directional;

import java.util.ArrayList;
import java.util.HashSet;

public class DirectionalAdjacencyList{
    private ArrayList<ArrayList<Integer>> nodeList;
    private ArrayList<ArrayList<String>> edgeList;
    private int nodeAmount;

    public DirectionalAdjacencyList(int nodeAmount){
        this.nodeAmount = nodeAmount;
        this.nodeList = new ArrayList<>();
        this.edgeList = new ArrayList<>();

        for(int i = 0; i < nodeAmount; i++){
            this.nodeList.add(new ArrayList<>());
            this.edgeList.add(new ArrayList<>());
        }
    }

    public void addEdge(int node1, int node2){
        node1--;
        node2--;
        if(node1 > this.nodeAmount || node2 > this.nodeAmount){
            System.out.println("ERRO: nó recebido não existe \n");
            return;
        }

        this.nodeList.get(node1).add(node2);
        this.edgeList.get(node1).add("(" + node1 + ", " + node2 + ")");
    }

    public String loopDetection(){
        String output = "";

        boolean isTrue = false;
        for(int i = 0; i < this.nodeAmount; i++){
            if(this.nodeList.get(i).indexOf(i) != -1){
                output += "Loop detectado no vértice " + (i + 1) + "\n";
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
        String output = "Arestas paralelas detectadas: [";

        boolean isTrue = false;
        for(ArrayList<String> arrayList : this.edgeList){
            if(arrayList.size() == (new HashSet<String>(arrayList)).size()){
                continue;
            }

            for(String string : arrayList){
                if(arrayList.indexOf(string) != arrayList.lastIndexOf(string)){
                    output += string + ", ";
                    isTrue = true;
                    break;
                }   
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
        for(ArrayList<Integer> arrayList : this.nodeList){
            if(arrayList.indexOf(nodeIndex) == -1){
                continue;
            }
            for(int node : arrayList){
                if(node == nodeIndex){
                    indegreeValue++;
                }
            }
        }

        int outdegreeValue = this.nodeList.get(nodeIndex).size();
        
        output += "O grau de entrada do vértice " + (nodeIndex + 1) + " é " + indegreeValue + "\n";
        output += "O grau de saída do vértice " + (nodeIndex + 1) + " é " + outdegreeValue + "\n \n";
        return output;
    }

    public String allNodesDegree(){
        String output = "";

        for(int i = 0; i < nodeAmount; i++){
            output += this.nodeDegree(i);
        }
        output += "\n";
        return output;
    }

    @Override
    public String toString(){
        String outputNodes = "Lista de Adjacência de Vértices: \n";
        String outputEdges = "Lista de Arestas por Vértice: \n";

        //vértices
        for(int i = 0; i < nodeAmount; i++){
            outputNodes += "Vértice " + (i + 1) + ": [";
            for (int node : this.nodeList.get(i)){
                outputNodes += (node + 1) + ", ";
            }
            if(this.nodeList.get(i).size() != 0){
                outputNodes = outputNodes.substring(0, outputNodes.length() - 2) + "] \n";
            }else{
                outputNodes += "] \n";
            }
        }
        outputNodes += "\n";

        //vértices
        for(int i = 0; i < this.edgeList.size(); i++){
            outputEdges += "Vértice " + (i + 1) + ": [";
            for (String edge : this.edgeList.get(i)){
                outputEdges += edge + ", ";
            }
            if(this.edgeList.get(i).size() != 0){
                outputEdges = outputEdges.substring(0, outputEdges.length() - 2) + "] \n";
            }else{
                outputEdges += "] \n";
            }
        }
        outputEdges += "\n";

        return "Lista de Adjacência Direcionada: \n" + outputNodes + outputEdges + this.loopDetection() + this.parallelEdgeDetection() + this.allNodesDegree();
    }

}