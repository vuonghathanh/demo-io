import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainThread {
    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        Student student;

        try{
            while (true){
                System.out.println("    1.Luu thong tin sinh vien vao file. ");
                System.out.println("    2.In thong tin sinh vien tu file ra. ");
                System.out.println("    3.Thoat.        ");
                System.out.println("-------------------------------------------");
                System.out.print("Choice = ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice){
                    case 1:
                        System.out.print("Nhap ten file can luu: ");
                        String fileOutPut = scanner.nextLine();
                        System.out.print("Nhap id sinh vien: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nhap ten sinh vien: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhap dia chi sinh vien: ");
                        String address = scanner.nextLine();
                        System.out.print("Nhap so dien thoai: ");
                        String phone = scanner.nextLine();
                        System.out.print("Nhap email: ");
                        String email = scanner.nextLine();
                        student = new Student(id,name,address,phone,email);
                        studentArrayList.add(student);
                        FileOutputStream fileOutputStream = new FileOutputStream(fileOutPut,true);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                        objectOutputStream.writeObject(studentArrayList);
                        objectOutputStream.close();

                        break;
                    case 2:
                        System.out.print("Nhap ten file muon in thon tin: ");
                        String fileInPut = scanner.nextLine();
                        FileInputStream fileInputStream = new FileInputStream(fileInPut);
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                        studentArrayList = (ArrayList<Student>) objectInputStream.readObject();
                        for (int i = 0; i < studentArrayList.size(); i++) {
                            System.out.println(studentArrayList.get(i).toString());
                        }
                        objectInputStream.close();
                        break;
                    case 3:
                        System.out.println("Tam biet!!!");
                        break;
                    default:
                        break;
                }
                if (choice == 3){
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }



//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Hello IO");
//        System.out.println("Nhap ten file muon luu: ");
//        String fileName = scanner.nextLine();
//        System.out.println("Nhap noi dung can luu: ");
//        String fileContent = scanner.nextLine();

//        //ghi file
//        File file = new File(fileName);
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        fileOutputStream.write(fileContent.getBytes());
//        fileOutputStream.close();
//
          //doc file
//        //File file = new File("hello.txt");
//        System.out.println("Noi dung file la: ");
//        FileInputStream fileInputStream = new FileInputStream(file);
//        int result = 0;
//        while ((result = fileInputStream.read()) != -1){
//            System.out.print((char) result);
//        }
//        fileInputStream.close();
    }
}
