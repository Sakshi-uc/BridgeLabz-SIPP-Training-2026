import java.util.*;

public class UniversityCourseManagementSystem {

    static abstract class CourseType {
        String description;

        CourseType(String description) {
            this.description = description;
        }

        public String toString() {
            return getClass().getSimpleName() + " (" + description + ")";
        }
    }

    static class ExamCourse extends CourseType {
        ExamCourse(String description) {
            super(description);
        }
    }

    static class AssignmentCourse extends CourseType {
        AssignmentCourse(String description) {
            super(description);
        }
    }

    static class ResearchCourse extends CourseType {
        ResearchCourse(String description) {
            super(description);
        }
    }

    static class Course<T extends CourseType> {
        String courseName;
        T evaluationType;

        Course(String courseName, T evaluationType) {
            this.courseName = courseName;
            this.evaluationType = evaluationType;
        }

        public String toString() {
            return courseName + " -> " + evaluationType;
        }
    }

    static void displayCourses(List<? extends CourseType> evaluationTypes) {
        System.out.println("\n--- Evaluation Types in Use ---");
        for (CourseType type : evaluationTypes) {
            System.out.println(type);
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> dbms = new Course<>("DBMS", new ExamCourse("Final written exam"));
        Course<AssignmentCourse> webDev = new Course<>("Web Development", new AssignmentCourse("Project submissions"));
        Course<ResearchCourse> thesis = new Course<>("Thesis", new ResearchCourse("Independent research paper"));

        System.out.println(dbms);
        System.out.println(webDev);
        System.out.println(thesis);

        List<CourseType> evaluationTypes = new ArrayList<>();
        evaluationTypes.add(dbms.evaluationType);
        evaluationTypes.add(webDev.evaluationType);
        evaluationTypes.add(thesis.evaluationType);

        displayCourses(evaluationTypes);
    }
}
