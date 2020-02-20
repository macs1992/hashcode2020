package main;

import reader.ReadUtils;
import resolvers.ProblemHashCodeResolver;
import resolvers.ProblemResolver;

public class mainProblemPizza {

    public static void main(String args[]){
        ProblemResolver resolver = new ProblemHashCodeResolver();

        ReadUtils.readFile("in/f_libraries_of_the_world.txt",resolver,"out/f_libraries_of_the_world.txt");
        ReadUtils.readFile("in/e_so_many_books.txt",resolver,"out/e_so_many_books.txt");
        ReadUtils.readFile("in/b_read_on (1).txt",resolver,"out/b_read_on (1).txt");
        ReadUtils.readFile("in/c_incunabula (1).txt",resolver,"out/c_incunabula (1).txt");
        ReadUtils.readFile("in/d_tough_choices.txt",resolver,"out/d_tough_choices.txt");
    }
}
