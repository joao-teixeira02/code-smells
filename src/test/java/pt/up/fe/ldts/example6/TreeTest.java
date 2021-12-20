package pt.up.fe.ldts.example6;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TreeTest {
    public Tree tree;
    public Location treeLocation;
    public Date date;

    @BeforeEach
    public void setUp() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        date = sdf.parse("31-08-2002 10:20:56");
        treeLocation = new Location(date, "41.177772696363114", "-8.59843522310257", "FEUP");
        tree = new Tree();
    }

    @Test
    public void testTreeCreation() {
        Assertions.assertEquals(treeLocation.plantedAt, date);
        Assertions.assertEquals(treeLocation.locationLatitude, "41.177772696363114");
        Assertions.assertEquals(treeLocation.locationLongitude, "-8.59843522310257");
        Assertions.assertEquals(treeLocation.locationName, "FEUP");
    }

    @Test
    public void testTreeSetLocation() {
        treeLocation.setLocation("loclat", "loclon", "locname");
        Assertions.assertEquals(treeLocation.plantedAt, date);
        Assertions.assertEquals(treeLocation.locationLatitude, "loclat");
        Assertions.assertEquals(treeLocation.locationLongitude, "loclon");
        Assertions.assertEquals(treeLocation.locationName, "locname");
    }

    @Test
    public void testToString() {
        String result = treeLocation.toString();
        Assertions.assertEquals("Tree planted at Sat Aug 31 10:20:56 WEST 2002 in location 41.177772696363114,-8.59843522310257 (FEUP)", result);
    }

    @Test
    public void testAddAppraisal() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date appraisalDate = sdf.parse("31-08-2002 10:20:56");

        Assertions.assertEquals(tree.getAppraisals().size(), 0);
        tree.addAppraisal(appraisalDate);
        Assertions.assertEquals(tree.getAppraisals().size(), 1);
    }

    @Test
    public void testNextAppraisalOverdue() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -6);
        Date appraisalDate = calendar.getTime();

        Assertions.assertFalse(tree.isNextAppraisalOverdue());
        tree.addAppraisal(appraisalDate);
        Assertions.assertTrue(tree.isNextAppraisalOverdue());
    }

    @Test
    public void testNextAppraisalNotOverdue() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        Date appraisalDate = calendar.getTime();

        Assertions.assertFalse(tree.isNextAppraisalOverdue());
        tree.addAppraisal(appraisalDate);
        Assertions.assertFalse(tree.isNextAppraisalOverdue());
    }

}