import java.util.Arrays;
import java.util.Scanner;
import  java.lang.String;

class lake {
    String place;
    String name;

    int area;

    public static int compareLakes(lake_1 a , lake_1 b)
    {
        return a.name.compareTo(b.name);
    }

    @Override
    public String toString() {
        return "Назва озера: " + name + "\t";
    }
}

public class lab1_2 {
    public static lake_1[] lakess(int np) {
        Scanner ns = new Scanner(System.in, "UTF-8");
        lake_1[] lake_1s = new lake_1[np];
        System.out.println("Введіть характеристики озер:");
        for (int i = 0; i < lake_1s.length; i++) {
            lake_1s[i] = new lake_1();

            System.out.println("Назва " + (i + 1) + " озера: ");
            lake_1s[i].name = ns.nextLine();

            System.out.println("Місце розташування " + (i + 1) + " озера: ");
            lake_1s[i].place = ns.nextLine();

            System.out.println("Площа " + (i + 1) + " озера: ");
            lake_1s[i].area = ns.nextInt();

            ns.nextLine();
        }
        return lake_1s;
    }

    public static void showArray(lake_1[] lake_1s) {
        for (int i = 0; i < lake_1s.length; i++) {
            System.out.println((i + 1) + ")" + " Назва: " + lake_1s[i].name + "\t" + "Місце розташування: " + lake_1s[i].place + "\t" + "Площа: " + lake_1s[i].area);
        }
    }

    public static void showLake(lake_1 lake_1) {
        System.out.println("Назва: " + lake_1.name + "\tМісце розташування: " + lake_1.place + "\tПлоща: " + lake_1.area);
    }

    public static int NumMax(lake_1[] lake_1s) {
        int maxnum = 0;
        int max = lake_1s[maxnum].area;
        for (int i = 0; i < lake_1s.length; i++) {
            if (lake_1s[i].area > max) {
                max = lake_1s[i].area;
                maxnum = i;
            }
        }
        return maxnum;
    }

    public static double avgSize(lake_1[] lake_1s) {
        int average = 0;
        int count = 0;
        int mincount = 0;
        for (int i = 0; i < lake_1s.length; i++) {
            count++;
            average += lake_1s[i].area;
        }
        for (int i = 0; i < lake_1s.length; i++) {
            if(lake_1s[i].area < (average / count))
                mincount++;
        }
        return mincount;
    }

    public static void sortArr(lake_1[] lake_1s) {
        Arrays.sort(lake_1s, lake_1::compareLakes);
        Arrays.asList(lake_1s).forEach(System.out::println);
    }

    public static lake_1 arraySearch(lake_1[] lake_1s, String name) {
        int num = -1;
        for (int i = 0; i < lake_1s.length; i++) {
            if (name.equalsIgnoreCase(lake_1s[i].name)) num = i;
        }
        if (num != -1) {
            return lake_1s[num];
        } else return null;
    }

    public static void arrayEdit(lake_1[] lake_1s, int editind, int editint) {
        Scanner ed = new Scanner(System.in, "UTF-8");

        for (int i = 0; i < lake_1s.length; i++) {
            if (i == editind) {
                System.out.println((editind + 1) + ")" + " Назва: " + lake_1s[editind].name + " " + "Місце розташування: " + lake_1s[editind].place + " " + "Площа: " + lake_1s[editind].area);
            }
        }

        switch (editint) {
            case 1 -> {
                System.out.println("На що змінюємо: ");
                lake_1s[editind].name = ed.nextLine();
            }
            case 2 -> {
                System.out.println("На що змінюємо: ");
                lake_1s[editind].place = ed.nextLine();
            }
            case 3 -> {
                System.out.println("На що змінюємо: ");
                lake_1s[editind].area = ed.nextInt();
            }
        }
    }

    public static void main(String[] args) {

        Scanner ns = new Scanner(System.in, "UTF-8");
        System.out.println("Введіть кількість озер: ");
        int n = ns.nextInt();
        lake_1[] lake_1s = lakess(n);
        System.out.println("\nХарактеристика озер");
        showArray(lake_1s);

        ns.nextLine();

        int nummax = NumMax(lake_1s);
        System.out.println("Найбільше озеро: ");
        showLake(lake_1s[nummax]);

        ns.nextLine();

        System.out.println("Кількість озер із площею меншу за середню: " + avgSize(lake_1s));

        ns.nextLine();

        System.out.println("\nВідсортований масив\n");
        sortArr(lake_1s);

        ns.nextLine();

        System.out.println("Введіть назву озера");
        String Sname = ns.nextLine();
        lake_1 pfind = arraySearch(lake_1s, Sname);
        if (pfind != null) {
            showLake(pfind);
        } else {
            System.out.println("Такого озера немає");
        }

        ns.nextLine();

        System.out.println("Редагування, який запис редагуємо?\n");
        showArray(lake_1s);
        int editind = ns.nextInt() - 1;
        System.out.println("Що саме редагуємо? введіть номер: \t 1) Назва \t 2) Місце розташування \t 3) Площа");
        int editint = ns.nextInt();
        arrayEdit(lake_1s, editind, editint);
        showLake(lake_1s[editind]);
    }
}
