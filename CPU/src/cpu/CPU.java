/*
 I ran a FCFS Scheduler that lets a user input the burst times for each process.
The user can also choose to have 1-10 processes or press a button that creates
5 random burst times for 5 different processes. Then the user can press the
calculate button to get the wait times and turnaround times for each process,and
get the average wait time and average turnaround time for the whole scheduler.
So I assumed 10 processes would be enough, I also let the user input however much
burst time they want. I did however, restrict the random burst times button to
calculate a more reasonable random burst time between 1 and 50. 
 */
package cpu;


import java.util.Random;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

/**
 *
 * @author Edwin
 */
public class CPU extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //CREATING THE TITLE TEXTS
        Label txt = new Label ("Select # of Processes:");
        Label txt1 = new Label ("Process");
        Label txt2 = new Label ("Burst(ms)");
        Label txt3 = new Label ("Wait Time");
        Label txt4 = new Label ("T/A Time");
        Label txt5 = new Label ();
        txt1.setUnderline(true);
        txt2.setUnderline(true);
        txt3.setUnderline(true);
        txt4.setUnderline(true);
        
        //CREATING ALL THE ROWS FOR EACH PROCESS,INPUT,WAIT TIME, AND TA TIME
        HBox row3 = new HBox(120);
        HBox row4 = new HBox(120);
        HBox row5 = new HBox(120);
        HBox row6 = new HBox(120);
        HBox row7 = new HBox(120);
        HBox row8 = new HBox(120);
        HBox row9 = new HBox(120);
        HBox row10 = new HBox(120);
        HBox row11 = new HBox(120);
        HBox row12 = new HBox(120);
        HBox row13 = new HBox(120);
        
        //CREATING THE COMBOBOX THAT LETS THE USER CHOOSE THE NUMBER OF PROCESSES
        ObservableList<String> options = FXCollections.observableArrayList("1", "2", "3","4", "5", "6","7", "8", "9","10");
        ComboBox comboBox = new ComboBox(options);
        comboBox.getSelectionModel().selectFirst();

        //CREATING THE VERTICAL BOX THAT HOLDS ALL THE ROWS OF INFO, AND THE TWO
        //BUTTONS FOR THE RANDOM BURSTS AND CALCULATIONS
        VBox process1 = new VBox(10);
        Button btn = new Button();
        Button btn2 = new Button();
        
        //FIRST ROW OF THE GUI
        HBox row1 = new HBox(27);
        row1.getChildren().addAll(txt,comboBox,btn2,btn);
        row1.setTranslateX(10);
        row1.setTranslateY(10);


        //SECOND ROW OF THE GUI
        HBox row2 = new HBox(85);
        row2.getChildren().addAll(txt1,txt2,txt3,txt4);
        row2.setTranslateX(40);
        row2.setTranslateY(30);

        
        // Create a tile pane
        TilePane root = new TilePane();

        //CREATING ALL THE PROCESSES NAMES, INPUT BOXES, WAIT TIMES, & TA TIMES
        Label p1 = new Label ("P1");
            TextField burstText1 = new TextField();
            burstText1.setPrefWidth(45);
            Label p1wait = new Label("0");
            Label p1TA = new Label("0");
            Label p2 = new Label ("P2");
            TextField burstText2 = new TextField();
            burstText2.setPrefWidth(45);
            Label p2wait = new Label("0");
            Label p2TA = new Label("0");
            Label p3 = new Label ("P3");
            TextField burstText3 = new TextField();
            burstText3.setPrefWidth(45);
            Label p3wait = new Label("0");
            Label p3TA = new Label("0");
            Label p4 = new Label ("P4");
            TextField burstText4 = new TextField();
            burstText4.setPrefWidth(45);
            Label p4wait = new Label("0");
            Label p4TA = new Label("0");
            Label p5 = new Label ("P5");
            TextField burstText5 = new TextField();
            burstText5.setPrefWidth(45);
            Label p5wait = new Label("0");
            Label p5TA = new Label("0");
            Label p6 = new Label ("P6");
            TextField burstText6 = new TextField();
            burstText6.setPrefWidth(45);
            Label p6wait = new Label("0");
            Label p6TA = new Label("0");
            Label p7 = new Label ("P7");
            TextField burstText7 = new TextField();
            burstText7.setPrefWidth(45);
            Label p7wait = new Label("0");
            Label p7TA = new Label("0");
            Label p8 = new Label ("P8");
            TextField burstText8 = new TextField();
            burstText8.setPrefWidth(45);
            Label p8wait = new Label("0");
            Label p8TA = new Label("0");
            Label p9 = new Label ("P9");
            TextField burstText9 = new TextField();
            burstText9.setPrefWidth(45);
            Label p9wait = new Label("0");
            Label p9TA = new Label("0");
            Label p10 = new Label ("P10");
            TextField burstText10 = new TextField();
            burstText10.setPrefWidth(45);
            Label p10wait = new Label("0");
            Label p10TA = new Label("0");
            Label average = new Label("Avg:");
            Label waitavg = new Label("0");
            Label TAavg = new Label("0");
                        
            //ADDING ALL THE LABELS TO ROWS AND TO THE GUI TO BE DISPLAYED
            row3.getChildren().clear();
            row3.getChildren().addAll(p1,burstText1,p1wait,p1TA);
            row3.setTranslateX(60);
            row3.setTranslateY(60);
            row4.getChildren().clear();
            row4.getChildren().addAll(p2,burstText2,p2wait,p2TA);
            row4.setTranslateX(60);
            row4.setTranslateY(60);
            row5.getChildren().clear();
            row5.getChildren().addAll(p3,burstText3,p3wait,p3TA);
            row5.setTranslateX(60);
            row5.setTranslateY(60);
            row6.getChildren().clear();
            row6.getChildren().addAll(p4,burstText4,p4wait,p4TA);
            row6.setTranslateX(60);
            row6.setTranslateY(60);
            row7.getChildren().clear();
            row7.getChildren().addAll(p5,burstText5,p5wait,p5TA);
            row7.setTranslateX(60);
            row7.setTranslateY(60);
            row8.getChildren().clear();
            row8.getChildren().addAll(p6,burstText6,p6wait,p6TA);
            row8.setTranslateX(60);
            row8.setTranslateY(60);
            row9.getChildren().clear();
            row9.getChildren().addAll(p7,burstText7,p7wait,p7TA);
            row9.setTranslateX(60);
            row9.setTranslateY(60);
            row10.getChildren().clear();
            row10.getChildren().addAll(p8,burstText8,p8wait,p8TA);
            row10.setTranslateX(60);
            row10.setTranslateY(60);
            row11.getChildren().clear();
            row11.getChildren().addAll(p9,burstText9,p9wait,p9TA);
            row11.setTranslateX(60);
            row11.setTranslateY(60);
            row12.getChildren().clear();
            row12.getChildren().addAll(p10,burstText10,p10wait,p10TA);
            row12.setTranslateX(60);
            row12.setTranslateY(60);
            row13.setTranslateX(210);
            row13.setTranslateY(60);
            row13.getChildren().addAll(average,waitavg,TAavg);
            
            
            process1.getChildren().addAll(row1,row2,row3,row13);
            root.getChildren().addAll(process1);

        
        //the random burst times button will assign 5 random integerw from
        //1-50 to the 5 input boxes
        btn2.setText("Random Burst Times");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Random rd = new Random(); // creating Random object
                int[] arr = new int[5];//creating an array to hold 5 random integers
                for (int i = 0; i < arr.length; i++) {
                    int low = 1;
                    int high = 50;
                    int result = rd.nextInt(high-low) + low;//creates a random int from 1-50
                    arr[i] = result; // storing random integers in an array
                }
                
                String number1=Integer.toString(arr[0]);
                String number2=Integer.toString(arr[1]);
                String number3=Integer.toString(arr[2]);
                String number4=Integer.toString(arr[3]);
                String number5=Integer.toString(arr[4]);
                
                burstText1.setText(number1);
                burstText2.setText(number2);
                burstText3.setText(number3);
                burstText4.setText(number4);
                burstText5.setText(number5);
                        
                
                        root.getChildren().remove(process1);
                        process1.getChildren().clear();
                        row1.getChildren().clear();
                        row1.getChildren().addAll(txt,comboBox,btn2,btn);
                        row1.setTranslateX(10);
                        row1.setTranslateY(10);
                        row2.getChildren().clear();
                        row2.getChildren().addAll(txt1,txt2,txt3,txt4);
                        row2.setTranslateX(40);
                        row2.setTranslateY(30);
                        row3.getChildren().clear();
                        row3.getChildren().addAll(p1,burstText1,p1wait,p1TA);
                        row3.setTranslateX(60);
                        row3.setTranslateY(60);
                        row4.getChildren().clear();
                        row4.getChildren().addAll(p2,burstText2,p2wait,p2TA);
                        row4.setTranslateX(60);
                        row4.setTranslateY(60);
                        row5.getChildren().clear();
                        row5.getChildren().addAll(p3,burstText3,p3wait,p3TA);
                        row5.setTranslateX(60);
                        row5.setTranslateY(60);
                        row6.getChildren().clear();
                        row6.getChildren().addAll(p4,burstText4,p4wait,p4TA);
                        row6.setTranslateX(60);
                        row6.setTranslateY(60);
                        row7.getChildren().clear();
                        row7.getChildren().addAll(p5,burstText5,p5wait,p5TA);
                        row7.setTranslateX(60);
                        row7.setTranslateY(60);
                        row13.setTranslateX(210);
                        row13.setTranslateY(60);
                        process1.getChildren().addAll(row1,row2,row3,row4,row5,row6,row7,row13);//************
                        root.getChildren().addAll(process1);
                     
                        comboBox.getSelectionModel().select(4);
            }
        });
     
        
        
  
 
        // Create a scene
        Scene scene = new Scene(root, 600, 600);
        
        
        //the comboBox will add and remove rows of processes depending
        //on the # of processes the user wants to do
        comboBox.setOnAction((e) -> {
            root.getChildren().remove(process1);
            process1.getChildren().clear();
            process1.getChildren().addAll(row1,row2);
            
            String choice=(String)comboBox.getValue();
            int most = Integer.parseInt(choice);
            switch (most) {
                case 1:
                    process1.getChildren().addAll(row3,row13);
                    break;
                case 2:
                    process1.getChildren().addAll(row3,row4,row13);
                    break;
                case 3:
                    process1.getChildren().addAll(row3,row4,row5,row13);
                    break;
                case 4:
                    process1.getChildren().addAll(row3,row4,row5,row6,row13);
                    break;
                case 5:
                    process1.getChildren().addAll(row3,row4,row5,row6,row7,row13);
                    break;
                case 6:
                    process1.getChildren().addAll(row3,row4,row5,row6,row7,row8,row13);
                    break;
                case 7:
                    process1.getChildren().addAll(row3,row4,row5,row6,row7,row8,row9,row13);
                    break;
                case 8:
                    process1.getChildren().addAll(row3,row4,row5,row6,row7,row8,row9,row10,row13);
                    break;
                case 9:
                    process1.getChildren().addAll(row3,row4,row5,row6,row7,row8,row9,row10,row11,row13);
                    break;
                case 10:
                    process1.getChildren().addAll(row3,row4,row5,row6,row7,row8,row9,row10,row11,row12,row13);
                    break;
                default:
                    break;
            }
            root.getChildren().addAll(process1);
        });
        
        //CALCULATE BUTTON WILL CALCULATE THE WAIT TIMES, TA TIMES, AND THE
        //AVERAGES FOR EVERYTHING
        btn.setText("Calculate");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            String choice=(String)comboBox.getValue();
            float most = Integer.parseInt(choice);
            if (most==1){
                int burst1 = Integer.parseInt(burstText1.getText());
                p1wait.setText("0");
                p1TA.setText(String.valueOf(burst1));
                waitavg.setText("0");
                TAavg.setText(String.valueOf(burst1));
            } else if (most==2){
                int burst1 = Integer.parseInt(burstText1.getText());
                p1wait.setText("0");
                p1TA.setText(String.valueOf(burst1));
                int burst2 = Integer.parseInt(burstText2.getText());
                p2wait.setText(String.valueOf(burst1));
                p2TA.setText(String.valueOf(burst1+burst2));
                waitavg.setText(String.valueOf(burst1/most));
                TAavg.setText(String.valueOf((burst1+burst2)/most));
                waitavg.setText(String.valueOf((burst1)/most));
                TAavg.setText(String.valueOf((2*burst1+burst2)/most));
            } else if (most==3){
                int burst1 = Integer.parseInt(burstText1.getText());
                p1wait.setText("0");
                p1TA.setText(String.valueOf(burst1));
                int burst2 = Integer.parseInt(burstText2.getText());
                p2wait.setText(String.valueOf(burst1));
                p2TA.setText(String.valueOf(burst1+burst2));
                int burst3 = Integer.parseInt(burstText3.getText());
                p3wait.setText(String.valueOf(burst1+burst2));
                p3TA.setText(String.valueOf(burst1+burst2+burst3));
                waitavg.setText(String.valueOf((burst1+burst2)/most));
                TAavg.setText(String.valueOf((burst1+burst2+burst3)/most));
                waitavg.setText(String.valueOf((2*burst1+burst2)/most));
                TAavg.setText(String.valueOf((3*burst1+2*burst2+burst3)/most));
            } else if (most==4){
                int burst1 = Integer.parseInt(burstText1.getText());
                p1wait.setText("0");
                p1TA.setText(String.valueOf(burst1));
                int burst2 = Integer.parseInt(burstText2.getText());
                p2wait.setText(String.valueOf(burst1));
                p2TA.setText(String.valueOf(burst1+burst2));
                int burst3 = Integer.parseInt(burstText3.getText());
                p3wait.setText(String.valueOf(burst1+burst2));
                p3TA.setText(String.valueOf(burst1+burst2+burst3));
                int burst4 = Integer.parseInt(burstText4.getText());
                p4wait.setText(String.valueOf(burst1+burst2+burst3));
                p4TA.setText(String.valueOf(burst1+burst2+burst3+burst4));
                waitavg.setText(String.valueOf((3*burst1+2*burst2+burst3)/most));
                TAavg.setText(String.valueOf((4*burst1+3*burst2+2*burst3+burst4)/most));
            } else if (most==5){
                int burst1 = Integer.parseInt(burstText1.getText());
                p1wait.setText("0");
                p1TA.setText(String.valueOf(burst1));
                int burst2 = Integer.parseInt(burstText2.getText());
                p2wait.setText(String.valueOf(burst1));
                p2TA.setText(String.valueOf(burst1+burst2));
                int burst3 = Integer.parseInt(burstText3.getText());
                p3wait.setText(String.valueOf(burst1+burst2));
                p3TA.setText(String.valueOf(burst1+burst2+burst3));
                int burst4 = Integer.parseInt(burstText4.getText());
                p4wait.setText(String.valueOf(burst1+burst2+burst3));
                p4TA.setText(String.valueOf(burst1+burst2+burst3+burst4));
                int burst5 = Integer.parseInt(burstText5.getText());
                p5wait.setText(String.valueOf(burst1+burst2+burst3+burst4));
                p5TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5));
                waitavg.setText(String.valueOf((4*burst1+3*burst2+2*burst3+burst4)/most));
                TAavg.setText(String.valueOf((5*burst1+4*burst2+3*burst3+2*burst4+burst5)/most));
            } else if (most==6){
                int burst1 = Integer.parseInt(burstText1.getText());
                p1wait.setText("0");
                p1TA.setText(String.valueOf(burst1));
                int burst2 = Integer.parseInt(burstText2.getText());
                p2wait.setText(String.valueOf(burst1));
                p2TA.setText(String.valueOf(burst1+burst2));
                int burst3 = Integer.parseInt(burstText3.getText());
                p3wait.setText(String.valueOf(burst1+burst2));
                p3TA.setText(String.valueOf(burst1+burst2+burst3));
                int burst4 = Integer.parseInt(burstText4.getText());
                p4wait.setText(String.valueOf(burst1+burst2+burst3));
                p4TA.setText(String.valueOf(burst1+burst2+burst3+burst4));
                int burst5 = Integer.parseInt(burstText5.getText());
                p5wait.setText(String.valueOf(burst1+burst2+burst3+burst4));
                p5TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5));
                int burst6 = Integer.parseInt(burstText6.getText());
                p6wait.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5));
                p6TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6));
                waitavg.setText(String.valueOf((5*burst1+4*burst2+3*burst3+2*burst4+burst5)/most));
                TAavg.setText(String.valueOf((6*burst1+5*burst2+4*burst3+3*burst4+2*burst5+burst6)/most));
            } else if (most==7){
                int burst1 = Integer.parseInt(burstText1.getText());
                p1wait.setText("0");
                p1TA.setText(String.valueOf(burst1));
                int burst2 = Integer.parseInt(burstText2.getText());
                p2wait.setText(String.valueOf(burst1));
                p2TA.setText(String.valueOf(burst1+burst2));
                int burst3 = Integer.parseInt(burstText3.getText());
                p3wait.setText(String.valueOf(burst1+burst2));
                p3TA.setText(String.valueOf(burst1+burst2+burst3));
                int burst4 = Integer.parseInt(burstText4.getText());
                p4wait.setText(String.valueOf(burst1+burst2+burst3));
                p4TA.setText(String.valueOf(burst1+burst2+burst3+burst4));
                int burst5 = Integer.parseInt(burstText5.getText());
                p5wait.setText(String.valueOf(burst1+burst2+burst3+burst4));
                p5TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5));
                int burst6 = Integer.parseInt(burstText6.getText());
                p6wait.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5));
                p6TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6));
                int burst7 = Integer.parseInt(burstText7.getText());
                p7wait.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6));
                p7TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6+burst7));
                waitavg.setText(String.valueOf((6*burst1+5*burst2+4*burst3+3*burst4+2*burst5+burst6)/most));
                TAavg.setText(String.valueOf((7*burst1+6*burst2+5*burst3+4*burst4+3*burst5+2*burst6+burst7)/most));
            } else if (most==8){
                int burst1 = Integer.parseInt(burstText1.getText());
                p1wait.setText("0");
                p1TA.setText(String.valueOf(burst1));
                int burst2 = Integer.parseInt(burstText2.getText());
                p2wait.setText(String.valueOf(burst1));
                p2TA.setText(String.valueOf(burst1+burst2));
                int burst3 = Integer.parseInt(burstText3.getText());
                p3wait.setText(String.valueOf(burst1+burst2));
                p3TA.setText(String.valueOf(burst1+burst2+burst3));
                int burst4 = Integer.parseInt(burstText4.getText());
                p4wait.setText(String.valueOf(burst1+burst2+burst3));
                p4TA.setText(String.valueOf(burst1+burst2+burst3+burst4));
                int burst5 = Integer.parseInt(burstText5.getText());
                p5wait.setText(String.valueOf(burst1+burst2+burst3+burst4));
                p5TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5));
                int burst6 = Integer.parseInt(burstText6.getText());
                p6wait.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5));
                p6TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6));
                int burst7 = Integer.parseInt(burstText7.getText());
                p7wait.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6));
                p7TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6+burst7));
                int burst8 = Integer.parseInt(burstText8.getText());
                p8wait.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6+burst7));
                p8TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6+burst7+burst8));
                waitavg.setText(String.valueOf((7*burst1+6*burst2+5*burst3+4*burst4+3*burst5+2*burst6+burst7)/most));
                TAavg.setText(String.valueOf((8*burst1+7*burst2+6*burst3+5*burst4+4*burst5+3*burst6+2*burst7+burst8)/most));
            } else if (most==9){
                int burst1 = Integer.parseInt(burstText1.getText());
                p1wait.setText("0");
                p1TA.setText(String.valueOf(burst1));
                int burst2 = Integer.parseInt(burstText2.getText());
                p2wait.setText(String.valueOf(burst1));
                p2TA.setText(String.valueOf(burst1+burst2));
                int burst3 = Integer.parseInt(burstText3.getText());
                p3wait.setText(String.valueOf(burst1+burst2));
                p3TA.setText(String.valueOf(burst1+burst2+burst3));
                int burst4 = Integer.parseInt(burstText4.getText());
                p4wait.setText(String.valueOf(burst1+burst2+burst3));
                p4TA.setText(String.valueOf(burst1+burst2+burst3+burst4));
                int burst5 = Integer.parseInt(burstText5.getText());
                p5wait.setText(String.valueOf(burst1+burst2+burst3+burst4));
                p5TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5));
                int burst6 = Integer.parseInt(burstText6.getText());
                p6wait.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5));
                p6TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6));
                int burst7 = Integer.parseInt(burstText7.getText());
                p7wait.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6));
                p7TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6+burst7));
                int burst8 = Integer.parseInt(burstText8.getText());
                p8wait.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6+burst7));
                p8TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6+burst7+burst8));
                int burst9 = Integer.parseInt(burstText9.getText());
                p9wait.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6+burst7+burst8));
                p9TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6+burst7+burst8+burst9));
                waitavg.setText(String.valueOf((8*burst1+7*burst2+6*burst3+5*burst4+4*burst5+3*burst6+2*burst7+burst8)/most));
                TAavg.setText(String.valueOf((9*burst1+8*burst2+7*burst3+6*burst4+5*burst5+4*burst6+3*burst7+2*burst8+burst9)/most));
            } else if (most==10){
                int burst1 = Integer.parseInt(burstText1.getText());
                p1wait.setText("0");
                p1TA.setText(String.valueOf(burst1));
                int burst2 = Integer.parseInt(burstText2.getText());
                p2wait.setText(String.valueOf(burst1));
                p2TA.setText(String.valueOf(burst1+burst2));
                int burst3 = Integer.parseInt(burstText3.getText());
                p3wait.setText(String.valueOf(burst1+burst2));
                p3TA.setText(String.valueOf(burst1+burst2+burst3));
                int burst4 = Integer.parseInt(burstText4.getText());
                p4wait.setText(String.valueOf(burst1+burst2+burst3));
                p4TA.setText(String.valueOf(burst1+burst2+burst3+burst4));
                int burst5 = Integer.parseInt(burstText5.getText());
                p5wait.setText(String.valueOf(burst1+burst2+burst3+burst4));
                p5TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5));
                int burst6 = Integer.parseInt(burstText6.getText());
                p6wait.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5));
                p6TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6));
                int burst7 = Integer.parseInt(burstText7.getText());
                p7wait.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6));
                p7TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6+burst7));
                int burst8 = Integer.parseInt(burstText8.getText());
                p8wait.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6+burst7));
                p8TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6+burst7+burst8));
                int burst9 = Integer.parseInt(burstText9.getText());
                p9wait.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6+burst7+burst8));
                p9TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6+burst7+burst8+burst9));
                int burst10 = Integer.parseInt(burstText10.getText());
                p10wait.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6+burst7+burst8+burst9));
                p10TA.setText(String.valueOf(burst1+burst2+burst3+burst4+burst5+burst6+burst7+burst8+burst9+burst10));
                waitavg.setText(String.valueOf((9*burst1+8*burst2+7*burst3+6*burst4+5*burst5+4*burst6+3*burst7+2*burst8+burst9)/most));
                TAavg.setText(String.valueOf((10*burst1+9*burst2+8*burst3+7*burst4+6*burst5+5*burst6+4*burst7+3*burst8+2*burst9+burst10)/most));
            }      
            }
        });
        
        primaryStage.setTitle("CPU FCFS Scheduler Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
   
    
}
