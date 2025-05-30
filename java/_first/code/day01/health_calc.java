package day01;
import java.util.Scanner;
import java.util.InputMismatchException;

public class health_calc {

    private static final double BMI_UNDERWEIGHT_THRESHOLD = 18.5;
    private static final double BMI_NORMAL_THRESHOLD = 24.9;
    private static final double BMI_OVERWEIGHT_THRESHOLD = 29.9;

    private static final double BMR_MALE_CONSTANT = 66;
    private static final double BMR_FEMALE_CONSTANT = 655;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("请输入年龄：");
            int age = sc.nextInt();
            System.out.println("请输入身高（单位：米）：");
            double height = sc.nextDouble();
            System.out.println("请输入体重（单位：千克）：");
            double weight = sc.nextDouble();
            System.out.println("请输入性别（1代表男，2代表女）：");
            int sex = sc.nextInt();

            double bmi = getBMI(weight, height);
            double bmr = getBMR(age, height, weight, sex);

            printBMISuggestion(bmi);
            printBMRsuggestion(bmr);
        } catch (InputMismatchException e) {
            System.out.println("输入错误，请输入数字！");
        } finally {
            sc.close();
        }
    }

    public static double getBMI(double weight, double height) {
        return weight / (height * height);
    }

    public static double getBMR(int age, double height, double weight, int sex) {
        if (sex == 1) {
            return BMR_MALE_CONSTANT + (13.7 * weight) + (5 * height * 100) - (6.8 * age);
        } else {
            return BMR_FEMALE_CONSTANT + (9.6 * weight) + (1.8 * height * 100) - (4.7 * age);
        }
    }

    public static void printBMISuggestion(double bmi) {
        if (bmi < BMI_UNDERWEIGHT_THRESHOLD) {
            System.out.println("您的BMI指数为：" + bmi + "，您的体重过轻。建议增加蛋白质和健康脂肪的摄入，并适当锻炼增肌。");
        } else if (bmi >= BMI_UNDERWEIGHT_THRESHOLD && bmi < BMI_NORMAL_THRESHOLD) {
            System.out.println("您的BMI指数为：" + bmi + "，您的体重正常，继续保持。");
        } else if (bmi >= BMI_NORMAL_THRESHOLD && bmi < BMI_OVERWEIGHT_THRESHOLD) {
            System.out.println("您的BMI指数为：" + bmi + "，您的体重过重，请考虑减肥。");
        }
    }

    /**
     * 根据基础代谢率（BMR）提供健康建议
     * 该方法根据计算出的BMR值，给出用户是否需要增加运动量的建议
     * 
     * @param bmr 基础代谢率，单位为卡路里
     */
    public static void printBMRsuggestion(double bmr) {
        // 当BMR值小于1000卡路里时，建议用户增加运动量
        if (bmr < 1000) {
            System.out.println("您的BMR指数为：" + bmr + "，您需要运动，请保持活动水平。");
        } else {
            // 当BMR值不低于1000卡路里时，认为用户当前的生活方式是健康的
            System.out.println("您的BMR指数为：" + bmr + "，您不需要运动，请保持当前 lifestyle。");
        }
    }
}