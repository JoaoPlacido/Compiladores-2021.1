package rpnStacker;
import java.util.*;
import java.io.*;

public class RpnStacker {

	public static void main(String[] args) throws IOException {
		Stack <String> pilha = new Stack<String>();
		FileInputStream stream = new FileInputStream("..\\RPNStacker Adhoc\\src\\Calc1.stk");
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		String dado="";
		while((dado=br.readLine())!= null) {
			boolean isNumeric = dado.matches("[+-]?\\d*(\\.\\d+)?");
			if(dado.equals("/")){
				double numero1 = Double.valueOf(pilha.pop()).doubleValue();	
				double numero2 = Double.valueOf(pilha.pop()).doubleValue();
				double resultado= numero2 / numero1;
				pilha.push(Double.toString(resultado));
			}
			else if(dado.equals("+")) {
				double numero1 = Double.valueOf(pilha.pop()).doubleValue();	
				double numero2 = Double.valueOf(pilha.pop()).doubleValue();
				double resultado= numero2 + numero1;
				pilha.push(Double.toString(resultado));
			}
			else if(dado.equals("-")) {
				double numero1 = Double.valueOf(pilha.pop()).doubleValue();
				double numero2 = Double.valueOf(pilha.pop()).doubleValue();
				double resultado= numero2 - numero1;
				pilha.push(Double.toString(resultado));
			}
			else if(dado.equals("*")) {
				double numero1 = Double.valueOf(pilha.pop()).doubleValue();	
				double numero2 = Double.valueOf(pilha.pop()).doubleValue();
				double resultado= numero2 * numero1;
				pilha.push(Double.toString(resultado));
			}
			else if(isNumeric) {
			pilha.push(dado);	
			}
			else {
			System.out.println("Formato errado");
			break;
			}
			
		}
		System.out.println("resultado: "+ pilha.pop());
		br.close();

	}

}
