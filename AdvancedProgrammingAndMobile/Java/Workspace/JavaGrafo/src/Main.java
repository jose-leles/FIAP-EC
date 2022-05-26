
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.reflect.Array.set;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

/**
 *
 * @author zangado
 */
public class Main {

    static final int numAtores= 248243;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      System.out.println("Rede de Atores");
      Main r = new  Main();
      r.processa();
    }
    
    public void processa(){
        Net rede = new Net();         
        rede.leVertices();
        rede.leArestas();
        LocalDateTime myDateObj = LocalDateTime.now();
        System.out.println("inicio: " + myDateObj);
    

        for(int i = 0; i< 5; i++){
         rede.caminhosminimos(i);
         rede.histograma(i);            
        }        
        myDateObj = LocalDateTime.now();
        System.out.println("fim: " + myDateObj);

    }
    
    protected class Net{
        
        Vector atores = new Vector(numAtores);
        
        public void histograma(int id){
            int hist[] = new int[256];
            int maximo = 0;
            Ator origem = (Ator) atores.elementAt(id);
            Ator a1;
            for(int i=0; i < numAtores; i++){
             a1 = (Ator)atores.elementAt(i);
             if(a1.dist < 255){
                hist[a1.dist]++;
                if(a1.dist > maximo)
                    maximo = a1.dist;
             }
             else{
                 hist[255]++;
             }
            }
            System.out.print(origem.id);
            System.out.print(" ");
            for(int i=0; i <= maximo; i++){  
             System.out.print(hist[i]);
             System.out.print(" ");
            }
            System.out.println("");
        }
        
        public class DistComparator implements Comparator<Ator> {

        @Override
        public int compare(Ator a1, Ator a2) {
            if (a1.id == a2.id)
                return 0;
            
            int value =  a1.dist-a2.dist;

            if (value > 0) {
                return 1;
            }
            else if (value < 0) {
                return -1;
            }
            else {
                value =  a1.id-a2.id;
                if (value > 0) {
                return 1;
                }
                else if (value < 0) {
                return -1;
                }
            }
            return 0;
         }
        }
        
        public class DegreetComparator implements Comparator<Ator> {

        @Override
        public int compare(Ator a1, Ator a2) {
            if (a1.id == a2.id)
                return 0;
            
            int value =  a1.dist-a2.dist;

            if (value > 0) {
                return 1;
            }
            else if (value < 0) {
                return -1;
            }
            else {
                value =  a1.id-a2.id;
                if (value > 0) {
                return 1;
                }
                else if (value < 0) {
                return -1;
                }
            }
            return 0;
         }
        }
        
                
        public class IDComparator implements Comparator<Ator> {

        @Override
        public int compare(Ator a1, Ator a2) {
            int value =  a1.id-a2.id;

            if (value > 0) {
                return -1;
            }
            else if (value < 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }        
        
        public void caminhosminimos(int id){
            

            TreeSet<Ator> atorescandidatos = new TreeSet<Ator>(new DistComparator());
            TreeSet<Ator> atoresnaovisitados = new TreeSet<Ator>(new IDComparator());
            Ator a1;
            Ator origem = (Ator) atores.elementAt(id);
            Ator maisprox = origem;
            
            for(int i=0; i < numAtores; i++){
             a1 = (Ator)atores.elementAt(i);
             a1.dist = Integer.MAX_VALUE;
             a1.visitado = false;
             a1.candidato = false;
             atoresnaovisitados.add(a1);
            }
            origem.dist = 0;
            Ator atorAtual = origem;
            
            while ((atoresnaovisitados.size() != 0) && (atorAtual != null)) {
             Iterator it = atorAtual.atoresVizinhos.iterator();
             while (it.hasNext()) {
                a1 = (Ator) it.next();
                if(atorAtual.dist+1 < a1.dist){
                    if(a1.candidato == true){
                     atorescandidatos.remove(a1);
                     a1.dist = atorAtual.dist+1;
                     atorescandidatos.add(a1);
                    }
                    else{
                        a1.dist = atorAtual.dist+1;
                    }
                }
                if(a1.visitado == false && a1.candidato == false)
                  atorescandidatos.add(a1);
             }
             atoresnaovisitados.remove(atorAtual);
             atorAtual.visitado = true;
             atorAtual = atorescandidatos.pollFirst();
            }
        }  
        
                 
    public void leVertices(){
        try {
            File myObj = new File("src/movie_actors_names_dists");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int i1 = data.indexOf(":");
                int i2 = data.indexOf("1", i1);
                int id = Integer.valueOf(data.substring(0, i1).trim());
                String nome = data.substring(i1+1, i2).trim();
                String[] dists = data.substring(i2).trim().split("\\t");
                System.out.println(nome + " " + id);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
            e.printStackTrace();
        }
    	System.out.println("Arquivo lido");
    }
        
        public void leArestas(){
            int c =0;
        for(int i=0; i < numAtores; i++){
            atores.insertElementAt(new Ator(i), i);
        }
        try {
            File myObj = new File("src/movie_actors.net");
            //File myObj = new File("teste1");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int i = data.indexOf(" ");
                if(i < 1) {
                    System.out.println("Erro de leitura linha: " + data );
                }
                int ator1 = Integer.valueOf(data.substring(0, i));
                int ator2 = Integer.valueOf(data.substring(i+1));
                Ator a1 = (Ator)atores.elementAt(ator1);
                Ator a2 = (Ator)atores.elementAt(ator2);
                a1.criaAresta(a2);
                a2.criaAresta(a1);
                c++;
                if(c%100000 == 0)
                    System.out.print("&");
         }
            myReader.close();
         } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
            e.printStackTrace();
         }
        System.out.println(".");
        System.out.println("Arquivo lido");
        }

    }

    
    
    public class Ator {
    
    public int id;
    
    
    public boolean visitado;
    
    public boolean candidato;
    
    private Integer dist = Integer.MAX_VALUE;
    
    public Set<Ator> atoresVizinhos = new HashSet<Ator>();

    public void criaAresta(Ator a) {
        atoresVizinhos.add(a);
    }
 
    public Ator(int i) {
        this.id = i;
    }
}
       
}