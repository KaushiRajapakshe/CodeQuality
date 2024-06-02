import Control.Size;
import Service.FileReader;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SizeTest2 {
    private String filepath;
    private ArrayList<Integer> no=new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        filepath="01.txt";
        no.add(0);
        no.add(0);
        no.add(0);
        no.add(0);
        no.add(0);
        no.add(0);
        no.add(0);
        no.add(0);
        no.add(0);
        no.add(3);
        no.add(0);
        no.add(0);
        no.add(0);
    }

    @Test
    public void num() {
        ArrayList<Integer> noGet=new Size(new FileReader(this.filepath)).getLineNoCount();

        for(int i=0;i<noGet.size();i++){
            assertEquals("not same line "+i,no.get(i),noGet.get(i));
        }
    }

}