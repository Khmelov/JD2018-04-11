package projects.Home;

import org.junit.Test;

import java.util.LinkedList;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class SPSTest {

    @Test(timeout = 5000)
    public void timeSearch() {
        LinkedList<String> list = new LinkedList<>();
        list.addLast("8:00 9:00");
        Pattern pattern = Pattern.compile("^(([0,1]?[0-9]|(2[0-3]))(:[0-5][0-9]))$");
        int[][][] actual = SPS.timeSearch(pattern, 1, list);
        int[][][] expected = new int[1][2][2];
        expected[0][0][0]=8;
        expected[0][0][1]=0;
        expected[0][1][0]=9;
        expected[0][1][1]=0;
        assertEquals(expected,actual);
    }
    @Test(timeout = 5000)
    public void maxPeople() {
        int[][][] masTime = new int[3][2][2];
        masTime[0][0][0]=8;
        masTime[0][0][1]=0;
        masTime[0][1][0]=9;
        masTime[0][1][1]=0;
        masTime[1][0][0]=8;
        masTime[1][0][1]=30;
        masTime[1][1][0]=8;
        masTime[1][1][1]=59;
        masTime[2][0][0]=9;
        masTime[2][0][1]=30;
        masTime[2][1][0]=9;
        masTime[2][1][1]=59;
        int expected=2;
        int actual = Counting.maxPeople(masTime);
        assertEquals(expected,actual);

    }
}