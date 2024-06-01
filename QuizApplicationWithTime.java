import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
//forming class for questions which will be included
class Question {
    String question;
    String[] options;
    char correctoption;

    public Question(String question, String[] options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctoption = correctAnswer;
    }
}
//This class represent Quiz Application
public class QuizApplicationWithTime extends JFrame implements ActionListener {
    static List<Question> questions;
    static int score = 0;
    static int currentQuestion = 0;
    static final int ALLOTTED_TIME = 20; // time in seconds
    Timer timer;
    int timeRemaining = ALLOTTED_TIME;

    JLabel questionLabel;
    JRadioButton[] optionsButtons;
    JButton submitButton;
    JLabel timerLabel;
    ButtonGroup optionsGroup;
//This constructor required for initialising Quiz Application
    public QuizApplicationWithTime() {
        setTitle("Quiz Application");//setting title
        setSize(400, 300);//setting size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
//Creating and configuring the components of GUI
        questionLabel = new JLabel("");
        add(questionLabel, BorderLayout.NORTH);

        optionsButtons = new JRadioButton[4];
        optionsGroup = new ButtonGroup();
        JPanel optionsl = new JPanel();
        optionsl.setLayout(new GridLayout(4, 1));
        for (int i = 0; i < 4; i++) {
            optionsButtons[i] = new JRadioButton();
            optionsGroup.add(optionsButtons[i]);
            optionsl.add(optionsButtons[i]);
        }
        add(optionsl, BorderLayout.CENTER);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton, BorderLayout.SOUTH);

        timerLabel = new JLabel("Time left: " + ALLOTTED_TIME + " seconds");
        add(timerLabel, BorderLayout.WEST);
//Initialise Questions and display the first Question
        initializeQuestions();
        displayQuestion(currentQuestion);
//Setup timer for each of the questions
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                timerLabel.setText("Time left: " + timeRemaining + " seconds");
                if (timeRemaining <= 0) {
                    handleAnswer(' '); // Pass empty answer to indicate time up
                }
            }
        });
        timer.start();//starting of the timer
    }
// Method to initialise the questions in the quiz
    public static void initializeQuestions() {
        questions = new ArrayList<>();

        // Insert all the questions which will be included in the quiz
        String[] options1 = {"A. Java is a platform-independent language.",
                "B. Java is a platform-dependent language.",
                "C. Java is both platform-independent and platform-dependent.",
                "D. None of the above."};
        questions.add(new Question("What is the nature of Java?", options1, 'A'));

        String[] options2 = {"A. Java is a high-level language.",
                "B. Java is a low-level language.",
                "C. Java is both high-level and low-level.",
                "D. None of the above."};
        questions.add(new Question("What is the level of Java?", options2, 'A'));

        String[] options3 = {"A. Java is an object-oriented language.",
                "B. Java is a procedural language.",
                "C. Java is both object-oriented and procedural.",
                "D. None of the above."};
        questions.add(new Question("What is the programming paradigm of Java?", options3, 'A'));

        String[] options4 = {"A. Java is a compiled language.",
                "B. Java is an interpreted language.",
                "C. Java is both compiled and interpreted.",
                "D. None of the above."};
        questions.add(new Question("What is the nature of Java compilation?", options4, 'C'));

        String[] options5 = {"A. Java is a statically typed language.",
                "B. Java is a dynamically typed language.",
                "C. Java is both statically and dynamically typed.",
                "D. None of the above."};
        questions.add(new Question("What is the type system of Java?", options5, 'A'));
    }
//Method to display the Question of the Quiz in the format of GUI
    public void displayQuestion(int index) {
        Question question = questions.get(index);
        questionLabel.setText(question.question);
        for (int i = 0; i < 4; i++) {
            optionsButtons[i].setText(question.options[i]);
        }
        optionsGroup.clearSelection();
        timeRemaining = ALLOTTED_TIME;
    }
//ActionListner implement submit button
    @Override
    public void actionPerformed(ActionEvent e) {
        char selectedOption = ' ';
        for (int i = 0; i < 4; i++) {
            if (optionsButtons[i].isSelected()) {
                selectedOption = (char) ('A' + i);
                break;
            }
        }
        handleAnswer(selectedOption);
    }
//To handle Answers of the Quiz questions
    public void handleAnswer(char answer) {
        timer.stop();
        if (answer == questions.get(currentQuestion).correctoption) {
            score++;
            JOptionPane.showMessageDialog(this, "Correct!");
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect.");
        }
        currentQuestion++;//move to next question
        if (currentQuestion < questions.size()) {
            displayQuestion(currentQuestion);
            timer.start();
        } else {
            //Display the final score which the user had got
            JOptionPane.showMessageDialog(this, "Quiz finished! Your score: " + score + "/" + questions.size());
            System.exit(0);
        }
    }
//initialisation of main method for quiz application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuizApplicationWithTime quizApp = new QuizApplicationWithTime();
            quizApp.setVisible(true);
        });
    }
}
