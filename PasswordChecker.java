public class PasswordChecker{

    private int minLength = 0;
    private int maxSameLength = 0;

    public void setMinLenght(int length) throws IllegalArgumentException {
        if (length <= 0){
            throw new IllegalArgumentException("Минимальная длина не соотвествует требованию, вы указали: " + length);
        }
        this.minLength = length;
    }

    public void setMaxLength(int length) throws IllegalArgumentException {
        if (length <= 0){
            throw new IllegalArgumentException("Максимальная длина одних симловов не соотвествует требованию, вы указали: " + length);
        }
        this.maxSameLength = length;
    }

    public int getMinLength(){
        return minLength;
    }
    public  int getMaxLength(){
        return maxSameLength;
    }

    private int MaxSame(String password){
        int counter = 1;
        int max = 1;
        String[] passArray = password.split("");
        for (int i = 0; i < passArray.length - 1; i++){
            if (passArray[i].equals(passArray[i+1])){
                counter++;
                if (counter > max) {
                    max = counter;
                }
            }
            else {
                counter = 1;
            }
        }
        return max;
    }

    public boolean verify(String password){
        if (maxSameLength == 0 || minLength == 0){
            throw new IllegalStateException("Не задан один из чекеров");
        }
        if (password.length() >= minLength && MaxSame(password) <= maxSameLength){
            return true;
        } else {
            return false;
        }
    }

}
