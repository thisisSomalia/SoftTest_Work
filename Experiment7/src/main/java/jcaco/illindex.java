package jcaco;

public class illindex {
    private int index;
    private String qusetion;
    private String answer;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getQusetion() {
        return qusetion;
    }

    public void setQusetion(String qusetion) {
        this.qusetion = qusetion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "illindex{" +
                "题目标号=" + index +
                ", 题目='" + qusetion + '\'' +
                ", 您给出的答案='" + answer + '\'' +
                '}';
    }
}
