package demo;
import java.util.*;

public class Shows {
    Map<String,Pair> treemap= new TreeMap<>();
    String movies[], theaters[];
    int available[];

    public void updateShows(String movies[], String theaters[], int available[]){
        for(int i=0;i<movies.length;i++){
            treemap.put(movies[i], new Pair(theaters[i],available[i]));
        }
        this.movies= movies.clone();
        this.theaters= theaters.clone();
        this.available= available.clone();
    }
    public void showMovie(){
        for(int i=0;i<treemap.size();i++){
            Pair p= treemap.get(movies[i]);
            System.out.println("Movie: "+ movies[i] +", Theater: "+ p.theater+", Available seats: "+ p.availability);
        }
    }
    public void showDetails(String film){
        Pair p= treemap.get(film);
        System.out.println("Theater: "+ p.theater);
        System.out.print("Available seats: "+ p.availability);
    }
    public boolean bookIfAvailable(String movie, int n){
        if(treemap.containsKey(movie)){
            Pair p= treemap.get(movie);
            if(p.availability>=n){
                p.availability-=n;
                System.out.println(p.availability);
                treemap.put(movie, new Pair(p.theater,p.availability));
                return true;
            }
            else
                return false;
        }
        return false;
    }
}
class Pair{
    String theater;
    int availability;
    Pair(String theater, int availability){
        this.theater= theater;
        this.availability=availability;
    }
}