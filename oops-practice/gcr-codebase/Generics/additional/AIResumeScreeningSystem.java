import java.util.*;

public class AIResumeScreeningSystem {

    static abstract class JobRole {
        String roleName;

        JobRole(String roleName) {
            this.roleName = roleName;
        }

        public String toString() {
            return getClass().getSimpleName() + " - " + roleName;
        }
    }

    static class SoftwareEngineer extends JobRole {
        SoftwareEngineer(String roleName) {
            super(roleName);
        }
    }

    static class DataScientist extends JobRole {
        DataScientist(String roleName) {
            super(roleName);
        }
    }

    static class ProductManager extends JobRole {
        ProductManager(String roleName) {
            super(roleName);
        }
    }

    static class Resume<T extends JobRole> {
        String candidateName;
        T jobRole;
        int yearsOfExperience;

        Resume(String candidateName, T jobRole, int yearsOfExperience) {
            this.candidateName = candidateName;
            this.jobRole = jobRole;
            this.yearsOfExperience = yearsOfExperience;
        }

        boolean isEligible(int minExperience) {
            return yearsOfExperience >= minExperience;
        }

        public String toString() {
            return candidateName + " applying for " + jobRole + " (" + yearsOfExperience + " yrs exp)";
        }
    }

    static void screenResumes(List<? extends JobRole> roles) {
        System.out.println("\n--- Job Roles in Screening Pipeline ---");
        for (JobRole role : roles) {
            System.out.println(role);
        }
    }

    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 = new Resume<>("Rohan", new SoftwareEngineer("Backend Developer"), 3);
        Resume<DataScientist> r2 = new Resume<>("Priya", new DataScientist("ML Engineer"), 5);
        Resume<ProductManager> r3 = new Resume<>("Karan", new ProductManager("Growth PM"), 1);

        System.out.println(r1 + " -> Eligible: " + r1.isEligible(2));
        System.out.println(r2 + " -> Eligible: " + r2.isEligible(2));
        System.out.println(r3 + " -> Eligible: " + r3.isEligible(2));

        List<JobRole> roles = new ArrayList<>();
        roles.add(r1.jobRole);
        roles.add(r2.jobRole);
        roles.add(r3.jobRole);

        screenResumes(roles);
    }
}
