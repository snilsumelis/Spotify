import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        /*
        HashMap<Integer,Song> song = new HashMap<Integer,Song>();
        HashMap<Integer,Person> person = new HashMap<Integer,Person>();
        LinkedList<Song> songList = new LinkedList<Song>();
        LinkedList<Person> personList = new LinkedList<Person>();
        Song sarkı = new Song();
        Song sarkı2 = new Song();
        Song sarkı3 = new Song();
        sarkı.SongName = "Still Loving You";
        sarkı2.SongName = "Forget Her";
        sarkı3.SongName = "She's Gone";
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        person1.PersonName = "Nilsu";
        person2.PersonName = "Melis";
        person3.PersonName = "İrem";
        songList.add(0,sarkı);
        songList.add(0,sarkı2);
        songList.add(0,sarkı3);
        for(int i =0; i<songList.size();i++){
            song.put(i,songList.getNodeData(i));
        }
        personList.add(0,person1);
        personList.add(0,person2);
        personList.add(0,person3);
        for(int i =0; i<personList.size();i++){
            person.put(i,personList.getNodeData(i));
        }
        //System.out.println(song);
        //System.out.println(person);
        */
        ReadAndOperations operations = new ReadAndOperations();
        if(operations.Output()){
            operations.readFiles();
        }

    }
}