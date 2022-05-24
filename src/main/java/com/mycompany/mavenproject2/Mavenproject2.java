package com.mycompany.mavenproject2;
/**
 *
 * @author juliz
 */
import java.util.*;
import java.io.*;

public class Mavenproject2 {

    public static void main(String[] args) {

        String mes,dia, res,root;
        
        Scanner in = new Scanner(System.in);
        System.out.print("Introduce número del mes: ");                                             
        mes = in.nextLine();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la letra de la semana entre L, M, X, J, V, S, D: ");
        dia = sc.nextLine();
        
        Scanner ruta = new Scanner(System.in);
        System.out.print("Introduce la ruta donde desea guardar el archivo: ");
        root = ruta.nextLine();

        res = escribirMes(mes,dia,root);
        System.out.println(res);
    }

    public static String escribirMes(String mes, String dia, String root){
        
        String dias="DLMXJVSDLMXJVSDLMXJVSDLMXJVSDLMXJVSDLMXJVS";
        String [] d = dias.split("");
        
        int i;
        int j;
        int k=0;
        
        switch (dia) {
              case "D" -> j=0;
              case "L" -> j=1;
              case "M" -> j=2;
              case "X" -> j=3;
              case "J" -> j=4;
              case "V" -> j=5;
              case "S" -> j=6;
              default -> {return "valor" +dia+"no válido";
            }
          }
        String [] de = new String[36];   

        while(k<31){
            de[k]=d[k+j];
            k++;
        }
         
        String cal="";
         for(i=0;i<31;i++){
             k=i+1;
             String da = k+"";
             cal=cal+da+de[i];
         }
        String name= "mes"+mes;
           System.out.println(name);  
         try {
            String ruta = root+name+".txt";
            File file = new File(ruta);
                if (!file.exists()) {
                    file.createNewFile();
                }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(cal);
            bw.close();
        } catch (Exception error) {
            System.out.println("Error al crear el archivo");
            error.printStackTrace();
        }
        return cal;
        
    } 
    }

