import java.util.*;

class task4
{
    static class Question 
    {
        String question;
        String[] options;
        int correctAnswer;
	public Question(String question, String[] options, int correctAnswer) 
	{
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();
        
        
        questions.add(new Question("What is the capital of India?", new String[]{"1. Gujarat", "2. patna", "3.New Delhi", "4.Hyderabad"}, 3));
        questions.add(new Question("Which data structure follows LIFO?", new String[]{"1. Queue", "2. Stack", "3. Tree", "4. Graph"}, 2));
        questions.add(new Question("What does JVM stand for?", new String[]{"1. Java Virtual Machine", "2. Java Visual Model", "3. Java Version Maker", "4. Just Virtual Memory"}, 1));
        
        int score = 0;
        int questionNumber = 1;

        for (Question q : questions) 
	{
            System.out.println("\nQuestion " + questionNumber + ": " + q.question);
            for (String option : q.options) 
	    {
                System.out.println(option);
            }

            long startTime = System.currentTimeMillis();
            boolean answered = false;

            while (System.currentTimeMillis() - startTime < 10000)
	   { 
                if (scanner.hasNextInt()) 
		{
                    int answer = scanner.nextInt();
                    if (answer == q.correctAnswer)
		    {
                        System.out.println("Correct!");
                        score++;
                    } 
		    else 
		   {
                        System.out.println("Wrong! The correct answer is option " + q.correctAnswer);
                    }
                    answered = true;
                    break;
               }
          }

          if (!answered)
	 {
                System.out.println("Time's up! The correct answer was option " + q.correctAnswer);
         }
 	 questionNumber++;
      }

        System.out.println("\nQuiz Over! Your final score is: " + score + "/" + questions.size());
        scanner.close();
    }
}
