package main;

import reader.ReadUtils;
import resolvers.ProblemPizzaResolver;
import resolvers.ProblemResolver;

public class mainProblemPizza {

    public static void main(String args[]){
        ProblemResolver resolver = new ProblemPizzaResolver();
        try {
            String current = new java.io.File( "." ).getCanonicalPath();
            System.out.println("Current dir:"+current);
            String currentDir = System.getProperty("user.dir");
            System.out.println("Current dir using System:" +currentDir);
        }catch (Exception e){
            System.out.println(e);
        }

        ReadUtils.readFile("in/a_example.in",resolver,"out/a_example.out");
        ReadUtils.readFile("in/b_small.in",resolver,"out/b_small.out");
        ReadUtils.readFile("in/c_medium.in",resolver,"out/c_medium.out");
        ReadUtils.readFile("in/d_quite_big.in",resolver,"out/d_quite_big.out");
        ReadUtils.readFile("in/e_also_big.in",resolver,"out/e_also_big.out");
    }
}
