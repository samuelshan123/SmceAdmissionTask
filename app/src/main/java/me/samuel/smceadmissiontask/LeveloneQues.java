package me.samuel.smceadmissiontask;

public class LeveloneQues {
    private String mQuestions[] = {
            "How to kill an activity in Android?",
            "On which thread services work in android?",
            "What are the functionalities of Binder services in android?",
            " What is the difference between content values and cursor in android SQlite?",
            " How to get current location in android?",
            "What is LastKnownLocation in android" ,
            "What is an HTTP client class in android?",
            " What is fragment life cycle in android?",
            " What is the purpose of super.onCreate() in android?"
    };


    private String mChoices[][] = {
            {"A - finish()", "B - finishActivity(int requestCode)", "C - A & B"},
            {"A - Worker Thread", "B - Own Thread", "C - Main Thread"},
            {"A - Binder is responsible to manage the thread while using aidl in android", "B - Binder is responsible for marshalling and un-marshalling of the data", "C - A & B"},
            {"A - Content values are key pair values, which are updated or inserted in the database"
                    , "B - Cursor is used to store the temporary result.", "C - A & B"
            },
            {"A - Using with GPRS"
                    ,"B - Using location provider"
                    ,"C - A & B"
            },
            {"A - To find the last location of a phone"
                    ,"B - To find known location of a phone"
                    ,"C - To find the last known location of a phone."
            },
            {"A - httprequest(get/post) and returns response from the server","B - Cookies management","C - Authentication management"},
            {"A - onReceive()" ,"B - onCreate()","C - onAttach()->onCreate() −> onCreateView() −> onActivityCreated() −> onStart() −> onResume()"},
            {"A - To create an activity","B - To create a graphical window for subclass","C - It allows the developers to write the program"}

    };


    private String mCorrectAnswers[] = {"C - A & B", "C - Main Thread", "C - A & B", "C - A & B","C - A & B","C - To find the last known location of a phone.","A - httprequest(get/post) and returns response from the server","C - onAttach()->onCreate() −> onCreateView() −> onActivityCreated() −> onStart() −> onResume()","B - To create a graphical window for subclass"};


    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

    public int getLength() {
        return mQuestions.length;
    }
}
