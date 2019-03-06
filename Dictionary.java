import java.util.Objects;

public enum Dictionary {
	PLACEHOLDER1("To be updated...", "placeholder", "adjective"),
	PLACEHOLDER2("To be updated...", "placeholder", "adjective"),
	PLACEHOLDER3("To be updated...", "placeholder", "adverb"),
	PLACEHOLDER4("To be updated...", "placeholder", "conjunction"),
	PLACEHOLDER5("To be updated...", "placeholder", "interjunction"),
	PLACEHOLDER6("To be updated...", "placeholder", "noun"),
	PLACEHOLDER7("To be updated...", "placeholder", "noun"),
	PLACEHOLDER8("To be updated...", "placeholder", "noun"),
	PLACEHOLDER9("To be updated...", "placeholder", "preposition"),
	PLACEHOLDER10("To be updated...", "placeholder", "pronoun"),
	PLACEHOLDER11("To be updated...", "placeholder", "verb"),
	CSC2101("Comfortable with Objects and Classes", "CSC210", "adjective"),
	CSC2102("Ready for CSC 220", "CSC210", "adjective"),
	CSC2103("Intro to Java", "CSC210", "noun"), 
	CSC2104("To learn Java", "CSC210", "verb"),
	CSC2201("Ready to create complex data structures.", "CSC220", "adjective"),
	CSC2202("Data Structures.", "CSC220", "noun"),
	CSC2203("To create data structures.", "CSC220", "verb"),
	CSC3401("C++ version of CSC210 + CSC220 + more.", "CSC340", "adjective"),
	CSC3402("A CS upper division course.", "CSC340", "noun"),
	CSC3403("Many hours outside of class.", "CSC340", "noun"),
	CSC3404("Programming Methodology.", "CSC340", "noun"),
	VERB("Verb is a word or group of words that expresses", "verb", "noun"),
	BOOK1("A set of pages.", "book", "noun"),
	BOOK2("A written work published in printed or electronic form.", "book", "noun"),
	BOOK3("To arrange for someone to have a seat on a plane.", "book", "verb"),
	BOOK4("To arrange something on a particular date.", "book", "verb"),
	INTERJECTION(
			"Interjection is a short sound, word or phrase spoken suddenly to express an emotion. Oh!, Look out! and Ow! are interjections.",
			"interjection", "noun"),
	ADJECTIVE(
			"Adjective is a word that describes a person or thing, for example big, red and clever in a big house, red wine and a clever idea.",
			"adjective", "noun"),
	ARROW("Here is one arrow: -=>> </iIMG>", "Arrow", "noun"),
	ADVERB("Adverb is a word that adds more information about place, time, manner, cause or degree to a verb, an adjective, a phrase, or another adverb",
			"Adverb", "noun"),
	NOUN("Noun is a word that refers to a person, (such as Ann or doctor), a place (such as Paris or city) or a thing, a quality or an activity (such as plants, sorrow or tennis).",
			"Noun", "noun"),
	DISTINCT1("Familiar. Worked in Java.", "Distinct", "adjective"),
	DISTINCT2("Unique. No duplicates. Clearly different or of a different kind.", "Distinct", "adjective"),
	DISTINCT3("Uniquely. Written\"distinctly\".", "Distinct", "adverb"),
	DISTINCT4("A keyword in this assignment.", "Distinct", "noun"),
	DISTINCT5("A keyword in this assignment.", "Distinct", "noun"),
	DISTINCT6("A keyword in this assignment.", "Distinct", "noun"),
	DISTINCT7("An advanced search option.", "Distinct", "noun"),
	DISTINCT8("Distinct is a parameter in this assignment.", "Distinct", "noun");
	
	
	private String definition;
	private String name;
	private String partOfSpeech;

	private Dictionary(String definition, String name, String partOfSpeech) {
		this.definition = definition;
		this.name = name;
		this.partOfSpeech = partOfSpeech;
		
	}

	public String getDefinition() {
		return definition;
	}

	public String getName() {
		return name;
	}

	public String getPartOfSpeech() {
		return partOfSpeech;
	}
	
	public boolean checkEquals(Object o) {
		if (o==this) return true;
		if (!(o instanceof Dictionary)) {
			return false;
		}
		Dictionary dictionary = (Dictionary) o;
		return Objects.equals(definition, dictionary.definition) && 
				Objects.equals(name, dictionary.name) &&
				Objects.equals(partOfSpeech, dictionary.partOfSpeech);
	}
	
	//public int hashCode() {
		//return Objects.hash(definition, name,partOfSpeech);
	//}

	public String toString() {
		String output = this.name.substring(0, 1).toUpperCase() + this.name.substring(1);
		return output + " [" + this.partOfSpeech + "] : " + this.definition;
	}
}
