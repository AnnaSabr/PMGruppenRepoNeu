import java.util.Comparator;
import java.util.List;

public class StudentSort {

    /**
     * 1a: Sortiert die Studierendenliste mithilfe eines Lambda-Ausdrucks aufsteigend nach dem
     * Alter.
     *
     * @param students die zu sortierende Liste der Studierenden
     * @return die sortierte Liste mit Studierenden
     */
    public static List<Student> sort_1a(List<Student> students) {
        students.sort((Student student, Student student2)-> student.getBirthday().compareTo(student2.getBirthday()));
        // TODO
        return students;
    }

    /**
     * 1b: Sortiert die Studierendenliste mithilfe eines Lambda-Ausdrucks absteigend nach dem Namen.
     *
     * @param students die zu sortierende Liste der Studierenden
     * @return die sortierte Liste mit Studierenden
     */
    public static List<Student> sort_1b(List<Student> students) {
        students.sort((Student student, Student student2)->(student.getName().compareToIgnoreCase(student2.getName())*-1));
        // TODO
        return students;
    }

    /**
     * 2a: Sortiert die Studierendenliste, mithilfe der compareByAge Methode unter Verwendung eines
     * Lambda-Ausdrucks, aufsteigend nach dem Alter.
     *
     * @param students die zu sortierende Liste der Studierenden
     * @return die sortierte Liste mit Studierenden
     */
    public static List<Student> sort_2a(List<Student> students) {
        students.sort((Student student, Student student2)-> Student.compareByAge(student,student2));
        // TODO
        return students;
    }

    /**
     * 2b: Sortiert die Studierendenliste, mithilfe der compareByAge Methode unter Verwendung einer
     * Methodenreferenz, aufsteigend nach dem Alter.
     *
     * @param students die zu sortierende Liste der Studierenden
     * @return die sortierte Liste mit Studierenden
     */
    public static List<Student> sort_2b(List<Student> students) {
        students.sort(Student::compareByAge);
        // TODO
        return students;
    }

    /**
     * 3a: Sortiert die Studierendenliste, mithilfe der compareByName Methode unter Verwendung eines
     * Lambda-Ausdrucks, aufsteigend nach dem Namen.
     *
     * @param students die zu sortierende Liste der Studierenden
     * @return die sortierte Liste mit Studierenden
     */
    public static List<Student> sort_3a(List<Student> students) {
        students.sort((Student student, Student student2)->student.compareByName(student2));
        // TODO
        return students;
    }

    /**
     * 3b: Sortiert die Studierendenliste, mithilfe der compareByName Methode unter Verwendung einer
     * Methodenreferenz, aufsteigend nach dem Namen.
     *
     * @param students die zu sortierende Liste der Studierenden
     * @return die sortierte Liste mit Studierenden
     */
    public static List<Student> sort_3b(List<Student> students) {
        students.sort(Student::compareByName);
        // TODO
        return students;
    }

    /**
     * 4a: Sortiert die Studierendenliste absteigend nach dem Alter unter Verwendung einer Instanz
     * ihres Funktionsinterfaces.
     *
     * @param students die zu sortierende Liste der Studierenden
     * @return die sortierte Liste mit Studierenden
     */
    public static List<Student> sort_4a(List<Student> students) {
        students.sort((student, student2)->{
            if(student.getBirthday().compareTo(student2.getBirthday())<0){
                return 1;
            } else if (student.getBirthday().compareTo(student2.getBirthday())>0) {
                return -1;
            }else{
                return 0;
            }
        });
        // TODO
        return students;
    }

    /**
     * 4b: Sortiert die Studierendenliste aufsteigend nach dem Name unter Verwendung einer Instanz
     * ihres Funktionsinterfaces.
     *
     * @param students die zu sortierende Liste der Studierenden
     * @return die sortierte Liste mit Studierenden
     */
    public static List<Student> sort_4b(List<Student> students) {
        Vergleich<Student> vergleich = ((student, student2)->{
            if(student.getName().compareToIgnoreCase(student2.getName())>0){
                return 1;
            } else if (student.getName().compareToIgnoreCase(student2.getName())<0) {
                return -1;
            }else{
                return 0;
            }
        });
        // TODO
        students.sort((student, student2)->{
            if(student.getName().compareToIgnoreCase(student2.getName())>0){
                return 1;
            } else if (student.getName().compareToIgnoreCase(student2.getName())<0) {
                return -1;
            }else{
                return 0;
            }
        });
        mySort(students, new Vergleich<Student>() {
            @Override
            public int compare(Student type, Student type2) {
                return 0;
            }
        });
        return students;
    }

    public static <T> void mySort(List<T> liste, Vergleich<T> vergleich){
        //liste.sort(vergleich.compare((type, type2)->()));
    }
}
