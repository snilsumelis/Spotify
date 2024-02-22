import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class ReadAndOperations {
    HashMap personHashMap = new HashMap();
    HashMap songHashMap = new HashMap();
    LinkedList<Person> personList = new LinkedList<Person>();
    LinkedList<Song> songList = new LinkedList<Song>();
    LinkedList<Integer> sameElement = new LinkedList<Integer>();
    Person person;
    Song song;
    String pathName = "C:\\Users\\snils\\IdeaProjects\\Spotify\\input.txt";
    public void readFiles() throws FileNotFoundException {
        File file = new File(pathName);
        Scanner scan = new Scanner(file);
        String s = "";
        int personCount = 0;
        int songCount = 0;
        while(scan.hasNextLine()){
            s = scan.nextLine();
            System.out.println(s);
            if(s.charAt(0) == 'I'){
                person = new Person();
                person.PersonName =s.substring(2);
                personList.add(personCount,person);
                //int personMapCount = 0;
                personHashMap.put(personCount, personList.getNodeData(personCount).PersonName);
                personCount++;
            }
            else if (s.charAt(0) == 'L') {
                person = new Person();
                song = new Song();
                String[] parts = s.split(" ");
                StringBuilder newString = new StringBuilder();
                //System.out.println(parts[1]);
                person.PersonName = parts[1];
                int no = personList.searchNode(person);
                //System.out.println(no);
                sameElement.add(songCount,no);
                //sameElement.Output();

                //System.out.println(no);
                for(int i=2;i< parts.length;i++){
                    newString.append(parts[i]).append(" ");
                }
                song.SongName = newString.toString();
                songList.add(songCount,song);
                songHashMap.put(no, songList.getNodeData(songCount).SongName);
                songCount++;
            }
            else if (s.charAt(0) == 'E') {
                person = new Person();
                song = new Song();
                String[] parts = s.split(" ");
                StringBuilder newString = new StringBuilder();
                //System.out.println(parts[1]);
                person.PersonName = parts[1];
                //System.out.println(parts[1]);
                int no = personList.searchNode(person);
                //System.out.println(no);
                sameElement.add(songCount,no);
                //sameElement.Output();
                //System.out.println(no);
                for(int i=2;i< parts.length;i++){
                    newString.append(parts[i]).append(" ");
                }
                //System.out.println(newString);
                int x = songHashMap.get(no, newString.toString());
                //System.out.println(x);
                songHashMap.remove(x);
                /*
                for(int i =no;i<=100;i+=10){
                    personHashMap.remove(no);
                }
                 */
            }
            else if (s.charAt(0) == 'D') {
                person = new Person();
                person.PersonName =s.substring(2);
                int index = personList.searchNode(person);
                personList.remove(index);
                personHashMap.remove(index);
            }
            else if (s.charAt(0) == 'P') {
                person = new Person();
                person.PersonName =s.substring(2);
                int index = personList.searchNode(person);
                findSong(index);
                //System.out.println(index);
            }
            else if (s.charAt(0) == 'M') {

            }
            else if (s.charAt(0) == 'R') {

            }
            else if (s.charAt(0) == 'O') {
                //Output methodu ve main ile bu işlem gerçekleştirilmiştir.
            }
            else if (s.charAt(0) == 'X') {
                break;
            }
        }
        System.out.println("*****************************");
        System.out.print(personHashMap);
        System.out.println("*****************************");
        System.out.println(songHashMap);

    }
    public void findSong(int number) throws FileNotFoundException {
        File file = new File(pathName);
        Scanner scan = new Scanner(file);
        String s = "";
        while(scan.hasNextLine()){
            s = scan.nextLine();
            if(s.charAt(0)=='L'){
                person = new Person();
                song = new Song();
                String[] parts = s.split(" ");
                StringBuilder newString = new StringBuilder();
                person.PersonName = parts[1];
                int no = personList.searchNode(person);
                if(number==no){
                    for(int i=2;i< parts.length;i++){
                        newString.append(parts[i]).append(" ");
                    }
                    System.out.print(newString+" ");
                }
            }
        }
        System.out.print("\n");
    }
    public void writeFiles() throws FileNotFoundException {
        File file = new File(pathName);
        Scanner scan = new Scanner(file);
        String s = "";
        while(scan.hasNextLine()){
            s = scan.nextLine();
            if(s.charAt(0)=='O'){
                System.out.print("Enter a file name:");
                Scanner scanner = new Scanner(System.in);
                Scanner scanner2 = new Scanner(System.in);
                String fileName = scanner.nextLine();
                System.out.print("Enter a file directory:");
                String directory = scanner2.nextLine();
                try{
                    File dosya = new File("C:\\Gecici\\scanner.txt");
                    FileWriter yazici = new FileWriter(file);
                    BufferedWriter yaz = new BufferedWriter(yazici);
                    //yaz.write();
                    yaz.close();
                    System.out.println("Yazma İşlemi Başarılı");
                }
                catch(Exception hata){
                    hata.printStackTrace();
                }
            }
        }
    }
    public boolean Output() throws FileNotFoundException{
        File file = new File(pathName);
        boolean temp = false;
        Scanner scan = new Scanner(file);
        String s = "";
        while(scan.hasNextLine()){
            s = scan.nextLine();
            if(s.charAt(0)=='O'){
                temp = true;
                return temp;
            }
        }
        return temp;
    }
}
