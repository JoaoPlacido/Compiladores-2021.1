package rpnStacker;
import java.util.*;
import java.io.*;
import rpnStacker.*;
public class RpnStacker {

	public static void main(String[] args) throws IOException {
		Stack <String> pilha = new Stack<String>();
		ArrayList <Token> tokens= new ArrayList<Token>();
		FileInputStream stream = new FileInputStream("..\\RPNStacker Adhoc\\src\\Calc1.stk");
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		String dado="";
		boolean erro=false;
		while((dado=br.readLine())!= null && !erro) {
			boolean isNumeric = dado.matches("[+-]?\\d*(\\.\\d+)?");
			
			if(dado.equals("/")){
				tokens.add( new Token( TokenType.SLASH, "/" ));
				double numero1 = Double.valueOf(pilha.pop()).doubleValue();	
				double numero2 = Double.valueOf(pilha.pop()).doubleValue();
				double resultado= numero2 / numero1;
				pilha.push(Double.toString(resultado));
			}
			else if(dado.equals("+")) {
				tokens.add( new Token( TokenType.PLUS, "+" ));
				double numero1 = Double.valueOf(pilha.pop()).doubleValue();	
				double numero2 = Double.valueOf(pilha.pop()).doubleValue();
				double resultado= numero2 + numero1;
				pilha.push(Double.toString(resultado));
			}
			else if(dado.equals("-")) {
				tokens.add( new Token( TokenType.MINUS, "-" ));
				double numero1 = Double.valueOf(pilha.pop()).doubleValue();
				double numero2 = Double.valueOf(pilha.pop()).doubleValue();
				double resultado= numero2 - numero1;
				pilha.push(Double.toString(resultado));
			}
			else if(dado.equals("*")) {
				tokens.add( new Token( TokenType.STAR, "*" ));
				double numero1 = Double.valueOf(pilha.pop()).doubleValue();	
				double numero2 = Double.valueOf(pilha.pop()).doubleValue();
				double resultado= numero2 * numero1;
				pilha.push(Double.toString(resultado));
			}
			else if(isNumeric) {
			tokens.add( new Token( TokenType.NUM, dado ));
			pilha.push(dado);	
			}
			else {
				tokens.add(new Token(TokenType.EOF,dado));
				erro=true;
			}
			
		}
		if(!erro) {
			for(int i=0;i<tokens.size();i++) {
				System.out.println(tokens.get(i).toString());
			}
			System.out.println("resultado: "+ pilha.pop());
		}
		else {
			System.out.println("Error: Unexpected character: " + tokens.get(tokens.size()-1).lexeme);
		}
		
		
		br.close();

	}

}

