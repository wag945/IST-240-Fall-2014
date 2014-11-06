/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */
class Answer {
    
    XML_240 x2;
    AnswerData[] k12Answers;
    AnswerData[] undergradAnswers;
    AnswerData[] gradAnswers;
    int NUM_ANSWERS = 7;
    
    public Answer()
    {
        k12Answers = new AnswerData[NUM_ANSWERS];
        undergradAnswers = new AnswerData[NUM_ANSWERS];
        gradAnswers = new AnswerData[NUM_ANSWERS];
        x2 = new XML_240(); // creates the 240 class that reads and writes XML
        int questionId = 0;
        String question = "";
        String category = "";
        String answer1 = "";
        String answer2 = "";
        String answer3 = "";
        int correctAnswer = 0;
        x2.openReaderXML("K12Answers.xml");
        for (int i = 0; i < k12Answers.length; i++)
        {
            questionId = (Integer)x2.ReadObject();
            category = (String)x2.ReadObject();
            question = (String)x2.ReadObject();
            answer1 = (String)x2.ReadObject();
            answer2 = (String)x2.ReadObject();
            answer3 = (String)x2.ReadObject();
            correctAnswer = (Integer)x2.ReadObject();
            k12Answers[i] = new AnswerData(questionId,category,question,answer1,answer2,answer3,correctAnswer);
        }
        
        x2.closeReaderXML();
    }
    
    void printK12Answers()
    {
        for (int i = 0; i < k12Answers.length; i++)
        {
            System.out.println("questionId = "+k12Answers[i].getQuestionId());
            System.out.println("category = "+k12Answers[i].getCategory());
            System.out.println("question = "+k12Answers[i].getQuestion());
            System.out.println("answer1 = "+k12Answers[i].getAnswer1());
            System.out.println("answer2 = "+k12Answers[i].getAnswer2());
            System.out.println("answer3 = "+k12Answers[i].getAnswer3());
            System.out.println("correctAnswer = "+k12Answers[i].getCorrectAnswer());
        }
    }
    
    void printUndergradAnswers()
    {
        for (int i = 0; i < undergradAnswers.length; i++)
        {
            System.out.println("questionId = "+undergradAnswers[i].getQuestionId());
            System.out.println("category = "+undergradAnswers[i].getCategory());
            System.out.println("question = "+undergradAnswers[i].getQuestion());
            System.out.println("answer1 = "+undergradAnswers[i].getAnswer1());
            System.out.println("answer2 = "+undergradAnswers[i].getAnswer2());
            System.out.println("answer3 = "+undergradAnswers[i].getAnswer3());
            System.out.println("correctAnswer = "+undergradAnswers[i].getCorrectAnswer());
        }
    }
    
    void printGradAnswers()
    {
        for (int i = 0; i < gradAnswers.length; i++)
        {
            System.out.println("questionId = "+gradAnswers[i].getQuestionId());
            System.out.println("category = "+gradAnswers[i].getCategory());
            System.out.println("question = "+gradAnswers[i].getQuestion());
            System.out.println("answer1 = "+gradAnswers[i].getAnswer1());
            System.out.println("answer2 = "+gradAnswers[i].getAnswer2());
            System.out.println("answer3 = "+gradAnswers[i].getAnswer3());
            System.out.println("correctAnswer = "+gradAnswers[i].getCorrectAnswer());
        }
    }
    
    AnswerData getAnswerDataByQuestionId(String difficulty,int id)
    {
        //Create default AnswerData object
        AnswerData data = new AnswerData(0,"","","","","",0);
        
        if (difficulty.equals("K12"))   
        {
            for (int i = 0; i < k12Answers.length; i++)
            {
                if (k12Answers[i].getQuestionId() == id)
                {
                    //save found AnswerData
                    data = k12Answers[i];
                }
            }
        }
        else if (difficulty.equals("Undergrad"))
        {
            for (int i = 0; i < undergradAnswers.length; i++)
            {
                if (undergradAnswers[i].getQuestionId() == id)
                {
                    //save found AnswerData
                    data = undergradAnswers[i];
                }
            }
        }
        else if (difficulty.equals("Grad"))
        {
            for (int i = 0; i < gradAnswers.length; i++)
            {
                if (gradAnswers[i].getQuestionId() == id)
                {
                    //save found AnswerData
                    data = gradAnswers[i];
                }
            }            
        }
        
        return data;
    }
    
    int getRandomQuestionNumber()
    {
        int number = 0;
        double r = Math.random();
        number = (int) (r * (float)NUM_ANSWERS);
        //Make sure range is 1..NUM_ANSWERS
        return number+1;
    }

}
