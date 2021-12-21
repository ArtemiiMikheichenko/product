package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
public class Controller {
    @FXML
    private ComboBox<String> combo1, combo2, combo3, combo4;
    @FXML
    private ToggleGroup radio;
    @FXML
    private RadioButton radio1, radio2, radio3, radio4;
    @FXML
    private RadioButton radio11, radio21, radio31, radio41;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button CreateBtn, On1, Next, que1, que2, que3, que4, Next2, Back,Back2,Back3,correct,back1,back2;
    @FXML
    private Button DownloadBtn;
    @FXML
    private Label label1;
    @FXML
    private Text text1,text11,text12, textque1_3, textgreat,textque41, textque42, textque43, textque44;
    @FXML
    private TextArea txtfield, txtfieldname, txtfield_1_4, txtfieldque1_3, txtfield_1, txtfield_2, txtfield_3, txtfield_4, txtfield_4_1,txtfield_4_2,txtfield_4_3,txtfield_4_4,txtfieldDir,txtfieldDir1;
    @FXML
    void initialize() {}
    @FXML
    public int count = -1, amount = 0,a = 0 ;
    @FXML
    public String type ="", test = "", dir = "";

    public void Cleaner(){//процедура отчистки полей
        txtfield_1_4.clear();
        txtfieldque1_3.clear();
        txtfield_1.clear();
        txtfield_2.clear();
        txtfield_3.clear();
        txtfield_4.clear();
        txtfield_1_4.setVisible(true);
        textque1_3.setVisible(true);
        txtfieldque1_3.setVisible(true);
        txtfield_1.setVisible(true);
        txtfield_2.setVisible(true);
        txtfield_3.setVisible(true);
        txtfield_4.setVisible(true);
        txtfield_4_1.setVisible(false);
        txtfield_4_2.setVisible(false);
        txtfield_4_3.setVisible(false);
        txtfield_4_4.setVisible(false);
    }
    public void Cleaner2(){//процедура отчистки полей для второй части
        radio1.setVisible(false);
        radio2.setVisible(false);
        radio3.setVisible(false);
        radio4.setVisible(false);
        radio11.setVisible(false);
        radio21.setVisible(false);
        radio31.setVisible(false);
        radio41.setVisible(false);
        txtfieldque1_3.setVisible(false);
        combo1.setVisible(false);
        combo2.setVisible(false);
        combo3.setVisible(false);
        combo4.setVisible(false);
        textque41.setVisible(false);
        textque42.setVisible(false);
        textque43.setVisible(false);
        textque44.setVisible(false);
    }
    public void CreateBtn() throws Exception{//кнопка для создания теста
        Parent root = FXMLLoader.load(getClass().getResource("p2.fxml"));
        Stage window = (Stage) CreateBtn.getScene().getWindow();
        window.setScene(new Scene(root, 1280, 800));
    }
    public void On1() throws Exception{//кнопка для перехода на главный экран
        Parent root = FXMLLoader.load(getClass().getResource("p1.fxml"));
        Stage window = (Stage) On1.getScene().getWindow();
        window.setScene(new Scene(root, 1280, 800));
    }
    public void DownloadBtn() throws Exception {//кнопка для загрузки теста
        Parent root = FXMLLoader.load(getClass().getResource("p3.fxml"));
        Stage window = (Stage) DownloadBtn.getScene().getWindow();
        window.setScene(new Scene(root, 1280, 800));
    }
    public void createtxt(Questions[] q, int amount, String test, String dir){// создание файла с данными
        try {
            dir = dir +"\\";//в директории
            File file = new File(test = dir + test +".txt");
            if(!file.exists())
                file.createNewFile();
            PrintWriter pw = new PrintWriter(file);

            for (int i = 0; i < amount ; i ++){
                pw.println(q[i].quetype());
                pw.println(q[i].getTask());
                for (int j = 0; j < 4; j++){
                pw.println(q[i].allAnswers[j]);}
                for (int k = 0; k < q[i].getCorrect(); k++){
                pw.println(q[i].correct[k]);
                }
                pw.println("***");
            }
            pw.close();
        } catch(IOException e){
            System.out.println("ERROR");
        }
    }
    public void quevis1(){//процедура для функций в вопросе типа 1
        radio1.setVisible(true);
        radio2.setVisible(true);
        radio3.setVisible(true);
        radio4.setVisible(true);
    }
    public void quevis2(){//процедура для функций в вопросе типа 2
        radio11.setVisible(true);
        radio21.setVisible(true);
        radio31.setVisible(true);
        radio41.setVisible(true);
    }
    public  void quevis4(){//процедура для функций в вопросе типа 4
        textque41.setVisible(true);
        textque42.setVisible(true);
        textque43.setVisible(true);
        textque44.setVisible(true);
        combo1.setVisible(true);
        combo2.setVisible(true);
        combo3.setVisible(true);
        combo4.setVisible(true);
    }
    public void que1() throws Exception {//процедура для заполнения вопроса 1 типа
        txtfield.clear();
        txtfield.setText("1==");
        Cleaner();
        textque1_3.setText("Введите номер правильного ответа");
    }
    public void que2() throws Exception {//процедура для заполнения вопроса 2 типа
        txtfield.clear();
        txtfield.setText("2==");
        Cleaner();
        textque1_3.setText("Введите номера правильных ответов," + "\n" +  "без пробелов, в порядке возростания");
    }
    public void que3() throws Exception {//процедура для заполнения вопроса 3 типа
        txtfield.clear();
        txtfield.setText("3==");
        Cleaner();
        txtfield_1_4.clear();
        txtfieldque1_3.clear();
        txtfieldque1_3.setVisible(true);
        txtfield_1_4.setVisible(true);
        textque1_3.setText("Введите правильный ответ");
        txtfield_1.setVisible(false);
        txtfield_2.setVisible(false);
        txtfield_3.setVisible(false);
        txtfield_4.setVisible(false);
    }
    public void que4() throws Exception {//процедура для заполнения вопроса 4 типа
        Cleaner();
        txtfield.clear();
        txtfield.setText("4==");
        textque1_3.setVisible(false);
        txtfield_1_4.clear();
        txtfield_4_1.setVisible(true);
        txtfield_4_2.setVisible(true);
        txtfield_4_3.setVisible(true);
        txtfield_4_4.setVisible(true);
        txtfieldque1_3.setVisible(false);
    }
    public void Back() throws Exception {//кнопка для перепрохождения теста
        count = 0;
        a = 0;
        Next2();
        Next2.setDisable(false);

    }
    public void Back2() throws Exception {// кнопка для возврата на предыдущий вопрос
        if(count != 1){
            count -= 2;
            a--;
            Next2();
        }
    }
    public void Back3() throws Exception {// кнопка для проверки ошибок
        type = " ";
        for(int i =0; i < amount;i++)
        {
            if(itog[i] == 0){
                type = type + (i + 1)+ " ";
            }
        }
        textque1_3.setText("Ошибки были совершены в вопросах" + type);
    }

