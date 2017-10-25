/*

    * This programs uses search api
    * To accept a user input field
      @return a console response as text
      @author Gcobani Mkontwana
      @ date 12 October 2017
*/


import java.util.*;

class TextSearch1 {
	public static void main(String[] args){
		TextSearch1 searcher = new TextSearch1();
		Scanner input = new Scanner(System.in);
		String[] phrases = {
			"Users", 
			"User Groups", 
			"User Activity Log", 
			"Report Designer", 
			"Report Activity Log"};

		while(true){
			String result = "";
			String searchText = input.nextLine();
			String[] query = searchText.split(" ");
			
			for (String phrase : phrases) {
				result += searcher.search(query[0], phrase);
			}

			if(result.length() > 0 && query.length > 1){
				for (int i = 1; i <  query.length; ++i) {
				
					String[] resultList = result.split(", ");
					
					result = "";
					for(String phrase : resultList){
						String[] phraseFrag = phrase.split(" ");
						boolean matches = false;
						
						for (String p : phraseFrag ) {
							String temp = searcher.search(query[i], p);	
							if(temp.length() > 0){
								matches = true;
							}
						}

						if(matches){
							result += phrase + ", ";
						}
					}
				}
			}

			System.out.println(result);
		}
	}
        
        /*
           * Method to search for an index of Aray list
            * As camel case, nor does not accept upper case.
            @param query as a phrase.
        */
	public String search(String query, String phrase){
		String result = "";
		
		if(phrase.toLowerCase().startsWith(query.toLowerCase())){
				result += phrase + ", ";
		}
		return result;
	}
}
