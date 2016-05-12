package com.app.reversewords;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseWords {
	
	public static void main(String[] args) {
		ReverseWords sc = new ReverseWords();
		
		List<String> linhas = sc.readFile("B-small-practice.in");
//		sc.printLines(linhas);
		linhas = sc.reverseWords(linhas);
		sc.printLines(linhas);
		sc.writeFile(linhas);
	}
	
	/**
	 * M�todo respons�vel por inverter as linhas de uma lista.
	 * @param linhas
	 * @return
	 */
	public List<String> reverseWords(List<String> linhas){
		List<String> reverseLinhas = new ArrayList<String>();
		
		for(String s : linhas){
			String reverseLinha = "";
			String[] linha = s.split("\\s+");
			for (int i = linha.length -1 ; i >= 0 ; i--){
				reverseLinha += linha[i] + " ";
			}
			reverseLinhas.add(reverseLinha.trim());
		}
		
		return reverseLinhas;
	}
	
	/**
	 * M�todo respons�vel por escrever o arquivo
	 * 
	 * @param linhas
	 */
	public void writeFile(List<String> linhas){
		
		try {
			FileWriter writer = new FileWriter(new File("saida.txt"));
			
			int i = 1;
			for(String s : linhas){
				writer.write("Case #"+ i +": " + s + "\n");
				i++;
			}
			
			writer.close();
		} catch (IOException e) {
			System.out.println("Deu Xabu");
		}
	}
	
	/**
	 * M�todo respons�vel por ler o arquivo
	 * @param filename
	 */
	public List<String> readFile(String filename){
		File arquivo = new File(this.getClass().getResource(filename).getFile());
		List<String> linhas = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(arquivo);
			scanner.nextLine();
			while(scanner.hasNextLine()){
				linhas.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo n�o encontrado");
		}
		
		return linhas;		
	}
	
	/**
	 * M�todo respons�vel por imprimir as linhas do array
	 * @param linhas
	 */
	public void printLines(List<String> linhas){
		for(String s: linhas){
			System.out.println(s);
		}
	}

}
