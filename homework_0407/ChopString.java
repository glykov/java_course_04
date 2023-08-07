// Напишите код, с помощью которого можно разделить строку на части.
// Код должен работать для строк любого размера и любого содержания. Размер частей вы устанавливаете самостоятельно.

import java.util.*;

public class ChopString {
	public static List<String> chopString(String original, int chopSize) {
		List<String> result = new ArrayList<>();
		int begin = 0;
		int end = chopSize;
		
		while (end < original.length()) {
			String temp = original.substring(begin, end);
			result.add(temp);
			begin = end;
			end += chopSize;
		}
		result.add(original.substring(begin));
		
		return result;
	}

	public static void main(String[] args) {
		String str = "Quick brown fox jumps over the lazy dog";
		List<String> result = chopString(str, 5);
		for (var s : result) {
			System.out.println(s);
		}
	}
}