package testArea;

import java.util.ArrayList;

public class MovieTest {

    public static void main(String[] args) {
        Movie movie1 = new Movie("Pulp Fiction", 90, "thriller");
        Movie movie2 = new Movie("Lethal weapon", 110, "action");
        Movie movie3 = new Movie("Dumb and dumbr", 89, "comedy");
        
        Movie movies[] = new Movie[3];
        movies[0] = movie1;
        movies[1] = movie2;
        movies[2] = movie3;
        
        String review = "it's ok";
        
        for(int index = 0; index < movies.length; index++) {
        	movies[index].setReview(review);
        	System.out.println("***\n" + movies[index].getMovieSummary());
        }
        
        var list = new ArrayList<Movie>();
        var iterator = list.iterator();
        list.add(movie1);
        list.add(movie2);
        list.add(movie3);
        
        for(int i = 0; i < list.size();i++) {
        	if(i ==	 2) {
        		list.get(i).setTitle("Truman show");
        	}
        	System.out.println(list.get(i).getMovieSummary());
        }
        
//        while(iterator.hasNext()) {
//        	System.out.println(iterator.next().getMovieSummary());
//        }
        
    }
}
