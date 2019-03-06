import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryUser {
	public static void main(String args[]) {
		System.out.println("! Loading data...");
		System.out.println("! Loading complete...\n");
		System.out.println("-----DICTIONARY 340 JAVA-----\n");
		Scanner scan = new Scanner(System.in);
		
		welcomeMessage();

		while (true) {
			System.out.print("Search: ");

			String input = scan.nextLine();
			String[] arguments = input.split(" ");
			String search = null;
			String search1 = null;

			if (input.equalsIgnoreCase("!q")) {
				System.out.println("\n-------THANK YOU-------");
				break;
			}

			if (arguments.length == 1) {
				search = arguments[0];
				List<Dictionary> values = new ArrayList<>();
				System.out.println("|");
				values = getIfPresentName(search);

				if (values.isEmpty()) {
					System.out.println("<Not Found>");
				} else {
					values.forEach(System.out::println);
				}
				System.out.println("|");
			}

			else if (arguments.length == 2) {
				search = arguments[0];
				search1 = arguments[1];
				System.out.println("|");
				if (search1.contains("distinct")) {

					List<Dictionary> values = new ArrayList<>();
					List<Dictionary> values2 = new ArrayList<>();

					values = getIfPresentName(search);
					values2 = removeDuplicates(values);

					if (values2.isEmpty()) {
						System.out.println("<Not Found>");
					} else {
						values2.forEach(System.out::println);
					}

				} else {
					search = arguments[0];
					search1 = arguments[1];

					List<Dictionary> values = new ArrayList<>();
					List<Dictionary> values2 = new ArrayList<>();

					values = getIfPresentName(search);
					values2 = getIfPresentPartOfSpeech(search1);

					values.retainAll(values2);

					if (values2.isEmpty()) {
						System.out.println("<2nd argument must be a part of speech or \"distinct\">");
					}
					else if (values.isEmpty()) {
						System.out.println("<Not Found>");
					} else {
						values.forEach(System.out::println);
					}
				}
				System.out.println("|");
			}

			else if (arguments.length == 3) {
				search = arguments[0];
				search1 = arguments[1];

				System.out.println("|");
				if (arguments[2].equals("distinct")) {
					List<Dictionary> values = new ArrayList<>();
					List<Dictionary> values2 = new ArrayList<>();
					List<Dictionary> values3 = new ArrayList<>();

					values = getIfPresentName(search);
					values2 = getIfPresentPartOfSpeech(search1);

					values.retainAll(values2);
					values3 = removeDuplicates(values);

					if (values2.isEmpty()) {
						System.out.println("<2nd argument must be a part of speech or \"distinct\">");
					}
					else if (values.isEmpty()) {
						System.out.println("<Not Found>");
					}else if (values3.isEmpty()) {
						System.out.println("<Not Found>");
					} else {
						values3.forEach(System.out::println);
					}
					

				} else {
					System.out.println("<3rd argument must be \"distinct\">");
				}
				System.out.println("|");
			}
		}
		scan.close();
	}
	
	public static List<Dictionary> getIfPresentName(String name) {
		List<Dictionary> response = new ArrayList<>();
		for (Dictionary inquiry : Dictionary.values()) {
			if (inquiry.getName().equalsIgnoreCase(name)) {
				response.add(inquiry);
			}
		}
		return response;
	}

	public static List<Dictionary> getIfPresentPartOfSpeech(String name) {
		List<Dictionary> response = new ArrayList<>();
		for (Dictionary inquiry : Dictionary.values()) {
			if (inquiry.getPartOfSpeech().equalsIgnoreCase(name)) {
				response.add(inquiry);
			}
		}
		return response;
	}

	public static List<Dictionary> removeDuplicates(List<Dictionary> unique) {
        for (int i = 0; i < unique.size(); i++) {
            for (int j = i + 1; j < unique.size(); j++) {
                if (unique.get(i).checkEquals(unique.get(j))){
                	unique.remove(j);
                    j--;
                }
            }
        }
        return unique;
    }
	
	public static void welcomeMessage() {
		System.out.println("Welcome to our interactive dictionary! The search has a limit of up to three terms.");
		System.out.println("The first word can be any word you would like a complete entry for. If a second word is ");
		System.out.println("typed in, it must a \"part of speech\" or the word \"distinct\", to pull all unique entries ");
		System.out.println("of the first word. Finally, if a third word is entered it must be \"distinct\". Have fun :)");
		System.out.println();
	}
}
