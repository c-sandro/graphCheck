import java.util.Scanner;

import directional.DirectionalAdjacencyList;
import directional.DirectionalAdjacencyMatrix;
import directional.DirectionalIncidencyMatrix;
import nondirectional.NonDirectionalAdjacencyList;
import nondirectional.NonDirectionalAdjacencyMatrix;
import nondirectional.NonDirectionalIncidencyMatrix;

public class Main{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        String input = "";

        NonDirectionalIncidencyMatrix ndIncMatrix = null;
        NonDirectionalAdjacencyMatrix ndAdjMatrix = null;
        NonDirectionalAdjacencyList ndAdjList = null;

        DirectionalIncidencyMatrix dIncMatrix = null;
        DirectionalAdjacencyMatrix dAdjMatrix = null;
        DirectionalAdjacencyList dAdjList = null;

        while(!input.equals("L")){
            menu();
            input = scan.nextLine();
            switch(input){
                case "Q":
                {
                    int newQnt;
                    while(true){
                        System.out.println("Digite a quantidade de vértices: ");
                        try{
                            newQnt = Integer.parseInt(scan.nextLine());
                            if(newQnt < 1){
                                System.out.println("\n ERRO: Quantidade inválida. \n");
                                continue;
                            }
                            break;
                        }catch(Exception e){
                            System.out.println("\n ERRO: Entrada inválida. \n");
                        }
                    }
                    ndIncMatrix = new NonDirectionalIncidencyMatrix(newQnt);
                }
                break;
                
                case "A":
                {
                    if(ndIncMatrix == null){
                        System.out.println("\n ERRO: Matriz não foi criada ainda. \n");
                        break;
                    }
                    int newN1, newN2;
                    while(true){
                        System.out.println("Digite os vértices 1 e 2, separados por um enter, respectivamente: ");
                        try{
                            newN1 = Integer.parseInt(scan.nextLine());
                            newN2 = Integer.parseInt(scan.nextLine());
                            break;
                        }catch(Exception e){
                            System.out.println("\n ERRO: Entrada inválida. \n");
                        }
                    }
                    ndIncMatrix.addEdge(newN1, newN2);
                }
                break;
            
                case "Z":
                    if(ndIncMatrix == null){
                        System.out.println("\n ERRO: Matriz não foi criada ainda. \n");
                        break;
                    }
                    System.out.println(ndIncMatrix.toString());
                break;

                case "W":
                {
                    int newQnt;
                    while(true){
                        System.out.println("Digite a quantidade de vértices: ");
                        try{
                            newQnt = Integer.parseInt(scan.nextLine());
                            if(newQnt < 1){
                                System.out.println("\n ERRO: Quantidade inválida. \n");
                                continue;
                            }
                            break;
                        }catch(Exception e){
                            System.out.println("\n ERRO: Entrada inválida. \n");
                        }
                    }
                    dIncMatrix = new DirectionalIncidencyMatrix(newQnt);
                }
                break;
                
                case "S":
                {
                    if(dIncMatrix == null){
                        System.out.println("\n ERRO: Matriz não foi criada ainda. \n");
                        break;
                    }
                    int newN1, newN2;
                    while(true){
                        System.out.println("Digite os vértices 1 e 2, separados por um enter, respectivamente: ");
                        try{
                            newN1 = Integer.parseInt(scan.nextLine());
                            newN2 = Integer.parseInt(scan.nextLine());
                            break;
                        }catch(Exception e){
                            System.out.println("\n ERRO: Entrada inválida. \n");
                        }
                    }
                    dIncMatrix.addEdge(newN1, newN2);
                }
                break;
            
                case "X":
                    if(dIncMatrix == null){
                        System.out.println("\n ERRO: Matriz não foi criada ainda. \n");
                        break;
                    }
                    System.out.println(dIncMatrix.toString());
                break;

                case "E":
                {
                    int newQnt;
                    while(true){
                        System.out.println("Digite a quantidade de vértices: ");
                        try{
                            newQnt = Integer.parseInt(scan.nextLine());
                            if(newQnt < 1){
                                System.out.println("\n ERRO: Quantidade inválida. \n");
                                continue;
                            }
                            break;
                        }catch(Exception e){
                            System.out.println("\n ERRO: Entrada inválida. \n");
                        }
                    }
                    ndAdjMatrix = new NonDirectionalAdjacencyMatrix(newQnt);
                }
                break;
                
                case "D":
                {
                    if(ndAdjMatrix == null){
                        System.out.println("\n ERRO: Matriz não foi criada ainda. \n");
                        break;
                    }
                    int newN1, newN2;
                    while(true){
                        System.out.println("Digite os vértices 1 e 2, separados por um enter, respectivamente: ");
                        try{
                            newN1 = Integer.parseInt(scan.nextLine());
                            newN2 = Integer.parseInt(scan.nextLine());
                            break;
                        }catch(Exception e){
                            System.out.println("\n ERRO: Entrada inválida. \n");
                        }
                    }
                    ndAdjMatrix.addEdge(newN1, newN2);
                }
                break;
            
                case "C":
                    if(ndAdjMatrix == null){
                        System.out.println("\n ERRO: Matriz não foi criada ainda. \n");
                        break;
                    }
                    System.out.println(ndAdjMatrix.toString());
                break;

                case "R":
                {
                    int newQnt;
                    while(true){
                        System.out.println("Digite a quantidade de vértices: ");
                        try{
                            newQnt = Integer.parseInt(scan.nextLine());
                            if(newQnt < 1){
                                System.out.println("\n ERRO: Quantidade inválida. \n");
                                continue;
                            }
                            break;
                        }catch(Exception e){
                            System.out.println("\n ERRO: Entrada inválida. \n");
                        }
                    }
                    dAdjMatrix = new DirectionalAdjacencyMatrix(newQnt);
                }
                break;
                
                case "F":
                {
                    if(dAdjMatrix == null){
                        System.out.println("\n ERRO: Matriz não foi criada ainda. \n");
                        break;
                    }
                    int newN1, newN2;
                    while(true){
                        System.out.println("Digite os vértices 1 e 2, separados por um enter, respectivamente: ");
                        try{
                            newN1 = Integer.parseInt(scan.nextLine());
                            newN2 = Integer.parseInt(scan.nextLine());
                            break;
                        }catch(Exception e){
                            System.out.println("\n ERRO: Entrada inválida. \n");
                        }
                    }
                    dAdjMatrix.addEdge(newN1, newN2);
                }
                break;
                
                case "V":
                    if(dAdjMatrix == null){
                        System.out.println("\n ERRO: Matriz não foi criada ainda. \n");
                        break;
                    }
                    System.out.println(dAdjMatrix.toString());
                break;

                case "T":
                {
                    int newQnt;
                    while(true){
                        System.out.println("Digite a quantidade de vértices: ");
                        try{
                            newQnt = Integer.parseInt(scan.nextLine());
                            if(newQnt < 1){
                                System.out.println("\n ERRO: Quantidade inválida. \n");
                                continue;
                            }
                            break;
                        }catch(Exception e){
                            System.out.println("\n ERRO: Entrada inválida. \n");
                        }
                    }
                    ndAdjList = new NonDirectionalAdjacencyList(newQnt);
                }
                break;
                
                case "G":
                {
                    if(ndAdjList == null){
                        System.out.println("\n ERRO: Matriz não foi criada ainda. \n");
                        break;
                    }
                    int newN1, newN2;
                    while(true){
                        System.out.println("Digite os vértices 1 e 2, separados por um enter, respectivamente: ");
                        try{
                            newN1 = Integer.parseInt(scan.nextLine());
                            newN2 = Integer.parseInt(scan.nextLine());
                            break;
                        }catch(Exception e){
                            System.out.println("\n ERRO: Entrada inválida. \n");
                        }
                    }
                    ndAdjList.addEdge(newN1, newN2);
                }
                break;
            
                case "B":
                    if(ndAdjList == null){
                        System.out.println("\n ERRO: Matriz não foi criada ainda. \n");
                        break;
                    }
                    System.out.println(ndAdjList.toString());
                break;

                case "Y":
                {
                    int newQnt;
                    while(true){
                        System.out.println("Digite a quantidade de vértices: ");
                        try{
                            newQnt = Integer.parseInt(scan.nextLine());
                            if(newQnt < 1){
                                System.out.println("\n ERRO: Quantidade inválida. \n");
                                continue;
                            }
                            break;
                        }catch(Exception e){
                            System.out.println("\n ERRO: Entrada inválida. \n");
                        }
                    }
                    dAdjList = new DirectionalAdjacencyList(newQnt);
                }
                break;
                
                case "H":
                {
                    if(dAdjList == null){
                        System.out.println("\n ERRO: Matriz não foi criada ainda. \n");
                        break;
                    }
                    int newN1, newN2;
                    while(true){
                        System.out.println("Digite os vértices 1 e 2, separados por um enter, respectivamente: ");
                        try{
                            newN1 = Integer.parseInt(scan.nextLine());
                            newN2 = Integer.parseInt(scan.nextLine());
                            break;
                        }catch(Exception e){
                            System.out.println("\n ERRO: Entrada inválida. \n");
                        }
                    }
                    dAdjList.addEdge(newN1, newN2);
                }
                break;
            
                case "N":
                    if(dAdjList == null){
                        System.out.println("\n ERRO: Matriz não foi criada ainda. \n");
                        break;
                    }
                    System.out.println(dAdjList.toString());
                break;
            
                case "L":
                    System.out.println("Finalizando...");
                break;
            
                default:
                    System.out.println("\n ERRO: Comando inválido. \n");
                break;
            }
        }

