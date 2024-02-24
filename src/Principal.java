//Luís F. de Castilho e Gabriel de S. Klauck
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);

		int op;
		while (true) {

			System.out.println("Selecione um tipo de pilha");
			System.out.println("1 - Pilha Vetor");
			System.out.println("2 - Pilha Lista");
			op = tec.nextInt();

			switch (op) {
			case 1:
				pv();
				break;

			case 2:
				pl();
				break;

			default:
				System.exit(0);
				break;
			}
		}
	}

	public static void pv() {
		Scanner tec = new Scanner(System.in);
		PilhaVetor<Double> pilha = new PilhaVetor<>(10);
		ArrayList<String> simbolos = new ArrayList<>();
		simbolos.add("+");
		simbolos.add("-");
		simbolos.add("*");
		simbolos.add("/");
		
		int qtdNumeros = 0; // contem a quantidade de numeros
		int qtdSimbolos = 0; // contem a quantidade de simbolos
		char caractere;
		boolean erroAtivo = false;
		String notacao;
		
		do {
		System.out.println("Digite a sua operacao em forma de notacao pos-fixa");
		notacao = tec.nextLine();
		}while(!(simbolos.contains(notacao.substring(notacao.length() - 1))));
		
		for (int i = 0; i < notacao.length(); i++) {
			caractere = notacao.charAt(i);

			if (caractere == '+' || caractere == '-' || caractere == '–' || caractere == '*' || caractere == '/') {
				// agrega a varivel de
				// acordo com a
				// quantiade
				// de simbolos escritos
				qtdSimbolos++;
			}

			try {
			if (Character.isDigit(caractere)) {
				String numS = "";
				while (Character.isDigit(caractere) == true || caractere == '.') {
					numS += String.valueOf(caractere);
					i++;
					caractere = notacao.charAt(i);
				}
				double num = Double.parseDouble(numS);
				pilha.push(num);
				qtdNumeros++;
			}
			}catch(RuntimeException p) {
				
			}
			

			if (caractere == '-' || caractere == '–') {
				try {
					Double num1 = pilha.pop();
					Double num2 = pilha.pop();
					Double conta = num2 - num1;
					pilha.push(conta);
				} catch (RuntimeException e) { // CAPTURA O ERRO DE PILHA VAZIA E O TRATA COLOCANDO 0 NA PILHA
					System.out.println("ERRO DE SINTAXE VALOR RETORNADO SERA 0");
					pilha.push(0.0);
					erroAtivo = true;
				}
			} else if (caractere == '+') {
				try {
					Double num1 = pilha.pop();
					Double num2 = pilha.pop();
					Double conta = num2 + num1;
					pilha.push(conta);
				} catch (RuntimeException e) {
					System.out.println("ERRO DE SINTAXE VALOR RETORNADO SERA 0");
					pilha.push(0.0);
					erroAtivo = true;
				}
			} else if (caractere == '*') {
				try {
					Double num1 = pilha.pop();
					Double num2 = pilha.pop();
					Double conta = num2 * num1;
					pilha.push(conta);
				} catch (RuntimeException e) {
					System.out.println("ERRO DE SINTAXE VALOR RETORNADO SERA 0");
					pilha.push(0.0);
					erroAtivo = true;
				}
			} else if (caractere == '/') {
				try {
					Double num1 = pilha.pop();
					Double num2 = pilha.pop();
					Double conta = num2 / num1;
					pilha.push(conta);
				} catch (RuntimeException e) {
					System.out.println("ERRO DE SINTAXE VALOR RETORNADO SERA 0");
					pilha.push(0.0);
					erroAtivo = true;
				}
			}
		}
		// Testa a seguinte logica: toda operaçao para funcionar deve conter x numeros
		// e x-1 simbolos ou seja se a 4 numeros deve-se conter 3 simbolos para a
		// operaçao ocorrer
		if ((qtdNumeros - qtdSimbolos) == 1) {
			System.out.println(pilha.pop());
		} else if(erroAtivo == false){
			System.out.println("OPERAÇAO INVALIDA, SINTAXE INCORRETA");
		} 
		System.out.println();
	}

	public static void pl() {
		Scanner tec = new Scanner(System.in);
		PilhaVetor<Double> pilha = new PilhaVetor<>(10);
		ArrayList<String> simbolos = new ArrayList<>();
		simbolos.add("+");
		simbolos.add("-");
		simbolos.add("*");
		simbolos.add("/");
		
		int qtdNumeros = 0; // contem a quantidade de numeros
		int qtdSimbolos = 0; // contem a quantidade de simbolos
		char caractere;
		boolean erroAtivo = false;
		String notacao;
		
		do {
		System.out.println("Digite a sua operacao em forma de notacao pos-fixa");
		notacao = tec.nextLine();
		}while(!(simbolos.contains(notacao.substring(notacao.length() - 1))));
		

		for (int i = 0; i < notacao.length(); i++) {
			caractere = notacao.charAt(i);
            
			if (caractere == '+' || caractere == '-' || caractere == '–' || caractere == '*' || caractere == '/') {
				// agrega a varivel de
				// acordo com a
				// quantiade
				// de simbolos escritos
				qtdSimbolos++;
			}

			try {
				if (Character.isDigit(caractere)) {
					String numS = "";
					while (Character.isDigit(caractere) == true || caractere == '.') {
						numS += String.valueOf(caractere);
						i++;
						caractere = notacao.charAt(i);
					}
					double num = Double.parseDouble(numS);
					pilha.push(num);
					qtdNumeros++;
				}
				}catch(RuntimeException p) {
					
				}

			if (caractere == '-' || caractere == '–') {
				try {
					Double num1 = pilha.pop();
					Double num2 = pilha.pop();
					Double conta = num2 - num1;
					pilha.push(conta);
				} catch (RuntimeException e) { // CAPTURA O ERRO DE PILHA VAZIA E O TRATA COLOCANDO 0 NA PILHA
					System.out.println("ERRO DE SINTAXE VALOR RETORNADO SERA 0");
					pilha.push(0.0);
					erroAtivo = true;
				}
			} else if (caractere == '+') {
				try {
					Double num1 = pilha.pop();
					Double num2 = pilha.pop();
					Double conta = num2 + num1;
					pilha.push(conta);
				} catch (RuntimeException e) {
					System.out.println("ERRO DE SINTAXE VALOR RETORNADO SERA 0");
					pilha.push(0.0);
					erroAtivo = true;
				}
			} else if (caractere == '*') {
				try {
					Double num1 = pilha.pop();
					Double num2 = pilha.pop();
					Double conta = num2 * num1;
					pilha.push(conta);
				} catch (RuntimeException e) {
					System.out.println("ERRO DE SINTAXE VALOR RETORNADO SERA 0");
					pilha.push(0.0);
					erroAtivo = true;
				}
			} else if (caractere == '/') {
				try {
					Double num1 = pilha.pop();
					Double num2 = pilha.pop();
					Double conta = num2 / num1;
					pilha.push(conta);
				} catch (RuntimeException e) {
					System.out.println("ERRO DE SINTAXE VALOR RETORNADO SERA 0");
					pilha.push(0.0);
					erroAtivo = true;
				}
			}
		}
		// Testa a seguinte logica: toda operaçao para funcionar deve conter x numeros
		// e x-1 simbolos ou seja se a 4 numeros deve-se conter 3 simbolos para a
		// operaçao ocorrer
		if ((qtdNumeros - qtdSimbolos) == 1) {
			System.out.println(pilha.pop());
		} else if(erroAtivo == false){
			System.out.println("OPERAÇAO INVALIDA, SINTAXE INCORRETA");
		} 
		System.out.println();
	}
}