import java.util.*;
public class EmployeeSkillAssignment {
	public static List<List<Integer>> findCombinations(int[] skills, int target) {
		List<List<Integer>> result=new ArrayList<>();
		findHelper(skills, target, 0, new ArrayList<>(), result);
		return result;
	}
	private static void findHelper(int[] skills, int target, int index, List<Integer> current, List<List<Integer>> result) {
		if(target==0) {
			result.add(new ArrayList<>(current));
			return;
		}
		if(target<0||index==skills.length) {
			return;
		}
		current.add(skills[index]);
		findHelper(skills, target-skills[index], index+1, current, result);
		current.remove(current.size()-1);
		findHelper(skills, target, index+1, current, result);
	}
	public static void main(String[] args) {
		int[] skills={2,3,5,7};
		int target=10;
		List<List<Integer>> combinations=findCombinations(skills, target);
		for(List<Integer> combo:combinations) {
			System.out.println(combo);
		}
	}
}
