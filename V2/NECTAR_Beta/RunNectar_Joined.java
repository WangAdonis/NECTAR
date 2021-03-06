package NECTAR_Beta;
import java.io.IOException;

// Main class - running the NECTAR algorithm.
public class RunNectar_Joined {

	public static void main(String[] args) throws IOException {		
		if (args.length <2){
			System.out.println("Input parameteres for NECTAR: pathToGraph  outputPath  betas={1.1,1.2,2.0,3.0}  alpha=0.8  iteratioNumToStartMerge=6  maxIterationsToRun=20 firstPartMode=0(0=CC, 3=clique 3, 4=clique 4) percentageOfStableNodes=95 ");
		}
		else{
			String pathToGraph = "";
			String outputPath = "";
			double[] betas = {1.1,1.2,2.0,3.0};
			int firstPartMode = 0;
			double alpha = 0.8;
			int iteratioNumToStartMerge = 6;
			int maxIterationsToRun = 20;
			int percentageOfStableNodes = 100;
			
			
			if (args.length > 0)
				pathToGraph = args[0];		
			
			if (args.length > 1)
				outputPath = args[1];		
			
			if (args.length > 2)
				betas = Utills.ParseDoubleArray(args[2]);		
				
			if (args.length > 3)
				 alpha = Double.parseDouble(args[3]);
			
			if ( args.length > 4)
				 iteratioNumToStartMerge = Integer.parseInt(args[4]);
			
			if ( args.length > 5)
				maxIterationsToRun = Integer.parseInt(args[5]);
			
			if ( args.length > 6)
				firstPartMode = Integer.parseInt(args[6]);
			
			if(args.length > 7){
				percentageOfStableNodes = Integer.parseInt(args[7]);
				if(percentageOfStableNodes<1 || percentageOfStableNodes>100){
					throw(new RuntimeException("param at location 7 is percentageOfStableNodes. You gave: " + percentageOfStableNodes +"  which is not <1 or >100."));
				}
			}
								
			String betasString = "";
			for (double d: betas){
				betasString = betasString + d + " ";
			}
			
			System.out.println("pathToGraph:             "+pathToGraph);      
			System.out.println("outputPath:              "+outputPath);
			System.out.println("betas:                   "+betasString);
			System.out.println("alpha:                   "+alpha);
			System.out.println("iteratioNumToStartMerge: "+iteratioNumToStartMerge);
			System.out.println("first Part mode:      "+firstPartMode);
			System.out.println("maxIterationsToRun:      "+maxIterationsToRun);
			System.out.println("percentageOfStableNodes: "+percentageOfStableNodes);

			System.out.println("");
			
			Nectar nectar = new Nectar(pathToGraph,betas,alpha,outputPath, iteratioNumToStartMerge, maxIterationsToRun,percentageOfStableNodes,firstPartMode);			
			
			nectar.FindCommunities();
		}
	}	
}