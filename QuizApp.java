import java.util.ArrayList;
import java.util.Collections;

public class QuizApp {
    enum Type {MultipleChoice, TrueOrFalse, FillBlank}

    enum Level {Hard, Easy, Challenge}

    public static void main(String[] args) {
        // name of main class
        QuizApp quizApp = new QuizApp();

        User user = quizApp.createUser();
        ArrayList<Question> questions = quizApp.createQuiz1Questions();
        ArrayList<Question> questions2 = quizApp.createQuiz2Questions();

        //  Create your own data for your quiz and quiz topic. Here is an example.
        Quiz quiz1 = quizApp.createQuiz(questions, user);
        Quiz quiz2 = quizApp.createQuiz2(questions2, user);
        
        // prints both student and instructor version of the quiz.
        // You may want to create separate print methods for student and instructor.

        quizApp.printQuiz1(quiz1, user);
        System.out.println("\n");

        quizApp.printQuiz2(quiz2, user);
        System.out.println("\n");

    }

    public ArrayList<Question> createQuiz1Questions() {

        ArrayList<Answer> Quiz1Q1Answers = new ArrayList<>();
        ArrayList<Answer> Quiz1Q2Answers = new ArrayList<>();

        Quiz1Q1Answers.add(new Answer("Ans1", "Quiz1", "Quiz1Q1", true, true, "Toronto"));
        Quiz1Q1Answers.add(new Answer("Ans2", "Quiz1", "Quiz1Q1", true, false, "Kingston"));
        Quiz1Q1Answers.add(new Answer("Ans3", "Quiz1", "Quiz1Q1", true, false, "London"));
        Quiz1Q1Answers.add(new Answer("Ans4", "Quiz1", "Quiz1Q1", true, false, "Waterloo"));

        Quiz1Q2Answers.add(new Answer("Q2Ans1", "Quiz1", "Quiz1Q2", true, true, "True"));
        Quiz1Q2Answers.add(new Answer("Q2Ans2", "Quiz1", "Quiz1Q2", true, false, "False"));


        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(new Question("Quiz1", Type.MultipleChoice, Level.Easy, 2, "What is the famous city in Canada?", Quiz1Q1Answers));
        questions.add(new Question("Quiz1", Type.TrueOrFalse, Level.Hard, 2, "Niagara falls is the famous fall in Canada.", Quiz1Q2Answers));

        return questions;

    }
    public ArrayList<Question> createQuiz2Questions(){
        ArrayList<Answer> Quiz2Q1Answers = new ArrayList<>();
        ArrayList<Answer> Quiz2Q2Answers = new ArrayList<>();

        Quiz2Q1Answers.add(new Answer("Q1Ans1", "Quiz2", "Quiz2Q1", true, false, "Ryerson" ));
        Quiz2Q1Answers.add(new Answer("Q1Ans1", "Quiz2", "Quiz2Q1", true, false, "Queens" ));
        Quiz2Q1Answers.add(new Answer("Q1Ans1", "Quiz2", "Quiz2Q1", true, true, "U of T" ));
        Quiz2Q1Answers.add(new Answer("Q1Ans1", "Quiz2", "Quiz2Q1", true, false, "Seneca" ));

        Quiz2Q2Answers.add(new Answer("Q2Ans1", "Quiz1", "Quiz1Q2", true, false, "True"));
        Quiz2Q2Answers.add(new Answer("Q2Ans2", "Quiz1", "Quiz1Q2", true, true, "False"));

        ArrayList<Question> questions2 = new ArrayList<Question>();

        questions2.add(new Question("Quiz1", Type.MultipleChoice, Level.Easy, 5, "What is the best university in Canada?", Quiz2Q1Answers));
        questions2.add(new Question("Quiz1", Type.TrueOrFalse, Level.Hard, 5, "U.S. citizens need visa to visit Canada.", Quiz2Q2Answers));

        return questions2;
    }

    public User createUser() {
        User user = new User("MT", "Mahshid", "Tofigh", "mahsi_tr@yahoo.com", "387465", false,
                "Welcome, ");
        return user;
    }


    public Quiz createQuiz(ArrayList<Question>questions,User user) {
        Quiz quiz1 = new Quiz("Quiz1", "Get to know Canada", "This quiz helps you to learn about Canada.It contains multiple choice and true or false questions.",
                5, true, user.getId(), createQuiz1Questions());
        return quiz1;
    }

    public Quiz createQuiz2(ArrayList<Question>questions,User user){
        Quiz quiz2 = new Quiz("Quiz2", "Canada's universities", "This quiz helps you to know about Canada's universities. It contains multiple choice and true or false questions.",
                5, true, user.getId(),createQuiz2Questions());
        return quiz2;
    }
    public void printQuiz1(Quiz quiz1, User user){
        ArrayList<String> str = new ArrayList<>();
        str.add("A");
        str.add("B");
        str.add("C");
        str.add("D");
        System.out.println("Host: "+ quiz1.getHostId());
        System.out.println(user.getFirstName()+" "+user.getLastName());
        System.out.println(user.getIntro()+user.getFirstName());
        System.out.println("Email: "+user.getEmail());
        System.out.println("\n");
        System.out.println("Quiz Topic: "+quiz1.getTitle());
        System.out.println(quiz1.getSummary());

        Collections.shuffle(quiz1.questions);

        int i = 0;
        for(Question question : quiz1.getQuestions()){
            System.out.println(i + 1 + ") "+question.toString());

            int h = 0;
            for(Answer answer : question.getAnswers()){
                System.out.println(str.get(h)+". " + answer);
                h++;
            }
            i++;
            System.out.println();

        }
        System.out.println("-------------------------");
        System.out.println("INSTRUCTOR VERSION");
        System.out.println("-------------------------");
        System.out.println("Host: "+ quiz1.getHostId());
        System.out.println("Quiz Topic: "+quiz1.getTitle());
        System.out.println(quiz1.getSummary());
        System.out.println();

        Collections.shuffle(quiz1.questions);

        int a = 0;
        for(Question question : quiz1.getQuestions()){
            System.out.println(a + 1 + ") "+question.toString());

            Collections.shuffle(question.answers);

            int h = 0;
            for(Answer answer : question.getAnswers()){

                System.out.println(str.get(h) + ". "+answer);

                h++;
            }
            a++;
            System.out.println();
            for(Answer answer : question.getAnswers()){
                if (answer.isCorrect){
                    System.out.println("Correct answer: "+ answer);
                }

            }
            System.out.println();


        }

    }