        scan.close();
    }

    public static void menu(){
        System.out.println(" -- MENU -- ");
        System.out.println("Q: criar matriz de incidencia não direcional");
        System.out.println("A: adicionar aresta na matriz de incidencia não direcional");
        System.out.println("Z: checar propriedades da matriz de incidencia não direcional");
        System.out.println(" - ");
        System.out.println("W: criar matriz de incidencia direcional");
        System.out.println("S: adicionar aresta na matriz de incidencia direcional");
        System.out.println("X: checar propriedades da matriz de incidencia direcional");
        System.out.println(" - ");
        System.out.println("E: criar matriz de adjacencia não direcional");
        System.out.println("D: adicionar aresta na matriz de adjacencia não direcional");
        System.out.println("C: checar propriedades da matriz de adjacencia não direcional");
        System.out.println(" - ");
        System.out.println("R: criar matriz de adjacencia direcional");
        System.out.println("F: adicionar aresta na matriz de adjacencia direcional");
        System.out.println("V: checar propriedades da matriz de adjacencia direcional");
        System.out.println(" - ");
        System.out.println("T: criar lista de adjacencia não direcional");
        System.out.println("G: adicionar aresta na lista de adjacencia não direcional");
        System.out.println("B: checar propriedades da lista de adjacencia não direcional");
        System.out.println(" - ");
        System.out.println("Y: criar lista de adjacencia direcional");
        System.out.println("H: adicionar aresta na lista de adjacencia direcional");
        System.out.println("N: checar propriedades da lista de adjacencia direcional");
        System.out.println(" - ");
        System.out.println("L: sair");
        System.out.println("Digite seu comando: ");
    }

}
