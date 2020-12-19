/**
 * 
 */
package wk1assignment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Collectors;

/**
 * @author matthew
 *
 */
public class RemoveX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> l1 = Arrays.asList("ax","bb","cx");
		List<String> l2 = Arrays.asList("xxax", "xbxbx", "xxcx");
		List<String> l3 = Arrays.asList("x");
		
		System.out.println("noX("+l1+") = "+noX(l1));
		System.out.println("noX("+l2+") = "+noX(l2));
		System.out.println("noX("+l3+") = "+noX(l3));


	}
	
	private static List<String> noX(List<String> l) {
		return l.stream().map(s->s.replace("x","")).collect(Collectors.toList());
	}

}
