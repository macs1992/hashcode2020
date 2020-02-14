package resolvers;

import dto.ProblemDto;

import java.util.ArrayList;

public interface ProblemResolver {

    ProblemDto setUpData(ArrayList<String> lines, String solutionFileName);

}
