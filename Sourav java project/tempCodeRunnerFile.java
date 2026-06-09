import java.util.*;

class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return title + " - " + artist;
    }
}

class Playlist {
    private ArrayList<Song> songs;

    public Playlist() {
        songs = new ArrayList<>();
    }

    public void addSong(String title, String artist) {
        songs.add(new Song(title, artist));
        System.out.println("Song added successfully.");
    }

    public void displayPlaylist() {
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("\n===== PLAYLIST =====");
        int i = 1;

        for (Song song : songs) {
            System.out.println(i + ". " + song);
            i++;
        }
    }

    public void searchSong(String title) {
        boolean found = false;

        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Song Found:");
                System.out.println(song);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Song not found.");
        }
    }

    public void deleteSong(String title) {
        Iterator<Song> iterator = songs.iterator();

        while (iterator.hasNext()) {
            Song song = iterator.next();

            if (song.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                System.out.println("Song deleted successfully.");
                return;
            }
        }

        System.out.println("Song not found.");
    }

    public void sortSongs() {
        songs.sort(Comparator.comparing(Song::getTitle));

        System.out.println("Playlist sorted alphabetically.");
    }

    public void shufflePlaylist() {

        Random random = new Random();

        for (int i = songs.size() - 1; i > 0; i--) {

            int j = random.nextInt(i + 1);

            Song temp = songs.get(i);
            songs.set(i, songs.get(j));
            songs.set(j, temp);
        }

        System.out.println("Playlist shuffled successfully.");
    }

    public int getTotalSongs() {
        return songs.size();
    }
}

public class MusicPlaylistManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Playlist playlist = new Playlist();

        int choice;

        do {

            System.out.println("\n==============================");
            System.out.println(" MUSIC PLAYLIST MANAGEMENT ");
            System.out.println("==============================");

            System.out.println("1. Add Song");
            System.out.println("2. Display Playlist");
            System.out.println("3. Search Song");
            System.out.println("4. Delete Song");
            System.out.println("5. Sort Songs");
            System.out.println("6. Shuffle Playlist");
            System.out.println("7. Total Songs");
            System.out.println("8. Exit");

            System.out.print("Enter Choice: ");

            try {

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Song Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Artist Name: ");
                        String artist = sc.nextLine();

                        playlist.addSong(title, artist);

                        break;

                    case 2:

                        playlist.displayPlaylist();

                        break;

                    case 3:

                        System.out.print("Enter Song Title to Search: ");
                        String searchTitle = sc.nextLine();

                        playlist.searchSong(searchTitle);

                        break;

                    case 4:

                        System.out.print("Enter Song Title to Delete: ");
                        String deleteTitle = sc.nextLine();

                        playlist.deleteSong(deleteTitle);

                        break;

                    case 5:

                        playlist.sortSongs();

                        break;

                    case 6:

                        playlist.shufflePlaylist();

                        break;

                    case 7:

                        System.out.println("Total Songs: "
                                + playlist.getTotalSongs());

                        break;

                    case 8:

                        System.out.println("Thank You!");

                        break;

                    default:

                        System.out.println("Invalid Choice.");
                }

            } catch (InputMismatchException e) {

                System.out.println("Please enter a valid number.");
                sc.nextLine();
                choice = 0;
            }

        } while (choice != 8);

        sc.close();
    }
}