package org.geekbang.week.five.homework2;

/**
 * 描述:
 *
 * @author lil
 */
public class StudentInfo {

    private String school;
    private String klass;
    private String student;

    public StudentInfo(String school, String klass, String student) {
        this.school = school;
        this.klass = klass;
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "school='" + school + '\'' +
                ", klass='" + klass + '\'' +
                ", student='" + student + '\'' +
                '}';
    }
}
