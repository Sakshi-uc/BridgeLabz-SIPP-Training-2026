import java.util.*;
public class SimplifyPath {
	public static String simplifyPath(String path) {
		Stack<String> stack=new Stack<>();
		String[] parts=path.split("/");
		for(String part:parts) {
			if(part.isEmpty()||part.equals(".")) {
				continue;
			} else if(part.equals("..")) {
				if(!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(part);
			}
		}
		StringBuilder result=new StringBuilder();
		while(!stack.isEmpty()) {
			result.insert(0, "/"+stack.pop());
		}
		return result.isEmpty()?"/":result.toString();
	}
	public static void main(String[] args) {
		System.out.println(simplifyPath("/home/"));
		System.out.println(simplifyPath("/../"));
		System.out.println(simplifyPath("/home//foo/"));
	}
}
