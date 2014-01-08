package Misc.stringManipulation;

public class Reverser {
	public static String reverseWordOrder(String sentence){
		String[] words = sentence.split(" ");
		
		int wordCount = words.length;
		for(int i=0; i<wordCount/2; i++){
			String left = words[i];
			words[i] = words[wordCount-i-1];
			words[wordCount-i-1] = left;
		}
		return join(words, " ");
	}
	
	private static String join(String[] words, String delim){
		int last = words.length-1;
		String out = "";
		for(int i=0; i<=last; i++){
			out += words[i] + delim;
		}
		return out.substring(0, out.length() - delim.length());
	}
	
	public static String reverseWords(String sentence){
		String[] words = sentence.split(" ");
		for(int i=0; i<words.length; i++){
			words[i] = reverse(words[i]);
		}
		return join(words, " ");
	}
	
	public static String reverse(String word){
		String reversed = "";
		
		for(int i=0; i<word.length(); i++){
			reversed += word.charAt(word.length()-1-i);
		}
		
		return reversed;
	}
}
