package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            if ( args.length >= 1 ) {
                if ( args[0].compareTo( "-a" )== 0 ) {
                   append_file();
                }
                else if ( args[0].compareTo( "-p" )== 0 ) {
                    // Prints data file
                    print_file();
                }
                else if ( args[0].compareTo( "-d" )== 0 ) {
                    // Delete data file
                    delete_file();
                }
                else {
                    System.err.println( "Option is not realised: " + args[0] );
                    System.exit(1);
                }
            }
            else {
                System.err.println( "Staff: Nothing to do!" );
            }
        }
        catch ( Exception e ) {
            System.err.println( "Run/time error: " + e );
            System.exit(1);
        }
        System.out.println( "Staff finished..." );
        System.exit(0);
    }

    static final String filename = "Staff.dat";

    private static Scanner fin = new Scanner( System.in );

    static Employee read() {
        if ( fin.hasNextLine()) {
            return Employee.read(fin);
        }
        return null;
    }

    static void delete_file() {
        File file = new File( filename );
        file.delete();
        System.out.println("Файл удален!");
    }

    static void append_file() throws FileNotFoundException, IOException {
        Employee employee;
        System.out.println( "Enter employee data: " );
        System.out.println("Табельный номер: ");
        try ( RandomAccessFile raf = new RandomAccessFile( filename, "rw" )) {
            while (( employee = read())!= null ) {
                Buffer.writeObject( raf, employee );
                System.out.println("Данные для одного сотрудника записаны. Хотите продолжить?\n" +
                        "1. Введите s, если хотите продолжить ввод\n" +
                        "2. Введите q, если хотите завершить ввод");
                switch (fin.nextLine()){
                    case "q":
                        System.out.println("Ввод завершен");
                        System.exit(0);
                        break;
                    case "s":
                        System.out.println("Табельный номер: ");
                        break;
                    default:
                        throw new IOException("Неправильный символ для ввода/выхода");
                }

            }
        }
    }
    static void print_file()
            throws FileNotFoundException, IOException, ClassNotFoundException {
        try ( RandomAccessFile raf = new RandomAccessFile( filename, "rw" )) {
            long pos;
            while (( pos = raf.getFilePointer()) < raf.length() ) {
                Employee employee = (Employee) Buffer.readObject( raf, pos );
                System.out.println( pos + ": " + employee );
            }
        }
    }
}
