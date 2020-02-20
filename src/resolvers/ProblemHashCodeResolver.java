package resolvers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import reader.ReadUtils;

public class ProblemHashCodeResolver implements ProblemResolver {

    public String solutionFileName;

    @Override
    public void setUpData(ArrayList<String> lines, String solutionFileName) {
    	
    	int [] firstLineData = ReadUtils.readLine(lines.get(0),3);
        int books = firstLineData[0];
        int libraries = firstLineData[1];
        int days = firstLineData[2];
        int [] scores = ReadUtils.readLine(lines.get(1),books);
        List<BookDto> bookList = new ArrayList<>();
        int i=0;
        for(int score : scores){        	
        	BookDto book =  new BookDto(); 
        	book.idBook=i;
        	book.bookScore = score;
        	bookList.add(book);
        	i++;
        }
        
        ArrayList<LibraryDto> libs = new ArrayList<>();
        int line = 1;
        for (int j = 0; j < libraries; j++) {
        	LibraryDto dto = new LibraryDto();
        	line++;
            int [] data = ReadUtils.readLine(lines.get(line),3);
            dto.libraryId = j;
            dto.nBooks = data[0];
            dto.daysSignupProcess= data[1];
            dto.booksShipPerDay= data[2];
            line++;
            int [] bookListInLibrary = ReadUtils.readLine(lines.get(line),dto.nBooks);
            for(int numberOfBook: bookListInLibrary){
            	dto.bookList.add(bookList.get(numberOfBook));
            }
            libs.add(dto);            
        }
        
        ArrayList<LibraryDto> libsToSolv = ordenarLibrary(libs);
        
        
        ArrayList<String> solutionToWrite = new ArrayList<>();

        solutionToWrite.add(libsToSolv.size()+"");
        for(LibraryDto lib : libsToSolv){
        	solutionToWrite.add(lib.libraryId+ " " + lib.nBooks);
        	ArrayList<Integer> bookArray = new ArrayList<>();
        	for(BookDto book: lib.bookList){        		
        		bookArray.add(book.idBook);   
        	}
        	solutionToWrite.add(ReadUtils.transformArray(bookArray));
        }
        System.out.print("Termina y escribe");
        ReadUtils.printSolution(solutionToWrite,solutionFileName);
        
        

    }

    //Posible solución voraz (no buena)
    private void resolveProblem(String solutionFileName){
       

    }

    
    public ArrayList<LibraryDto> ordenarLibrary(ArrayList<LibraryDto> libs){
    	ArrayList<LibraryDto> libreriaOrdenada= new ArrayList<LibraryDto>();
    	ArrayList<LibraryDto> libreriaFinal= new ArrayList<LibraryDto>();
    	System.out.print("Empieza Ordenar");
    	
    	System.out.print("Termina Ordenar");
    	
    	/*Collections.sort(libs, new Comparator<LibraryDto>() {
            @Override public int compare(LibraryDto p1, LibraryDto p2) {
                return p2.booksShipPerDay - p1.booksShipPerDay; // Ascending
            }
    	});
    	     	
    	Collections.sort(libs, new Comparator<LibraryDto>() {
            @Override public int compare(LibraryDto p1, LibraryDto p2) {
                return p1.daysSignupProcess - p2.daysSignupProcess; // Ascending
            }
    	});
    	
    	Collections.sort(libs, new Comparator<LibraryDto>() {
            @Override public int compare(LibraryDto p1, LibraryDto p2) {
                return p2.nBooks - p1.nBooks; // Ascending
            }
    	});*/
    	
    	for(LibraryDto lib :libs){
    		Collections.sort(lib.bookList, new Comparator<BookDto>() {
                @Override public int compare(BookDto p1, BookDto p2) {
                    return p2.bookScore - p1.bookScore; // Ascending
                }
        	});
    	}
    	
    	
    	int sizeLib = libs.size()/100;
    	
    	for(int j = 0; j< sizeLib; j++){
    		calculateFunction(libs);
    		
	    	
	    	for(int i = 0; (i< libs.size() && i!=100) ; i++){ 
	    		libreriaOrdenada.add(libs.get(i));
	    	}
	    	if(libs.size()<100){
	    		
	    	}else{
	    		libs = new ArrayList<LibraryDto>(libs.subList(100, libs.size()));
	    	}
	    	
    	}
    	
    	
    
    	
    	return libreriaOrdenada;
    }

	 private void calculateFunction(List<LibraryDto> libs){
		 for(LibraryDto lib :libs){
	    		for(BookDto book :lib.bookList){
	    			lib.scoreLibrary += book.bookScore;
	    		}
	    		lib.scoreLibrary = lib.scoreLibrary  / lib.daysSignupProcess; 
	    	}
	       	
    	
    	Collections.sort(libs, new Comparator<LibraryDto>() {
            @Override public int compare(LibraryDto p1, LibraryDto p2) {
                return p2.scoreLibrary - p1.scoreLibrary; // Ascending
            }
    	});
	 }

}
