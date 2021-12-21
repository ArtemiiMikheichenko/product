package sample;

public class Questions {
    private String quetype;//тип вопроса
    private String task;//задание
    public String[] allAnswers = new String[4];//все варианты ответов
    public String[] correct = new String[4];//правильные ответы


    public Questions(String quetype, String task, String[] allAnswers, String[] correct){
        this.quetype = quetype;
        this.task = task;
        this.allAnswers = allAnswers;
        this.correct = correct;
    }

    public String getTask (){
        return task;
    }

    public String[] getAnswers (){
            return allAnswers;
    }

    public String quetype(){
        return quetype;
    }

    public int getCorrect(){
        return correct.length;
    }
}
