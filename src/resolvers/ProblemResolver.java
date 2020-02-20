package resolvers;

import dto.ProblemDto;

import java.util.ArrayList;

public interface ProblemResolver {

    void setUpData(ArrayList<String> lines, String solutionFileName);

}
