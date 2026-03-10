/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mephi.maven1;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;
import org.yaml.snakeyaml.Yaml;
/**
 *
 * @author panda
 */
public class Main {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        Yaml yaml = new Yaml();
        InputStream inputStream = People.class.getClassLoader().getResourceAsStream("yamlPeople.yaml");
        People data = yaml.loadAs(inputStream, People.class);
        List<Person> people = data.getPeople();
        
        for (Person person : people) {
            System.out.println("Имя:"+person.getName()+"  "+"Адрес:"+person.getAdress());
            System.out.println();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter для выхода");
        scanner.nextLine();
    }
}
