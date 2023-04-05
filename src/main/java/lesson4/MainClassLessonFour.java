package lesson4;

import java.util.*;

public class MainClassLessonFour {
    public static void main(String[] args) {
//        countTimeAddElements();
        enterAndPrintElemOfLinkList();
    }

    private static void enterAndPrintElemOfLinkList() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите текст и позицию в формате text ~ num: ");
//        String text = scanner.nextLine();
//        scanner.close();


//        String [] arr = text.split("\\~");
        List <String> linkList = new LinkedList<>();

//        int position = Integer.parseInt(arr[1]);
        boolean flag = true;
        while (flag){
            Scanner iscanner = new Scanner(System.in);
            System.out.println("Введите текст и позицию в формате text ~ num: ");
            String itext = iscanner.nextLine();
            String [] iarr = itext.split("\\~");
            int position = Integer.parseInt(iarr[1]);
            switch (iarr[0]) {
                case "print" -> {
                    if (position >= linkList.size()) {
                        System.out.println("Нет указанной позиции");
                        break;
                    }
                    System.out.println(linkList.get(position));
                    linkList.remove(position);
                }
                case "delete" -> {
                    if (position >= linkList.size()) {
                        System.out.println("Нет указанной позиции");
                        break;
                    }
                    linkList.remove(position);
                }
                case "end" -> flag = false;
                case "show" -> {
                    System.out.println(linkList);
                }

                default -> {
                    if (position > linkList.size()) {
                        int countAdd = position - linkList.size();
                        for (int i = linkList.size(); i < position; i++) {
                            linkList.add(null);
                        }
                        linkList.add(iarr[0]);
                    }
                    else {
                        linkList.set(position, iarr[0]);
                    }
                    System.out.println(linkList);
                }
            }
        }
//        if (arr[0] == "print") {
//            if(position >= linkList.size()) {
//                System.out.println("Нет указанной позиции");
//                return;
//            }
//            System.out.println(linkList.get(position));
//            return;
//        }
//        if (arr[0] == "delete") {
//            if(position >= linkList.size()) {
//                System.out.println("Нет указанной позиции");
//                return;
//            }
//            linkList.remove(position);
//        }

//        if (position > linkList.size()) {
//            int countAdd = position - linkList.size();
//            for (int i = linkList.size(); i < countAdd; i++) {
//                linkList.add(null);
//            }
//            linkList.add(arr[0]);
//        }
        System.out.println(linkList);
    }



    private static void countTimeAddElements() {
        int size = 100_000;
        Random random = new Random();
        long start = System.currentTimeMillis();
        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
//            arrList.add(random.nextInt());
            arrList.add(0, random.nextInt());
        }
        System.out.println(System.currentTimeMillis()-start);

        start = System.currentTimeMillis();
        List<Integer> linkList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
//            linkList.add(random.nextInt());
            linkList.add(0, random.nextInt());
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
