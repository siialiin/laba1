import java.util.Arrays;
import java.util.Scanner;
import java.lang.String;


class lake_1 {
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

public class lab1_1 {
    public static void main(String[] args) {
        Scanner ns = new Scanner(System.in, "UTF-8");
        System.out.println("Створимо ваш список озер!");
        System.out.println("Введіть кількість озер:");
        int np = ns.nextInt();
        lake_1[] lake_1s = new lake_1[np];
        System.out.println("Введіть характеристики озер:");
        for (int i = 0; i < lake_1s.length; i++) {
            ns.nextLine();
            lake_1s[i] = new lake_1();
            System.out.println("Назва " + (i + 1) + " озера: ");
            lake_1s[i].name = ns.nextLine();
            System.out.println("Місце розташування " + (i + 1) + " озера: ");
            lake_1s[i].place = ns.nextLine();
            System.out.println("Площа " + (i + 1) + " озера: ");
            lake_1s[i].area = ns.nextInt();
        }
        for (lake_1 peo : lake_1s) {
            System.out.println("Назва: " + peo.name + "\n" + "Місце розташування: " + peo.place + "\n" + "Площа: " + peo.area + " см/кв\n" + "\n\n");
        }

        System.out.println("В цій частині ми визначаємо найбільше озеро");
        ns.nextLine();
        int maxnum = 0;
        int max = lake_1s[maxnum].area;
        for (int i = 0; i < lake_1s.length; i++) {
            if (lake_1s[i].area > max) {
                max = lake_1s[i].area;
                maxnum = i;
            }
        }
        System.out.println("Найбільшe озеро: \n\n");
        System.out.println(lake_1s[maxnum].name + " " + lake_1s[maxnum].place + " " + lake_1s[maxnum].area + "\n\n");

        System.out.println("В цій частині йде розрахунок озер із площею менншу за середню.");
        ns.nextLine();
        double average = 0;
        int count = 0;
        int mincount = 0;
        for (int i = 0; i < lake_1s.length; i++) {
            count++;
            average += lake_1s[i].area;
        }
        System.out.println("Середня площа серед озер: " + (average / count) + "\n\n");
        for (int i = 0; i < lake_1s.length; i++) {
            if(lake_1s[i].area < (average / count))
                mincount++;
        }
        System.out.println("Кількість озер із площею меншу за середню: " + mincount + "\n\n");


        System.out.println("В цій частині ми сортуємо масив за назвою");
        Arrays.sort(lake_1s, lake_1::compareLakes);
        Arrays.asList(lake_1s).forEach(System.out::println);

        System.out.println("Пошук по масиву");
        ns.nextLine();
        System.out.println("Введіть назву озера: ");
        String name = ns.nextLine();
        int num = -1;
        for (int i = 0; i < lake_1s.length; i++) {
            if (name.equalsIgnoreCase(lake_1s[i].name))
                num = i;
        }
        if (num != -1) {
            System.out.println("Таке озеро є у списку. Це: " + lake_1s[num].name + " " + lake_1s[num].place + " " + lake_1s[num].area);
        } else System.out.println("Такої людини немає");

        System.out.println("Редагування записів у масиві");
        ns.nextLine();
        for (int i = 0; i < lake_1s.length; i++) {
            System.out.println((i + 1) + ")" + " Назва: " + lake_1s[i].name + " " + "Місце розташування: " + lake_1s[i].place + " " + "Площа: " + lake_1s[i].area);
        }
        System.out.println("Який запис редагуємо? введіть номер: ");
        int editind = ns.nextInt() - 1;
        for (int i = 0; i < lake_1s.length; i++) {
            if (i == editind) {
                System.out.println((editind + 1) + ")" + " Назва: " + lake_1s[editind].name + " " + "Місце розташування: " + lake_1s[editind].place + " " + "Площа: " + lake_1s[editind].area);
            } else {
                System.out.println("індекс введено неправильно або такого номеру елементу не існує");
            }
        }
        ns.nextLine();
        System.out.println("Що саме редагуємо? введіть номер: \t 1) Назва \t 2) Місце розташування \t 3) Площа");
        int editint = ns.nextInt();
        switch (editint) {
            case 1:
                ns.nextLine();
                System.out.println("На що змінюємо: ");
                lake_1s[editind].name = ns.nextLine();
                break;
            case 2:
                ns.nextLine();
                System.out.println("На що змінюємо: ");
                lake_1s[editind].place = ns.nextLine();
                break;
            case 3:
                ns.nextLine();
                System.out.println("На що змінюємо: ");
                lake_1s[editind].area = ns.nextInt();
                break;
        }
        System.out.println("Змінена інформація про озеро: ");
        System.out.println("Назва: " + lake_1s[editind].name + " " + "Місце розташування: " + lake_1s[editind].place + " " + "Площа: " + lake_1s[editind].area);
    }
}
