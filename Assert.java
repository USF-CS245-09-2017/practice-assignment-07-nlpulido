import java.lang.ArrayIndexOutOfBoundsException;

public class Assert {
	public static boolean notFalse(boolean cond){
		if (cond){
			return true;
		}
		throw new ArrayIndexOutOfBoundsException("Error");
	}
}