    public void printQuiz2(Quiz quiz2, User user){
        ArrayList<String> str = new ArrayList<>();
        str.add("A");
        str.add("B");
        str.add("C");
        str.add("D");
        System.out.println("Host: "+ quiz2.getHostId());
        System.out.println(user.getFirstName()+" "+user.getLastName());
        System.out.println(user.getIntro()+user.getFirstName());
        System.out.println("Email: "+user.getEmail());
        System.out.println("\n");
        System.out.println("Quiz Topic: "+quiz2.getTitle());
        System.out.println(quiz2.getSummary());

        Collections.shuffle(quiz2.questions);

        int i = 0;
        for(Question question : quiz2.getQuestions()){
            System.out.println(i + 1 + ") "+question.toString());

            int h = 0;
            for(Answer answer : question.getAnswers()){
                System.out.println(str.get(h)+". " + answer);
                h++;
            }
            i++;
            System.out.println();

        }
        System.out.println("-------------------------");
        System.out.println("INSTRUCTOR VERSION");
        System.out.println("-------------------------");
        System.out.println("Host: "+ quiz2.getHostId());
        System.out.println("Quiz Topic: "+quiz2.getTitle());
        System.out.println(quiz2.getSummary());
        System.out.println();

        Collections.shuffle(quiz2.questions);

        int a = 0;
        for(Question question : quiz2.getQuestions()){
            System.out.println(a + 1 + ") "+question.toString());
            
            Collections.shuffle(question.answers);

            int h = 0;
            for(Answer answer : question.getAnswers()){

                System.out.println(str.get(h) + ". "+ answer);

                h++;
            }
            a++;
            System.out.println();
            for(Answer answer : question.getAnswers()){
                if (answer.isCorrect){
                    System.out.println("Correct answer: "+ answer);
                }
               
            }
            System.out.println();

        }

    }
    class Question {
        String quizId;
        Type type;
        Level level;
        int score;
        String questionText;
        ArrayList<Answer> answers = new ArrayList<>();

        public Question(String quizId, Type type, Level level, int score, String questionText, ArrayList<Answer> answers) {
            this.quizId = quizId;
            this.type = type;
            this.level = level;
            this.score = score;
            this.questionText = questionText;
            this.answers = answers;
        }
        @Override
        public String toString() {
            return "("+ score +" points):\n" +
                    questionText;
        }

        public String getQuizId() {
            return quizId;
        }

        public Type getType() {
            return type;
        }

        public Level getLevel() {
            return level;
        }

        public int getScore() {
            return score;
        }

        public String getQuestionText() {
            return questionText;
        }

        public ArrayList<Answer> getAnswers() {
            return answers;
        }


    }

    class Answer {
        String id;
        String quizId;
        String questionId;
        boolean isActive;
        boolean isCorrect;
        String answerText;

        public Answer(String id, String quizId, String questionId, boolean isActive, boolean isCorrect, String answerText) {
            this.id = id;
            this.quizId = quizId;
            this.questionId = questionId;
            this.isActive = isActive;
            this.isCorrect = isCorrect;
            this.answerText = answerText;
        }

        @Override
        public String toString() {
            return this.answerText;
        }

        public String getId() {
            return id;
        }

        public String getQuizId() {
            return quizId;
        }

        public String getQuestionId() {
            return questionId;
        }

        public boolean isActive() {
            return isActive;
        }

        public boolean isCorrect() {
            return isCorrect;
        }

        public String getAnswerText() {
            return answerText;
        }
    }

    class Quiz {
        String id;
        String title;
        String summary;
        int score;
        boolean isPublished;
        String hostId;
        ArrayList<Question> questions;

        public Quiz(String id, String title, String summary, int score, boolean isPublished, String hostId, ArrayList<Question> questions) {
            this.id = id;
            this.title = title;
            this.summary = summary;
            this.score = score;
            this.isPublished = isPublished;
            this.hostId = hostId;
            this.questions = questions;
        }

        @Override
        public String toString() {
            return "Quiz{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", summary='" + summary + '\'' +
                    ", score=" + score +
                    ", isPublished=" + isPublished +
                    ", hostId='" + hostId + '\'' +
                    ", questions=" + questions +
                    '}';
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getSummary() {
            return summary;
        }

        public int getScore() {
            return score;
        }

        public boolean isPublished() {
            return isPublished;
        }

        public String getHostId() {
            return hostId;
        }

        public ArrayList<Question> getQuestions() {
            return questions;
        }
    }

    class User {
        String id;
        String firstName;
        String lastName;
        String email;
        String password;
        boolean isHost;
        String intro;

        public User(String id, String firstName, String lastName, String email, String password, boolean isHost, String intro) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.isHost = isHost;
            this.intro = intro;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", isHost=" + isHost +
                    ", intro='" + intro + '\'' +
                    '}';
        }

        public String getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public boolean isHost() {
            return isHost;
        }

        public String getIntro() {
            return intro;
        }
    }


}
