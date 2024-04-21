/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.trabalhoestrturadedados;

import javax.swing.JOptionPane;

/**
 *
 * @author jefer
 */
public class Trabalhoestrturadedados {

    public static void main(String[] args) {
        String tamanhoVetor = JOptionPane.showInputDialog("Vossa excelência poderia informar ao campo abaixo o tamanho do vetor que deseja ordenar:");
        int nrTamanhoVetor = Integer.parseInt(tamanhoVetor);
        JOptionPane.showInputDialog(" Vossa excelência esta certo disso ? é esse o tamanho que deseja  vossa excelência ?");
        
        int [] vetor = new int [nrTamanhoVetor];
        for (int i = 0; i < vetor.length; i++) {
            String aux = JOptionPane.showInputDialog((i+1)+"° posição");
            vetor[i] = Integer.parseInt(aux);
        }
        
        boolean opcaoValida = false;
        while(!opcaoValida){
            String opcaoOrdenacao = JOptionPane.showInputDialog("Escolha uma opção que deseja utilizar: "
                + "\n1 Ordenação por Seleção"
                + "\n2 Ordenação por Inserção"
                + "\n3 Ordenação Bolha");
            int opcao = Integer.parseInt(opcaoOrdenacao);

            switch (opcao) {
                case 1:
                    opcaoValida = true;
                    OrdenacaoSelecao(vetor);
                    break;
                case 2:
                    opcaoValida = true;
                    OrdenacaoInsercao(vetor);
                    break;
                case 3:
                    opcaoValida = true;
                    OrdenacaoBolha(vetor);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Essa opção não é valida piá do djanho, Faz certo ae !");
                    break;
            }
        }
    }
    
    
   
    public static void OrdenacaoSelecao(int vetor[]){
        
        int [] vetorOrdenado = vetor.clone();
        for (int i = 0; i < vetorOrdenado.length; i++) {
            
            int posicaoMenor = i;
            for (int j = i+1; j < vetorOrdenado.length; j++) {
                
                if(vetorOrdenado[j] < vetorOrdenado[posicaoMenor]) {
                    posicaoMenor = j;
                }               
            }
            if(posicaoMenor != i) {
                int aux = vetorOrdenado[i];
                vetorOrdenado[i] = vetorOrdenado[posicaoMenor];
                vetorOrdenado[posicaoMenor] = aux;
            }
        }
        
        String msg = "Vetor informado: ";
        for (int i = 0; i < vetor.length; i++) {
            msg += vetor[i];
            if(i < vetor.length-1)
                msg += " - ";
        }
        msg += "\n Vetor finalizado e ordenado: ";
        for (int i = 0; i < vetorOrdenado.length; i++) {
            msg += vetorOrdenado[i];
            if(i < vetorOrdenado.length-1)
                msg += " - ";
        }
        
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static void OrdenacaoInsercao(int vetor[]){
        
        int [] vetorOrdenado = vetor.clone();
        int chave;
        int j;
        
        for (int i = 1; i < vetorOrdenado.length; i++) {
            chave = vetorOrdenado[i];
            for (j = i-1; (j >= 0 && vetorOrdenado[j] > chave); j--) {
                vetorOrdenado[j+1] = vetorOrdenado[j];
            }
            vetorOrdenado[j+1] = chave;
        }
        
        String msg = "Vetor informado: ";
        for (int i = 0; i < vetor.length; i++) {
            msg += vetor[i];
            if(i < vetor.length-1)
                msg += " - ";
        }
        msg += "\n Vetor finalizado e ordenado: ";
        for (int i = 0; i < vetorOrdenado.length; i++) {
            msg += vetorOrdenado[i];
            if(i < vetorOrdenado.length-1)
                msg += " - ";
        }

        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static void OrdenacaoBolha(int vetor[]){
        
        int [] vetorOrdenado = vetor.clone();
        boolean houveTroca= true;
        while(houveTroca){
            houveTroca = false;
            for (int i = 0; i < vetorOrdenado.length -1; i++) {
                if(vetorOrdenado[i] > vetorOrdenado[i+1]) {
                    int aux = vetorOrdenado[i];
                    vetorOrdenado[i] = vetorOrdenado[i+1];
                    vetorOrdenado[i+1] = aux;
                    houveTroca = true;
                }
                
            }
        }
        
        String msg = "Vetor informado: ";
        for (int i = 0; i < vetor.length; i++) {
            msg += vetor[i];
            if(i < vetor.length-1)
                msg += " - ";
        }
        msg += "\n Vetor finalizado e ordenado: ";
        for (int i = 0; i < vetorOrdenado.length; i++) {
            msg += vetorOrdenado[i];
            if(i < vetorOrdenado.length-1)
                msg += " - ";
        }
        
        JOptionPane.showMessageDialog(null, msg);
    }
}
