package resolvers;

import dto.ProblemPizzaDto;
import reader.ReadUtils;

import java.util.ArrayList;

public class ProblemPizzaResolver implements ProblemResolver {

    public String solutionFileName;

    @Override
    public void setUpData(ArrayList<String> lines, String solutionFileName) {
    
    }

    //Posible solución voraz (no buena)
    private void resolveProblem(ProblemPizzaDto dto, String solutionFileName){
        ArrayList<Integer> solution = new ArrayList<>();
        int totalCount = 0;
        int index = dto.typesOfPizza;
        System.out.println(index);
        System.out.println(dto.maximunSlices);
        while(totalCount < dto.maximunSlices && index > 0){
            index --;
            if(totalCount + dto.pizzas[index] <= dto.maximunSlices){
                solution.add(index);
                totalCount+= dto.pizzas[index];
            }
        }
        ArrayList<String> solutionToWrite = new ArrayList<>();

        solutionToWrite.add(solution.size()+"");
        solutionToWrite.add(ReadUtils.transformArray(solution));

        ReadUtils.printSolution(solutionToWrite,solutionFileName);



    }




}
