package dhlee.coding.exam;

import java.util.*;

// KKO_MB
public class Exam01 {
    // John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parke
    // John Doe <jdoe@example.com>, Peter Parker <pparker@example.com>, Mary Jane Watson-Parker <mjwatsonpa@example.com>, James Doe <jdoe2@example.com>, John Elvis Doe <jedoe@example.com>, Jane Doe <jdoe3@example.com>, Penny Parker <pparker2@example.com>
    public String solution(String S, String C) {
        List<String> names = Arrays.asList(S.split(", "));
        StringBuilder addressBuilder = new StringBuilder();
        StringBuilder emailBuilder = new StringBuilder();
        Map<String, Integer> emailCount = new HashMap<>();


        for (int i=0; i<names.size(); i++) {

            String name = names.get(i);
            List<String> character = Arrays.asList(name.split(" "));

            // First
            emailBuilder.append(character.get(0).toLowerCase().charAt(0));

            // Second
            if (character.size() > 2) {
                emailBuilder.append(character.get(1).toLowerCase().charAt(0));
            }

            // Last
            String lastName = character.get(character.size() - 1).toLowerCase().replace("-", "");
            emailBuilder.append(lastName, 0, lastName.length() > 8 ? 8 : lastName.length());
            emailCount.put(emailBuilder.toString(), emailCount.getOrDefault(emailBuilder.toString(), 0) + 1);
            addressBuilder.append(name + " <");
            Integer count = emailCount.get(emailBuilder.toString());
            addressBuilder.append(emailBuilder.toString() + (count > 1 ? count : ""));
            addressBuilder.append("@" + C.toLowerCase() + ".com>");
            if (i != names.size() - 1) {
                addressBuilder.append(", ");
            }
            emailBuilder.delete(0, emailBuilder.length());
        }
        return addressBuilder.toString();
    }
}
