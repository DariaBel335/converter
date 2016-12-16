package utils;

import model.User;

import java.io.PrintStream;
import java.util.List;

public final class UserUtils {
    private UserUtils() {
        // empty private constructor
    }

    public static User createUser(String[] user) {
        User student = new User();
        student.setFirstName(user[0]);
        student.setLastName(user[1]);
        student.setEmail(user[2]);
        student.setPassword(user[3]);
        student.setSecondaryEmail(user[4]);
        student.setDepartment(user[6]);
        student.setPhone(user[5]);
        return student;
    }

    public static void printDetails(PrintStream stream, List<User> users) {
        for (User user : users) {
            stream.println("Email: " + user.getEmail());
            stream.println("Phone: " + user.getPhone());
            stream.println();
        }
    }
}