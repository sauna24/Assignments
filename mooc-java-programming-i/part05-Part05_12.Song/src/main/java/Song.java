
public class Song {

    private String artist;
    private String name;
    private int durationInSeconds;

    public Song(String artist, String name, int durationInSeconds) {
        this.artist = artist;
        this.name = name;
        this.durationInSeconds = durationInSeconds;
    }
    
    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        
        if (!(compared instanceof Song)) { // om "compared" objektket inte är av typen Song, så är objekten inte lika
            return false;
        }
        
        //converterar objektet till ett Song objekt
        Song comparedSong = (Song) compared;
        
        //om objektens variabel värden är samma, så är objekten lika
        if (this.artist.equals(comparedSong.artist) &&
            this.name.equals(comparedSong.name) &&
            this.durationInSeconds == comparedSong.durationInSeconds) {
            return true;
        }
        
        return false; // annars är objekten inte lika
    }

    @Override
    public String toString() {
        return this.artist + ": " + this.name + " (" + this.durationInSeconds + " s)";
    }


}
