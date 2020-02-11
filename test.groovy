import org.junit.Assert
import org.junit.Test


class CalcTest {
    @Test
    void testEmptyAddEqualsZero() {
        assert Calc.add("") == 0
    }

    @Test
    void testSingleArgumentAsIs() {
        assert Calc.add("1") == 1
    }

    @Test
    void testAddTwoArguments() {
        assert Calc.add("1,2") == 3
    }

    @Test
    void testNewlinesAsDelimiter() {
        assert Calc.add("1\n2") == 3
    }

    @Test
    void testCustomDelimiter() {
        assert Calc.add("//x\n1x2") == 3
    }

    @Test
    void testIgnoreNumbersBiggerThanThousand() {
        assert Calc.add("1,1001") == 1
    }

    @Test
    void testCustomDelimiterWithLengthTwo() {
        assert Calc.add("//[xx]\n1xx2") == 3
    }

    @Test
    void testMultipleCustomDelimitersWithLengthTwo() {
        assert Calc.add("//[xx][yy]\n1xx2yy3") == 6
    }

    @Test
    void testExceptionOnNegativeNumbers() {
        try {
            Calc.add("-1,-2")
            Assert.fail()
        } catch (Exception e) {
            assert e.getMessage().equals("Negatives not supported (-1,-2)")
        }
    }
}