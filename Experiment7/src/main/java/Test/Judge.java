package Test;


public class Judge {
    public static String judge(String symptom, String contact) {
        if (symptom.equals("有典型症状") && contact.equals("有接触史")) {
            return "建议1";
        }
        if (symptom.equals("有典型症状")) {
            return "建议2";

        }
        if (contact.equals("有接触史")) {
            return "建议3";
        }
        else {
            return "建议4";
        }
    }

}
