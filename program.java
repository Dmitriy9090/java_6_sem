// • Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// • Создать множество ноутбуков.
// • Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
// Критерии фильтрации можно хранить в Map. Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// • Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// • Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

class Laptop {

    private String name;
    private int ram;
    private int storageCap;
    private String os;
    private String color;
    private double diagonal;

    public Laptop(String name, int ram, int storageCap, String os, String color, double diagonal){
        this.name = name;
        this.ram = ram;
        this.storageCap = storageCap;
        this.os = os;
        this.color = color;
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return String.format("Название: %s \n Объем оперативной памяти: %d Гб \n Объем накопителя %d Гб \n ОС %s \n Цвет %s \n Диагональ %.1f \n",
                this.name, this.ram, this.storageCap, this.os, this.color, this.diagonal);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Laptop) {
            return this.name.equals(((Laptop) obj).name) && this.ram == ((Laptop) obj).ram
                    && this.storageCap == ((Laptop) obj).storageCap && this.os.equals(((Laptop) obj).os)
                    && this.color.equals(((Laptop) obj).color) && this.diagonal == ((Laptop) obj).diagonal;
        }
        return false;
    }

    public int getRam(){
        return this.ram;
    }

    public int getStorageCap(){
        return this.storageCap;
    }

    public String getOS(){
        return this.os;
    }

    public double getDiagonal(){
        return this.diagonal;
    }
}

class Application {
    public static void main(String[] args) {
        List<Laptop> laptops = new ArrayList<>();
        Map<Integer, String> criteria = new HashMap<>();

        Laptop laptop0 = new Laptop("ASUS Vivobook Go 15", 8, 512, "Windows 11", "серый", 15.6);
        Laptop laptop1 = new Laptop("Lenovo IdealPad 15", 8, 256, "Windows 11", "синий", 15.6);
        Laptop laptop2 = new Laptop("Honor MagicBook 16", 16, 512, "без ОС", "серый", 16.1);
        Laptop laptop3 = new Laptop("Apple MacBook Air 13", 8, 256, "MacOs", "золотистый", 13.3);
        Laptop laptop4 = new Laptop("HP 250 G7", 8, 1024, "без ОС", "черный", 15.6);
        Laptop laptop5 = new Laptop("MSI GF76 Katana 17", 8, 256, "без ОС", "чёрный", 17.3);
        Laptop laptop6 = new Laptop("IRBIS NB290", 4, 128, "Windows 10", "чёрный", 15.6);
        Laptop laptop7 = new Laptop("ASUS Laptop 15", 4, 1000, "Windows 10", "чёрный", 15.6);
        Laptop laptop8 = new Laptop("Acer Extensa 15", 4, 256, "Windows 11", "чёрный", 15.6);
        laptops.add(laptop0);
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop4);
        laptops.add(laptop5);
        laptops.add(laptop6);
        laptops.add(laptop7);
        laptops.add(laptop8);

        criteria.put(1, "объем оперативной памяти");
        criteria.put(2, "объем накопителя");
        criteria.put(3, "ОС");
        criteria.put(4, "цвет");
        criteria.put(5, "диагональ");

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите желаемые характеристики:\n1. Объем оперативной памяти: ");
        int searchRam = sc.nextInt();
        System.out.println("2. Объем накопителя: ");
        int searchStorage = sc.nextInt();
        System.out.println("3. Диагональ");
        double searchDiagonal = sc.nextDouble();

        List<Laptop> results = new ArrayList<>();

        for(Laptop laptop: laptops) {
            if ((laptop.getRam() >= searchRam) && (laptop.getStorageCap() >= searchStorage)  && laptop.getDiagonal() >= searchDiagonal) {
                results.add(laptop);
            }
        }

        if (results.size() > 0) {
            System.out.println("Найдено " + results.size() + " ноутбуков. Результаты поиска:\n");
            for(Laptop laptop: results) {
                System.out.println(laptop);
            }
            System.out.println("Поиск завершён.");
        } else {
            System.out.println("Поиск завершён. Результатов не найдено.");
        }

sc.close();
    }
}