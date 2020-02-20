package resolvers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dto.LibraryDto;
import dto.ProblemPizzaDto;
import reader.ReadUtils;

public class HashcodeMarcos implements ProblemResolver {
    public String solutionFileName;

    @Override
    public void setUpData(ArrayList<String> lines, String solutionFileName) {
       
        int [] firstLineData = ReadUtils.readLine(lines.get(0),3);
        int books = firstLineData[0];
        int libraries = firstLineData[1];
        int days = firstLineData[2];
        int [] scores = ReadUtils.readLine(lines.get(1),books);
        boolean [] allbooks = new boolean[books];
        
        ArrayList<LibraryDto> libs = new ArrayList<>();        
        int line = 1;
        for (int i = 0; i < libraries; i++) {
        	LibraryDto dto = new LibraryDto();
        	line++;
            int [] data = ReadUtils.readLine(lines.get(line),3);
            dto.id = i;
            dto.nBooks = data[0];
            dto.daysCost = data[1];
            dto.bocksPerDay= data[2];
            line++;
            dto.books = ReadUtils.readLine(lines.get(line),dto.nBooks);
            dto.score = calculateScore(dto,scores);
            //recalcular score
            libs.add(dto);  
        }
            
        int totalLibraries = 0;
        int daysConsumed = 0;
        ArrayList<int[]> solution = new ArrayList<>();
        while (daysConsumed <= days) {
        	double maxScore = 0D;
        	
        }
     
        
        
        
    }   
    
    private double calculateScore (LibraryDto lib,int [] scores) {    	
    	int scoreBooks = 0;
    	for(int i = 0; i < lib.nBooks ; i++) {
    		scoreBooks += scores[lib.books[i]];
    	}
    	return (scoreBooks * lib.nBooks) / lib.bocksPerDay  ;
    	
    	
    }
    	
}
