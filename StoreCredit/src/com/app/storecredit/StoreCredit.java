package com.app.storecredit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreCredit {
	
	public static void main(String[] args) {
		
		List<String> lines = new StoreCredit().readFile("A-large-practice.in");
		
		List<String> results = new StoreCredit().computeCredit(lines);
		
		new StoreCredit().writeFile(results);
		
		
			
	}
	
	public List<String> computeCredit(List<String> lines){
		List<String[]> listCredit = new ArrayList<>();
		
		String[] credit = new String[3];
		int x = 0;
		
		for (int i = 0; i < lines.size(); i++) {
			if(i!= 0 && i % 3 ==0){
				listCredit.add(credit);
				credit = new String[3];
				x=0;
				credit[x] = lines.get(i);
			}else{
				credit[x] = lines.get(i);
			}
			x++;
		}
		
		listCredit.add(credit);
		execute(listCredit);
		
		return execute(listCredit);
	}
	
	private List<String> execute(List<String[]> listCredit){
		List<String> res = new ArrayList<String>();
		
		for(String[] caso : listCredit){
			int credit = Integer.parseInt(caso[0]);
			String[] products = caso[2].split("\\s+");
			
			boolean ok = false;
			
			for(int i=0;i<products.length;i++){
				for(int x=0;x<products.length;x++){
					if((i != x ) && (Integer.parseInt(products[i]) + 
							Integer.parseInt(products[x]) == credit)){
						res.add((i+1) + " " + (x+1));
						ok = true;
						break;
					}
				}
				if(ok){
					break;
				}
			}
		}
		
		return res;
	}
	
	
	/**
	 * Método responsável por escrever o arquivo
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
			System.out.println("Arquivo não encontrado");
		}
		
		return linhas;		
	}

}
