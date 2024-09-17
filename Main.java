import java.util.Scanner;

import directional.DirectionalAdjacentMatrix;
import directional.DirectionalIncidentMatrix;
import nondirectional.NonDirectionalAdjacentList;
import nondirectional.NonDirectionalAdjacentMatrix;
import nondirectional.NonDirectionalIncidentMatrix;

public class Main{
    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);
        int n1,n2,e,e2,tm;

        System.out.println("Fazer Direcional ou Não direcional");
        System.out.println("1-Direcional");
        System.out.println("2-Não Direcional");
        e=sc.nextInt();
        switch (e) {
            case 1:
                System.out.println("1-lista de adjacencia");//Ou eu faço os dois tudo de uma vez?
                System.out.println("2-Lista Incidencia");
                e2=sc.nextInt();
                switch (e2) {
                    case 1:
                    System.out.println("Quantos vertices");
                    tm=sc.nextInt();
                    DirectionalAdjacentMatrix d= new DirectionalAdjacentMatrix(tm);
                    for(int i =0;i<=tm;i++){
                        System.out  .println(i+1+":esocolha a aresta");
                        n1=sc.nextInt();
                        System.out  .println(i+1+":esocolha a  outra aresta");
                        n2=sc.nextInt();
                        d.addEdge(n1, n2);
                    }
                        d.loopDetection();
                        d.parallelEdgeDetection();
                        for(int i=0;i<tm;i++){
                            d.nodeDegree(i);
                        }
                        break;
                
                    default:
                    System.out.println("Quantos vertices");
                    tm=sc.nextInt();
                    DirectionalIncidentMatrix in= new DirectionalIncidentMatrix(tm);
                    for(int i =0;i<=tm;i++){
                        System.out  .println(i+1+":esocolha a aresta");
                        n1=sc.nextInt();
                        System.out  .println(i+1+":esocolha a  outra aresta");
                        n2=sc.nextInt();
                        in.addEdge(n1, n2);
                    }
                    in.loopDetection();
                    for(int i=0;i<tm;i++){//Acho que Incidencia não possui grau
                        in.nodeDegree(i);
                    }
                }
                break;
        
            case 2:
                System.out.println("1-lista de adjacencia");//Ou eu faço os dois tudo de uma vez?
                System.out.println("2-Lista Incidencia");
                e2=sc.nextInt();
                switch (e2) {
                    case 1:
                        System.out.println("Quantos vertices");
                        tm=sc.nextInt();
                        NonDirectionalAdjacentMatrix nd= new NonDirectionalAdjacentMatrix(tm);
                        for(int i =0;i<=tm;i++){
                            System.out  .println(i+1+":esocolha a aresta");
                            n1=sc.nextInt();
                            System.out  .println(i+1+":esocolha a  outra aresta");
                            n2=sc.nextInt();
                            nd.addEdge(n1, n2);
                        }
                        nd.loopDetection();
                        for(int i=0;i<tm;i++){//Acho que Incidencia não possui grau
                            nd.nodeDegree(i);
                        }
                        break;
                
                    default:
                    System.out.println("Quantos vertices");
                    tm=sc.nextInt();
                    NonDirectionalIncidentMatrix ni= new NonDirectionalIncidentMatrix(tm);
                    for(int i =0;i<=tm;i++){
                        System.out  .println(i+1+":esocolha a aresta");
                        n1=sc.nextInt();
                        System.out  .println(i+1+":esocolha a  outra aresta");
                        n2=sc.nextInt();
                        ni.addEdge(n1, n2);
                    }
                    ni.loopDetection();
                    for(int i=0;i<tm;i++){//Acho que Incidencia não possui grau
                        ni.nodeDegree(i);
                    }
                        break;
                }
                break;
        }



















    
        

        /*System.out  .println("2:esocolha a aresta");
        n1=sc.nextInt();
        System.out  .println("2:esocolha a  outra aresta");
        n2=sc.nextInt();
        d.addEdge(n1, n2);//aresta2

        System.out  .println("3:esocolha a aresta");
        n1=sc.nextInt();
        System.out  .println("3:esocolha a  outra aresta");
        n2=sc.nextInt();
        d.addEdge(n1, n2);//aresta3

        System.out  .println("4:esocolha a aresta");
        n2=sc.nextInt();
        System.out  .println("4:esocolha a  outra aresta");
        n2=sc.nextInt();
        d.addEdge(n1, n2);//aresta4

        System.out  .println("5:esocolha a aresta");
        n1=sc.nextInt();
        System.out  .println("5:esocolha a  outra aresta");
        n2=sc.nextInt();
        d.addEdge(n1, n2);//aresta5

        System.out  .println("6:esocolha a aresta");
        n1=sc.nextInt();
        System.out  .println("6:esocolha a  outra aresta");
        n2=sc.nextInt();
        d.addEdge(n1, n2);//aresta6*/

        
       /*  for(int i = 0;i<5;i++ ){
        d.nodeDegree(i);
        }*/




        sc.close();
    }
}
