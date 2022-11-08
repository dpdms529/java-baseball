package baseball;

import java.util.List;

public class Game {
    private ProblemMaker problemMaker = new ProblemMaker();
    private ProblemSolver problemSolver = new ProblemSolver();
    private Result result = new Result();
    private int status = Settings.START_STATUS;

    public void start(){
        while(isStartStatus()){
            result.initialize();
            problemMaker.makeProblem(Settings.SIZE_OF_NUMBERS);
            printlnMessage(Settings.START_MESSAGE);
            while(result.isWrongAnswer()){
                requestAnswer();
                checkAnswer();
            }
            printlnMessage(Settings.SUCCESS_MESSAGE);
            setStatusByProblemSolver();
        }

    }

    public void printMessage(String message){
        System.out.print(message);
    }

    public void printlnMessage(String message){
        System.out.println(message);
    }

    public boolean isStartStatus(){
        return status == Settings.START_STATUS;
    }

    public void requestAnswer(){
        printMessage(Settings.ANSWER_REQUEST_MESSAGE);
        problemSolver.solveProblem(Settings.SIZE_OF_NUMBERS);
    }

    public void checkAnswer(){
        result.initialize();
        countResult();
        printlnMessage(result.createResultMessage());
    }

    public void countResult(){
        List<Integer> numbers = problemSolver.getNumbers();
        for(int i = 0;i<Settings.SIZE_OF_NUMBERS;i++){
            int number = numbers.get(i);

            if(problemMaker.isSameAtGivenLocation(number, i)){
                result.increaseStrikeCount();
            }else if(problemMaker.hasNumber(number)){
                result.increaseBallCount();
            }
        }

    }

    public void setStatusByProblemSolver(){
        printlnMessage(Settings.RESTART_REQUEST_MESSAGE);
        status = problemSolver.chooseToRestart();
    }

    public Player getProblemMaker() {
        return problemMaker;
    }

    public void setProblemMaker(ProblemMaker problemMaker) {
        this.problemMaker = problemMaker;
    }

    public Player getProblemSolver() {
        return problemSolver;
    }

    public void setProblemSolver(ProblemSolver problemSolver) {
        this.problemSolver = problemSolver;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
