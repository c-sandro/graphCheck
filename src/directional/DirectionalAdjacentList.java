package directional;

import java.util.ArrayList;
import java.util.HashSet;

public class DirectionalAdjacentList{

    private ArrayList<ArrayList<Integer>> nodeList;
    private ArrayList<ArrayList<String>> edgeList;
    private int nodeAmount;

    public DirectionalAdjacentList(int nodeAmount){

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
        edgeList.get(node1).add("(" + node1 + ", " + node2 + ")");
        
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

        int indegreeValue = 0;
        
        for(ArrayList<Integer> arrayList : nodeList){
            if(arrayList.indexOf(nodeIndex) == -1){
                continue;
            }
            for(int node : arrayList){
                if(node == nodeIndex){
                    indegreeValue++;
                }
            }
        }

        int outdegreeValue = nodeList.get(nodeIndex).size();
        
        System.out.println("Grau de entrada do nó " + nodeIndex + ": " + indegreeValue + "\n");
        System.out.println("Grau de saida do nó " + nodeIndex + ": " + outdegreeValue + "\n");

    }

}