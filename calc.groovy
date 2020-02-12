import org.apache.tools.ant.filters.TokenFilter
import static java.lang.System.*;

class Calc {

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
                result = result.replace("[", "")
                result = result.replace("]", "")

            return result
            }
}


    String hello="Hello,this is calculator!";
    println hello

    def a = {int z = 2,int w = 2 ->
        println  "${z} plus ${w} is ?"
    }

    println "Enter your expression"
    Scanner sc = new Scanner(System.in);
    String expr = sc.nextLine();
    println Calc.parse_string(expr)

   
