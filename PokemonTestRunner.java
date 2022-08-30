package pokemon;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class PokemonTestRunner {
	
	public static void main (String[] args)
	{
		Result result = JUnitCore.runClasses(PokemonTester.class);
		int failCount = 0;
		for (Failure failure : result.getFailures())
		{
			System.out.println(failure.toString());
			failCount++;
		}
		System.out.println("\nAll methods worked as intended: " + result.wasSuccessful());
		System.out.println("There were " + failCount + " errors.");
	}
	
}

