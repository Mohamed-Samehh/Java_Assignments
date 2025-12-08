public class ExceptionThrower {
    
    // Method 1
    public void checkAge(int age) throws MyException {
        if (age < 18) {
            throw new MyException("Age must be 18 or above!");
        }
    }
    
    // Method 2
    public void checkName(String name) throws MyException {
        if (name == null || name.isEmpty()) {
            throw new MyException("Name cannot be empty!");
        }
    }
    
    // Method 3
    public void checkScore(int score) throws MyException {
        if (score < 0 || score > 100) {
            throw new MyException("Score must be between 0 and 100!");
        }
    }
}