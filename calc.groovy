import org.apache.tools.ant.filters.TokenFilter
import static java.lang.System.*;

class Calc {
        double x, y;
        static double sum(double x, double y) {
            x + y;
        }


       static double min(double x) {
           x - x;
       }

        static double min(double x, double y) {
            x - y;
        }





        static double mul(double x, double y) {
            x * y;
        }

        static double div(double x, double y) {
            x / y;
        }

        static double pow(double x, double y) {
            x**y
        }
        static double init_var1(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter first number:");
            double x = sc.nextDouble();
            return x;

        }
        static double init_var2(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter second number:");
            double y = sc.nextDouble();
            return y;
        }
        static List<String> check_for_brek(List<String> result){
            String tmp_str=""
            for(int i=0;i<result.size();i++) {
                if (result[i] == "(") {
                    int j = i
                    i++
                    while (result[i] != ')') {
                        tmp_str += (result[i])
                        result.remove(i)
                    }
                    result.remove(i)
                    tmp_str = parse_string(tmp_str)
                    System.out.println(tmp_str)
                    tmp_str = tmp_str.replace("[", "")
                    tmp_str = tmp_str.replace("]", "")
                    result.set(j, tmp_str)

                }
            }
        return result
        }
        static List<String> check_for_mult(List<String> result){
            for(int i=0;i<result.size();i++) {
                if (result[i] == '*') {
                    result.set(i - 1, Double.toString(Double.parseDouble(result[i - 1]) * Double.parseDouble(result[i + 1])))
                    result.remove(i + 1)
                    result.remove(i)
                    i = 0;

                }
            }
        return result
        }
        static List<String> check_for_div(List<String> result){
            for(int i=0;i<result.size();i++) {
                if (result[i] == '/') {
                    result.set(i - 1, (Double.toString((Double.parseDouble(result[i - 1]) / (Double.parseDouble(result[i + 1]))))))
                    result.remove(i + 1)
                    result.remove(i)
                    i = 0

                }
            }
        return result
        }
        static List<String> check_for_sum(List<String> result){
            for(int i=0;i<result.size();i++) {
                if (result[i] == '+') {
                    result.set(i - 1, (Double.toString((Double.parseDouble(result[i - 1])) + (Double.parseDouble(result[i + 1])))))
                    result.remove(i + 1)
                    result.remove(i)
                    i = 0

                }
            }
        return result
        }
        static List<String> check_for_sub(List<String> result){
                for(int i=0;i<result.size();i++) {
                    if (result[i] == '-') {
                        result.set(i - 1, (Double.toString((Double.parseDouble(result[i - 1])) - (Double.parseDouble(result[i + 1])))))
                        result.remove(i + 1)
                        result.remove(i)
                        i = 0

                    }
                }

        return result
        }

       static String parse_string(String x){

                List<String> result = new ArrayList<String>(Arrays.asList(x.split("(?<=[-+*/()])|(?=[-+*/()])")));

                    check_for_brek(result);
                    check_for_mult(result);
                    check_for_div(result);
                    check_for_sum(result);
                    check_for_sub(result);


                return result
               }
           }


   String hello="Hello,this is calculator!";
   System.out.println(hello);

   def a = {int z = 2,int w = 2 ->
       println  "${z} plus ${w} is ?"
   }

   System.out.println("1-Simple calculator\n2-Expression")
   Scanner t = new Scanner(System.in)
   int ch = t.nextInt()
   if( ch == 1 ) {
       Scanner sc = new Scanner(System.in)
       x = 0; y = 0;
       choice = 0;
       while (true) {
           double x = Calc.init_var1();
           choice = 0;
           while (choice != 6) {

               System.out.println("Select the action to select enter number.\n1-Addition\n2-Substraction\n3-Multiplication\n4-Division\n5-Exponentiation\n6-Clear\n7-Expression\n0-Exit")
               choice = sc.nextInt();
               if (choice == 6) break;
               if (choice == 0) {
                   System.exit(0)
               }
               double y = Calc.init_var2();
               switch (choice) {
                   case 1: x = Calc.sum(x, y); System.out.println("Result is: " + x); break;
                   case 2: x = Calc.min(x, y); System.out.println("Result is: " + x); break;
                   case 3: x = Calc.mul(x, y); System.out.println("Result is: " + x); break;
                   case 4: x = Calc.div(x, y); System.out.println("Result is: " + x); break;
                   case 5: x = Calc.pow(x, y); System.out.println("Result is: " + x); break;
                   case 6: break;
                   case 0: System.exit(0);
                   default: System.out.println("You must enter an integer"); break;
               }

           }
       }
   }
   else if( ch == 2 ) {
       System.out.println("Enter your expression");
       Scanner sc = new Scanner(System.in);
       String expr = sc.nextLine();
       System.out.println(Calc.parse_string(expr))

   }
   else {
       System.out.println("Eto fiasko bratan")
   }