    public void error() throws IOException {// ошибка в программе
        Stage window = new Stage ();
        Pane pane = FXMLLoader.load(getClass().getResource("error.fxml"));
        Scene scene = new Scene (pane, 400, 100);
        window.setScene (scene);
        window.setTitle ("Ошибка");
        window.showAndWait();
    }
    public void Next() throws Exception {//шаги заполнения теста
        try {

        count ++;
        if (count == 0) {//нулевой шаг считывает данные пользователя

            amount = Integer.parseInt(txtfield.getText());//количество вопросов
            Questions[] questions = new Questions[amount];
            txtfield.setVisible(false);
            txtfieldname.setVisible(false);
            txtfieldDir.setVisible(false);
            txtfield_1_4.setVisible(true);
            text1.setText("Введите ваш вопрос и выберите его тип");
            text11.setVisible(false);
            text12.setVisible(false);
            textgreat.setText("         Вопрос № " + (count + 1));
            que1.setDisable(false);
            que2.setDisable(false);
            que3.setDisable(false);
            que4.setDisable(false);
        }
            if ((count > 0) && (count <= amount)) {//заполнение массива вопросов
                textgreat.setText("         Вопрос № " + (count + 1));
                type = txtfield.getText();
                switch (type) {// проверка на заполнение ответов
                    case ("1==")://тип вопроса
                        test = txtfieldque1_3.getText();//проверка правильности заполнения
                        if(test.contains("1")){ test = "1"; }
                        else if(test.contains("2")){test = "2";}
                        else if(test.contains("3")){test = "3";}
                        else if(test.contains("4")){test = "4";}
                        else {error();On1();}
                        if(((txtfield_1_4.getText() ) == "" || (txtfield_1.getText() ) == "" || (txtfield_2.getText() ) == "" || (txtfield_3.getText() ) == "" || (txtfield_4.getText() ) == "")){error();On1();}
                        questions[count - 1] = new Questions(type, txtfield_1_4.getText(), new String[]{txtfield_1.getText(), txtfield_2.getText(), txtfield_3.getText(), txtfield_4.getText()}, new String[]{test});
                        break;
                    case ("2==")://проверка правильности заполнения
                        if(txtfieldque1_3.getText().contains("1")){ test = test + "1";}
                        else if(txtfieldque1_3.getText().contains("2")){ test = test + "2";}
                        else if(txtfieldque1_3.getText().contains("3")){ test = test + "3";}
                        else if(txtfieldque1_3.getText().contains("4")){ test = test + "4";}
                        else {error();On1();}
                        if((txtfield_1_4.getText()) == "" || (txtfield_1.getText()) == "" || (txtfield_2.getText()) == "" || (txtfield_3.getText()) =="" || (txtfield_4.getText()) ==""){error();On1();}
                        questions[count - 1] = new Questions(type, txtfield_1_4.getText(), new String[]{txtfield_1.getText(), txtfield_2.getText(), txtfield_3.getText(), txtfield_4.getText()}, new String[]{test});
                        break;
                    case ("3=="):
                        if((txtfield_1_4.getText()) == "" || (txtfieldque1_3.getText()) == ""){error();On1();}
                        questions[count - 1] = new Questions(type, txtfield_1_4.getText(), new String[]{"0", "0", "0", "0"}, new String[]{txtfieldque1_3.getText()});
                        break;
                    case ("4=="):
                        if((txtfield_1_4.getText()) == "" || (txtfield_1.getText()) == "" || (txtfield_2.getText()) == "" || (txtfield_3.getText()) == "" || (txtfield_4.getText()) == ""){error();On1();}
                        questions[count - 1] = new Questions(type, txtfield_1_4.getText(), new String[]{txtfield_1.getText(), txtfield_2.getText(), txtfield_3.getText(), txtfield_4.getText()}, new String[]{txtfield_4_1.getText(), txtfield_4_2.getText(), txtfield_4_3.getText(), txtfield_4_4.getText()});
                        break;
                }
            }
        if(count == amount) {// заполнение файла
                createtxt(questions,amount, txtfieldname.getText(),txtfieldDir.getText());//ввод данных для создания файла
                On1();
                    }
        que1();
    }
     catch(IOException e){
         error();
        On1();
    }}
    public void Next2() throws Exception {//шаги после загрузки файла
        try {
        count++;
        if(count == 0) {
            test = txtfieldname.getText()+".txt";
            textque1_3.setText("Введите название теста");
            dir = txtfieldDir1.getText();//директроия файла
            dir = dir +"\\"+test;
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(dir));
            while ((type = br.readLine()) != null) {
                if(type.contains("***")){
                    amount++;
                }
            }
            br.close();
            Questions[] questions2 = new Questions[amount];//создание массива
            int[] itog = new int[amount];
            for(int i = 0;i < amount;i++){itog[i] = 0;}
        }
        if(count == 0) {
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(dir));

            while ((type = br.readLine()) != null) {
                switch (type) {//чтение данных из файла
                    case ("1=="):
                    case ("2=="):
                    case ("3=="):
                        questions2[a] = new Questions(type, br.readLine(), new String[]{br.readLine(), br.readLine(), br.readLine(), br.readLine()}, new String[]{br.readLine()});
                        break;
                    case ("4=="):
                        questions2[a] = new Questions(type, br.readLine(), new String[]{br.readLine(), br.readLine(), br.readLine(), br.readLine()}, new String[]{br.readLine(), br.readLine(), br.readLine(), br.readLine()});
                }
                a++;
                br.readLine();
            }
            a = 0;
            br.close();
            count++;
        }
        if((count > 0) && (count <= amount)){
            txtfieldname.setVisible(false);
            txtfieldDir1.setVisible(false);

            switch (questions2[count - 1].quetype()){//заполнение заданий теста для пользователя
                case ("1=="):
                    Cleaner2();
                    textque1_3.setText("Вопрос " + count + ":" + "\n" + "         " + questions2[count - 1].getTask());
                    quevis1();
                    radio1.setText(" " + questions2[count - 1].allAnswers[0]);// 4 радио кнопки с одним выбором
                    radio2.setText(" " + questions2[count - 1].allAnswers[1]);
                    radio3.setText(" " + questions2[count - 1].allAnswers[2]);
                    radio4.setText(" " + questions2[count - 1].allAnswers[3]);
                    break;
                case ("2=="):
                    Cleaner2();
                    textque1_3.setText("Вопрос " + count + ":" + "\n" + "         " + questions2[count - 1].getTask());
                    quevis2();
                    radio11.setText(" " + questions2[count - 1].allAnswers[0]);//4 радио кнопки любым количеством выборов
                    radio21.setText(" " + questions2[count - 1].allAnswers[1]);
                    radio31.setText(" " + questions2[count - 1].allAnswers[2]);
                    radio41.setText(" " + questions2[count - 1].allAnswers[3]);
                    break;
                case ("3=="):
                    Cleaner2();
                    textque1_3.setText("Вопрос " + count + ":" + "\n" + "         " + questions2[count - 1].getTask());
                    txtfieldque1_3.setVisible(true);//сделать поле ввода видимым
                    break;
                case ("4=="):
                    Cleaner2();
                    quevis4();
                    textque1_3.setText("Вопрос " + count + ":" + "\n" + "         " + questions2[count - 1].getTask());
                    for(int i = 0; i < 4;i++){
                        combo3.getItems().add(questions2[count - 1].allAnswers[i]);
                        combo1.getItems().add(questions2[count - 1].allAnswers[i]);
                        combo2.getItems().add(questions2[count - 1].allAnswers[i]);
                        combo4.getItems().add(questions2[count - 1].allAnswers[i]);
                    }
                    textque41.setText(questions2[count - 1].correct[3]);
                    textque42.setText(questions2[count - 1].correct[2]);
                    textque43.setText(questions2[count - 1].correct[0]);
                    textque44.setText(questions2[count - 1].correct[1]);
                    break;
            }
        }
        if((count > 1) && (count <= amount + 1)){//проверка правильности введенных ответов
            back2.setDisable(false);
            back1.setDisable(false);
            switch (questions2[count - 2].quetype()){
                case ("1=="):
                    type = questions2[count - 2].allAnswers[0];
                    if(radio1.isSelected()){
                        type = "1"; }
                    else if(radio2.isSelected()){
                        type = "2"; }
                    else if(radio3.isSelected()){
                        type = "3"; }
                    else if(radio4.isSelected()){
                        type = "4"; }
                    if(questions2[count - 2].correct[0].contains(type)){
                        a++;//если ответ совпал то +1 к правильным ответам
                        itog[count - 2] = 1;
                        }
                    break;
                case ("2=="):
                    type = "";
                    if(radio11.isSelected()){
                        type = type + "1"; }
                    if(radio21.isSelected()){
                        type = type + "2"; }
                    if(radio31.isSelected()){
                        type = type + "3"; }
                    if(radio41.isSelected()){
                        type = type + "4"; }
                    if ((questions2[count - 2].correct[0].contains(type)) &&
                            (type.length()== questions2[count - 2].correct[0].length())){
                        a++;
                        itog[count - 2] = 1;}
                    break;
                case ("3=="):
                    type = txtfieldque1_3.getText();
                    if(questions2[count - 2].correct[0].contains(type) &&
                            (type.length()== questions2[count - 2].correct[0].length())){
                        a++;
                        itog[count - 2] = 1;}
                    break;
                case ("4=="):
                    if((combo3.getValue() == questions2[count - 2].allAnswers[0]) && (combo4.getValue() == questions2[count - 2].allAnswers[1]) && (combo2.getValue() == questions2[count - 2].allAnswers[2]) && (combo1.getValue() == questions2[count - 2].allAnswers[3])){
                        a++;
                        itog[count - 2] = 1;}
                    break;
            }
        }
        if(count > amount){//вывод строки с правильными ответами
            Cleaner2();
            textque1_3.setText("Вы правильно ответили на " + a + " вопросов из " + amount);
            correct.setDisable(false);
            back2.setDisable(true);
            Next2.setDisable(true);
            }
        }
        catch(IOException e){
            error();
            On1();
        }}




    public Questions[] questions = new Questions[50];//массив вопросов
    public Questions[] questions2 = new Questions[50];
    public int[] itog = new int[50];//массив ответов
}
