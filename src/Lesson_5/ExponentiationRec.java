package Lesson_5;

public class ExponentiationRec {

    private float source;
    private float exponent;
    private float target;


    float exponentiationRec(float source, float exponent) {
//допилить 0^n
        if (exponent == 0) {
            target = 1;
        } else if (exponent < 0) {
//            ++exponent;
            target = 1/(source * exponentiationRec(source, -exponent-1));
        } else {
//            --exponent;
            target = source * exponentiationRec(source, exponent-1);
        } return target;
    }
}
