package main;

import reader.ReadUtils;
import resolvers.HashcodeMarcos;

import resolvers.ProblemResolver;

public class mainProblemPizza {

    public static void main(String args[]){
        ProblemResolver resolver = new HashcodeMarcos();

        ReadUtils.readFile("in/a_example.txt",resolver,"out/a_example.txt");
        System.out.println("out/a_example.txt");
        ReadUtils.readFile("in/b_read_on.txt",resolver,"out/b_read_on.txt");
        System.out.println("out/b_read_on.txt");
        ReadUtils.readFile("in/c_incunabula.txt",resolver,"out/c_incunabula.txt");
        System.out.println("out/c_incunabula.txt");
        ReadUtils.readFile("in/d_tough_choices.txt",resolver,"out/d_tough_choices.txt");
        System.out.println("out/d_tough_choices.txt");
        ReadUtils.readFile("in/e_so_many_books.txt",resolver,"out/e_so_many_books.txt");
        System.out.println("out/e_so_many_books.txt");
        ReadUtils.readFile("in/f_libraries_of_the_world.txt",resolver,"out/f_libraries_of_the_world.txt");
        System.out.println("out/f_libraries_of_the_world.txt");
    }
}
