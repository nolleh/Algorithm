import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Hedgemony {
	private static final String PATH = "./Hedgemony";
	private static final String PATH_POSTFIX_IN = ".in.txt";
	private static final String PATH_POSTFIX_OUT = ".out.txt";
	private static final String PATH_SMALL = PATH +"/A-small-practice";
	private static final String PATH_LARGE = PATH + "/A-large-practice";
	
	private static final String PATH_TYPE = PATH_LARGE;

	public static void main(String arg[]) {
		int T, N = 0;
		float bushes[] = null;
		
		try {
			Scanner scanner = new Scanner(new FileInputStream(new File(PATH_TYPE+PATH_POSTFIX_IN)));
			FileOutputStream fos = new FileOutputStream(new File(PATH_TYPE + PATH_POSTFIX_OUT));
			if (scanner.hasNextInt()) {
				T = scanner.nextInt();
				for (int t = 0; t < T; t++) {
					if (scanner.hasNextInt()) {
						N = scanner.nextInt();
						bushes = new float[N];
						for (int n = 0; n < N; n++) {
							if (scanner.hasNextInt()) {
								bushes[n] = scanner.nextInt();
//								System.out.print( bushes[n] + " ");
							}
						}// for n;
						if(bushes != null){
							for(int i = 1 ; i < bushes.length-1 ; i++){
								float avg = (bushes[i-1] + bushes[i+1])/2.0f ;
								if( bushes[i] > avg ){
									bushes[i] = avg;
								}
							}
//							float avg = (bushes[N-3] + bushes[N-1])/2.0f ;
							String value = "Case #"+(t+1)+": "+ bushes[N-2]+"\n";
							System.out.print(value);
							fos.write(value.getBytes());
						}
					}
				}// for T;
				scanner.close();
				fos.close();
			}
		} catch (IOException ie) {

		}
	}
}
