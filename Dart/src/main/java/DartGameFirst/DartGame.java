package DartGameFirst;

public class DartGame {
    private int firstPlayerPoints = 501;

    private int secondPlayerPoints = 501;

    public void shoot(int value, int multiplicity, int player) {
        validate(value,multiplicity);
        if (player == 1) {
            firstPlayerPoints = countPoints(value, multiplicity, firstPlayerPoints);
            if(checkWin(firstPlayerPoints)){
                System.out.println("FIRST PLAYER IS THE WINNER");
            }
        } else {
            secondPlayerPoints = countPoints(value, multiplicity, secondPlayerPoints);
            if(checkWin(firstPlayerPoints)){
                System.out.println("SECOND PLAYER IS THE WINNER");
            }
        }
    }

    public int countPoints(int value, int multiplicity, int points) {
        points =  points - value * multiplicity;

        if(points == 0 ){
            return 1000;
        }else if(points < 0){
            return points + value * multiplicity;
        }
        return points;
    }
    private boolean checkWin(int points){
        if(points == 1000){
            return true;
        }
        return false;
    }
    public void validate(int value,int multiplicity)throws IllegalArgumentException{
        if(value > 20 && value != 50 && value != 25){
            throw new IllegalArgumentException("Value is invalid");
        }
        if(multiplicity != 2 && multiplicity != 1 && multiplicity !=3){
            throw new IllegalArgumentException("Multiplicity is invalid");
        }
    }


    public int getFirstPlayerPoints() {
        return firstPlayerPoints;
    }

    public void setFirstPlayerPoints(int firstPlayerPoints) {
        this.firstPlayerPoints = firstPlayerPoints;
    }

    public int getSecondPlayerPoints() {
        return secondPlayerPoints;
    }

    public void setSecondPlayerPoints(int secondPlayerPoints) {
        this.secondPlayerPoints = secondPlayerPoints;
    }
}
