package resolvers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
        for(int i = 0 ; i < books ; i ++) {
        	allbooks[i] = false;
        }
        
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
        ArrayList<String> solution = new ArrayList<>();
        ArrayList<LibraryDto> libsOrder = new ArrayList<>();
    	Collections.sort(libs, new Comparator<LibraryDto>() {
            @Override
            public int compare(LibraryDto book1, LibraryDto book2)
            {            	
                return  book1.score < book2.score ? 1 : 0;
            }
        });
    	for(LibraryDto dto : libs) {
    		daysConsumed += dto.daysCost;
    		if(daysConsumed <= days) {
    			libsOrder.add(dto);
    		} else {
    			break;
    		}
    		
    	}       
        solution.add(libsOrder.size()+"");
   
        
        for(LibraryDto dto: libsOrder) {        	
        	
        	ArrayList<Integer> books2 = new ArrayList<Integer>();
        	
        	for(int i = 0; i < dto.books.length; i++) {
        		books2.add(dto.books[i]);        		
        	}
        	
        	Collections.sort(books2, new Comparator<Integer>() {
                @Override
                public int compare(Integer book1, Integer book2)
                {                	
                    return  scores[book1] - scores[book2];
                }
            });
        	String library = "";
        	int total = 0;
        	
        	for(Integer num: books2) {
        		if(!allbooks[num]) {
        			total ++;
        			allbooks[num] = true;
            		library+= " " + num;
        		}
        		
        	}
        	if(total!=0) {
        		solution.add(dto.id +" " + total);
        		solution.add(library.substring(1));
        	} else {
        		solution.add(dto.id +" 1");
        		solution.add(books2.get(0)+"");
        	}
        	
        	
        }
        ReadUtils.printSolution(solution, solutionFileName);
     
        
        
        
    }   
    
    private double calculateScore (LibraryDto lib,int [] scores) {    	
    	int scoreBooks = 0;
    	for(int i = 0; i < lib.nBooks ; i++) {
    		scoreBooks += scores[lib.books[i]];
    	}
    	return (scoreBooks  / lib.bocksPerDay ) ;
    	
    	
    }
    	
}
