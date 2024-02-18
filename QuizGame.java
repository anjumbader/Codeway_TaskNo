import java.util.*;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctOption;

    public QuizQuestion(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

public class QuizGame {
    private static final int QUESTION_DURATION_SECONDS = 10;

    private static Scanner scanner = new Scanner(System.in);
    private static Timer timer = new Timer();

    private static List<QuizQuestion> quizQuestions;
    private static int currentQuestionIndex = 0;
    private static int score = 0;

    public static void main(String[] args) {
        initializeQuiz();

        System.out.println("Welcome to the Quiz Game!");
        System.out.println("You will have " + QUESTION_DURATION_SECONDS + " seconds to answer each question.");
        System.out.println("Let's begin!\n");

        askQuestion();
    }

    private static void initializeQuiz() {
        // Initialize quiz questions
        quizQuestions = new ArrayList<>();
        quizQuestions.add(new QuizQuestion("What is the capital of France?", Arrays.asList("A. London", "B. Paris", "C. Rome", "D. Berlin"), 1));
        quizQuestions.add(new QuizQuestion("What is the largest planet in our solar system?", Arrays.asList("A. Venus", "B. Jupiter", "C. Mars", "D. Saturn"), 1));
        // Add more questions as needed
    }

    private static void askQuestion() {
        if (currentQuestionIndex < quizQuestions.size()) {
            QuizQuestion currentQuestion = quizQuestions.get(currentQuestionIndex);
            System.out.println("Question " + (currentQuestionIndex + 1) + ": " + currentQuestion.getQuestion());
            for (String option : currentQuestion.getOptions()) {
                System.out.println(option);
            }

            startTimer();
            String userAnswer = scanner.nextLine().trim().toUpperCase();
            stopTimer();

            checkAnswer(currentQuestion, userAnswer);

            currentQuestionIndex++;
            askQuestion();
        } else {
            displayResult();
        }
    }

    private static void startTimer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                scanner.nextLine(); // Consume newline
                checkAnswer(null, "");
            }
        }, QUESTION_DURATION_SECONDS * 1000);
    }

    private static void stopTimer() {
        timer.cancel();
        timer = new Timer();
    }

    private static void checkAnswer(QuizQuestion question, String userAnswer) {
        if (question != null && userAnswer.equals(question.getOptions().get(question.getCorrectOption() - 1).substring(0, 1))) {
            System.out.println("Correct!");
            score++;
        } else if (question != null) {
            System.out.println("Incorrect!");
        } else {
            System.out.println("Time's up!");
        }
    }

    private static void displayResult() {
        System.out.println("\nQuiz ended!");
        System.out.println("Your final score: " + score + "/" + quizQuestions.size());

        // Display correct and incorrect answers
        for (int i = 0; i < quizQuestions.size(); i++) {
            QuizQuestion currentQuestion = quizQuestions.get(i);
            String status = currentQuestion.getOptions().get(currentQuestion.getCorrectOption() - 1).substring(0, 1);
            System.out.println("Question " + (i + 1) + ": " + (status.equals(scanner.nextLine().trim().toUpperCase()) ? "Correct" : "Incorrect"));
        }

        scanner.close();
    }
}
