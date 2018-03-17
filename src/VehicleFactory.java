import java.io.FileInputStream;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VehicleFactory {
	
	// our parallel worker threads count configuration 
	static int workersCount = 7;
	
	// list of our workers that will create vehicles
    static List<Callable<Integer>> workersList = new ArrayList<Callable<Integer>>();

	public static void main(String[] args) throws InterruptedException {
		readLine();
	}
	
	private static void readLine() throws InterruptedException {
		System.out.println("Please give a XML file path: ");
		readXML(new Scanner(System.in).nextLine());
	}
	
	private static void readXML(String XMLPath) throws InterruptedException {
				
		try (FileInputStream fis = new FileInputStream(XMLPath)) {
			
			// XML parser factory
	        XMLInputFactory xmlInFact = XMLInputFactory.newInstance();
	        XMLStreamReader reader = xmlInFact.createXMLStreamReader(fis);
	        
	        while(reader.hasNext()) {

	        	  switch (reader.next()) {
	        	    case XMLStreamReader.START_ELEMENT:
	        	      // handle XML start element, do nothing actually

	        	    case XMLStreamReader.ATTRIBUTE:
	        	      // handle XML attribute
	        	    	if (reader.getName().toString().equals("item")) {
	        	    		
	        	    		// create new worker of some type (car, motorcycle or truck in our actual case)
		    	        	FactoryWorker worker = new FactoryWorker(reader.getAttributeValue(0));
		    	        	
	        	    		// add worker to list for executing
	        	    		workersList.add(worker); 
	        	    	}
	        	  }
	        }
	      
	        launchWorkers(workersCount);
	        
	    } catch (Exception e) {
	    	System.err.println(e);
	    	System.out.println("Try again...");
	    	// come back to XML file path reading
	    	readLine();
	    }
		
	}
	
	private static void launchWorkers(int count) throws InterruptedException, ExecutionException {
		
		int totalProductionCost = 0;

		// our callables executor service with count of workers
	    final ExecutorService service = Executors.newFixedThreadPool(count);

		// invoke our workers
	    List<Future<Integer>> futureObjects = service.invokeAll(workersList);  //futureObjects will contain result of each thread execution
	
	    for (Iterator<Future<Integer>> i = futureObjects.iterator(); i.hasNext();) {
	        int cost = i.next().get();
		    totalProductionCost += cost;
	    }
	    
	    // print out final procution cost
		System.out.format("Total production cost: %d.", totalProductionCost);
		System.exit(0);
	}
	
}